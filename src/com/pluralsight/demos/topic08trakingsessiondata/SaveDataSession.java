package com.pluralsight.demos.topic08trakingsessiondata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaveDataSession
 */
@WebServlet("/SaveDataSession")
public class SaveDataSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveDataSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String guestName = (String) session.getAttribute("guestName");
		String email = (String) session.getAttribute("email");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
				
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Guest Details </h3>");
		out.println("<p>Guest Name : " + guestName);
		out.println("<p>Email Id : " + email);
		out.println("</body>");
		out.println("</html>");
	}

}
