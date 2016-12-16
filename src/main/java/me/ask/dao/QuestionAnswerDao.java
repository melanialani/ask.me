package me.ask.dao;

import java.util.*;
import me.ask.model.*;

public interface QuestionAnswerDao {
	
	public Collection<QuestionAnswer> findAll();
	
	public QuestionAnswer find(int question_id); 
	
	public Collection<QuestionAnswer> find_home(String username);
}
