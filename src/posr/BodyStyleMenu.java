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
 * This class allows the user to customize the user's avatar
 * @author Luka_
 */
public class BodyStyleMenu {

    // Creating PosrScene object
    PosrScene posr = new PosrScene();

    BodyStyleMenu() {

    }
    
    // The constructor that passes the stage that is to be displayed upon
    BodyStyleMenu(Stage primaryStage, PosrScene posr) {
        this.primaryStage = primaryStage;
        this.posr = posr;
    }

    // Creating a stage variable to be passed in to have access to main program
    // stage.
    Stage primaryStage = new Stage();

    // Creating the images that won't change
    ImageView[] ivStaticImg = createStaticImages();

    // Setting default background
    ImageView ivBsm = ivStaticImg[0];

    // Setting default hands       
    ImageView ivHands = ivStaticImg[1];

    // Setting default value for hat, top, bottom and head
    ImageView[] ivGen = createDynamicImages();
    ImageView ivHat = ivGen[0];
    ImageView ivTop = ivGen[1];
    ImageView ivBottom = ivGen[2];
    ImageView ivHead = ivGen[3];

    // Creating hat selections
    // images for hats 1, 2 and 3    
    ImageView ivHat1 = ivStaticImg[2];
    ImageView ivHat2 = ivStaticImg[3];
    ImageView ivHat3 = ivStaticImg[4];

    // Creating top selections
    // images for top 1, 2 and 3
    ImageView ivTop1 = ivStaticImg[5];
    ImageView ivTop2 = ivStaticImg[6];
    ImageView ivTop3 = ivStaticImg[7];

    // Creating bottom selections
    // images for bottoms 1, 2 and 3
    ImageView ivBottom1 = ivStaticImg[8];
    ImageView ivBottom2 = ivStaticImg[9];
    ImageView ivBottom3 = ivStaticImg[10];

    Pane root = new Pane();

    // Creating Buttons
    Button btnHat1 = new Button();
    Button btnHat2 = new Button();
    Button btnHat3 = new Button();

    Button btnTop1 = new Button();
    Button btnTop2 = new Button();
    Button btnTop3 = new Button();

    Button btnBottom1 = new Button();
    Button btnBottom2 = new Button();
    Button btnBottom3 = new Button();

    Button btnBack = new Button();
    Button btnSave = new Button();

    public Scene bsmScene() {

        // Creating all buttons
        btnHat1.setText("Hat1");
        btnHat2.setText("Hat2");
        btnHat3.setText("Hat3");
        btnTop1.setText("Top1");
        btnTop2.setText("Top2");
        btnTop3.setText("Top3");
        btnBottom1.setText("Bottom1");
        btnBottom2.setText("Bottom2");
        btnBottom3.setText("Bottom3");

        btnBack.setText("Back");
        btnSave.setText("Save");

        btnHat1.setOnAction(e -> eventsCode(e));
        btnHat2.setOnAction(e -> eventsCode(e));
        btnHat3.setOnAction(e -> eventsCode(e));
        btnTop1.setOnAction(e -> eventsCode(e));
        btnTop2.setOnAction(e -> eventsCode(e));
        btnTop3.setOnAction(e -> eventsCode(e));
        btnBottom1.setOnAction(e -> eventsCode(e));
        btnBottom2.setOnAction(e -> eventsCode(e));
        btnBottom3.setOnAction(e -> eventsCode(e));

        // Creating event listeners for the buttons
        btnBack.setOnAction(e -> eventsCode(e));
        btnSave.setOnAction(e -> eventsCode(e));

        root.getChildren().addAll(ivBsm, ivHead, ivHands, ivBottom,
                ivTop, ivHat, ivHat1, ivHat2, ivHat3, ivTop1, ivTop2,
                ivTop3, ivBottom1, ivBottom2, ivBottom3, btnHat1, btnHat2,
                btnHat3, btnTop1, btnTop2, btnTop3, btnBottom1, btnBottom2,
                btnBottom3, btnBack, btnSave);

        // Setting the layout for all the buttons
        btnHat1.setLayoutX(241);
        btnHat1.setLayoutY(262);

        btnHat2.setLayoutX(302);
        btnHat2.setLayoutY(262);

        btnHat3.setLayoutX(366);
        btnHat3.setLayoutY(262);

        btnTop1.setLayoutX(241);
        btnTop1.setLayoutY(352);

        btnTop2.setLayoutX(302);
        btnTop2.setLayoutY(352);

        btnTop3.setLayoutX(366);
        btnTop3.setLayoutY(352);

        btnBottom1.setLayoutX(228);
        btnBottom1.setLayoutY(441);

        btnBottom2.setLayoutX(292);
        btnBottom2.setLayoutY(441);

        btnBottom3.setLayoutX(354);
        btnBottom3.setLayoutY(441);

        btnBack.setLayoutX(50);
        btnBack.setLayoutY(550);
        btnBack.setPrefWidth(100);
        btnBack.setPrefHeight(40);

        btnSave.setLayoutX(300);
        btnSave.setLayoutY(550);
        btnSave.setPrefWidth(100);
        btnSave.setPrefHeight(40);
        
        // Updates the scene upon loading to reflect the current PosrScene avatar
        updateScene();

        // Sets the scene to the app standard 450 x 652 pixels
        Scene scene = new Scene(root, 450, 652);

        return scene;
    }

    /**
     * Creates all the images to be shown on the avatar
     * @return returns the array of images
     */
    public ImageView[] createDynamicImages() {
        // Creating an array that will return all images
        ivGen = new ImageView[4];

        for (int i = 0; i < ivGen.length; i++) {
            ivGen[i] = new ImageView();
        }

        // Setting hat
        Image imgHat = new Image("file:images\\BodyStyleMenu\\Hat\\Hat" + posr.getHat() + ".png");
        ivGen[0].setImage(imgHat);

        // Setting top
        Image imgTop = new Image("file:images\\BodyStyleMenu\\Top\\Top" + posr.getTop() + ".png");
        ivGen[1].setImage(imgTop);

        // Setting bottom
        Image imgBottom = new Image("file:images\\BodyStyleMenu\\Bottom\\Bottom" + posr.getBottom() + ".png");
        ivGen[2].setImage(imgBottom);
        
        // Setting head
        Image imgHead = new Image("file:images\\BodyStyleMenu\\Head" + posr.getGender() + ".png");
        ivGen[3].setImage(imgHead);

        return ivGen;
    }

    /**
     * Creates all the static images for this scene
     * @return returns an array of static images used in this scene
     */
    public ImageView[] createStaticImages() {

        // Creating an array that will return all images
        ivGen = new ImageView[11];

        // Initilizing all ImageViews
        for (int i = 0; i < ivGen.length; i++) {
            ivGen[i] = new ImageView();
        }

        // Setting default background
        Image imgBsmBackground = new Image("file:images\\BodyStyleMenu\\BsmBackground.png");
        ivGen[0].setImage(imgBsmBackground);

        // Setting default hands       
        Image imgHands = new Image("file:images\\BodyStyleMenu\\Hands1.png");
        ivGen[1].setImage(imgHands);

        // Creating hat selections
        // image for hat 1    
        Image imgHat1 = new Image("file:images\\BodyStyleMenu\\HatSelections\\HSH1.png");
        ivGen[2].setImage(imgHat1);

        // image for hat 2
        Image imgHat2 = new Image("file:images\\BodyStyleMenu\\HatSelections\\HSH2.png");
        ivGen[3].setImage(imgHat2);

        // image for hat 3
        Image imgHat3 = new Image("file:images\\BodyStyleMenu\\HatSelections\\HSH3.png");
        ivGen[4].setImage(imgHat3);

        // Creating top selections
        // image for top 1
        Image imgTop1 = new Image("file:images\\BodyStyleMenu\\TopSelections\\TST1.png");
        ivGen[5].setImage(imgTop1);

        // image for top 2
        Image imgTop2 = new Image("file:images\\BodyStyleMenu\\TopSelections\\TST2.png");
        ivGen[6].setImage(imgTop2);

        // image for top 3
        Image imgTop3 = new Image("file:images\\BodyStyleMenu\\TopSelections\\TST3.png");
        ivGen[7].setImage(imgTop3);

        // Creating bottom selections
        // image for bottom 1
        Image imgBottom1 = new Image("file:images\\BodyStyleMenu\\BottomSelections\\BSB1.png");
        ivGen[8].setImage(imgBottom1);

        // image for bottom 2
        Image imgBottom2 = new Image("file:images\\BodyStyleMenu\\BottomSelections\\BSB2.png");
        ivGen[9].setImage(imgBottom2);

        // image for bottom 3
        Image imgBottom3 = new Image("file:images\\BodyStyleMenu\\BottomSelections\\BSB3.png");
        ivGen[10].setImage(imgBottom3);

        return ivGen;
    }

    public void eventsCode(ActionEvent e) {
        Stage primaryStageClear = new Stage();
        // This is the command for the button to go back
        if (e.getSource() == btnBack) {
            GenderSelect gsm = new GenderSelect(primaryStage, posr);
            Scene sceneGsm = gsm.gsmScene();
            primaryStage.setScene(sceneGsm);
        }

        // Event listener to save and go back home
        if (e.getSource() == btnSave) {
            MainScreen mainScreen = new MainScreen(primaryStage, posr);
            Scene sceneMain = mainScreen.mainScene();
            primaryStage.setScene(sceneMain);
        }

        // changing to hat 1
        if (e.getSource() == btnHat1) {
            posr.setHat(1);
        }

        // changing to hat 2
        if (e.getSource() == btnHat2) {
            posr.setHat(2);
        }

        // changing to hat 3
        if (e.getSource() == btnHat3) {
            posr.setHat(3);
        }

        // changing to top 1
        if (e.getSource() == btnTop1) {
            posr.setTop(1);
        }

        // changing to top 2
        if (e.getSource() == btnTop2) {
            posr.setTop(2);
        }

        // changing to top 3
        if (e.getSource() == btnTop3) {
            posr.setTop(3);
        }

        // changing to
        if (e.getSource() == btnBottom1) {
            posr.setBottom(1);
        }

        // changing to
        if (e.getSource() == btnBottom2) {
            posr.setBottom(2);
        }

        // changing to
        if (e.getSource() == btnBottom3) {
            posr.setBottom(3);
        }
        
        // The following code updates the avatar to reflect the choices made
        // by the user.
        updateScene();
    }

    /**
     * This method is needed to update the user avatar
     */
    public void updateScene() {

        ImageView[] ivGen = createDynamicImages();
        ImageView ivHat = ivGen[0];
        ImageView ivTop = ivGen[1];
        ImageView ivBottom = ivGen[2];
        ImageView ivHead = ivGen[3];

        root.getChildren().clear();
        root.getChildren().addAll(ivBsm, ivHead, ivHands, ivBottom,
                ivTop, ivHat, ivHat1, ivHat2, ivHat3, ivTop1, ivTop2,
                ivTop3, ivBottom1, ivBottom2, ivBottom3, btnHat1, btnHat2,
                btnHat3, btnTop1, btnTop2, btnTop3, btnBottom1, btnBottom2,
                btnBottom3, btnBack, btnSave);
    }
}
