package main;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.GameModel;
import model.GameObject;
import view.GameViewManager;

import java.util.List;

public class GameController {

    private GameViewManager gameViewManager;
    private GameModel gameModel;

    private List<GameObject> gameObjects;
    private List<ImageView> lives ;
    private Stage gameStage;


    public GameController(GameModel gameModel , GameViewManager gameViewManager){
        this.gameModel = gameModel;
        this.gameViewManager = gameViewManager;

        //gameObjects list is created in constructor of GameModel
        gameObjects = gameModel.getGameObjects();
        gameViewManager.setGameObjects(gameObjects);

        lives = gameModel.getLives();
        gameViewManager.setLives(lives);

        //gameViewManager.setGameController(this);

        gameStage = gameViewManager.getGameStage();
        gameStage.show();

        gameViewManager.createGameLoop();

    }
    public void setUsernameInScores(String name){
        gameModel.addUserToScores(name);

    }
    EventHandler<Event> closeGameHandler = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
           gameStage.close();

        }
    };

}