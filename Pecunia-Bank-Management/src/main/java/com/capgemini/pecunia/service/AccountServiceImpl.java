package com.capgemini.pecunia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.Customer;
import com.capgemini.pecunia.exception.AccountDoesNotExistException;
import com.capgemini.pecunia.repository.AccountRepository;
import com.capgemini.pecunia.repository.CustomerRepository;

@Service
public class AccountServiceImpl {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired 
	private AccountRepository accountRepo;
	
	
	//post
	
	public Account saveAccount(Account account) {
		//accountRepo.save(account);
		return accountRepo.save(account);
	}
	
	
	//get
	
	public List<Account> getAccounts(){
		return accountRepo.findAll();
	}
	
	public Account getAccountById(long accountNumber){
		return accountRepo.findById(accountNumber).orElse(null);
	}
	
	
	//delete
	
	public String deleteAccount(long accountNumber) {
		accountRepo.deleteById(accountNumber);
		return "customer removed and Account Id=" + accountNumber;
	}
	
	//put
	public Account updateAccount(Account account) {
		
		//Account existingAccount=accountRepo.findById(account.getAccountNumber()).orElse(null);
		if(accountRepo.existsById(account.getAccountNumber())) {
		return	accountRepo.save(account);
			
		}
		else {
			throw new AccountDoesNotExistException();
		}
		//existingAccount.setAccountBalance(account.getAccountBalance());
		//existingAccount.setAccountStatus(account.getAccountStatus());
		//existingAccount.setAccountType(account.getAccountType());
		//existingAccount.setCustomer(customer.getCustomer().getCustName());
		
		//existingAccount.setCustomer(account.getCustomer().getCustName());
	//	existingAccount.setCustContact(account.getCustContact());
	//	existingAccount.setCustName(account.getCustName());
	//	return null;
		
	}
}