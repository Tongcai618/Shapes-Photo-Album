import controller.AlbumController;


public class PhotoAlbumMain {

  public static void main(String[] args) {

    if (args.length > 0) {
      new AlbumController(args);
    }
  }
}
