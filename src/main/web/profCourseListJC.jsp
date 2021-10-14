<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 10/11/21
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="objects.profCoursesJC"%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="CssFiles/stud_list.css" rel="stylesheet">
    <title>J.A.N.S U Prof Course List</title>
</head>
<body>

<div class="topnav">
    <a href="profHomePageJC.jsp">Home</a>
    <a href="profCourseList">Courses</a>
    <a id="logout" href="adminLogout">Log Out</a>
</div>

<table class="content-table">
    <h1>Course List </h1>
    <% Object proCourse = request.getAttribute("profCourseList");
        System.out.println(proCourse);
    %>
    <thead>
    <tr>
        <th>course ID</th>
        <th>course Name</th>
        <th>course description</th>
    </tr>
    </thead>
    <c:forEach var="courseList" items="${courseList}">
        <tr>

            <form action="${pageContext.request.contextPath}/examList" method="post">
                <td><input type="text" name="course_ID" value="${courseList.course_ID}"/></td>
                <td><input type="text" name="course_name" value="${courseList.course_Name}"/></td>
                <td><input type="text" name="course_description" value ="${courseList.course_description}"/></td>
                <td><button type="submit">Edit Grade</button></td>
            </form>
        </tr>
    </c:forEach>
</table>

</body>
</html>
