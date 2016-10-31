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
<head>
    <title>Transaction page</title>
</head>
<body>
<h2>Transaction from the card:</h2>
<td>
    Cart №:  <c:out value="${cart.cardNumber}" />
</td>
<td>
    Summ: <c:out value="${cart.sum}" />
</td>
<td>
    Currency<c:out value="${cart.currency}" />
</td>

<br/>
<form method="POST" action="${pageContext.request.contextPath}/сontroller">
    <input type="hidden" name="command" value="sentMoney"/>
    <table>
        <tr>
            <td><b>toCart:</b></td>
            <td>
                <input name="toCart" type="text" size=40></td>
        </tr>
        <tr>
            <td><b>sum of operation:</b></td>
            <td>
                <input name="sumOfOperation" type="text" size=40></td>
        </tr>
        </table>
    </form>

</body>
</html>
