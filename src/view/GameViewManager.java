package view;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.FruitButton;
import model.FruitSubscene;
import model.GameObject;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameViewManager {
   private main.GameController gameController;

    private final String FONT_PATH = "view/uipack_fixed/Font/kenvector_future.ttf";
    private Stage gameStage;
    private AnchorPane gamePane;
    private Scene gameScene;

    private AnimationTimer gameTimer;

    private List<GameObject> gameObjects;
    private List<ImageView> fruitImages;
    private List<ImageView> bombImages;
    private List<ImageView> lives;

    private FruitSubscene promptUser;
    private FruitButton enterUsernameBtn;
    private TextField usernameTextfield;
    private Label enterUsername;

    private Random random = new Random();
    private final static String BACKGROUND_PATH  = "view/assets/bck2.jpg";

    private final static int GAME_HEIGHT = 800;
    private final static int GAME_WIDTH = 1000;

    private Label pointsLabel;
    private static int numberOfPoints = 0;

    public GameViewManager(){

        initializeStage();
        putBackground();

    }



    /**
     * Start the animation timer and call methods every frame
     */
    public void createGameLoop(){
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                moveGameElements();
                checkIfGameObjectsAreOutsideScreen();
                detectChopping();
            }
        };
        gameTimer.start();
    }

    /**
     * Detect user chopping fruits and bombs
     */
    private void detectChopping(){
        for(int i=0;i<fruitImages.size();++i){
            gamePane.setOnDragDetected(e -> gamePane.startFullDrag());
            int k = i;
            fruitImages.get(i).setOnMouseDragEntered(e -> choppedFruit(fruitImages.get(k)));
        }

            gamePane.setOnDragDetected(e -> gamePane.startFullDrag());

            bombImages.get(0).setOnMouseDragEntered(e -> choppedBomb(bombImages.get(0)));
            bombImages.get(1).setOnMouseDragEntered(e -> endGameAndPromptUser());
             bombImages.get(2).setOnMouseDragEntered(e -> choppedBomb(bombImages.get(2)));
             bombImages.get(3).setOnMouseDragEntered(e -> endGameAndPromptUser());
    }

    /**
     * When the user chops a death bomb this method prompts
     * the user for his name so that the score can be saved.
     */
    private void endGameAndPromptUser(){
        promptUser = new FruitSubscene();
        enterUsernameBtn = new FruitButton("Submit");
        usernameTextfield = new TextField();
        enterUsername = new Label("Enter username please");

        enterUsername.setFont(Font.font("Verdana", FontWeight.BOLD, 23));

        enterUsername.setLayoutX(100);
        enterUsername.setLayoutY(100);

        usernameTextfield.setLayoutX(100);
        usernameTextfield.setLayoutY(150);

        usernameTextfield.setPrefHeight(50);
        usernameTextfield.setPrefWidth(230);

        usernameTextfield.setFont(Font.font("Verdana", FontWeight.BOLD, 18));

        enterUsernameBtn.setLayoutX(350);
        enterUsernameBtn.setLayoutY(150);

        promptUser.setLayoutX(100);
        promptUser.setLayoutY(100);

        promptUser.getPane().getChildren().addAll(usernameTextfield,enterUsernameBtn,enterUsername);
        gamePane.getChildren().add(promptUser);

        enterUsernameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                gameStage.close();
                System.out.println(usernameTextfield.getText());
                //gameController.setUsernameInScores(usernameTextfield.getText());
            }
        });

    }

    /**
     * When the user enters username and clicks submit
     * the game stage should close
     */


    /**
     * called when a bomb is chopped , it repositions the bomb at the top of the screen and decreases the lives count
     * @param bombImage image of the chopped bomb
     */
    private void choppedBomb(ImageView bombImage){
        setGameObjectsPos(bombImage);
        decreaseLives();
    }

    /**
     * called when a fruit is chopped , it repositions the fruit and increase the number of points
     * @param fruitImage image of the chopped fruit
     */
    private void choppedFruit(ImageView fruitImage){
        setGameObjectsPos(fruitImage);
        numberOfPoints++;
        updatePointsLabel();
    }

    /**
     * decreases the number of lives by one
     */
    private void decreaseLives(){
        if(lives.size() == 1){
            gameStage.close();
        }else {
            removeLives(lives);
            lives.remove(lives.get(lives.size()-1));
            addLivesToPane(lives);
        }
    }

    /**
     * move all game objects downwards and rotate them
     */
    private void moveGameElements(){
        double randomRotateAngle = random.nextDouble();

        for(int i=0;i<fruitImages.size();++i){
            fruitImages.get(i).setLayoutY(fruitImages.get(i).getLayoutY() + 0.7);
            fruitImages.get(i).setRotate(fruitImages.get(i).getRotate() + randomRotateAngle);
        }
        for(int i=0;i<bombImages.size();++i){
            bombImages.get(i).setLayoutY(bombImages.get(i).getLayoutY() + 1.2);
            bombImages.get(i).setRotate(bombImages.get(i).getRotate() + randomRotateAngle);
        }
    }


    /**
     * Repositions Game objects that are outside the screen.
     */
    private void checkIfGameObjectsAreOutsideScreen(){
        for(int i=0;i<fruitImages.size();++i){
            if(fruitImages.get(i).getLayoutY() > 800){
                setGameObjectsPos(fruitImages.get(i));
            }
        }

        for(int i=0;i<bombImages.size();++i){
            if(bombImages.get(i).getLayoutY() > 800){
                setGameObjectsPos(bombImages.get(i));
            }
        }
    }


    /**
     * this function positions the image at the starting positions ready to be thrown
     * @param gameObjectImage the image of the objects that needs to be positioned/repositioned
     */
    public void setGameObjectsPos(ImageView gameObjectImage){
        gameObjectImage.setFitHeight(100);
        gameObjectImage.setFitWidth(100);
        gameObjectImage.setPreserveRatio(true);

        int randomXPosition = random.nextInt(800);
        int randomYPosition = random.nextInt(1800);
        int randomXHelper = random.nextInt(60);
        gameObjectImage.setLayoutX(randomXPosition + randomXHelper);
        gameObjectImage.setLayoutY(-randomYPosition);

    }

    private void putBackground(){
        Image backImage = new Image(BACKGROUND_PATH,1080,1080, false,true);
        BackgroundImage backgroundImage = new BackgroundImage(backImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT , null );
        gamePane.setBackground(new Background(backgroundImage));
    }

    /**
     * initializes the stage and pane and scene
     */
    private void initializeStage(){
        gameStage = new Stage();
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane,GAME_WIDTH,GAME_HEIGHT);
        gameStage.setScene(gameScene);
        addPointsLabel();
    }

    /**
     * Adds the points label to the pane
     */
    private void addPointsLabel(){
        pointsLabel = new Label("Points: " + String.valueOf(numberOfPoints));
        gamePane.getChildren().add(pointsLabel);
        pointsLabel.setLayoutY(10);
        pointsLabel.setLayoutX(10);
        pointsLabel.setPrefHeight(50);
        pointsLabel.setPrefWidth(300);
        pointsLabel.setTextFill(Color.web("#0076a3"));
        try {
            pointsLabel.setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));

        }catch (Exception e){
            pointsLabel.setFont(Font.font("Verdana" , 23));
        }
    }

    /**
     * Update the points label when a fruit is chopped
     */
    private void updatePointsLabel(){
        pointsLabel.setText("Points: " + String.valueOf(numberOfPoints));
    }


    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;

        //I am calling the buildImagesLists once i get the list of game objects
        buildImagesLists( gameObjects );
    }


    /**
     * this method builds the lists for the fruits , bombs.
     * @param gameObjects is the list of game objects
     */
    private void buildImagesLists(List<GameObject> gameObjects){
        fruitImages = new ArrayList<>();
        bombImages = new ArrayList<>();

        for(GameObject go : gameObjects){

            String gameObjectType = go.getType();

            if(gameObjectType.equals("banana") || gameObjectType.equals("lemon") || gameObjectType.equals("watermelon") || gameObjectType.equals("pineapple") ){

                ImageView fruitImage = new ImageView(go.getPath());
                fruitImages.add(fruitImage);
            }else {
                ImageView bombImage = new ImageView(go.getPath());
                bombImages.add(bombImage);
            }
        }
        addFruitsAndBombsToPane();
    }


    /**
     * Adds Fruits and Bomb images to the pane and sets their initial position
     */
    private void addFruitsAndBombsToPane(){
        for(int i =0;i<fruitImages.size();++i){
            gamePane.getChildren().add(fruitImages.get(i));
            setGameObjectsPos(fruitImages.get(i));
        }
        for(int i =0;i<bombImages.size();++i){
            gamePane.getChildren().add(bombImages.get(i));
            setGameObjectsPos(bombImages.get(i));
        }
    }

    /**
     * Adds the lives images to the pane
     * @param lives list of images of lives
     */
    private void addLivesToPane(List<ImageView> lives){
        for(int i=0;i<lives.size();++i){
            gamePane.getChildren().add(lives.get(i));
            lives.get(i).setLayoutY(10);
            lives.get(i).setLayoutX(900 + (20*i));
        }
    }

    private void removeLives(List<ImageView> lives){
        for(int i=0;i<lives.size();++i){
            gamePane.getChildren().remove(lives.get(i));
        }
    }

    public Stage getGameStage() {
        return gameStage;
    }

    public void setGameStage(Stage gameStage) {
        this.gameStage = gameStage;
    }

    public void setLives(List<ImageView> lives) {
        this.lives = lives;
        addLivesToPane(lives);
    }

    public void setGameController(main.GameController gameController){
        this.gameController = gameController;
    }

}
