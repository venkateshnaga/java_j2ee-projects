package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Otpservlet
 */
@WebServlet("/Otpservlet")
public class Otpservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Otpservlet() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		String rotp=(String)session.getAttribute("otp");
		String lotp=request.getParameter("loginotp");
		
		if(rotp==lotp)
		{
			out.print("Please Enter Correct Input");
			out.print("<html><body align='center'>");
			out.print("<form action='index.html' method='post'"+ ">");
			out.print("<br>");
			out.print("<input type='submit' value='Back'>");
			out.print("</form></body></html>");
		}
		else
		{
			out.print("Please Enter wrong  Input");
			out.print("Please Enter wrong  Input");
			out.print("<html><body align='center'>");
			out.print("<form action='index.html' method='post'"+ ">");
			out.print("<br>");
			out.print("<input type='submit' value='Back'>");
			out.print("</form></body></html>");
		}
	}

}
