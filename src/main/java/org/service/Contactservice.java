package org.service;

import java.util.List;

import org.model.Contact;


import or.repository.contactrepository;

public class Contactservice {
	contactrepository cr=new contactrepository();
   public int iscontactsave(Contact contact) {
	  
	   return cr.issavecontact(contact);
   }
   
   
   
   
   
   public boolean isemailpresent(String email) {
	   return cr.isemailindata(email);
   }
   public List<Contact> getallcon(){
	   return cr.getallcontact();
   }
   public boolean deletecon(int id) {
	   return cr.deletecon(id);
   }





public List<Contact> getuserdatabysearch(String userdata) {
	
	return cr.serachcontbyname(userdata);
}
     
   





}
