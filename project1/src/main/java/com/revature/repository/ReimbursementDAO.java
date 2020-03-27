package com.revature.repository;

import java.io.IOException;
import java.util.List;

import com.revature.instances.Reimbursement;

public interface ReimbursementDAO {
	public List<Reimbursement> findAll();
	public List<Reimbursement> findByPending();
	public List<Reimbursement> findByApproved();
	public List<Reimbursement> findByDenied();
	public List<Reimbursement> findByAuthor(int username);
	
	public boolean insert(Reimbursement reimb);
	public boolean update(Reimbursement reimb);
	public List<Reimbursement> findById(int reimbid) throws IOException;
}
