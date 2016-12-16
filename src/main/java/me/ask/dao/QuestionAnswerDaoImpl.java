package me.ask.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.*;
import me.ask.model.*;

@Repository
public class QuestionAnswerDaoImpl implements QuestionAnswerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Collection<QuestionAnswer> findAll() {
		String query = "SELECT q.id AS question_id, a.id AS answer_id, q.questioner AS questioner, q.answering AS answering, q.question AS question, a.answer AS answer, q.date AS date"
				+ " FROM question q, answer a"
				+ " WHERE q.id=a.question_id"
				+ " GROUP BY q.id"
				+ " UNION "
				+ " SELECT q.id AS question_id, '0' AS answer_id, q.questioner AS questioner, q.answering AS answering, q.question AS question, 'Not answered yet' AS answer, q.date AS date"
				+ " FROM question q"
				+ " WHERE q.id NOT IN (SELECT a.question_id FROM answer a)"
				+ " ORDER BY date DESC";
		return this.jdbcTemplate.query(query, new BeanPropertyRowMapper<QuestionAnswer>(QuestionAnswer.class));
	}

	@Override
	public QuestionAnswer find(int question_id) {
		String query = "SELECT q.id AS question_id, a.id AS answer_id, q.questioner AS questioner, q.answering AS answering, q.question AS question, a.answer AS answer, q.date AS date"
				+ " FROM question q, answer a"
				+ " WHERE q.id=a.question_id AND q.id=?"
				+ " GROUP BY q.id"
				+ " UNION "
				+ " SELECT q.id AS question_id, '0' AS answer_id, q.questioner AS questioner, q.answering AS answering, q.question AS question, 'Not answered yet' AS answer, q.date AS date"
				+ " FROM question q"
				+ " WHERE q.id NOT IN (SELECT a.question_id FROM answer a) AND q.id=?"
				+ " ORDER BY date DESC";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<QuestionAnswer>(QuestionAnswer.class), question_id, question_id);
	}

	@Override
	public Collection<QuestionAnswer> find_home(String username) {
		String query = "SELECT q.id AS question_id, a.id AS answer_id, q.questioner AS questioner, q.answering AS answering, q.question AS question, a.answer AS answer, q.date AS date"
				+ " FROM question q, answer a"
				+ " WHERE q.id=a.question_id AND (q.questioner=? OR q.answering=?)"
				+ " GROUP BY q.id"
				+ " UNION "
				+ " SELECT q.id AS question_id, '0' AS answer_id, q.questioner AS questioner, q.answering AS answering, q.question AS question, 'Not answered yet' AS answer, q.date AS date"
				+ " FROM question q"
				+ " WHERE q.id NOT IN (SELECT a.question_id FROM answer a) AND (q.questioner=? OR q.answering=?)"
				+ " ORDER BY date DESC";
		return this.jdbcTemplate.query(query, new BeanPropertyRowMapper<QuestionAnswer>(QuestionAnswer.class), username, username, username, username);
	}
}
