package cs1302.p2;

import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import java.util.NoSuchElementException;


/**
 * Creates an HBox that contains buttons to apply image filters.
 */
 
public class FilterBox extends HBox{
   
   int s;
   Button checkers = new Button("Checkers");
   Button hstripe = new Button("Horizontal Stripes");
   Button vstripe = new Button("Vertical Stripes");


   public FilterBox(ImgPane imgpain){
      super(15);
      setPadding(new Insets(0,8,0,8));
      MyArtsy h = new MyArtsy();
      checkers.setOnAction(event -> {
      
         TextInputDialog input = new TextInputDialog();
         input.setTitle("Checkers Options");
         input.setContentText("Please enter the desired checker width, in pixels:");
         input.setHeaderText(null);
         input.setGraphic(null);
         try{
            s = Integer.parseInt(input.showAndWait().get()); 
            imgpain.changeImg(h.doCheckers(imgpain.getImg(0),imgpain.getImg(1),s),2);
         }//try
         catch(NoSuchElementException hey){
         }
         catch(NumberFormatException e){
            Alert howdareu = new Alert(AlertType.ERROR);
            howdareu.setTitle("Invalid Input");
            howdareu.setHeaderText("Why?!?!");
            howdareu.setContentText("Input not a number.");
            howdareu.showAndWait();
         }//catch
         
      });
      hstripe.setOnAction(event -> {
      
         TextInputDialog input = new TextInputDialog();
         input.setTitle("Horizontal Stripe Options");
         input.setContentText("Please enter the desired stripe height, in pixels:");
         input.setHeaderText(null);
         input.setGraphic(null);
         try{
            s = Integer.parseInt(input.showAndWait().get()); 
            imgpain.changeImg(h.doHorizontalStripes(imgpain.getImg(0),imgpain.getImg(1),s),2);
         }//try
         catch(NoSuchElementException hey){
         }
         catch(NumberFormatException e){
            Alert howdareu = new Alert(AlertType.ERROR);
            howdareu.setTitle("Invalid Input");
            howdareu.setHeaderText("Why?!?!");
            howdareu.setContentText("Input not a number.");
            howdareu.showAndWait();
         }//catch
         
      });
      
         vstripe.setOnAction(event -> {
      
         TextInputDialog input = new TextInputDialog();
         input.setTitle("Vertical Stripe Options");
         input.setContentText("Please enter the desired stripe width, in pixels:");
         input.setHeaderText(null);
         input.setGraphic(null);
         try{
            s = Integer.parseInt(input.showAndWait().get()); 
            imgpain.changeImg(h.doVerticalStripes(imgpain.getImg(0),imgpain.getImg(1),s),2);
         }//try
         catch(NoSuchElementException hey){
         }
         catch(NumberFormatException e){
            Alert howdareu = new Alert(AlertType.ERROR);
            howdareu.setTitle("Invalid Input");
            howdareu.setHeaderText("Why?!?!");
            howdareu.setContentText("Input not a number.");
            howdareu.showAndWait();
         }//catch
         
      });
      
      getChildren().addAll(checkers,hstripe,vstripe);
      
   }//FilterBox

}//FilterBox