package com.company;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

import static com.company.Main.Tentativi;
import static javafx.scene.paint.Color.YELLOW;

public abstract class Cella extends StackPane {

    protected final double DIM = 50.0;
    protected boolean coperto = true;

    public Cella() {
        this.getChildren().add(new Rectangle(DIM, DIM, YELLOW));
        this.setOnMouseClicked(mouseEvent -> {
            if (this.coperto && Tentativi > 0){
                Tentativi--;
                this.scopri();
            }
        });
    }

    public void scopri(){
        coperto = false;
    }
}
