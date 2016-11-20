package edu.stts.ejava;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@NotNull
	@Size(min=3, max=32)
	private String username; 

	@NotNull
	@Min(5)
	private int age; 

	@Override
	public String toString() {
		return "User [username=" + username + ", age=" + age + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
