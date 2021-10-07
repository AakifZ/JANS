<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 10/3/2021
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <link href="CssFiles/prof_form.css" rel="stylesheet">
    <title>Hello</title>
</head>

<body>
<div id="form-container">
    <form action="profInsert">

        <div class="form-group">
            <label for="first_name">First Name</label><input id="first_name" type="text" name="first_name" required="required" />
        </div>
        <div class="form-group">
            <label for="last_name">Last Name</label><input id="last_name" type="text" name="last_name" required="required" />
        </div>
        <div class="form-group">
            <label for="email">Email</label><input id="email" type="text" name="email" required="required" />
        </div>

        <div class="form-group">
            <label for="phone">Phone #</label><input id="phone" type="text" name="phone" required="required">
        </div>


        <div class="form-group">
            <label for="admin">Admin ID</label><input id="admin" type="text" name="admin" required="required">
        </div>
        <div class="form-group">
            <label for="password">Password</label><input id="password" type="password" name="password" required="required" />
        </div>

        <div class="form-group">
            <label for="password-confirm">Confirm Password</label><input id="password-confirm" type="password" name="password-confirm"
                                                                         required="required" />
        </div>

        <input type="submit" value="Submit">
    </form>

</div>
<div class="form-group">
    <h3>${Error}</h3>
</div>
</body>

</html>