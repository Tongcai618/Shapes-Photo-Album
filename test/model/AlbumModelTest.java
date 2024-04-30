package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Model test.
 */
class AlbumModelTest {
  private IShape circle;
  private IShape square;
  private IShape oval;
  private IShape rectangle;
  private AlbumModel model;

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    circle = ShapeFactory.createShape("oval", "circle", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(100, 100, 100));
    square = ShapeFactory.createShape("rectangle", "square", new Point2D(0, 0),
            new Size(100, 100), new ShapeColor(100, 100, 100));
    oval = ShapeFactory.createShape("oVal", "oval", new Point2D(500, -500),
            new Size(200, 100), new ShapeColor(100, 100, 100));
    rectangle = ShapeFactory.createShape("rectangLe", "rectangle", new Point2D(300, 0),
            new Size(100, 200), new ShapeColor(200, 200, 200));

    model = new AlbumModel();
    model.addShape(circle);
    model.addShape(square);
    model.addShape(oval);
    model.addShape(rectangle);
  }

  /**
   * Test get shapes.
   */
  @Test
  void testGetShapes() {
    assertEquals(this.model.getShapes().size(), 4);
  }

  /**
   * Test get shape.
   */
  @Test
  void testGetShape() {
    assertEquals(this.model.getShape("circle"), circle);
  }

  /**
   * Test move.
   */
  @Test
  void testMove() {
    model.move("circle", 1000, 1000);
    assertEquals(this.model.getShape("circle").getCenterPoint(), new Point2D(1000,1000));
  }

  /**
   * Sets shape color.
   */
  @Test
  void setShapeColor() {
  model.setShapeColor("circle", 1, 1, 1);
  assertEquals(this.model.getShape("circle").getColor(), new ShapeColor(1, 1, 1));
  }

  /**
   * Test resize.
   */
  @Test
  void testResize() {
    model.resize("circle", 1, 1);
    assertEquals(this.model.getShape("circle").getSize(), new Size(1, 1));
  }

  /**
   * Test remove.
   */
  @Test
  void testRemove() {
    model.remove("circle");
    assertEquals(this.model.getShapes().size(), 3);
  }

  /**
   * Test take get snapshot.
   */
  @Test
  void testTakeGetSnapshot() {
    model.takeSnapshot("After add all shapes");
    assertEquals(model.getSnapshots().size(), 1);

    model.takeSnapshot("The second snapshot.");
    assertEquals(model.getSnapshots().size(), 2);
  }


  /**
   * Test reset.
   */
  @Test
  void testReset() {
    model.reset();
    assertEquals(model.getShapes(), new HashMap<>());
    assertEquals(model.getSnapshots(), new ArrayList<>());

  }
}