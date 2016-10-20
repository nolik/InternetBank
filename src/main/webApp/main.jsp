<%--
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
    <h1> Hello username.</h1>
    <h3> Welcom to the bank account page!</h3>
        <FORM action="${pageContext.request.contextPath}/сontroller" method="POST">
            <INPUT name="command" type="submit" value="LOGOUT">

            </FORM>
<body>

</body>
</html>
