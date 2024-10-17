<%-- 
    Document   : eastern-feature-1
    Created on : Jul 8, 2024, 3:19:40 PM
    Author     : locsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String weakElement = (String) request.getAttribute("weakElement");
    if (weakElement == null) {
        weakElement = "";
    }
%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>New Page with Comet Effect</title>
        <link rel="stylesheet" href="styles/feature.css">
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
                    <img src="/assets/images/logo/logo.png" alt="Site Logo">
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
                        <li class="menu-item"><a href="#">Membership</a></li>
                    </ul>
                </nav>
                <form action="signout" method="post">
                    <div class="auth-buttons">
                        <button class="signout-button">Sign Out</button>
                    </div>
                </form>
            </div>
        </header>

        <main class="main-content">
            <!-- Add your new content here -->
            <div class="new-content-container">
                <div class="header-title-container">
                    <h1>Weak Element</h1>
                </div>
                <div class="square-container">
                    <button class="circle-button" id="fire-button" data-content="Nội dung 1">
                        <img src="./assets/images/icon/hoa.png" alt="Fire">
                        <div class="glow-effect"></div>
                    </button>
                    <button class="circle-button" id="water-button" data-content="Nội dung 2">
                        <img src="./assets/images/icon/thuy.png" alt="Water">
                        <div class="glow-effect"></div>
                    </button>
                    <button class="circle-button" id="earth-button" data-content="Nội dung 3">
                        <img src="./assets/images/icon/tho.png" alt="Earth">
                        <div class="glow-effect"></div>
                    </button>
                    <button class="circle-button" id="metal-button" data-content="Nội dung 4">
                        <img src="./assets/images/icon/kim.png" alt="Metal">
                        <div class="glow-effect"></div>
                    </button>
                    <button class="circle-button" id="wood-button" data-content="Nội dung 5">
                        <img src="./assets/images/icon/moc.png" alt="Wood">
                        <div class="glow-effect"></div>
                    </button>
                    <div class="content" id="square-content">Nội dung mặc định</div>
                </div>



                <form id="form-id" action="eastern-feature-1" method="post">
                    <input type="hidden" name="userChoice" id="selectedOption">            
                    <button type="button" class="custom-button">Explore Now</button>
                    <div id="new-modal" class="new-modal">
                        <div class="new-modal-content">
                            <span class="new-close-button">&times;</span>
                            <div class="modal-body">
                                <div class="modal-left">
                                    <img src="./assets/images/feature/for-you.png" alt="For You Image">
                                    <p>For Yourself</p>
                                </div>
                                <div class="modal-right">
                                    <img src="./assets/images/feature/for-someone-else.png" alt="For Someone Else Image" value="1">
                                    <p>For Someone Else</p>
                                </div>
                            </div>
                            <button id="confirm-button" class="confirm-button">Confirm</button>
                        </div>
                    </div>

                    <!-- Loading Modal -->
                    <div id="new-loading-modal" class="new-loading-modal">
                        <div class="new-loading-content">
                            <p id="new-loading-message">Connecting to the stars...</p>
                            <div class="new-loading-spinner"></div>
                            <p>Your destiny is decided by you!</p>
                        </div>
                    </div>


                    <!-- Result Modal -->
                    <div id="result-loading-modal" class="result-loading-modal">
                        <div class="result-loading-content">
                            <p id="result-loading-message">new loading message</p>
                            <h3><pre>${requestScope.result}</pre></h3>
                            <!-- Thêm nút Back -->
                            <button id="back-button" class="back-button">Back</button>
                        </div>
                    </div>

                    <!-- HTML cho Modal Nhập Thông Tin -->
                    <div id="new-input-modal" class="new-input-modal">
                        <div class="new-input-content">
                            <span class="new-close-button">&times;</span>
                            <h2>Enter Information</h2>
                            <input type="text" id="full-name" placeholder="Full Name" required>
                            <select id="gender" required>
                                <option value="">Select Gender</option>
                                <option value="male">Male</option>
                                <option value="female">Female</option>
                                <option value="other">Other</option>
                            </select>
                            <input type="date" id="birthdate" name="dob" min="1900-01-01" required>
                            <button type="submit" id="submit-info-button">Submit</button>
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
        <script src="./scripts/eastern-feature-1.js"></script>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const weakElement = '<%= weakElement%>';
                if (weakElement) {
                    const buttonId = {
                        "Hỏa": "fire-button",
                        "Thủy": "water-button",
                        "Thổ": "earth-button",
                        "Kim": "metal-button",
                        "Mộc": "wood-button"
                    }[weakElement];
                    if (buttonId) {
                        const button = document.getElementById(buttonId);
                        if (button) {
                            button.click(); // chọn weakElement
                            showModal();  // hiển thị bảng kết quả
                        }
                    }
                }
            });
        </script>
    </body>

</html>
