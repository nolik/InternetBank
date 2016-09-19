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
    <title>Internet Banking</title>
</head>
<body>
<b> Welcom to Internet Banking </b>

<h4>Current time:</h4> <jsp:useBean id="gc" class="java.util.GregorianCalendar"/>
<jsp:getProperty name="gc" property="time"/>

<h3>Please Logg In:</h3>
<form method="post" action="/controller">
    <table>
        <tr>
            <td><b>Login:</b></td>
            <td>
                <input name="Login" type="text" size=40></td>
        </tr>
        <tr>
            <td><b>Password:</b></td>
            <td>
                <input name="Password" type="text" size=40></td>
        </tr>


    </table>
    <FORM action="/controller" method="POST">
        <INPUT type="submit" value="Loggin">
    </FORM>
</body>
</html>
