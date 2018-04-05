package com.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="lab")
public class Lab {

	
	@Id
	@Column(unique=true,nullable=false,name="lab_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer labId;
	
	@Column(nullable=false,name="name")
	private String name;
	
	@Column(unique=true, nullable=false,name="email")
	private String email;
	
	@Column(nullable=false,name="password")
	//@JsonIgnore
	private String password;
	
	@Column(nullable=false)
	private String mobileNumber;
	
	@Column(nullable=true)
	private String address;
	
	@OneToMany(mappedBy="lab",cascade=CascadeType.ALL,orphanRemoval=false)
	@JsonIgnore
	private Set<Case> cases;
	
	@ManyToMany
    @JoinTable(name = "lab_role", joinColumns = {@JoinColumn(name = "lab_id")}, inverseJoinColumns = { @JoinColumn(name = "role_id")})
	@JsonIgnore
	private Set<Role> roles;
	
	
	public Integer getLabId() {
		return labId;
	}
	public void setLabId(Integer labId) {
		this.labId = labId;
	}
	public Set<Case> getCases() {
		return cases;
	}
	public void setCases(Set<Case> cases) {
		this.cases = cases;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
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
