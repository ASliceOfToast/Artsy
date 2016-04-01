package cs1302.p2;

import cs1302.effects.Artsy;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;

/**
 * This is the driver for this application.
 */
public class Driver extends Application {

    @Override
    public void start(Stage stage) {

        FlowPane root = new FlowPane();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Artsy!");
        stage.sizeToScene();
        stage.show();
        
    } // createAndShowGUI

    public static void main(String[] args) {
        launch(args);
    } // main

} // Driver
