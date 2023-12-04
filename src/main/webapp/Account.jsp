<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Information</title>
</head>
<body>

<h1>Account Information</h1>

<%
    // Replace the following lines with your actual data retrieval logic
    String profilePicture = "path/to/profile_pic_admin.jpg";
    String email = "amrelgen12@gmail.com";
    String username = "password";
%>

<form action="/insert" method="post" enctype="multipart/form-data">
    <img src="<%= profilePicture %>" alt="Profile Picture" width="150" height="150">
    <br>

    <label for="newProfilePicture">Upload New Profile Picture:</label>
    <input type="file" id="newProfilePicture" name="file">
    <br>

    <input type="submit" value="Save">
</form>

<br>

<strong>Email:</strong> <%= email %>
<br>

<strong>User Name:</strong> <%= username %>

</body>
</html>
