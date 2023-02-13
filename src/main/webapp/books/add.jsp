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
<head >
    <title>Add book</title>
</head>
<body >
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<link rel="stylesheet" href="/books/book_resources/add.css">
<!------ Include the above in your HEAD tag ---------->

<form class="form-horizontal" method="post" enctype="multipart/form-data">
    <fieldset>

        <!-- Form Name -->
        <div class="main_header">
        <h1>ADD BOOKS</h1>
        </div>
        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="book_name">BOOK NAME</label>
            <div class="col-md-4">
                <input id="book_name" name="book_name" placeholder="BOOK NAME" class="form-control input-md" required type="text">

            </div>
        </div>


        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="author">AUTHOR</label>
            <div class="col-md-4">
                <input id="author" name="author" placeholder="AUTHOR" class="form-control input-md" required="" type="text">

            </div>
        </div>  <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="publisher">PUBLISHER</label>
            <div class="col-md-4">
                <input id="publisher" name="publisher" placeholder="PUBLISHER" class="form-control input-md" required="" type="text">
            </div>
        </div>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="publish_date">PUBLISH DATE</label>
            <div class="col-md-4">
                <input id="publish_date" name="publish_date" placeholder="PUBLISH DATE" class="form-control input-md" required="" type="datetime-local">

            </div>
        </div>

        <!-- Select Basic -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="book_categorie">BOOK CATEGORY</label>
            <div class="col-md-4">
                <select class="form-select"   aria-label="select example" style="margin-top: 30px" id="book_categorie"
                        name="book_categorie">
                    <option value="0">Choose a category</option>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.getId()}">${category.getName()}</option>
                    </c:forEach>
                </select>
            </div>
        </div>


        <!-- Textarea -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="book_description">BOOK DESCRIPTION</label>
            <div class="col-md-4">
                <textarea class="form-control" id="book_description" placeholder="BOOK DESCRIPTION" name="book_description"></textarea>
            </div>
        </div>


                <!-- File Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="file_picture_button">BOOK_IMAGE</label>
                    <div class="col-md-4">
                        <input id="file_picture_button" name="image" class="input-file" type="file">
                    </div>
                </div>

                <!-- File Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="filebutton">BOOK_FILE</label>
                    <div class="col-md-4">
                        <input id="filebutton" name="file" class="input-file" type="file">
                    </div>
                </div>

                <!-- Button -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="singlebutton">BUTTONS</label>
                    <div class="col-md-4">
                        <button id="singlebutton" name="singlebutton" class="btn btn-success">SAVE BOOK</button>  ||
                        <a href="/main" class="btn btn-danger">Back</a>
                    </div>
                </div>

    </fieldset>
</form>

<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</body>
</html>
