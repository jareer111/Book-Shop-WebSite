<%--
  Created by IntelliJ IDEA.
  User: javohir
  Date: 02/03/2023
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About book</title>
    <link rel="stylesheet" href="/addition/css/single-book.css">
</head>
<body>

<div class="card">
    <nav>
        <form action="/addition/home">
            <button type="submit"> 🔙 </button>
            Back to all Books
        </form>
    </nav>
    <div class="photo">
        <img src="/download?filename=${book.getCoverGeneratedFileName()}" class="card-img-top"
             alt="${book.getCoverOriginalFileName()}" loading="lazy"/>
    </div>
    <div class="description">
        <h2>${book.getTitle()}</h2>
        <h4>${book.getAuthor()} </h4>
        <p>${book.getDescription()}</p>
        <button>Wiev</button>
        <button>Download</button>
    </div>
</div>
</body>
</html>
