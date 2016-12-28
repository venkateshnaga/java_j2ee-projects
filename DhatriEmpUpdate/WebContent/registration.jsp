<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="registrationservlet" method="post">

<table align="center">
<tr>
<td>Enter Name:</td>
<th><input type="text" name="empname" /></th>
</tr>

<tr>
<td>Enter MailId:</td>
<th><input type="text" name="empmailid" /></th>
</tr>
<tr>
<td>Enter Password:</td>
<th><input type="password" name="emppwd" /></th>
</tr>

<tr>
<td>Confirm Password:</td>
<th><input type="password" name="empcpwd" /></th>
</tr>

<tr>
<td>Enter CTC:</td>
<th><input type="number" name="empctc" /></th>
</tr>

<tr>
<td>Enter Experience:</td>
<th><input type="text" name="empexp" /></th>
</tr>

<tr>
<td>Enter Location:</td>
<th><input type="text" name="emploc" /></th>
</tr><br>

<tr>
<td></td>
<th><input type="submit" value="SignUp"/></th>
</tr>
</table>

</form>
</body>
</html>