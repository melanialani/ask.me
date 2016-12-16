package me.ask.model;

public class Friend {

	private int id;
	private String username, following, date;
	
	public Friend() {
		super();
	}

	public Friend(int id, String username, String following, String date) {
		super();
		this.id = id;
		this.username = username;
		this.following = following;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
