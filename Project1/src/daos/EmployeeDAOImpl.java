package daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Employee;
import beans.Employees;
import util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public List<Employee> getEmployeeListByManager(int role_id) {
		List <Employee> employeeList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT EMPLOYEE_ID, FIRSTNAME, LASTNAME  "
					+ "FROM FAKECO_EMPLOYEES "
					+ "WHERE FAKECO_EMPLOYEES.ROLE_ID > FAKECO_ROLES.ROLE_ID" ;
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int employee_id = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String 
				employeeList.add(employee_id, firstName, lastName);
		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = null; 
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = 
					"SELECT EMPLOYEE_ID, FIRSTNAME, LASTNAME, USERNAME, PASS " 
					+ "FROM EMPLOYEES E " 
					+ "WHERE E.EMPLOYEE_ID = ? "
					+ "ORDER BY E.EMPLOYEE_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					int employeeId = rs.getInt("EMPLOYEE_ID");
					String firstName = rs.getString("FIRSTNAME");
					String lastName = rs.getString("LASTNAME");
					String username = rs.getString("USERNAME");
					String pass = rs.getString("PASS");
					e = new Employee(employeeId, firstName, lastName, username, pass);
				}
			} catch (SQLException s) {
				s.printStackTrace();
			} catch (IOException i) {
				i.printStackTrace();
			}
			
		
		return e;
	}

	@Override
	public Employee addEmployee(String first, String last) {
		Employee newEmployee = null; 
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = 
					"INSERT INTO EMPLOYEES E VALUES ?, ? " 
					+ "FROM EMPLOYEES E " 
					+ "WHERE E.EMPLOYEE_ID = ? "
					+ "ORDER BY E.EMPLOYEE_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, first);
			pstmt.setString(2, last);
			ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					int employeeId = rs.getInt("EMPLOYEE_ID");
					String firstName = rs.getString("FIRSTNAME");
					String lastName = rs.getString("LASTNAME");
					String username = rs.getString("USERNAME");
					String pass = rs.getString("PASS");
					newEmployee = new Employee(employeeId, firstName, lastName, username, pass);
				}
			} catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		return newEmployee;
	}

}
