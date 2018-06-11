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

import com.sogeti.digital.lss.model.Product;
import com.sogeti.digital.lss.service.StockServiceImpl;
import com.sogeti.digital.lss.service.StockServiceImplServiceLocator;

/**
 * Servlet implementation class ManageStock
 */
@WebServlet("/ManageStock")
public class ManageStock extends HttpServlet {

	private static final String infoMsgStr = "Your request was successfull.";
	private static final String errorStr = "Sorry! Error in processing your request.";
	private static final String stockNotFoundMsgStr = "Sorry! No records found for your stock search. ";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageStock() {
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

		request.setAttribute("firstname", request.getParameter("firstName"));
		request.setAttribute("lastname", request.getParameter("lastName"));
		request.setAttribute("dob",  request.getParameter("dob"));
		request.setAttribute("personId", request.getParameter("personId"));
		
		int productID = 0;
		
		String productIDParam = request.getParameter("productID");
		
		String findBtnValue = request.getParameter("findStock");
		if (findBtnValue == null || findBtnValue.equals("")) {
			findBtnValue = "-1";
		}
		
		String saveBtnValue = request.getParameter("saveBtn");
		if (saveBtnValue == null || saveBtnValue.equals("")) {
			saveBtnValue = "-1";
		}
		
		String deleteBtnValue = request.getParameter("deleteBtn");
		if(deleteBtnValue == null || deleteBtnValue.equals("")) {
			deleteBtnValue = "-1";
		}
		
		if( productIDParam != null && !productIDParam.equals("null") && productIDParam.length() > 0 ) {
			
			productID = Integer.parseInt(productIDParam);			
		}
		
		String allStocks = request.getParameter("allStocks");
		if( !(allStocks != null && !allStocks.equals("null") && allStocks.length() > 0 ) ) {
			
			allStocks = "";
		}
		

		try {

			StockServiceImplServiceLocator ssl = new StockServiceImplServiceLocator();
			StockServiceImpl ssi = ssl.getStockServiceImpl();
			
		
			if( productID > 0 && findBtnValue.equals("Go") ) {
				// find a stock 
				
				Product product = ssi.getStock(productID);
				
				if( product != null ) {
					
					request.setAttribute("stock", product);
				} else {
					request.setAttribute("infoStr", stockNotFoundMsgStr);
				}
				
			} else if ( allStocks.length() > 0 ) { // Retrieve all stocks
				
				Product[] productList = ssi.getAllTheStocks();
				if(productList != null ) {
					
					request.setAttribute("allStocks", productList);
				} else {
					request.setAttribute("infoStr", stockNotFoundMsgStr);
				}
				
				
			} else if ( productID > 0 && saveBtnValue.equals("Save") ) { // update the stock
				
				Product updateProduct = new Product();
				updateProduct.setId(productID);
				updateProduct.setName(request.getParameter("name"));
				updateProduct.setAmount(Integer.parseInt((String)request.getParameter("amount")));
				updateProduct.setPrice(request.getParameter("price"));
				
				if(ssi.update(updateProduct)) {

					request.setAttribute("infoStr", infoMsgStr);
				} else {	

					request.setAttribute("errorStr", errorStr);
				}
				
				
			} else if( productID > 0 && deleteBtnValue.equals("Delete") ) { // delete the stock
				
				if(ssi.delete(productID)) {
					
					request.setAttribute("infoStr", infoMsgStr);
				} else {	

					request.setAttribute("errorStr", errorStr);
				}
				
			}
			else {
				// create a new stock
				Product product = new Product();
				product.setName(request.getParameter("name"));
				product.setAmount(Integer.parseInt((String)request.getParameter("amount")));
				product.setPrice(request.getParameter("price"));

				if(ssi.create(product)) {

					request.setAttribute("infoStr", infoMsgStr);
				} else {	

					request.setAttribute("errorStr", errorStr);
				}
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
