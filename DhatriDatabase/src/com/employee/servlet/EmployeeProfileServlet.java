package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.bean.EmployeeBean;
import com.employee.bean.EmployeeCompanyBean;
import com.employee.dbo.Dboperations;

/**
 * Servlet implementation class EmployeeProfileServlet
 */
@WebServlet("/EmployeeProfileServlet")
public class EmployeeProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeProfileServlet() {
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
	 
	 String empid=(String)session.getAttribute("empid");
	 //String eid="DS--139";
	 
	 if(empid!=null)
	 {
		 ArrayList<EmployeeBean> emplist=new ArrayList<EmployeeBean>();
		 ArrayList<EmployeeCompanyBean> emplist1=new ArrayList<EmployeeCompanyBean>();
		 Dboperations dbo=new Dboperations();
		 emplist=dbo.userprofile(empid);
		 emplist1=dbo.usercompanyprofile(empid);
		 session.setAttribute("employeebeansearch", emplist);
		 session.setAttribute("employeecompanysearch", emplist1);
		 RequestDispatcher ref1=request.getRequestDispatcher("employeeprofileview.jsp");
		 ref1.forward(request, response);
	 }
	 else
	 {
		 RequestDispatcher ref=request.getRequestDispatcher("employeeprofile.jsp");
		 ref.include(request, response);
		 out.print("Wrong");
	 }
	 
	 
	 
	 LocalDate today = LocalDate.now();
		LocalDate birthday = LocalDate.of(1993, Month.JANUARY, 1);
		 
		Period period = Period.between(birthday, today);
		 
		//Now access the values as below
		System.out.println(period.getDays());
		System.out.println(period.getMonths());
		System.out.println(period.getYears());
	}

}
