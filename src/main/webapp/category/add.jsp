<%--
  Created by IntelliJ IDEA.
  User: javohir
  Date: 08/02/2023
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<html>
<head>
    <title>Add category</title>
</head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="/resources/css/book-add.css">

<body>
<form action="/category/add" class="form-horizontal" method="post" >
    <fieldset>

        <!-- Form Name -->
        <div class="main_header">
            <h1>ADD CATEGORY</h1>
        </div>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="category_name">CATEGORY NAME</label>
            <div class="col-md-4">
                <input id="category_name" name="category_name" placeholder="CATEGORY NAME" class="form-control input-md"
                       required
                       type="text">
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebutton">BUTTONS</label>
            <div class="col-md-4">
                <button id="singlebutton" name="singlebutton" class="btn btn-success">SAVE CATEGORY</button>
                ||
                <a href="/user/home" class="btn btn-danger">Back</a>
            </div>
        </div>

    </fieldset>
</form>

<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</body>
</html>
