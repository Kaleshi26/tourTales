function togglePasswordVisibility() {
    var passwordField = document.getElementById("pass"); //assign the result "pass" to passwordField
    if (passwordField.type === "password") {
        passwordField.type = "text";
    } else {
        passwordField.type = "password";
    }
}

// Function to toggle password visibility on the sign-up page
function showPassword() {
    var passwordField = document.getElementById("psw");
    if (passwordField.type === "password") {
        passwordField.type = "text";
    } else {
        passwordField.type = "password";
    }
}
