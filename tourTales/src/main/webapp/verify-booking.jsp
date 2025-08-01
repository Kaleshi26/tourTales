<%@include file="/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container"></div>

<form action="verify-booking?id=${ booking.booking_id }" method="post"
	class="verify-booking-form">
	<h1 class="verify-booking-title">Verify Booking</h1>
	<div class="verify-booking-layout">
		<div class="left-column">
			<div class="section">
				<h2 class="section-title">Booking Details</h2>
				<p>
					<strong>Booking ID:</strong> <span>${ booking.booking_id }</span>
				</p>
				<p>
					<strong>Booking Status:</strong> <span>${ booking.booking_status }</span>
				</p>
				<p>
					<strong>No. of Participants:</strong> <span>${ booking.participants }</span>
				</p>
				<p>
					<strong>Tour Date:</strong> <span>${ booking.tour_date }</span>
				</p>
				<p>
					<strong>Budget:</strong> <span>${ booking.budget }</span>
				</p>
				<p>
					<strong>Package Name:</strong> <span>Exotic Thailand Tour</span>
				</p>
			</div>
			<div class="section">
				<h2 class="section-title">Payment Details</h2>
				<p>
					<strong>Payment ID:</strong> <span>${ payment.id }</span>
				</p>
				<p>
					<strong>Payment Status:</strong> <span>${ booking.verification } </span>
				</p>
				<p>
					<strong>Payment Date:</strong> <span>${ payment.date }</span>
				</p>
				<p>
					<strong>Payment Amount:</strong> <span>${ payment.amount }</span>
				</p>
			</div>
			<div>
				<label for="verification">booking verification status: </label> <select
					id="verification" name="verification" class="verify-select">
					<option
						<c:if test="${ booking.verification == 'Verified' }">selected="selected"</c:if>
						value="Verified">verified</option>
					<option
						<c:if test="${ booking.verification == 'Cancelled' }">selected="selected"</c:if>
						value="Cancelled">cancel</option>
					<option
						<c:if test="${ booking.verification == 'Pending' }">selected="selected"</c:if>
						value="Pending">pending</option>
				</select>

			</div>
		</div>

		<div class="right-column">
			<div class="customer-details">
				<h2 class="section-title">Customer Details</h2>
				<p>
					<strong>Name:</strong> <span>${ customer.fName } ${ customer.lName }
					</span>
				</p>
				<p>
					<strong>Country:</strong> <span>${ customer.country }</span>
				</p>
				<p>
					<strong>Contact No:</strong> <span>${ customer.contact_no }</span>
				</p>
				<p>
					<strong>Email:</strong> <span>${ customer.email }</span>
				</p>
			</div>

			<div class="tour-guide-details">
				<h2 class="section-title">Tour Guide Details</h2>
				<c:if test="${ empty booking.guide_id }">
					<a href="assign-guide?id=${ booking.booking_id }"
						class="verify-booking-button">Assign Tour Guide</a>
				</c:if>
				<c:if test="${ not empty booking.guide_id }">
					<p>
						<strong>Name:</strong> <span>${ guide.fName } ${ guide.lName }</span>
					</p>
					<p>
						<strong>Contact No:</strong> <span>${ guide.contact_no }</span>
					</p>
					<p>
						<strong>Email:</strong> <span>${ guide.email }</span>
					</p>
				</c:if>
			</div>
			<div>
				<button type="submit" name="sub" value="done"
					class="verify-booking-button verify-booking-button--green">done</button>
				<button type="submit" name="sub" value="cancel"
					class="verify-booking-button verify-booking-button--red">cancel
					booking</button>
			</div>

		</div>
	</div>
</form>


<%@include file="/includes/footer.jsp"%>
