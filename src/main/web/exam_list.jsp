<%--
  Created by IntelliJ IDEA.
  User: aakif
  Date: 10/2/2021
  Time: 7:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Exam List>
</head>
<body>
<% HttpSession session1 = request.getSession();
    if(session1.getAttribute("user") == null) {
        response.sendRedirect("studentLoginPage.jsp");
    }
%>
<div class="topnav">
    <a href="studServ">Professor</a>
    <a href="#">Student</a>
    <a href="#">Course</a>
    <a id="logout" href="adminLogout">Log Out</a>
</div>
<table class="content-table">
    <h1>Students:</h1>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>email</th>
        <th>gpa</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="Student" items="${examList}">
        <tr onclick="window.location='courselist.jsp';">
            <td><c:out value="${Student.student_ID}"/></td>
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

