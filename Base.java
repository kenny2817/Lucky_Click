package com.company;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import static com.company.Main.*;
import static javafx.scene.paint.Color.WHITE;

public class Base extends Cella{

    private final int n = (int) (Math.random() * 10 + 1) * 100;

    @Override
    public void scopri() {
        super.scopri();
        ((Rectangle)(this.getChildren().get(0))).setFill(WHITE);
        this.getChildren().add(new Text(String.valueOf(n)));

        Punti += n;
        aggiornaTesto();
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }
}
