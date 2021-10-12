<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 10/11/21
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="objects.examListJC" %>
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
    <% Object examListJC = request.getAttribute("examL");
        System.out.println(examListJC);
    %>
    <thead>
    <tr>
        <th>Exam ID</th>
        <th>Exam Name</th>
        <th>Feedback</th>
    </tr>
    </thead>
    <c:forEach var="courL" items="${examL}">
        <tr>
            <td name="ID"><c:out value="${examL.exam_ID}"/></td>
            <td><c:out value="${examL.exam_Name}"/></td>
            <td><c:out value="${examL.feedback}"/></td>


        </tr>
    </c:forEach>
</table>

</body>
</html>
