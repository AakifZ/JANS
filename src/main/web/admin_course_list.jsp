<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="objects.AdminCourse" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 10/7/2021
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="CssFiles/prof_list.css" rel="stylesheet">
  <title>Course List</title>
</head>
<body>
<% /*HttpSession session1 = request.getSession();
    if(session1.getAttribute("user") == null) {
        response.sendRedirect("sysAdminLoginPage.jsp");
    }*/
%>
<div class="topnav">
  <a href="profServ">Professor</a>
  <a href="studServ">Student</a>
  <a href="adminCourseListServlet">Course</a>
  <a id="logout" href="adminLogout">Log Out</a>
</div>
<table class="content-table">
  <h1>Courses:</h1>
  <a href="admin_course_insert_form.jsp">New Course</a>

  <thead>
  <tr>
    <th>Course ID</th>
    <th>Professor ID</th>
    <th>Course Name</th>
    <th>Course Description</th>
    <th>Admin ID</th>
    <th>Remove</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="adminCourseList" items="${adminCourseList}">
    <!-- onclick="window.location='courselist.jsp';"-->
    <tr>
      <td><c:out value="${adminCourseList.course_ID}"/></td>
      <td><c:out value="${adminCourseList.professor_ID}"/></td>
      <td><c:out value="${adminCourseList.course_name}"/></td>
      <td><c:out value="${adminCourseList.course_description}"/></td>
      <td><c:out value="${adminCourseList.sysAdmin}"/></td>
      <td><a href="adminCourseDeleteServlet?course_ID=<c:out value="${adminCourseList.course_ID}"/>&prof_ID=<c:out value="${adminCourseList.professor_ID}"/>"/>Delete</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
