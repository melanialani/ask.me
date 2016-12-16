package me.ask.service;

import java.util.*;
import me.ask.model.*;

public interface QuestionAnswerService {
	
	public Collection<QuestionAnswer> findAll();
	
	public QuestionAnswer find(int question_id); 
	
	public Collection<QuestionAnswer> find_home(String username);
}
