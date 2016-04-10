package main.java.cs1302.p2;

import javafx.scene.control.*;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;

/**
 * Creates the File menu that is added to the application's MenuBar.
 */

public class FileMenu extends Menu{

MenuItem getmeoutofhere = new MenuItem("Exit");
MenuItem saveme = new MenuItem("Save Result As...");
FileChooser chooser = new FileChooser();

   public FileMenu(Stage screams, ImgPane imgpain){
      super("File");
      chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.jpg"), new FileChooser.ExtensionFilter("JPEG files (*.jpeg)","*.jpeg"), new FileChooser.ExtensionFilter("PNG files (*.png)","*.png"), new FileChooser.ExtensionFilter("GIF files (*.gif)","*.gif"));
      OpenShitMenu open = new OpenShitMenu(screams,imgpain);
      saveme.setOnAction(event -> {File save = chooser.showSaveDialog(screams);
      if(save != null){
         BufferedImage bImage = SwingFXUtils.fromFXImage(imgpain.getImg(2), null);
         try{
            ImageIO.write(bImage, "png", save);
         }//try
         catch(IOException o){
            Alert howdareu = new Alert(AlertType.ERROR);
            howdareu.setTitle("Error");
            howdareu.setHeaderText(null);
            howdareu.setContentText(o.getMessage());
            howdareu.showAndWait();
         }//catch
      }//if   
      });
      getmeoutofhere.setOnAction(event -> Platform.exit());
      getItems().addAll(open,saveme,getmeoutofhere);
   }

}//FileMenu