package com.capgemini.pecunia.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.entity.Account;
import com.capgemini.pecunia.entity.Transaction;
import com.capgemini.pecunia.exception.AccountDoesNotExistException;
import com.capgemini.pecunia.exception.TransactionDoesNotExist;
import com.capgemini.pecunia.repository.PassbookRepository;

@Service
@Transactional
public class PassbookServiceImpl implements IPassbookService {

	@Autowired
	private PassbookRepository dao;



	/**
	 * Returns a list of transactions occurred between the given period
	 * i.e. the start date and the end date from the given account number.
	 * 
	 * @param accountId
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws TransactionDoesNotExist
	 */
	@Override
	public List<Transaction> accountSummary(long accountId, String startDate, String endDate) throws TransactionDoesNotExist {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date start;
		try {
			start = format.parse(startDate);

			System.out.println(start);
			Date end = format.parse(endDate);
			List<Transaction> result = dao.accountSummary(accountId, start, end);
			if ((result.isEmpty())) {
				throw new TransactionDoesNotExist();
			}
			return dao.accountSummary(accountId, start, end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * API Returns True if account number is valid, false if invalid.
	 * 
	 * @param accountId
	 * @return
	 */
	@Override
	public boolean accountValidation(long accountId) {
//		Account account = new Account();
		
		if (dao.existsById(accountId)) {
			return true;
		} else {
			throw new AccountDoesNotExistException();

		}

	}

	/**
	 * API Returns a list of transaction occurred after the last pass book update and
	 * updates the last pass book updated date to the current date.
	 * 
	 * @param accountId
	 * @return
	 * @throws TransactionDoesNotExist
	 */	public List<Transaction> updatePassbook(long accountId) throws TransactionDoesNotExist {
		if (accountValidation(accountId) == false) {
			throw new AccountDoesNotExistException();
		}
		List<Transaction> result = dao.updatePassbook(accountId);
		if (result.isEmpty()) {
			throw new TransactionDoesNotExist();
		}
		updatelastUpdated(accountId);
		return result;

	}

	/**
	 * Update the last updated date to current date in account table for the given
	 * account number.
	 * 
	 * @param accountId long
	 * @return 
	 */
	@Override
	public void updatelastUpdated(long accountId) {
		long millis = System.currentTimeMillis();

		Date date = new Date(millis);

		dao.update(accountId, date);

	}

}