package com.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		getParameter(request, out);
		out.println("<br/>");
		getParameterNames(request, out);
		out.println("<br/>");
		getParameterMap(request, out);
	}

	private void getParameterMap(HttpServletRequest request, PrintWriter out) {
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNamesSet = paramMap.keySet();
		out.println("<h3>Reading QueryString data using 'String getParameterMap(String name)' method</h3>");
		out.println("<div>");
		
		for (String paramName : paramNamesSet) {
			String[] paramValues = paramMap.get(paramName);
			out.println("<p>" + paramName + " : ");

			for (int i = 0; i < paramValues.length; i++) {
				out.println(paramValues[i]);
			}

			out.println("</p>");
		}
		
		out.println("</div>");
	}

	private void getParameter(HttpServletRequest request, PrintWriter out) {
		out.println("<h3>Reading QueryString data using String getParameter(String name) method :</h3>");
		out.println("<div>");
		out.println(" <p>First Name: " + request.getParameter("firstName") + "</p>");
		out.println(" <p>Last Name: " + request.getParameter("lastName") + "</p>");
		out.println("</div>");
	}

	private void getParameterNames(HttpServletRequest request, PrintWriter out) {
		Enumeration<String> paramNames = request.getParameterNames();

		out.println("<h3>Reading QueryString data using 'String getParameterNames(String name)' method</h3>");
		out.println("<div>");
		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p> ParamName :" + paramName + " ParamValue :" + paramValue);
		}
		out.println("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
