package com.Controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Order;
import com.Model.Registration;
import com.dao.DBApplication;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String starter=request.getParameter("starter");
		String maincourse=request.getParameter("maincourse");
		String dessert=request.getParameter("dessert");
		
		Order o=new Order();
		System.out.println("saveserv3");
		o.setUsername(username);
		o.setStarter(starter);
		o.setMaincourse(maincourse);
		o.setDessert(dessert);
		System.out.println("saveserv4");
		
		DBApplication db=new DBApplication();
		List<Order> lst=new LinkedList<Order>();
		lst.add(o);
		System.out.println("test1");
		int i=db.saveOrderData(lst);
		System.out.println("test2 iw value"+i);
		if(i>0)
		{
			System.out.println("test3");
			response.sendRedirect("Congratulation.jsp");
		}
		System.out.println("test4");		
	}

	}

