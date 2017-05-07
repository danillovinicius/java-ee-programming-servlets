package com.pluralsight.demos.topic13asyncservletprocessing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProgressAsyncServlet
 */
@WebServlet(urlPatterns = "/ProgressAsyncServlet", asyncSupported = true)
public class ProgressAsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProgressAsyncServlet() {
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
		out.println("<title>Progress Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Entering doGet(), Thread Name : " + Thread.currentThread().getName() + "</p>");
		out.println("<progress id='progress' max='100'> </progress>");
		AsyncContext aContext = request.getAsyncContext();

		aContext.start(() -> {
			out.print("<p>Executing Long Running Task using Thread : " + Thread.currentThread().getName() + "</p>");
			int i = 0;
			while (i <= 100) {
				out.println("<script>document.getElementById('progress').value = '" + i++ + "' ; </script>");
				out.flush();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
				}
			}
			out.println("<p>Completed the long running task... </p>");
			aContext.complete();
		});

		out.println("<p>Exiting doGet(), Thread Name : " + Thread.currentThread().getName() + "</p>");
		out.println("</body>");
		out.println("</html>");
	}

}
