package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.util.ConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String filename = "connection.properties";

	@Override
	public List<Employee> getEmployeeListByManager(int r_id) {
		List <Employee> employeeList = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * "
					+ "FROM FAKECO_EMPLOYEES "
					+ "WHERE ROLE_ID > ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int employee_id = rs.getInt("EMPLOYEE_ID");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int role_id = rs.getInt("ROLE_ID");
				String username = rs.getString("USERNAME");
				String pass = rs.getString("PASS");
				employeeList.add(new Employee(employee_id, firstName, lastName, email, role_id, username, pass));
		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = null; 
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = 
					"SELECT * " 
					+ "FROM FAKECO_EMPLOYEES " 
					+ "WHERE E.EMPLOYEE_ID = ? "
					+ "ORDER BY E.EMPLOYEE_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					int employeeId = rs.getInt("EMPLOYEE_ID");
					String firstName = rs.getString("FIRSTNAME");
					String lastName = rs.getString("LASTNAME");
					String email = rs.getString("EMAIL");
					int role_id = rs.getInt("ROLE_ID");
					String username = rs.getString("USERNAME");
					String pass = rs.getString("PASS");
					e = new Employee(employeeId, firstName, lastName, email, role_id, username, pass);
				}
			} catch (SQLException s) {
				s.printStackTrace();
			} catch (IOException i) {
				i.printStackTrace();
			}
			
		
		return e;
	}

	@Override
	public Employee updateEmployeeInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}

