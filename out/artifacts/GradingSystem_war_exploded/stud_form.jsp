<%--
  Created by IntelliJ IDEA.
  User: nafri
  Date: 10/4/2021
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="stud_html.css" rel="stylesheet">
    <title>Hello</title>
</head>
<body>
<div id="form-container">
    <form action="studInsert">
        <input type="text" placeholder="first_name" name="first_name"/><br>
        <input type="text" placeholder="last_name" name="last_name"/><br>
        <input type="text" placeholder="email" name="email"/><br>
        <input type="text" placeholder="gpa" name="gpa"/><br>
        <input type="text" placeholder="admin" name="admin"/><br>
        <input type="text" placeholder="password" name="password"/><br>
        <input type="submit" value="Submit">
    </form>
    <h3>${Error}</h3>
</div>
</body>
</html>
