package model;

/**
 * The interface Operate shape.
 */
public interface IShapeManipulator {


  /**
   * Moves the IShapes's center point.
   *
   * @param ID the id
   * @param x  the x
   * @param y  the y
   */
  void move(String ID, int x, int y);

  /**
   * Sets an IShape's color based on its ID.
   *
   * @param ID    the id
   * @param red   the red
   * @param green the green
   * @param blue  the blue
   */
  void setShapeColor(String ID, int red, int green, int blue);

  /**
   * Resize an IShape based on its ID.
   *
   * @param ID     the id
   * @param width  the width
   * @param height the height
   */
  void resize(String ID, int width, int height);

  /**
   * Remove an IShape based on its ID.
   *
   * @param ID the id
   */
  void remove(String ID);

  /**
   * Take snapshot.
   *
   * @param description the description
   */
}
