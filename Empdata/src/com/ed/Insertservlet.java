package com.ed;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class Insertservlet
 */
@WebServlet("/Insertservlet")
public class Insertservlet extends HttpServlet 
{
	Connection connection=null;
	PreparedStatement ps=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public Insertservlet() {
        super();
      
    	connection=MyConnection.getInstance().connection;
    	
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Data db=new Data();
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String esal=request.getParameter("esal");
		String eloc=request.getParameter("eloc");
		String eexp=request.getParameter("eexp");
		db.setEid(eid);
		db.setEname(ename);
		db.setEsal(esal);
		db.setEloc(eloc);
		db.setEexp(eexp);
		
		try{
			
			ps = connection.prepareStatement("insert into empdata values(?,?,?,?,?)");
				  
				ps.setString(1,db.getEid());  
				ps.setString(2,db.getEname());  
				ps.setString(3,db.getEsal());  
				ps.setString(4,db.getEloc()); 
				ps.setString(5,db.getEexp()); 
				
				int i=ps.executeUpdate();  
				
			out.print("Successfully Registered");	
			}
			
			catch (SQLException e) 
			{
			
				out.print(e);
			}
		out.print("<html><body>");
		out.print("<form action='index.html' "+ ">");
		out.print("<input type='submit' value='Go'>");
		out.print("</form></body></html>");
		
		
	}
	}


