<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration!</title>
</head>
<body>
<jsp:useBean id="person" class="by.bsu.fpmi.contactRegistration.model.Person" scope="session"/>
<h1>Contact Registration</h1>

<P>

<form action="addCompany" method="POST">

    <label>First Name:</label>
    <input type="text" size="20" name="firstname"><br>

    <label>Last Name:</label>
    <input type="text" size="20" name="lastname"><br>

    <input type="submit" value="Next">
</form>
</body>
</html>