package com.revature.daos;

import java.util.List;
import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

	// get Reimbursement Requests a specific employee has made
	public List<Reimbursement> getEmployeeReimbursements(int e_id);
	
	// get Reimbursement Requests of all Employees a manager manages
	public List<Reimbursement> getManagerReimbursements(int role_id);
	
	// update the status of a Reimbursement Request
	public Reimbursement updateReimbursementStatus(int reimb_id);
	
	// submit a Reimbursement Request
	public Reimbursement submitRequest();
	
	// view images from Reimbursement Requests
	public Reimbursement viewReimbursementImages();
	
	
	
}
