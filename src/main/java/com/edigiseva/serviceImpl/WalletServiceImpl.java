package com.edigiseva.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edigiseva.message.request.BankRequest;
import com.edigiseva.model.Bank;
import com.edigiseva.model.Users;
import com.edigiseva.model.Wallet;
import com.edigiseva.repository.BankRepository;
import com.edigiseva.repository.UserRepository;
import com.edigiseva.repository.WalletRepository;
import com.edigiseva.service.BankService;
import com.edigiseva.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {


	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private WalletRepository walletRepo;


	@Override
	public List<Wallet> findByUser(Long userID) {
		Optional<Users> userData = userRepo.findById(userID);
		List<Wallet> walletList = new ArrayList<Wallet>();
		if (userData.isPresent()) {
			walletList = walletRepo.findByUser(userData.get());
		}
		return walletList;
	}

}
