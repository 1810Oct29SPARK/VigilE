package com.revature.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1206242231575746111L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forward the request (pass the request onto another request handler) 
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// obtain request parameters
		Double answer = 0.0;
		String error = "";
		// null check
		String paramN1 = req.getParameter("n1");
		String paramN2 = req.getParameter("n2");
		String operation = req.getParameter("operation");
		
		if (paramN1 != null && paramN2 != null && operation != null) {
			Double n1 = Double.parseDouble(paramN1);
			Double n2 = Double.parseDouble(paramN2);
			
			// calculate answer
			switch (operation) {
			case "add":
				answer = n1 + n2;
				break;
			case "subtract":
				answer = n1 - n2;
				break;
			case "multiply":
				answer = n1 * n2;
				break;
			case "divide":
				answer = n1 / n2;
				break;
			default:
				error = "Invalid argument";
			
			}
		} else {
			error = "Please enter all operands";
		}
		
		// include answer in response
		/*
		PrintWriter pw = resp.getWriter();
		pw.write("The answer is: " + answer);
		*/
		
		req.setAttribute("answer", answer);
		req.setAttribute("error", error);
		
		// pass along these attributes to another servlet
		
		RequestDispatcher rd = req.getRequestDispatcher("result");
		rd.forward(req, resp);
		
	}

}
