package com.revature.daos;

public class Driver {

	public static void main(String[] args) {
		
		ReimbursementDAO rDAO = new ReimbursementDAOImpl();
		System.out.println(rDAO.getAllReimbursements());
		

	}

}
