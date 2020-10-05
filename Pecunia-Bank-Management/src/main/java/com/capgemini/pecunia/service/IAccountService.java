package com.capgemini.pecunia.service;

import java.util.List;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.Customer;

public interface IAccountService {

	public Account saveAccount(Account account);
	
	public List<Account> getAccounts();
	public Account getAccountById(long accountNumber);
	public String deleteAccount(long accountNumber);
	public Account updateAccount(Account account);
}