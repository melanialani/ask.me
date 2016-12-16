package me.ask.model;

public class User {

	private String username, password, email, name, birthday, phone;
	
	public User() {
		super();
	}

	public User(String username, String password, String email, String name, String birthday, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
	}
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
