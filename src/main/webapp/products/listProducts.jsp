<%--
  Created by IntelliJ IDEA.
  User: TamLeDuc
  Date: 9/9/2020
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <style>
        *{
            box-sizing: border-box;
        }
    </style>
</head>
<body>
<section class="m-auto" style="width: 80%">
    <a href="/products?action=create" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Add new product</a>
    <form action="/products?action=find" method="post" class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Enter product" name="nameFind">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Product Name</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Color</th>
            <th scope="col">Category</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope['listProduct']}" var="product">
            <tr>
                <td scope="row">${product.getId()}</td>
                <td scope="row">${product.getName()}</td>
                <td scope="row">${product.getPrice()}</td>
                <td scope="row">${product.getQuantity()}</td>
                <td scope="row">${product.getColor()}</td>
                <td scope="row">${product.getCategory()}</td>
                <td scope="row"><a class="nav-link" href="/products?action=edit&id=${product.getId()}">Edit</a></td>
                <td scope="row"><a class="nav-link" href="/products?action=delete&id=${product.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
