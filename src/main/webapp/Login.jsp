<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
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

        .login-container {
            background-color: rgba(0, 0, 0, 0.8);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            opacity: 0;
            transform: translate(-50%, -50%) scale(0.5);
            transition: opacity 0.5s, transform 0.5s;
            animation: arrive 0.5s ease-in-out forwards;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            backdrop-filter: blur(8px);
        }

        .login-form {
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

        input {
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
<video class="video-background" src="STYLE.mp4" autoplay muted loop></video>
<div class="login-container">
    <form class="login-form" action="/login" method="POST">
        <h1>Login</h1>
        <label for="email">Email</label>
        <input type="text" id="email" name="email" required>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
        <button type="submit">Login</button>
    </form>
    <div class="create-account-link">
        NEW TO THE CLUB? <a href="/register">Create one</a>

    </div>
</div>
</body>
</html>