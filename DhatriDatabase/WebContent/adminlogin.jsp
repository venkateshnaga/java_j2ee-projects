<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AdminLoginServlet" method="post">
<table>
<tr>
<td>AdminId:</td>
<th><input type="text" name="adminid" /></th>
</tr>

<tr>
<td>AdminPassword:</td>
<th><input type="password" name="adminpwd" /></th>
</tr>
</table>
<input type="submit" value="Login" />
</form>
</body>
</html>