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

import fr.epita.quiz.DTO.ExamDTO;
import fr.epita.quiz.datamodel.Exam;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.ExamDAO;

@Path("/exam")
public class ExamResources {

	@Inject
	ExamDataService examDS;
	@Inject
	ExamDAO examDAO;

	@POST
	@Path("/createExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response createExam(@RequestBody ExamDTO examDTO) {
		Exam exam = new Exam();
		exam.setTitle(examDTO.getTitle());
		examDAO.create(exam);
		examDTO.setId(exam.getId());
		return Response.ok(examDTO).build();
	}
	
	@GET
	@Path("/getAllExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response getAllExam(@RequestBody ExamDTO examDTO) {
		List<Exam> list = examDAO.getAll();
		return Response.ok(list).build();
	}
	
	@GET
	@Path("/loadData/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response editExam(@PathParam("id")Long id) {
		Exam exam =new Exam();
		ExamDTO examDTO =new ExamDTO();
		exam.setId(examDTO.getId());
		exam.setTitle(examDTO.getTitle());
		examDAO.getById(id);
		System.out.println("load data" + id);
		System.out.println(examDAO);
		return Response.ok(examDAO).build();
	}
	
	@DELETE
	@Path("/deleteExam/{id}")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response deleteExam(@PathParam("id")Long id) {
		examDAO.delete(id);
		Map<String, Long> examdelete= new HashMap<String, Long>();
		examdelete.put("id", id);
		return Response.ok(examdelete).build();	
	}
	
	@PUT
	@Path("/updateExam")
	@Produces(value = MediaType.APPLICATION_JSON)
	public Response updateExam(@RequestBody ExamDTO examDTO) {
		Exam exam = new Exam();
		exam.setTitle(examDTO.getTitle());
		exam.setId(examDTO.getId());
		examDAO.edit(exam);
		return Response.ok(examDTO).build();
	}
	
}
