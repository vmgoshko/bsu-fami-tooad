<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration!</title>
</head>
<body>
<jsp:useBean id="person" class="by.bsu.fpmi.contactRegistration.model.Person" scope="session"/>
<jsp:useBean id="lastFormId" class="java.lang.String" scope="session"/>
<h1>Contact Registration</h1>

<P>

<form name="regForm" action="addCompany" method="POST">
    <input type="hidden" name="formId" value="1">
    <input type="hidden" name="action" value="addFullName">

    <label>First Name:</label>
    <input type="text" size="20" name="firstname"><br>

    <label>Last Name:</label>
    <input type="text" size="20" name="lastname"><br>

    <input type="submit" value="Next">
</form>
</body>
</html>