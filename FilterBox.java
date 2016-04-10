package cs1302.p2;

import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.Button;


/**
 * Creates an HBox that contains buttons to apply image filters.
 */
 
public class FilterBox extends HBox{

   Button checkers = new Button("Checkers");
   Button hstripe = new Button("Horizontal Stripes");
   Button vstripe = new Button("Vertical Stripes");


   public FilterBox(){
      super(15);
      setPadding(new Insets(0,8,0,8));
      getChildren().addAll(checkers,hstripe,vstripe);
   }//FilterBox

}