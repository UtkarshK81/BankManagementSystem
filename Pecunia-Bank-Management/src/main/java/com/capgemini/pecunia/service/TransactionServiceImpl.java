package com.capgemini.pecunia.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.entity.Transaction;
import com.capgemini.pecunia.exception.AccountDoesNotExistException;
import com.capgemini.pecunia.repository.AccountRepository;
import com.capgemini.pecunia.repository.ChequeRepository;
import com.capgemini.pecunia.repository.TransactionRepository;
@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ChequeRepository chequeRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	/**
	 * Returns the status of the transaction 
	 * i.e. success or failed.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return
	 * @throws AccountDoesNotExistException
	 */
	
	@Override
	public String creditUsingSlip(long accountNumber, double amount) throws AccountDoesNotExistException{
		Transaction transaction=new Transaction();
		String status="";
		Account account=new Account();
		if(accountRepository.existsById(accountNumber)) {
	    account=accountRepository.getOne(accountNumber);
	    account.setAccountBalance(amount+account.getAccountBalance());
		System.out.println(account);
	    accountRepository.save(account);
		transaction.setAccount(account);
	    transaction.setTransAmount(amount);
		transaction.setTransType("Slip");
		transactionRepository.save(transaction);
		 status="Success";
		}
		else {
			throw new AccountDoesNotExistException();
		}
		return status;
	}
	
	/**
	 * Returns the status of the transaction  
	 * i.e. success if sufficient amount available in payer account or failed.
	 * 
	 * @param cheque
	 * @return
	 * @throws AccountDoesNotExistException
	 */
	@Override
	public String creditUsingCheque(Cheque cheque,long payeeAccountNumber) throws AccountDoesNotExistException{
		String transactionStatus="";
		
	    if(accountRepository.existsById(cheque.getChequeAccountNumber())&&accountRepository.existsById(payeeAccountNumber))
	    {
	    	Transaction transaction=new Transaction();
			Account payerAccount=new Account();
			Account payeeAccount=new Account();
			double payerBalance=accountRepository.getOne(cheque.getChequeAccountNumber()).getAccountBalance();
		    payerAccount=accountRepository.getOne(cheque.getChequeAccountNumber());
		    payeeAccount=accountRepository.getOne(payeeAccountNumber);
		    double payeeBalance=payeeAccount.getAccountBalance();
		  if(payerBalance<cheque.getChequeAmount())
		  {
			 transactionStatus="Failed";
			 cheque.setChequeStatus("Reject");
			 chequeRepository.save(cheque);
		  }
		  else {
			payerBalance-=cheque.getChequeAmount();
			payerAccount.setAccountBalance(payerBalance);
			accountRepository.save(payerAccount);
			payeeBalance+=cheque.getChequeAmount();
			payeeAccount.setAccountBalance(payeeBalance);
			accountRepository.save(payeeAccount);
			transaction.setAccount(payeeAccount);
			transaction.setChequeNumber(cheque.getChequeNumber());
			transaction.setTransAmount(cheque.getChequeAmount());
			transaction.setTransType("Cheque");
			transactionRepository.save(transaction);
			cheque.setChequeStatus("Accepted");
			chequeRepository.save(cheque);
			transactionStatus="Success";
		  }
	    }
	    else{
	    	throw new AccountDoesNotExistException();
	    }
		return transactionStatus;
	}
	
	/**
	 * Returns the status of the transaction 
	 *i.e. success if sufficient balance available in customer's account or failed.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return
	 * @throws AccountDoesNotExistException
	 */
	@Override
	public String debitUsingSlip(long accountNumber, double amount) throws AccountDoesNotExistException{
		Account account=new Account();
		Transaction transaction=new Transaction();
		String transactionStatus="";
		if(accountRepository.existsById(accountNumber)) {
		  account=accountRepository.getOne(accountNumber);
		  if(account.getAccountBalance()<amount)
			transactionStatus="Failed";
		  else
		  {
			account.setAccountBalance(account.getAccountBalance()-amount);
			accountRepository.save(account);
			transaction.setAccount(account);
			transaction.setTransAmount(amount);
			transaction.setTransType("Slip");
			transactionRepository.save(transaction);
			transactionStatus="Success";
		  }
		}
		else {
			throw new AccountDoesNotExistException();
		}
			
		return transactionStatus;
	}
	
	/**
	 * Returns the status of the transaction 
	 * i.e. success if sufficient amount available in payer account or failed.
	 * 
	 * @param cheque
	 * @return
	 * @throws AccountDoesNotExistException
	 */
	@Override
	public String debitUsingCheque(Cheque cheque,long payeeAccountNumber) throws AccountDoesNotExistException{
		 String transactionStatus="";
		 if(accountRepository.existsById(cheque.getChequeAccountNumber())&&accountRepository.existsById(payeeAccountNumber))
		    {
		    	Transaction transaction=new Transaction();
				Account payerAccount=new Account();
				Account payeeAccount=new Account();
				double payerBalance=accountRepository.getOne(cheque.getChequeAccountNumber()).getAccountBalance();
			    payerAccount=accountRepository.getOne(cheque.getChequeAccountNumber());
			    payeeAccount=accountRepository.getOne(payeeAccountNumber);
			    double payeeBalance=payeeAccount.getAccountBalance();
			  if(payerBalance<cheque.getChequeAmount())
			  {
				 transactionStatus="Failed";
				 cheque.setChequeStatus("Reject");
				 chequeRepository.save(cheque);
			  }
			  else {
				payerBalance-=cheque.getChequeAmount();
				payerAccount.setAccountBalance(payerBalance);
				accountRepository.save(payerAccount);
				payeeBalance+=cheque.getChequeAmount();
				payeeAccount.setAccountBalance(payeeBalance);
				accountRepository.save(payeeAccount);
				transaction.setAccount(payeeAccount);
				transaction.setChequeNumber(cheque.getChequeNumber());
				transaction.setTransAmount(cheque.getChequeAmount());
				transaction.setTransType("Cheque");
				transactionRepository.save(transaction);
				cheque.setChequeStatus("Accepted");
				chequeRepository.save(cheque);
				transactionStatus="Success";
			  }
		    }
		    else{
		    	throw new AccountDoesNotExistException();
		    }
			return transactionStatus;
	}
		
	}

	

