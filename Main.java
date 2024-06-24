package com.company;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Main extends Application {

    final static int N = 10;

    final static int N_BASE = 75;
    final static int N_MOLT = 10;
    final static int N_DIVI = 10;
    final static int N_BOOM = 5;

    static int Punti;
    static int Tentativi;

    static ArrayList<Cella> celle = new ArrayList<>();

    static Text t1 = new Text();
    static Text t2 = new Text();
    static GridPane gridPane = new GridPane();
    static VBox vBox = new VBox(t1, t2, gridPane);
    static Scene scene = new Scene(vBox);

    @Override
    public void start(Stage primarystage) throws Exception {

        restart();

        t1.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, 20.0));
        t2.setFont(Font.font("arial", FontWeight.EXTRA_BOLD, 20.0));
        vBox.setAlignment(Pos.CENTER);

        primarystage.setTitle("Lucky click");
        primarystage.setScene(scene);
        primarystage.show();
        primarystage.setResizable(false);
        primarystage.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void restart(){
        celle.clear();
        for (int i = 0; i < N_BASE; i++){celle.add(new Base());}
        for (int i = 0; i < N_MOLT; i++){celle.add(new Moltiplicatore());}
        for (int i = 0; i < N_DIVI; i++){celle.add(new Divisore());}
        for (int i = 0; i < N_BOOM; i++){celle.add(new Boom());}
        Collections.shuffle(celle);

        gridPane.getChildren().clear();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                gridPane.add(celle.get(i * N +j), j, i);
            }
        }
        gridPane.setGridLinesVisible(false);
        gridPane.setGridLinesVisible(true);

        Punti = 0;
        Tentativi = 10;
        aggiornaTesto();
    }

    public static void aggiornaTesto(){
        t1.setText("Punteggio = " + Punti);
        t2.setText("Tentativi = " + Tentativi);
        if (Tentativi == 0){t2.setText("GAMEOVER!");}
    }
}
