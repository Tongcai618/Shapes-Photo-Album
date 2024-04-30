package model;

public class ShapeFactory {

  public static IShape createShape(String shapeType, String name,
                                   Point2D centerPoint, Size size, ShapeColor shapeColor) {
      switch (shapeType.toUpperCase()) {
        case "OVAL":
          return new Oval(name, centerPoint, size, shapeColor);
        case "RECTANGLE":
          return new Rectangle(name, centerPoint, size, shapeColor);
        default:
          throw new IllegalArgumentException("The album doesn't support this type.");
      }
  }
}
