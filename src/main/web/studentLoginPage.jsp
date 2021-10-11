<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 9/27/21
  Time: 9:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CssFiles/professorLoginPage.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Login</title>
</head>
<body>
<h1>Student Login</h1>

<center>
    <form action="studentLogin" method="post">
        <br/>Username:<input type="number" name="user" required="required">
        <br/>Password:<input type="password" name="pass" required="required">
        <br/><input type="submit" value="Submit">
        <h3>${Error}</h3>
    </form>
</center>
</body>
</html>
