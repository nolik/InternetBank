<%--
  Created by IntelliJ IDEA.
  User: Novik Igor
  Date: 31.10.2016
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css"/>
    <style>
        table, th, td {
            border: 1px solid black;
        }

        th, td {
            text-align: center;
        }
    </style>
    <title>Transaction page</title>
</head>
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">
<h2>Sent money from the cart №: ${operatingCart.cardNumber}
    <br/>
    Balance: ${operatingCart.sum} Currency: ${operatingCart.currency} </h2>

<br/>
<form method="POST" action="${pageContext.request.contextPath}/сontroller">
    <input type="hidden" name="command" value="SENT_MONEY"/>
    <table>
        <tr>
            <td><b>Recipient Cart:</b></td>
            <td>
                <input name="recipientCart" type="number" max="2147483647" required></td>
        </tr>
        ${cartNotFoundMessage}
        <tr>
            <td><b>sum of operation:</b></td>
            <td>
                <input name="sumOfOperation" type="number" max="2147483647" required></td>
        </tr>
        ${notEnoughMoney} ${wrongSum}
    </table>
    <input type="submit" value="Sent Money">
</form>
<a href="${pageContext.request.contextPath}/src/main/webapp/jsp/main.jsp">Go main page</a>
    </div>
</body>
</html>
