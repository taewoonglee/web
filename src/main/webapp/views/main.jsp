<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>main</title>
</head>
<body>
<%@ include file="header.jsp" %>

<img src="/img/ffsf.png">

<h1>${uname} 환영합니다.</h1>

<%@ include file="todos.jsp"%>
<%@ include file="todolist.jsp"%>
<%@ include file="keyword.jsp"%>
</body>
</html>