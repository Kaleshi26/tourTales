<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="includes/header.jsp"%>
<section class="manage-package-section">
	<div class="manage-package-container">
		<h1 class="dashboard-title">Package Dashboard</h1>
		<a href="add_package" class="add-package-btn"
			style="background-color: #28a745; color: white; padding: 12px 24px; font-size: 16px; border-radius: 8px; text-decoration: none;">Add
			New Package</a>

		<table class="package-table">
			<thead class="table-header">
				<tr>
					<th>Package Id</th>
					<th>Package Name</th>
					<th>Type</th>
					<th>Days</th>
					<th>Budget</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="tp" items="${pkg }">
					<tr class="table-row">
						<td><c:out value="${tp.id }"></c:out></td>
						<td><c:out value="${tp.packName }"></c:out></td>
						<td><c:out value="${tp.packType }"></c:out></td>
						<td><c:out value="${tp.days }"></c:out></td>
						<td><c:out value="${tp.pBudget }"></c:out></td>
						<td class="action-buttons">
							<a href="update-package?id=<c:out value='${tp.id }'/>" class="update-btn"
								style="background-color: #007bff; color: white; padding: 8px 16px; font-size: 14px; border-radius: 5px; text-decoration: none;">Update</a>
							<a href="delete-package?id=<c:out value='${tp.id }'/>" class="delete-btn"
								style="background-color: #dc3545; color: white; padding: 8px 16px; font-size: 14px; border-radius: 5px; text-decoration: none;"
								onclick="return confirm('Are you sure you want to delete this package?');">Delete</a>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</section>

<%@include file="includes/footer.jsp"%>

</body>
</html>
