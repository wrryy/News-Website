<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>HomePage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@ include file="menu.jsp" %>

<c:forEach items="top5" var="article">
    <div>
        <h3><c:out value="${article.title}"/></h3>
        <h6><c:out value="${article.created}"/></h6>
        <p><c:out value="${article.content}"/></p>
    </div>
</c:forEach>
</body>
</html>
