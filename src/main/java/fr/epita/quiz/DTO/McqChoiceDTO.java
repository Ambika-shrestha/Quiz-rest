package fr.epita.quiz.DTO;

import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;

public class McqChoiceDTO {
	private long id;
	private String choice;
	private boolean valid;
	private Question question;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public McqChoiceDTO(MCQChoice entity) {
		this.id= entity.getId();
		this.choice = entity.getChoice();
		this.valid =  entity.isValid();
		this.question =entity.getQuestion();
	}
	
	public McqChoiceDTO() {
	}
	
}
