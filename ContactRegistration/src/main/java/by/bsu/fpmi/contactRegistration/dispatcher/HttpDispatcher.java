package by.bsu.fpmi.contactRegistration.dispatcher;

import by.bsu.fpmi.contactRegistration.exception.RoleAccessException;
import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.utils.Configuration;
import by.bsu.fpmi.contactRegistration.utils.ModelBuilder;
import by.bsu.fpmi.contactRegistration.utils.PropertyBuilder;
import by.bsu.fpmi.contactRegistration.utils.XmlBuilder;

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

    private Map<String, Object> model;

    public void dispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        model = ModelBuilder.build(request);
        PropertyBuilder.build(request);

        try{
            if (model.get("action") != null) {
                super.invoke(model);
            }
        } catch (RoleAccessException e) {
            response.sendRedirect("");
        }
        printPage(response);
    }

    private void printPage(HttpServletResponse response) throws IOException, TransformerException {
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(Configuration.contextPath + "\\WEB-INF\\xslt\\" + model.get("page") + ".xsl");
        Transformer transformer = factory.newTransformer(xslStream);
        StreamResult out = new StreamResult(response.getOutputStream());
        StreamSource in;
        if (model.get("page").equals("success")) {
            XmlBuilder.build((String) model.get("pageNum"));
            in = new StreamSource(Configuration.pageData);
        } else {
            in = new StreamSource(new StringReader(buildData((Person) model.get("person"))));
        }

        transformer.transform(in, out);
    }

    private String buildData(Person person) {
        return "<person>" +
                "<firstName>" + person.getFirstName() + "</firstName>" +
                "<lastName>" + person.getLastName() + "</lastName>" +
                "<company>" + person.getCompany() + "</company>" +
                "<hobby>" + person.getHobby() + "</hobby>" +
                "</person>";
    }
}
