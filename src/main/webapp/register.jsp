<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registration</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
        }

        body {
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: black;
            overflow: hidden;
        }

        .video-background {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            z-index: -1;
            object-fit: cover;
        }

        .registration-container {
            background-color: #48240f; /* Solid brown color */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            opacity: 0;
            transform: translate(-50%, -50%) scale(0.5);
            transition: opacity 0.5s, transform 1.2s;
            animation: arrive 1.2s ease-in-out forwards;
            position: absolute;
            top: 50%;
            left: 50%;
            backdrop-filter: blur(8px); /* Apply a blur effect */
        }



        .registration-form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #ffffff;
        }

        label {
            margin: 10px 0;
            color: #ffffff;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            box-sizing: border-box;
        }

        button {
            padding: 10px 20px;
            background-color: transparent;
            color: #fff;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        button:hover {
            background-color: #dc3545;
        }

        .create-account-link {
            margin-top: 20px;
            text-align: center;
            color: #ffffff;
        }

        .create-account-link a {
            color: white;
            text-decoration: none;
            font-weight: bold;
        }

        .create-account-link a:hover {
            text-decoration: underline;
        }

        @keyframes arrive {
            0% {
                opacity: 0;
                transform: translate(-50%, -50%) scale(0.5);
            }
            100% {
                opacity: 1;
                transform: translate(-50%, -50%) scale(1);
            }
        }
    </style>
</head>
<body>
<video class="video-background" src="registrate.mov" autoplay muted loop></video>
<div class="registration-container">
    <form class="registration-form" action="/register" method="POST" enctype="multipart/form-data">
        <h1>Registration</h1>
        <label for="full-name">Full Name</label>
        <input type="text" id="full-name" name="full_name" required>
        <label for="username">Username</label>
        <input type="text" id="username" name="user_name" required>
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        <label for="gender">Gender</label>
        <select id="gender" name="gender" required>
            <option value="male">Male</option>
            <option value="female">Female</option>
        </select>
        <!-- End of new input -->
        <button type="submit">Register</button>
    </form>
    <div class="create-account-link">
        ALREADY HAVE AN ACCOUNT? <a href="Login.jsp">Login</a>
    </div>
</div>
<script>
    window.addEventListener('DOMContentLoaded', function() {
        var registrationContainer = document.querySelector('.registration-container');

        setTimeout(function() {
            registrationContainer.style.opacity ="1";
            registrationContainer.style.transform = "translate(-50%, -50%) scale(1)";
        }, 1200);
    });
</script>
</body>
</html>
