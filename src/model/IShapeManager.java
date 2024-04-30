package model;

import java.util.Map;

/**
 * The interface Shape manager.
 */
public interface IShapeManager {
  /**
   * Add shape.
   *
   * @param shape the shape
   */
  void addShape(IShape shape);

  /**
   * Gets shape.
   *
   * @param ID the id
   * @return the shape
   */
  IShape getShape(String ID);

  /**
   * Gets shapes.
   *
   * @return the shapes
   */
  Map<String, IShape> getShapes();

  /**
   * Remove.
   *
   * @param ID the id
   */
  void remove(String ID);
}
