package me.ask.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.ask.model.*;
import me.ask.dao.*;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDao friendDao;

	@Override
	public Collection<Friend> findAll() {
		return this.friendDao.findAll();
	}

	@Override
	public Friend find(int id) {
		return this.friendDao.find(id);
	}

	@Override
	public void insert(Friend friend) {
		this.friendDao.insert(friend);
	}

	@Override
	public void delete(int id) {
		this.friendDao.delete(id);
	}
	
	@Override
	public Collection<Friend> friendList(String username) {
		return this.friendDao.friendList(username);
	}
}
