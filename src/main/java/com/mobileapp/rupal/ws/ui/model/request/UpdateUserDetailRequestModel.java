package com.mobileapp.rupal.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailRequestModel {
	@NotNull(message="firstname cannot be null")
	@Size(min=2,message="firstname cannot be les than 2 chars")
	private String firstname;
	
	@NotNull(message="lastname cannot be null")
	@Size(min=2,message="lastname cannot be les than 2 chars")
	private String lastname;
	
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

}
