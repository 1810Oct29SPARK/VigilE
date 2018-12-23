package com.revature.daos;

import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {
	
	// submit a Reimbursement Request
	public Reimbursement newReimbursement(Reimbursement r);
	
	// update the status of a Reimbursement Request
	public Reimbursement updateReimbursement(Reimbursement reimb, int reimb_stat, int reimb_resolver);
		
	public Reimbursement deleteReimbursement(int id);
	
	public List<Reimbursement> getAllReimbursements();
	
	public Reimbursement getReimbursementById(int id);

	// get Reimbursement Requests a specific employee has made
	public List<Reimbursement> getEmployeeReimbursements(Employee e);
	
	// get Reimbursement Requests of all Employees a manager manages
//	public List<Reimbursement> getManagerReimbursements(Employee emp);
	
	
	
	
	
	
	
	
		
}
