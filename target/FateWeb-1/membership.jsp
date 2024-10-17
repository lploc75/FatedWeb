<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Membership Page</title>
        <link rel="stylesheet" href="./styles/membership.css">
    </head>
    <body>
        <div class="background">
            <video class="back-video" autoplay muted loop>
                <source src="./assets/videos/HomeBG.mp4" type="video/mp4">
            </video>
            <div class="overlay"></div>
        </div>
        <header>
            <div class="container">
                <div class="logo">
                    <img src="./assets/images/logo/logo.png" alt="Site Logo">
                </div>

                <%-- Kiểm tra nếu userrank.type là Member --%>
                <c:choose>
                    <c:when test="${sessionScope.userrank.type == 'Member'}">
                        <nav>
                            <ul>
                                <li class="menu-item"><a href="homepage">Home</a></li>
                                <li class="menu-item dropdown">
                                    <a href="#">Western</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#" onclick="alertFeatureLocked()">Western Feature 1</a></li>
                                        <li><a href="#" onclick="alertFeatureLocked()">Western Feature 2</a></li>
                                    </ul>
                                </li>
                                <li class="menu-item dropdown">
                                    <a href="#">Eastern</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#" onclick="alertFeatureLocked()">Eastern Feature 1</a></li>
                                        <li><a href="#" onclick="alertFeatureLocked()">Eastern Feature 2</a></li>
                                    </ul>
                                </li>
                                <li class="menu-item"><a href="membership">Membership</a></li>
                            </ul>
                        </nav>
                    </c:when>
                    <c:otherwise>
                        <nav>
                            <ul>
                                <li class="menu-item"><a href="homepage">Home</a></li>
                                <li class="menu-item dropdown">
                                    <a href="#">Western</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="westernfeature1">Western Feature 1</a></li>
                                        <li><a href="westernfeature2">Western Feature 2</a></li>
                                    </ul>
                                </li>
                                <li class="menu-item dropdown">
                                    <a href="#">Eastern</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="eastern-feature-1">Eastern Feature 1</a></li>
                                        <li><a href="eastern-horoscope">Eastern Feature 2</a></li>
                                    </ul>
                                </li>
                                <li class="menu-item"><a href="membership">Membership</a></li>
                            </ul>
                        </nav>
                    </c:otherwise>
                </c:choose>

                <form action="signout" method="post">
                    <div class="auth-buttons">
                        <button class="login-button">Sign Out</button>
                    </div>
                </form>
            </div>
        </header>


        <main class="container">
            <form action="membership" method="post">
                <div class="main-container">
                    <div class="content-box">
                        <h1>VIP MEMBERSHIP</h1>
                        <p>Become a lifetime member and enjoy VIP member privileges. One and forever.</p>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            <span class="icon-overlay"></span>
                            Unlock the Eastern horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Draw Card feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Western horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Weak Element feature
                        </h2>
                        <h1>
                            <br>
                            Only 19.99 $
                        </h1>
                        <button type="submit" name="membership" value="vip" class="register-button"
                                <c:if test="${currentMembership == 'Vip' || currentMembership == 'Vip++'}">disabled</c:if>>
                                    Get A Plan
                                </button>
                        <c:if test="${currentMembership == 'Vip'}">
                            <p>You are already a VIP member</p>
                        </c:if>
                    </div>
                                    
                    <div class="content-box">
                        <h1>VIP++ MEMBERSHIP</h1>
                        <p>Become a lifetime member and enjoy VIP++ member privileges. One and forever.</p>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Eastern horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Draw Card feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Western horoscope feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Unlock the Weak Element feature
                        </h2>
                        <h2>
                            <img src="./assets/images/feature/vip.png" alt="icon">
                            Chat One-on-One with our mentors
                        </h2>
                        <h1>
                            <br>
                            Only 39.99 $
                        </h1>
                        <button type="submit" name="membership" value="vip++" class="register-button"
                                <c:if test="${ currentMembership == 'Vip++'}">disabled</c:if>>
                                    Get B Plan
                                </button>
                        <c:if test="${ currentMembership == 'Vip++'}">
                            <p>You are already a VIP++ member</p>
                        </c:if>

                    </div>
                </div>  
            </form>
        </main>

       <footer>
            <div class="container">
                <div class="footer-content">
                    <div class="footer-left">
                        <img src="./assets/images/logo/logo.png" alt="Company Logo" class="footer-logo">
                    </div>
                    <div class="footer-right">
                        <div class="footer-section">
                            <h4>Feature</h4>
                            <ul>
                               <li><a href="westernfeature1">Tarot Reader</a></li>
                                <li><a href="westernfeature2">Zodiac</a></li>
                                <li><a href="eastern-feature-1">Weak Element</a></li>
                                <li><a href="eastern-horoscope">Horoscope</a></li>
                            </ul>
                        </div>
                        <div class="footer-section">
                            <h4>Services</h4>
                            <ul>
                                <li><a href="#">Help</a></li>
                                <li><a href="#">Contact Us</a></li>
                            </ul>
                        </div>
                        <div class="footer-section">
                            <h4>Company</h4>
                            <ul>
                                <li><a href="#">Terms & conditions</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                            </ul>
                        </div>
                        <div class="footer-section">
                            <h4>Get in touch</h4>
                            <ul class="social-media">
                                <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                            </ul>
                            <div class="subscribe-form">
                                <input type="email" placeholder="Enter email address">
                                <button>Subscribe</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
                                    
        <script src="scripts/membership.js"></script>
    </body>
</html>