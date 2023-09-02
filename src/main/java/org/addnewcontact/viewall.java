package org.addnewcontact;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.model.Contact;
import org.service.Contactservice;


@WebServlet("/view")
public class viewall extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	Contactservice cs=new Contactservice ();
	List<Contact> list =cs.getallcon();
	/*RequestDispatcher r= request.getRequestDispatcher("master.html");
	r.include(request, response);*/
	
	out.println("<br><br>");
	out.println("<html>");
	out.println("<script src='js/validate.js' type='text/javascript'></script>");
	out.println("<body>");
	out.println("<input type='text' name='search' value='' onkeyup='searchname(this.value)'/>");
	out.println("<br><br><div id='d'>");
	out.println("<table border=5>");
	
	out.println("<tr><th>NAME</th><th>email</th><th>CONTACT</th><th>ADRESS</th><th>DOB</th><th>Delete</th><th>update</th></tr>");
       for(Contact c:list) {
    	out.println("<tr>");   
    	out.println("<td>"+c.getName() +"</td>");   
    	out.println("<td>"+ c.getEmail()+"</td>");
    	out.println("<td>"+ c.getnumber()+"</td>");
    	out.println("<td>"+ c.getAddress()+"</td>");   
    	out.println("<td>"+ c.getDob()+"</td>");   
    	out.println("<td><a href='delete?del="+c.getId()+"'>Delete</a></td>");   
    	out.println("<td><a href='update?up="+c.getId()+"'>update</a></td>");   
    	out.println("</tr>");   
        }
       out.println("</table></div></body></html>");
       
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
