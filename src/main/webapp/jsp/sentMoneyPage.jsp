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
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="../css/raleway.css">
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css"/>
    <style>
        table, th, td {
            border: 1px solid black;
        }

        th, td {
            text-align: center;
        }

        .wrapper {
            width: 50%;


            display: block;
            position: absolute;
            top: 30%;
            left: 50%;
            opacity: 0.9;
            transform: translateY(-30%) translateX(-50%);
            background: #182F2B;
            color: white;
            border-radius: 5px;
            border: 2px solid #000;
        }

        .w3-jumbo-custom {
            font-size: 38px !important;
        }


    </style>
    <title>Transaction page</title>
</head>
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">

    <div class="w3-container w3-center">
        <h1 class="w3-jumbo-custom w3-animate-top"><font color="black">Sent money from the cart
            №:${operatingCart.cardNumber}</font></h1>

        <hr class="w3-border-grey" style="margin:auto;width:40%">
    </div>

    <div class="wrapper">
        <h2 class="w3-jumbo-custom"><font color="white">

            Balance: ${operatingCart.sum} Currency: ${operatingCart.currency} </font></h2>
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
        <a href="${pageContext.request.contextPath}/jsp/main.jsp">Go main page</a>
    </div>
</div>
</body>
</html>
