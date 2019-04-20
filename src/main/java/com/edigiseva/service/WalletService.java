package com.edigiseva.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edigiseva.model.Wallet;

public interface WalletService {

	
	@Query("SELECT w FROM Wallet w WHERE w.isActi1ve =:true and w.user.id=:userID")
	public List<Wallet> findByUser(@Param("userID") Long userID);
	
	
	public boolean addMoneyTowallet(BigDecimal amount,Long userID);

}
