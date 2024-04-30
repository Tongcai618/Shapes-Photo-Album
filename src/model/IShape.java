package model;

/**
 * The interface Shape.
 */
public interface IShape {
  /**
   * Gets name.
   *
   * @return the name
   */
  String getName();

  /**
   * Gets type.
   *
   * @return the type
   */
  String getType();

  /**
   * Gets center point.
   *
   * @return the center point
   */
  Point2D getCenterPoint();

  /**
   * Sets center point.
   *
   * @param x the x
   * @param y the y
   */
  void setCenterPoint(int x, int y);

  /**
   * Gets size.
   *
   * @return the size
   */
  Size getSize();

  /**
   * Sets size.
   *
   * @param width  the width
   * @param height the height
   */
  void setSize(int width, int height);

  /**
   * Gets color.
   *
   * @return the color
   */
  ShapeColor getColor();

  /**
   * Sets color.
   *
   * @param red   the red
   * @param blue  the blue
   * @param green the green
   */
  void setColor(int red, int blue, int green);

  String toString();

  /**
   * Clone the shape.
   *
   * @return the shape
   */
  IShape cloneShape();

  /**
   * Equals boolean.
   *
   * @return the boolean
   */

}
