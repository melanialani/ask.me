package me.ask.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import me.ask.model.*;

@Repository
public class FriendDaoImpl implements FriendDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<Friend> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM friend", 
				new BeanPropertyRowMapper<Friend>(Friend.class));
	}

	@Override
	public Friend find(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM friend WHERE id = ?", 
				new BeanPropertyRowMapper<Friend>(Friend.class), id);
	}

	@Override
	public void insert(Friend friend) {
		String query = "INSERT INTO friend (username, following) VALUES (?, ?)";
		jdbcTemplate.update(query, friend.getUsername(), friend.getFollowing());
	}
	
	@Override
	public void delete(int id) {
		String query = "DELETE FROM friend WHERE id=?";
		jdbcTemplate.update(query, id);
	}
	
	@Override
	public Collection<Friend> friendList(String username) {
		return jdbcTemplate.query("SELECT * FROM friend WHERE username = ?", 
				new BeanPropertyRowMapper<Friend>(Friend.class), username);
	}
}
