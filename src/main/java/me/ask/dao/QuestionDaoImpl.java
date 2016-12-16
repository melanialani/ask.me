package me.ask.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import me.ask.model.*;

@Repository
public class QuestionDaoImpl implements QuestionDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<Question> findAll() {
		return this.jdbcTemplate.query("SELECT * FROM question", 
				new BeanPropertyRowMapper<Question>(Question.class));
	}

	@Override
	public Question find(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM question WHERE id = ?", 
				new BeanPropertyRowMapper<Question>(Question.class), id);
	}

	@Override
	public void insert(Question question) {
		String query = "INSERT INTO question (questioner, answering, question) VALUES (?, ?, ?)";
		jdbcTemplate.update(query, question.getQuestioner(), question.getAnswering(), question.getQuestion());
	}
	
	@Override
	public void delete(int id) {
		String query = "DELETE FROM friend WHERE id=?";
		jdbcTemplate.update(query, id);
	}
}
