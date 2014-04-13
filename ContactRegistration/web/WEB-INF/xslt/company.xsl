<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Person's Company Registration</title>
            </head>
            <body>
                <h1>Contact Registration XSL</h1>
                <P/>
                <form name="regForm" action="addHobby" method="POST">
                    <input type="hidden" name="formId" value="2"/>
                    <input type="hidden" name="action" value="addCompany"/>

                    <label>First Name: <xsl:value-of select="person/firstName"/> </label> <br/>
                    <!--<input size="20" name="firstname"> <xsl:value-of select="person/firstName"/></input> <br/>-->

                    <label>Last Name: <xsl:value-of select="person/lastName"/></label> <br/>
                    <!--<input size="20" name="lastname"> <xsl:value-of select="person/lastName"/></input> <br/>-->

                    <label>Company Name:</label>
                    <input type="text" size="20" name="company"/><br/>

                    <input type="submit" value="Next"/>
                </form>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>