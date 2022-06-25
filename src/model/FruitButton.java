package model;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FruitButton extends Button {

    private final String FONT_PATH = "src/view/uipack_fixed/Font/kenvector_future.ttf";
    private final String BACKGROUND_FREE_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/view/uipack_fixed/PNG/yellow_button01.png')";
    private final String BACKGROUND_CLICKED_STYLE = "-fx-background-color: transparent; -fx-background-image: url('/view/uipack_fixed/PNG/yellow_button00.png')";



    public FruitButton(String text){
        setPrefHeight(50);
        setPrefWidth(200);
        setText(text);
        setBtnFont();
        setStyle(BACKGROUND_FREE_STYLE);
        initializeListeners();

    }

    private void initializeListeners(){
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setButtonClickedStyle();
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setButtonFreeStyle();
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new DropShadow());
            }
        });

        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(null);
            }
        });
    }

    private void setBtnFont(){
        try {
            setFont(Font.loadFont(new FileInputStream(FONT_PATH), 23));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana" , 23));
        }
    }

    private void setButtonFreeStyle(){
        setStyle(BACKGROUND_FREE_STYLE);
        setPrefHeight(50);
    }

    private void setButtonClickedStyle(){
        setStyle(BACKGROUND_CLICKED_STYLE);
        setPrefHeight(45);
    }

/*
    public void addActionListener(ActionListener listenForCalcButton) {
        this.setOnAction(listenForCalcButton);
    }*/
}
