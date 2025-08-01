<%@include file="includes/header.jsp" %>

<div class="centered-container">
 <div class="tour-information-box">
    <div class="tour-information-box">
	
	<h1>Tour Details</h1>
	
	
	
	<c:forEach var="list" items="${listDetails}">
	
	   <c:set var="listID" value="${list.listID}"/>
	   <c:set var="tourtitle" value="${list.tourtitle}"/>
       <c:set var="name" value="${list.packagename}"/>
       <c:set var="count" value="${list.tourcount}"/>
       <c:set var="category" value="${list.category}"/>
       <c:set var="language" value="${list.language}"/>
       <c:set var="email" value="${list.email}"/>
       <c:set var="contact_number" value="${list.contactnumber}"/>
       <c:set var="registration_number" value="${list.registrationnumber}"/>
       <c:set var="description" value="${list.description}"/>
       <c:set var="duration" value="${list.duration}"/>
       <c:set var="price" value="${list.price}"/>
   
    <ul>
    
       <li><b>List ID:</b> ${list.listID}</li>
       <li><b>Tour Title:</b> ${list.tourtitle}</li>
       <li><b>Name:</b> ${list.packagename}</li>
       <li><b>Count:</b> ${list.tourcount}</li>
       <li><b>Category:</b> ${list.category}</li>
       <li><b>Language:</b> ${list.language}</li>
       <li><b>Email Address:</b> ${list.email}</li>
       <li><b>Contact Number:</b> ${list.contactnumber}</li>
       <li><b>Registration Number:</b> ${list.registrationnumber}</li>
       <li><b>Description:</b> ${list.description}</li>
       <li><b>Duration:</b> ${list.duration}</li>
       <li><b>Price:</b> ${list.price}</li>
       
     </ul>
     </c:forEach>
     

	<c:url value="updatelist.jsp" var="listupdate">
    	<c:param name="listID" value="${listID}"/>
    	<c:param name="tourtitle" value="${tourtitle}"/>
    	<c:param name="name" value="${name}"/>
    	<c:param name="count" value="${count}"/>
    	<c:param name="category" value="${category}"/>
    	<c:param name="language" value="${language}"/>
    	<c:param name="email" value="${email}"/>
    	<c:param name="contact_number" value="${contact_number}"/>
    	<c:param name="registration_number" value="${registration_number}"/>
    	<c:param name="description" value="${description}"/>
    	<c:param name="duration" value="${duration}"/>
    	<c:param name="price" value="${price}"/>
    
    </c:url>
	<a href="${listupdate}"> 
		<input type="button" name="update" value="Update">
	</a>
	
	<br>
    <br>
    <c:url value="deletelist.jsp" var="listdelete">
    	<c:param name="listID" value="${listID}"/>
    	<c:param name="tourtitle" value="${tourtitle}"/>
    	<c:param name="name" value="${name}"/>
    	<c:param name="count" value="${count}"/>
    	<c:param name="category" value="${category}"/>
    	<c:param name="language" value="${language}"/>
    	<c:param name="email" value="${email}"/>
    	<c:param name="contactnumber" value="${contact_number}"/>
    	<c:param name="registration_number" value="${registration_number}"/>
    	<c:param name="description" value="${description}"/>
    	<c:param name="duration" value="${duration}"/>
    	<c:param name="price" value="${price}"/>
    </c:url>
    <a href="${listdelete}">
    <input type = "button" name = "delete" value = "Delete List">
    </a>
	</div>
	</div>
</div>
	
<%@include file="includes/footer.jsp" %>
	
</body>
</html>