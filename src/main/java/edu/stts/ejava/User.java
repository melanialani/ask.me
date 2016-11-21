package edu.stts.ejava;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@NotNull
	@Size(min=3, max=32)
	private String username; 
	
	@NotNull
	@Size(min=8, max=32)
	private String password; 

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
