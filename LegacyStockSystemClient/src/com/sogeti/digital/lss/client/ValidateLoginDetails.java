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

import com.sogeti.digital.lss.service.PersonServiceImpl;
import com.sogeti.digital.lss.service.PersonServiceImplServiceLocator;

/**
 * Servlet implementation class ValidateLoginDetails
 */
@WebServlet("/ValidateLoginDetails")
public class ValidateLoginDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateLoginDetails() {
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
	     
	     try {
	    	 String name = request.getParameter("email");
	    	 String password = request.getParameter("pwd");

	    	 PersonServiceImplServiceLocator psl = new PersonServiceImplServiceLocator();
	    	 PersonServiceImpl psi = psl.getPersonServiceImpl();

	    	 if(psi.login(name, password))
	    	 {
	    		 RequestDispatcher rd = request.getRequestDispatcher("Welcome");
	    		 rd.forward(request, response);
	    	 }
	    	 else
	    	 {
	    		 out.println("<font color='red' style='margin-left: 80px;'><b>Sorry! Login details do not match. Please try again.</b></font>");
	    		 RequestDispatcher rd = request.getRequestDispatcher("login.html");
	    		 rd.include(request, response);
	    	 }
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
