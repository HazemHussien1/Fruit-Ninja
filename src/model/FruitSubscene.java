package model;

import javafx.animation.TranslateTransition;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class FruitSubscene extends SubScene {

    private final String FONT_PATH = "view/uipack_fixed/Font/kenvector_future.ttf";
    private final String BACKGROUND_PATH = "view/uipack_fixed/PNG/yellow_panel.png";


    private boolean isHidden ;
    public FruitSubscene() {
        super(new AnchorPane(), 600, 400);

        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_PATH,600,400,false,true),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null);

        AnchorPane root = (AnchorPane) this.getRoot();
        root.setBackground(new Background(backgroundImage));



        setLayoutX(1024);
        setLayoutY(180);

        isHidden = false ;

    }

    public void moveSubscene(){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.3));
        transition.setNode(this);

        if(isHidden){
            isHidden = false ;
            transition.setToX(-850);
        }else {
            transition.setToX(850);
            isHidden = true;
        }
        transition.play();
    }

    public AnchorPane  getPane(){
        return (AnchorPane) this.getRoot();
    }


}
