package com.employee.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.bean.EmployeeBean;
import com.employee.bean.EmployeeCompanyBean;
import com.employee.dbo.Dboperations;
import com.employee.autoid.GenerateEmployeeId;

/**
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegistrationServlet() {
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
		//Employee Personal Details
		String employeeid=GenerateEmployeeId.getEmployeeId();
		String employeefirstname=request.getParameter("employeefirstname");
		String employeelastname=request.getParameter("employeelastname");
		String employeedob=request.getParameter("employeedob");
		String employeemobilenumber=request.getParameter("employeemobilenumber");
		String employeemailid=request.getParameter("employeemailid");
		String employeealtermobileno=request.getParameter("employeealtermobileno");
		String employeealtermailid=request.getParameter("employeealtermailid");
		String employeeprsentaddress=request.getParameter("employeeprsentaddress");
		String employeepermanentaddress=request.getParameter("employeepermanentaddress");
		String employeefathername=request.getParameter("employeefathername");
		String employeefatheroccupation=request.getParameter("employeefatheroccupation");
		
		//Employee Company Details
		String employeeyearsofexp=request.getParameter("employeeyearsofexp");
		String employeepastcompanyname=request.getParameter("employeepastcompanyname");
		String employeecompanyperiod=request.getParameter("employeecompanyperiod");
		String employeedoj=request.getParameter("employeedoj");
		String employeecctc=request.getParameter("employeecctc");
		String employeepastctc=request.getParameter("employeepastctc");
		String employeepasthikedate=request.getParameter("employeepasthikedate");
		String employeeadvsal=request.getParameter("employeeadvsal");
		String employeeadvdate=request.getParameter("employeeadvdate");
		String employeeadvterms=request.getParameter("employeeadvterms");
		String employeedesignation=request.getParameter("employeedesignation");
		String employeetechnology=request.getParameter("employeetechnology");
		
		//Bean For Emp Personal Details
		EmployeeBean emp=new EmployeeBean();
		emp.setEmpid(employeeid);
		emp.setFname(employeefirstname);
		emp.setLname(employeelastname);
		emp.setDob(employeedob);
		emp.setMobileno(employeemobilenumber);
		emp.setEmialid(employeemailid);
		emp.setAltmobileno(employeealtermobileno);
		emp.setAltemialid(employeealtermailid);
		emp.setPresentaddress(employeeprsentaddress);
		emp.setPermanentaddress(employeepermanentaddress);
		emp.setFathername(employeefathername);
		emp.setFatheroccupation(employeefatheroccupation);
		
		
		//Bean For Emp Company Details
		
		EmployeeCompanyBean empc=new EmployeeCompanyBean();
		empc.setEmpid(employeeid);
		empc.setExp(employeeyearsofexp);
		empc.setPastcompanyname(employeepastcompanyname);
		empc.setPastcompanyperiod(employeecompanyperiod);
		empc.setDoj(employeedoj);
		empc.setCurrentctc(employeecctc);
		empc.setPastctc(employeepastctc);
		empc.setPasthikedate(employeepasthikedate);
		empc.setAdvsal(employeeadvsal);
		empc.setAdvsaldate(employeeadvdate);
		empc.setAdvsalterms(employeeadvterms);
		empc.setDesignation(employeedesignation);
		empc.setTechnology(employeetechnology);
		
		Dboperations dbo=new Dboperations();
		int result=dbo.employeeregistration(emp, empc);
		
	
	}

}
