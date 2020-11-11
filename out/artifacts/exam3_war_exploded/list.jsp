<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: truon
  Date: 11/11/2020
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form>
    <table>
        <tr>
            <th>#</th>
            <th>Product Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach items="listProduct" var="product">
            <tr>
                <td>${product.getpId}</td>
                <td>${product.getpName}</td>
                <td>${product.getPrice}</td>
                <td>${product.getQuantity}</td>
                <td>${product.getColor}</td>
                <td>${product.getCategory}</td>
                <td>
                    <button type="button" value="edit"></button>
                    <button type="button" value="delete"></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
