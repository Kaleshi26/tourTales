<%@include file="includes/header.jsp" %>


<!-- The rest of your HTML content, including the form and details box -->
<div class="tourlist-centered-container">
    <div class="tourlist-tour-information-box">
        <h1>Create the Tour</h1>
        <form action="insert" method="post" id="tourForm">
            <div class="tourlist-form-group">
                <label for="tourtitle">Tour Title:<span class="required">*</span></label>
                <input type="text" name="tourtitle" id="tourtitle">
            </div>
            <div class="tourlist-form-group">
                <label for="name">Package Name:<span class="required">*</span></label>
                <input type="text" name="name" id="name">
            </div>
            <div class="tourlist-form-group">
                <label for="count">tourist's count:<span class="required">*</span></label>
                <input type="text" name="count" id="count">
            </div>
            <div class="tourlist-form-group">
                <label for="category">Category:<span class="required">*</span></label>
                <input type="text" name="category" id="category">
            </div>
            <div class="tourlist-form-group">
                <label for="language">Language:<span class="required">*</span></label>
                <input type="text" name="language" id="language">
            </div>
            <div class="tourlist-form-group">
                <label for="email">Email Address:<span class="required">*</span></label>
                <input type="email" name="email" id="email">
            </div>
            <div class="tourlist-form-group">
                <label for="contact_number">Contact Number:<span class="required">*</span></label>
                <input type="tel" name="contact_number" id="contact_number" pattern="^\d{10}$" title="Please enter a valid 10-digit phone number" required>
                <span class="tourlist-error-message">Please enter a valid 10-digit phone number.</span>
            </div>
            <div class="tourlist-form-group">
                <label for="registration_number">Registration Number:<span class="required">*</span></label>
                <input type="text" name="registration_number" id="registration_number" pattern="^T\d{3}$" title="Please enter a valid registration number (e.g., T123)" required>
                <span class="tourlist-error-message">Please enter a valid registration number (e.g., T123).</span>
            </div>
            <div class="tourlist-form-group">
                <label for="description">Description:<span class="required">*</span></label>
                <textarea name="description" id="description"></textarea>
            </div>
            <div class="tourlist-form-group">
                <label for="duration">Duration:<span class="required">*</span></label>
                <input type="text" name="duration" id="duration">
            </div>
            <div class="tourlist-form-group">
                <label for="price">Price:<span class="required">*</span></label>
                <input type="text" name="price" id="price" pattern="^\$?\d+(\.\d{1,2})?$" title="Please enter a valid price (e.g., $99.99)" required>
                <span class="tourlist-error-message">Please enter a valid price (e.g., $80.12).</span>
            </div>
            <input type="submit" name="submit" value="Submit">
            <a href="tour-login.jsp"><b>Click here to Search a tour</b></a>
        </form>
    </div>
</div>

<%@include file="includes/footer.jsp" %>

</body>
</html>
