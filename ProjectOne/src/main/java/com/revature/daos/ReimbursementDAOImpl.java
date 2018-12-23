package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDAOImpl implements ReimbursementDAO {

	private static final String filename = "connection.properties";
	
	private EmployeeDAO eDAO = new EmployeeDAOImpl();
	private StatusDAOImpl statDAO = new StatusDAOImpl();

	@Override
	public Reimbursement newReimbursement(Reimbursement r) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "INSERT INTO REIMBURSEMENTS (REIMBURSEMENT_ID, REIMBURSEMENT_AMOUNT, REIMBURSEMENT_DESCRIPTION, EMPLOYEE_ID, REIMBURSEMENT_STATUS, REIMBURSEMENT_RESOLVER) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, r.getReimb_id());
			pstmt.setDouble(2, r.getAmount());
			pstmt.setString(3, r.getDescription());
			pstmt.setInt(4, r.getEmployee_id().getId());
			pstmt.setInt(5, r.getStat().getId());
			pstmt.setInt(6, r.getReimb_resolver().getId());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Reimbursement updateReimbursement(Reimbursement reimb, int reimb_stat, int reimb_resolver) {

		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "UPDATE REIMBURSEMENTS " +
							"SET REIMBURSEMENT_RESOLVER = ?, REIMBURSEMENT_STATUS = ?" +
							"WHERE REIMBURSEMENT_ID = ?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reimb_resolver);
			pstmt.setInt(2, reimb_stat);
			pstmt.setInt(3, reimb.getReimb_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Reimbursement deleteReimbursement(int id) {
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "DELETE FROM REIMBURSEMENTS " +
							"WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		List <Reimbursement> reimbList = new ArrayList <Reimbursement>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			
			// "SELECT R.REIMB_ID, R.REIMB_AMOUNT, R.REIMB_DESC, R.EMPLOYEEID, E.FIRSTNAME, E.LASTNAME, R.REIMB_STATUS, S.STATUS_TITLE, R.REIMB_RESOLVER " + 
			// "FROM REIMBURSEMENTS R INNER JOIN EMPLOYEE E ON R.EMPLOYEEID = E.EMPLOYEEID " +
			// "INNER JOIN REIMB_STATUS S ON R.REIMB_STATUS = S.STATUS_ID ORDER BY R.REIMB_ID";
			
//			"SELECT REIMB.REIMBURSEMENT_ID, REIMB.REIMBURSEMENT_AMOUNT, REIMB.REIMBURSEMENT_DESCRIPTION, REIMB.EMPLOYEE_ID, EMP.FIRSTNAME, EMP.LASTNAME, REIMB.REIMBURSEMENT_STATUS, STATUS.STATUS_TITLE, REIMB.REIMBURSEMENT_RESOLVER\n" + 
//			"FROM REIMBURSEMENTS REIMB INNER JOIN FAKECO_EMPLOYEES EMP ON REIMB.EMPLOYEE_ID = EMP.EMPLOYEE_ID \n" + 
//			"INNER JOIN REIMBURSEMENT_STATUS STATUS ON REIMB.REIMBURSEMENT_STATUS = STATUS.STATUS_ID\n" + 
//			"ORDER BY REIMB.REIMBURSEMENT_ID";
			
			String sql = "SELECT REIMB.REIMBURSEMENT_ID, REIMB.REIMBURSEMENT_AMOUNT, REIMB.REIMBURSEMENT_DESCRIPTION, REIMB.EMPLOYEE_ID, EMP.FIRSTNAME, EMP.LASTNAME, REIMB.REIMBURSEMENT_STATUS, STATUS.STATUS_TITLE, REIMB.REIMBURSEMENT_RESOLVER \n" + 
					"FROM REIMBURSEMENTS REIMB INNER JOIN FAKECO_EMPLOYEES EMP ON REIMB.EMPLOYEE_ID = EMP.EMPLOYEE_ID \n" + 
					"INNER JOIN REIMBURSEMENT_STATUS STATUS ON REIMB.REIMBURSEMENT_STATUS = STATUS.STATUS_ID\n" + 
					"ORDER BY REIMB.REIMBURSEMENT_ID";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int reimb_Id = rs.getInt("REIMBURSEMENT_ID");
				double reimb_amount = rs.getDouble("REIMBURSEMENT_AMOUNT");
				String reimb_desc = rs.getString("REIMBURSEMENT_DESCRIPTION");
				int emp_id = rs.getInt("EMPLOYEE_ID");
				int statusNum = rs.getInt("REIMBURSEMENT_STATUS");
				int resolver = rs.getInt("REIMBURSEMENT_RESOLVER");
				reimbList.add(new Reimbursement(reimb_Id, reimb_amount, reimb_desc, eDAO.getEmployeeById(emp_id), statDAO.getStatusById(statusNum), eDAO.getEmployeeById(resolver)));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reimbList;
	}

	@Override
	public Reimbursement getReimbursementById(int id) {
		Reimbursement reimbursement = null;
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT FROM REIMBURSEMENTS WHERE REIMBURSEMENT_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(); 
			while (rs.next()) {
				int reimb_Id = rs.getInt("REIMBURSEMENT_ID");
				double reimb_amount = rs.getDouble("REIMBURSEMENT_AMOUNT");
				String reimb_desc = rs.getString("REIMBURSEMENT_DESCRIPTION");
				int emp_id = rs.getInt("EMPLOYEE_ID");
				int statusNum = rs.getInt("REIMBURSEMENT_STATUS");
				int resolver = rs.getInt("REIMBURSEMENT_RESOLVER");
				reimbursement = (new Reimbursement(reimb_Id, reimb_amount, reimb_desc, eDAO.getEmployeeById(emp_id), statDAO.getStatusById(statusNum), eDAO.getEmployeeById(resolver)));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> getEmployeeReimbursements(Employee e) {
		List <Reimbursement> reimbList = new ArrayList <Reimbursement>();
		try (Connection con = ConnectionUtil.getConnection(filename)) {
			String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMPLOYEE_ID = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, e.getId());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reimb_Id = rs.getInt("REIMBURSEMENT_ID");
				double reimb_amount = rs.getDouble("REIMBURSEMENT_AMOUNT");
				String reimb_desc = rs.getString("REIMBURSEMENT_DESCRIPTION");
				int emp_id = rs.getInt("EMPLOYEE_ID");
				int statusNum = rs.getInt("REIMBURSEMENT_STATUS");
				int resolver = rs.getInt("REIMBURSEMENT_RESOLVER");
				reimbList.add(new Reimbursement(reimb_Id, reimb_amount, reimb_desc, eDAO.getEmployeeById(emp_id), statDAO.getStatusById(statusNum), eDAO.getEmployeeById(resolver)));
			} 
		} catch (SQLException s) {
			s.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return reimbList;
	}

	

	
}


