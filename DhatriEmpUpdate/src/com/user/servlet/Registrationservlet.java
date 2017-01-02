package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.mail.SendMail;
import com.user.mail.Sendimage;
import com.user.autoid.GenerateEmployeeId;
import com.user.bean.UserBean;
import com.user.dboperations.Dboperations;

/**
 * Servlet implementation class Registrationservlet
 */
@WebServlet("/Registrationservlet")
public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registrationservlet() {
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
		String empid=GenerateEmployeeId.getEmployeeId();
		String empname=request.getParameter("empname");
		String empmailid=request.getParameter("empmailid");
		String emppwd=request.getParameter("emppwd");
		String empsal=request.getParameter("empctc");
		String empexp=request.getParameter("empexp");
		String emploc=request.getParameter("emploc");
		double salary,exp;
		try
		{
			salary=Double.parseDouble(empsal);
			exp=Double.parseDouble(empexp);
		}
		catch(Exception e)
		{
			salary=0.0;
			exp=0.0;
		}
		
		UserBean ub=new UserBean();
		ub.setEmpid(empid);
		ub.setEmpname(empname);
		ub.setEmpmailid(empmailid);
		ub.setEmppwd(emppwd);
		ub.setEmpsal(salary);
		ub.setEmpexp(exp);
		ub.setEmploc(emploc);
		
		Dboperations dbo=new Dboperations();
		int result=dbo.registration(ub);
	
		String resultMessage = "";

		try {
			SendMail.sendEmail(ub);
			resultMessage = "Thanks For your enroll., Please check your mail";
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			resultMessage = "oops..!!!!: " + ex.getMessage();
		} 
		finally 
		{
			session.setAttribute("Message", resultMessage);
			
			getServletContext().getRequestDispatcher("/registrationsucess.jsp").forward(request, response);
		}
		
		
	}
	

}
