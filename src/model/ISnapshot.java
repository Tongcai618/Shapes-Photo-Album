package model;

import java.util.Map;

/**
 * The interface Snapshot.
 */
public interface ISnapshot {
  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();
  Map<String, IShape> getShapes();
  String toString();

}
