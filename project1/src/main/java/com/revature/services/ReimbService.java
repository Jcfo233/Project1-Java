package com.revature.services;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.instances.Reimbursement;
import com.revature.repository.ReimbursementDAO;
import com.revature.repository.ReimbursementDAOImpl;

public class ReimbService {
	private ReimbursementDAO repository = new ReimbursementDAOImpl();
	private ObjectMapper mapper = new ObjectMapper();
	
	public ReimbService() {
		super();
		repository = new ReimbursementDAOImpl();
		mapper = new ObjectMapper();
	}

	public ReimbService(ReimbursementDAO repository) {
		super();
		this.repository = repository;
	}
	
	
	
	public List<Reimbursement> findAll(){
		return repository.findAll();
	}
	
	public List<Reimbursement> findByPending(){
		return repository.findByPending();
	}
	
	public List<Reimbursement> findByApproved(){
		return repository.findByApproved();
	}
	
	public List<Reimbursement> findByDenied(){
		return repository.findByDenied();
	}
	
	public List<Reimbursement> findByAuthor(int id){
		return repository.findByAuthor(id);
	}
	
	public boolean insert(Reimbursement reimb) {
		return repository.insert(reimb);
	}
	
	public boolean update(Reimbursement reimb) {
		return repository.update(reimb);
	}
	
	public List<Reimbursement> findById(int reimbid) throws IOException{
		return repository.findById(reimbid);
	}

	public String processGet(String[] uri) throws NumberFormatException, IOException {
		System.out.println(uri.length);
		if (uri.length == 1){
			return mapper.writeValueAsString(repository.findAll());
		}else if (uri.length > 2) {
				System.out.println("findbyid");
				return mapper.writeValueAsString(repository.findById(Integer.parseInt(uri[2])));
		}else{
			switch (uri[1]) {
			case "PENDING":
				return mapper.writeValueAsString(repository.findByPending());
			case "APPROVED":
				return mapper.writeValueAsString(repository.findByApproved());
			case "DENIED":
				return mapper.writeValueAsString(repository.findByDenied());
			default:
				int id = new EmployeeService().findByUser(uri[1]).getId();
				return mapper.writeValueAsString(repository.findByAuthor(id));
			}
		}
	}
	
	public String processPost(String[] uri, String body) throws JsonProcessingException {
		System.out.println(uri[3]);
		if (uri[3].equals("update")) {
			return mapper.writeValueAsString(repository.update(mapper.readValue(body, Reimbursement.class)));
		}else {
			return mapper.writeValueAsString(repository.insert(mapper.readValue(body, Reimbursement.class)));
		}
	}
	
}
