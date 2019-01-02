/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * This class displays the names of pre-created scenes
 * @author Luka_
 */
public class Gallery {

    // Creating PosrScene object
    PosrScene posr = new PosrScene();

    // Creating Pane
    Pane root = new Pane();

    // Creating buttons
    Button btnOpen = new Button();
    Button btnDelete = new Button();
    Button btnBack = new Button();
    Button btnClear = new Button();

    // Creating a stage variable to be passed in to have access to main program
    // stage.
    Stage primaryStage = new Stage();

    // Creating label for all the files
    Label lblPosrSaves = new Label();

    // Creating Text Area to show the names of all the pictures saved
    TextArea txaPosrSaves = new TextArea();

    // Getting all the images that will remain static on the Scene
    ImageView galleryMenu = new ImageView();

    Gallery() {

    }

    Gallery(Stage primaryStage, PosrScene posr) {
        this.primaryStage = primaryStage;
        this.posr = posr;
    }

    public Scene galStage() throws Exception {

        // Setting default background
        Image imgGalleryBackground = new Image("file:images\\Gallery\\galBackground.png");
        galleryMenu.setImage(imgGalleryBackground);

        // Setting label for the saved files
        lblPosrSaves.setText("List of saved scenes");

        // Setting content of the text area
        getSaves();

        // Setting button attributes
        btnOpen.setText("Open");
        btnDelete.setText("Delete");
        btnBack.setText("Back");
        btnClear.setText("Clear");

        // Setting event handler on the open button
        btnOpen.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(Gallery.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Setting event handler on the delete button
        btnDelete.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(Gallery.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Setting event handler on the back button
        btnBack.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(Gallery.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        // Setting event handler on the clear button
        btnClear.setOnAction(e -> {
            try {
                eventsCode(e);
            } catch (Exception ex) {
                Logger.getLogger(Gallery.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().addAll(galleryMenu, lblPosrSaves, txaPosrSaves, btnOpen, btnDelete, btnBack, btnClear);

        // Setting Label Style
        lblPosrSaves.setLayoutX(40);
        lblPosrSaves.setLayoutY(100);
        lblPosrSaves.setFont(Font.font("Arial", FontWeight.LIGHT, FontPosture.REGULAR, 20));
        lblPosrSaves.setTextFill(Paint.valueOf("white"));

        // Setting Text Area Style
        txaPosrSaves.setDisable(true);
        txaPosrSaves.setPrefWidth(400);
        txaPosrSaves.setPrefHeight(400);
        txaPosrSaves.setLayoutX(25);
        txaPosrSaves.setLayoutY(140);
        txaPosrSaves.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24));

        // Setting Open Button Style
        btnOpen.setLayoutX(320);
        btnOpen.setLayoutY(550);
        btnOpen.setPrefWidth(80);
        btnOpen.setPrefHeight(20);

        // Setting Delete Button Style
        btnDelete.setLayoutX(50);
        btnDelete.setLayoutY(600);
        btnDelete.setPrefWidth(80);
        btnDelete.setPrefHeight(20);

        // Setting Back Button Style
        btnBack.setLayoutX(50);
        btnBack.setLayoutY(550);
        btnBack.setPrefWidth(80);
        btnBack.setPrefHeight(20);

        // Setting Clear Button Style
        btnClear.setLayoutX(185);
        btnClear.setLayoutY(550);
        btnClear.setPrefWidth(80);
        btnClear.setPrefHeight(20);

        Scene scene = new Scene(root, 450, 652);

        return scene;
    }

    public void eventsCode(ActionEvent e) throws Exception {
        // Opening the selected image
        if (e.getSource() == btnOpen) {
            String name;
            // Creating a dialog input box to save the name of the scene
            while (true) {
                TextInputDialog input = new TextInputDialog();
                input.setTitle("Load Scene");
                input.setHeaderText(null);
                input.setContentText("Enter Scene to Load: ");

                Optional<String> result = input.showAndWait();

                // Checking to see if the user inputted a file name
                if (!result.get().isEmpty()) {
                    name = result.get();
                    Boolean nameFound = loadScene(name);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    if (nameFound) {
                        alert.setTitle("Scene Loaded");
                        alert.setContentText("Scene is loaded");
                    } else {
                        alert.setTitle("Scene Fail");
                        alert.setContentText("Scene failed to load");
                    }
                    alert.show();
                    break;
                }
            }
        }

        // Opening the selected image
        if (e.getSource() == btnDelete) {
            String name;
            // Creating a dialog input box to save the name of the scene
            while (true) {
                TextInputDialog input = new TextInputDialog();
                input.setTitle("Delete Scene");
                input.setHeaderText(null);
                input.setContentText("Enter Scene to Delete: ");

                Optional<String> result = input.showAndWait();

                // Checking to see if the user inputted a scene name
                if (!result.get().isEmpty()) {
                    name = result.get();
                    boolean nameFound = deleteScene(name);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    if (nameFound) {
                        alert.setTitle("Scene Deleted");
                        alert.setContentText("Scene was deleted");
                    } else {
                        alert.setTitle("Scene Fail");
                        alert.setContentText("Scene failed to delete");
                    }
                    alert.show();
                    break;
                }
            }
        }

        // Saving and going back to main menu
        if (e.getSource() == btnBack) {
            MainScreen mainScreen = new MainScreen(primaryStage, posr);
            Scene sceneMain = mainScreen.mainScene();
            primaryStage.setScene(sceneMain);
        }

        // Clearing saved scenes
        if (e.getSource() == btnClear) {
            clearSaves();
        }

    }

    /**
     * Adds the saved names in the savedScenes.txt file
     * @throws Exception 
     */
    public void getSaves() throws Exception {
        File file = new File("sceneList/savedScenes.txt");
        txaPosrSaves.clear();
        Scanner input = new Scanner(file);
        if (file.exists()) {
            while (input.hasNext()) {
                String name = input.next();
                int location = input.nextInt();
                int vehicle = input.nextInt();
                String gender = input.next();
                int hat = input.nextInt();
                int top = input.nextInt();
                int bottom = input.nextInt();
                txaPosrSaves.appendText(name + "\n");
            }
            //Close the file
            input.close();
        } else {
            System.out.println("The file does not exist");
        }
    }

    /**
     * This method allows to the user to load a saved scene and returns a
     * boolean value on whether or not the file name exists.
     *
     * @param sceneName the passed String of the scene name that will be used to
     * check if the filename exists
     * @return The status of the filename existing is returned
     * @throws Exception If there is any problem with the file retrieval an
     * exception is thrown
     */
    public Boolean loadScene(String sceneName) throws Exception {
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
                    posr.setSceneName(name);
                    posr.setLocation(location);
                    posr.setVehicle(vehicle);
                    posr.setGender(gender);
                    posr.setHat(hat);
                    posr.setTop(top);
                    posr.setBottom(bottom);
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
     * Clears all the saved scenes
     * @throws FileNotFoundException 
     */
    public void clearSaves() throws FileNotFoundException {
        File file = new File("sceneList/savedScenes.txt");
        PrintWriter write = new PrintWriter(file);
        write.print("");
        write.close();
        txaPosrSaves.setText("");
    }

    /**
     * This code will delete an entered entry from the text file and update it
     * in this scene.
     * @param sceneName The name of the scene to delete
     * @return a boolean value indicating if the name was deleted.
     * @throws Exception 
     */
    public boolean deleteScene(String sceneName) throws Exception {

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

                // If the name is found in the text file, the values are loaded
                // into the PosrScene.
                if (!name.equals(sceneName)) {
                    write.print(posrLine.toString());
                } else {
                    nameFound = true;
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
        // repopulating text area
        getSaves();
        // returning if a file has been erased
        return nameFound;
    }
}
