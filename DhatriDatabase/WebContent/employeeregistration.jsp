<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
<form action="EmployeeRegistrationServlet" method="post">
<table align="center"><br>
<tr>
<td>Employee First Name:</td>
<th><input type="text" name="employeefirstname" />
</tr>

<tr>
<td>Employee Last Name:</td>
<th><input type="text" name="employeelastname" />
</tr>

<tr>
<td>Employee DOB:</td>
<th><input type="text" name="employeedob" />
</tr>

<tr>
<td>Employee Mobile No:</td>
<th><input type="number" name="employeemobilenumber" />
</tr>

<tr>
<td>Employee EmialId:</td>
<th><input type="text" name="employeemailid" />
</tr>

<tr>
<td>Employee Alternate Mobile Number:</td>
<th><input type="number" name="employeealtermobileno" />
</tr>

<tr>
<td>Employee Alternate EmailId:</td>
<th><input type="text" name="employeealtermailid" />
</tr>
<tr>
<td>Employee Present Address:</td>
<th><input type="text" name="employeeprsentaddress" />
</tr>
<tr>
<td>Employee Permanent Address:</td>
<th><input type="text" name="employeepermanentaddress" />
</tr>

<tr>
<td>Employee Father Name:</td>
<th><input type="text" name="employeefathername" />
</tr>


<tr>
<td>Employee Father Occupation:</td>
<th><input type="text" name="employeefatheroccupation" />
</tr>
</table>
<hr>

<table align="center">
<tr>
<td>Employee Years Of Exp:</td>
<th><input type="number" name="employeeyearsofexp" />
</tr>

<tr>
<td>Employee Past Company Name:</td>
<th><input type="text" name="employeepastcompanyname" />
</tr>

<tr>
<td>Employee Past Company Period:</td>
<th><input type="number" name="employeecompanyperiod" />
</tr>

<tr>
<td>Employee Date Of Joining:</td>
<th><input type="text" name="employeedoj" />
</tr>

<tr>
<td>Employee Current CTC:</td>
<th><input type="text" name="employeectc" />
</tr>

<tr>
<td>Employee Past CTC:</td>
<th><input type="text" name="employeepastctc" />
</tr>


<tr>
<td>Employee Past Hike Date:</td>
<th><input type="text" name="employeepasthikedate" />
</tr>
<tr>
<td>Employee Advance Salary:</td>
<th><input type="number" name="employeeadvsal" />
</tr>

<tr>
<td>Employee Advance Salary Date:</td>
<th><input type="text" name="employeeadvdate" />
</tr>
<tr>
<td>Employee Advance Salary Terms:</td>
<th><input type="text" name="employeeadvterms" />
</tr>
<tr>
<td>Employee Designation:</td>
<th><input type="text" name="employeedesignation" />
</tr>

<tr>
<td>Employee Technology:</td>
<th><input type="text" name="employeetechnology" />
</tr>
<tr>
<th><br>
<input type="submit" value="Register"></th>
</tr>
</table>

</form>
</body>
</html>