
<%@ page import="java.util.*" %>
<%@ page import="com.ideas.*" %>
<html>
<head>
<title>Account List</title>
</head>
<body>
<h3>Account List</h3>




<table> 
<% List <AccountVO> volist=(List) request.getAttribute("list"); %>
<tr>
<th> Name </th>
<th> Account Type </th>
<th> Account id </th>
</tr>

<% for(AccountVO account:volist)
{ %>
<tr>  
    <td> <%= account.getName() %>
    <td><%= account.getAccountType() %></td>
    <td><a href="#" onclick="FetchAccountDetails(<%=account.getId()%>);">  
    <%=account.getId()%> </a>
 
  </tr>
  <%} %>
 </table>

<script type="text/javascript">
//System.out.println("Print json" + jsonString);

function FetchAccountDetails(id) {
	accid = id.innerHTML;
	alert(accid);
	var xhttp = new XMLHttpRequest();
	
	 xhttp.onreadystatechange = function() {
		//alert(xhttp.readyState);
		if (xhttp.readyState == 4 && xhttp.status == 200){
			 obj = jsonString.parse(xhttp.responseText);
			document.getElementById("id").value = obj.id;
			document.getElementById("name").value = obj.name;
			document.getElementById("addres").value = obj.address;
			document.getElementById("date").value = obj.date;
			document.getElementById("panNo").value = obj.panNo;
			document.getElementById("mobNo").value = obj.mobNo;
			document.getElementById("accountType").value = obj.Account_type;

		} 
	 };
	 xhttp.open("GET","./welcome1?accountId="+id,true);
	 xhttp.send();
}
</script>

 <table>
<tr>
  <td>Account Id </td>
  <td> <input type="text" name="id" id="id" > </td>
  </tr>

<tr>
  <td>Name: </td>
  <td> <input type="text" name="name" id="name" > </td>
  </tr>
  
  <tr>
  <td>Address </td>
  <td> <input type="text" name="addres" id="addres"> </td>
  </tr>
  
  <tr>
  <td>Date of Birth: </td>
  <td> <input type="text" name="date" id="date"> </td>
  </tr>
  
  <tr>
  <td>Pan No: </td>
  <td> <input type="text" name="panNo" id="panNo"> </td>
  </tr>
  
  <tr>
  <td>Mobile No: </td>
  <td> <input type="text" name="mobNo" id="mobNo"> </td>
  </tr>
  
  <tr>
  <td>Account Type: </td>
  <td> <input type="text" name="accountType" id="accountType"> </td>
  </tr>
</table>

</body>
</html>