package view;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

import model.IShape;
import model.ISnapshot;

/**
 * The type Panel drawer.
 */
public class SnapshotRender extends JPanel {
  private ISnapshot snapshot;

  /**
   * Instantiates a new Panel drawer.
   *
   * @param snapshot the snapshot
   */
  public SnapshotRender(ISnapshot snapshot) {
    this.snapshot = snapshot;
  }


  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2D = (Graphics2D) g;
    super.paintComponent(g2D);
    // get the type of the shape
    Map<String, IShape> shapes = this.snapshot.getShapes();

    for (Map.Entry<String, IShape> shapeEntry : shapes.entrySet()) {
      IShape shape = shapeEntry.getValue();
      String type = shape.getType();
      // set the color of the shape
      g2D.setColor(new Color(shape.getColor().getRed(),
              shape.getColor().getGreen(),
              shape.getColor().getBlue())
      );

      // put the shape into panel
      switch (type.toUpperCase()) {
        case "RECTANGLE":
          g2D.fillRect(shape.getCenterPoint().getX(), shape.getCenterPoint().getY(),
                  shape.getSize().getWidth(), shape.getSize().getHeight());
          break;
        case "OVAL":
          g2D.fillOval(shape.getCenterPoint().getX(), shape.getCenterPoint().getY(),
                  shape.getSize().getWidth(), shape.getSize().getHeight());
          break;
      }
    }


  }

}
