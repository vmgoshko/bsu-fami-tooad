package by.bsu.fpmi.contactRegistration.dao.daoImpl;

import by.bsu.fpmi.contactRegistration.dao.PersonDao;
import by.bsu.fpmi.contactRegistration.model.Person;
import by.bsu.fpmi.contactRegistration.utils.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class PersonDaoImpl implements PersonDao {

    @Override
    public void save(Person person) {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        Document xmlStorage;

        try {

            docBuilder = docFactory.newDocumentBuilder();
            xmlStorage = docBuilder.parse(Configuration.xmlStorage);

            Element rootXml = xmlStorage.getDocumentElement();
            Element personElement = xmlStorage.createElement("person");

            Element fName = xmlStorage.createElement("firstName");
            fName.setTextContent(person.getFirstName());
            personElement.appendChild(fName);

            Element lName = xmlStorage.createElement("lastName");
            lName.setTextContent(person.getLastName());
            personElement.appendChild(lName);

            Element company = xmlStorage.createElement("company");
            company.setTextContent(person.getCompany());
            personElement.appendChild(company);

            Element hobby = xmlStorage.createElement("hobby");
            hobby.setTextContent(person.getHobby());
            personElement.appendChild(hobby);


            rootXml.appendChild(personElement);

            xmlStorage.getDocumentElement().normalize();
            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xmlStorage);
            StreamResult result = new StreamResult(new File(Configuration.xmlStorage));

            transformer.transform(source, result);

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

