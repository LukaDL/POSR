/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * This is the main screen that shows the user's avatar, scene and vehicle
 * @author Luka_
 */
public class MainScreen {

    MainScreen() {

    }

    MainScreen(Stage primaryStage, PosrScene posr) {
        this.primaryStage = primaryStage;
        this.posr = posr;
    }

    // Creating PosrScene object
    PosrScene posr = new PosrScene();

    // Creating a stage variable to be passed in to have access to main program
    // stage.
    Stage primaryStage = new Stage();

    // Setting default values for the styles
    int top = 1, bottom = 1, hat = 1;
    String gender = "";

    // Getting all images from an array list
    ImageView[] ivImages = createImages();

    // Setting all scene variables
    
    // Setting default background
    ImageView ivBsm = ivImages[0];

    // Setting default head
    ImageView ivHead = ivImages[1];

    // Setting default hands       
    ImageView ivHands = ivImages[2];

    // Avatar items
    ImageView ivHat = ivImages[3];
    ImageView ivTop = ivImages[4];
    ImageView ivBottom = ivImages[5];

    // Getting vehicle
    ImageView ivVehicle = ivImages[6];

    // Getting scenery
    ImageView ivScenery = ivImages[7];

    Pane root = new Pane();

    // Creating Buttons
    Button btnAvatar = new Button();
    Button btnGallery = new Button();
    Button btnVehicle = new Button();
    Button btnScenery = new Button();
    Button btnSave = new Button();

    public Scene mainScene() {

        // Creating all buttons
        btnAvatar.setText("Appearance");
        btnGallery.setText("Gallery");
        btnVehicle.setText("Vehicle");
        btnScenery.setText("Change Background");
        btnSave.setText("Save");

        // Creating event listeners
        btnAvatar.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnGallery.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnVehicle.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnScenery.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        btnSave.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Adding all GUI items to the scene
        root.getChildren().addAll(ivScenery, ivVehicle, ivBsm, ivHead, ivHands, ivBottom,
                ivTop, ivHat, btnAvatar, btnGallery,
                btnVehicle, btnScenery, btnSave);

        // Setting the button layouts
        btnAvatar.setLayoutX(125);
        btnAvatar.setLayoutY(560);

        btnGallery.setLayoutX(180);
        btnGallery.setLayoutY(605);

        btnVehicle.setLayoutX(240);
        btnVehicle.setLayoutY(262);

        btnScenery.setLayoutX(130);
        btnScenery.setLayoutY(80);

        btnSave.setLayoutX(375);
        btnSave.setLayoutY(560);

        btnGallery.setPrefWidth(100);
        btnGallery.setPrefHeight(40);

        btnScenery.setPrefWidth(200);
        btnScenery.setPrefHeight(30);
        updateScene();

        // Creating the scene using the standard app size
        Scene scene = new Scene(root, 450, 652);

        // Returning the scene to the calling class
        return scene;
    }

    /**
     * Creating all the images used in the Main Screen interface
     * @return returns all the images used in the main screen interface
     */
    public ImageView[] createImages() {

        // Creating an array that will return all images
        ivImages = new ImageView[8];

        // Initilizing all ImageViews
        for (int i = 0; i < ivImages.length; i++) {
            ivImages[i] = new ImageView();
        }

        // Setting default background
        Image imgBsmBackground = new Image("file:images\\MainMenu\\posrBackground.png");
        ivImages[0].setImage(imgBsmBackground);

        // Setting default head
        Image imgHead = new Image("file:images\\MainMenu\\Person\\Head" + posr.getGender() + ".png");
        ivImages[1].setImage(imgHead);

        // Setting default hands       
        Image imgHands = new Image("file:images\\MainMenu\\Person\\HandsH" + 1 + ".png");
        ivImages[2].setImage(imgHands);

        // image for hat  
        Image imgHat = new Image("file:images\\MainMenu\\Person\\Hat\\Hat" + posr.getHat() + ".png");
        ivImages[3].setImage(imgHat);

        // image for top
        Image imgTop = new Image("file:images\\MainMenu\\Person\\Top\\Top" + posr.getTop() + ".png");
        ivImages[4].setImage(imgTop);

        // image for bottom
        Image imgBottom = new Image("file:images\\MainMenu\\Person\\Bottom\\Bottom" + posr.getBottom() + ".png");
        ivImages[5].setImage(imgBottom);

        // image for vehicle
        Image imgVehicle = new Image("file:images\\MainMenu\\Vehicle\\Vehicle" + posr.getVehicle() + ".png");
        ivImages[6].setImage(imgVehicle);

        // image for scenery
        Image imgScenery = new Image("file:images\\MainMenu\\Scenery\\Scenery" + posr.getLocation() + ".png");
        ivImages[7].setImage(imgScenery);

        return ivImages;
    }

    public void eventsCode(ActionEvent e) throws Exception {

        // This button will go to the gender select scene
        if (e.getSource() == btnAvatar) {
            GenderSelect gsm = new GenderSelect(primaryStage, posr);
            Scene sceneGsm = gsm.gsmScene();
            primaryStage.setScene(sceneGsm);
        }
        // This button will go to the gallery scene
        if (e.getSource() == btnGallery) {
            Gallery gallery = new Gallery(primaryStage, posr);
            Scene sceneGallery = gallery.galStage();
            primaryStage.setScene(sceneGallery);
        }
        // This button will go to the vehicle scene
        if (e.getSource() == btnVehicle) {
            VehicleSelect vsm = new VehicleSelect(primaryStage, posr);
            Scene sceneVehicle = vsm.vsmStage();
            primaryStage.setScene(sceneVehicle);
        }

        // This button will go to the Scenery scene
        if (e.getSource() == btnScenery) {
            ScenerySelect ssm = new ScenerySelect(primaryStage, posr);
            Scene sceneScenery = ssm.ssmStage();
            primaryStage.setScene(sceneScenery);
        }

        // This button will save the scene
        if (e.getSource() == btnSave) {
            try {
                saveScene();
            } catch (IOException ex) {
                System.out.println("There was an error saving.");
            }
        }
    }

    /**
     * This method is needed to update the user avatar
     */
    public void updateScene() {
        ivImages = createImages();

        // Setting background
        ivBsm = ivImages[0];

        // Setting head
        ivHead = ivImages[1];

        // Setting hands       
        ivHands = ivImages[2];

        // Avatar items
        ivHat = ivImages[3];
        ivTop = ivImages[4];
        ivBottom = ivImages[5];

        // Getting vehicle
        ivVehicle = ivImages[6];

        // Getting scenery
        ivScenery = ivImages[7];

        root.getChildren().clear();
        root.getChildren().addAll(ivScenery, ivVehicle, ivBsm, ivHead, ivHands, ivBottom,
                ivTop, ivHat, btnAvatar, btnGallery,
                btnVehicle, btnScenery, btnSave);
    }

    /**
     * This method takes the current scene and saves it in the text file
     * @throws IOException
     * @throws Exception 
     */
    public void saveScene() throws IOException, Exception {

        // Creating Boolean value for overwritting file purposes
        int overwrite = -1;
        
        String searchName = "";
        // Creating a dialog input box to save the name of the scene
        while (true) {
            TextInputDialog input = new TextInputDialog();
            input.setTitle("Save Scene");
            input.setHeaderText(null);
            input.setContentText("Enter Scene Name: ");

            Optional<String> result1 = input.showAndWait();

            // Ensuring the user didn't leave the text field blank
            if (!result1.get().isEmpty()) {
                // Does not allow for spaces in name
                String name = result1.get().replace(' ', '_');
                // This checks if the scene name is unused.  If so it will alert
                // the user that the file is save successfully
                if (!sceneNameExists(name)) {
                    // Informs user that the file has been saved
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    overwrite = 0;
                    alert.setTitle("Scene Saved");
                    alert.setContentText("Scene Name: " + name);
                    posr.setSceneName(name);
                    alert.show();
                    break;
                } // If the scene name is used, the user is prompted if they would
                // like to overwrite the file
                else {
                    // Asks the user if they would like to overwrite the file.
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Scene Name Exists");
                    alert.setContentText("Scene Name: " + name + " Exists\nWould"
                            + " you like to overwrite the file?");
                    // Getting user to confirm if they want to overwrite an existing
                    // scene entry.
                    Optional<ButtonType> result2 = alert.showAndWait();
                    
                    if (result2.get() == ButtonType.OK) {
                        System.out.println("Overwritting..");
                        posr.setSceneName(name);
                        // Setting the overwrite code to overwrite file
                        overwrite = 1;
                        searchName = name;
                    }
                    break;
                }
            }
        }

        File file = new File("sceneList/savedScenes.txt");
        
        // This overwrite code means write a new name to file
        if (overwrite == 0) {
            try {
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter write = new PrintWriter(bw);
                write.print(posr.toString());
                write.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } 
        // Overwrites the file
        else if(overwrite == 1){
            overwriteScene(searchName);
        }
    }

    /**
     * Checks to see if the scene name has been used
     * @param sceneName The scene name that will check if it is used already
     * @return returns a boolean value if the name has been used already
     * @throws Exception 
     */
    public Boolean sceneNameExists(String sceneName) throws Exception {
        // Getting file and loading it as an input
        File file = new File("sceneList/savedScenes.txt");
        Boolean nameFound = false;
        Scanner input = new Scanner(file);
        // If the file containing scene information exists this command executes
        if (file.exists()) {
            // Loops through each line of the code.
            while (input.hasNext()) {
                // Stores the values from the text file to local variables
                String name = input.next();
                int location = input.nextInt();
                int vehicle = input.nextInt();
                String gender = input.next();
                int hat = input.nextInt();
                int top = input.nextInt();
                int bottom = input.nextInt();

                // If the name is found in the text file, the values are loaded
                // into the PosrScene.
                if (name.equals(sceneName)) {
                    nameFound = true;
                }
            }
            //Close the file
            input.close();
        } else {
            System.out.println("The file does not exist");
        }
        return nameFound;
    }
    
    /**
     * Overwrites the found scene name
     * @param sceneName the name which the user is overwriting
     * @return returns if the name has been overwritten
     * @throws Exception 
     */
    public boolean overwriteScene(String sceneName) throws Exception {

        // Getting file and loading it as an input
        File readFile = new File("sceneList/savedScenes.txt");
        // Creating a temporary file that will replace the current save file
        File writeFile = new File("sceneList/tempScenes.txt");
        PrintWriter write = new PrintWriter(writeFile);
        boolean nameFound = false;
        Scanner input = new Scanner(readFile);
        PosrScene posrLine = new PosrScene();
        String lineDelete = "notfound";
        // If the file containing scene information exists this command executes
        if (readFile.exists()) {
            // Loops through each line of the code.
            while (input.hasNext()) {
                // Stores the values from the text file to local variables
                String name = input.next();
                int location = input.nextInt();
                int vehicle = input.nextInt();
                String gender = input.next();
                int hat = input.nextInt();
                int top = input.nextInt();
                int bottom = input.nextInt();

                // Setting posrScene variables
                posrLine.setSceneName(name);
                posrLine.setLocation(location);
                posrLine.setVehicle(vehicle);
                posrLine.setGender(gender);
                posrLine.setHat(hat);
                posrLine.setTop(top);
                posrLine.setBottom(bottom);

                // If the name is found in the text file, the values stay the
                // same. Otherwise it will overwrite the name with the currently
                // set up posrScene.
                if (!name.equals(sceneName)) {
                    write.print(posrLine.toString());
                } else {
                    nameFound = true;
                    write.print(posr.toString());
                }
            }
            // Close the write file
            write.close();
            // Close the read file
            input.close();
        } else {
            System.out.println("The file does not exist");
        }
        // Deleting the savedScenes file
        readFile.delete(); // File permission problems are caught here.
        // Renaming the temp file to saveScenes.txt
        writeFile.renameTo(readFile);
        
        // returning if a file has been erased
        return nameFound;
    }
}
