package com.capgemini.pecunia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Branch") 
public class Branch {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq",initialValue=111,allocationSize=100)
	@Column(length=4)
	private long branchId;
	@NotNull
	private String branchName;
	
	@OneToOne
	private Address address;
	@NotNull
	private String branchIfsc;
	
	public long getBranchId() {
		return branchId;
	}
	
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
	
	public String getBranchName() {
		return branchName;
	}
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
		
	public String getBranchIfsc() {
		return branchIfsc;
	}
	
	public void setBranchIfsc(String branchIfsc) {
		this.branchIfsc = branchIfsc;
	}
	public Branch() {
		super();
	}
	public Branch(long branchId, String branchName, Address address, String branchIfsc) {
		super();
		this.branchId = branchId;
		this.branchName = branchName;
		this.address = address;
		this.branchIfsc = branchIfsc;
	}
	
	
}