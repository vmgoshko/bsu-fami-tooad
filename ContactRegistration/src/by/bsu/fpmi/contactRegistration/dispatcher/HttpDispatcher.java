package by.bsu.fpmi.contactRegistration.dispatcher;


import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.utils.ModelBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

public class HttpDispatcher extends Dispatcher {

    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, TransformerException {
        Map<String, Object> model = ModelBuilder.build(request);

        super.invoke(model);

        printPage(request, response, (String) model.get("page"), (Person) model.get("person"));
    }

    private void printPage(HttpServletRequest request, HttpServletResponse response, String page, Person person) throws IOException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(request.getServletContext().getRealPath("/WEB-INF/xslt/" + page + ".xsl"));
        Transformer transformer = factory.newTransformer(xslStream);
        StreamResult out = new StreamResult(response.getOutputStream());
        StreamSource in = new StreamSource(new StringReader(buildData(person)));
        transformer.transform(in, out);
    }

    private String buildData(Person person) {
        return "<person> <firstName>" + person.getFirstName() + "</firstName><lastName>" + person.getLastName() + "</lastName><company>" + person.getCompany() + "</company><hobby>" + person.getHobby() + "</hobby></person>";
    }
}
