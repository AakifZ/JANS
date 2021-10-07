<%--
  Created by IntelliJ IDEA.
  User: aakif
  Date: 10/7/2021
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="objects.courseList" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CssFiles/stud_list.css" rel="stylesheet">
    <title>Student Courses</title>
</head>
<body>

<div class="topnav">
    <a href="#">Student</a>
</div>
<table class="content-table">
    <h1>Courses</h1>
    <% Object stud = request.getAttribute("studList");
        System.out.println(stud);
    %>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Gpa</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="Student" items="${studList}">
        <tr>
            <td name="ID"><c:out value="${Student.student_ID}"/></td>
            <td><c:out value="${Student.first_name}"/></td>
            <td><c:out value="${Student.last_name}"/></td>
            <td><c:out value="${Student.email}"/></td>
            <td><c:out value="${Student.gpa}"/></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
