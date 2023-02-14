<%--
  Created by IntelliJ IDEA.
  User: javohir
  Date: 09/02/2023
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>


<div class="modal fade" id="addModalToggle" aria-hidden="true" aria-labelledby="addModalToggleLabel"
     tabindex="-1">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="addModalToggleLabel">Create Student</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="post" action="/students/add">
          <div class="mb-3">
            <label for="firstName" class="form-label">Student First Name</label>
            <input type="text" class="form-control" id="firstName" name="firstName">
          </div>
          <div class="mb-3">
            <label for="lastName" class="form-label">Student Last Name</label>
            <input type="text" class="form-control" id="lastName" name="lastName">
          </div>

          <div class="mb-3">
            <label for="age" class="form-label">Student Age</label>
            <input type="number" class="form-control" id="age" name="age">
          </div>

          <button type="submit" class="btn btn-success">Save Student</button>
        </form>
      </div>
    </div>
  </div>
</div>

<script src="/resources/js/main.js"></script>
<script src="/resources/js/popper.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>


</body>
</html>
