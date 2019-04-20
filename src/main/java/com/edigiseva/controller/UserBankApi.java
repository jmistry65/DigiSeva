package com.edigiseva.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigiseva.message.request.BankRequest;
import com.edigiseva.message.request.DigiSevaResponseEntity;
import com.edigiseva.model.Bank;
import com.edigiseva.model.Users;
import com.edigiseva.model.VirtualAccountNumberVerificationIN;
import com.edigiseva.service.BankService;
import com.edigiseva.service.UserBankService;
import com.edigiseva.service.UserService;
import com.edigiseva.utils.Utilities;
import com.fasterxml.jackson.core.JsonProcessingException;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/user/bank")
public class UserBankApi {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BankService bankService;
	
	@Autowired
	private UserBankService userBankServce;
	
	@PostMapping("/createbankuser")
	public ResponseEntity<DigiSevaResponseEntity> createBankUser(@Valid @RequestBody BankRequest request) throws JsonProcessingException{
		Optional<Users> user = userService.findById(request.getUser_id());
		if(!user.isPresent()){
			return Utilities.createResponse(true, "User does not exist", HttpStatus.CONFLICT, "");
		}
		Bank bank = bankService.setUserBank(request,user.get());
		return Utilities.createResponse(false, "Bank data saved successfully", HttpStatus.CREATED, bank);
		
	}
	
	@PostMapping("/icicibankuat")
	public ResponseEntity<?> saveECollectionInfo(@RequestHeader(name="username",required=true) String userName , @RequestHeader(name="password",required=true) String password ,
											@RequestBody VirtualAccountNumberVerificationIN eCollections){
		
		return new ResponseEntity<>(userBankServce.saveECollectionInfo(userName,password,eCollections),HttpStatus.OK); // TODO : Change HTTP Sstatus and model as well 
	}
}
