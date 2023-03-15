<%--
  Created by IntelliJ IDEA.
  User: jlkesh
  Date: 06/02/23
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Users List</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css">
</head>
<body>
<div class="row">
    <div class="col-md-10 offset-1">
        <h1 style="text-align: center">Users List</h1>
        <form class="align-content-center">
        <nav aria-label="..." >
            <ul class="pagination mt-6">
                <c:if test="${hasPrevious}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${previous}">Previous</a>
                    </li>
                </c:if>
                <c:set value="${currentPage}" var="cur"/>
                <c:forEach begin="0" end="${pageCount}" var="i">
                    <li class="page-item ${cur == i ? "active":""}">
                        <a class="page-link" href="?page=${i}">${i+1}</a>
                    </li>
                </c:forEach>
                <c:if test="${hasNext}">
                    <li class="page-item">
                        <a class="page-link" href="?page=${next}">Next</a>
                    </li>
                </c:if>
            </ul>
        </nav>
        </form>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col" style="color: #0a53be">ID</th>
                <th scope="col">Username</th>
                <th scope="col">Email</th>
                <th scope="col">Is Active</th>
                <th scope="col">Roles</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${counter=counter+1}</td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getIsActive()}</td>
                    <td>
                    <c:forEach items="${user.getRole()}" var="role">
                        <td>${role}</td>
                    </c:forEach>
                    </td>
                    <td>
                        <button class="btn btn-warning" data-bs-target="#updateUserModal" data-bs-toggle="modal" onclick="update(${user.getId()})">Update</button> ||
                        <a class="btn btn-danger" href="/users/delete/${user.getId()}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<div class="modal fade" id="addModalToggle" aria-hidden="true" aria-labelledby="addModalToggleLabel"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="addModalToggleLabel">Create User</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="/users/add">
                    <div class="mb-3">
                        <label for="firstName" class="form-label">User First Name</label>
                        <input type="text" class="form-control" id="firstName" name="firstName">
                    </div>
                    <div class="mb-3">
                        <label for="lastName" class="form-label">User Last Name</label>
                        <input type="text" class="form-control" id="lastName" name="lastName">
                    </div>

                    <div class="mb-3">
                        <label for="age" class="form-label">User Age</label>
                        <input type="number" class="form-control" id="age" name="age">
                    </div>

                    <button type="submit" class="btn btn-success">Save User</button>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="updateUserModal" aria-hidden="true" aria-labelledby="UpdateUserModalLabel"
     tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="UpdateUserModalLabel">Update User</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form method="post" action="/users/update/">
                    <input type="hidden" id="u_id" name="id" />
                    <div class="mb-3">
                        <label for="u_username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="u_username" name="username">
                    </div>
                    <div class="mb-3">
                        <label for="u_email" class="form-label">Email</label>
                        <input type="text" class="form-control" id="u_email" name="email">
                    </div>

                    <div class="mb-3">
                        <label for="u_role" class="form-label">Role</label>
                        <input type="text" class="form-control" id="u_role" name="role">
                    </div>
                    <button type="submit" class="btn btn-success">Update User</button>
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
