package image;

import model.Node;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.awt.*;

public class ImageAnnotator{
/*
off of the node object we need to get the rectangle
once retrieved from the leaf nodes we need to draw the rectangle on the png file
 */
  public static void annotate(String inputPath, String outputPath, List<Node> nodes)  throws Exception{
      BufferedImage image = ImageIO.read(new File(inputPath));
      Graphics2D g = image.createGraphics();

      g.setColor(Color.YELLOW);
      // setStroke helps visibility with overlapping boxes and add dashes
      float[] dashPattern = {1, 1};
      g.setStroke(new BasicStroke(
                8,
                      BasicStroke.CAP_BUTT,   // line cap
                      BasicStroke.JOIN_BEVEL, // line join
                      0,                      // miter limit
                      dashPattern,            // dash pattern
                      0));

      for (Node node : nodes){
          Rectangle rect = node.getBounds();
          if (rect != null){
              g.drawRect(rect.x, rect.y, rect.width, rect.height);
          }
      }

      g.dispose();
      ImageIO.write(image, "png", new File(outputPath));
  }
}