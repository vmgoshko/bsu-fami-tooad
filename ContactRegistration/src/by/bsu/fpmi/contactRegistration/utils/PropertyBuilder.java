package by.bsu.fpmi.contactRegistration.utils;

import by.bsu.fpmi.contactRegistration.model.Person;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class PropertyBuilder {

    public static void savePerson(HttpServletRequest request,Person person) throws ParserConfigurationException, IOException, SAXException {
        String filePath = request.getServletContext().getRealPath("/WEB-INF/xml/database.xml");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(filePath);

        Element root = doc.getDocumentElement();

        Element personElement = doc.createElement("person");

        Node firstNameElement = doc.createElement("firstName");
        firstNameElement.appendChild(doc.createTextNode(person.getFirstName()));
        personElement.appendChild(firstNameElement);

        Node lastNameElement = doc.createElement("lastName");
        lastNameElement.appendChild(doc.createTextNode(person.getLastName()));
        personElement.appendChild(lastNameElement);

        Node companyElement = doc.createElement("company");
        companyElement.appendChild(doc.createTextNode(person.getCompany()));
        personElement.appendChild(companyElement);

        Node hobbyElement = doc.createElement("hobby");
        hobbyElement.appendChild(doc.createTextNode(person.getHobby()));
        personElement.appendChild(hobbyElement);

        root.appendChild(personElement);
    }

}
