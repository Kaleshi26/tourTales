<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="includes/header.jsp"%>

<section class="update-package-section">
	<div class="back-button-container">
		<a href="manage-packages" class="back-to-dashboard-btn">Back To Dashboard</a>
	</div>

	<div class="update-package-container">
		<h2 class="form-title">Update Tour Package</h2>

		<form action="update-package" method="post">
			<input type="hidden" name="pid" value="<c:out value='${pk.id }'/>">

			<div class="form-group">
				<label for="pname">Package Name</label><br>
				<input type="text" name="pname" value="<c:out value='${pk.packName }'/>"><br>
			</div>
			<div class="form-group">
				<label for="ptype">Package Type</label><br>
				<input type="text" name="ptype" value="<c:out value='${pk.packType }'/>"><br>
			</div>
			<div class="form-group">
				<label for="days">Days</label><br>
				<input type="text" name="days" value="<c:out value='${pk.days }'/>" required><br>
			</div>
			<div class="form-group">
				<label for="budget">Budget</label><br>
				<input type="text" name="budget" value="<c:out value='${pk.pBudget }'/>" required><br>
			</div>
			<div class="form-group">
				<input type="submit" name="submit" value="Update Package" class="submit-btn">
			</div>
		</form>
	</div>
</section>

<%@include file="includes/footer.jsp"%>
</body>
</html>
