
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>website</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="hero">

    <video autoplay loop muted plays-inline class="back-video">
        <source src="STEVENGRAND.mp4" type="video/mp4">
    </video>
    <nav>
        <img src="logo.jpg" class="logo">
        <ul>
            <li><a href="#">HOME</a></li>
            <li><a href="#">NEW</a></li>
            <li id="loginItem"><a href="Login.jsp">LOGIN</a></li>
            <li><a href="#">CONTACT</a></li>
        </ul>
    </nav>
    <div class="content">
        <h1>STEVEN GRANT</h1>
        <li><a href="Explore.jsp">Explore</a></li>
    </div>
</div>
<style>
    *{
        padding: 0;
        margin: 0;
        box-sizing: border-box ;
        font-family: 'Poppins', sans-serif;
    //////////////
    list-style: none;
        text-decoration: none;
        scroll-behavior: smooth;
    }
    .hero{
        width: 100%;
        height: 100vh;
        background-image: linear-gradient(rgba(12,3,51,0.3),rgba(12,3,51,0.3));
        position: relative;
        padding: 0 5%;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    nav{
        width: 100%;
        position: absolute;
        top: 0;
        left: 0;
        padding: 20px 8%;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
    nav .logo{
        width: 80px;
    }
    nav ul li{
        list-style: none;
        display: inline-block;
        margin-left: 40px;
    }
    nav ul li a{
        text-decoration: none;
        color: #fff;
        font-size: 17px;
    }
    .content {
        text-align: center;
    }
    .content h1 {
        font-size: 160px;
        color: #fff;
        font-weight: 600;
        transition: 0.5s;
    }
    .content h1:hover{
        -webkit-text-stroke: 2px #fff;
        color: transparent;
    }


    .content a{
        text-decoration: none;
        display: inline-block;
        color: #fff;
        font-size: 24px;
        border: 2px solid #fff;
        padding: 14px 70px;
        border-radius: 50px;
        margin-top: 20px;
    }
    .back-video{
        position: absolute;
        right: 0;
        bottom: 0;
        z-index: -1;
    }

    @media (min-aspect-ratio: 16/9) {
        .back-video{
            width: auto;
            height: 100%;
        }
    }



</style>

</body>
</html>