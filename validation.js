document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("registerForm");
    const username = document.getElementById("username");
    const email = document.getElementById("email");
    const password = document.getElementById("password");
    const confirmPassword = document.getElementById("confirmPassword");
    const submitBtn = document.getElementById("submitBtn");

    const usernameError = document.getElementById("usernameError");
    const emailError = document.getElementById("emailError");
    const passwordError = document.getElementById("passwordError");
    const confirmPasswordError = document.getElementById("confirmPasswordError");

    function validateForm() {
        let valid = true;

        // Username validation
        if (username.value.trim() === "") {
            usernameError.innerText = "Username is required";
            valid = false;
        } else {
            usernameError.innerText = "";
        }

        // Email validation
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email.value)) {
            emailError.innerText = "Invalid email format";
            valid = false;
        } else {
            emailError.innerText = "";
        }

        // Password validation
        if (password.value.length < 6 || !/[!@#$%^&*]/.test(password.value)) {
            passwordError.innerText = "Password must be at least 6 characters and contain a special character";
            valid = false;
        } else {
            passwordError.innerText = "";
        }

        // Confirm password validation
        if (confirmPassword.value !== password.value) {
            confirmPasswordError.innerText = "Passwords do not match";
            valid = false;
        } else {
            confirmPasswordError.innerText = "";
        }

        submitBtn.disabled = !valid;
    }

    form.addEventListener("input", validateForm);
});
