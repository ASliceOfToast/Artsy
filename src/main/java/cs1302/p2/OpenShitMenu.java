package cs1302.p2;

import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;

public class OpenShitMenu extends Menu{

FileChooser chooser = new FileChooser();
File img1f;
File img2f;


public OpenShitMenu(Stage scream,ImgPane imgpain){
   super("Open");
   MenuItem first = new MenuItem("Open Image 1");
   MenuItem second = new MenuItem("Open Image 2");

   chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.png","*.jpeg"));

   first.setOnAction(event -> {img1f = chooser.showOpenDialog(scream);imgpain.changeImg(img1f,0);});
   second.setOnAction(event -> {img2f = chooser.showOpenDialog(scream);imgpain.changeImg(img2f,1);});

   getItems().addAll(first,second);
}


}