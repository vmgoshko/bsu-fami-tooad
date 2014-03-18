<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration!</title>
</head>
<body>
<h1>Personal Info Registration</h1>
<P>

<form name="regForm" action="save" method="POST">
    <input type="hidden" name="formId" value="3">
    <input type="hidden" name="action" value="addHobby">

    <label>First Name: ${person.firstName}</label>
    <input type="hidden" size="20" name="firstname" value="${person.firstName}"><br>

    <label>Last Name:  ${person.lastName}</label>
    <input type="hidden" size="20" name="lastname" value="${person.lastName}"><br>

    <label>Company Name: ${person.company}</label>
    <input type="hidden" size="20" name="company" value="${person.company}"><br>

    <label>Hobby: </label>
    <input type="text" size="20" name="hobby"><br>

    <input type="submit" value="Save">
</form>
</body>
</html>