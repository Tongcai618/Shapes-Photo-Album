package model;

import java.util.Objects;

/**
 * The type Color.
 */
public class ShapeColor {
  private int red;
  private int blue;
  private int green;

  /**
   * Instantiates a new Color.
   *
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   * @throws IllegalArgumentException the illegal argument exception
   */
  public ShapeColor(int red, int green, int blue) throws IllegalArgumentException {
    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Red cannot be out of [0, 255]");
    }
    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Green cannot be out of [0, 255]");
    }
    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Blue cannot be out of [0, 255]");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Gets red.
   *
   * @return the red
   */
  public int getRed() {
    return red;
  }

  /**
   * Sets red.
   *
   * @param red the red
   */
  public void setRed(int red) {
    if (red < 0 || red > 255) {
      throw new IllegalArgumentException("Red cannot be out of [0, 255]");
    }
    this.red = red;
  }

  /**
   * Gets green.
   *
   * @return the green
   */
  public int getGreen() {
    return green;
  }

  /**
   * Sets green.
   *
   * @param green the green
   */
  public void setGreen(int green) {
    if (green < 0 || green > 255) {
      throw new IllegalArgumentException("Green cannot be out of [0, 255]");
    }
    this.green = green;
  }

  /**
   * Gets blue.
   *
   * @return the blue
   */
  public int getBlue() {
    return blue;
  }

  /**
   * Sets blue.
   *
   * @param blue the blue
   */
  public void setBlue(int blue) {
    if (blue < 0 || blue > 255) {
      throw new IllegalArgumentException("Blue cannot be out of [0, 255]");
    }
    this.blue = blue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ShapeColor shapeColor = (ShapeColor) o;
    return red == shapeColor.red && blue == shapeColor.blue && green == shapeColor.green;
  }

  @Override
  public int hashCode() {
    return Objects.hash(red, blue, green);
  }
}
