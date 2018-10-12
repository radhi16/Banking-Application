
<%@ page import="java.util.*" %>
<%@ page import="com.ideas.*" %>
<html>
<head>
<title>Account List</title>
</head>
<body background="show5.jpg">
<h1 align="center"><font face="Algerian" size="50" >List of Accounts</font></h1>
<br>
<marquee direction="right" bgcolor="LavenderBlush"> WE ARE A FAMILY! </marquee>
<br>

<br>
<br>
      <script type="text/javascript">
      var minAge = 18;
      function calculateAge() {
          var birthDate = new Date(document.getElementById("date").value);
          var today = new Date();

          var timeDifference = Math.abs(today.getTime() - birthDate.getTime());
          var calculatedAge =Math.ceil(timeDifference / (1000 * 3600 * 24)) / 365;
          return calculatedAge;
      }
      //Compares calculated age with minimum age and acts according to rules//
      function setAge() {

          var age = calculateAge();
          //alert("my age is " + age);
          if (age < minAge) {
              alert("You are not allowed into the site. The minimum age is 18!");
          } else

              alert("Welcome to my Site");
          window.open(main.htm, _self);

      }

</script>
<div style="width: 50%;  float: left;" id="table">
<table border="2" bgcolor="LavenderBlush"> 
<% List <Account> volist=(List) request.getAttribute("list"); %>
<tr bgcolor="	#9400D3" style="color: white"> 
<th> Name </th>
<th> Account Type </th>
<th> Account id </th> 
</tr>

<% for(Account account:volist)
{ %>
<tr>  
    <td> <%= account.getName() %>
    <td><%= account.getAccountType() %></td>
    <td align="center"><a href="#" onclick="FetchAccountDetails(<%=account.getId()%>);">  
    <%=account.getId()%> </a>
 
  </tr>
  <%} %>
  
 </table>
 <br>
 <br>
 

 
<button style="color:blue" onclick="window.location.href='http://localhost:8080/welcomeapp1/BankingApp.html'">Back to HomePage</button>
</div>
<script type="text/javascript">
//System.out.println("Print json" + jsonString);

function FetchAccountDetails(id) {
	var http = new XMLHttpRequest();
    http.onreadystatechange = function() {
           if (http.readyState == 4 && http.status == 200) {
	
			 var JSONobj = JSON.parse(http.responseText);
			 //System.out.println(JSONobj.id);
			 
			 
			
			  document.getElementById("detailsDiv").style.display="block";
			document.getElementById("id").value = JSONobj.id;
			document.getElementById("name").value = JSONobj.name;
			document.getElementById("addres").value = JSONobj.address;
			document.getElementById("date").value = JSONobj.date;
			document.getElementById("panNo").value = JSONobj.panNo;
			document.getElementById("mobNo").value = JSONobj.mobNo;
			document.getElementById("accountType").value = JSONobj.accountType;
		    
			document.getElementById("name").readOnly=true;

		    document.getElementById("addres").readOnly=true;
		    document.getElementById("date").readOnly=true;
		    document.getElementById("mobNo").readOnly=true;
			 
		    document.getElementById("name").style.backgroundColor = "white";
		    document.getElementById("addres").style.backgroundColor = "white";
		    document.getElementById("date").style.backgroundColor = "white";
		    document.getElementById("mobNo").style.backgroundColor = "white";
		} 
	 };
	 http.open("GET","./welcome1?accountId="+id,true);
	 http.send();
}

function enableEdit() {

    document.getElementById("name").removeAttribute("readonly");

    document.getElementById("addres").removeAttribute("readonly");
    document.getElementById("date").removeAttribute("readonly");
    document.getElementById("mobNo").removeAttribute("readonly");
    
    document.getElementById("name").style.backgroundColor = "yellow";
    document.getElementById("addres").style.backgroundColor = "yellow";
    document.getElementById("date").style.backgroundColor = "yellow";

    document.getElementById("mobNo").style.backgroundColor = "yellow";

}


</script>


 <div id="detailsDiv" style="margin-left: 50%;  width: 50%;  overflow:  hidden;  display: none;">
<form action="./welcome1?from=update" method="post">
 <table border="2" bgcolor="LavenderBlush" >
<tr bgcolor="	#9400D3" style="color: white">
  <td>Account Id </td>
  <td> <input type="text" name="updateid" id="id" readonly="readonly" > </td>
  </tr>

<tr>
  <td>Name: </td>
  <td> <input type="text" name="updateName" id="name" readonly="readonly" required> </td>
  </tr>
  
  <tr>
  <td>Address </td>
  <td> <input type="text" name="updateAddres" id="addres" readonly="readonly"> </td>
  </tr>
  
  <tr>
  <td>Date of Birth: </td>
  <td> <input type="date" name="updateDate" id="date" readonly="readonly"> </td>
  </tr>
  
  <tr>
  <td>Pan No: </td>
  <td> <input type="text" name="updatePanNo" id="panNo" readonly="readonly" required> </td>
  </tr>
  
  <tr>
  <td>Mobile No: </td>
  <td> <input type="text" name="updateMobNo" id="mobNo" readonly="readonly" pattern="[7-9]{1}[0-9]{9}"> </td>
  </tr>
  
  <tr>
  <td>Account Type: </td>
  <td> <input type="text" name="updateAccountType" id="accountType" readonly="readonly"> </td>
  </tr>
  
  <tr>
  <td> <input type="button" value="Edit" onclick="enableEdit()"> </td>
  <td> <input type="submit" value="Update" onClick="setAge();"> </td>
  </tr>
</table>
<br>


</div>

<br>
<br>


</body>
</html>