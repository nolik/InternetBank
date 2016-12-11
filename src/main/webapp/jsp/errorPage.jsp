<%--
  Created by IntelliJ IDEA.
  User: Novik Igor
  Date: 20.09.2016
  Time: 14:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<title>Login Error</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="../css/raleway.css">
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css"/>
<style>
    .w3-container {
        padding: 2em 70px;
    }

    .wrapper {
        width: 90%;
        background: #182F2B;
        display: block;
        position: absolute;
        top: 35%;
        left: 20%;
        transform: translateY(-10%) translateX(-17%);
        opacity: 0.9;
        color: white;
        border-radius: 5px;
        border: 2px solid #000;

    }
</style>
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">
    <div class="w3-container w3-center">
        <h1 class="w3-jumbo w3-animate-top"><font color="black">WOW! Some error!</font></h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center"><font color="black">such suddenly, such malapropos</font></p>
    </div>

    <c:url var="url" value="${pageContext.request.contextPath}/index.jsp"/>

    <div class="wrapper">
        <p>Request from ${pageContext.errorData.requestURI} is failed
            <br/>
            Servlet name or type: ${pageContext.errorData.servletName}
            <br/>
            Status code: ${pageContext.errorData.statusCode}
            <br/>
            Exception: ${pageContext.errorData.throwable}</p>
    </div>
</div>

</body>
</html>

