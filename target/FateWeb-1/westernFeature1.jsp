<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Two Column Layout with Tarot Cards</title>
        <link rel="stylesheet" href="styles/western-1.css">
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
                <h1>Using a Single Card in Yes/No Tarot Readings</h1>
                <div class="section-content">
                    <h2>1. Introduction</h2>
                    <p>Using a single card for Yes/No tarot readings is one of the simplest and most direct approaches in tarot. This method is suitable for questions that require quick, decisive answers without the need for detailed or in-depth analysis.</p>
                </div>
                <div class="section-content">
                    <h2>2. Procedure</h2>
                    <h3>2.1. Preparation</h3>
                    <p><strong>Define the Question:</strong> The querent needs to clearly define the question they want to be answered with a "Yes" or "No". The question should be framed in a way that it can be answered definitively with "Yes" or "No".</p>
                    <p><strong>Cleanse the Deck:</strong> Before drawing the card, the reader should cleanse the deck's energy by shuffling it thoroughly and focusing on the question.</p>
                    <h3>2.2. Drawing the Card</h3>
                    <p><strong>Draw a Single Card:</strong> The reader draws a single card from the tarot deck. This card will represent the answer to the question.</p>
                    <h3>2.3. Interpreting the Card</h3>
                    <p><strong>Predefined Meaning:</strong> Before drawing the card, the reader should have a clear convention for interpretation:</p>
                    <ul>
                    </ul>
                    <p><strong>Quick Analysis:</strong> The reader can add a layer of quick interpretation based on intuition and the general meaning of the card to better understand the context of the answer.</p>
                </div>
                <div class="section-content">
                    <h2>3. Advantages and Limitations</h2>
                    <h3>3.1. Advantages</h3>
                    <ul>
                        <li><strong>Quick:</strong> This method allows the reader to get an answer quickly without extensive analysis.</li>
                        <li><strong>Simple:</strong> It does not require much skill or experience to perform, making it suitable for both beginners and experienced readers.</li>
                    </ul>
                    <h3>3.2. Limitations</h3>
                    <ul>
                        <li><strong>Limited Information:</strong> Since it relies on a single card, the information obtained may be limited and might not provide a comprehensive view of the situation.</li>
                        <li><strong>Dependent on Intuition:</strong> It requires the reader to have good intuition to interpret accurately within the context of the question.</li>
                    </ul>
                </div>

                <h1> Speard Card</h1>
                <div class="card-container">
                    <div class="card" id="card1">
                        <img src="assets/images/tarot-card/0.png" alt="Card 1">
                    </div>
                    <div class="card" id="card2">
                        <img src="assets/images/tarot-card/0.png" alt="Card 2">
                    </div>
                    <div class="card" id="card3">
                        <img src="assets/images/tarot-card/0.png" alt="Card 3">
                    </div>
                </div>

                <div class="question-container">
                    <h3>Chọn vấn đề bạn muốn hỏi:</h3>

                    <form action="westernfeature1" method="post">
                        <button type="submit" class="question-button" name="question" value="wish">Ước muốn</button>
                        <button type="submit" class="question-button" name="question" value="love">Tình yêu</button>
                        <button type="submit" class="question-button" name="question" value="career">Sự nghiệp</button>
                        <button type="submit" class="question-button" name="question" value="study">Thi cử</button>
                    </form>
                </div>

                <c:choose>
                    <c:when test="${not empty sessionScope['card-description']}">
                        <div id="card-interpretation" class="card-interpretation" style="display: block;">
                            <h3>Luận giải</h3>
                            <img id="card-result" src="${sessionScope['card-url']}" alt="Card Image" style="width: 150px; height: auto; margin: 0 auto; display: block;">
                            <p id="interpretation-text">${sessionScope['card-description']}</p>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div id="card-interpretation" class="card-interpretation" style="display: none;"></div>
                    </c:otherwise>
                </c:choose>
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
                            <p>Full meaning of the Major Arcana cards in the tarot deck.</p>
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
        
        <script src="scripts/western-feature-1.js"></script>
    </body>

</html>
