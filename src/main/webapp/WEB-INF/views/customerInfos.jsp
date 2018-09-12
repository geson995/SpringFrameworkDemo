<%--
  Created by IntelliJ IDEA.
  User: geson
  Date: 2018/9/10
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%--<%@page import="com.springmvc.entity.Customer" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show All Customers</title>
</head>
<body>
<h2><a href="/">Back to the Index</a></h2>
<c:forEach items="${customerList}" var="item">
    CustomerId:<c:out value="${item.id}"/>
    <br>
    CustomerName:<c:out value="${item.name}"/>
    <br>
    CustomerBalance:<c:out value="${item.balance}"/>
    <h3>--------------------------------------------</h3>
</c:forEach>
</body>
</html>
