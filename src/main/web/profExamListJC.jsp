<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 10/11/21
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="objects.exam" %>
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


<%--<% Object proExam = request.getAttribute("StuExamList");--%>
<%--    System.out.println("TEST" + proExam);--%>
<%--%>--%>
<%--<c:out value="${proExam}"/>--%>

<%--<c:set var="examList" value="${StuExamList}"/>--%>
<%--<p>${examList}</p>--%>
<%--<p>${StuExamList}</p>--%>

    <th>Exam Number</th>
    <th>Exam Name</th>
    <th>Feedback</th>

<c:forEach items="${StuExamList}" var="exam">

    <tr>
        <form action="${pageContext.request.contextPath}/examGradeList" method="post">
        <td><input type="text" name="exam_number" value="${exam.exam_number}"/></td>
    <td><input type="text" name="exam_name" value="${exam.exam_name}"/></td>
            <td><input type="text" name="exam_grade" value ="${exam.exam_grade}"/></td>
    <td><input type="text" name="feedback" value ="${exam.feedback}"/></td>
        <td><button type="submit">Edit Grade</button></td>
        </form>
    </tr>
</c:forEach>
</table>
</body>
</html>

