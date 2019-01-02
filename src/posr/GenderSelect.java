/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posr;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This class presents the gender select menu
 * @author Luka_
 */
public class GenderSelect {
    
    // Creating PosrScene object
    PosrScene posr = new PosrScene();
    
    GenderSelect(){
        
    }
    
    // The constructor that passes the stage that is to be displayed upon
    GenderSelect(Stage primaryStage, PosrScene posr) {
        this.primaryStage = primaryStage;
        this.posr = posr;
    }
    
    // Creating a stage variable to be passed in to have access to main program
    // stage.
    Stage primaryStage = new Stage();
    
    // Creating the pane
    Pane root = new Pane();
    
    // Creating the buttons
    Button btnMale = new Button();
    Button btnFemale = new Button();
    
    
    /**
     * This method creates the Gender Select screen
     * @return The Gender Select stage is returned
     */
    public Scene gsmScene() {
        
        // Creating all images
        ImageView[] gsm = createStaticImages();
        
        
        // Setting button text
        btnMale.setText("Male");
        btnFemale.setText("Female");
        
        // Adding event listeners to the buttons
        btnMale.setOnAction(e -> eventsCode(e));
        btnFemale.setOnAction(e -> eventsCode(e));
        
        root.getChildren().addAll(gsm[0], gsm[1], gsm[2], btnMale, btnFemale);

        // Positioning the buttons
        btnMale.setLayoutX(50);
        btnMale.setLayoutY(550);
        btnMale.setPrefWidth(100);
        btnMale.setPrefHeight(40);
        
        btnFemale.setLayoutX(300);
        btnFemale.setLayoutY(550);
        btnFemale.setPrefWidth(100);
        btnFemale.setPrefHeight(40);
        
        // Creating the scene
        Scene scene = new Scene(root, 450, 652);

        return scene;
    }

    /**
     * This method creates an ImageView array that returns all the images used on this scene
     * @return Returns the ImageView array with images attached.
     */
    public ImageView[] createStaticImages() {

        // Creating an array that will return all images
        ImageView[] ivGen = new ImageView[3];

        // Initilizing all ImageViews
        for (int i = 0; i < ivGen.length; i++) {
            ivGen[i] = new ImageView();
        }

        // Setting default background
        Image imgBsmBackground = new Image("file:images\\GenderSelectMenu\\GsmBackground.png");
        ivGen[0].setImage(imgBsmBackground);

        // Setting default head
        Image imgHead = new Image("file:images\\GenderSelectMenu\\male.png");
        ivGen[1].setImage(imgHead);

        // Setting default hands       
        Image imgHands = new Image("file:images\\GenderSelectMenu\\female.png");
        ivGen[2].setImage(imgHands);

        return ivGen;
    }

    public void eventsCode(ActionEvent e) {
        // Selecting Male
        if (e.getSource() == btnMale) {
            posr.setGender("M1");
            BodyStyleMenu bsm = new BodyStyleMenu(primaryStage, posr);
            Scene sceneBsm = bsm.bsmScene();
            primaryStage.setScene(sceneBsm);
        }
        
        // Selecting Female
        if (e.getSource() == btnFemale) {
            posr.setGender("F1");
            BodyStyleMenu bsm = new BodyStyleMenu(primaryStage, posr);
            Scene sceneBsm = bsm.bsmScene();
            primaryStage.setScene(sceneBsm);
        }
    }
}
