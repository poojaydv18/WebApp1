package com.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Model.Order;
import com.Model.Registration;
import com.dao.DBApplication;

/**
 * Servlet implementation class DisplayOrderServlet
 */
public class DisplayOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOrderServlet() {
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
		System.out.println("dsplayserv1");
		DBApplication db=new DBApplication();
		List<Order> lst=db.getAllOrderData();
		System.out.println("dsplayserv2");
	/*	pw.print("<table>");
		for(Register r:lst)
		{
	pw.print("<tr><td>"+r.getFname()+"</td><td>"+r.getRno()+"</td><tr>");
		}
		pw.println("</table>")
		*/
		
		
		
		
		/*HttpSession session=request.getSession(true);
		session.setAttribute("data",lst);
		response.sendRedirect("DisplayAll.jsp");
	*/
	
request.setAttribute("ordlist",lst);
javax.servlet.RequestDispatcher view = request.getRequestDispatcher("DisplayOrder.jsp");
view.forward(request, response);
	}

	}


