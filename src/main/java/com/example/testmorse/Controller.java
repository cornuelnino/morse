package com.example.testmorse;

import com.example.testmorse.clavier.In;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public Morse morse;
    public Circle circleMorse;
    public Button buttonMorse;
    String rexex = "^[A-Za-z0-9\\s]+$";
    String entree;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        circleMorse.setFill(Color.BLACK);
        morse = new Morse(this);

        buttonMorse.setOnAction(event -> {
            startMorse();
            buttonMorse.setDisable(true);
            buttonMorse.setText("EN TRADUCTION");
        });
    }

    public void startMorse(){
        System.out.println("\nEntrez une phrase :");

        entree = In.readString();
        entree = entree.toLowerCase();

        if(entree.matches(rexex)){
            String avecSlash = morse.insertSlash(entree);

            String morsise = morse.transformToMorse(avecSlash);

            Thread led = new Thread(()->{
                morse.printMorse(morsise);
                buttonMorse.setDisable(false);
            });
            led.start();


        } else {
            System.out.println("Mauvaise saisie, veuillez reessayer");
        }
    }

}