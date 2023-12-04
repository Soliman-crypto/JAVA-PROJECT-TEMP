<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name ="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>STEVEN GRANT™</title>
</head>
<body>
<nav class="navbar">
    <div class="logo"><h1>STEVEN GRANT™</h1></div>
    <ul class="menu">
        <li><a href="" class="active">Home</a></li>
        <li><a href="Account.jsp">Accounts</a></li> <!-- Updated this line to include the link -->
        <li><a href="#">Contact</a></li>
    </ul>
    <div class="menu-btn">
        <i class="fa fa-bars"></i>
    </div>
</nav>

        <c:if test="${user != null && user.admin}">
        </c:if>

        <li><a href="Account.jsp">Accounts</a></li>


        <!-- Conditional display for login/logout -->
        <c:choose>
            <c:when test="${user != null}">
                <!-- User is logged in, display profile and logout options -->
            </c:when>
            <c:otherwise>
                <!-- User is not logged in, display login option -->
            </c:otherwise>
        </c:choose>
    </ul>
    <div class="menu-btn">
        <i class="fa fa-bars"></i>
    </div>
</nav>

<section class="content">
    <h1>COLLECT THE RAREST PIECES.</h1>
    <p>Louis Vuitton, Bottega Veneta, YSL & More..</p>
    <button onclick="redirectToRegister()">Shop Now</button>
</section>

<script>
    function redirectToRegister() {
        window.location.href = "register.jsp";

    }
</script>

<script>
    $(document).ready(function () {
        $(".btn").on("click", function () {
            var btn = $(this);

            // Add animation classes
            btn.addClass("fade-out");

            // Wait for the animation to complete
            setTimeout(function () {
                // Replace button text
                btn.text("Reserved");

                // Remove animation classes
                btn.removeClass("fade-out");
            }, 500); // Adjust the duration as needed
        });
    });
</script>
///////////////////////////////////
<h1 class="pheading">Our Latest Products</h1>

<section class="sec">
    <div class="products">

        <div class="card">
            <div class="img"><img src="   1.png" alt=""></div>
            <div class="desc">Women</div>
            <div class="title">1/1 LV ELYSEES BAG</div>
            <div class="box">
                <div class="price">25000$</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


        <div class="card">
            <div class="img"><img src="   2.png" alt=""></div>
            <div class="desc">Men</div>
            <div class="title">1977 POLO ASSN </div>
            <div class="box">
                <div class="price">10000$</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


        <div class="card">
            <div class="img"><img src="   4.png" alt=""></div>
            <div class="desc">Men</div>
            <div class="title">TOMFORD 1/1 FU**ING FABULOUS FRAGRANCE </div>
            <div class="box">
                <div class="price">$10000</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


        <div class="card">
            <div class="img"><img src="   3.png" alt=""></div>
            <div class="desc">Men</div>
            <div class="title">1/1 LOUIS VITTON BAG "CHERRIES EDDITION"</div>
            <div class="box">
                <div class="price">$65500</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div><div class="card">
        <div class="img"><img src="   6.png" alt=""></div>
        <div class="desc">Women</div>
        <div class="title">RALPH LAUREN RL67 1/1 SWEATER" </div>
        <div class="box">
            <div class="price">$6000</div>
            <button class="btn">Reserved</button>
        </div>
    </div>


        <div class="card">
            <div class="img"><img src="   5.png" alt=""></div>
            <div class="desc">Women</div>
            <div class="title">1/1 CHANNEL UMBRELLA</div>
            <div class="box">
                <div class="price">$4542</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


        <div class="card">
            <div class="img"><img src="   8.png" alt=""></div>
            <div class="desc">Women</div>
            <div class="title">REGULAR LV TENNIS BAG</div>
            <div class="box">
                <div class="price">$3565</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


        <div class="card">
            <div class="img"><img src="   9.png" alt=""></div>
            <div class="desc">Men</div>
            <div class="title">AMERICA RALPH LAUREN SWEATER</div>
            <div class="box">
                <div class="price">$2000</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


        <div class="card">
            <div class="img"><img src="   7.png" alt=""></div>
            <div class="desc">Boys</div>
            <div class="title">LORO PIANA SOCKS 1/30</div>
            <div class="box">
                <div class="price">$1200</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


        <div class="card">
            <div class="img"><img src="   10.png" alt=""></div>
            <div class="desc">Men</div>
            <div class="title">1/1 ALEXANDER CRAFT PEARL COAT</div>
            <div class="box">
                <div class="price">$110000</div>
                <button class="btn">Pre-Reserve</button>
            </div>
        </div>


    </div>
</section>

<footer>
    <p>Copyrights @<a href="">STEVEN GRANT™</a></p>
</footer>

<style>
    *{
        margin: 0;
        padding: 0;
        font-family: sans-serif;
    }

    body{
        height: 100%;
    }

    .menu-btn{
        color: #424144;
        font-size: 23px;
        cursor: pointer;
        display: none;
    }

    .navbar{
        padding: 20px 5%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        position: sticky;
        top: 0;
        z-index: 999;
        background-color: #f3f4f6;
        box-shadow: 0 0 14px rgba(0, 0, 0, 0.3);
    }
    .navbar .menu li{
        list-style: none;
        display: inline-block;
    }

    .navbar .menu li a{
        display: block;
        margin-left: 20px;
        color: #424144;
        border-bottom: 4px solid transparent;
        text-decoration: none;
        font-size: 20px;
        font-weight: bold;

    }

    .navbar .menu li .active{
        border-bottom: 4px solid  saddlebrown;
    }

    .navbar . menu li a i{
        color:  saddlebrown;

    }

    .navbar .menu li a:hover {
        border-bottom: 4px solid  saddlebrown;
    }

    .content{
        background-image: url("shooping.jpg");
        background-size: cover;
        background-repeat: no-repeat;
        padding: 0 5%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: flex-start;
        color: #000000;
        height: 100vh;
    }

    .content h1{
        font-size: 40px;
    }

    .content p{
        font-size: 20px;
        margin-top: 20px;
    }

    .content button{
        margin-top: 30px;
        padding: 15px 30px;
        border: none;
        background:  saddlebrown;
        color: white;
        font-size: 20px;
        border-radius: 5px;
        cursor: pointer;
    }

    .pheading{
        text-align: center;
        margin: 50px 0;
        color: #424144;
    }

    .sec{
        padding: 10px 5%;

    }.products{
         display: grid;
         grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
     }

    .products .card{
        width: 310px;
        background: #f5f5f5;
        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.3);
        border-radius: 5px;
        padding: 5px;
        margin-bottom: 20px;
    }

    .products .card img{
        height: 350px;
        width: 100%;
    }

    .products .card .desc{
        padding: 5px 20px;
        opacity: 0.8;
    }

    .products .card .title{
        font-weight: 900;
        font-size: 20px;
        color: #424144;
        padding: 0 20px;
    }

    .products .card .box{
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 20px;
    }

    .products .card .box .price{
        color: saddlebrown;
        font-size: 20px;
        font-weight: bold;
    }

    .products .card .box .btn{
        font-size: 13px;
        color:  saddlebrown;
        padding: 10px 18px;
        font-weight: 900;
        border-radius: 20px;
    }

    .products .card .box .btn:hover{
        cursor: pointer;
        background-color:  saddlebrown;
        color: white;
    }

    footer{
        background-color: #f3f4f6;
        height: 10vh;
    }

    footer p{
        text-align: center;
        line-height: 10vh;
    }

    footer p a{
        text-decoration: none;
        color:  saddlebrown;
        font-weight: bold;
    }
    /* Add this CSS for animation */
    .fade-out {
        opacity: 0;
        transition: opacity 0.5s;
    }

</style>
</body>
</html>