package com.revature.daos;

public class Driver {

	public static void main(String[] args) {
		
		EmployeeDAO ed = new EmployeeDAOImpl();
		System.out.println(ed.getEmployeeById(2));
		System.out.println(ed.getEmployeeCreds("TylerMooney", "t_Mooney"));
		
		

	}

}
