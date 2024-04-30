package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractShapeTest {
  IShape rect;
  /**
   * The Circle.
   */
  IShape circle;

  @BeforeEach
  void setUp() {
    rect = new Rectangle("rect", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(0, 0, 0));
    circle = new Oval("circle", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(0, 0, 0));
  }

  @Test
  void setCenterPoint() {
    rect.setCenterPoint(200, 200);
    assertEquals(rect.getCenterPoint(), new Point2D(200,200));

    circle.setCenterPoint(200, 200);
    assertEquals(circle.getCenterPoint(), new Point2D(200,200));
  }

  @Test
  void setSize() {
    rect.setSize(300, 300);
    assertEquals(rect.getSize(), new Size(300, 300));

    circle.setSize(300, 300);
    assertEquals(circle.getSize(), new Size(300, 300));
  }

  @Test
  void setColor() {
    rect.setColor(3,3,3);
    assertEquals(rect.getColor(), new ShapeColor(3,3,3));

    circle.setColor(3,3,3);
    assertEquals(circle.getColor(), new ShapeColor(3,3,3));
  }
  @Test
  void testGetType() {
    assertEquals(rect.getType().toLowerCase(), "rectangle");
    assertEquals(circle.getType().toLowerCase(), "oval");

  }
}