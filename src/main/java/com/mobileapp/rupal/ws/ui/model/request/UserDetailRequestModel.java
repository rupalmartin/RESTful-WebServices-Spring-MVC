package com.mobileapp.rupal.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailRequestModel {

	@NotNull(message="firstname cannot be null")
	@Size(min=2,message="firstname cannot be les than 2 chars")
	private String firstname;
	
	@NotNull(message="lastname cannot be null")
	@Size(min=2,message="lastname cannot be les than 2 chars")
	private String lastname;
	
	@NotNull(message="email cannot be null")
	@Email
	private String email;	
	
	@NotNull(message="password cannot be null")
	@Size(min=8,max=16,message="password must be equal or greater than 8 characters and less than 16 characters")
	private String password;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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
}
