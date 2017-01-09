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

/**
 * Servlet implementation class UpdateAdminConfirmServlet
 */
@WebServlet("/UpdateAdminConfirmServlet")
public class UpdateAdminConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		EmployeeBean empbean=(EmployeeBean)session.getAttribute("employeebean");
		
		Dboperations dbo=new Dboperations();
		int result=dbo.employeeupdate(empbean);
		RequestDispatcher requestDispact=request.getRequestDispatcher("home.jsp");
		
	if(result>0)
		{
			requestDispact.include(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
}

}
