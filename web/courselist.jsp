<%--
  Created by IntelliJ IDEA.
  User: jonathancampos
  Date: 9/27/21
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link href="gradeStyle.css" rel="stylesheet">
    <script src="gradingSysJS.js"></script>
    <link rel="icon" href="../../../../web/images/JanLogo.png"/>
</head>

<title> J.A.N.S University Class List</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="headerTitle">
    <h1><img src="../../../../web/images/JanLogo.png" width="50" height="50"> J.A.N.S. University</h1>
</div>

<!hyperlink>
<div class="tabs">

    <a href="index.jsp" class="w3-bar-item w3-button">Home</a>
    <a href="exams.jsp" class="w3-bar-item w3-button">Assignments</a>
    <a href="courselist.jsp" class="w3-bar-item w3-button">Courses</a>
</div>


<div class="headerTitle">
    <h2><b>Course List</b></h2>
</div>

<br>
<br>

<div class="textFormat">
    <p><b>Add course:</b></p>
    <br>
    <br>
    <input id="inputOne" placeholder="Enter Course Name" type="text"/>
    <br>
    <br>
    <input id="inputTwo" placeholder="Enter Date" type="text"/>
    <br>
    <br>
    <input id="inputThree" placeholder="Enter Description" type="text"/>
    <br>
    <br>
    <div>
        <button onclick="addClass()">Create Class</button>
    </div>
</div>

<br>
<br>

<div class="display">
    <h3>Added Courses: </h3>
    <div id="displayClass"></div>
</div>


<br>
<br>
<br>
<br>

<div class="headerTitleOne">
    <p>Copyrighted by the J.A.N.S University peeps.</p>
</div>

</body>
</html>
