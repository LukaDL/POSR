/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posr;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This is the scene that allows the user to select a scene.
 * @author Luka_
 */
public class ScenerySelect {

    // Creating PosrScene object
    PosrScene posr = new PosrScene();

    ScenerySelect() {

    }

    ScenerySelect(Stage primaryStage, PosrScene posr) {
        this.primaryStage = primaryStage;
        this.posr = posr;
    }

    // Creating Pane
    Pane root = new Pane();

    // Creating all interface buttons
    Button btnNext = new Button();
    Button btnPrevious = new Button();
    Button btnSave = new Button();

    // Creating a stage variable to be passed in to have access to main program
    // stage.
    Stage primaryStage = new Stage();

    // Getting all the scene images
    ImageView[] ssm = createImages();
    
    // Creating the Scene that will be returned to the caller of this method
    public Scene ssmStage() {

        // Creating all buttons
        btnNext.setText("Next");
        btnPrevious.setText("Previous");
        btnSave.setText("Save");
        
        // Creating all event listeners
        btnNext.setOnAction(e -> eventsCode(e));
        btnPrevious.setOnAction(e -> eventsCode(e));
        btnSave.setOnAction(e -> eventsCode(e));

        // Adding images and buttons to the scene
        root.getChildren().addAll(ssm[0], ssm[1], btnNext, btnPrevious, btnSave);

        // Positioning the buttons on the scene
        btnNext.setLayoutX(320);
        btnNext.setLayoutY(150);
        btnNext.setPrefWidth(80);
        btnNext.setPrefHeight(20);

        btnPrevious.setLayoutX(50);
        btnPrevious.setLayoutY(150);
        btnPrevious.setPrefWidth(80);
        btnPrevious.setPrefHeight(20);

        btnSave.setLayoutX(185);
        btnSave.setLayoutY(600);
        btnSave.setPrefWidth(80);
        btnSave.setPrefHeight(20);

        // Updating the scene to reflect the current selections
        updateScene();

        // Creating the scene to be returned to the caller
        Scene scene = new Scene(root, 450, 652);

        return scene;
    }

    /**
     * Creating images that will be placed in the scene
     * @return returns an array of scene images
     */
    public ImageView[] createImages() {

        // Creating an array that will return all images
        ImageView[] ivGen = new ImageView[2];

        // Initilizing all ImageViews
        for (int i = 0; i < ivGen.length; i++) {
            ivGen[i] = new ImageView();
        }

        // Setting default background
        Image imgssmBackground = new Image("file:images\\ScenerySelectMenu\\ssmBackground.png");
        ivGen[0].setImage(imgssmBackground);

        // Setting default scenery
        Image imgScenery = new Image("file:images\\ScenerySelectMenu\\scenery" + posr.getLocation() + ".png");
        ivGen[1].setImage(imgScenery);

        return ivGen;
    }

    public void eventsCode(ActionEvent e) {
        // An algorithm to change to the next scenery
        if (e.getSource() == btnNext) {
            posr.setLocation((posr.getLocation() % 3) + 1);
            // Updating the scene
            updateScene();

        }

        // changing to previous scenery
        if (e.getSource() == btnPrevious) {
            
            // An algorithim to go backwards through the list of 3 vehicles
            posr.setLocation((posr.getLocation() - 1) % 3);

            if (posr.getLocation() < 1) {
                posr.setLocation(3);
            }
            // Updating the scene
            updateScene();
        }

        // Saving and going back to main menu
        if (e.getSource() == btnSave) {
            MainScreen mainScreen = new MainScreen(primaryStage, posr);
            Scene sceneMain = mainScreen.mainScene();
            primaryStage.setScene(sceneMain);
        }

    }

    /**
     * This method is needed to update the user avatar
     */
    public void updateScene() {

        ssm = createImages();

        root.getChildren().clear();
        root.getChildren().addAll(ssm[0], ssm[1], btnNext, btnPrevious, btnSave);
    }

}
