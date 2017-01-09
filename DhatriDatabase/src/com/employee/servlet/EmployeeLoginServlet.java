package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.employee.autoid.GenerateLoginOtp;
import com.employee.bean.EmployeeBean;
import com.employee.dbo.Dboperations;
import com.employee.mail.LoginOtpMail;

/**
 * Servlet implementation class EmployeeLoginServlet
 */
@WebServlet("/EmployeeLoginServlet")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLoginServlet() {
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
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String employeeid=request.getParameter("employeeid");
		String employeedob=request.getParameter("employeedob");
		
		Dboperations dbo=new Dboperations();
		ArrayList<EmployeeBean> empList=dbo.loginsearch(employeeid);

		session.setAttribute("employeeList", empList);
		
		Object obj=session.getAttribute("employeeList");
		
		ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
		Iterator iterator=employeeList.iterator();
		
		EmployeeBean ub1=null;
		while(iterator.hasNext())
		{
		ub1=(EmployeeBean)iterator.next();
		}
		
		
		String loginotp=GenerateLoginOtp.getGenerateLoginOtp(); 
		
		RequestDispatcher ref=request.getRequestDispatcher("employeelogin.jsp");
		RequestDispatcher ref1=request.getRequestDispatcher("loginotp.jsp");
		
		
		if(employeeid.equals(ub1.getEmpid()) && employeedob.equals(ub1.getDob()))
		{
			String resultMessage = "";
			
			try {
				LoginOtpMail.sendEmail(ub1,loginotp);
				session.setAttribute("systemgeneratedotp",loginotp);
				session.setAttribute("employeeid",employeeid);
				ref1.forward(request, response);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			ref.include(request, response);
			out.print("Wrong Credentials,Try Again");
		}

}
}
