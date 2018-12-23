package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.BearService;
import com.revature.service.BearServiceImpl;

/**
 * Servlet implementation class BearServlet
 */
public class BearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BearService bearService = new BearServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO check where id is specified
		response.getWriter().append("tbd");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
