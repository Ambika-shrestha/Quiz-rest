package fr.epita.quiz.DTO;

public class ExamDTO {

	private Long id;
	private String title;
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
	public ExamDTO(Long id, String title) {
		this.id = id;
		this.title = title;
	}
	public ExamDTO() {
		// TODO Auto-generated constructor stub
	}
}
