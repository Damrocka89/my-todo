<%--@elvariable id="toDoModel" type="com.sda.model.ToDoModel"--%>
<%--
  Created by IntelliJ IDEA.
  User: ewkra
  Date: 03.08.2019
  Time: 13:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Edit</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="components/navbar.jsp" %>


<form action="/to-do/edit" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <input type="text" class="form-control" id="title" name="title" value="${todo.title}">
        </div>
        <div class="form-group col-md-6">
            <select class="form-control" id="category" name="category">
                <option selected>${todo.category}</option selected>
                <c:forEach items="${categories}" var="category">
                    <c:if test="${category != todo.category}">
                        <option>${category}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group col-md-9">
        <input type="text" class="form-control" id="description" name="description" value="${todo.description}">
    </div>
    <div class="form-row">
        <div class="form-group col-md-3">
            <input class="form-control" type="date" id="dueDate" name="dueDate" value="${todo.dueDate}">
        </div>
    </div>
    <div class="form-row">
        <input type=hidden name="id" value="${todo.id}">
        <button type="submit" class="btn btn-primary btn-block">Update</button>
    </div>
</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/jquery.min.js"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
