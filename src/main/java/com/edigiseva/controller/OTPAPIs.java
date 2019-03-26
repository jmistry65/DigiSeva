package com.edigiseva.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edigiseva.message.request.DigiSevaResponseEntity;
import com.edigiseva.model.Users;
import com.edigiseva.service.OTPService;
import com.edigiseva.service.UserService;
import com.edigiseva.utils.Utilities;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/otp")
public class OTPAPIs {

	@Autowired
	private  OTPService otpService;
	
	@Autowired
	private UserService userService;

	@GetMapping("/generateOtp")
	public String generateOtp() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		int otp = otpService.generateOTP(username);

		return String.valueOf(otp);
	}

	@PostMapping(value = "/validateOtp")
	public ResponseEntity<DigiSevaResponseEntity> updatePassword(@RequestBody int request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		JSONObject reqObject = new JSONObject(request);
		Long mobileNo = reqObject.getLong("mobileNo");
		Long otp = reqObject.getLong("otp");
		Users user =  userService.findByMobileNo(mobileNo);
		// Validate the Otp
		if (otp >= 0) {
			int serverOtp = otpService.getOtp(user.getMobileNo().toString());
			if (serverOtp > 0) {
				if (otp == serverOtp) {
					otpService.clearOTP(user.getMobileNo().toString());
					return Utilities.createResponse(false, "OTP is valid", HttpStatus.OK, "");
				} else {
					return Utilities.createResponse(false, "OTP is valid", HttpStatus.OK, "");
				}
			} else {
				return Utilities.createResponse(true, "OTP is invalid", HttpStatus.OK, "");
			}
		} else {
			return Utilities.createResponse(true, "OTP is invalid", HttpStatus.OK, "");
		}
	}
}
