package fr.epita.quiz.DTO;

import fr.epita.quiz.datamodel.Answer;

public class AnswerDTO {
	
private Long id;
public String content;
	public AnswerDTO() {
		
	}
	public AnswerDTO(Answer entity) {
		this.id= entity.getId();
		this.content = entity.getContent();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
}
