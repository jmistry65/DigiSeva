package com.edigiseva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigiseva.message.request.DigiSevaResponseEntity;
import com.edigiseva.model.Wallet;
import com.edigiseva.service.WalletService;
import com.edigiseva.utils.Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/wallet")
public class WalletAPIs {
	
	
	@Autowired
	private WalletService walletService;
	
	@PostMapping("/getuserwallet")
	public ResponseEntity<DigiSevaResponseEntity> getUserWallet(@RequestBody Long userID) throws JsonProcessingException{
		List<Wallet> wallet = walletService.findByUser(userID);
		return Utilities.createResponse(false, "Bank data saved successfully", HttpStatus.CREATED, wallet);
		
	}
}
