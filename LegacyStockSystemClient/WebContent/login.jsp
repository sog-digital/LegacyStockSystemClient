<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to Legacy Stock System</title>

<style>
#loginForm {
    border: 1px solid black;
    margin-top: 100px;

    margin-left: 80px;
  	border-style: none;
}
</style>

<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>

<script src="passwordencryption.js"></script>

</head>	
<body>

<%
    String errorStr = (String)request.getAttribute("errorStr");
    if(errorStr == null)
    {
        errorStr="";
    }
%>    


<font color='red' style='margin-left: 80px;'><b><% out.println(errorStr); %></b></font>

<Div id="loginForm">

<form method="post" action="Validate" name="loginForm">

<table>
<tr>
<td style="text-align: right;"> Email </td>
<td> &nbsp;&nbsp;</td>
<td> <input type="text" name="email"> </td>
<td> </td>
<td> </td>
</tr>

<tr>
<td style="text-align:right;"> password </td>
<td> &nbsp;&nbsp;</td>
<td> <input type="password" name="pwd" id="pass"></td>
<td> &nbsp;&nbsp;</td>
<td> <input type="submit" value="Go" onClick="encryptPasswordAndSubmit()"> </td>
</tr>
</table>

</form>

</Div>

</body>
</html>