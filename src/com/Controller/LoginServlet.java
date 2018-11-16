package com.Controller;

import java.io.IOException;
import java.io.PrintWriter; 
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Registration;
import com.dao.DBApplication;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String username=request.getParameter("username");
			String password=request.getParameter("password");
			System.out.println("check login1");
			
			
			DBApplication db=new DBApplication();
	
			boolean status=db.checkLogin(username,password);
			System.out.println("check login2");

			if(status==true){
				
				System.out.println ("Welcome, "+username);  
		       System.out.println(" Give Your Order...!!!");  

		        HttpSession session=request.getSession();  
		        session.setAttribute("username",username);  
				 
	            response.sendRedirect("Order.jsp");

			}
			else{
				 System.out.println("Sorry, username or password error!");  
				    response.sendRedirect("Login.jsp"); 
				}
				
	}
}