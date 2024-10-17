<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><!DOCTYPE html>
<html lang="en">
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Details</title>
        <link rel="stylesheet" href="./styles/admin.css">
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
                    </ul>
                </nav>
                <form action="signout" method="post">
                    <div class="auth-buttons">
                        <button class="login-button">Sign Out</button>
                    </div>
                </form>
            </div>
        </header>

        <main class="main-content">
            <div class="content-container">

                <!-- User Search Interface -->
                <div id="user-search-interface">
                    <h2>User Management</h2>
                    <p>Searching by Username:</p>
                    <form action="searchServlet" method="post">
                        <div class="search-container">
                            <input type="text" id="search-username" name="username" placeholder="Enter username">
                            <button type="submit" class="search-button">Search</button>
                        </div>
                    </form>

                    <div class="user-details">
                        <h3>User Information</h3>
                        <c:choose>
                            <c:when test="${not empty user}">
                                <p><strong>Username:</strong> ${user.account.username}</p>
                                <p><strong>Email:</strong> ${user.account.email}</p>
                                <p><strong>Membership:</strong> ${user.membership}</p>
                                <p><strong>Price:</strong> ${user.price}</p>
                                <p><strong>Period:</strong> ${user.period}</p>
                                <p><strong>Rank:</strong> ${user.ranktype}</p>
                                <p><strong>Gender:</strong> ${user.gender}</p>
                                <p><strong>Date of Birth:</strong> ${user.dob}</p>
                            </c:when>
                            <c:otherwise>
                                <p>${error}</p>
                                <p>${msg}</p>
                            </c:otherwise>
                        </c:choose>

                        <div class="user-actions">
                            <form action="deleteUserServlet" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
                                <input type="hidden" name="username" value="${user.account.username}">
                                <button type="submit" class="delete-user">Delete User</button>
                            </form>
                            <form action="upGradeServlet" method="post" onsubmit="return confirm('Are you sure you want to Upgrade this user?');">
                                <input type="hidden" name="username" value="${user.account.username}">
                                <button type="submit" class="upgrade-user">Upgrade User</button>
                            </form>
                            <form action="downGradeServlet" method="post" onsubmit="return confirm('Are you sure you want to downgrade this user?');">
                                <input type="hidden" name="username" value="${user.account.username}">
                                <button type="submit" class="downgrade-user">Downgrade User</button>
                            </form>
                        </div>
                    </div>
                </div>

                <!-- Website Revenue Interface -->
                <div id="website-revenue-interface" style="display: none;">
                    <h2>Website Revenue</h2>
                    <p>Here you can see the revenue of the website.</p>
                </div>

            </div>
        </main>

        <script src="./scripts/admin.js"></script>
    </body>
</html>
