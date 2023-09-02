package org.addnewcontact;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.Contact;
import org.service.Contactservice;

/**
 * Servlet implementation class Addnewcontact
 */
@WebServlet("/Addnew")
public class Addnewcontact extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head><title> add new contact</title> ");
		out.println("<script src='js/validate.js' type='text/javascript'></script>");
		out.println("<link rel='stylesheet' href='css/addcontact.css'/>");
		out.println("</head>");
		//RequestDispatcher r=request.getRequestDispatcher("master.html");
		//r.include(request, response);
		out.println("<body><div class='frm'><form name='frm' action='' method='post'><table>");
	    // out.println("<form name='form' action='contodata' method='get'>");
	     	
		out.println("<tr><td><b>Name</b>:</td><td><input type='text' name='name' id='name' value='' class='control' onkeyup='validatename(this.value)'>&nbsp;<span id='span'></span></td></tr>");
		out.println("<tr><td><b>Email</b>:</td><td><input type='email' name='email' value='' class='control' onkeyup='validateemail(this.value)'onblur='ajaxcall(this.value)'>&nbsp;<span id='e'></span><span id='e1'></span></td></tr>");
		out.println("<tr><td><b>Number</b>:</td><td><input type='text' name='number' id='num' value='' class='control' onkeyup='validatenumber(this.value)'>&nbsp;<span id='nu'></span></td></tr>");
		out.println("<tr><td><b>Address</b>:</td><td><input type='text' name='address' value='' class='control'></td></tr>");
		out.println("<tr><td><b>DOB</b>:</td><td><input type='date' name='dob' value='' class='control'></td></tr>");
		out.println("<tr><td colspan='3' align=\"center\"><input type='submit' name='s' value='Add To Contact' class='control'></td></tr>");
		out.println("</table></form></div>");
		
		String button=request.getParameter("s");
		if(button!=null) {
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String number=request.getParameter("number");
			String address=request.getParameter("address");
			String dob=request.getParameter("dob");
			Contact c=new Contact();
			c.setName(name);
			c.setEmail(email);
			c.setnumber(number);
			c.setAddress(address);
			c.setDob(dob);
			Contactservice ct=new Contactservice();
			int b=ct.iscontactsave(c);
			if(b==1) {
				out.println("new contact created");
			}
			else if(b==-1) {
				out.println("contact already present..");
			}
			else {
				out.println("problemmmmmmm");
			}
		}
		
		out.println("</body>");
		
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
