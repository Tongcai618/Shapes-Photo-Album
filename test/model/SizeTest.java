package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Size test.
 */
class SizeTest {
  private Size size;

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    size = new Size(100, 200);
  }

  /**
   * Test exception.
   */
  @Test
  void testException() {
    assertThrows(IllegalArgumentException.class, () ->
            new Size(0, 100));
    assertThrows(IllegalArgumentException.class, () ->
            new Size(10, 0));
    assertThrows(IllegalArgumentException.class, () ->
            new Size(-1, 20));
    assertThrows(IllegalArgumentException.class, () ->
            new Size(20, -1));
  }

  /**
   * Test set width.
   */
  @Test
  void testSetWidth() {
    size.setWidth(100);
    assertEquals(size.getWidth(), 100);
    assertThrows(IllegalArgumentException.class, () ->
            size.setWidth(-1));

  }

  /**
   * Test set height.
   */
  @Test
  void testSetHeight() {
    size.setHeight(100);
    assertEquals(size.getHeight(), 100);
    assertThrows(IllegalArgumentException.class, () ->
            size.setHeight(-1));
  }
}