package com.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hospital")
public class Hospital {
	
	@Id
	@Column(unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer hospitalId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String mobileNumber;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(nullable=true)
	private String address;
	
	@Column(nullable=false)
	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy="hospital",cascade=CascadeType.ALL,orphanRemoval=false)
	@JsonIgnore
	private Set<Case> cases;
	
	
	public Integer getId() {
		return hospitalId;
	}
	
	public void setId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
