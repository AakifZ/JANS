
<%--
  Created by IntelliJ IDEA.
  User: aakif
  Date: 10/09/2021
  Time: 12:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <link href="CssFiles/stud_list.css" rel="stylesheet">
    <title>Exam Grades</title>
</head>
<body>

<div class="topnav">
    <a id="Home" href="studentindex.jsp">Home</a>
    <a href="StudCourseList">Student</a>
    <a id="logout" href="studLogout">Log Out</a>
</div>
<table class="content-table">
    <h1>Exam Grades</h1>
    <thead>
    <tr>
        <th>Exam Number</th>
        <th>Name</th>
        <th>Grade</th>
        <th>Feedback</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="studExamList" items="${studExamList}">

            <tr>
                <td name="ID"><c:out value="${studExamList.exam_number}"/></td>
                <td><c:out value="${studExamList.exam_name}"/></td>
                <td><c:out value="${studExamList.exam_grade}"/></td>
                <td><c:out value="${studExamList.exam_feedback}"/></td>

            </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
