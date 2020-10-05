package com.capgemini.pecunia.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@JsonIgnoreProperties(value = { "lastUpdated" }, allowGetters = true)
@Entity
@Table(name = "Account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@SequenceGenerator(name = "seq", initialValue = 100001001, allocationSize = 100)
	@Column(length = 12)
	private long accountNumber;

	@OneToOne
	private Branch branch;

	@Column(length = 15)
	private String accountType;

	private String accountStatus;

	@Column(length = 8)
	private double accountBalance;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false, updatable = true)
	@CreatedDate
	private Date lastUpdated;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "custId", nullable = false)
//	@OnDelete(action = OnDeleteAction.CASCADE)
	private Customer customer;

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * 
	 * @param accountNumber
	 * @param branch
	 * @param accountType
	 * @param accountStatus
	 * @param accountBalance
	 * @param lastUpdated
	 * @param customer
	 */
	public Account(long accountNumber, Branch branch, String accountType, String accountStatus, double accountBalance,
			Date lastUpdated, Customer customer) {
		super();
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalance = accountBalance;
		this.lastUpdated = lastUpdated;
		this.customer = customer;
	}

	public Account() {
		super();
	}

}