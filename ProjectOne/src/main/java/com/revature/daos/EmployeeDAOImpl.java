package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.User;
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
			while (rs.next()) {
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
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e = null; 
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = 
					"SELECT * " 
					+ "FROM FAKECO_EMPLOYEES " 
					+ "WHERE EMPLOYEE_ID = ? "
					+ "ORDER BY EMPLOYEE_ID";
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
	public Employee updateEmployeeInfo(int id, String password) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = 
					"UPDATE FAKECO_EMPLOYEES " 
					+ "SET PASS = ? " 
					+ "WHERE EMPLOYEE_ID = ? ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, password);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		
	} catch (SQLException s) {
		s.printStackTrace();
	} catch (IOException i) {
		i.printStackTrace();
	}
		return null;
	}

	@Override
	public Employee getEmployeeCreds(String username, String password) {
		Employee emp = null;
		String user = username;
		String pass = password;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT *  "
						+ "FROM FAKECO_EMPLOYEES "
						+ "WHERE USERNAME = ? AND PASS = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("EMPLOYEE_ID");
				String userName = rs.getString("USERNAME");
				String firstName = rs.getString("FIRSTNAME");
				String lastName = rs.getString("LASTNAME");
				String email = rs.getString("EMAIL");
				int role_id = rs.getInt("ROLE_ID");
				String pw = rs.getString("PASS");
				if (user.equals(userName) && pass.equals(pw)) {
				emp = new Employee(id, firstName, lastName, email, role_id, userName, pw );
				return emp;
				}
			}
					
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return null;
	}
}

