package com.pluralsight.demos.topic11globalizingservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LanguageSettingsDemo
 */
@WebServlet("/LanguageSettingsDemo")
public class LanguageSettingsDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LanguageSettingsDemo() {
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
		out.println("<title>Detecting Locale </title>");
		out.println("</head>");
		out.println("<body>");

		Locale locale = new Locale("fr");
		out.println("<p>Language Set using Single Parameter : " + locale + "</p>");

		Locale locale2 = new Locale("fr", "CANADA");
		out.println("<p>Language Set using Two Parameters : " + locale2 + "</p>");

		Locale locale3 = new Locale("no", "NORWAY", "NY");
		out.println("<p>Langauge Set using Three Parameters : " + locale3 + "</p>");

		Locale localeFromBuilder = new Locale.Builder().setLanguage("en").setRegion("GB").build();
		out.println("<p>Language Set using Locale Builder: " + localeFromBuilder + "</p>");

		Locale forLangLocale = Locale.forLanguageTag("en-GB");
		out.println("<p>Language Set using Language Tag : " + forLangLocale + "</p>");

		Locale localeConst = Locale.FRANCE;
		out.println("<p>Language Set using Locale Constants : " + localeConst + "</p>");

		out.println("</body>");
		out.println("</html>");
	}

}
