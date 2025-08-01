<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ page import="java.util.List" %> 
<%@ page import = "java.util.ArrayList" %>
<%@ page import="models.Bookings" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookingDashboard</title>
<link rel = "stylesheet" href="css/CustomerBookingDashboard.css"> 
</head>
<body>
<main class="UserBookingDashboard-main">
	<%@include file="includes/header.jsp" %>
	
	<a href="profile">
		<button id="UserBookingDashboard-profilebtn" >Profile</button>
	</a>
<%
		System.out.println("Booking dashboard.......");
		List<Bookings> booklist = new ArrayList<>();
		booklist= (List<Bookings>)request.getAttribute("bookings");
		System.out.println("Bookings List: " + booklist);

		String a = "Pending";
		String b = "Confirmed";
		if(booklist != null)
		{
			for(Bookings book :booklist)
			{
			
%>
            <div class="bookings">
			<ul class="bookingpage-list">
			<li class="bookingpage-line">Package : <%=book.getPid()%></li>
			<li class="bookingpage-line">Booking ID : <%= book.getId()%></li>
			<li class="bookingpage-line">Number of Participants : <%= book.getNumber()%></li>
			<li class="bookingpage-line">Staff Verification :<% if(book.getVerify() == null){ %> <%=a%> <%}else{ %> <%= b%> <% } %></li>		
		
		</ul>
		
		</div>
		<% } }  %>
		
<%@include file="includes/footer.jsp" %>
</main>
</body>
</html>