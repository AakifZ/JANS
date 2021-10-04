<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <link href="gradeStyle.css" rel="stylesheet">
    <script src="gradingSysJS.js"></script>
    <link rel="icon" href="images/JanLogo.png"/>
</head>

<title>JANS University Assignments</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<div class="headerTitle">
    <h1><img src="images/JanLogo.png" width="50" height="50"> J.A.N.S. University</h1>
</div>
<!hyperlink>
    <div class="w3-bar w3-black">
        <a href="index.jsp" class="w3-bar-item w3-button">Home</a>
        <a href="exams.jsp" class="w3-bar-item w3-button">Exams</a>
        <a href="courselist.jsp" class="w3-bar-item w3-button">ClassList</a>
    </div>

<br>
<br>
<div class="textFormat">
    <p><b>Enter Student's Exam:</b></p>
    <br>
    <br>
    <input id="inputOne" placeholder="Enter Student ID" type="text"/>
    <br>
    <br>
    <input id="inputTwo" placeholder="Enter Exam Number" type="text"/>
    <br>
    <br>
    <input id="inputThree" placeholder="Enter Exam Grade" type="text"/>
    <br>
    <br>
    <div>
        <button onclick="addClass()">Enter Grade</button>
    </div>
</div>

<br>
<br>

<div class="display">
    <h3>Exam's Entered: </h3>
    <div id="displayClass"></div>
</div>


<br>
<br>
<br>
<br>

<div class="speech">
    <p>Your assignments are posted here. Remember... it's all about getting that bag ;)</p>

    <table>
    <tr>
        <th><u>Exams</u></th>
        <th><u>Grade</u></th>
        <th><u>Feedback</u></th>
    <tr>
        <td>Exam 1</td>
        <td>83%</td>
        <td><br>9. Needed to add the solution and then use the formula to determine how much time it takes the ball to travel around the pole. </br>
            <br>13.Correct usage of formula but did not take the percentage of how much of the object was in the shaded area. Talk to me in office hours for full solution breakdown </br>
            <br>15. Good job just took 1/2 point off for not rounding to the nearest hundredth.
        </td>
    </tr>
    <tr>
        <td>Exam 2</td>
        <td>79%</td>
        <td>Hi</td>
    </tr>
</table>
</div>

<div class="headerTitleOne">
    <p>Copyrighted by the J.A.N.S University peeps.</p>
</div>

</body>
</html>