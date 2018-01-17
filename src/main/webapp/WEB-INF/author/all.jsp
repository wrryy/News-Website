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
<a href="/author/add">Add author</a><br>
<h2>Authors list</h2>
<ol>
<c:forEach items="${author}" var="auth">
        <li>
        <h4><c:out value="${auth.firstName}"/></h4>
        <h6><c:out value="${auth.lastName}"/></h6>
            <a href="/author/edit/${auth.id}">Edit  </a>
            <a href="/author/delete/${auth.id}">Delete</a>
        </li>
    </div>
</c:forEach>
</ol>
</body>
</html>
