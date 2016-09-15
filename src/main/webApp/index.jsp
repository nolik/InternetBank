<%--
  Created by IntelliJ IDEA.
  User: nolik
  Date: 01.09.16
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index JSP</title>
</head>
<body>
<jsp:useBean id="gc" class="java.util.GregorianCalendar"/>
<jsp:getProperty name="gc" property="time"/>
<FORM action="Controller.java" method="POST">
    <INPUT type="submit" value="Loggin">
</FORM>
</body>
</html>
