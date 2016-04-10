package cs1302.p2;

import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;

/**
 * Creates the File menu that is added to the application's MenuBar.
 */

public class FileMenu extends Menu{

MenuItem getmeoutofhere = new MenuItem("Exit");
MenuItem saveme = new MenuItem("Save Result As...");
FileChooser chooser = new FileChooser();

   public FileMenu(Stage screams, ImgPane imgpain){
      super("File");
      OpenShitMenu open = new OpenShitMenu(screams,imgpain);
      saveme.setOnAction(event -> chooser.showOpenDialog(screams));
      getmeoutofhere.setOnAction(event -> Platform.exit());
      getItems().addAll(open,saveme,getmeoutofhere);
   }

}//FileMenu