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
@Table(name="lab")
public class Lab {

	
	@Id
	@Column(unique=true,nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer labId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@Column(nullable=false)
	@JsonIgnore
	private String password;
	
	@Column(nullable=false)
	private String mobileNumber;
	
	@Column(nullable=true)
	private String address;
	
	@OneToMany(mappedBy="lab",cascade=CascadeType.ALL,orphanRemoval=false)
	@JsonIgnore
	private Set<Case> cases;
	
	
	public Integer getId() {
		return labId;
	}
	public void setId(Integer labId) {
		this.labId = labId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
