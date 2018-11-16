<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
   background-image: url("images/background2.jpeg");
}

.content {
    max-width: 500px;
    margin: auto;
    background: white;
    padding: 10px;
}
</style>

<SCRIPT LANGUAGE="JavaScript">
function dil(form)
{
   
 if(!isNaN(document.F2.username.value))
   {
       alert("User Name  must  be  char's & can't be null")
	   document.F2.username.value=""
	   document.F2.username.focus()
	   return false
   }
  
    if(document.F2.password.value!=document.F2.repassword.value)
    {
	   alert("Check Confirm PWD"); 
	   document.F2.repassword.value=""
	   document.F2.repassword.focus()	
	   return false
	}
    return true  
}
</script>
</head>
<body>
<div class="content">
<form name=F2 onSubmit="return dil(this)" action="LoginServlet" method="post">
				  <table cellspacing="5" cellpadding="3">	
				
					<tr><td>USER NAME:</td><td> <input type="text" name="username"/></td></tr>
					<tr><td>PASSWORD:</td><td> <input type="password" name="password"/></td></tr>
					<tr><td></td><td><input type="submit" value="Submit"/>
					
					</table>
					</form>
</div>
</body>
</html>