<%--
  Created by IntelliJ IDEA.
  User: nolik
  Date: 01.09.16
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    * {
        padding: 0;
        margin: 0;
    }

    .form {
        padding: 20px;
        background: #999;
        width: 50%;
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
        background: skyblue;
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
        transform: translateY(-30%) translateX(-50%)
    }


</style>
<head>
    <title>Internet Banking</title>
</head>
<body>
<p align="right">
Current time:
    <br/>
    <jsp:useBean id="gc" class="java.util.GregorianCalendar"/>
    <jsp:getProperty name="gc" property="time"/>
</p>

<p align="center">
    <b> Welcome to Internet Banking!</b>
    <br/>
    Please Logg In:
</p>
<div class="wrapper">
    <form method="POST" action="${pageContext.request.contextPath}/сontroller" class="form">
        <input type="hidden" name="command" value="login"/>
        <label for="login">
            <input id="login" name="login" placeholder="Login" type="text"/>
        </label>
        <label for="password">
            <input id="password" name="password" placeholder="Password" type="password"/>
        </label>

        <button type="submit">Log In</button>
    </form>
</div>
</body>
</html>
