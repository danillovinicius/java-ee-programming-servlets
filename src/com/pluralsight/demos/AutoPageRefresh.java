package com.pluralsight.demos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoPageRefresh
 */
@WebServlet("/AutoPageRefresh")
public class AutoPageRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoPageRefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		response.setIntHeader("Refresh", 1);
		
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);
		
		if( calendar.get(Calendar.AM_PM)==0)
			am_pm = "am";
		else
			am_pm = "pm";
		
		String currentTime = hour + ":" + min + ":" + sec + " " + am_pm;
		
		PrintWriter out = response.getWriter();
		
		out.println("<!Doctype HTML>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Demo: AutoRefreshPage using Response Headers</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Page Last refreshed at : " + currentTime + "</p>");		
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
