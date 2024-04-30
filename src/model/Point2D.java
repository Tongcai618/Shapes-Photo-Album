package model;

import java.util.Objects;

/**
 * The type Point 2 d.
 */
public class Point2D {
  private int x;
  private int y;

  /**
   * Instantiates a new Point 2 d.
   *
   * @param x the x
   * @param y the y
   */
  public Point2D(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets x.
   *
   * @return the x
   */
  public int getX() {
    return x;
  }

  /**
   * Sets x.
   *
   * @param x the x
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Gets y.
   *
   * @return the y
   */
  public int getY() {
    return y;
  }

  /**
   * Sets y.
   *
   * @param y the y
   */
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Point2D point2D = (Point2D) o;
    return Double.compare(x, point2D.x) == 0 && Double.compare(y, point2D.y) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }
}
