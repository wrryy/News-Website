<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%@ include file="../menu.jsp" %>

<form:form method="post" action="/author/edit" modelAttribute="author">
    <form:hidden path="id"/>
    First name: <form:input path="firstName"/><br>
    Last name: <form:input path="lastName"/><br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
