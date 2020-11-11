<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 11/11/2020
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h1>Add new product</h1>
    <label>Name</label>
    <input type="text" name = 'name'>
    <label>Price</label>
    <input type="text" name = "price">
    <label>Quantity</label>
    <input type="text" name = "color">
    <label>Description</label>
    <input type="text" name = "description">
    <label > Category</label>
    <select name="category">
        <c:forEach items="${listCategory}" var="category">
            <option value="${category.getcName}">${category.getcName}</option>
        </c:forEach>
    </select>
    <form>
    <button type="submit"></button>
    </form>
</form>
</body>
</html>
