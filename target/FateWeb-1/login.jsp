<%-- 
    Document   : login
    Created on : Jul 4, 2024, 5:17:06 PM
    Author     : Luu Chi Khanh-CE181175
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" href="./styles/styles.css">
    </head>

    <body>
        <div class="background">
            <video class="back-video" autoplay muted loop>
                <source src="./assets/videos/starry.mp4" type="video/mp4">
            </video>
        </div>
        <div class="login-box">
            <h2>Login</h2>
            <h3>${requestScope.msg}</h3>
            <c:set var="cookie" value ="${pageContext.request.cookies}"/>
            <form action="login" method="post">
                <div class="user-box">
                    <input type="text" name="username" value="${cookie.username.value}" required>
                    <label>Username</label>
                </div>
                <div class="user-box">
                    <input type="password" name="password" value="${cookie.password.value}" required>
                    <label>Password</label>
                </div>
                <div class="options">
                    <input type="checkbox" id="remember-me" 
                           ${(cookie.remember!=null?'checked':'')}
                           name="remember-me" value ="ON">
                    <label for="remember-me">Remember Me</label>
                </div>
                <div class="buttons">
                    <button type="submit">Login</button>
                    <button type="button" onclick="window.location.href = 'register.jsp'">Register</button>
                </div>
            </form>
        </div>
    </body>

</html>
