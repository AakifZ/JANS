<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 10/3/2021
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="prof_html.css" rel="stylesheet">
    <title>Hello</title>
</head>
<body>
<div id="form-container">
    <form action="profInsert">
        <input type="text" placeholder="first_name" name="first_name"/><br>
        <input type="text" placeholder="last_name" name="last_name"/><br>
        <input type="text" placeholder="email" name="email"/><br>
        <input type = "text" placeholder="phone" name="phone"><br>
        <input type="text" placeholder="admin" name="admin"><br>
        <input type = "text" placeholder="password" name="password"/><br>
        <input type = "submit" value="Submit">
    </form>
    <h3>${Error}</h3>
</div>
</body>
</html>