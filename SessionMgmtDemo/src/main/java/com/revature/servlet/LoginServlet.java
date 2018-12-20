package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Credentials;
import com.revature.model.User;
import com.revature.service.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	AuthenticationService authService = new AuthenticationService();
	
	// return login page for GET request
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.html").forward(req, resp);

	}
	
	// handling POST request from form on Login page
	// (or anywhere else)
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("handling request...");
		// checks whether a session exists, otherwise creates a new one
		// overloaded version takes a boolean create param, if false it returns null
		// if no session exists for the current request.
		HttpSession session = req.getSession(); 
		resp.setContentType("text/html");
		// grab params from request
		Credentials cred = new Credentials(req.getParameter("username"), req.getParameter("password"));
		// attempting to authenticate the user
		User u = authService.isValidUser(cred);
		// if user is not null, set user information as session attributes
		if (u != null) {
			session.setAttribute("id", u.getId());
			session.setAttribute("username", u.getUsername());
			session.setAttribute("firstname", u.getFirstname());
			session.setAttribute("lastname", u.getLastname());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("problem", null);	
			// redirect user profile page if authenticated
			resp.sendRedirect("profile");
		} else {
			session.setAttribute("problem", "invalid credentials");	
			// send user to login page if authentication fails
			resp.sendRedirect("login");
		}
		
		

	}
	
}
