/**
 * 
 */

function myFunction()
{
	var employeePwd=document.getElementById("employeepwd").value;
	var employeeCpwd=document.getElementById("employeecpwd").value;

	if(employeePwd!=employeeCpwd)
		{
		//alert("Passwords are not matched");
		document.getElementById("error1").innerHTML="Passwords are not matched";
		return false;
		}
	else
		
		return true;

	}

	function clearField()
	{
		document.getElementById("error1").innerHTML=" ";
	}


