package com.edigiseva.service;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;

import com.edigiseva.message.request.UserBankRequest;
import com.edigiseva.model.UserBank;
import com.edigiseva.model.VirtualAccountNumberVerificationIN;

public interface UserBankService {

	UserBank createBankUser(@Valid UserBankRequest request) throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;

	UserBank userBankLogin();

	VirtualAccountNumberVerificationIN saveECollectionInfo(String userName, String password,
			VirtualAccountNumberVerificationIN eCollections);
}
