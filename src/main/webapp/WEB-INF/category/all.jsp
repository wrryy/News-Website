<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>HomePage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../menu.jsp" %><br>
<a href="/category/add">Add category</a><br>
<h2>Categories list</h2>
<ul>
<c:forEach items="${category}" var="cat">
        <li>
        <h4><c:out value="${cat.name}"/></h4>
        <h6><c:out value="${cat.description}"/></h6>
            <a href="/category/edit/${cat.id}">Edit  </a>
            <a href="/category/delete/${cat.id}">Delete</a>
        </li>
    </div>
</c:forEach>
</ul>
</body>
</html>
