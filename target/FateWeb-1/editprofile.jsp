<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css2?family=Khand:wght@300;400;500;600;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" rel="stylesheet">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">       
        <title>Edit Profile</title>

    </head>
    <body>
        <div class="background">
            <video class="back-video" autoplay muted loop>
                <source src="./assets/videos/HomeBG.mp4" type="video/mp4">
                <<link rel="stylesheet" href="styles/editprofile.css"/>
            </video>
            <div class="overlay"></div>
        </div>
        <div class="edit-profile-container">
            <h1>Edit personal information</h1>
            <h3>${requestScope.msg}</h3>
            <form action="editprofile" method="get">
                <div class="form-group">
                    <label for="username">Username:</label>
                    <input type="text" id="username" name="username" value="${sessionScope.account.username}" required readonly>
                </div>
                <div class="form-group">
                    <label for="password">Password:</label>
                    <input type="password" id="password" name="password" value="${sessionScope.account.password}" required>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email" value="${sessionScope.account.email}" required>
                </div>
                <div class="form-group">
                    <label for="fullname">Full Name:</label>
                    <input type="text" id="fullname" name="fullname" value="${sessionScope.user.fullname}" required>
                </div>
                <div class="form-group">
                    <label for="gender">Gender:</label>
                    <select id="gender" name="gender" required>
                        <option value="male" ${sessionScope.user.gender eq 'male' ? 'selected' : ''}>Male</option>
                        <option value="female" ${sessionScope.user.gender eq 'female' ? 'selected' : ''}>Female</option>
                        <option value="other" ${sessionScope.user.gender eq 'other' ? 'selected' : ''}>Other</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="dob">Date of Birth:</label>
                    <input type="date" id="birthdate" name="dob" min="1900-01-01" value="${sessionScope.user.dob}" required>
                </div>
                <div class="buttons">
                    <button type="submit" >Save Changes</button>
                    <button type="button" onclick="window.location.href = 'homepage.jsp'">Back to Home</button>
                </div>
            </form>
        </div>
        <script>
            document.addEventListener('DOMContentLoaded', () => {
                const today = new Date().toISOString().split('T')[0]; // Get today's date in YYYY-MM-DD format
                document.getElementById('birthdate').setAttribute('max', today);
            });
        </script>
    </body>
</html>
