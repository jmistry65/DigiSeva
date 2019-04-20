package com.edigiseva.serviceImpl;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigiseva.message.request.UserBankRequest;
import com.edigiseva.model.UserBank;
import com.edigiseva.model.Users;
import com.edigiseva.model.VirtualAccountNumberVerificationIN;
import com.edigiseva.repository.UserBankRepository;
import com.edigiseva.repository.UserRepository;
import com.edigiseva.securedata.AsymmetricCryptography;
import com.edigiseva.service.UserBankService;

@Service
public class UserBankServiceImpl implements UserBankService {

	@Autowired
	private UserBankRepository userBankRepo;
	
	@Autowired
	private UserRepository userRepo;

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
	public VirtualAccountNumberVerificationIN saveECollectionInfo(String userName, String password, VirtualAccountNumberVerificationIN eCollections) {
		
		// TODO : move all to seprate methods 
		String virtualAcNo = eCollections.getVirtualAccountNumber();
		virtualAcNo = virtualAcNo.replaceAll("LINK", ""); 
		VirtualAccountNumberVerificationIN virtualAccountNumberVerificationIN = eCollections;
		
		if(eCollections.equals(null)) { 
			eCollections.setRejectReason("Invalid data ,No Data found");
			eCollections.setStatus(VirtualAccountNumberVerificationIN.STATUS_REJECT);
			return eCollections;
		}
		if(!validateCredentials(userName, password)) {
			virtualAccountNumberVerificationIN.setRejectReason("Invalid credentials, Invalida username or password");
			virtualAccountNumberVerificationIN.setStatus(VirtualAccountNumberVerificationIN.STATUS_REJECT);
			return virtualAccountNumberVerificationIN;
		}
		
		if(!validateVirtualAccountNo(virtualAcNo)) {
			virtualAccountNumberVerificationIN.setRejectReason("Invalid virtual account no");
			virtualAccountNumberVerificationIN.setStatus(VirtualAccountNumberVerificationIN.STATUS_ACCEPT);
			return virtualAccountNumberVerificationIN;
		}
		
		virtualAccountNumberVerificationIN.setRejectReason(null);
		virtualAccountNumberVerificationIN.setStatus(VirtualAccountNumberVerificationIN.STATUS_ACCEPT);
		return virtualAccountNumberVerificationIN;
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
	
	private boolean validateVirtualAccountNo(String virtualAcNo) {
		boolean response = false;
		Optional<Users> user = userRepo.findByMobileNo(Long.parseLong(virtualAcNo));
		if(user.isPresent() && user.get().getMobileNo() == Long.parseLong(virtualAcNo)) {
			response = true;
		}
		return response;
	}
}
