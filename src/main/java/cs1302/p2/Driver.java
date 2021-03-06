package main.java.cs1302.p2;

import main.java.cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

	static String bull = "UPUPDOWNDOWNLEFTRIGHTLEFTRIGHTBA";
    static String shit = "";
	
    @Override
    public void start(Stage stage) {

        VBox root = new VBox(8);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Artsy!");
        
        ImgPane imgpain = new ImgPane();
        FilterBox filt = new FilterBox(imgpain);
        MainMenu m = new MainMenu(stage,imgpain);
        
        
        root.getChildren().addAll(m,filt,imgpain);
        
        
        
        stage.sizeToScene();
        
        
        /*
         * Creates an event listener that monitors keypresses and 
         * creates a window containing Grumpy Cat if the Konami code
         * is entered.
         */
        root.setOnKeyPressed(new EventHandler<KeyEvent>(){

			@Override
			public void handle(KeyEvent event) {
				
				shit+=event.getCode();
				//System.out.println(shit);
				if(shit.toLowerCase().contains(bull.toLowerCase())){
		        	//System.out.println("Penis");
		        	shit="";
		        	Stage about = new Stage(StageStyle.UTILITY);
	                GrumpyCat grumpycat = new GrumpyCat();
	                Scene scene = new Scene(grumpycat);
	                about.setScene(scene);
	                about.setTitle("GIMME TEH BONUS POINTS PLS");
	                about.initModality(Modality.APPLICATION_MODAL);
	                about.show();
				}//if
				
			}//handle
        	
        });//key press events
        
        stage.show();
        
    } // createAndShowGUI

    /*
     * Launches application
     */
    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
