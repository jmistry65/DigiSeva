package com.edigiseva.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edigiseva.message.request.BankRequest;
import com.edigiseva.model.Bank;
import com.edigiseva.model.Users;
import com.edigiseva.model.Wallet;

public interface WalletService {

	
	@Query("SELECT w FROM Wallet w WHERE w.isActive = :true and b.user.id:=userID")
	public List<Wallet> findByUser(@Param("userID") Long userID);

}
