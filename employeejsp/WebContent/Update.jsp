<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body style="background-color:Moccasin">
<div align="center">
<h1>Employee Info</h1>

<form action="us" method="post">

 <table>
    <tr>
      <td>Enter Employee Id to update:</td>
      <td><input type="text" name="id" /></td>
    </tr>

    <tr>
      <td>Enter Employee Name to update:</td>
      <td><input type="text" name="name" /></td>
    </tr>

   <tr>
      <td>Enter Salary to update:</td>
      <td><input type="number" name="sal" /></td>
    </tr>
    
    <tr>
      <td>Enter Experience to update:</td>
      <td><input type="number" name="exp" /></td>
    </tr>
     <tr>
      <td>Enter Location to update:</td>
      <td><input type="text" name="loc" /></td>
    </tr>
     
    
    
</table>

<input type="submit" value="Submit">
</form>

</div>

</body>

</html>