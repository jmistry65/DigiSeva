package com.edigiseva.serviceImpl;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigiseva.message.request.ECollectionVO;
import com.edigiseva.message.request.UserBankRequest;
import com.edigiseva.model.ECollection;
import com.edigiseva.model.UserBank;
import com.edigiseva.repository.UserBankRepository;
import com.edigiseva.securedata.AsymmetricCryptography;
import com.edigiseva.service.UserBankService;

@Service
public class UserBankServiceImpl implements UserBankService {

	@Autowired
	private UserBankRepository userBankRepo;

	private static final Logger log = Logger.getLogger(UserBankServiceImpl.class.getName());
	
	@Override
	public UserBank createBankUser(@Valid UserBankRequest request) throws Exception {
		List<UserBank> userBankList = userBankRepo.findByUserName(request.getUserName());
		if(userBankList.isEmpty()) {
			UserBank userBank = new UserBank();
			userBank.setUserName(request.getUserName());
			userBank.setBankName(request.getBankName());
			AsymmetricCryptography ac = new AsymmetricCryptography();
			PrivateKey privateKey = ac.getPrivate("KeyPair/privateKey");
			PublicKey publicKey = ac.getPublic("KeyPair/publicKey");
			userBank.setPassword(ac.encryptText("ICICI@pwd01", publicKey));
			userBank.setPublicKey(publicKey.toString());
			userBank.setPrivateKey(privateKey.toString());
			return userBankRepo.save(userBank);
		}
		return null;
	}
	
	@Override
	public UserBank userBankLogin() {
		return null;
	}

	@Override
	public ECollectionVO saveECollectionInfo(String userName, String password, ECollectionVO eCollections) {
		
		// TODO : move all to seprate methods 
		
		if(!validateCredentials(userName, password)) {
			
			List<ECollection> collections = new ArrayList<>();
			collections.add(new ECollection(null, null, null, null, null, null,null, new Date(), null, "Invalid credentials, Invalida username or password", ECollection.STATUS_REJECT));
			
			return new ECollectionVO(collections);
		}
		
		if(eCollections == null || (eCollections.geteCollections() == null)) { 
			List<ECollection> collections = new ArrayList<>();
			collections.add(new ECollection(null, null, null, null, null, null,null, new Date(), null, "Invalid data ,No Data found", ECollection.STATUS_REJECT));
			
			return new ECollectionVO(collections);
		}
		
		List<ECollection> eCollectionResponse =  eCollections.geteCollections().stream().map(e -> { 
			
			log.info(e.toString()+System.lineSeparator()); // print data 
			
			return new ECollection(e.getClientCode(), e.getVirtulaAccNo(), e.getTrxAmount(), e.getUrtNo(), e.getSenderIFSCCode(), null,
					"NULL", new Date(), null, null, ECollection.STATUS_ACCEPT);
		}
		).collect(Collectors.toList());
	
		return new ECollectionVO(eCollectionResponse);
	}
	
	private boolean validateCredentials(String userName, String password){
		
		boolean response = false;
		List<UserBank> userBank = userBankRepo.findByUserName(userName);
		
		if(userBank == null || userBank.isEmpty()) {
			log.warning("No details found with username:"+userName+" timestamp:"+new Date());
		} else {
			if(userBank.get(0).getPassword().equalsIgnoreCase(password))  // TODO : getting the 1st result only , will the user have many to one relation here ?
				response = true;
		}
		
		return response;
	}
}
