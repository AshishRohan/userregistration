<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link rel="stylesheet" href="style.css">
    <script defer src="validation.js"></script>
</head>
<body>
    <div class="container">
        <h2>User Registration</h2>
        <form id="registerForm" action="RegisterServlet" method="post">
            <label>Username:</label>
            <input type="text" id="username" name="username">
            <small class="error" id="usernameError"></small>

            <label>Email:</label>
            <input type="email" id="email" name="email">
            <small class="error" id="emailError"></small>

            <label>Password:</label>
            <input type="password" id="password" name="password">
            <small class="error" id="passwordError"></small>

            <label>Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword">
            <small class="error" id="confirmPasswordError"></small>

            <button type="submit" id="submitBtn" disabled>Register</button>
        </form>
    </div>
</body>
</html>
