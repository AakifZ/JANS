<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type=text/css href="gradeStyle.css" rel="stylesheet">
    <link rel="icon" href="../images/JanLogo.png"/>
</head>

<title>JANS University Grading</title>

<! this is the hyperlink tabs>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>
<div class="headerTitle">
    <h1><img src="../images/JanLogo.png" width="50" height="50"> J.A.N.S. University</h1>
</div>
    <div class="w3-bar w3-black">
        <a href="index.jsp" class="w3-bar-item w3-button">Home</a>
        <a href="exams.jsp" class="w3-bar-item w3-button">Exams</a>
        <a href="courselist.jsp" class="w3-bar-item w3-button">ClassList</a>
    </div>


<! this is the welcome page>
<div class="header">
    <h1>Welcome to the JANS University Grading System!</h1>
</div>

<!this is the paragraph intro >
<div class="speech">
    <p>Hello Students! we're all about getting that bag and riding off in the sunset with latest Lambo. By doing so,
        we're not just laying on the couch eating chips,
        no... we at JANS University, we thrive in success with good grades and a LOT of passion. We are happy that you
        are a part of this saucey family! we expect nothing but the best!</p>
</div>
<% double num = Math.random() * 100;%>
<div class="speech">
    <h2>Your chance of success in life according to JANS University is: <% out.print(num); %>%</h2>
    <% if (num >= 70) {
        out.println("Nice");
    } else {
        out.println("Loser");
    } %>
</div>
</body>
</html>
