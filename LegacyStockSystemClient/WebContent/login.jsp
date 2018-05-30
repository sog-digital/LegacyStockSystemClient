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

</head>
<body>

<font color='red' style='margin-left: 80px;'><b><%= request.getAttribute("errorStr") %></b></font>

<Div id="loginForm">

<form method="post" action="Validate">

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
<td> <input type="password" name="pwd"></td>
<td> &nbsp;&nbsp;</td>
<td> <input type="submit" value="Go"> </td>
</tr>
</table>

</form>

</Div>




</body>
</html>