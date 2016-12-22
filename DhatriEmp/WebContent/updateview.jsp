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
<body style="background-color:DarkKhaki ">

<div align="center">

<h2>Update Employee Details</h2>

<form action="Updatedummy" method="post">
Enter Employee Id :
<input type="text" name="search" />
<input type="submit" value="Update By Id"><br>
</form>

<%
Object obj=session.getAttribute("employeeList");

if(obj!=null)
{
	%>
	<form action="Updateservlet" method="post">
	<table><br>

	<%
	ArrayList<EmployeeBean> employeeList=(ArrayList)obj;
	Iterator iterator=employeeList.iterator();
	EmployeeBean employeebean=null;
	while(iterator.hasNext())
	{
		employeebean=(EmployeeBean)iterator.next();
		%>
		<tr>
		
<td>Employee Id:<br><input type="hidden" value="<%= employeebean.getEmpid() %>" name="eid"/></td>
<td>Employee Name:<input type="text" value="<%= employeebean.getEmpname()  %>" name="ename"/></td>
<td>Employee Salary:<input type="text" value="<%= employeebean.getEmpsal() %>" name="esal"/></td>
<td>Employee Exp:<input type="text" value="<%= employeebean.getEmpexp() %>" name="eexp"/></td>
<td>Employee Location:<input type="text" value="<%= employeebean.getEmploc() %>" name="eloc"/></td>


		</tr>
		
	<%	
	}
	session.removeAttribute("employeeList");
	
}
else
	
{
	out.print("No Data");
}

%>

</table>
<input type="submit" value="Update" />
</form>
<br>
<br>
<br>
<a href="index.html">Go To HomePage</a>
</div>


</body>
</html>