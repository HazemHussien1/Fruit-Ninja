package main;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.GameModel;
import view.GameViewManager;
import view.ViewManager;

public class MenuController {
    ViewManager viewManager;
    public MenuController(ViewManager viewManager, Stage stage){
        this.viewManager = viewManager;
        stage = viewManager.getMainStage();
        stage.show();

        viewManager.addScoresBtnEventHandler(buttonHandlerForScores);
        viewManager.addCloseBtnHandler(buttonHandlerForClose);
        viewManager.addStartBtnEventHandler(buttonHandlerForStart);
    }



    EventHandler<Event> buttonHandlerForScores = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            viewManager.showOrHideSubscene();
            viewManager.addScoresNames();
        }
    };

    EventHandler<Event> buttonHandlerForClose = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            viewManager.showOrHideSubscene();
        }
    };

    EventHandler<Event> buttonHandlerForStart = new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
           // viewManager.closeMainStage();
            GameViewManager gameViewManager = new GameViewManager();
            GameModel gameModel = new GameModel() ;

            GameController gameController = new GameController(gameModel , gameViewManager);

        }
    };




}

