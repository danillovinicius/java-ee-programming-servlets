package com.pluralsight.demos.topic08trakingsessiondata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Preview() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String guestName = request.getParameter("guestName");
		String email = request.getParameter("email");
		
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Welcome </h3>"+guestName+" - "+email);
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
		String email = request.getParameter("email");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Please confirm your information </p>");
		out.println("<p>Guest Name : " + guestName + "</p>");
		out.println("<p>Email Id : " + email + "</p>");
		out.println("<form name='frm' action='SaveData' method='post'>");
		out.println("<input type='hidden' name='guestName' value='" + guestName + "'/>");
		out.println("<input type='hidden' name='email' value='" + email + "'/>");
		out.println("<p><input type='submit' value='Save Data' name='btnSave' />");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}
}
