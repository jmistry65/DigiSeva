package com.edigiseva.service;

public interface OTPService {

	int generateOTP(String username);

	void clearOTP(String username);

	int getOtp(String username);

	
}
