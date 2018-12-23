package com.revature.service;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.daos.EmployeeDAO;
import com.revature.daos.EmployeeDAOImpl;

public class AuthenticationService {

	public AuthenticationService() {
		
	}
	
	
	public Employee isValidUser(Credentials credentials) {
		Employee emp = null;
		String user = credentials.getUsername();
		String password = credentials.getPassword();
		
		
		
		if (user != null && password != null) {
			
			EmployeeDAO ed = new EmployeeDAOImpl();
			emp = ed.getEmployeeCreds(user, password);
			System.out.println(emp);
			return emp;
		}
		
		return null;
			
	}
		
}
