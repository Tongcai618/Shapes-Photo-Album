package model;

import java.util.AbstractMap;
import java.util.List;

/**
 * The interface Snapshot manager.
 */
public interface ISnapshotManager {

  /**
   * Take snapshot.
   *
   * @param description the description
   */
  void takeSnapshot(String description);

  /**
   * Gets snapshots.
   *
   * @return the snapshots
   */
  List<AbstractMap.SimpleEntry<String, ISnapshot>> getSnapshots();

//  AbstractMap.SimpleEntry<String, ISnapshot> getSnapshot(String name);
}
