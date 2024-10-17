<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Two Column Layout with Calendar</title>
        <link rel="stylesheet" href="./styles/feature-2.css">
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
                <form action="signout" method="post">
                    <div class="auth-buttons">
                        <button class="login-button">Sign Out</button>
                    </div>
                </form>
            </div>
        </header>

        <main class="container">
            <div class="main-content" id="main-content">
                <div id="horoscope-overview-container">
                    <%= request.getAttribute("astrologyContent")%>
                </div>

                <form action="eastern-horoscope" method="post">
                    <div class="horoscope-search">
                        <input type="number" id="birth-year" name="birth-year" placeholder="Enter your birth year">
                        <button id="search-horoscope">Find Horoscope</button>
                    </div>
                </form>

            </div>
            <div class="sidebar">
                <div class="calendar-header">
                    <button id="prev-month" class="nav-button">«</button>
                    <h3 id="calendar-title"></h3>
                    <button id="next-month" class="nav-button">»</button>
                </div>
                <div id="calendar"></div>
                <div id="featured-article">
                    <h3>Featured Articles</h3>
                    <hr>
                    <div class="article">
                        <img src="./assets/images/feature/Tarot2.png" alt="Article Image">
                        <div class="article-content">
                            <h4>What is Tarot?</h4>
                            <p>Learn about tarot and its applications in daily life.</p>
                        </div>
                    </div>
                    <div class="article">
                        <img src="./assets/images/feature/tuvi.png" alt="Article Image">
                        <div class="article-content">
                            <h4>Eastern Horoscope</h4>
                            <p>Origin of Eastern horoscope, how to read horoscope for life.</p>
                        </div>
                    </div>

                    <div class="article">
                        <img src="./assets/images/feature/Zodiac.png" alt="Article Image">
                        <div class="article-content">
                            <h4>Zodiac</h4>
                            <p>Zodiac sign, personality, career suitable for each zodiac sign.</p>
                        </div>
                    </div>
                    <div class="article">
                        <img src="./assets/images/feature/major.png" alt="Article Image">
                        <div class="article-content">
                            <h4>Major Arcana</h4>
                            <p>Full meaning of the main hidden cards in the tarot deck.</p>
                        </div>
                    </div>
                    <div class="article">
                        <img src="./assets/images/feature/tarot.png" alt="Article Image">
                        <div class="article-content">
                            <h4>Spread the cards</h4>
                            <p>How to experience jobs using tarot, detailed instructions.</p>
                        </div>
                    </div>
                </div>

            </div>
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
        <script src="scripts/eastern-feature-2.js"></script>
    </body>

</html>