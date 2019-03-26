package com.edigiseva.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edigiseva.model.Bank;
import com.edigiseva.model.UserBank;
import com.edigiseva.model.Users;

public interface UserBankRepository extends JpaRepository<UserBank, Long>{
	List<UserBank> findByUserName(String userName);
}
