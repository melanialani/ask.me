package me.ask.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import me.ask.model.*;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<User> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM user", 
				new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public User find(String username) {
		return jdbcTemplate.queryForObject("SELECT * FROM user WHERE username = ?", 
				new BeanPropertyRowMapper<User>(User.class), username);
	}

	@Override
	public void insert(User user) {
		String query = "INSERT INTO user (username, password, email, name, phone, birthday) VALUES (?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, user.getUsername(), user.getPassword(), user.getEmail(), user.getName(), user.getPhone(), user.getBirthday());
	}

	@Override
	public void update(User user) {
		String query = "UPDATE user SET password=?, email=?, name=?, phone=?, birthday=? WHERE username=?";
		jdbcTemplate.update(query, user.getPassword(), user.getEmail(), user.getName(), user.getPhone(), user.getBirthday(), user.getUsername());
	}
	
	@Override
	public void delete(String username) {
		String query = "DELETE FROM user WHERE username=?";
		jdbcTemplate.update(query, username);
	}
	
	@Override
	public Collection<User> checkLogin(String username) {
		return jdbcTemplate.query("SELECT * FROM user WHERE username = ?", 
				new BeanPropertyRowMapper<User>(User.class), username);
	}
}
