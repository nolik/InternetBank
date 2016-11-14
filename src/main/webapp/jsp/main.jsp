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
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-white">
<title>MainJSP</title>


    <h1> Hello, ${lastName} ${firstName}! </h1>

    <h2> Welcom to your bank account page!</h2>
    </head>

    <br/>
    <h2> Your card list: </h2>

    <%-- Here  list-table implementation --%>

    <div class="w3-container w3-center">
    <table class="w3-table w3-striped w3-border w3-hoverable w3-center" style="width:100%">
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


                    <br/>

                    <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
                        <select name="command">
                            <option value="TRANSACTION_HISTORY">Review Transaction History</option>
                            <option value="OPERATION_FOR_SENDING_MONEY">Sent Money From Cart</option>
                        </select>
                        <br/>

                        <input type="hidden" name="operatingCartID" value="${card.cardNumber}"/>
                        <br/>
                        <input type="submit" value="make operation">
                    </FORM>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
       <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
        <INPUT name="command" type="submit" value="Logout">
    </FORM>

</div>
</body>
</html>
