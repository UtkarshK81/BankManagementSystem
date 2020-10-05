package com.capgemini.pecunia.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "transDate" }, allowGetters = true)
@Entity
@Table(name = "Transaction")
public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", initialValue = 1000011, allocationSize = 100)
	@Column(length = 8)
	private long transId;
	@Column(length = 8)
	private String transType;
	@Column(length = 8)
	private Double transAmount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(length = 20, nullable = false, updatable = false)
	@CreatedDate
	private Date transDate;

	public Transaction(long transId, String transType, Double transAmount, Date transDate, Account account,
			String chequeNumber) {
		super();
		this.transId = transId;
		this.transType = transType;
		this.transAmount = transAmount;
		this.transDate = transDate;
		this.account = account;
		this.chequeNumber = chequeNumber;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "accountNumber", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Account account;
	@Column(length = 6)
	private String chequeNumber;

	public long getTransId() {
		return transId;
	}

	public void setTransId(long transId) {
		this.transId = transId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public Double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(Double transAmount) {
		this.transAmount = transAmount;
	}

	public Date getTransDate() {
		return transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getChequeNumber() {
		return chequeNumber;
	}

	public void setChequeNumber(String chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	public Transaction() {
		super();
	}

}