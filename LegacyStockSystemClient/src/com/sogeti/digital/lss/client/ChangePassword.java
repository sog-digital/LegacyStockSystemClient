package com.sogeti.digital.lss.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.rpc.ServiceException;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.service.PersonServiceImpl;
import com.sogeti.digital.lss.service.PersonServiceImplServiceLocator;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {

	private static final String infoMsgStr = "Your Change Password request was successfull.";
	private static final String errorStr = "Sorry! Error in processing your Change Password request.";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
		 
	    PrintWriter out = response.getWriter();
	    
	    String newpassword = request.getParameter("pwd");
	    String personId = request.getParameter("personId");
	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String dob = request.getParameter("dob");
	    
	    try {

	    	PersonServiceImplServiceLocator psl = new PersonServiceImplServiceLocator();
	    	PersonServiceImpl psi = psl.getPersonServiceImpl();

	    	Person person = new Person();
	    	person.setId(Integer.parseInt(personId));
	    	person.setPassword(newpassword);
	    	
	    	if(psi.changePassword(person)) {
	    		
	    		 request.setAttribute("firstname", firstName);
	    		 request.setAttribute("lastname", lastName);
	    		 request.setAttribute("dob", dob);
	    		 request.setAttribute("personId", personId);
	    		 request.setAttribute("infoStr", infoMsgStr);
	    		 
	    	} else {	
	    		
	    		 request.setAttribute("errorStr", errorStr);
	    	}

   		 RequestDispatcher rd = request.getRequestDispatcher("Welcome");
   		 rd.forward(request, response);


	    } catch(ServiceException se) {
	    	System.out.println("ServiceException " + se.getMessage());
	    } finally {            
	    	out.close();
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
