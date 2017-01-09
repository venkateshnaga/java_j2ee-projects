package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.bean.EmployeeBean;
import com.employee.dbo.Dboperations;

/**
 * Servlet implementation class EmployeeUpdateSearchServlet
 */
@WebServlet("/EmployeeUpdateSearchServlet")
public class EmployeeUpdateSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdateSearchServlet() {
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
		String employeeid=(String)session.getAttribute("empid");
		
		
		if(employeeid!=null)
		{
			 ArrayList<EmployeeBean> emplist=new ArrayList<EmployeeBean>();
			 Dboperations dbo=new Dboperations();
			 emplist=dbo.userprofile(employeeid);
			 session.setAttribute("employeelist", emplist);
			 RequestDispatcher ref1=request.getRequestDispatcher("employeeupdateview.jsp");
			 ref1.forward(request, response);
		 }
		 else
		 {
			 RequestDispatcher ref=request.getRequestDispatcher("employeeprofile.jsp");
			 ref.include(request, response);
			 out.print("Wrong");
		}
	
	
	
	
	}

	}
