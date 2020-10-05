package com.capgemini.pecunia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.Cheque;
import com.capgemini.pecunia.exception.AccountDoesNotExistException;
import com.capgemini.pecunia.exception.TransactionDoesNotExist;
import com.capgemini.pecunia.service.ITransactionService;
/**
 * 
 * @author Amar
 *
 */
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/bank")
public class TransactionController {

	@Autowired
	private ITransactionService transactionService;
	
	/**
	 * API that returns the status of the transaction
	 * i.e. success or failed.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return
	 * @throws TransactionDoesNotExist
	 */
	
	@PutMapping("creditUsingSlip/{accountNumber}/{amount}")
	public String creditUsingSlip(@PathVariable("accountNumber") long accountNumber,@PathVariable("amount")double amount) throws AccountDoesNotExistException {
		return transactionService.creditUsingSlip(accountNumber, amount);
	}
	
	/**
	 * API that returns the status of the transaction 
	 * i.e. success if sufficient amount available in payer account or failed.
	 * 
	 * @param cheque
	 * @return
	 * @throws AccountDoesNotExistException
	 */
	@PutMapping("creditUsingCheque/{payeeAccountNumber}")
	public String creditUsingCheque(@RequestBody Cheque cheque,@PathVariable long payeeAccountNumber) throws AccountDoesNotExistException{
		System.out.println(cheque.toString());
		return transactionService.creditUsingCheque(cheque,payeeAccountNumber);
		
	}
	
	/**
	 * API that returns the status of the transaction
	 *i.e. success if sufficient balance available in customer's account or failed.
	 * 
	 * @param accountNumber
	 * @param amount
	 * @return
	 * @throws TransactionDoesNotExist
	 */
	@PutMapping("debitUsingSlip/{accountNumber}/{amount}")
	public String debitUsingSlip(@PathVariable("accountNumber") long accountNumber,@PathVariable("amount")double amount) throws AccountDoesNotExistException {
		return transactionService.debitUsingSlip(accountNumber, amount);
	}
	
	/**
	 * API that returns the status of the transaction 
	 * i.e. success if sufficient amount available in payer account or failed.
	 * 
	 * @param cheque
	 * @return
	 * @throws AccountDoesNotExistException
	 */
	@PutMapping("debitUsingCheque/{payeeAccountNumber}")
	public String debitUsingCheque(@RequestBody Cheque cheque,@PathVariable long payeeAccountNumber) throws AccountDoesNotExistException {
		return transactionService.debitUsingCheque(cheque,payeeAccountNumber);
	}
}
