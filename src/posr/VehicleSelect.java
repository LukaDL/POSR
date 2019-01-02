/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posr;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Brings up the VehicleSelect menu
 * @author Luka_
 */
public class VehicleSelect {

    // Creating PosrScene object
    PosrScene posr = new PosrScene();
    
    VehicleSelect() {

    }

    VehicleSelect(Stage primaryStage, PosrScene posr) {
        this.primaryStage = primaryStage;
        this.posr = posr;
    }

    // Creating Pane
    Pane root = new Pane();
    
    // Creating all the buttons for the car navigation and return to main screen
    Button btnNext = new Button();
    Button btnPrevious = new Button();
    Button btnSave = new Button();

    // Creating the default red vehicle label
    Label lblVehicle = new Label("Red Rocket");

    // Creating a stage variable to be passed in to have access to main program
    // stage.
    Stage primaryStage = new Stage();

    // Getting all the images for the Scene
    ImageView[] vsm = createImages();

    // Creating the Scene that will be returned to the caller of this method
    public Scene vsmStage() {

        // Creating all buttons
        btnNext.setText("Next");
        btnPrevious.setText("Previous");
        btnSave.setText("Save");

        // Creating event listeners for the buttons
        btnNext.setOnAction(e -> eventsCode(e));
        btnPrevious.setOnAction(e -> eventsCode(e));
        btnSave.setOnAction(e -> eventsCode(e));

        // Adding all the buttons, labels and images
        root.getChildren().addAll(vsm[0], vsm[1], btnNext, btnPrevious, btnSave, lblVehicle);

        // Setting the styles and positions for the buttons and labels
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

        lblVehicle.setLayoutX(170);
        lblVehicle.setLayoutY(125);
        lblVehicle.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        lblVehicle.setTextFill(Paint.valueOf("white"));

        // Calls on the method that updates the scene to show currently selected
        // vehicle
        updateScene();
        
        // Creating scene to be the standard 450 x 652 size
        Scene scene = new Scene(root, 450, 652);
        
        // Returns the scene to the calling class POSR
        return scene;
    }

    /**
     * This creates the image view files for all GUI images
     * @return returns an array of images created for the scene
     */
    public ImageView[] createImages() {

        // Creating an array that will return all images
        ImageView[] ivGen = new ImageView[2];

        // Initilizing all ImageViews
        for (int i = 0; i < ivGen.length; i++) {
            ivGen[i] = new ImageView();
        }

        // Setting default background
        Image imgvsmBackground = new Image("file:images\\VehicleSelectMenu\\VsmBackground.png");
        ivGen[0].setImage(imgvsmBackground);

        // Setting default car
        Image imgCar = new Image("file:images\\VehicleSelectMenu\\vehicle" + posr.getVehicle() + ".png");
        ivGen[1].setImage(imgCar);

        return ivGen;
    }

    public void eventsCode(ActionEvent e) {
        // changing to next vehicle
        if (e.getSource() == btnNext) {
            posr.setVehicle((posr.getVehicle() % 3) + 1);
            updateScene();
        }

        // changing to previous vehicle
        if (e.getSource() == btnPrevious) {
            posr.setVehicle((posr.getVehicle() - 1) % 3);

            if (posr.getVehicle() < 1) {
                posr.setVehicle(3);
            }
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
     * This method is needed to update the scene
     */
    public void updateScene() {

        int vehicle = posr.getVehicle();
        if (vehicle == 1) {
            lblVehicle.setText("Red Rocket");
        } else if (vehicle == 2) {
            lblVehicle.setText("Baby Blue");
        } else {
            lblVehicle.setText("Green Machine");
        }
        vsm = createImages();

        root.getChildren().clear();
        root.getChildren().addAll(vsm[0], vsm[1], btnNext, btnPrevious, btnSave, lblVehicle);
    }

}
