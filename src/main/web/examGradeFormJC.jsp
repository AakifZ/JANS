<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 10/13/21
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link href="CssFiles/prof_form.css" rel="stylesheet">
    <title>Edit Student's Grade</title>
</head>

<body>
<div id="form-container">
    <form action="examGradeList">

        <div class="form-group">
            <label for="student_ID">Student ID</label><input id="student_ID" type="text" name="student_ID" required="required" />
        </div>
        <div class="form-group">
            <label for="exam_number">Exam Number</label><input id="exam_number" type="text" name="exam_number" required="required" />
        </div>

        <div class="form-group">
            <label for="exam_grade">Exam Grade</label><input id="exam_grade" type="text" name="exam_grade" required="required">
        </div>

        <input type="submit" value="Submit">
        <a href="examInsert">Cancel</a>
    </form>

</div>
<div class="form-group">
    <h3>${Error}</h3>
</div>
</body>

</html>
