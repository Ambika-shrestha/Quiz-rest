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

import fr.epita.quiz.DTO.McqChoiceDTO;
import fr.epita.quiz.DTO.QuestionDTO;
import fr.epita.quiz.datamodel.MCQChoice;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.dao.MCQChoiceDAO;

@Path("/mcqchoice")
public class McqChoiceResources {

	@Inject
	MCQChoiceDAO mcqDao;
	
	@POST
	@Path("/createChoice")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createExam(@RequestBody McqChoiceDTO mcqChoiceDto) {
		MCQChoice mcqchoice = new MCQChoice();
		mcqchoice.setChoice(mcqChoiceDto.getChoice());
		mcqchoice.setValid(mcqChoiceDto.isValid());
		mcqchoice.setQuestion(mcqChoiceDto.getQuestion());
		mcqDao.create(mcqchoice);
		mcqChoiceDto.setId(mcqchoice.getId());
		return Response.ok(mcqChoiceDto).build();
	}
	
	@GET
	@Path("/getAllChoice/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAllChoice(@PathParam("id")Long id) {
		List<MCQChoice> list = mcqDao.getByOtherColumnId(id, "question");
		return Response.ok(list).build();
	}
	
	@PUT
	@Path("/updateMcqChoice")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response updateMcq(@RequestBody McqChoiceDTO mcqChoiceDto) {	
		MCQChoice mcqChoice = new MCQChoice();
		mcqChoice.setId((mcqChoiceDto.getId()));
		mcqChoice.setChoice((mcqChoiceDto.getChoice()));
		mcqChoice.setValid(mcqChoiceDto.isValid());
		mcqChoice.setQuestion(mcqChoiceDto.getQuestion());
		mcqDao.edit(mcqChoice);
		return Response.ok(mcqChoiceDto).build();
	}
	
	@DELETE
	@Path("/deleteMcqChoice/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response deleteQuestion(@PathParam("id")Long id) {
		mcqDao.delete(id);
		Map<String, Long> mcqdelete= new HashMap<String, Long>();
		mcqdelete.put("id", id);
		return Response.ok(mcqdelete).build();
	}
}
