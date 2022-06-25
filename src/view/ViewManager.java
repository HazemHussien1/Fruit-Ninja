package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.FruitButton;
import model.FruitSubscene;

import java.util.List;

public class ViewManager  {
    //This class will show main menu
    //uipack_fixed is in src/view/

    private static int helperInt = 0;
    private List<String> scoresNames;

    private Label firstName;
    private Label secondName;
    private Label thirdName;

    private Stage mainStage;
    private Scene mainScene;
    private AnchorPane mainPane;

    private FruitButton startBtn;
    private FruitButton scoresBtn;
    private FruitButton exitBtn;

    private FruitButton easyGame;
    private FruitButton mediumGame;
    private FruitButton hardGame;

    private FruitSubscene difficultySubscene;

    private boolean isShown = false;

    private FruitButton closeBtn;

    private FruitSubscene scoresSubscene;

    private  VBox vbox ;

    public static ViewManager viewManager;

    private ViewManager(){
        mainStage = new Stage();
        mainPane = new AnchorPane();

        mainScene = new Scene(mainPane,1000,1200);
        mainStage.setScene(mainScene);

        createMenuBtns();
        createScoresSubscene();
        createBackground();
        //createLogo();
    }

    public static ViewManager getInstance(){
        if(viewManager == null){
            synchronized (ViewManager.class) {
                if (viewManager == null) {
                    viewManager = new ViewManager();//instance will be created at request time
                }
            }
        }
        return viewManager;
    }




    public void createVBox(){
        vbox = new VBox(10);
    }

    private void createScoresSubscene(){
        scoresSubscene = new FruitSubscene();

        closeBtn = new FruitButton("CLOSE");
        closeBtn.setLayoutY(30);
        closeBtn.setLayoutX(350);
        scoresSubscene.getPane().getChildren().addAll(closeBtn);

        mainPane.getChildren().addAll(scoresSubscene);
    }

    public void addScoresNames(){
        if(scoresNames == null){
            Label noPlayersYet = new Label("There aren't any high scores now");
            scoresSubscene.getPane().getChildren().add(noPlayersYet);
            noPlayersYet.setFont(Font.font("Verdana", FontWeight.BOLD, 23));
            noPlayersYet.setLayoutY(130);
            noPlayersYet.setLayoutX(30);

        }else {
             firstName = new Label(" ");
             secondName = new Label(" ");
             thirdName = new Label(" ");
            if(scoresNames.size() > 3){
                for(int i=0;i<3;++i){
                    firstName.setText(scoresNames.get(0));
                    secondName.setText(scoresNames.get(1));
                    thirdName.setText(scoresNames.get(2));
                }
            }else if(scoresNames.size() == 2 ) {
                firstName.setText(scoresNames.get(0));
                secondName.setText(scoresNames.get(1));
            }else {
                firstName.setText(scoresNames.get(0));
            }
            addNamesToScoresSubscene();
        }
    }
    private void addNamesToScoresSubscene(){
        if(helperInt == 0){
            scoresSubscene.getPane().getChildren().addAll(firstName,secondName,thirdName);
            helperInt++;
        }
    }

    public void addCloseBtnHandler(EventHandler eventHandler){
        closeBtn.setOnAction(eventHandler);
    }

    public void showOrHideSubscene( ){
        scoresSubscene.moveSubscene();
    }

    public void closeMainStage(){
        mainStage.close();
    }

   private void createMenuBtns(){
        startBtn = new FruitButton("START");
        startBtn.setLayoutY(200);
        startBtn.setLayoutX(400);

       scoresBtn = new FruitButton("SCORES");
       scoresBtn.setLayoutY(300);
       scoresBtn.setLayoutX(400);

       exitBtn = new FruitButton("EXIT");
       exitBtn.setLayoutY(400);
       exitBtn.setLayoutX(400);

       exitBtn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
               mainStage.close();
           }
       });
       mainPane.getChildren().addAll(startBtn,scoresBtn,exitBtn);

   }
    private void createBackground(){
        Image backImage = new Image("view/assets/bck2.jpg",1080,1080, false,true);
        BackgroundImage backgroundImage = new BackgroundImage(backImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT , null );
        mainPane.setBackground(new Background(backgroundImage));

    }

    public Stage getMainStage(){
        return mainStage;
    }

   public  void addScoresBtnEventHandler(EventHandler eventHandler){
        scoresBtn.setOnAction(eventHandler);
    }

    public  void addStartBtnEventHandler(EventHandler eventHandler){
        startBtn.setOnAction(eventHandler);
    }

    public void setScoresNames(List<String> scoresNames){
        this.scoresNames = scoresNames;

    }

}