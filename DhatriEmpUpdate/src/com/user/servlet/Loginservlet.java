package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.user.autoid.GenerateOtp;
import com.user.bean.UserBean;
import com.user.dboperations.Dboperations;
import com.user.mail.SendMail;
import com.user.mail.SendMailOtp;

/**
 * Servlet implementation class Loginservlet
 */

@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
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
		
		String uname=request.getParameter("empmailid");
		String upwd=request.getParameter("emppwd");
		String uotp=GenerateOtp.getEmployeeOtp();
		UserBean ub=new UserBean();
		ub.setEmpotp(uotp);
		
		Dboperations dbo=new Dboperations();
		ArrayList<UserBean> empList=dbo.search(uname);
		session.setAttribute("employeeList", empList);
		
		
		Object obj=session.getAttribute("employeeList");
		ArrayList<UserBean> employeeList=(ArrayList)obj;
		Iterator iterator=employeeList.iterator();
		UserBean ub1=null;
		while(iterator.hasNext())
		{
		ub1=(UserBean)iterator.next();
		}
		
		
		String rotp=GenerateOtp.getEmployeeOtp(); 
		
		if(uname.equals(ub1.getEmpmailid()) && upwd.equals(ub1.getEmppwd()))
		{
		
			String resultMessage = "";

			try 
			{
				SendMailOtp.sendEmail(uname,uotp);
				resultMessage = "Thanks For your enroll., Please check your mail";
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
				//resultMessage = "oops..!!!!: " + ex.getMessage();
			} 
			finally 
			{
				session.setAttribute("otp", rotp);
				RequestDispatcher requestDis=request.getRequestDispatcher("loginotp.jsp");
				requestDis.forward(request, response);
			}
		}
		
	}

}





