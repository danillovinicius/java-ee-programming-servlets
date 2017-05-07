package com.pluralsight.demos.topic12metadatausingannotations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloAnnotations
 */
@WebServlet(name = "HelloAnnotations", description = "Demo: @WebServlet Annotation", urlPatterns = {
		"/HelloAnnotations", "/WebServletAnnotationDemo" }, initParams = {
				@WebInitParam(name = "user", value = "dvlima"),
				@WebInitParam(name = "email", value = "email@gmail.com") })
public class HelloAnnotations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloAnnotations() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Providing Servlet Metadata using Annotations </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Welcome to Servlets 3 - Annotations </h3>");

		String ename = getServletConfig().getInitParameter("user");
		String email = getServletConfig().getInitParameter("email");

		out.println("<h4>Reading the values from the InitParams </h4>");
		out.println("<p>Name : " + ename + "</p>");
		out.println("<p>Email : " + email + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
