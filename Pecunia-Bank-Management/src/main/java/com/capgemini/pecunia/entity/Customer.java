package com.capgemini.pecunia.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq",initialValue=10000101,allocationSize=100)
	private long custId;
	@NotNull
	private String custName;
	@NotNull
	private String custAadhar;
	@NotNull
	private String custPan;
	@Size(min=10,max=10)
	private String custContact;
	@NotNull
	private Date custDob;
	@NotNull
	private String gender;
	@Email(message="Enter valid email id!!")
	private String custEmail;
	
	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;

	public Customer() {
		super();
	}
	
	
	



	public Customer(long custId, String custName, String custAadhar, String custPan, String custContact, Date custDob,
			String gender, String custEmail, Address address) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custAadhar = custAadhar;
		this.custPan = custPan;
		this.custContact = custContact;
		this.custDob = custDob;
		this.gender = gender;
		this.custEmail = custEmail;
		this.address = address;
	}






	public Address getAddress() {
		return address;
	}






	public void setAddress(Address address) {
		this.address = address;
	}






	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Date getCustDob() {
		return custDob;
	}
	
	public void setCustDob(Date custDob) {
		this.custDob = custDob;
	}
	
	public long getCustId() {
		return custId;
	}
	
	public void setCustId(long custId) {
		this.custId = custId;
	}
	
	public String getCustName() {
		return custName;
	}
	
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	public String getCustAadhar() {
		return custAadhar;
	}
	
	public void setCustAadhar(String custAadhar) {
		this.custAadhar = custAadhar;
	}
	
	public String getCustPan() {
		return custPan;
	}
	
	public void setCustPan(String custPan) {
		this.custPan = custPan;
	}
	
	
	public String getCustContact() {
		return custContact;
	}
	
	public void setCustContact(String custContact) {
		this.custContact = custContact;
	}
	
	public String getCustEmail() {
		return custEmail;
	}
	
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
}
