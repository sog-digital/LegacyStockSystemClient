package com.sogeti.digital.lss.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainScreen
 */
@WebServlet("/MainScreen")
public class WelcomeServlet extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            //out.println("<h2>Welcome user your email is:  "+ request.getParameter("email") +"</h2>");
        	
        	  RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
              rd.include(request, response);
        	
        } finally {            
            out.close();
        }
	}

}
