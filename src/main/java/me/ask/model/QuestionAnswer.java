package me.ask.model;

public class QuestionAnswer {

	private int question_id, answer_id;
	private String questioner, answering, question, answer, date;
	
	public QuestionAnswer() {
		super();
	}

	public QuestionAnswer(int question_id, int answer_id, String questioner, String answering, String question,
			String answer, String date) {
		super();
		this.question_id = question_id;
		this.answer_id = answer_id;
		this.questioner = questioner;
		this.answering = answering;
		this.question = question;
		this.answer = answer;
		this.date = date;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
