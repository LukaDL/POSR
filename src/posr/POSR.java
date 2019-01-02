/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posr;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class where all scenes are loaded into
 * @author Luka_
 */
public class POSR extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Creating PosrScene object
        PosrScene posr = new PosrScene();
        
        // Going to the main screen to start
        MainScreen mainScreen = new MainScreen(primaryStage, posr);

        Scene scene = mainScreen.mainScene();

        primaryStage.setTitle("POSR");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
