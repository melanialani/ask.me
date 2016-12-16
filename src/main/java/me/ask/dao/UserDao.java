package me.ask.dao;

import java.util.*;
import me.ask.model.*;

public interface UserDao {
	
	public Collection<User> findAll();
	
	public User find(String username);
	
	public void insert(User user);
	
	public void update(User user);
	
	public void delete(String username);
	
	public Collection<User> checkLogin(String username);
}
