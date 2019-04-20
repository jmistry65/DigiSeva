package com.edigiseva.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edigiseva.model.Users;
import com.edigiseva.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

	List<Wallet> findByUser(Users user);
	
	@Query("UPDATE Wallet w set w.amount =:amount WHERE w.isActive =:true and w.user.id=:userID")
	public boolean addMoneyTowallet(@Param("amount") BigDecimal amount, @Param("userID") Long userID);
}
