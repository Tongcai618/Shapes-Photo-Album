package controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.AlbumModel;
import model.IShape;
import model.Point2D;
import model.ShapeFactory;
import model.Size;
import model.ShapeColor;

/**
 * The type Command reader.
 */
public class CommandReader {

  /**
   * Executes the commands based on each line's content.
   *
   * @param albumModel The album model.
   * @param lineArray  A list line from the text.
   */

  private static void execute(AlbumModel albumModel, List<String> lineArray) {
    // if the command is shape, create an IShape
    if (lineArray.get(0).equalsIgnoreCase("shape")) {
      String name = lineArray.get(1);
      String type = lineArray.get(2);
      Point2D centerPoint = new Point2D(Integer.parseInt(lineArray.get(3)),
              Integer.parseInt(lineArray.get(4)));
      Size size = new Size(Integer.parseInt(lineArray.get(5)), Integer.parseInt(lineArray.get(6)));
      ShapeColor shapeColor = new ShapeColor(Integer.parseInt(lineArray.get(7)),
              Integer.parseInt(lineArray.get(8)),
              Integer.parseInt(lineArray.get(9)));
      IShape shape = ShapeFactory.createShape(type, name, centerPoint, size, shapeColor);

      // add shape to the model
      albumModel.addShape(shape);
    } else if (lineArray.get(0).equalsIgnoreCase("snapshot")) {
      // if the command is snapshot, take a snapshot
      // if the snapshot line's size is larger than 1, we have description
      lineArray.remove(0);
      String description = lineArray.size() > 1? String.join(" ", lineArray) : "";
      albumModel.takeSnapshot(description);
    } else if (lineArray.get(0).equalsIgnoreCase("move")) {
      // if the command is move, move a shape
      if (lineArray.size() != 4) {
        return;
      }
      String name = lineArray.get(1);
      int newX = Integer.parseInt(lineArray.get(2));
      int newY = Integer.parseInt(lineArray.get(3));
      albumModel.move(name, newX, newY);
    } else if (lineArray.get(0).equalsIgnoreCase("resize")) {
      // if the command is resize, resize a shape
      if (lineArray.size() != 4) {
        return;
      }
      String name = lineArray.get(1);
      int newWidth = Integer.parseInt(lineArray.get(2));
      int newHeight = Integer.parseInt(lineArray.get(3));
      albumModel.resize(name, newWidth, newHeight);
    } else if (lineArray.get(0).equalsIgnoreCase("color")) {
      // if the command is color, set the color of a shape
      if (lineArray.size() != 5) {
        return;
      }
      String name = lineArray.get(1);
      int newR = Integer.parseInt(lineArray.get(2));
      int newG = Integer.parseInt(lineArray.get(3));
      int newB = Integer.parseInt(lineArray.get(3));
      albumModel.setShapeColor(name, newR, newG, newB);
    } else if (lineArray.get(0).equalsIgnoreCase("remove")) {
      // if the command is remove, remove a shape
      if (lineArray.size() != 2) {
        return;
      }
      String name = lineArray.get(1);
      albumModel.remove(name);
    }

  }

  /**
   * Read and execute command.
   *
   * @param albumModel   the album model
   * @param resourcePath the resource path
   */
  public static void readAndExecuteCommand(AlbumModel albumModel, String resourcePath) {
    try {
      List<String> allLines = Files.readAllLines(Paths.get(resourcePath));
      for (String line : allLines) {
        // convert each line into a list
        if (!line.isEmpty()) {
          // we don't read the empty line
          List<String> lineArray = Arrays.stream(line.split(" ")).toList()
                  .stream().filter((s -> !s.isEmpty())).collect(Collectors.toList());
          if (!lineArray.get(0).equals("#")) {
            execute(albumModel, lineArray);
          }
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
