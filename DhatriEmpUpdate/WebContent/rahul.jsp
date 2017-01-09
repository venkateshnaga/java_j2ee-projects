<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="regvalidations.js">
/* 
		var Pass=document.getElementById("rahul").value;
		var password=document.getElementById("venkatesh").value;
	function myFunction()	
{
if(Pass!=password)
{
	alert("wrong password");
//document.getElementById("1").innerHTML="mismatch password";
		return false;
}
else
return true;
}
	
	function clearField(id)
	{
		document.getElementById(id).value="";
		} */
		
</script>



<body>
<div align="center">
<h1>Welcome to registration page</h1>
<form action="registrationservlet" method="post">
<input type="text" name="firstname"  id="firstname" value="firstname" onclick="return clearField(this.id)" ><br>
<input type="text" name="lastname" value="lastname" id="lastname" onclick="return clearField(this.id)"><br>
<input type="text" name="email id" value="email id" id="email id" onclick="return clearField(this.id)"><br>
new password<br>
<input type="password" name="emppwd" id="employeepwd" onkeypress="return clearField()" /><br>
Reenter password<br>
<input type="password" name="empcpwd" id="employeecpwd" onkeypress="return clearField()" /><br>

<input type="submit" value="sign up" onclick="return myFunction()"/>
</form>
</div>

</body>
</html>