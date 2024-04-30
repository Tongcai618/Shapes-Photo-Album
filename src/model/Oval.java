package model;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {

  /**
   * Instantiates a new Oval.
   *
   * @param name        the name
   * @param centerPoint the center point
   * @param size        the size
   * @param shapeColor  the color
   */
  public Oval(String name, Point2D centerPoint, Size size, ShapeColor shapeColor) {
    super(name, centerPoint, size, shapeColor, "Oval");
  }

  @Override
  public IShape cloneShape() {
    return new Oval(super.getName(), super.getCenterPoint(), super.getSize(), super.getColor());
  }


  @Override
  public String toString() {
    return String.format("Name: %s\nType: %s\nCenter:"
                    + " (%d,%d) X radius: %d, Y radius: %d, Color: (%d,%d,%d)\n",
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
