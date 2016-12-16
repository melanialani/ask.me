package me.ask.dao;

import java.util.*;
import me.ask.model.*;

public interface QuestionDao {
	
	public Collection<Question> findAll();
	
	public Question find(int id);
	
	public void insert(Question question);
	
	public void delete(int id);
}
