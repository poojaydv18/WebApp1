<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
   background-image: url("images/background3.jpeg");
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
  
 if(!isNaN(document.F1.username.value))
   {
       alert("User Name  must  be  char's & can't be null")
	   document.F1.username.value=""
	   document.F1.username.focus()
	   return false
   }
  
   
   
    if(!isNaN(document.F1.prodname.value))
   {
       alert("product field  must  be  char's & can't be null")
	   document.F1.prodname.value=""
	   document.F1.prodname.focus()
	   return false
   }
   
	 if(!isNaN(document.F1.paymode.value))
   {
       alert("Payment Mode Can only be PAYTM OR COD ")
	   document.F1.statename.value=""
	   document.F1.statename.focus()
	   return false
   }
	
   return true   
   }
</SCRIPT>


</head>
<body>
<div class="content">
<a href="Logout.jsp">LOGOUT</a>
<form name=F1 onSubmit="return dil(this)" action="OrderServlet" method="post">
				  <table cellspacing="5" cellpadding="3">	
				
					<tr><td>USER NAME:</td><td> <input type="text" name="username"/></td></tr>
					<tr><td>STARTERS:</td><td> <input type="text" name="starter"/></td></tr>
					<tr><td>MAIN COURSE:</td><td> <input type="text" name="maincourse"/></td></tr>
					<tr><td>DESSERT:</td><td> <input type="text" name="dessert"/></td></tr>
					
					<tr><td></td><td><input type="submit" value="Proceed To Pay"/>
					
					<INPUT TYPE=RESET VALUE="CLEAR"></td></tr>
					</table>
               		</form>


</div>
</body>
</html>