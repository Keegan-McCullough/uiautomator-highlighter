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
        this.bounds = parseBounds(boundary);
        this.children = new ArrayList<>();
    }

    public Rectangle getBounds(){
        return bounds;
    }
    public boolean isLeaf(){
        return children.isEmpty();
    }
    public void addChild(Node child){
        children.add(child);
    }

    public List<Node> getLeafNodes() {
        List<Node> leaves = new ArrayList<>();
        if (isLeaf()){
            leaves.add(this);
        } else{
            for (Node child : children){
                leaves.addAll(child.getLeafNodes());
            }
        }
        return leaves;
    }

    private Rectangle parseBounds(String boundsStr) {
        // Format: [x1,y1][x2,y2]
        boundsStr = boundsStr.replace("[", "").replace("]", ",");
        String[] parts = boundsStr.split(",");
        if (parts.length >= 4) {
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);
            int x2 = Integer.parseInt(parts[2]);
            int y2 = Integer.parseInt(parts[3]);
            return new Rectangle(x1, y1, x2 - x1, y2 - y1);
        }
        return null;
    }
}