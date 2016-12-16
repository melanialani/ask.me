package me.ask.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import me.ask.model.*;
import me.ask.dao.*;

@Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {
	
	@Autowired
	private QuestionAnswerDao questionAnswerDao;

	@Override
	public Collection<QuestionAnswer> findAll() {
		return this.questionAnswerDao.findAll();
	}

	@Override
	public QuestionAnswer find(int question_id) {
		return this.questionAnswerDao.find(question_id);
	}

	@Override
	public Collection<QuestionAnswer> find_home(String username) {
		return this.questionAnswerDao.find_home(username);
	}

}
