package com.edigiseva.service;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.http.ResponseEntity;

import com.edigiseva.message.request.DigiSevaResponseEntity;
import com.edigiseva.model.UserJson;
import com.edigiseva.model.Users;

public interface UserService {

	Users findByEmailId(String email);

	ResponseEntity<DigiSevaResponseEntity> updatePassword(String request);

	Optional<Users> findById(Long user_id);

	ResponseEntity<DigiSevaResponseEntity> createNewUser(UserJson user, Long udid, String email, Long mobileNo,
			String password);

	ResponseEntity<DigiSevaResponseEntity> forgotPassword(String request) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException;

	Users findByMobileNo(Long mobileNo);

}
