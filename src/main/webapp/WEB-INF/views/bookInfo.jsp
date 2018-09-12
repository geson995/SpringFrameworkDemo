<%--
  Created by IntelliJ IDEA.
  User: geson
  Date: 2018/9/10
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Detail</title>
</head>
<body>
<h2><a href="/">Back To Index</a></h2>
<c:choose>
    <c:when test="${hasBook}">
        <h2>BookId:${bookModel.id}</h2>
        <h2>BookName:${bookModel.name}</h2>
        <h2>BookPrice:${bookModel.price}</h2>
        <h2>BookCount:${bookModel.count}</h2>
    </c:when>
    <c:otherwise>
        <h2>No Such Book Named <abbr>${bookName}</abbr>,ReInput BookName.</h2>
    </c:otherwise>
</c:choose>
</body>
</html>
