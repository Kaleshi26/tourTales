<%@include file="includes/header.jsp"%>
<%@include file="includes/userDashboardLayoutStart.jsp"%>

<%@ page import="com.tourtales.user.User" %>

<%
User c_user = (User) request.getAttribute("user");
%>

	
<div class="Userprofilepage">
<ul class="Userprofilepage-list">
<li class="Userprofilepage-line">User ID : <%= c_user.getId() %> </li>
<li class="Userprofilepage-line">First Name :<%= c_user.getfName() %> </li>
<li class="Userprofilepage-line">Last Name :<%=c_user.getlName() %> </li>
<li class="Userprofilepage-line">E mail :<%= c_user.getEmail() %> </li>
<li class="Userprofilepage-line">Password :<%= c_user.getPwd() %> </li>
<li class="Userprofilepage-line">Contact Number : <%= c_user.getContact_no() %></li>
<li class="Userprofilepage-line">Date of Birth : <%= c_user.getDob() %></li>
<li class="Userprofilepage-line">Country : <%=c_user.getCountry() %> </li>
</ul>
</div>


<a href="ProfileupdateServlet">
		<button id="Userprofilepage-upadtebtn" >Edit</button>
	</a>
<form action="DeleteprofileServlet" method="POST">
		<button id="Userprofilepage-deletebtn" >Delete</button>
	</form>


<%@include file="includes/userDashboardLayoutEnd.jsp"%>

<%@include file="includes/footer.jsp"%>

</body>
</html>