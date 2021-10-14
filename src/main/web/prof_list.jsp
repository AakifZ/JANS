<%@ page import="objects.Professor" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 10/2/2021
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CssFiles/prof_list.css" rel="stylesheet">
    <title>Professor List</title>
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
    <h1>Professors:</h1>
    <a href="prof_form.jsp">New Professor</a>
    <% Object prof = request.getAttribute("profList");
        System.out.println(prof);
    %>
    <h3>${Error}</h3>
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Admin</th>
        <th>Remove</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="Professor" items="${profList}">
        <!-- onclick="window.location='courselist.jsp';"-->
        <tr>
            <td name="ID"><c:out value="${Professor.professor_ID}"/></td>
            <td><c:out value="${Professor.first_name}"/></td>
            <td><c:out value="${Professor.last_name}"/></td>
            <td><c:out value="${Professor.email}"/></td>
            <td><c:out value="${Professor.phone}"/></td>
            <td><c:out value="${Professor.admin}"/></td>
            <td><a href="profDelete?ID=<c:out value="${Professor.professor_ID}"/>"/>Delete</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
