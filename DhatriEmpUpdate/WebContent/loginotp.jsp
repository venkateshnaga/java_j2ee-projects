<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String secondotp=(String)session.getAttribute("otp");

%>

<form action="Otpservlet" method="post">
<table align="center">

<tr>
<td>Enter OTP:</td>
<th><input type="text" name="loginotp" /></th>
</tr>

<tr>
<th><input type="submit" value="Submit" /></th>
</tr>



</table>




</form>
</body>
</html>