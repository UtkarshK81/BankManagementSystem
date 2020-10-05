package com.capgemini.pecunia.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.Transaction;
import com.capgemini.pecunia.exception.TransactionDoesNotExist;
import com.capgemini.pecunia.service.IPassbookService;

/**
 * 
 * @author Nikhil
 *
 */
@RestController
@RequestMapping("/bank")
@CrossOrigin(origins = "http://localhost:4200")
public class PassbookController {

	@Autowired
	private IPassbookService service;

	/**
	 * API that returns a list of transactions occurred between the given period
	 * i.e. the start date and the end date from the given account number.
	 * 
	 * @param accountId
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws com.capgemini.pecunia.exception.TransactionDoesNotExist 
	 * @throws TransactionDoesNotExist
	 */
	@GetMapping("/accountSummary/{accountId}/{startDate}/{endDate}")
	public ResponseEntity<List<Transaction>> accountSummary(@PathVariable long accountId,
			@PathVariable String startDate, @PathVariable String endDate) throws TransactionDoesNotExist  {
		List<Transaction> list = service.accountSummary(accountId, startDate, endDate);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

		
	
	
	/**
	 * API Returns True if account number is valid, false if invalid.
	 * 
	 * @param accountId
	 * @return
	 */
	
	@GetMapping("/accountValidation/{accountId}")
	public boolean accountValidation(@PathVariable("accountId") long accountId) {
		return service.accountValidation(accountId);
	}

	/**
	 * API Returns a list of transaction occurred after the last pass book update and
	 * updates the last pass book updated date to the current date.
	 * 
	 * @param accountId
	 * @return
	 * @throws com.capgemini.pecunia.exception.TransactionDoesNotExist 
	 * @throws TransactionDoesNotExist
	 */
	@GetMapping("/updatePassbook/{accountId}")
	public ResponseEntity<List<Transaction>> updatePassbook(@PathVariable("accountId") long accountId) throws TransactionDoesNotExist 
 {
		List<Transaction> list = service.updatePassbook(accountId);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
