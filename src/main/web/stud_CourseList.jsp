<%--
  Created by IntelliJ IDEA.
  User: aakif
  Date: 10/7/2021
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="objects.StudentCourses" %>
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
    <a href="StudCourseList">Student</a>
</div>
<table class="content-table">
    <h1>Courses</h1>
    <% Object studCourse = request.getAttribute("studCourseList");
        System.out.println(studCourse);
    %>
    <thead>
    <tr>
        <th>Course ID</th>
        <th>Course Name</th>
        <th>Description</th>
        <th>Professor ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="studCourseList" items="${studCourseList}">
        <tr>
            <td name="ID"><c:out value="${studCourseList.courseID}"/></td>
            <td><c:out value="${studCourseList.course_name}"/></td>
            <td><c:out value="${studCourseList.course_description}"/></td>
            <td><c:out value="${studCourseList.professor_ID}"/></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
