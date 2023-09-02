package or.repository;

import org.model.Contact;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class contactrepository {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	public contactrepository() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook","root","Pruthvi@123");
		}
		catch(Exception ex) {}
	}
	
	
	public int issavecontact(Contact c) {
		try {
			stmt=conn.prepareStatement("select * from contact where email=? and contact=?");
			stmt.setString(1, c.getEmail());
			stmt.setString(2, c.getnumber());
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				return -1;
			}
			else {
			
			stmt=conn.prepareStatement("insert into contact values('0',?,?,?,?,?)");
			stmt.setString(1, c.getName());
			stmt.setString(2, c.getEmail());
			stmt.setString(3, c.getnumber());
			stmt.setString(4, c.getAddress());
			stmt.setDate(5, Date.valueOf(c.getDob()));
			int value=stmt.executeUpdate();
			if(value>0) {
				return 1;
			}
			else {
				return 0;
			}
				
			}
		
		}
		catch(Exception ex) {
			
		}
		return 0;
	}
	
	public boolean isemailindata(String email) {
		try {
			stmt=conn.prepareStatement("select * from contact where email=?");
			stmt.setString(1,email);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception ex) {
			System.out.println("error is"+ex);
			return false;
			
		}
	}
	
	public List<Contact> getallcontact(){
		ArrayList<Contact> list;
		try {
			 list = new ArrayList<Contact>();
			 
			 stmt=conn.prepareStatement("select * from contact");
			 rs=stmt.executeQuery();
			 while(rs.next()) {
				 Contact c1= new Contact();
			    c1.setId(rs.getInt(1));
			    c1.setName(rs.getString(2));
			    c1.setEmail(rs.getString(3));
			    c1.setnumber(rs.getString(4));
			    c1.setAddress(rs.getString(5));
			    c1.setDob(rs.getString(6));
			    list.add(c1);
			    
				 
			 }
		}
		catch(Exception ex) {
			return null;
		}
		return list;
	}
	public boolean deletecon(int id) {
		try {
			stmt=conn.prepareStatement("delete from contact where id=?");
			stmt.setInt(1, id);
			int value=stmt.executeUpdate();
		if(value>0) {
			return true;
		}
		else {
			return false;
		}
		
		
		}
		catch(Exception ex) {
			return false;
		}
		
		
	}
	public List<Contact> serachcontbyname(String data) {
		ArrayList<Contact> list;
		try {
			 list = new ArrayList<Contact>();
			 
			 stmt=conn.prepareStatement("select * from contact where name like'"+data+"%'");
			 rs=stmt.executeQuery();
			 while(rs.next()) {
				 Contact c1= new Contact();
			    c1.setId(rs.getInt(1));
			    c1.setName(rs.getString(2));
			    c1.setEmail(rs.getString(3));
			    c1.setnumber(rs.getString(4));
			    c1.setAddress(rs.getString(5));
			    c1.setDob(rs.getString(6));
			    list.add(c1);
			    
				 
			 }
		}
		catch(Exception ex) {
			return null;
		}
		return list;
		
		
		
	}

}
