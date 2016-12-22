package com.employeejsp;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Insert
 */
//@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		String employeeId=request.getParameter("employeeId");
		String employeeName=request.getParameter("employeeName");
		String employeeSalary=request.getParameter("employeeSalary");
		String employeeLocation=request.getParameter("employeeLocation");
		String employeeExp=request.getParameter("employeeExp");
		double salary;
		int exp;
		try
		{
		 salary=Double.parseDouble(employeeSalary);
		 exp=Integer.parseInt(employeeExp);
		}
		catch(Exception e)
		{
			salary=0.0;
			exp=0;
		}
		
		EmployeeBean employeeBean=new EmployeeBean();
		employeeBean.setEmployeeId(employeeId);
		employeeBean.setEmployeeName(employeeName);
		employeeBean.setEmployeeSlary(salary);
		employeeBean.setEmployeeExp(exp);
		employeeBean.setEmployeeLoc(employeeLocation);
		
		
		DAOOperations dao=new DAOOperations();
		int result=dao.insertData(employeeBean);
		
		RequestDispatcher requestDispact=request.getRequestDispatcher("Success.jsp");
		
		HttpSession session=request.getSession();
		session.setAttribute("employeeId", employeeId);
		
		if(result>0)
		{
			requestDispact.forward(request, response);
		}
		
		
		
		
		
		
	
	}

}
