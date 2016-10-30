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
    <title>MainJSP</title>
    <h1> Hello, ${lastName} ${firstName}! </h1>

    <h2> Welcom to your bank account page!</h2>
    <br/>
    <big> Your card list: </big>
    <table>
        <p>
            - ${cards}!!!!!
        </p>
    </table>

    <br/>
    ________________________________________________
    <br/>
    <%-- Here i try to use list implementation --%>

    <table>
        <c:forEach items="${cards}" var="item">
            <tr>
                <td><c:out value="${item}" /></td>
            </tr>
        </c:forEach>
    </table>

    _________________________________________________
    <br />

    <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
        <INPUT name="command" type="submit" value="LOGOUT">

    </FORM>
<body>

</body>
</html>
