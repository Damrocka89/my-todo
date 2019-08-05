<%--
  Created by IntelliJ IDEA.
  User: ewkra
  Date: 27.07.2019
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="webjars/bootstrap/3.4.0/css/bootstrap.min-jsf.css" rel="stylesheet">

    <title>Login</title>
</head>
<body>

<%@ include file="components/navbar.jsp" %>

<c:if test="${valid}">
    <div class="alert alert-danger"><h5>Invalid login attempt!</h5></div>
</c:if>

<form method="post" action="/login">
    Login: <input type="text" name="login"/>
    Password: <input type="password" name="password"/>
    <button type="submit" class="btn btn-primary">Login</button>
</form>

<form method="get" action="${pageContext.request.contextPath}/register" >
    <input type="submit" value="Register" class="btn btn-primary outline"/>
</form>



<script src="webjars/jquery/3.4.1/jquery.min.js"/>
<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"/>
</body>
</html>
