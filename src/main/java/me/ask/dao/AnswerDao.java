package me.ask.dao;

import java.util.*;
import me.ask.model.*;

public interface AnswerDao {
	
	public Collection<Answer> findAll();
	
	public Answer find(int id);
	
	public void insert(Answer answer);
	
	public void delete(int id);
}
