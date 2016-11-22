<%--
  Created by IntelliJ IDEA.
  User: nolik
  Date: 01.09.16
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<title>InternetBanking</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<style>

    body, h1 {
        font-family: "Raleway", sans-serif
    }

    body, html {
        height: 100%
    }

    .bgimg {
        background-image: url(../images/index-background.jpg);
        min-height: 100%;
        background-position: center;
        background-size: cover;
    }

    * {
        padding: 0;
        margin: 0;
    }

    .form {
        padding: 20px;
        background: #182F2B;
        width: 30%;
        min-width: 200px;
    }

    .form input {
        display: block;
        width: 100%;
        height: 30px;
        border: none;
        margin-bottom: 20px;
        padding: 0 10px;
        box-sizing: border-box;
    }

    .form button {
        display: block;
        width: 100%;
        border-radius: 0px;
        background: #90E563;
        border: none;
        height: 30px;
    }

    .wrapper {
        width: 100%;
        height: 100vh;
        position: relative;
    }

    .wrapper .form {
        display: block;
        position: absolute;
        top: 30%;
        left: 50%;
        transform: translateY(-30%) translateX(-50%);
    }


</style>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">

    <div class="w3-container w3-center">
        <h1 class="w3-jumbo w3-animate-top"><font color="black">Internet Banking</font></h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center"><font color="black">Please, log in</font></p>
    </div>
    <div class="wrapper">
        <form method="POST" action="${pageContext.request.contextPath}/сontroller" class="form">
            <input type="hidden" name="command" value="login"/>
            <label for="login">
                <input id="login" name="login" placeholder="Login" type="text"/>
            </label>
            <label for="password">
                <input id="password" name="password" placeholder="Password" type="password"/>
            </label>

            <button class="w3-btn w3-round-large" type="submit"> Log In</button>
        </form>
    </div>
    <div class="w3-display-bottomleft w3-padding-large">
        Developed by <a href="https://github.com/nolik" target="_blank">Nolik</a>
    </div>
    <div class="w3-display-bottomright w3-padding-large w3-small">
        Current time:
        <jsp:useBean id="gc" class="java.util.GregorianCalendar"/>
        <jsp:getProperty name="gc" property="time"/>
    </div>
</div>

</body>
</html>
