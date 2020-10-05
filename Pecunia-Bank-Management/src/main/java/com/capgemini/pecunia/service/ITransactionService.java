package com.capgemini.pecunia.service;


import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.exception.AccountDoesNotExistException;


public interface ITransactionService {

	public String creditUsingSlip(long accountId,double amount) throws AccountDoesNotExistException ;

	public String creditUsingCheque(Cheque cheque,long payeeAccountNumber) throws AccountDoesNotExistException;

	public String debitUsingSlip(long accountId, double amount) throws AccountDoesNotExistException;
	
	public String debitUsingCheque(Cheque cheque,long payeeAccountNumber) throws AccountDoesNotExistException;
}
