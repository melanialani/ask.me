package me.ask.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.ask.model.*;
import me.ask.dao.*;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;

	@Override
	public Collection<Question> findAll() {
		return this.questionDao.findAll();
	}

	@Override
	public Question find(int id) {
		return this.questionDao.find(id);
	}

	@Override
	public void insert(Question question) {
		this.questionDao.insert(question);
	}

	@Override
	public void delete(int id) {
		this.questionDao.delete(id);
	}

}
