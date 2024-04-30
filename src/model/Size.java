package model;

import java.util.Objects;

/**
 * The type Size.
 */
public class Size {
  private int width;
  private int height;

  /**
   * Instantiates a new Size.
   *
   * @param width  the width
   * @param height the height
   */
  public Size(int width, int height) throws IllegalArgumentException{
    if (width <= 0 || height <= 0) {
      throw new IllegalArgumentException();
    }
    this.width = width;
    this.height = height;
  }

  /**
   * Gets width.
   *
   * @return the width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Sets width.
   *
   * @param width the width
   */
  public void setWidth(int width) throws IllegalArgumentException {
    if (width <= 0) {
      throw new IllegalArgumentException();
    }
    this.width = width;
  }

  /**
   * Gets height.
   *
   * @return the height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Sets height.
   *
   * @param height the height
   */
  public void setHeight(int height) throws IllegalArgumentException {
    if (height <= 0) {
      throw new IllegalArgumentException();
    }
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Size size = (Size) o;
    return Double.compare(width, size.width) == 0 && Double.compare(height, size.height) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(width, height);
  }
}
