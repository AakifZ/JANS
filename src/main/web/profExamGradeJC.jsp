<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 10/11/21
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="objects.examgradeStuJC" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CssFiles/stud_list.css" rel="stylesheet">
    <title>J.A.N.S U Prof Exam List</title>
</head>
<body>

<div class="topnav">
    <a href="profHomePageJC.jsp">Home</a>
    <a href="profCourseListJC.jsp">Courses</a>
    <a id="logout" href="adminLogout">Log Out</a>
</div>

<table class="content-table">
    <h1>Exam List</h1>
    <% Object examgradeStuJC = request.getAttribute("examGrade");
        System.out.println(examgradeStuJC);
    %>
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Student ID</th>
        <th>Exam Number</th>
        <th>Grade</th>
    </tr>
    </thead>
    <c:forEach var="examGrade" items="${examGrade}">
        <tr>
            <td name="ID"><c:out value="${examGrade.exam_number}"/></td>
            <td><c:out value="${examGrade.student_ID}"/></td>
            <td><c:out value="${examGrade.first_Name}"/></td>
            <td><c:out value="${examGrade.last_Name}"/></td>
            <td><c:out value="${examGrade.exam_Grade}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
