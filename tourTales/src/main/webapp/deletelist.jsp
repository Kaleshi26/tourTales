<%@include file="includes/header.jsp" %>

<div class="centered-container">
    <div class="tour-information-box">
    
    

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
	
	<h1> Delete List </h1>
	
	<form action="delete" method="post">
		List ID <input type="text" name="listID" value="<%= listID %>" readonly ><br>
		Tour Title<input type="text" name="tourtitle" value="<%= tourtitle %>" readonly><br>
		Name<input type="text" name="name" value="<%= name %>" readonly><br>
		Count<input type="text" name="count" value="<%= count %>" readonly><br>
		Category<input type="text" name="category" value="<%= category %>" readonly><br>
		Language<input type="text" name="language" value="<%= language %>" readonly><br>
		Email Address<input type="email" name="email" value="<%= email %>" readonly><br>
		Contact Number<input type="text" name="contact_number" value="<%= contact_number %>" readonly><br>
		Registration Number<input type="text" name="registration_number" value="<%= registration_number %>" readonly><br>
		Description<input type="text" name="description" value="<%= description %>" readonly><br>
		Duration<input type="text" name="duration" value="<%= duration %>" readonly><br>
		Price<input type="text" name="price" value="<%= price %>" readonly><br>
		
		<input type="submit" name="submit" value="Delete List "><br>
		
	</form>
	</div>
</div>


<%@include file="includes/footer.jsp" %>
	
</body>
</html>