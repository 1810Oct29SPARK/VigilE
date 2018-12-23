package com.revature.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Reimbursement;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementDAOImpl;

@WebServlet("/reimbursements")
public class ReimbursementServlet extends HttpServlet {
	
	ReimbursementDAO reimbDAO = new ReimbursementDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(false);
		
		
		if (ses != null) {
			List <Reimbursement> reimbList = reimbDAO.getAllReimbursements();
			System.out.println(reimbList);
			response.getWriter().write(new ObjectMapper().writeValueAsString(reimbList));
			
		} else {
			response.getWriter().write("{\"session\": null}");
		}

	}
}
