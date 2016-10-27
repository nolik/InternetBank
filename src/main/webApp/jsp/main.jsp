<%@ page import="com.NovikIgor.dto.Card" %>
<%@ page import="java.util.concurrent.ConcurrentLinkedQueue" %><%--
  Created by IntelliJ IDEA.
  User: nolik
  Date: 01.09.16
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <title>MainJSP</title>
    <h1> Hello, ${lastName} ${firstName}! </h1>
        <%
        ConcurrentLinkedQueue<Card> userCards = (ConcurrentLinkedQueue<Card>) request.getAttribute("cards");
        for (Card card : userCards){
            out.println("------------------------------------------------------------------");
            out.println("|"+card.getCardNumber() + " | " + card.getSum()+" | " + card.getCurrency() + " |" );
            out.println("------------------------------------------------------------------");
        }
    %>

    <h3> Welcom to your bank account page!</h3>
    <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
        <INPUT name="command" type="submit" value="LOGOUT">

    </FORM>
<body>

</body>
</html>
