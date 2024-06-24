package com.company;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import static com.company.Main.Punti;
import static com.company.Main.aggiornaTesto;
import static javafx.scene.paint.Color.RED;

public class Divisore extends Cella{
    @Override
    public void scopri() {
        super.scopri();
        ((Rectangle)(this.getChildren().get(0))).setFill(RED);
        this.getChildren().add(new Text("/2"));

        Punti = Punti / 2;
        aggiornaTesto();
    }

    @Override
    public String toString() {
        return "Divi";
    }
}
