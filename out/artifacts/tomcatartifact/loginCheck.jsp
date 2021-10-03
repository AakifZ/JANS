<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 9/27/21
  Time: 9:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="CssFiles/gradeStyle.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");

    if((username.equals("jayC") && password.equals("cookies")))
    {
        session.setAttribute("username",username);
        response.sendRedirect("index.jsp");
    }
    else
        response.sendRedirect("Error.jsp");
%>
</body>
</html>
