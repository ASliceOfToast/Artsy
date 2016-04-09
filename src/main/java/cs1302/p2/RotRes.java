package cs1302.p2;

import javafx.scene.layout.HBox;
import javafx.scene.control.Button;

public class RotRes extends HBox{
   int id;
   Button rotate = new Button("Rotate");
   Button reset = new Button("Reset");
   
   public RotRes(int ID, ImgPane imgpain){
      super(8);
      id = ID;
      //rotate.setOnAction(event -> imgpain.changeImg(doRotate(imgpain.getImage(id))));
      //reset.setOnAction(event -> imgpain.changeImg(
      getChildren().addAll(rotate,reset);
   }

}