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
<h2>Articles list</h2>
<c:forEach items="${article}" var="art">
    <div>
        <h3><c:out value="${art.title}"/></h3>
        <h6><c:out value="${art.created}"/></h6>
        <a href="/article/edit/${art.id}">Edit  </a>
        <a href="/article/delete/${art.id}">Delete</a>
        <p><c:out value="${art.content}"/></p>
    </div>
</c:forEach>
</body>
</html>
