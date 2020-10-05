package com.capgemini.pecunia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.service.AccountServiceImpl;

@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

	@Autowired
	private AccountServiceImpl service;
	
	
	
	@PostMapping("/addAccount")
	public Account addAccount(@RequestBody Account account) {
		return service.saveAccount(account);
		//return service.saveCustomer(customer);
	}
	
	
	@GetMapping("/accounts")
	public List<Account> findAllAccounts(){
		return service.getAccounts();
	}
	@GetMapping("/accounts/{accountNumber}")
	public Account findById(@PathVariable long accountNumber){
		return service.getAccountById(accountNumber);
	}
	
	@PutMapping("/updateAccount")
	public Account updateAccount(@RequestBody Account account) {
		return service.updateAccount(account);
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	@CrossOrigin(origins="http://localhost:4200")
	public String deleteAccount(@PathVariable long accountNumber) {
		return service.deleteAccount(accountNumber);
	}
	
}