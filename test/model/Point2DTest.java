package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Point 2 d test.
 */
class Point2DTest {
  private Point2D point;

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    point = new Point2D(100, 200);
  }

  /**
   * Test set x.
   */
  @Test
  void testSetX() {
    point.setX(300);
    assertEquals(point.getX(), 300);
  }

  /**
   * Test set y.
   */
  @Test
  void testSetY() {
    point.setY(300);
    assertEquals(point.getY(), 300);
  }
}