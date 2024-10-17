<%-- 
    Document   : register
    Created on : Jul 4, 2024, 5:22:58 PM
    Author     : Luu Chi Khanh-CE181175
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>
        <link rel="stylesheet" href="./styles/styles2741984.css">
    </head>

    <body>
        <div class="background">
            <video autoplay loop muted plays-inline class="back-video">
                <source src="./assets/videos/starry.mp4" type="video/mp4">
            </video>
        </div>
        <div class="login-box">
            <h2>Register</h2>
            <h3>${requestScope.msg}</h3>
            <form action="register" onsubmit="return validateForm()">
                <div class="user-box">
                    <input type="text" name="username" required>
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input type="email" name="email" required>
                    <label>Email</label>
                </div>
                <div class="user-box">
                    <input type="password" name="password" required>
                    <label>Password</label>
                </div>
                <div class="user-box">
                    <input type="password" name="confirm-password" required>
                    <label>Confirm Password</label>
                </div>
                <div class="dob-box">
                    <label for="dob">Date of Birth</label>
                    <input type="date"  id="dob" name="dob" min="1900-01-01" required>
                </div>
                <div class="buttons">
                    <button type="submit">Register</button>
                    <button type="button" onclick="window.location.href = 'login.jsp'">Back to Login</button>
                </div>
            </form>
        </div>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                const today = new Date().toISOString().split('T')[0]; // Get today's date in YYYY-MM-DD format
                document.getElementById('dob').setAttribute('max', today);
            });

            function validateForm() {
                const password = document.querySelector('input[name="password"]').value;
                const confirmPassword = document.querySelector('input[name="confirm-password"]').value;

                if (password !== confirmPassword) {
                    alert("Passwords do not match. Please try again.");
                    return false;
                }
                return true;
            }
        </script>
    </body>

</html>
