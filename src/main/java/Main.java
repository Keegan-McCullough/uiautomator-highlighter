import image.ImageAnnotator;
import model.Node;
import parser.XmlParser;

import java.io.*;
import java.util.*;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        String inputXml = "input/com.giphy.messenger-1.xml";
        String inputPng = "input/com.giphy.messenger-1.png";
        String outputPng = "output/com.giphy.messenger-1.png";
        System.out.println("hello world");

        // Parse XML into tree of UiNodes
        XmlParser parser = new XmlParser();
        Node root = parser.parse(inputXml);

        List<Node> leafNodes = root.getLeafNodes();
        System.out.println("Number of nodes:" + leafNodes.size());
        ImageAnnotator.annotate(inputPng, outputPng,leafNodes);
    }
}