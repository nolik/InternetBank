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
<title>TransactionHistory</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="../css/w3.css">
<link rel="stylesheet" href="../css/raleway.css">
<head>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/background.css"/>
    <style>
        table, th, td {
            border: 1px solid black;
        }

        th, td {
            text-align: center;
        }

        .w3-container {
            padding: 2em 70px;
        }

        .wrapper {
            width: 90%;
            background: #182F2B;
            display: block;
            position: absolute;
            top: 35%;
            left: 20%;
            transform: translateY(-10%) translateX(-17%);
            opacity: 0.7;

        }

        .button-space {
            position: absolute;
            left: 1%;
            bottom: 2%;
            color: white;
        }
        .w3-jumbo-small{font-size:64px!important}

    </style>


</head>
<body>
<div class="bgimg w3-display-container w3-animate-opacity w3-text-black">

    <div class="w3-container w3-center">
        <h1 class="w3-jumbo-small w3-animate-top"><font color="black"> Transaction list</font></h1>
        <hr class="w3-border-grey" style="margin:auto;width:40%">
        <p class="w3-large w3-center"><font color="black">For bank cart: <c:out value="${operatingCartID}"/></font></p>

    </div>
    <b/>
    <br/>
    <div class="wrapper">
        <%-- Here  transaction-table implementation --%>
        <div class="w3-container w3-center">


            <table class="w3-gray w3-border w3-hoverable w3-centerw3-gray" style="width:100%">
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
        </div>
        <br/>
        <a href="${pageContext.request.contextPath}/jsp/main.jsp" class="w3-btn button-space">Main page</a
    </div>
</div>
</body>
</html>
