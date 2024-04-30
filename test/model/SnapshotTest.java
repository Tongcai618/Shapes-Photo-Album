package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnapshotTest {
  private IShape circle;
  private IShape square;
  private IShape oval;
  private IShape rectangle;
  private AlbumModel model;
  private ISnapshot snapshot;
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
    model.takeSnapshot("first snapshot");
    snapshot = model.getSnapshots().getLast().getValue();

  }

  @Test
  void testGetDescription() {
    assertEquals(snapshot.getDescription(), "first snapshot");
  }

  @Test
  void testGetShapes() {
    assertEquals(snapshot.getShapes().size(), 4);
  }
}