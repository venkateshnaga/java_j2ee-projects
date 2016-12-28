<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="loginservlet" method="post">
<table align="center">
<tr>
<td>Enter MailId:</td>
<th><input type="text" name="empmailid" /></th>
</tr>
<tr>
<td>Enter Password:</td>
<th><input type="password" name ="emppwd" /></th>
</tr>

<tr>
<th><input type="Submit" value="Login" /></th>
</tr>
</table>
</form>
</body>
</html>