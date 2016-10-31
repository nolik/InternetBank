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
<h2>Sent money from the cart №: ${operatingCart.cardNumber}
    <br/>
    Balance: ${operatingCart.sum}      Currency: ${operatingCart.currency} </h2>

<br/>
<form method="POST" action="${pageContext.request.contextPath}/сontroller">
    <input type="hidden" name="command" value="SENT_MONEY"/>
    <table>
        <tr>
            <td><b>Recipient Cart:</b></td>
            <td>
                <input name="recipientCart" type="number" size=40 required></td>
        </tr>
        ${cartNotFoundMessage}
        <tr>
            <td><b>sum of operation:</b></td>
            <td>
                <input name="sumOfOperation" type="number" size=40 required></td>
        </tr>
        ${notEnoughMoney}
    </table>
    <input type="submit" value="Sent Money">
</form>

</body>
</html>
