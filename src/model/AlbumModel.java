package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Model.
 */
public class AlbumModel implements IShapeManipulator, IShapeManager, ISnapshotManager {

  private Map<String, IShape> shapes;
  private List<SimpleEntry<String, ISnapshot>> snapshotList;

  /**
   * Instantiates a new Model.
   */
  public AlbumModel() {
    this.shapes = new LinkedHashMap<>();
    this.snapshotList = new ArrayList<>();
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
  public IShape getShape(String ID) {
    return this.shapes.get(ID).cloneShape();
  }

  @Override
  public void addShape(IShape shape) {
    this.shapes.put(shape.getName(), shape);
  }

  @Override
  public void move(String ID, int x, int y)
          throws IllegalArgumentException {
    if (!this.shapes.containsKey(ID)) {
      // if the shape does not in the map
      throw new IllegalArgumentException("Cannot move. This shape doesn't exist.");
    }
    // set the center point/min corner point
    this.shapes.get(ID).setCenterPoint(x, y);
  }

  @Override
  public void setShapeColor(String ID, int red, int green, int blue)
          throws IllegalArgumentException {
    if (!this.shapes.containsKey(ID)) {
      // if the shape does not in the map
      throw new IllegalArgumentException("Cannot set color. This shape doesn't exist.");
    }
    this.shapes.get(ID).setColor(red, blue, green);
  }

  @Override
  public void resize(String ID, int width, int height)
          throws IllegalArgumentException {
    if (!this.shapes.containsKey(ID)) {
      // if the shape does not in the map
      throw new IllegalArgumentException("Cannot resize. This shape doesn't exist.");
    }
    this.shapes.get(ID).setSize(width, height);
  }

  @Override
  public void remove(String ID) throws IllegalArgumentException {
    if (!this.shapes.containsKey(ID)) {
      // if the shape does not in the map
      throw new IllegalArgumentException("Cannot remove. This shape doesn't exist.");
    }
    this.shapes.remove(ID);
  }

  @Override
  public void takeSnapshot(String description) {
    DateTimeFormatter dateTimeFormatterID = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSS");
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    // get the ID based on the time
    String ID = dateTimeFormatterID.format(now);
    // generate the snapshot based on time
    ISnapshot snapshot = new Snapshot(description, this.getShapes(), dateTimeFormatter.format(now));
    SimpleEntry<String, ISnapshot> entry = new SimpleEntry<>(ID, snapshot);
    snapshotList.add(entry);
  }

  @Override
  public List<SimpleEntry<String, ISnapshot>> getSnapshots() {
    List<SimpleEntry<String, ISnapshot>> newSnapshot = new ArrayList<>();
    for (int i = 0; i < this.snapshotList.size(); i += 1) {
      newSnapshot.add(snapshotList.get(i));
    }
    return newSnapshot;
  }

//  @Override
//  public SimpleEntry<String, ISnapshot> getSnapshot(String name) {
//    for (int i = 0; i < this.snapshotList.size(); i += 1) {
//      if (this.snapshotList.get(i).getKey().equals(name)) {
//        return this.snapshotList.get(i);
//      }
//    }
//    return null;
//  }

  /**
   * Reset the model.
   * <p>
   * This method will clear the shapes, and the snapshotList.
   */
  public void reset() {
    shapes = new HashMap<>();
    snapshotList = new ArrayList<>();
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (Map.Entry<String, IShape> entry : this.shapes.entrySet()) {
      stringBuilder.append(entry.getValue().toString());
      stringBuilder.append("\n");
    }

    return stringBuilder.toString();
  }
}
