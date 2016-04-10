package main.java.cs1302.p2;

import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.control.TabPane;

public class OpenShitMenu extends Menu{

FileChooser chooser = new FileChooser();
File img1f;
File img2f;

/*
 * Populates the menu with open image options for image 1 and image 2.
 */

public OpenShitMenu(Stage scream,ImgPane imgpain){
   super("Open");
   MenuItem first = new MenuItem("Open Image 1");
   MenuItem second = new MenuItem("Open Image 2");

   chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files (*.jpg, *.jpeg, *.png, *.gif)", "*.jpg","*.png","*.jpeg","*.gif"));

   first.setOnAction(event -> {img1f = chooser.showOpenDialog(scream);imgpain.changeImg(img1f,0);});
   /*first.setOnAction(event -> {
   
   
   });*/
   second.setOnAction(event -> {img2f = chooser.showOpenDialog(scream);imgpain.changeImg(img2f,1);});

   getItems().addAll(first,second);
}


}