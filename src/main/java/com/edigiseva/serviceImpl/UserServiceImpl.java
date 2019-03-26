package com.edigiseva.serviceImpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.mail.MessagingException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edigiseva.message.request.DigiSevaResponseEntity;
import com.edigiseva.model.Role;
import com.edigiseva.model.RoleName;
import com.edigiseva.model.UserJson;
import com.edigiseva.model.Users;
import com.edigiseva.repository.RoleRepository;
import com.edigiseva.repository.UserRepository;
import com.edigiseva.service.UserService;
import com.edigiseva.utils.Utilities;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public Users findByEmailId(String email) {
		Optional<Users> user = userRepo.findByEmail(email);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@Override
	public ResponseEntity<DigiSevaResponseEntity> updatePassword(String request) {
		JSONObject reqObject = new JSONObject(request);
		String email = reqObject.getString("email");
		String oldPassword = reqObject.getString("oldPassword");
		String newPassword = reqObject.getString("newPassword");
		Optional<Users> user = userRepo.findByEmail(email);
		if(!user.isPresent()) {
			return Utilities.createResponse(true, "No user exist with "+email, HttpStatus.NOT_FOUND, "");
		}
		if(!oldPassword.equals(user.get().getPassword())) {
			return Utilities.createResponse(true, "Please enter valid old password", HttpStatus.CONFLICT, "");
		}
		user.get().setPassword(newPassword);
		userRepo.save(user.get());
		return Utilities.createResponse(true, "Password updated successfully", HttpStatus.CONFLICT, "");
	}

	@Override
	public Optional<Users> findById(Long user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<DigiSevaResponseEntity> createNewUser(UserJson userJson, Long udid, String email, Long mobileNo,
			String password) {
		 Optional<Role> userRole = roleRepo.findByName(RoleName.ROLE_USER);

		Users user = new Users(udid, userJson.getName(), email, mobileNo, userJson.getGender(), new Date(userJson.getDateOfBirth()), password,Collections.singleton(userRole.get()));
		return null;
	}

	@Override
	public ResponseEntity<DigiSevaResponseEntity> forgotPassword(String request) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException{
		JSONObject reqObject = new JSONObject(request);
		String email = reqObject.getString("email");
		Users user = findByEmailId(email);
		if(null == user) {
			return Utilities.createResponse(true, "No user exist with this email", HttpStatus.CONFLICT, "");
		}
		try {
			String newPassword = Utilities.generateRendomPassword();
			Utilities.sendmail(email,newPassword);
			user.setPassword(newPassword);
			userRepo.save(user);
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
		return Utilities.createResponse(false, "Mail sent", HttpStatus.OK, "");

	}

	@Override
	public Users findByMobileNo(Long mobileNo) {
		Optional<Users> user = userRepo.findByMobileNo(mobileNo);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

	
}
