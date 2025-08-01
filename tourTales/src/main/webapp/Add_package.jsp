<%@include file="includes/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="insert-package-section">

	<div class="insert-package-back-button-container">
		<a href="manage-packages" class="insert-package-back-to-dashboard-btn">Back To Dashboard</a>
	</div>

	<div class="insert-package-container">
		<h2 class="insert-package-form-title">Add Tour Package</h2>

		<form action="add_package" method="post">
			<div class="insert-package-form-group">
				<label for="pname">Package Name</label><br>
				<input type="text" name="pname" placeholder="Enter the package name...." required><br>
			</div>
			<div class="insert-package-form-group">
				<label for="ptype">Package Type</label><br>
				<input type="text" name="ptype" placeholder="Enter the package type...." required><br>
			</div>
			<div class="insert-package-form-group">
				<label for="days">Days</label><br>
				<input type="text" name="days" placeholder="Enter number of days...." required><br>
			</div>
			<div class="insert-package-form-group">
				<label for="budget">Budget</label><br>
				<input type="text" name="budget" placeholder="Enter the budget...." required><br>
			</div>
			<div class="insert-package-form-group">
				<input type="submit" name="submit" value="Add Package" class="insert-package-submit-btn">
			</div>
		</form>
	</div>

</section>

<%@include file="includes/footer.jsp"%>
</body> 
</html>
