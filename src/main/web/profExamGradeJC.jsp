<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 10/11/21
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="objects.examGradesJC" %>
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
    <a href="profCourseList">Courses</a>
    <a id="logout" href="professorLoginPage.jsp">Log Out</a>
</div>


<table class="content-table">
    <h1>Exam Grade</h1>
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

        <tr onclick="window.location = 'examList=<c:out value = "${examList}"/>'">
            <form action="${pageContext.request.contextPath}/examInsert" method="post">

<%--                //<td name="ID"><c:out value="${examGrade.exam_number}"/></td>--%>
            <td ><input type="text" name="student_ID" value="${examGrade.student_ID}"/></td>
            <td><input type="text" name="first_Name"  value="${examGrade.first_Name}"/></td>
            <td><input type="text" name="last_Name" value="${examGrade.last_Name}"/></td>
            <td><input type="text" name="exam_Grade" value="${examGrade.exam_Grade}"/></td>

            </form>
        </tr>

    </c:forEach>
</table>

<h3>Edit Student Grades:</h3>
<a href="examGradeFormJC.jsp">Edit</a>
</body>
</html>
