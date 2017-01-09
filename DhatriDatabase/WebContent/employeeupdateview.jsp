 <%@page import="java.util.Iterator"%>
<%@page import="com.employee.bean.EmployeeBean"%>
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
<h2>Update Employee Details</h2>
</div>

<%
Object obj=session.getAttribute("employeelist");

if(obj!=null)
{
	%>
	
	

	<%
	ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	EmployeeBean employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(EmployeeBean)iterator.next();
		%>
<form action="EmployeeUpdateServlet" method="post">		
<table align="center">

<tr>
<td>Employee Id:</td>
<td><input type="text" value="<%= employeebean.getEmpid() %>" name="eid" readonly/></td>
</tr>

<tr>
<td>Employee FirstName:</td>
<td><input type="text" value="<%= employeebean.getFname() %>" name="empfirstname"/></td>
</tr>

<tr>
<td>Employee Last Name:</td>
<td><input type="text" value="<%= employeebean.getLname() %>" name="emplastname" /></td>
</tr>

<tr>
<td>Employee DOB:</td>
<td><input type="text" value="<%= employeebean.getDob() %>" name="empdob"/></td>
</tr>

<tr><td>Employee Mobile No:</td>
<td><input type="text" value="<%= employeebean.getMobileno() %>" name="empmobileno"/></td>
</tr>

<tr><td>Employee Mailid:</td>
<td><input type="text" value="<%= employeebean.getEmialid() %>" name="empmailid"/></td>
</tr>
		
<tr>
<td>Employee Alternate Mobile Number:</td>
<td><input type="text" value="<%= employeebean.getAltmobileno() %>" name="empaltermobileno" readonly/></td>
</tr>

<tr>
<td>Employee Alternate EmailId:</td>
<td><input type="text" value="<%= employeebean.getAltemialid() %>" name="empaltermailid"/></td>
</tr>

<tr>
<td>Employee Present Address:</td>
<td><input type="text" value="<%= employeebean.getPresentaddress() %>" name="empprsentaddress" /></td>
</tr>

<tr>
<td>Employee Permanent Address:</td>
<td><input type="text" value="<%= employeebean.getPermanentaddress() %>" name="emppermanentaddress"/></td>
</tr>

<tr><td>Employee Father Name:</td>
<td><input type="text" value="<%= employeebean.getFathername() %>" name="empfathername"/></td>
</tr>

<tr><td>Employee Father Occupation:</td>
<td><input type="text" value="<%= employeebean.getFatheroccupation() %>" name="empfatheroccupation"/></td>
</tr>
		</table><br>
		<div align="center">
		<input type="submit" value="Update" />
		</div>
		</form>
	<%	
	}
	session.removeAttribute("employeeList");
	
}
else
	
{
	out.print("No Data");
}

%>



</body>
</html>