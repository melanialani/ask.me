package me.ask.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.ask.model.*;
import me.ask.dao.*;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	private AnswerDao answerDao;

	@Override
	public Collection<Answer> findAll() {
		return this.answerDao.findAll();
	}

	@Override
	public Answer find(int id) {
		return this.answerDao.find(id);
	}

	@Override
	public void insert(Answer answer) {
		this.answerDao.insert(answer);
	}

	@Override
	public void delete(int id) {
		this.answerDao.delete(id);
	}

}
