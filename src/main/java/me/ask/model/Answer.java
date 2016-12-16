package me.ask.model;

public class Answer {

	private int id;
	private String question_id, answer;
	
	public Answer() {
		super();
	}

	public Answer(int id, String question_id, String answer) {
		super();
		this.id = id;
		this.question_id = question_id;
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(String question_id) {
		this.question_id = question_id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
