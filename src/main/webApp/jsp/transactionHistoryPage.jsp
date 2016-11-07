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
<head>

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
</body>
</html>
