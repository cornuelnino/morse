package com.example.testmorse;

import com.example.testmorse.clavier.In;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Morse morse;
    public Circle circleMorse;
    public Button buttonMorse;
    public TextField textFieldMorse;
    String rexex = "^[A-Za-z0-9\\s]+$";
    String entree;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        circleMorse.setFill(Color.BLACK);
        morse = new Morse(this);

        buttonMorse.setOnAction(event -> {
            startMorse();
        });
    }

    public void startMorse(){

        if(textFieldMorse.getText() != null){
            entree = textFieldMorse.getText().toLowerCase();
        }

        if(entree.matches(rexex)){
            buttonMorse.setDisable(true);
            buttonMorse.setText("EN TRADUCTION");

            String entreeSlash = morse.insertSlash(entree);

            String entreeMorse = morse.transformToMorse(entreeSlash);

            Thread led = new Thread(()->{
                morse.printMorse(entreeMorse);
                buttonMorse.setDisable(false);
            });
            led.start();


        } else {
            textFieldMorse.setText("");
        }
    }

}