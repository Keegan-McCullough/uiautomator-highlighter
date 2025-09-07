package main.java.image;

import main.java.model.Node;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.awt.*;

public class ImageAnnotator{
  public static void annotate(String inputPath, String outputPath, List<Node> nodes)  throws Exception{
      BufferedImage image = ImageIO.read(new File(inputPath));
      Graphics2D g = image.createGraphics();

      g.setColor(Color.YELLOW);
      // improving visibility with overlapping boxes by setting the stroke width and adding dashes
      float[] dashPattern = {1, 1};
      g.setStroke(new BasicStroke(
                8,
                      BasicStroke.CAP_BUTT,
                      BasicStroke.JOIN_BEVEL,
                      0,
                      dashPattern,
                      0));

      for (Node node : nodes){
          String ClassName = node.getClassName();
          // skip non-application nodes contained in the screenshots
          if (ClassName.startsWith("android.view")) {
              continue;
          }
          Rectangle rect = node.getBounds();
          if (rect != null){
              g.drawRect(rect.x, rect.y, rect.width, rect.height);
          }
      }

      g.dispose();
      ImageIO.write(image, "png", new File(outputPath));
  }
}