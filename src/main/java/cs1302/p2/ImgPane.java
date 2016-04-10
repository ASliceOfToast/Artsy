package main.java.cs1302.p2;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.image.BufferedImage;
import javafx.scene.control.Label;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/*
 * Creates Image panes to display the two input images and the result image.
 */
public class ImgPane extends BorderPane{
   Image[] imgarr = new Image[3];
   Image[] altered = new Image[3];
   RotRes[] butts = new RotRes[3];
   Image def;
   String wow;
   VBox[] lilboxes = new VBox[3];
   ImageView[] imgvi = new ImageView[3];
   InputStream input;
   Label[] labels = new Label[]{new Label("Image 1: default.png"),new Label("Image 2: default.png"),new Label("Result")};
   Insets padding = new Insets(10,10,10,10);

   public ImgPane(){
      super();
      for(int i=0;i<3;i++){
         imgvi[i] = new ImageView();
         lilboxes[i] = new VBox(8);
      }
      
      
      try{
         
         input = new FileInputStream("resources/default.png");
         def = new Image(input);
         for(int i=0;i<3;i++){
            imgarr[i] = def;
            altered[i] = def;
            imgvi[i].setImage(def);
            setMargin(lilboxes[i],padding);
            setAlignment(lilboxes[i],Pos.CENTER);
            butts[i] = new RotRes(i,this);
            lilboxes[i].getChildren().addAll(labels[i],imgvi[i],butts[i]);
            lilboxes[i].setAlignment(Pos.CENTER);
            lilboxes[i].setPrefWidth(300);
         }
                  
         
         setLeft(lilboxes[0]);
         setCenter(lilboxes[1]);
         setRight(lilboxes[2]);
      }
      catch(FileNotFoundException i){
         i.printStackTrace();
      }
      
   }//ImgPane
   
   /*
    * An overloaded method to change the image in each pane
    */
   public void changeImg(File file, int ID){
      try{
         input = new FileInputStream(file.getPath());
         Image thing = new Image(input);
         imgarr[ID] = thing;
         altered[ID] = thing;
         imgvi[ID].setImage(imgarr[ID]);
         labels[ID].setText("Image " + (ID+1) + ": " + file.getName());
      }
      catch(FileNotFoundException i){
         i.printStackTrace();
      }
      catch(NullPointerException n){
      
      }
   }//changeImg, changes image to one selected from computer
   
   /*
    * An overloaded method to change the image in each pane
    */
   public void changeImg(Image img, int ID){
      altered[ID] = img;
      imgvi[ID].setImage(altered[ID]);
   }//changeImg, changes displayed image as altered image
   
   /*
    * returns the image in a given pane.
    */
   public Image getImg(int ID){
      return altered[ID];
   }
   
   /*
    * Resets an image to it's original state.
    */
   public void resetImg(int ID){
      altered[ID] = imgarr[ID];
      imgvi[ID].setImage(imgarr[ID]);
   }
}