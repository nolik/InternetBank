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
<head>
    <style>
        table, th, td {
            border: 1px solid black;
        }
        th,td {
            text-align: center;
        }
    </style>

    <title>MainJSP</title>
    <h1> Hello, ${lastName} ${firstName}! </h1>

    <h2> Welcom to your bank account page!</h2>
</head>

<br/>
<h2> Your card list: </h2>

<%-- Here i try to use list implementation --%>

<table style="width:100%">
    <thead>
    <tr>
        <th>Card Number</th>
        <th>Summ</th>
        <th>Currency</th>
        <th>Operation</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cards}" var="card">
        <tr>
            <td>
                <c:out value="${card.cardNumber}" />
            </td>
            <td>
                <c:out value="${card.sum}" />
            </td>
            <td>
                <c:out value="${card.currency}" />
            </td>
            <td>
                <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
                    <input type="hidden" name="operatingCartID" value="${card.cardNumber}"/>
                    <input name="command" type="submit" value="operation">
                </FORM>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br/>
<hr/>

<FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
    <INPUT name="command" type="submit" value="Logout">
</FORM>
<body>

</body>
</html>
