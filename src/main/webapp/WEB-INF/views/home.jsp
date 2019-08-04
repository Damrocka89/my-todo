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
    <title>Homepage</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">List of Todos</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="table-responsive">
    <table class="table">
        <tr>
            <th>#</th>
            <th>Title</th>
            <th>Category</th>
            <th>Creation Date</th>
            <th>Deadline</th>
            <th>Description</th>
        <tr>
        <c:set var="counter" value="${0}"></c:set>
            <c:forEach items="${todos}" var="todo">
        <tr <c:if test="${todo.done == true}"> class="success" </c:if> >
            <td><h6>${counter}</h6></td>
            <td><h6>${todo.title}</h6></td>
            <td><h6>${todo.category}</h6></td>
            <td><h6>${todo.creationDate}</h6></td>
            <td><h6>${todo.dueDate}</h6></td>
            <td><h6>${todo.description}</h6></td>
            <td>
                <form action="/markAsDone" method="get">
                    <input type=hidden name="id" value="${todo.id}">
                    <c:if test="${todo.done == false}">
                        <input type="submit" value="Done" class="btn btn-success outline"/>
                    </c:if>
                </form>
            </td>
            <td>
                <form action="/edit" method="get">
                    <input type=hidden name="id" value="${todo.id}">
                    <input type="submit" value="Edit" class="btn btn-primary outline"/>
                </form>
            </td>
            <td>
                <form action="<c:url value="/delete"/>" method="get">
                    <input type=hidden name="id" value="${todo.id}">
                    <input type="submit" value="Delete" class="btn btn-danger outline"/>
                </form>
            </td>
        </tr>
        <c:set var="counter" value="${counter+1}"></c:set>
    </c:forEach>
    </table>
</div>


<form action="/save" method="get">
    <div class="form-row">
        <div class="form-group col-md-6">
            <input type="text" class="form-control" id="title" name="title" placeholder="Title">
        </div>
        <div class="form-group col-md-6">
            <select class="form-control" id="category" name="category">
                <c:forEach items="${categories}" var="category">
                    <option>${category}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group col-md-9">
        <input type="text" class="form-control" id="description" name="description" placeholder="Description">
    </div>
    <div class="form-row">
        <div class="form-group col-md-3">
            <input class="form-control" type="date" value="Deadline" id="dueDate" name="dueDate">
        </div>
    </div>
    <div class="form-row">
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
    </div>
</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/jquery.min.js"/>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
