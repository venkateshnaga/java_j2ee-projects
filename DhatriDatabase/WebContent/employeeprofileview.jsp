 <%@page import="java.util.Iterator"%>
<%@page import="com.employee.bean.EmployeeBean"%>
<%@page import="com.employee.bean.EmployeeCompanyBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Employee Details</title>
</head>
<body align="center">

<div align="center">
<h2>View </h2>
</div>

<%
Object obj=session.getAttribute("employeebeansearch");
if(obj!=null)
{

	ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	
	EmployeeBean employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(EmployeeBean)iterator.next();
		//companybean=(EmployeeCompanyBean)iterator.next();
		%>
	
<table align="center">

<tr>
<td>Id:</td>
<td><input type="text" value="<%= employeebean.getEmpid() %>" name="eid" readonly/></td>
</tr>

<tr>
<td>FirstName:</td>
<td><input type="text" value="<%= employeebean.getFname() %>" name="empfirstname" readonly/></td>
</tr>

<tr>
<td>Last Name:</td>
<td><input type="text" value="<%= employeebean.getLname() %>" name="emplastname" readonly/></td>
</tr>

<tr>
<td>DOB:</td>
<td><input type="text" value="<%= employeebean.getDob() %>" name="empdob" readonly/></td>
</tr>

<tr><td>Mobile No:</td>
<td><input type="text" value="<%= employeebean.getMobileno() %>" name="empmobileno" readonly/></td>
</tr>

<tr><td>Mailid:</td>
<td><input type="text" value="<%= employeebean.getEmialid() %>" name="empmailid" readonly/></td>
</tr>
		
<tr>
<td>Alternate Mobile Number:</td>
<td><input type="text" value="<%= employeebean.getAltmobileno() %>" name="empaltermobileno" readonly/></td>
</tr>

<tr>
<td>Alternate EmailId:</td>
<td><input type="text" value="<%= employeebean.getAltemialid() %>" name="empaltermailid" readonly/></td>
</tr>

<tr>
<td>Present Address:</td>
<td><input type="text" value="<%= employeebean.getPresentaddress() %>" name="empprsentaddress" readonly/></td>
</tr>

<tr>
<td>Permanent Address:</td>
<td><input type="text" value="<%= employeebean.getPermanentaddress() %>" name="emppermanentaddress" readonly/></td>
</tr>

<tr><td>Father Name:</td>
<td><input type="text" value="<%= employeebean.getFathername() %>" name="empfathername" readonly/></td>
</tr>

<tr><td>Father Occupation:</td>
<td><input type="text" value="<%= employeebean.getFatheroccupation() %>" name="empfatheroccupation" readonly/></td>
</tr>
		</table>
	<%	
	}
	session.removeAttribute("employeebeansearch");
	
}
else
	
{
	out.print("No Data");
}
%>
<hr>

<%

Object obj1=session.getAttribute("employeecompanysearch");
if(obj1!=null)
{
	ArrayList<EmployeeCompanyBean> employeeList1=(ArrayList)obj1;
	Iterator iterator=employeeList1.iterator();
	
	EmployeeCompanyBean companybean=null;
	while(iterator.hasNext())
	{
		companybean=(EmployeeCompanyBean)iterator.next();
		%>
	
<table align="center">

<tr>
<td>Experience:</td>
<td><input type="text" value="<%= companybean.getExp()%>" name="empexp" readonly/></td>
</tr>

<tr>
<td>PastCompany Name:</td>
<td><input type="text" value="<%= companybean.getPastcompanyname()%>" name="emppastcompanyname" readonly/></td>
</tr>

<tr>
<td>PastCompany Period:</td>
<td><input type="text" value="<%= companybean.getPastcompanyperiod()%>" name="emppastcompanyperiod" readonly/></td>
</tr>

<tr><td>DOJ:</td>
<td><input type="text" value="<%= companybean.getDoj()%>" name="empdoj" readonly/></td>
</tr>

<tr>
<td>Current CTC:</td>
<td><input type="text" value="<%= companybean.getCurrentctc()%>" name="empcctc" readonly/></td>
</tr>

<tr>
<td>Past CTC:</td>
<td><input type="text" value="<%= companybean.getPastctc()%>" name="emppctc" readonly/></td>
</tr>

<tr>
<td>PastHike Date:</td>
<td><input type="text" value="<%= companybean.getPasthikedate()%>" name="emppasthikedate" readonly/></td>
</tr>

<tr><td>DOJ:</td>
<td><input type="text" value="<%= companybean.getDoj()%>" name="empdoj" readonly/></td>
</tr>

<tr>
<td>Advance Salary:</td>
<td><input type="text" value="<%= companybean.getAdvsal()%>" name="empadvsal" readonly/></td>
</tr>

<tr>
<td>Advance Salary Date:</td>
<td><input type="text" value="<%= companybean.getAdvsaldate()%>" name="empadvsaldate" readonly/></td>
</tr>
<tr>
<td>Advance Salary Terms:</td>
<td><input type="text" value="<%= companybean.getAdvsalterms()%>" name="empadvsalterms" readonly/></td>
</tr>

<tr><td>Designation:</td>
<td><input type="text" value="<%= companybean.getDesignation() %>" name="empdesignation" readonly/></td>
</tr>
		
<tr>
<td>Technology:</td>
<td><input type="text" value="<%= companybean.getTechnology() %>" name="emptechnology" readonly/></td>
</tr>
</table>
			<%	
	}
	session.removeAttribute("employeecompanysearch");
	
}
else
	
{
	out.print("No Data");
}
%>
</body>
</html>