package main.java.cs1302.p2;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.NoSuchElementException;

/*
 * Creates an Hbox that has buttons allowing the user to rotate and reset
 * the images in each pane.
 */
public class RotRes extends HBox{
   int id;
   Button rotate = new Button("Rotate");
   Button reset = new Button("Reset");
   double degrees;
   
   public RotRes(int ID, ImgPane imgpain){
      super(8);
      id = ID;
      MyArtsy h = new MyArtsy();
      
      rotate.setOnAction(event -> {
      
         TextInputDialog input = new TextInputDialog();
         input.setTitle("Rotate Image Options");
         input.setContentText("Please enter your angle, in degrees:");
         input.setHeaderText(null);
         input.setGraphic(null);
         try{
            degrees = Double.parseDouble(input.showAndWait().get()); 
            imgpain.changeImg(h.doRotate(imgpain.getImg(ID),degrees),ID);
         }
         catch(NoSuchElementException hey){
         }
         catch(NumberFormatException e){
            Alert howdareu = new Alert(AlertType.ERROR);
            howdareu.setTitle("Invalid Input");
            howdareu.setHeaderText("Why?!?!");
            howdareu.setContentText("Input not a number.");
            howdareu.showAndWait();
         }
         
      });
      reset.setOnAction(event -> imgpain.resetImg(ID));
      getChildren().addAll(rotate,reset);
   }

}