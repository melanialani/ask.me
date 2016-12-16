package me.ask.service;

import java.util.*;
import me.ask.model.*;

public interface FriendService {
	
	public Collection<Friend> findAll();
	
	public Friend find(int id);
	
	public void insert(Friend friend);
	
	public void delete(int id);
	
	public Collection<Friend> friendList(String username);
}
