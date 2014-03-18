<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration!</title>
</head>
<body>
<h1>Person's Company Registration</h1>
<P>

<form name="regForm" action="addHobby" method="POST">
    <input type="hidden" name="formId" value="2">
    <input type="hidden" name="action" value="addCompany">

    <label>First Name: ${person.firstName}</label>
    <input type="hidden" size="20" name="firstname" value="${person.firstName}"><br>

    <label>Last Name:  ${person.lastName}</label>
    <input type="hidden" size="20" name="lastname" value="${person.lastName}"><br>

    <label>Company Name:</label>
    <input type="text" size="20" name="company"><br>

    <input type="submit" value="Next">
</form>
</body>
</html>