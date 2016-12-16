package me.ask.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.ask.model.*;
import me.ask.dao.*;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public Collection<User> findAll() {
		return this.userDao.findAll();
	}

	@Override
	public User find(String username) {
		return this.userDao.find(username);
	}

	@Override
	public void insert(User user) {
		this.userDao.insert(user);
	}

	@Override
	public void update(User user) {
		this.userDao.update(user);
	}

	@Override
	public void delete(String username) {
		this.userDao.delete(username);
	}
	
	@Override
	public Collection<User> checkLogin(String username) {
		return this.userDao.checkLogin(username);
	}
}
