package fr.epita.quiz.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import fr.epita.quiz.DTO.QuestionDTO;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.dao.MCQChoiceDAO;
import fr.epita.quiz.services.dao.QuestionDAO;

@Path("/question")
public class QuestionResources {
	
	@Inject
	QuestionDAO questionDAO;
	
	@Inject
	MCQChoiceDAO mcqDao;
	
	@POST
	@Path("/save")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response addQuestion(@RequestBody QuestionDTO questionDTO) {	
		Question question = new Question();
		question.setTitle((questionDTO.getTitle()));
		questionDAO.create(question);		
		questionDTO.setId(question.getId());	
		return Response.ok(questionDTO).build();
	}
	
	
	@GET
	@Path("/getAllQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAllQuestion() {
		List<Question> list = questionDAO.getAll();
		return Response.ok(list).build();
	}
	
	@PUT
	@Path("/editQuestion/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getQuestion(@RequestBody QuestionDTO questionDTO) {
		Question question = new Question();
		question.setTitle((questionDTO.getTitle()));
		return Response.ok((questionDTO)).build();
	}
	
	@DELETE
	@Path("/deleteQuestion/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@PathParam("id")Long id) {
			mcqDao.deletChoiceFk(id, "question");
			questionDAO.delete(id);
			Map<String, Long> questiondelete= new HashMap<String, Long>();
			questiondelete.put("id", id);
			return Response.ok(questiondelete).build();		
	}
	
	@PUT
	@Path("/updateQuestion")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response updateQuestion(@RequestBody QuestionDTO questionDTO) {	
		Question question = new Question();
		question.setTitle((questionDTO.getTitle()));
		question.setId(questionDTO.getId());
		questionDAO.edit(question);		
		return Response.ok(questionDTO).build();
	}
}
