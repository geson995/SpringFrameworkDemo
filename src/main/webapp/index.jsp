<%@ page contentType="text/html;UTF-8" language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Document</title>
    <script src="/js/jquery-3.3.1.js"></script>
</head>
<body>
<ul id="nav">
    <li><a href="/customerInfos">Show all customers</a></li>
    <li><a href="#" onclick="javascript:alert('coming soon!')">Show all books</a></li>
</ul>
<h3>Purchase a Book:</h3>
<form action="/purchase" method="post">
    CustomerName: <input type="text" name="customerName">
    BookName:<input type="text" name="bookName">
    <input type="submit" value="提交">
</form>
<h3>Query a Book:</h3>
BookName:<input type="text" id="bookName"><br>
<input type="submit" value="查询" id="queryBook">
</body>
<h3>Recharge for Customer</h3>
<form action="/recharge"></form>
<script type="text/javascript">
    var buttom = document.getElementById("queryBook");
    buttom.onclick = function (ev) {
        var bookName = document.getElementById("bookName").value;
        location.href = "bookInfo/" + bookName;
    }
</script>
</html>