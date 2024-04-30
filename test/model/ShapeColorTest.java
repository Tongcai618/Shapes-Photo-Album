package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Shape color test.
 */
class ShapeColorTest {
  private ShapeColor shapeColor;

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    shapeColor = new ShapeColor(0, 0, 0);
  }

  /**
   * Test set red.
   */
  @Test
  void testSetRed() {
    shapeColor.setRed(100);
    assertEquals(shapeColor.getRed(), 100);

    assertThrows(IllegalArgumentException.class, () -> shapeColor.setRed(-1));
    assertThrows(IllegalArgumentException.class, () -> shapeColor.setRed(256));
  }

  /**
   * Test set green.
   */
  @Test
  void testSetGreen() {
    shapeColor.setGreen(100);
    assertEquals(shapeColor.getGreen(), 100);

    assertThrows(IllegalArgumentException.class, () -> shapeColor.setGreen(-1));
    assertThrows(IllegalArgumentException.class, () -> shapeColor.setGreen(256));
  }

  /**
   * Test set blue.
   */
  @Test
  void testSetBlue() {
    shapeColor.setBlue(100);
    assertEquals(shapeColor.getBlue(), 100);

    assertThrows(IllegalArgumentException.class, () -> shapeColor.setBlue(-1));
    assertThrows(IllegalArgumentException.class, () -> shapeColor.setBlue(256));
  }
}