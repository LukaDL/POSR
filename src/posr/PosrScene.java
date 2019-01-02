
package posr;

import java.util.ArrayList;

/**
 * This class creates all variables needed for a POSR Scene
 * @author Luka_
 */
public class PosrScene {
    
    // Creating the variables for a POSR Scene
    private int hat, top, bottom, location, vehicle;
    private String gender;
    private String sceneName = "";
    
    ArrayList<PosrScene> posrs = new ArrayList<>();
    
    /**
     * The default constructor for the avatar
     */
    PosrScene(){
        hat = 1;
        top = 1;
        bottom = 1;
        location = 1;
        vehicle = 1;
        gender = "M1";
        sceneName = "Default";
    }
    
    /**
     * Constructor for an avatar with all needed parameters
     * @param hat this int indicates which hat to be used on this avatar
     * @param top this int indicates which top to be used on this avatar
     * @param bottom this int indicates which bottom to be used on this avatar
     * @param gender  this int indicates the gender of this avatar
     */
    PosrScene(int hat, int top, int bottom, int location, int vehicle, String gender){
        this.hat = hat;
        this.top = top;
        this.bottom = bottom;
        this.location = location;
        this.vehicle = vehicle;
        this.gender = gender;
    }

    /**
     * Get the value of the location
     * @return returns the location value
     */
    public int getLocation() {
        return location;
    }

    /**
     * Set the value of the location
     * @param location this int indicates which location to be used in this scene
     */
    public void setLocation(int location) {
        this.location = location;
    }

    /**
     * Get the value of the vehicle
     * @return returns the vehicle value
     */
    public int getVehicle() {
        return vehicle;
    }

    /**
     * Set the value of the vehicle
     * @param vehicle this int indicates which vehicle to be used in this scene
     */
    public void setVehicle(int vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Get the value of the hat
     * @return returns the hat value
     */
    public int getHat() {
        return hat;
    }
    
    /**
     * Set the value of the hat
     * @param hat this int indicates which hat to be used on this avatar
     */
    public void setHat(int hat) {
        this.hat = hat;
    }

    /**
     * Get the value of the top
     * @return returns the top value
     */
    public int getTop() {
        return top;
    }

    /**
     * Set the value of the top
     * @param top this int indicates which top to be used on this avatar
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * Get the value of the bottom
     * @return returns the bottom value
     */
    public int getBottom() {
        return bottom;
    }

    /**
     * Set the value of the bottom
     * @param bottom this int indicates which bottom to be used on this avatar
     */
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }

    /**
     * Get the value of the gender
     * @return returns the gender string value
     */
    public String getGender() {
        return gender;
    }

    /**
     * Set the value of the gender
     * @param gender this String indicates which gender this avatar is
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    /**
     * gets the name of the scene
     * @return the name of the scene is returned
     */
    public String getSceneName() {
        return sceneName;
    }

    /**
     * This method allows the user to set the name of the scene
     * @param sceneName this String is the name of the scene
     */
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }
    
    @Override
    public String toString(){
        String output = String.format("%-15s%-4d%-4d%-4s%-4d%-4d%-4d%n",
                sceneName, location, vehicle, gender, hat, top, bottom);
        return output;
    }
    
}
