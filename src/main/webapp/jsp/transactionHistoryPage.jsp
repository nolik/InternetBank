<%--
  Created by IntelliJ IDEA.
  User: Novik Igor
  Date: 07.11.2016
  Time: 7:37
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

    <title>TransactionHistory</title>
</head>
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">
Here will be located transaction history from operation card.
<%-- Here  transaction-table implementation --%>
<br/>
<table style="width:100%">
    <thead>
    <tr>
        <th>Transaction ID</th>
        <th>Operation</th>
        <th>Sum Of Operation</th>
        <th>Transaction Time</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${transactionList}" var="transaction">
        <tr>
            <td><c:out value="${transaction.transactionID}"/></td>
            <td><c:out value="${transaction.operation}"/></td>
            <td><c:out value="${transaction.sumOfOperation}"/></td>
            <td><c:out value="${transaction.transactionTime}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<hr/>
<a href="${pageContext.request.contextPath}/jsp/main.jsp">Go main page</a>
    </div>
</body>
</html>
