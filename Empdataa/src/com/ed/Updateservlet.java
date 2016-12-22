package com.ed;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Updateservlet
 */
@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet
{
	Connection connection=null;
	PreparedStatement pst=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateservlet() {
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
		String eid=request.getParameter("eidu");
		String ename=request.getParameter("enameu");
		String esal=request.getParameter("esalu");
		String eloc=request.getParameter("elocu");
		String eexp=request.getParameter("eexpu");
		db.setEid(eid);
		db.setEname(ename);
		db.setEsal(esal);
		db.setEloc(eloc);
		db.setEexp(eexp);
		
		try{
			
			pst = connection.prepareStatement("update empdata set ename=?,esal=?,eloc=?,eexp=? where Eid=?");
				  
				
				pst.setString(1,db.getEname());  
				pst.setString(2,db.getEsal());  
				pst.setString(3,db.getEloc()); 
				pst.setString(4,db.getEexp()); 
				pst.setString(5,db.getEid());  
				
				int i=pst.executeUpdate();  
				
			out.print("Successfully Updated");	
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
