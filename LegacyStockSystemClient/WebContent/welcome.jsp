<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.sogeti.digital.lss.model.Product"%>    
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
   	height:350px 
}

#changePassDiv {
	display:none;
	padding: 50px 0;
	align-self: centre;
	margin-left: 30px
}

#stockDiv {
	display:none;
	padding: 50px 0;
	align-self: centre;
	margin-left: 150px
}

#createStockDiv {
	display:none;
	padding: 50px 0;
	align-self: centre;
	margin-left: 150px
}

</style>

<script>

function displaySubDiv(id) {
    var x = document.getElementById(id);
    x.style.display = "block";
    

    var subDivs = document.getElementById('borderDiv').querySelectorAll("Div");
    
	
    for( var i=0; i<subDivs.length; i++) {
    
    	if( subDivs[i].id != id ) {
    	
    		document.getElementById(subDivs[i].id).style.display = 'none';
    	}
    }		
    
}


</script>


</head>
<body>


<Div id="mainScreen">


<h2>Welcome <%=request.getAttribute("firstname") %> <%=request.getAttribute("lastname") %>. Your dob is <%=request.getAttribute("dob") %>.
&nbsp;&nbsp;<input type="button" name="changePass" value="Change Password" onclick="displaySubDiv('changePassDiv')">
</h2> 
<h3>Create a New Stock &nbsp;&nbsp;<input type="button" name="createStock" value="Go" onclick="displaySubDiv('createStockDiv')"></h3>
<form method="post" action="Stock">
		<input type="hidden" name="personId" value="<%=request.getAttribute("personId") %>">
		<input type="hidden" name="firstName" value="<%=request.getAttribute("firstname") %>">
		<input type="hidden" name="lastName" value="<%=request.getAttribute("lastname") %>">
		<input type="hidden" name="dob" value="<%=request.getAttribute("dob") %>">

<h3>Enter Stock ID &nbsp;&nbsp;<input type="number" name="productID" min="1">&nbsp;&nbsp; <input type="submit" name="findStock" value="Go"></h3>
</form>
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
    
    Product product = (Product)request.getAttribute("stock");
    boolean stockFound = false;
    String productID = "";
    String productName ="";
    String amount ="";
    String price ="";
    
    if( product != null ) {
		stockFound = true;
		productID = String.valueOf(product.getId());
		productName = product.getName();
		amount = String.valueOf( product.getAmount());
		price = product.getPrice();
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

	<div id="stockDiv">

		<form method="post" action="Stock">
		
		<input type="hidden" name="personId" value="<%=request.getAttribute("personId") %>">
		<input type="hidden" name="firstName" value="<%=request.getAttribute("firstname") %>">
		<input type="hidden" name="lastName" value="<%=request.getAttribute("lastname") %>">
		<input type="hidden" name="dob" value="<%=request.getAttribute("dob") %>">
		
		<table>
		<tr>
		<td style="text-align: right;"><h3> Product ID </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="productID" disabled value="<%=productID %>"> </td>
		<td> </td>
		<td> </td>
		</tr>

		<tr>
		<td style="text-align:right;"> <h3> Name </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="name" value="<%=productName %>"></td>
		<td> &nbsp;&nbsp;</td>
		<td> </td>
		</tr>
		
		<tr>
		<td style="text-align: right;"><h3> Price </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="price" value="<%=price %>"> </td>
		<td> </td>
		<td> </td>
		</tr>
		
		<tr>
		<td style="text-align: right;"><h3> Amount </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="amount" value="<%=amount %>"> </td>
		<td> </td>
		<td> </td>
		</tr>
		
		</table>
		<br>
		<br>
		<input type="submit" value="Save"> 
		
		</form>
	
	</div>
	
		<div id="createStockDiv">

		<form method="post" action="Stock">
		
		<input type="hidden" name="personId" value="<%=request.getAttribute("personId") %>">
		<input type="hidden" name="firstName" value="<%=request.getAttribute("firstname") %>">
		<input type="hidden" name="lastName" value="<%=request.getAttribute("lastname") %>">
		<input type="hidden" name="dob" value="<%=request.getAttribute("dob") %>">
		
		<table>
		<tr>
		<td style="text-align: right;"><h3> Product ID </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="productID" disabled> </td>
		<td> </td>
		<td> </td>
		</tr>

		<tr>
		<td style="text-align:right;"> <h3> Name </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="name"></td>
		<td> &nbsp;&nbsp;</td>
		<td> </td>
		</tr>
		
		<tr>
		<td style="text-align: right;"><h3> Price </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="price"> </td>
		<td> </td>
		<td> </td>
		</tr>
		
		<tr>
		<td style="text-align: right;"><h3> Amount </h3> </td>
		<td> &nbsp;&nbsp;</td>
		<td> <input type="text" name="amount"> </td>
		<td> </td>
		<td> </td>
		</tr>
		
		</table>
		<br>
		<br>
		<input type="submit" value="Save"> 
		
		</form>
	
	</div>
	




</div>

</Div>

<% if(stockFound) { %>
    
    <script>
    	
    	document.getElementById('stockDiv').style.display = "block";
    
    </script>

    
    <%
       }  
    %>

</body>
</html>