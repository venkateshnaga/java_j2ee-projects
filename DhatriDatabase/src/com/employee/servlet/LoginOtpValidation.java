package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginOtpValidation
 */
@WebServlet("/LoginOtpValidation")
public class LoginOtpValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginOtpValidation() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String systemgeneratedotp=(String)session.getAttribute("systemgeneratedotp");
		String clientotp=request.getParameter("clientotp");
		String employeeid=(String)session.getAttribute("employeeid");
		out.print(employeeid);
		if(systemgeneratedotp!=null)
		{
		if(systemgeneratedotp.equals(clientotp))
		{
			session.setAttribute("employeid",employeeid);
			RequestDispatcher requestDis=request.getRequestDispatcher("employeeprofile.jsp");
			requestDis.forward(request, response);	
			
		}
		else
		{
			out.print(employeeid);
			out.print("<html><body align='center'>");
			out.print("<form action='index.html' method='post'"+ ">");
			out.print("<br>");
			out.print("<input type='submit' value='GoTo Login Page'>");
			out.print("</form></body></html>");
		}
		}
		else
		{
			out.print("Session Expired");
			out.print("<html><body align='center'>");
			out.print("<form action='index.html' method='post'"+ ">");
			out.print("<br>");
			out.print("<input type='submit' value=' GoTo Login Page '>");
			out.print("</form></body></html>");
		}
	}
}
