package view;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.Map;

import model.AlbumModel;
import model.IShape;
import model.ISnapshot;

/**
 * The type Html controller.
 */
public class HtmlViewer{
  private AlbumModel albumModel;
  private String htmlContent;
  private int width;
  private int height;

  /**
   * Instantiates a new Html controller.
   *
   * @param albumModel the album model
   * @param width      the width
   * @param height     the height
   */
  public HtmlViewer(AlbumModel albumModel, int width, int height) {
    this.albumModel = albumModel;
    this.width = width;
    this.height = height;
    htmlContent = "<!DOCTYPE html>"
            + "<html>"
            + "<head><title>Album</title></head>"
            + "<body>"
            + drawAllSnapshots()
            + "</body>"
            + "</html>";

  }

  /**
   * Draw all snapshots string.
   *
   * @return the string
   */
  private String drawAllSnapshots() {
    StringBuilder stringBuilder = new StringBuilder();
    List<SimpleEntry<String, ISnapshot>> snapshotEntriesList = albumModel.getSnapshots();

    for (int i = snapshotEntriesList.size() - 1; i >= 0; i--) {
      stringBuilder.append("<h1>");
      stringBuilder.append(snapshotEntriesList.get(i).getKey());
      stringBuilder.append("</h1>");
      stringBuilder.append("<h2>");
      stringBuilder.append(snapshotEntriesList.get(i).getValue().getDescription());
      stringBuilder.append("</h2>");
      stringBuilder.append(String.format("<svg width='%d' height='%d'>", this.width, this.height));
      stringBuilder.append(drawSnapshot(snapshotEntriesList.get(i)));
      stringBuilder.append("</svg>");
    }

    return stringBuilder.toString();
  }

  /**
   * Draw snapshot string.
   *
   * @param snapshotEntry the snapshot entry
   * @return the string
   */
  private String drawSnapshot(SimpleEntry<String, ISnapshot> snapshotEntry) {
    StringBuilder stringBuilder = new StringBuilder();
    ISnapshot snapshot = snapshotEntry.getValue();
    for (Map.Entry<String, IShape> shapeEntry : snapshot.getShapes().entrySet()) {
      stringBuilder.append(drawShape(shapeEntry.getValue())).append("\n");
    }
    return stringBuilder.toString();
  }

  private String drawShape(IShape shape) {
    String type = shape.getType();
    String result;
    switch (type.toLowerCase()) {
      case "oval":
        result = String.format("<ellipse cx='%d' cy='%d' rx='%d' ry='%d' fill='rgb(%d,%d,%d)' />",
                shape.getCenterPoint().getX(), shape.getCenterPoint().getY(),
                shape.getSize().getWidth(), shape.getSize().getHeight(),
                shape.getColor().getRed(), shape.getColor().getGreen(), shape.getColor().getBlue());
        break;
      case "rectangle":
        result = String.format("<rect x='%d' y='%d' width='%d' height='%d' fill='rgb(%d,%d,%d)' />",
                shape.getCenterPoint().getX(), shape.getCenterPoint().getY(),
                shape.getSize().getWidth(), shape.getSize().getHeight(),
                shape.getColor().getRed(), shape.getColor().getGreen(), shape.getColor().getBlue());
        break;
      default:
        result = "";
    }
    return result;
  }

  /**
   * Save html to file.
   *
   * @param filePath the file path
   */
  public void saveHtmlToFile(String filePath) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      writer.write(htmlContent);
    } catch (IOException e) {
      System.err.println("Error writing the file: " + e.getMessage());
    }
  }

  /**
   * Save html to file.
   */
  public void openHtmlToFile() {
    File htmlFile = new File("web.html");

    // save the html to file
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile))) {
      writer.write(htmlContent);
    } catch (IOException e) {
      e.printStackTrace();
    }
    // open the file using default browser
    if (Desktop.isDesktopSupported()) {
      try {
        Desktop.getDesktop().open(htmlFile);
      } catch (IOException e) {
        System.err.println("Failed to open the file.");
        e.printStackTrace();
      }
    } else {
      System.out.println("Desktop is not supported.");
    }
    // delete the file
    htmlFile.delete();
  }
}
