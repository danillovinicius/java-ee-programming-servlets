package com.pluralsight.demos.topic11globalizingservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocaleSpecificDemo
 */
@WebServlet("/LocaleSpecificDemo")
public class LocaleSpecificDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LocaleSpecificDemo() {
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
		
		long number = 5000000L;
		NumberFormat numberFormatDefault = NumberFormat.getInstance();
		out.println("<p>Number Format using Default Locale: " + numberFormatDefault.format(number));
		
		NumberFormat numberFormatLocale = NumberFormat.getInstance(Locale.FRENCH);
		out.println("<p>Number Format using French Locale: " + numberFormatLocale.format(number));
		
		NumberFormat numberFormatDefaultCurrency = NumberFormat.getCurrencyInstance();
		out.println("<p>Currency Format using Default Locale: " + numberFormatDefaultCurrency.format(number));
		
		NumberFormat numberFormatLocaleCurrency = NumberFormat.getCurrencyInstance(Locale.UK);
		out.println("<p>Currency Format using UK Locale: " + numberFormatLocaleCurrency.format(number));
		
		Currency currency = Currency.getInstance(Locale.JAPAN);
		out.println("<p>Currency Format using Japan Locale: " + numberFormatLocaleCurrency.format(number)
				+ "<br>Currency Display Name : " + currency.getDisplayName() + "<br>Currency Code : "
				+ currency.getCurrencyCode());
		
		Date currentDate = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
		out.println("<p>Date Format in French Locale: " + dateFormat.format(currentDate));
		
		out.println("</body>");
		out.println("</html>");

	}

}
