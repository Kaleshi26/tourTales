<%@include file="includes/header.jsp" %>


<div class="centered-container">
    <div class="tour-information-box">
	<h1>Update Tour Details</h1>

	<%
		String listID =request.getParameter("listID");
		String tourtitle = request.getParameter("tourtitle");
		String name = request.getParameter("name");
		String count = request.getParameter("count");
		String category = request.getParameter("category");
		String language = request.getParameter("language");
		String email = request.getParameter("email");
		String contact_number = request.getParameter("contact_number");
		String registration_number = request.getParameter("registration_number");
		String description = request.getParameter("description");
		String duration = request.getParameter("duration");
		String price = request.getParameter("price");
		
	%>

	<form action="update" method="post">
		List ID <input type="text" name="listID" value="<%= listID %>" readonly ><br>
		Tour Title<input type="text" name="tourtitle" value="<%= tourtitle %>"><br>
		Name<input type="text" name="name" value="<%= name %>"><br>
		Count<input type="text" name="count" value="<%= count %>"><br>
		Category<input type="text" name="category" value="<%= category %>"><br>
		Language<input type="text" name="language" value="<%= language %>"><br>
		Email Address<input type="email" name="email" value="<%= email %>"><br>
		Contact Number<input type="text" name="contact_number" value="<%= contact_number %>"><br>
		Registration Number<input type="text" name="registration_number" value="<%= registration_number %>" readonly ><br>
		Description<input type="text" name="description" value="<%= description %>"><br>
		Duration<input type="text" name="duration" value="<%= duration %>"><br>
		Price<input type="text" name="price" value="<%= price %>"><br>
		
		<input type="submit" name="submit" value="Update My List"><br>
		
	</form>
	</div>
	</div>

<%@include file="includes/footer.jsp" %>
	
</body>
</html>