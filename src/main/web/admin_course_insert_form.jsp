<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: 10/7/2021
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <link href="CssFiles/prof_form.css" rel="stylesheet">
    <title>Add Course</title>
</head>

<body>
<div id="form-container">
    <form action="adminCourseInsertServlet">

        <div class="form-group">
            <label for="course_ID">Course ID</label><input id="course_ID" type="number" name="course_ID" required="required"/>
        </div>
        <div class="form-group">
            <label for="professor_ID">Professor ID</label><input id="professor_ID" type="number" name="professor_ID" required="required"/>
        </div>
        <div class="form-group">
            <label for="course_name">Course Name</label><input id="course_name" type="text" name="course_name" required="required" />
        </div>

        <div class="form-group">
            <label for="course_desc">Course Description</label><textarea maxlength="250" id="course_desc" name="course_desc" required="required"></textarea>
        </div>

        <div class="form-group">
            <label for="admin">Admin ID</label><input id="admin" type="number" name="admin" required="required">
        </div>

        <input type="submit" value="Submit">
        <a href="adminCourseListServlet">Cancel</a>
    </form>

</div>
<div class="form-group">
    <h3>${Error}</h3>
</div>
</body>

</html>