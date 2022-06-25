package model;

abstract public class Fruit  extends GameObject{

    public int numberOfPointsAdded;
    public boolean increasesLives;

    private String path;

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIncreasesLives() {
        return increasesLives;
    }

    public void setIncreasesLives(boolean increasesLives) {
        this.increasesLives = increasesLives;
    }

    public int getNumberOfPointsAdded() {
        return numberOfPointsAdded;
    }

    public void setNumberOfPointsAdded(int numberOfPointsAdded) {
        this.numberOfPointsAdded = numberOfPointsAdded;
    }

    public String getImage(){
        //Allows you to chose an image (represented by a String path to a file).
        // This is not abstract, but you should still override it so each of your fruits has its own image.
        // (Hint: check out the Constants class for help with this)
        return "not yet implemented";
    }
    public void chopGraphically(){
        //Graphically chops the fruit by making the fruit image appear more transparent.
    }
    public void wash(){
        //Graphically makes the fruit appear less dirty.
    }
    public void ripen(){
        //Graphically makes fruits appear less shrunken
    }
    public void splash(){
        //Creates a splash on the screen at the fruit’s last position. When might you want to call this method?
    }


}
