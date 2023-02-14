<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

<link rel="stylesheet" href="resources/css/main.css" >

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">


</head>
<body style= background-color:#97debb>

<nav class="navbar navbar-expand-md navbar-dark bg-dark" >
    <a class="navbar-brand" href="#">Bootstrap</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mx-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/main">Home</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="/books/add">Add Book</a>
            </li>
            <li class="nav-item">
                <a class="nav-link btn btn-dark" data-bs-target="#addModalToggle" data-bs-toggle="modal" href="/category/add">Add Category</a>

            </li>
            <li class="nav-item">
                <a class="nav-link" href="/services">Services</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="https://www.linkedin.com/in/javohir-orifjonov/">Contact</a>
            </li>
        </ul>
        <form class="form-inline">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-light my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>


<div class="modal fade" id="addModalToggle" aria-hidden="true" aria-labelledby="addModalToggleLabel"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="addModalToggleLabel">CREATE CATEGORY</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="/category/add">
                    <div class="mb-3">
                        <label for="categoryName" class="form-label">Category Name</label>
                        <input type="text" required="" class="form-control" id="categoryName" name="categoryName">
                    </div>
                    <button class="btn btn-success" onclick="myFunction()" >Save Category</button>

                    <script>
                        function myFunction() {
                            alert("Category added successfully!");
                        }
                    </script>
<%--                    <button type="submit" class="btn btn-success">Save Category</button>--%>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="/resources/js/main.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>