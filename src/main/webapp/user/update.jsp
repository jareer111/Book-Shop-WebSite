<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 06/02/23
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users List</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-md-10 offset-1">
        <h1 class="text-center">User Create Page</h1>
        <form method="post">
            <input type="hidden" name="id" value="${user.getId()}">
            <div class="mb-3">
                <label for="firstName" class="form-label">User First Name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" value="${user.getFirstName()}">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">User Last Name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" value="${user.getLastName()}">
            </div>

            <div class="mb-3">
                <label for="age" class="form-label">User Age</label>
                <input type="number" class="form-control" id="age" name="age" value="${user.getAge()}">
            </div>

            <a href="/users" class="btn btn-warning">Back</a>
            <button type="submit" class="btn btn-primary">Update User</button>
        </form>
    </div>
</div>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
</body>
</html>
