<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Registration!</title>
            </head>
            <body>
                <h1>Personal Info Registration</h1>
                <P/>

                <form name="regForm" action="save" method="POST">
                    <input type="hidden" name="formId" value="3"/>
                    <input type="hidden" name="action" value="addHobby"/>

                    <label>First Name: <xsl:value-of select="person/firstName"/></label> <br/>
                    <!--<input type="hidden" size="20" name="firstname" value="${person.firstName}"><br>-->

                    <label>Last Name:  <xsl:value-of select="person/lastName"/></label> <br/>
                    <!--<input type="hidden" size="20" name="lastname" value="${person.lastName}"><br>-->

                    <label>Company Name: <xsl:value-of select="person/company"/></label> <br/>
                    <!--<input type="hidden" size="20" name="company" value="${person.company}"><br>-->

                    <label>Hobby: </label>
                    <input type="text" size="20" name="hobby"/><br/>

                    <input type="submit" value="Save"/>
                </form>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>