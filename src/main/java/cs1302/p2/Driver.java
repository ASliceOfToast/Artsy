package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
import javafx.scene.control.*;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

    @Override
    public void start(Stage stage) {

        VBox root = new VBox(8);
        FilterBox filt = new FilterBox();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Artsy!");
        
        ImgPane imgpain = new ImgPane();
        MainMenu m = new MainMenu(stage,imgpain);
        
        
        root.getChildren().addAll(m,filt,imgpain);
        
        
        
        stage.sizeToScene();
        
        
        stage.show();
        
    } // createAndShowGUI

    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
