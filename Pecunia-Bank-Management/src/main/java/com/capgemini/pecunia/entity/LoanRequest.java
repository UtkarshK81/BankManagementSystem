package com.capgemini.pecunia.entity;

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
@Table(name="LoanRequest") 
public class LoanRequest {
	
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
	private double loanRoi;
	private int creditScore;
	private double loanEMI;
	
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
	
	public double getLoanRoi() {
		return loanRoi;
	}
	
	public void setLoanRoi(double loanRoi) {
		this.loanRoi = loanRoi;
	}
	
	public int getCreditScore() {
		return creditScore;
	}
	
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
	public double getLoanEMI() {
		return loanEMI;
	}
	
	public void setLoanEMI(double loanEMI) {
		this.loanEMI = loanEMI;
	}
	public LoanRequest(long loanRequestId, Customer customer, double loanAmount, String loanType, int loanTenure,
			double loanRoi, int creditScore, double loanEMI) {
		super();
		this.loanRequestId = loanRequestId;
		this.customer = customer;
		this.loanAmount = loanAmount;
		this.loanType = loanType;
		this.loanTenure = loanTenure;
		this.loanRoi = loanRoi;
		this.creditScore = creditScore;
		this.loanEMI = loanEMI;
	}
	public LoanRequest() {
		super();
	}
	
	
}
