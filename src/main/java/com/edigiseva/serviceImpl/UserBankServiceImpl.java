package com.edigiseva.serviceImpl;

import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigiseva.message.request.UserBankRequest;
import com.edigiseva.model.UserBank;
import com.edigiseva.repository.UserBankRepository;
import com.edigiseva.securedata.AsymmetricCryptography;
import com.edigiseva.service.UserBankService;

@Service
public class UserBankServiceImpl implements UserBankService {

	@Autowired
	private UserBankRepository userBankRepo;


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
}
