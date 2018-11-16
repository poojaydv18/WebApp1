package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.Model.Order;
import com.Model.Registration;

import oracle.jdbc.util.Login;
public class DBApplication {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	public Connection myConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","newuser123");
		System.out.println("CONNECTION DONE");
		}
		catch(Exception e)
		{
			System.out.println(e);
			System.out.println("CONNECTION NOT DONE");
		}
		return con;
	}
	public int saveData(List<Registration> lst)
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Registration a=null;
		con=myConnection();
		try
		{
			Iterator<Registration> itr=lst.iterator();
			System.out.println("dbsave2");
			while(itr.hasNext())
			{
				System.out.println("dbsave3");
				a=itr.next();
				ps=con.prepareStatement("insert into CUSTOMER_DETAILS values(?,?,?,?,?,?,?)");
				ps.setString(1,a.getUsername());
				ps.setString(2,a.getPassword());
				ps.setString(3,a.getAddress());
				ps.setString(4,a.getCityname());
				ps.setString(5,a.getStatename());
				ps.setDouble(6,a.getPhone());
				ps.setString(7,a.getEmail());	
				i = ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
System.out.println("NO ENTRY");
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public int saveOrderData(List<Order> lst)
	{
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Order a=null;
		con=myConnection();
		try
		{
			Iterator<Order> itr=lst.iterator();
			System.out.println("dbsave21");
			while(itr.hasNext())
			{
				System.out.println("dbsave23");
				a=itr.next();
				ps=con.prepareStatement("insert into ORDER_DETAILS values(?,?,?,?)");
				ps.setString(1,a.getUsername());
				ps.setString(2,a.getStarter());
				ps.setString(3,a.getMaincourse());
				ps.setString(4,a.getDessert());
				i = ps.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
System.out.println("NO ENTRY");
		}
		finally
		{
			try
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return i;
	}
	
	
	
	public List<Registration> getAllUserData()
	{
		List<Registration> lst=new LinkedList<Registration>();
		con=myConnection();
		try
		{
		Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from CUSTOMER");
			while(rs.next())
				System.out.println("displaycustomer3");
			{
				Registration a=new Registration();
				a.setUsername(rs.getString(1));
				a.setPassword(rs.getString(2));
				a.setAddress(rs.getString(3));
				a.setCityname(rs.getString(4));
				a.setStatename(rs.getString(5));
				a.setPhone(rs.getDouble(7));
				a.setEmail(rs.getString(8));
				lst.add(a);
				System.out.println("cnt");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			
		}
		return lst;
	}
	public List<Order> getAllOrderData()
	{
		List<Order> lst=new LinkedList<Order>();
		con=myConnection();
		try
		{
		Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from CUSTOMER_ORDER");
			while(rs.next())
			{
				Order a=new Order();
				a.setUsername(rs.getString(1));
			a.setStarter(rs.getString(2));
			a.setMaincourse(rs.getString(3));
			a.setDessert(rs.getString(4));
				
				lst.add(a);
				System.out.println("cntaa");
			}
			
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
	
	
	
	public boolean checkLogin(String username,String password){
		boolean status=false;
		System.out.println("dbsave1");
		//Account a=lst.get(0);
		Registration a=null;
		System.out.println("check login3");

		con=myConnection();
		System.out.println("check login4");

		try {
			PreparedStatement ps=con.prepareStatement("Select * from CUSTOMER_DETAILS where username = ? and password =?");
			ps.setString(1,username);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			System.out.println("check login5");

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("check login6");

		}
		return status;
	}
	public boolean checkAdminLogin(String username,String password){
		boolean status=false;
		System.out.println("dbsave1");
		int i=0;
		//Account a=lst.get(0);
		Registration a=null;
		con=myConnection();
		try {
			PreparedStatement ps=con.prepareStatement("Select * from ADMIN_DETAILS where username = ? and password =?");
			ps.setString(1,username);
			ps.setString(2,password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	
	
	/*public boolean validateUser(Login l)
	{
		myConnection();
		List<Registration> lst=getAllData();
		boolean b=false;
		for(Registration r:lst)
		{
			if(r.getRno()==l.getRno())
			{
				if(r.getpassword().equals(l.getpassword()))
				{
					b=true;
					break;
				}
			}
		}
		return b;
	}
	*/
}
