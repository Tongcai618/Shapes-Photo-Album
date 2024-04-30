package model;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {

  /**
   * Instantiates a new Rectangle.
   *
   * @param name        the name
   * @param centerPoint the center point
   * @param size        the size
   * @param shapeColor       the color
   */
  public Rectangle(String name, Point2D centerPoint, Size size, ShapeColor shapeColor) {
    super(name, centerPoint, size, shapeColor, "Rectangle");
  }

  @Override
  public IShape cloneShape() {
    return new Rectangle(super.getName(), super.getCenterPoint(), super.getSize(), super.getColor());
  }

  @Override
  public String toString() {
    return String.format("Name: %s\nType: %s\nMin corner:"
                    + " (%d,%d) Width: %d, Height: %d, Color: (%d,%d,%d)\n",
            super.getName(),
            this.getType(),
            super.getCenterPoint().getX(),
            super.getCenterPoint().getY(),
            super.getSize().getWidth(),
            super.getSize().getHeight(),
            super.getColor().getRed(),
            super.getColor().getGreen(),
            super.getColor().getBlue());
  }
}
