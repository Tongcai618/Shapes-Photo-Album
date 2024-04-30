package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Snapshot.
 */
public class Snapshot implements ISnapshot{
  private String time;
  private String description;
  private Map<String, IShape> shapes;

  /**
   * Instantiates a new Snapshot.
   *
   * @param description the description
   * @param shapes      the shapes
   * @param time        the time
   */
  public Snapshot(String description, Map<String, IShape> shapes, String time) {

    this.time = time;
    this.description = description;
    this.shapes = shapes;
  }

  @Override
  public String getDescription() {
    return description;
  }

  @Override
  public Map<String, IShape> getShapes() {
    Map<String, IShape> newMap = new LinkedHashMap<>();
    for (Map.Entry<String, IShape> entry : this.shapes.entrySet()) {
      newMap.put(entry.getKey(), entry.getValue().cloneShape());
    }
    return newMap;
  }
  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Timestamp: " + this.time + "\n");
    stringBuilder.append("Description: " + this.description + "\n\n");
    stringBuilder.append("Shape Information: \n");
    for (Map.Entry<String, IShape> entry: this.shapes.entrySet()) {
      stringBuilder.append(entry.getValue());
      stringBuilder.append("\n");
    }

    return stringBuilder.toString();
  }
}
