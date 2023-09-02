package delete;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.service.Contactservice;


@WebServlet("/delete")
public class deletecontact extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cid=request.getParameter("del");
		Contactservice cs=new Contactservice();
		int id=Integer.parseInt(cid);
		if(cs.deletecon(id)) {
			RequestDispatcher r=request.getRequestDispatcher("view");
			r.include(request, response);  
		}
		else {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
