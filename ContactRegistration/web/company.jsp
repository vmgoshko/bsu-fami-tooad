<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration!</title>
</head>
<body>
<h1>Person's Company Registration</h1>
<P>

<form action="addHobby" method="POST">

    <label>First Name: ${person.firstName}</label>
    <input type="hidden" size="20" name="firstname" value="${person.firstName}"><br>

    <label>Last Name:  ${person.lastName}</label>
    <input type="hidden" size="20" name="lastname" value="${person.lastName}"><br>

    <label>Company Name:</label>
    <input type="text" size="20" name="companyname"><br>

    <input type="submit" value="Next">
</form>
</body>
</html>