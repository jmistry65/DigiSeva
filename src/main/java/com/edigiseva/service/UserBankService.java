package com.edigiseva.service;

import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;
import javax.validation.Valid;

import com.edigiseva.message.request.ECollectionVO;
import com.edigiseva.message.request.UserBankRequest;
import com.edigiseva.model.UserBank;

public interface UserBankService {

	UserBank createBankUser(@Valid UserBankRequest request) throws NoSuchAlgorithmException, NoSuchPaddingException, Exception;

	UserBank userBankLogin();

	ECollectionVO saveECollectionInfo(String userName, String password, ECollectionVO eCollections);
}
