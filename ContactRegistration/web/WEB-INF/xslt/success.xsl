<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head>
                <title>Registration!</title>
            </head>
            <body>
                <h1>Congratulation!</h1>
                <input type="hidden" name="formId" value="4"/>
                <P/>
                <label>Contact has been saved successfully.</label> <br/>

                <table>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Company</th>
                        <th>Hobby</th>
                    </tr>
                    <xsl:for-each select="persons/person">
                        <tr>
                            <td><xsl:value-of select="firstName"/></td>
                            <td><xsl:value-of select="lastName"/></td>
                            <td><xsl:value-of select="company"/></td>
                            <td><xsl:value-of select="hobby"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
                <a href="/success?page=success&amp;pageNum=1">1</a>
                <a href="/success?page=success&amp;pageNum=2">2</a>
                <a href="/success?page=success&amp;pageNum=3">3;</a>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>