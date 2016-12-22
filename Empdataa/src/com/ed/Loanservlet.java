package com.ed;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loanservlet
 */
@WebServlet("/Loanservlet")
public class Loanservlet extends HttpServlet 
{
	Connection connection=null;
	PreparedStatement pst=null;
	ResultSet rset=null;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loanservlet() {
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
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		ArrayList<Data> al=new ArrayList<Data>();
		Data db=null;		
		String tempid=request.getParameter("tempid");
		double exp;
		double salary;
		String query="select * from empdata where eid=?";
		try 
		{
			pst=connection.prepareStatement(query);
			pst.setString(1, tempid);
			rset=pst.executeQuery();

			while(rset.next())
			{
				db=new Data();
				db.setEid(rset.getString(1));
				db.setEname(rset.getString(2));
				db.setEsal(rset.getString(3));
				db.setEloc(rset.getString(4));
				db.setEexp(rset.getString(5));
				db.setEloan(rset.getDouble(6));
				db.setEemi(rset.getDouble(7));
				al.add(db);
			}
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<Data> it=al.iterator();
		Data ee=null;
		exp=Double.parseDouble(db.getEexp());
		salary=Double.parseDouble(db.getEsal());
		
		while(it.hasNext())
		{
			
		ee=(Data)it.next();
		if(exp>2 && exp<5)
		{
			double insal=salary/2;
			ee.setEloan(insal);
			out.print("You Are Eligible For Loan"+ insal);
			double emi=((ee.getEloan()*0.14+ee.getEloan())/9);
			ee.setEemi(emi);
			out.print("You Emi"+ emi);
		}
		else
		{
			out.print("Not eligible for loan");
		}
		try 
		{
			String query1="update empdata set eloan=?,eemi=? where eid=?";
			pst=connection.prepareStatement(query1);
			pst.setDouble(1, ee.getEloan());
			pst.setDouble(2, ee.getEemi());
			pst.setString(3, tempid);
			int x=pst.executeUpdate();
			
		}
		catch (SQLException e) 
		{
		e.printStackTrace();
		}
	}
		out.print("<html><body>");
		out.print("<form action='index.html' "+ ">");
		out.print("<input type='submit' value='Go'>");
		out.print("</form></body></html>");
	
	}
		
}


