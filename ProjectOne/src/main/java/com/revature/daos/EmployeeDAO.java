package com.revature.daos;

import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDAO {

	// gets list of all employees under a manager
	public List<Employee> getEmployeeListByManager(int role_id);
	
	// get information for a specific employee
	public Employee getEmployeeById(int id);
	
	// update employee info
	public Employee updateEmployeeInfo();
	
	
	 

}
