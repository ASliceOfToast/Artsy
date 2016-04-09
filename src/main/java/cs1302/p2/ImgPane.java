package cs1302.p2;

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
         File fuck = new File("ImgPane.class");
         wow = fuck.getAbsolutePath();
         wow = wow.substring(0,wow.lastIndexOf("src")) + "resources\\default.png";
         input = new FileInputStream(wow);
         def = new Image(input);
         for(int i=0;i<3;i++){
            imgarr[i] = def;
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
   
   public void changeImg(File file, int ID){
      try{
         input = new FileInputStream(file.getPath());
         imgarr[ID] = new Image(input);
         imgvi[ID].setImage(imgarr[ID]);
         imgvi[ID].setFitWidth(300);
         imgvi[ID].setFitHeight(300);
         int i = file.getPath().lastIndexOf("\\") + 1;
         labels[ID].setText("Image 1: " + file.getPath().substring(i,file.getPath().length()));
      }
      catch(FileNotFoundException i){
         i.printStackTrace();
      }
      catch(NullPointerException n){
      
      }
   }//changeImg, changes image to one selected from computer
   
   public void changeImg(Image img, int ID){
      altered[ID] = img;
      imgvi[ID].setImage(altered[ID]);
   }//changeImg, changes displayed image as altered image
   
   public Image getImage(int ID){
      return imgarr[ID];
   }
}