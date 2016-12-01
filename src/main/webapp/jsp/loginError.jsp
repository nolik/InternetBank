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

    }
</style>
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">
    <div class="w3-container w3-center">
        <h1 class="w3-jumbo w3-animate-top"><font color="black">Login error!</font></h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center"><font color="black">Invalid user name or password.</font></p>
    </div>

    <c:url var="url" value="${pageContext.request.contextPath}/index.jsp"/>

    <div class="wrapper">
        <p>Please enter a user name or password that is authorized to access this
            application. For this application, this means a user that has been created in the
            <code>file</code> realm and has been assigned to the <em>group</em> of
            <code>user</code>. Click here to <a href="${url}">Try Again</a></p>
    </div>
</div>

</body>
</html>
