package main.java.parser;

import main.java.model.Node;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParser{
    public Node parse(String xmlPath) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        Element root = doc.getDocumentElement();
        return parseNode(root);
    }

    private Node parseNode(Element element){
        Node node = new Node(
                element.getAttribute("class"),
                element.getAttribute("bounds")
        );

        NodeList children = element.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            org.w3c.dom.Node child = children.item(i);
            if (child instanceof Element) {
                node.addChild(parseNode((Element) child));
            }
        }
        return node;
    }
}