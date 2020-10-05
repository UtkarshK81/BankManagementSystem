  
package com.capgemini.pecunia.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="Address") 
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq")
	@SequenceGenerator(name="seq",initialValue=101,allocationSize=100)
	@Column(length=12)
	private long addressId;
	@NotNull
	private String addressLine1;
	private String addressLine2;
	private String addressLine3;
	@NotNull
	private String addressCity;
	@NotNull
	private String addressState;
	@NotNull
	private String addressCountry;
	@Column(length=6)
	@NotNull
	private int addressZipcode;
	
	
	public long getAddressId() {
		return addressId;
	}
	
	public Address(long addressId, String addressLine1, String addressLine2, String addressLine3, String addressCity,
			String addressState, String addressCountry, int addressZipcode) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.addressZipcode = addressZipcode;
	}

	
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getAddressLine3() {
		return addressLine3;
	}
	
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}
	
	public String getAddressCity() {
		return addressCity;
	}
	
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	
	public String getAddressState() {
		return addressState;
	}
	
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}
	
	public String getAddressCountry() {
		return addressCountry;
	}
	
	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	
	public int getAddressZipcode() {
		return addressZipcode;
	}
	
	public void setAddressZipcode(int addressZipcode) {
		this.addressZipcode = addressZipcode;
	}
	public Address() {
		super();
	}
	
	
	
}

