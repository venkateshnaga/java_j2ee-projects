package com.ss;

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
 * Servlet implementation class Reg
 */
@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
        super();
        // TODO Auto-generated constructor stub
    }

    Connection con=null;
    PreparedStatement pst=null;
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
		// TODO Auto-generated method stub
		Database db=new Database();
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		String username=request.getParameter("uname");
		String userpwd=request.getParameter("upwd");
		String userno=request.getParameter("uno");
		String useradd=request.getParameter("uadd");
		db.setUsername(username);
		db.setUserpwd(userpwd);
		db.setUserno(userno);
		db.setUseradd(useradd);
		Connection connection=null;
		PreparedStatement ps=null;
		

		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/naga","root","root");
			ps = connection.prepareStatement("insert into reg1 values(?,?,?,?)");
				  
				ps.setString(1,db.getUsername());  
				ps.setString(2,db.getUserpwd());  
				ps.setString(3,db.getUserno());  
				ps.setString(4,db.getUseradd());  
				
				int i=ps.executeUpdate();  
				
			out.print("Successfully Registered");	
			}
			
			catch (ClassNotFoundException|SQLException e) 
			{
			
				out.print(e);
			}
	/*	out.print("<html><body>");
		out.print("<form action='index.html' "+ ">");
		out.print("<input type='submit' value='Go'>");
		out.print("</form></body></html>");
		*/
		
	}

}
