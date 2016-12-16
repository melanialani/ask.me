package me.ask.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import me.ask.model.*;

@Repository
public class AnswerDaoImpl implements AnswerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<Answer> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM answer", 
				new BeanPropertyRowMapper<Answer>(Answer.class));
	}

	@Override
	public Answer find(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM answer WHERE id = ?", 
				new BeanPropertyRowMapper<Answer>(Answer.class), id);
	}

	@Override
	public void insert(Answer answer) {
		String query = "INSERT INTO answer (question_id, answer) VALUES (?, ?)";
		jdbcTemplate.update(query, answer.getQuestion_id(), answer.getAnswer());
	}
	
	@Override
	public void delete(int id) {
		String query = "DELETE FROM answer WHERE id=?";
		jdbcTemplate.update(query, id);
	}
}
