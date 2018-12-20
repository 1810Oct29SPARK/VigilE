package daos;

import java.util.List;

import beans.Employee;

public interface EmployeeDAO {

	public List<Employee> getEmployeeListByManager(int role_id);
	public Employee getEmployeeById(int id);
	public Employee addEmployee(String firstName, String lastName);
	// How to auto-generate the rest of the information? 
	// I want the username to be firstName.lastName@fakeco.com and 
	// password to be firstInitial_lastName 
	

}
