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

import com.employee.bean.EmployeeBean;
import com.employee.dbo.Dboperations;
import com.employee.mail.LoginOtpMail;
import com.employee.mail.UpdateMail;

/**
 * Servlet implementation class EmployeeUpdateServlet
 */
@WebServlet("/EmployeeUpdateServlet")
public class EmployeeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeUpdateServlet() {
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
		String empid=request.getParameter("eid");
		String empfirstname=request.getParameter("empfirstname");
		String emplastname=request.getParameter("emplastname");
		String empdob=request.getParameter("empdob");
		String empmobileno=request.getParameter("empmobileno");
		String empmailid=request.getParameter("empmailid");
		String empaltermobileno=request.getParameter("empaltermobileno");
		String empaltermailid=request.getParameter("empaltermailid");
		String empprsentaddress=request.getParameter("empprsentaddress");
		String emppermanentaddress=request.getParameter("emppermanentaddress");
		String empfathername=request.getParameter("empfathername");
		String empfatheroccupation=request.getParameter("empmailid");
		
		EmployeeBean empbean=new EmployeeBean();
		empbean.setEmpid(empid);
		empbean.setFname(empfirstname);
		empbean.setLname(emplastname);
		empbean.setDob(empdob);
		empbean.setMobileno(empmobileno);
		empbean.setEmialid(empmailid);
		empbean.setAltmobileno(empaltermobileno);
		empbean.setAltemialid(empaltermailid);
		empbean.setPresentaddress(empprsentaddress);
		empbean.setPermanentaddress(emppermanentaddress);
		empbean.setFathername(empfathername);
		empbean.setFatheroccupation(empfatheroccupation);
		
		
		try {
			UpdateMail.sendEmail(empbean);
			session.setAttribute("employeebean",empbean);
			RequestDispatcher ref=request.getRequestDispatcher("home.jsp");
			ref.forward(request, response);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
