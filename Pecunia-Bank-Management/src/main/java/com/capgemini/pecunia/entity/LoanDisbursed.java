package com.capgemini.pecunia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LoanDisbursed") 
public class LoanDisbursed {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq",initialValue=100001,allocationSize=100)
	@Column(length = 12)
	private long loanRequestId;
	
	@ManyToOne(fetch=FetchType.EAGER,optional=false)
	@JoinColumn(name="custId",nullable=false)
	private Customer customer;
	
	private double loanAmount;
	private String loanType;
	private int loanTenure;
	private double loanEMI;
	private double loanAmtPaid;
	private LocalDate loanDueDate;
	
	public long getLoanRequestId() {
		return loanRequestId;
	}
	
	public void setLoanRequestId(long loanRequestId) {
		this.loanRequestId = loanRequestId;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public String getLoanType() {
		return loanType;
	}
	
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	
	public int getLoanTenure() {
		return loanTenure;
	}
	
	public void setLoanTenure(int loanTenure) {
		this.loanTenure = loanTenure;
	}
	
	public double getLoanEMI() {
		return loanEMI;
	}
	
	public void setLoanEMI(double loanEMI) {
		this.loanEMI = loanEMI;
	}
	
	public double getLoanAmtPaid() {
		return loanAmtPaid;
	}
	
	public void setLoanAmtPaid(double loanAmtPaid) {
		this.loanAmtPaid = loanAmtPaid;
	}
	
	public LocalDate getLoanDueDate() {
		return loanDueDate;
	}
	
	public void setLoanDueDate(LocalDate loanDueDate) {
		this.loanDueDate = loanDueDate;
	}
	public LoanDisbursed(long loanRequestId, Customer customer, double loanAmount, String loanType, int loanTenure,
			double loanEMI, double loanAmtPaid, LocalDate loanDueDate) {
		super();
		this.loanRequestId = loanRequestId;
		this.customer = customer;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.loanTenure = loanTenure;
		this.loanEMI = loanEMI;
		this.loanAmtPaid = loanAmtPaid;
		this.loanDueDate = loanDueDate;
	}
	public LoanDisbursed() {
		super();
	}
	
	
	
	
	
}