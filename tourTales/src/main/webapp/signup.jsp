<%@include file="includes/header.jsp" %>
<!DOCTYPE html>

    <div class="signup-box">
        <h2 class="signup-heading">Create an Account</h2>
        <form action="#" method="POST" class="signup-form-wrapper">
            <div class="signup-form-left">
                <div class="signup-field">
                    <label for="signup-fname" class="signup-label">First Name</label>
                    <input type="text" id="signup-fname" name="fname" class="signup-input" placeholder="Enter your first name" required>
                </div>
                <div class="signup-field">
                    <label for="signup-email" class="signup-label">Email Address</label>
                    <input type="email" id="signup-email" name="email" class="signup-input" placeholder="Enter your email" required>
                </div>
                <div class="signup-field">
                    <label for="signup-password" class="signup-label">Password</label>
                    <input type="password" id="signup-password" name="password" class="signup-input" placeholder="Enter your password" required>
                </div>
				<div class="signup-field">
               		 <label for="signup-confirm-password" class="signup-label">Confirm Password</label>
              		 <input type="password" id="signup-confirm-password" name="confirm-password" class="signup-input" placeholder="Confirm your password" required>
        	    </div>
            </div>
            <div class="signup-form-right">
                <div class="signup-field">
                    <label for="signup-lname" class="signup-label">Last Name</label>
                    <input type="text" id="signup-lname" name="lname" class="signup-input" placeholder="Enter your last name" required>
                </div>
                <div class="signup-field">
                    <label for="signup-dob" class="signup-label">Date of Birth</label>
                    <input type="date" id="signup-dob" name="dob" class="signup-input" required>
                </div>
                <div class="signup-field">
                    <label for="signup-country" class="signup-label">Country</label>
                    <input type="text" id="signup-country" name="country" class="signup-input" placeholder="Enter your country" required>
                </div>
				<div class="signup-field">
                    <label for="signup-country" class="signup-label">Contact no</label>
                    <input type="text" id="signup-country" name="contact" class="signup-input" placeholder="Enter your contact number" required>
                </div>
            </div>

            <button type="submit" class="signup-btn">Sign Up</button>
        </form>
        <p class="signup-text">Already have an account? <a href="login" class="signup-link">Login here</a></p>
    </div>

<%@include file="includes/footer.jsp" %>
	
</body>
</html>