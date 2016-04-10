package cs1302.p2;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class GrumpyCat extends BorderPane {

	VBox idk = new VBox(8);
	
	final String GRUMPY_CAT = "http://i.imgur.com/VJTVsNR.jpg";
	
	public GrumpyCat(){
		super();
		
		Image image = new Image(GRUMPY_CAT);
		ImageView kms = new ImageView();
		kms.setImage(image);
		setLeft(kms);
		
	}//CatPane
	
}//I hate everything