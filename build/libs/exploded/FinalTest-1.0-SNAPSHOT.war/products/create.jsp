<%--
  Created by IntelliJ IDEA.
  User: TamLeDuc
  Date: 9/9/2020
  Time: 9:59 AM
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
<section class="m-auto" style="width: 75%">
    <h2>ADD NEW PRODUCT</h2>
    <form action="/products?action=create" method="post">
        <div class="form-group">
            <label>Name</label>
            <input type="text" class="form-control" placeholder="Enter name" name="name">
        </div>
        <div class="form-group">
            <label >Price</label>
            <input type="text" class="form-control" placeholder="Enter price" name="price">
        </div>
        <div class="form-group">
            <label >Quantity</label>
            <input type="text" class="form-control" placeholder="Enter quantity" name="quantity">
        </div>
        <div class="form-group">
            <label >Color</label>
            <input type="text" class="form-control" placeholder="Enter color" name="color">
        </div>
        <div class="form-group">
            <label >Description</label>
            <input type="text" class="form-control" placeholder="Enter description" name="description">
        </div>
        <div class="form-group">
            <label >Category</label>
            <input type="text" class="form-control" placeholder="Enter category" name="category">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</section>
</body>
</html>
