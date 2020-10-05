package com.capgemini.pecunia.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Cheque")
public class Cheque {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq",initialValue=10101,allocationSize=100)
	@Column(length=12)
	private long chequeId;
	
	@Column(length=12)
	private String chequeNumber;
	
	@Column(length=12)
	private long chequeAccountNumber;
	
	private String chequeHolderName;
	private String chequeBankName;
	private String chequeIfsc;
	private LocalDate chequeIssueDate;
	private String chequeStatus;
	private Double chequeAmount;
	
	public Double getChequeAmount() {
		return chequeAmount;
	}
	
	public void setChequeAmount(Double chequeAmount) {
		this.chequeAmount = chequeAmount;
	}
	
	public long getChequeId() {
		return chequeId;
	}
	
	public void setChequeId(long chequeId) {
		this.chequeId = chequeId;
	}
	
	public String getChequeNumber() {
		return chequeNumber;
	}
	
	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}
	
	public long getChequeAccountNumber() {
		return chequeAccountNumber;
	}
	
	public void setChequeAccountNumber(long chequeAccountNumber) {
		this.chequeAccountNumber = chequeAccountNumber;
	}
	
	public String getChequeHolderName() {
		return chequeHolderName;
	}
	
	public void setChequeHolderName(String chequeHolderName) {
		this.chequeHolderName = chequeHolderName;
	}
	
	public String getChequeBankName() {
		return chequeBankName;
	}
	
	public void setChequeBankName(String chequeBankName) {
		this.chequeBankName = chequeBankName;
	}
	
	public String getChequeIfsc() {
		return chequeIfsc;
	}
	
	public void setChequeIfsc(String chequeIfsc) {
		this.chequeIfsc = chequeIfsc;
	}
	
	public LocalDate getChequeIssueDate() {
		return chequeIssueDate;
	}
	
	public void setChequeIssueDate(LocalDate chequeIssueDate) {
		this.chequeIssueDate = chequeIssueDate;
	}
	
	public String getChequeStatus() {
		return chequeStatus;
	}
	
	public void setChequeStatus(String chequeStatus) {
		this.chequeStatus = chequeStatus;
	}
	
	public Cheque(long chequeId, String chequeNumber, long chequeAccountNumber, String chequeHolderName,
			String chequeBankName, String chequeIfsc, LocalDate chequeIssueDate, String chequeStatus,
			Double chequeAmount) {
		super();
		this.chequeId = chequeId;
		this.chequeNumber = chequeNumber;
		this.chequeAccountNumber = chequeAccountNumber;
		this.chequeHolderName = chequeHolderName;
		this.chequeBankName = chequeBankName;
		this.chequeIfsc = chequeIfsc;
		this.chequeIssueDate = chequeIssueDate;
		this.chequeStatus = chequeStatus;
		this.chequeAmount = chequeAmount;
	}
	
	public Cheque() {
		super();
	}
	
	
}