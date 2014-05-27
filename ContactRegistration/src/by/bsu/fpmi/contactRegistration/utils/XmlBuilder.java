package by.bsu.fpmi.contactRegistration.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class XmlBuilder {

    public static void build(String pageNumber) {
        int page = Integer.parseInt(pageNumber);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        Document xmlStorage = null;
        Document result = null;

        try {

            docBuilder = docFactory.newDocumentBuilder();
            xmlStorage = docBuilder.parse(Configuration.xmlStorage);
            result = docBuilder.newDocument();

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element rootXml = xmlStorage.getDocumentElement();

        Element pageDataRoot = result.createElement("persons");
        result.appendChild(pageDataRoot);

        NodeList persons = rootXml.getElementsByTagName("person");
        int from = page * 5 - 4;
        int to = 5 * page;
        for (int i = from; i <= to; i++) {
            Node node = result.importNode(persons.item(i), true);
            result.getDocumentElement().appendChild(node);
        }

        xmlStorage.getDocumentElement().normalize();

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        DOMSource source = new DOMSource(result);
        StreamResult out = new StreamResult(Configuration.pageData);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            transformer.transform(source, out);
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        System.out.println("XML file updated successfully");
    }
}
