package model;

import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class GameModel  {
    // game sprites are in src/view/assets
    private List<GameObject> gameObjects ;
    private List<ImageView> lives ;
    private ImageView life ;

    private List<String> scoresNames;

    BombFactory bombFactory;
    FruitFactory fruitFactory;

    public GameModel(){

        fruitFactory = new FruitFactory();
        bombFactory = new BombFactory();
        gameObjects = new ArrayList<>();

        scoresNames = new ArrayList<>();

        createGameObjects();
        createLivesList();
    }
    private void createLivesList(){
        lives = new ArrayList<>();
        for(int i=0;i<3;++i){
            life = new ImageView("view/assets/life.png");
            lives.add(life);
        }
    }

    public List<ImageView> getLives() {
        return lives;
    }

    public void setLives(List<ImageView> lives) {
        this.lives = lives;
    }

    /**
     * Creates the list gameObjects that consists of fruits and bombs
     */
    public void createGameObjects(){
        for(int i=0;i<2;++i){
            gameObjects.add(fruitFactory.createFruit("banana"));
            gameObjects.add(fruitFactory.createFruit("lemon"));

            gameObjects.add(bombFactory.createBomb("lifeBomb"));

            gameObjects.add(new AddLife(fruitFactory.createFruit("pineapple")));
            gameObjects.add(new AddPoints(fruitFactory.createFruit("watermelon")));

            gameObjects.add(bombFactory.createBomb("deathBomb"));
        }
    }
    public void addUserToScores(String name){
        scoresNames.add(name);

    }

    public List<String> getScoresNames() {
        return scoresNames;
    }

    public void setScoresNames(List<String> scoresNames) {
        this.scoresNames = scoresNames;
    }

    public List<GameObject> getGameObjects(){
        return gameObjects;
    }

}
