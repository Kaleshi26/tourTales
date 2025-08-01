<%@include file="includes/header.jsp" %>

	<div class="login-container">
        <h2>Login</h2>

        <c:if test="${not empty errorMessage}">
            <div class="error-message" style="color: red;">
                ${errorMessage}
            </div>
        </c:if>

        <form action="login" method="post">
            <div class="input-group">
                <label for="email">Email :</label>
                <input type="text" name="email" id="email" required>
            </div>
            
            <div class="input-group">
                <label for="pass">Password :</label>
                <input type="password" name="pass" id="pass" required>
                <input type="checkbox" onclick="togglePasswordVisibility()"> Show Password
            </div>       

            <input type="submit" name="submit" value="Login" class="login-button"> 
        </form>

        <div class="signup-link">
            <p>Don't have an account? <a href="signup">Sign up here</a></p>
        </div>
    </div>
    
    <%@include file="includes/footer.jsp" %>
    <script src="js/login.js"></script>
</body>
</html>