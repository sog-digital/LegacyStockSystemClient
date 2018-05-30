<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Legacy Stock System</title>

<style>
 #mainScreen {
    border: 1px solid black;
    margin-top: 100px;

    margin-left: 80px;
  	border-style: none;
}

#borderDiv {

	borderborder-color:black; 
	border-style:solid; 
	border-width: 5px;
 	padding: 50px 0;
 	width: 45%;
   	height:300px 
}

#changePassDiv {
	display:none;
	padding: 50px 0;
	align-self: centre;
	margin-left: 30px
}

</style>

<script>
function displayChangePassDiv() {
    var x = document.getElementById("changePassDiv");
    x.style.display = "block";
    hideMessages();
}

function hideMessages() {

    var x = document.getElementById("appMsgDiv");
    x.style.display = "none";
}

</script>


</head>
<body>


<Div id="mainScreen">


<h2>Welcome <%=request.getAttribute("firstname") %> <%=request.getAttribute("lastname") %>. Your dob is <%=request.getAttribute("dob") %>.
<input type="button" name="changePass" value="Change Password" onclick="displayChangePassDiv()">
</h2> 
<br>
<br>
<br>
<br>

<div id="borderDiv">

	<%
    String errorStr = (String)request.getAttribute("errorStr");
    if(errorStr == null)
    {
        errorStr="";
    }
    String infoStr = (String)request.getAttribute("infoStr");
    if(infoStr == null)
    {
        infoStr="";
    }
    %>

	<div id="appMsgDiv">
		<font color='red' style='margin-left: 80px;'><b><% out.println(errorStr); %></b></font>
		<br>
		<font color='green' style='margin-left: 80px;'><b><% out.println(infoStr); %></b></font>
	</div>	
	
	
	<div id="changePassDiv">
	
	
		<form method="post" action="ChangePass">
		
		<input type="hidden" name="personId" value="<%=request.getAttribute("personId") %>">
		<input type="hidden" name="firstName" value="<%=request.getAttribute("firstname") %>">
		<input type="hidden" name="lastName" value="<%=request.getAttribute("lastname") %>">
		<input type="hidden" name="dob" value="<%=request.getAttribute("dob") %>">
		
		<table>
		<tr>
		<td style="text-align: right;"><h3> Please Enter your New </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td>  </td>
		<td> </td>
		<td> </td>
		</tr>

		<tr>
		<td style="text-align:right;"> <h3> Password </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="password" name="pwd"></td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="submit" value="Go"> </td>
		</tr>
		</table>
		
		</form>
	
	</div>

</div>

</Div>

</body>
</html>