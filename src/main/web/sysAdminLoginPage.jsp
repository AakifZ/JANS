<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 10/2/2021
  Time: 11:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>Systems Administrator Login</title>
    <link href = "sysAdminLoginPage.css" rel="stylesheet">
</head>
<body>
<% /*HttpSession session1 = request.getSession();
if(session1.getAttribute("user") != null ) {
    System.out.println("you're good");
    RequestDispatcher rd = request.getRequestDispatcher("profServ/list");
    rd.forward(request, response);
}*/
%>
<form action="adminLogin" method="post">
    <label for="user">Email/ID</label><br>
    <input type = "type" name = "user" id="user"><br>
    <label for="pass">Password</label><br>
    <input type = "password" name = "pass" id="pass"><br>
    <input type="submit" value="Login">
    <h2>${Error}</h2>
</form>
</body>
</html>