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

<form:form method="post" action="/article/add" modelAttribute="article">
    Title: <form:input path="title" maxlength="100"/><br>
    Author: <form:select items="${authors}" itemValue="id" itemLabel="firstName" path="author.id"/><br>
    Categories: <form:select items="${cats}" itemValue="id" itemLabel="name" path="category" multiple="true"/><br>
    Content<form:textarea path="content" rows="5" cols="20"/><br>
    <input type="submit" value="Send">
</form:form>
</body>
</html>
