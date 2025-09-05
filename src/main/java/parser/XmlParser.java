package parser;

import model.Node;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParser{
    /* need to parse the xml files into the nodes that have
    no other information contained in it and make this into a linked list
     */
    public Node parse(String xmlPath) throws Exception {
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(new File(xmlPath));
        doc.getDocumentElement().normalize();

        Element root = doc.getDocumentElement();
        return parseNode(root);
    }

    private Node parseNode(Element root){
        Node node = new Node(
                root.getAttribute("class"),
                root.getAttribute("text"),
                root.getAttribute("bounds")
        );

        NodeList children = root.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            org.w3c.dom.Node child = children.item(i);
            if (child instanceof Element) {
                node.addChild(parseNode((Element) child));
            }
        }
        return node;
    }
}