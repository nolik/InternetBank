<%--
  Created by IntelliJ IDEA.
  User: Novik Igor
  Date: 04.11.2016
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="../css/raleway.css">
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css"/>
</head>
<style>
    .button-space {
        position: absolute;
        left: 1%;
        bottom: 2%;
        color: white;
    }
</style>

<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">
    <div class="w3-container w3-center">
        <h1 class="w3-jumbo w3-animate-top"><font color="black">Operation been finished successful!</font></h1>
        </div>

    <b/>
    <p align="center">
        <iframe width="560" height="315" src="https://www.youtube.com/embed/lcYpaYrYpus?autoplay=1" frameborder="0"
                allowfullscreen></iframe>
    </p>

    <br/>

    <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="w3-btn button-space">Main page</a>
</div>
</body>
</html>
