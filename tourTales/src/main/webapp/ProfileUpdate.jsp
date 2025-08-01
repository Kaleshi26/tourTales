<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.tourtales.user.User" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upadte profile</title>
<link rel="stylesheet" href="css/updateprofile.css">
</head>
<body>

<%
User user = (User) request.getAttribute("userdetails");
%>

<div>
<form  class="Userprofileupdate-form" action="ProfileupdateServlet" method="post">
<label class="Userprofileupdate-label"  for="id">Id:</label>
<input class="Userprofileupdate-input" type="number" id="id" name ="id" value="<%= user.getId()%>" readonly>
<label class="Userprofileupdate-label" for="fname">First Name :</label>
<input class="Userprofileupdate-input" type="text" id="fname" name ="fname" value="<%= user.getfName()%>">
<label class="Userprofileupdate-label" for="lname">Last Name :</label>
<input class="Userprofileupdate-input" type="text" id="lname" name ="lname" value="<%= user.getlName()%>">
<label class="Userprofileupdate-label" for="email">E mail :</label>
<input class="Userprofileupdate-input" type="text" id="email" name ="email" value="<%= user.getEmail()%>">
<label class="Userprofileupdate-label" for="pass">Password :</label>
<input class="Userprofileupdate-input" type="text" id="pass" name ="pass" value="<%= user.getPwd()%>">
<label class="Userprofileupdate-label" for="contact">Contact Number :</label>
<input class="Userprofileupdate-input"  type="text" id="contact" name ="contact" value="<%= user.getContact_no()%>">
<label  class="Userprofileupdate-label" for="dob">Date of Birth :</label>
<input class="Userprofileupdate-input"type="text" id="dob" name ="dob" value="<%= user.getDob()%>">
<label  class="Userprofileupdate-label" for="country">Country :</label>
<input class="Userprofileupdate-input" type="text" id="country" name ="country" value="<%= user.getCountry()%>">
<input type = "submit" value = "Edit details" id="Userprofileupdate-editbtn">
</form>
</div>
</body>
</html>