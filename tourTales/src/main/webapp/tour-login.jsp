<%@include file="includes/header.jsp" %>

<div class="centered-container">
    <div class="tour-information-box">
	
	<h1>Tours</h1>
	
	<h4>Click here to see your Tours </h4>
	<form action="tour-login" method="post">
		<b>Registration Number</b> <input type="text" name="registrationnumber" placeholder="registration number"><br>
		<input type="submit" name="submit" value="Submit">
	</form>
	
	</div>
</div>
	
<%@include file="includes/footer.jsp" %>
	
</body>
</html>