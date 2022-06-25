package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ViewManager;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        ViewManager viewManager = ViewManager.getInstance();
        MenuController menuController = new MenuController(viewManager, stage);

    }
}
