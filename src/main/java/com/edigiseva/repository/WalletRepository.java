package com.edigiseva.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edigiseva.model.Users;
import com.edigiseva.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

	List<Wallet> findByUser(Users user);
	
	public boolean addMoneyTowallet(BigDecimal amount,Long userID);
}
