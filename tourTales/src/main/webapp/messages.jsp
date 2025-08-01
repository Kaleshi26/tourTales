<%@include file="includes/header.jsp"%>
<%@include file="includes/userDashboardLayoutStart.jsp"%>


<h1 class="page-title">Messages</h1>

<button class="new-message-button" onclick="openForm()">New
	Message</button>

<form class="new-message-form" action="messages" method="post"
	id="message-form">
	<input type="hidden" name="type" value="new">
	<div class="new-message-form-content">
		<span class="close-button" onclick="closeForm()">×</span>
		<h2 class="new-message-h2">New Message</h2>
		<div class="form-group">
			<label class="new-message-label" for="sender-email">Sender
				Email</label> <input class="new-message-email" type="email" name="email"
				id="sender-email" placeholder="Enter email" required>
		</div>
		<div class="form-group">
			<label class="new-message-label" for="new-message">Message</label>
			<textarea class="new-message-textarea" id="new-message"
				name="new-message" placeholder="Enter your message" required></textarea>
		</div>

		<button class="send-button">Send</button>
	</div>
</form>


<div class="messages-container">

	<c:forEach items="${ messages }" var="message">
		<div class="message-card">
			<div class="message-details">
				<p>
					<strong>From:</strong> ${ message.sender_email }
				</p>
				<br>
				<p>${ message.message }</p>
			</div>
			<form action="messages" method="post">
				<input type="hidden" name="type" value="delete">
				<input type="hidden" name="msg-id" value="${ message.msg_id }">
				<button type="submit" class="delete-button">Delete</button>
			</form>
		</div>
	</c:forEach>
</div>


<%@include file="includes/userDashboardLayoutEnd.jsp"%>
<%@include file="includes/footer.jsp"%>

<
<script src="js/messages.js"></script>
</body>
</html>
