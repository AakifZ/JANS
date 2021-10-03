<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 10/1/2021
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="CssFiles/professorLoginPage.css" rel="stylesheet">
    <title>Professor Login</title>
</head>
<body>
<h1>Professor Login</h1>
<div id="formContainer">
    <form action="professorLogin" method="post">
        <label for="user">ID/Email:</label><br>
        <input id="user" type="text" name="user" required="required"><br>
        <label for="pass">Password:</label><br>
        <input id="pass" type="password" name = "pass" required="required"><br>
        <input id="submit" type="submit" value="Submit">
        <h3>${Error}</h3>
    </form>
</div>
</body>
</html>