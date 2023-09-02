package org.techhub;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Validateserve
 */
@WebServlet("/Valid")
public class Validateserve extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("name");
		String password=request.getParameter("pass");
		if(username.equals("admin")&&password.equals("admin")) {
			RequestDispatcher r=request.getRequestDispatcher("master.html")	;	
		   r.forward(request, response);	
		}
		else {
			
			RequestDispatcher r=request.getRequestDispatcher("login.html");
			r.include(request, response);
			out.println("<h1>invalid user name or pass</h1>");
		}
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
