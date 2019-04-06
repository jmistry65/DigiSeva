package com.edigiseva.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edigiseva.model.Wallet;

public interface WalletService {

	
	@Query("SELECT w FROM Wallet w WHERE w.isActive = :true and b.user.id:=userID")
	public List<Wallet> findByUser(@Param("userID") Long userID);
	
	@Query("UPDATE Wallet set amount = :amount WHERE w.isActive = :true and b.user.id:=userID")
	public boolean addMoneyTowallet(@Param("amount") BigDecimal amount, @Param("userID") Long userID);

}
