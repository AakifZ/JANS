<%@ page import="objects.Student" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: nafri
  Date: 10/4/2021
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CssFiles/stud_list.css" rel="stylesheet">
    <title>Professor List</title>
</head>
<body>

<div class="topnav">
    <a href="profServ">Professor</a>
    <a href="#">Student</a>
    <a href="#">Course</a>
    <a id="logout" href="adminLogout">Log Out</a>
</div>
<table class="content-table">
    <h1>Students:</h1>
    <a href="stud_form.jsp">New Student</a>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Gpa</th>
        <th>Admin</th>
        <th>Remove</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="Professor" items="${studList}">
        <!-- onclick="window.location='courselist.jsp';"-->
        <tr>
            <td name="ID"><c:out value="${Students.student_ID}"/></td>
            <td><c:out value="${Student.first_name}"/></td>
            <td><c:out value="${Student.last_name}"/></td>
            <td><c:out value="${Student.email}"/></td>
            <td><c:out value="${Student.gpa}"/></td>
            <td><c:out value="${Student.sysAdmin}"/></td>
            <td><a href="profDelete?ID=<c:out value="${Professor.professor_ID}"/>"/>Delete</td>

        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
