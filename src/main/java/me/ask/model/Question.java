package me.ask.model;

public class Question {

	private int id;
	private String questioner, answering, question, date;
	
	public Question() {
		super();
	}

	public Question(int id, String questioner, String answering, String question, String date) {
		super();
		this.id = id;
		this.questioner = questioner;
		this.answering = answering;
		this.question = question;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestioner() {
		return questioner;
	}

	public void setQuestioner(String questioner) {
		this.questioner = questioner;
	}

	public String getAnswering() {
		return answering;
	}

	public void setAnswering(String answering) {
		this.answering = answering;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
