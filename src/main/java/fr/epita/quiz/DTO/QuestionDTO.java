package fr.epita.quiz.DTO;

import fr.epita.quiz.datamodel.Question;

public class QuestionDTO {

	private Long id;
	private String title;
	
	public QuestionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public QuestionDTO(Question entity) {
		this.title = entity.getTitle();
		this.id = entity.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
