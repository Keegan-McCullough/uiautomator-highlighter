package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Node {
    /*
    need to create the nodes that hold text its children and
    the rectangle to be highlighted
     */
    private String className;
    private String text;
    private Rectangle bounds;
    private List<Node> children;

    public Node(String className, String text, String boundary) {
        this.className = className;
        this.text = text;
        //this.bounds = parseBounds(boundsStr);
        this.children = new ArrayList<>();
    }
}