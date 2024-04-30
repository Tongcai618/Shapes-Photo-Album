package view;

import java.awt.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import model.AlbumModel;
import model.ISnapshot;

/**
 * The type Album viewer.
 */
public class AlbumViewer {
  /**
   * The Width.
   */
  int width;
  /**
   * The Height.
   */
  int height;
  private JFrame mainFrame;
  private JComboBox<String> comboBox;
  private AlbumModel albumModel;
  private List<SimpleEntry<String, ISnapshot>> snapshotEntries;
  private int snapshotEntryIndex;

  /**
   * Instantiates a new Album viewer.
   *
   * @param albumModel the album model
   * @param width      the width
   * @param height     the height
   */
  public AlbumViewer(AlbumModel albumModel, int width, int height) {
    this.albumModel = albumModel;
    this.snapshotEntries = albumModel.getSnapshots();
    this.width = width;
    this.height = height;
    snapshotEntryIndex = this.snapshotEntries.size() - 1;
  }

  /**
   * Create and show gui.
   */
  public void createAndShowGUI() {
    mainFrame = new JFrame("Album Viewer");
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(width, height);
    mainFrame.setLocationRelativeTo(null);
    mainFrame.setVisible(true);

    displayAlbum();
  }


  /**
   * Display album.
   */
  public void displayAlbum() {
    // remove all previous content
    mainFrame.getContentPane().removeAll();

    // reset the buttons
    setupButtons();

    // generate text and album and put them on the frame
    SnapshotRender panel = new SnapshotRender(snapshotEntries.get(snapshotEntryIndex).getValue());
    JLabel textLabel = getTextLabel();
    mainFrame.add(panel);
    mainFrame.add(textLabel, BorderLayout.NORTH);

    // validate and repaint the frame
    mainFrame.validate();
    mainFrame.repaint();
  }

  private void setupButtons() {
    // create the buttons Panel
    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    // create buttons

    // set up prev button
    JButton prevButton = new JButton("<< Prev <<");
    prevButton.addActionListener(e -> {
              if (this.snapshotEntryIndex > 0) {
                this.snapshotEntryIndex -= 1;
                displayAlbum();
              } else {
                JDialog dialog = new JDialog(mainFrame, "Message", true);
                dialog.setLayout(new FlowLayout());
                JLabel message1 = new JLabel("End of the photo album.");
                JLabel message2 = new JLabel("No previous snapshot to show before this snapshot.");
                dialog.add(message1);
                dialog.add(message2);
                dialog.setSize(400, 100);
                dialog.setLocationRelativeTo(mainFrame);
                dialog.setVisible(true);
              }
            }
    );


    JButton selectButton = new JButton("^^ Select ^^");
    selectButton.addActionListener(e -> setupComboBox());

    // set up next button
    JButton nextButton = new JButton(">> Next >>");
    nextButton.addActionListener(e -> {
      if (this.snapshotEntryIndex < this.snapshotEntries.size() - 1) {
        this.snapshotEntryIndex += 1;
        displayAlbum();
      } else {
        JDialog dialog = new JDialog(mainFrame, "Message", true);
        dialog.setLayout(new FlowLayout());
        JLabel message1 = new JLabel("End of the photo album.");
        JLabel message2 = new JLabel("No latter snapshot to show after this snapshot.");
        dialog.add(message1);
        dialog.add(message2);
        dialog.setSize(400, 100);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setVisible(true);
      }
    });

    // set up quit Button
    JButton quitButton = new JButton("xx Quit xx");
    quitButton.addActionListener(e -> System.exit(0));


    // add all buttons to the panel
    buttonPanel.add(prevButton);
    buttonPanel.add(selectButton);
    buttonPanel.add(nextButton);
    buttonPanel.add(quitButton);

    mainFrame.add(buttonPanel, BorderLayout.SOUTH);
    mainFrame.validate();
    mainFrame.repaint();
  }


  /**
   * Sets combo box.
   */
  public void setupComboBox() {

    // create a popup
    Dialog dialog = new JDialog(mainFrame, "Select Option", true);
    dialog.setLayout(new FlowLayout());
    List<String> options = new ArrayList<>();

    for (int i = 0; i < albumModel.getSnapshots().size(); i++) {
      options.add(albumModel.getSnapshots().get(i).getKey());
    }

    // create the list
    comboBox = new JComboBox<>(options.toArray(new String[0]));
    comboBox.addActionListener(l -> {
      String selectedOption = (String) comboBox.getSelectedItem();
      for (int i = 0; i < snapshotEntries.size(); i += 1) {
        if (snapshotEntries.get(i).getKey().equals(selectedOption)) {
          snapshotEntryIndex = i;
        }
      }
    });

    dialog.add(comboBox);
    // create a confirm button to render new album
    JButton confirmButton = new JButton("OK");
    confirmButton.addActionListener(e -> displayAlbum());
    dialog.add(confirmButton);
    // set the size of the popup
    dialog.setSize(400, 200);
    dialog.setLocationRelativeTo(mainFrame);
    dialog.setVisible(true);
  }

  private JLabel getTextLabel() {
    JLabel textLabel = new JLabel();
    textLabel.setText("<html>"
            + this.snapshotEntries.get(snapshotEntryIndex).getKey() + "<br/>"
            + this.snapshotEntries.get(snapshotEntryIndex).getValue().getDescription()
            + "</html>");
    textLabel.setBackground(new java.awt.Color(0,0,0));
    return textLabel;
  }
}
