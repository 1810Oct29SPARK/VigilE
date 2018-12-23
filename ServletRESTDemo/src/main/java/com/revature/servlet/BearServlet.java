package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.revature.beans.Bear;
import com.revature.service.BearService;
import com.revature.service.BearServiceImpl;

/**
 * Servlet implementation class BearServlet
 */
public class BearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectMapper om;
	private BearService bearService;

	/**
	 * Default constructor.
	 */
	public BearServlet() {
		bearService = new BearServiceImpl();
		om = new ObjectMapper();
		om.registerModule(new JavaTimeModule());
		om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// check whether uri was "bear" or "bears"
		// note: if we had more than two choices, we should ABSOLUTELY use a front
		// controller pattern
		// or some sort of helper class
		System.out.println(request.getRequestURI());
		switch (request.getRequestURI()) {
		case "/ServletRESTDemo/bear":
			//watch out! Should do some other validation. 
			int id = Integer.parseInt(request.getParameter("id"));
			response.getWriter().write(om.writeValueAsString(bearService.getBearById(id)));
			break;
		case "/ServletRESTDemo/bears":
			response.getWriter().write(om.writeValueAsString(bearService.allBears()));
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bearService.createBear(om.readValue(request.getReader(), Bear.class));
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bearService.updateBear(om.readValue(request.getReader(), Bear.class));
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		bearService.deleteBear(om.readValue(request.getReader(), Bear.class));
	}

}
