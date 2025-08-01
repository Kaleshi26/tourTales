<%@include file="includes/header.jsp" %>
<%@include file="includes/userDashboardLayoutStart.jsp" %>
	
	<h1 class="page-title">New Bookings</h1>
	<div class="booking-rows">
	
	<c:forEach var="booking" items="${bookings}">
            <div class="booking-row">
                <div class="booking-details">
                    <p><strong>Booking ID:</strong> ${ booking.booking_id }</p>
                    <p><strong>Payment Status</strong> ${ booking.verification }</p>
                    <p><strong>Tour Date:</strong> ${ booking.tour_date }</p>
                    <p><strong>No. of Participants:</strong> ${ booking.participants }</p>
					<p><strong>Pick-up Location:</strong> ${ booking.pickup_loc }</p>
                </div>
                <div class="booking-action">
                    <a href="verify-booking?id=${ booking.booking_id }" class="verify-button">Verify Booking</a>
                </div>
            </div>

	</c:forEach> 
    </div>
	
	
<%@include file="includes/userDashboardLayoutEnd.jsp" %>
<%@include file="includes/footer.jsp" %>
	
</body>
</html>
