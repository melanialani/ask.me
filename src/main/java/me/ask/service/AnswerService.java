package me.ask.service;

import java.util.*;
import me.ask.model.*;

public interface AnswerService {
	
	public Collection<Answer> findAll();
	
	public Answer find(int id);
	
	public void insert(Answer answer);
	
	public void delete(int id);
}
