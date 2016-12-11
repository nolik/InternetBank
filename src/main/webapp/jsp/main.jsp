<%@ page import="com.NovikIgor.dto.Card" %>
<%--
  Created by IntelliJ IDEA.
  User: nolik
  Date: 01.09.16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<html>
<title>MainJSP</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="../css/raleway.css">

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css"/>
<style>
    table, th, td {
        border: 1px solid black;
    }

    th, td {
        text-align: center;
    }

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

    .button-space {
        position: absolute;
        left: 1%;
        bottom: 2%;
    }





</style>
<body>

<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">

    <div class="w3-container w3-center">
        <h1 class="w3-jumbo w3-animate-top"><font color="black">Hello, ${lastName} ${firstName}! </font></h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center"><font color="black">Welcom to your bank account page!</font></p>
    </div>
    <b/>
    <div class="wrapper">

        <p class="w3-large w3-center"> Your card list: </p>

        <%-- Here  list-table implementation --%>

        <div class="w3-container w3-center">

            <table class="w3-gray w3-border w3-hoverable w3-center" style="width:100%">
                <thead>
                <tr class="w3-light-grey">
                    <th>Card Number</th>
                    <th>Summ</th>
                    <th>Currency</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cards}" var="card">
                    <tr>
                        <td><c:out value="${card.cardNumber}"/></td>
                        <td><c:out value="${card.sum}"/></td>
                        <td><c:out value="${card.currency}"/></td>
                        <td>


                            <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
                                <select name="command">
                                    <option value="TRANSACTION_HISTORY">Review Transaction History</option>
                                    <option value="OPERATION_FOR_SENDING_MONEY">Sent Money From Cart</option>
                                </select>
                                <input type="hidden" name="operatingCartID" value="${card.cardNumber}"/>
                                <input type="submit" value="make operation">
                            </FORM>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <br/>
        </div>

        <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
            <button class="w3-btn  button-space">Logout</button>
            <input type="hidden" name="command" value="Logout"/>
        </FORM>
    </div>


</div>
</body>
</html>
