package model;

import java.util.Objects;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
  private String name;
  private Point2D centerPoint;
  private Size size;
  private ShapeColor color;
  private final String type;

  /**
   * Instantiates a new Abstract shape.
   *
   * @param name        the name
   * @param centerPoint the center point
   * @param size        the size
   * @param color       the color
   * @param type        the type
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractShape(String name, Point2D centerPoint, Size size, ShapeColor color, String type)
          throws IllegalArgumentException {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("Name must not be null or empty.");
    }
    this.name = name;
    this.centerPoint = centerPoint;
    this.size = size;
    this.color = color;
    this.type = type;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Point2D getCenterPoint() {
    return new Point2D(this.centerPoint.getX(), this.centerPoint.getY());
  }

  @Override
  public void setCenterPoint(int x, int y) {
    this.centerPoint.setX(x);
    this.centerPoint.setY(y);
  }

  @Override
  public Size getSize() {
    return new Size(this.size.getWidth(), this.size.getHeight());
  }

  @Override
  public void setSize(int width, int height) {
    this.size.setWidth(width);
    this.size.setHeight(height);
  }

  @Override
  public ShapeColor getColor() {
    return new ShapeColor(this.color.getRed(), this.color.getGreen(), this.color.getBlue());
  }

  @Override
  public void setColor(int red, int blue, int green) {
    this.color.setRed(red);
    this.color.setGreen(green);
    this.color.setBlue(blue);
  }

  @Override
  public String getType() {
    return this.type;
  }


  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractShape that = (AbstractShape) o;
    return Objects.equals(name, that.name)
            && Objects.equals(centerPoint, that.centerPoint)
            && Objects.equals(size, that.size)
            && Objects.equals(color, that.color)
            && Objects.equals(type, that.type);
  }

  public int hashCode() {
    return Objects.hash(name, centerPoint, size, color, type);
  }
}
