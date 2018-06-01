package com.api.test.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class UserDetails {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("username")
	private String userName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("address")
	private Address address;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("website")
	private String website;
	
	@JsonProperty("company")
	private Company company;

	@JsonProperty("name1")
	private String name1;
	
	@JsonProperty("bs")
	private String bs;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", userName=" + userName + ", email=" + email + ", address="
				+ address + ", phone=" + phone + ", website=" + website + ", company=" + company + "]";
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getBs() {
		return bs;
	}

	public void setBs(String bs) {
		this.bs = bs;
	}
	
	
}

