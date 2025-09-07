import image.ImageAnnotator;
import model.Node;
import parser.XmlParser;

import java.io.*;
import java.util.*;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        // Initialize helpers
        XmlParser parser = new XmlParser();

        // Get all files in input
        File dir = new File("input");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".xml"));

        if (files == null) {
            System.out.println("No input files found.");
            return;
        }

        // For every XML file, find matching PNG and process
        for (File xmlFile : files) {
            String baseName = xmlFile.getName().replace(".xml", "");
            String inputXml = "input/" + baseName + ".xml";
            String inputPng = "input/" + baseName + ".png";
            String outputPng = "output/" + baseName + ".png";

            // Parse XML into node tree
            Node root = parser.parse(inputXml);
            List<Node> leafNodes = root.getLeafNodes();

            System.out.println(inputXml);
            ImageAnnotator.annotate(inputPng, outputPng, leafNodes);
        }
    }
}