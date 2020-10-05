package com.capgemini.pecunia.service;


import java.util.Date;
import java.util.List;

import com.capgemini.pecunia.entity.Transaction;
import com.capgemini.pecunia.exception.TransactionDoesNotExist;

public interface IPassbookService {
	List<Transaction> accountSummary(long accountId,String startDate, String endDate) throws TransactionDoesNotExist ;
	boolean accountValidation(long accountId);
	List<Transaction> updatePassbook(long accountId) throws TransactionDoesNotExist;
	
	void  updatelastUpdated(long accountId);

}
