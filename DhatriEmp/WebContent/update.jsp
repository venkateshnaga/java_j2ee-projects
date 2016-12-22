<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Details</title>
</head>
<body style="background-color:SeaGreen">
<div align="center">
<form action="Updateservlet" method="post">
<table align="center">
<h2>Update Employee Details</h2>
<tr><br>
      <td>Enter Employee Id :</td>
      <td><input type="text" name="empid" /></td>
    </tr>

    <tr>
      <td>Enter Employee Name To Update:</td>
      <td><input type="text" name="empname" /></td>
    </tr>

    <tr>
      <td>Enter Salary To Update:</td>
      <td><input type="number" name="empsal" /></td>
    </tr>
    <tr>
      <td>Enter Experience To Update:</td>
      <td><input type="number" name="empexp" /></td>
    </tr>
     <tr>
      <td>Enter Location To Update:</td>
      <td><input type="text" name="emploc" /></td>
    </tr>
    
</table>
<br>
<input type="submit" value="Update">

</form>
</div>
</body>
</html>