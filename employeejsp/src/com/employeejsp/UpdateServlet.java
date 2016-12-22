package com.employeejsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("id");
		String ename=request.getParameter("name");
		String esal=request.getParameter("sal");
		String eexp=request.getParameter("exp");
		String eloc=request.getParameter("loc");
		double sal;
		double exp;
		try
		{
			sal=Double.parseDouble(esal);
			exp=Double.parseDouble(eexp);
		
		}
		catch(Exception m)
		{
			sal=0.0;
			exp=0.0;
		}
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmployeeId(eid);
		employeeBean.setEmployeeName(ename);
		employeeBean.setEmployeeSlary(sal);
		employeeBean.setEmployeeExp(exp);
		employeeBean.setEmployeeLoc(eloc);
		
		
		DAOOperations dbo=new DAOOperations();
		
		int result=dbo.update(employeeBean);
		out.print(result);
/*
		RequestDispatcher requestDispact=request.getRequestDispatcher("Success.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("id", eid);
		
		if(result>0)
		{
			requestDispact.forward(request, response);
		}*/
		
	}

}
