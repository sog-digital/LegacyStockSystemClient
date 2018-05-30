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
</style>

</head>
<body>

<Div id="mainScreen">


<h2>Welcome <%=request.getAttribute("firstname") %> <%=request.getAttribute("lastname") %>. Your dob is <%=request.getAttribute("dob") %>.   </h2> 

</Div>

</body>
</html>