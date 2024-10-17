<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home Page</title>
        <link rel="stylesheet" href="./styles/homestyle.css">
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

        <main class="main-content">
            <div class="upper-content-container">
                <div class="user-info-container">
                    <h1>User Information</h1>
                    <div class="user-info-content">
                        <div class="user-info-left">
                            <img id="user-image" src="./assets/images/user/user.jpg" alt="User Image">
                            <p class="membership">Rank: <span id="membership-status">${sessionScope.userrank.type}</span></p>
                            <!--                            <p class="active-since">Hoạt động từ: <span id="active-since">2020</span></p>-->
                        </div>
                        <div class="user-info-right">
                            <p><strong>Full Name:</strong> <span id="user-name">${sessionScope.user.fullname}</span></p>
                            <p><strong>Day of birth:</strong> <span id="user-dob">${sessionScope.user.dob}</span></p>
                            <p><strong>Gender:</strong> <span id="user-gender">${sessionScope.user.gender}</span></p>
                        </div>
                    </div>
                    <form action="editprofile" method="post">
                        <button type="submit" class="edit-profile">Edit Profile</button>
                    </form>
                </div>

                <div class="card-info-container">
                    <div class="card-today">
                        <img id="card-image" src="${sessionScope.cardImage != null ? sessionScope.cardImage : './assets/images/tarot-card/0.png'}" alt="Today's Card" class="card-image">
                        <p class="card-caption">${sessionScope.cardDescription != null ? sessionScope.cardDescription : 'What does the future have in store for you? Now is time to discover the day’s possibilities!'}</p>
                        <button class="draw-card" onclick="document.getElementById('card-modal').style.display = 'block'">Draw new card</button>
                    </div>
                </div>

                <div class="moon-container">
                    <div class="moon-phase">
                        <!-- Thêm div để hiển thị hình ảnh chu kỳ mặt trăng -->
                        <div id="moon-phase-image-container" class="moon-image-container">
                            <img id="moon-phase-image" src="" alt="Moon Phase" class="moon-phase-image">
                            <div class="moon-phase-info" id="moon-phase-info">
                                <h2>Current Moon Phase:</h2>
                                <span id="current-moon-phase"></span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Combined content section -->
            <div class="combined-content-container">
                <div class="combined-content">
                    <div class="content-item text-item">
                        <h2>Con giáp</h2>
                        <p id="zodiac-name"></p>
                    </div>
                    <div class="separator"></div>
                    <div class="content-item image-item">
                        <img id="zodiac-image" src="" alt="Zodiac Image">
                    </div>
                    <div class="separator"></div>
                    <div class="content-item text-item">
                        <h2>Cung hoàng đạo</h2>
                        <p id="western-zodiac-name"></p>
                    </div>
                    <div class="separator"></div>
                    <div class="content-item image-item">
                        <img id="western-zodiac-image" src="" alt="Western Zodiac Image">
                    </div>
                </div>
            </div>

            <%-- Kiểm tra nếu userrank.type là Member --%>
            <c:choose>
                <c:when test="${sessionScope.userrank.type == 'Member'}">
                    <!-- Các ô nổi bật cho Member -->
                    <div class="featured-functions-container">
                        <div class="featured-function-container">
                            <div class="featured-function-content">
                                <img id="featured-function3-image" src="./assets/images/functions/function-1.png" alt="Featured Function"
                                     class="card-image">
                                <div class="function-description">
                                    <p>Tarot Reader: Discover insights and guidance for your future through tarot reading.</p>
                                </div>
                                <button class="explore-feature3" onclick="alertFeatureLocked()">Explore</button>
                            </div>
                        </div>

                        <div class="featured-function-container">
                            <div class="featured-function-content">
                                <img id="featured-function2-image" src="./assets/images/functions/function-2.png" alt="Featured Function"
                                     class="card-image">
                                <div class="function-description">
                                    <p>Zodiac Explore: Learn about your zodiac sign and its influence on your life.</p>
                                </div>
                                <button class="explore-feature2" onclick="alertFeatureLocked()">Explore</button>

                            </div>
                        </div>

                        <div class="featured-function-container">
                            <div class="featured-function-content">
                                <img id="featured-function1-image" src="./assets/images/functions/function-3.png" alt="Featured Function"
                                     class="card-image">
                                <div class="function-description">
                                    <p>Horoscope Explore: Get daily, weekly, and monthly horoscope predictions.</p>
                                </div>
                                <button class="explore-feature3" onclick="alertFeatureLocked()">Explore</button>
                            </div>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <!-- Các ô nổi bật cho user không phải là Member -->
                    <div class="featured-functions-container">
                        <div class="featured-function-container">
                            <div class="featured-function-content">
                                <img id="featured-function3-image" src="./assets/images/functions/function-1.png" alt="Featured Function"
                                     class="card-image">
                                <div class="function-description">
                                    <p>Tarot Reader: Discover insights and guidance for your future through tarot reading.</p>
                                </div>
                                <form action="westernfeature1">
                                    <button class="explore-feature3">Explore</button>
                                </form>
                            </div>
                        </div>

                        <div class="featured-function-container">
                            <div class="featured-function-content">
                                <img id="featured-function2-image" src="./assets/images/functions/function-2.png" alt="Featured Function"
                                     class="card-image">
                                <div class="function-description">
                                    <p>Zodiac Explore: Learn about your zodiac sign and its influence on your life.</p>
                                </div>
                                <form action="westernfeature2">
                                    <button class="explore-feature2">Explore</button>
                                </form>
                            </div>
                        </div>

                        <div class="featured-function-container">
                            <div class="featured-function-content">
                                <img id="featured-function1-image" src="./assets/images/functions/function-3.png" alt="Featured Function"
                                     class="card-image">
                                <div class="function-description">
                                    <p>Horoscope Explore: Get daily, weekly, and monthly horoscope predictions.</p>
                                </div>
                                <form action="eastern-horoscope">
                                    <button class="explore-feature3">Explore</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
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
            
        <div id="card-modal" class="modal">
            <div id="modal-content" class="modal-content">
                <span class="close-button">&times;</span>
                <h2>Pick Your Card</h2>
                <div class="cards-container">                  
                    <div class="card-item">
                        <img src="./assets/images/tarot-card/0.png" alt="Card" class="draw-card-image">
                    </div>
                    <div class="card-item">
                        <img src="./assets/images/tarot-card/0.png" alt="Card" class="draw-card-image">
                    </div>
                    <div class="card-item">
                        <img src="./assets/images/tarot-card/0.png" alt="Card" class="draw-card-image">
                    </div>
                    <form action="CardServlet" method="post">
                        <button class="confirm-draw" type="submit">Confirm</button>
                    </form>
                </div>
            </div>
        </div>


        <div id="loading-modal" class="modal">
            <div class="loading-content">
                <h2 id="loading-message">Connecting to the stars...</h2>
                <div class="loading-spinner"></div>
                <p>Your destiny is decided by you!</p>
            </div>
        </div>

        <script src="./scripts/homejs.js"></script>
        <script>
                                    function getZodiac(year) {
                                        const zodiacs = [
                                            {name: "Tý (Rat)", image: "./assets/images/animal-sign/chuot.png"},
                                            {name: "Sửu (Ox)", image: "./assets/images/animal-sign/trau.png"},
                                            {name: "Dần (Tiger)", image: "./assets/images/animal-sign/ho.png"},
                                            {name: "Mão (Rabbit)", image: "./assets/images/animal-sign/meo.png"},
                                            {name: "Thìn (Dragon)", image: "./assets/images/animal-sign/rong.png"},
                                            {name: "Tỵ (Snake)", image: "./assets/images/animal-sign/ran.png"},
                                            {name: "Ngọ (Horse)", image: "./assets/images/animal-sign/ngua.png"},
                                            {name: "Mùi (Goat)", image: "./assets/images/animal-sign/de.png"},
                                            {name: "Thân (Monkey)", image: "./assets/images/animal-sign/khi.png"},
                                            {name: "Dậu (Rooster)", image: "./assets/images/animal-sign/ga.png"},
                                            {name: "Tuất (Dog)", image: "./assets/images/animal-sign/cho.png"},
                                            {name: "Hợi (Pig)", image: "./assets/images/animal-sign/heo.png"}
                                        ];

                                        const index = (year - 4) % 12;
                                        return zodiacs[index];
                                    }

                                    function getWesternZodiac(day, month) {
                                        const zodiacs = [
                                            {name: "Ma Kết", image: "./assets/images/zodiac-sign/10.png", start: {month: 12, day: 22}, end: {month: 1, day: 19}},
                                            {name: "Bảo Bình", image: "./assets/images/zodiac-sign/11.png", start: {month: 1, day: 20}, end: {month: 2, day: 18}},
                                            {name: "Song Ngư", image: "./assets/images/zodiac-sign/12.png", start: {month: 2, day: 19}, end: {month: 3, day: 20}},
                                            {name: "Bạch Dương", image: "./assets/images/zodiac-sign/1.png", start: {month: 3, day: 21}, end: {month: 4, day: 19}},
                                            {name: "Kim Ngưu", image: "./assets/images/zodiac-sign/2.png", start: {month: 4, day: 20}, end: {month: 5, day: 20}},
                                            {name: "Song Tử", image: "./assets/images/zodiac-sign/3.png", start: {month: 5, day: 21}, end: {month: 6, day: 20}},
                                            {name: "Cự Giải", image: "./assets/images/zodiac-sign/4.png", start: {month: 6, day: 21}, end: {month: 7, day: 22}},
                                            {name: "Sư Tử", image: "./assets/images/zodiac-sign/5.png", start: {month: 7, day: 23}, end: {month: 8, day: 22}},
                                            {name: "Xử Nữ", image: "./assets/images/zodiac-sign/6.png", start: {month: 8, day: 23}, end: {month: 9, day: 22}},
                                            {name: "Thiên Bình", image: "./assets/images/zodiac-sign/7.png", start: {month: 9, day: 23}, end: {month: 10, day: 22}},
                                            {name: "Bọ Cạp", image: "./assets/images/zodiac-sign/8.png", start: {month: 10, day: 23}, end: {month: 11, day: 21}},
                                            {name: "Nhân Mã", image: "./assets/images/zodiac-sign/9.png", start: {month: 11, day: 22}, end: {month: 12, day: 21}}
                                        ];

                                        for (let i = 0; i < zodiacs.length; i++) {
                                            let zodiac = zodiacs[i];
                                            if ((month === zodiac.start.month && day >= zodiac.start.day) || (month === zodiac.end.month && day <= zodiac.end.day)) {
                                                return zodiac;
                                            }
                                        }

                                        // If no match found, assume Ma Kết
                                        return zodiacs[0];
                                    }

                                    function showZodiac() {
                                        const yearOfBirth = parseInt(document.getElementById('user-dob').innerText.split('-')[0]); // Assuming DOB is in YYYY-MM-DD format
                                        const zodiac = getZodiac(yearOfBirth);
                                        document.getElementById('zodiac-name').innerText = zodiac.name;
                                        document.getElementById('zodiac-image').src = zodiac.image;
                                    }

                                    function showWesternZodiac() {
                                        const dob = document.getElementById('user-dob').innerText.split('-'); // Assuming DOB is in YYYY-MM-DD format
                                        const day = parseInt(dob[2]);
                                        const month = parseInt(dob[1]);
                                        const zodiac = getWesternZodiac(day, month);
                                        document.getElementById('western-zodiac-name').innerText = zodiac.name;
                                        document.getElementById('western-zodiac-image').src = zodiac.image;
                                    }

                                    window.onload = function () {
                                        showZodiac(); // Hiển thị con giáp
                                        showWesternZodiac(); // Hiển thị cung hoàng đạo
                                    };
        </script>
    </body>
</html>
