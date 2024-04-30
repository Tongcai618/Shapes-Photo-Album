package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Shape factory test.
 */
class ShapeFactoryTest {

  /**
   * The Rect.
   */
  IShape rect;
  /**
   * The Circle.
   */
  IShape circle;

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    rect = ShapeFactory.createShape("rectangle", "rect", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(0, 0, 0));
    circle = ShapeFactory.createShape("oval", "circle", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(0, 0, 0));
  }

  /**
   * Test create shape.
   */
  @Test
  void testCreateShape() {
    IShape otherRect = new Rectangle("rect", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(0, 0, 0));
    IShape otherCircle = new Oval("circle", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(0, 0, 0));
    assertEquals(rect, otherRect);
    assertEquals(circle, otherCircle);
  }

  /**
   * Test exceptions.
   */
  @Test
  void testExceptions() {
    assertThrows(IllegalArgumentException.class, () ->
            ShapeFactory.createShape("rectangl", "rect", new Point2D(0, 0),
                    new Size(100, 100), new ShapeColor(0, 0, 0)));

    assertThrows(IllegalArgumentException.class, () ->
            ShapeFactory.createShape("rectangle", "rect", new Point2D(0, 0),
                    new Size(-1, 100), new ShapeColor(0, 0, 0)));

    assertThrows(IllegalArgumentException.class, () ->
            ShapeFactory.createShape("rectangle", "rect", new Point2D(0, 0),
                    new Size(100, -1), new ShapeColor(0, 0, 0)));

    assertThrows(IllegalArgumentException.class, () ->
            ShapeFactory.createShape("rectangle", "rect", new Point2D(0, 0),
                    new Size(100, 100), new ShapeColor(-1, 0, 0)));

    assertThrows(IllegalArgumentException.class, () ->
            ShapeFactory.createShape("rectangle", "rect", new Point2D(0, 0),
                    new Size(100, 100), new ShapeColor(-256, 0, 0)));
  }
}