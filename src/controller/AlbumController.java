package controller;

import java.util.HashMap;
import java.util.Map;

import model.AlbumModel;
import view.AlbumViewer;
import view.HtmlViewer;

/**
 * The type Album controller.
 */
public class AlbumController {
  private int width;
  private int height;
  private AlbumModel albumModel;
  private AlbumViewer albumViewer;
  /**
   * The Arguments map.
   */
  Map<String, String> argumentsMap;

  /**
   * Instantiates a new Album controller.
   *
   * @param args the args
   */
  public AlbumController(String[] args) {
    argumentsMap = parseArgs(args);
    albumModel = new AlbumModel();

    // get the input file
    CommandReader.readAndExecuteCommand(albumModel, argumentsMap.get("-in"));

    // if the width and height were set.
    if (argumentsMap.containsKey("width") && argumentsMap.containsKey("height")) {
      width = Integer.parseInt(argumentsMap.get("width"));
      height = Integer.parseInt(argumentsMap.get("height"));
    } else {
      width = 1000;
      height = 1000;
    }
    albumViewer = new AlbumViewer(albumModel, width, height);
    // if the -out exists, we just output the html file
    if (argumentsMap.containsKey("-out")) {
      HtmlViewer htmlViewer = new HtmlViewer(albumModel, width, height);
      htmlViewer.saveHtmlToFile(argumentsMap.get("-out"));
    }

    // handle the view
    String viewType = getViewType(argumentsMap);
    if ("web".equals(viewType)) {
      HtmlViewer htmlViewer = new HtmlViewer(albumModel, width, height);
      htmlViewer.openHtmlToFile();
    } else if ("graphical".equals(viewType)) {
      albumViewer.createAndShowGUI();
    }
  }

  private Map<String, String> parseArgs(String[] args) {
    Map<String, String> argumentsMap = new HashMap<>();

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "-in":
        case "-out":
        case "-v":
        case "-view":
          if (i + 1 < args.length) {
            argumentsMap.put(args[i], args[i + 1]);
            i++;
          }
      }
    }

    if (args.length >= 2) {
      try {
        Integer.parseInt(args[args.length - 2]);
        argumentsMap.put("width", args[args.length - 2]);
        argumentsMap.put("height", args[args.length - 1]);
      } catch (NumberFormatException e) {
      }
    }

    return argumentsMap;
  }

  private String getViewType(Map<String, String> argumentsMap) {
    if (argumentsMap.get("-v") != null) {
      return argumentsMap.get("-v");
    } else if (argumentsMap.get("-view") != null) {
      return argumentsMap.get("-view");
    }
    return null;
  }
}
