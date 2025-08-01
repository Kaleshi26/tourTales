<%@include file="includes/header.jsp"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1 class="page-title">Tour Guides</h1>

<form action="assign-guide" method="post" class="assign-guide-form">
	<input type="hidden" name="id" value="${ id }">

	<table class="assign-guide-table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Contact No</th>
				<th>License No</th>
				<th>Years of Experience</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ tourGuides }" var="guide">
				<tr>
					<td>${ guide.fName } ${ guide.lName }</td>
					<td>${ guide.email }</td>
					<td>${ guide.contact_no }</td>
					<td>${ guide.license_no }</td>
					<td>${ guide.exp_year }</td>
					<td>
						<button type="submit" name="guide-id" value="${ guide.id }"
							class="assign-guide-button">assign</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
</body>
</html>