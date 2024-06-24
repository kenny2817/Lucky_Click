package com.company;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import static com.company.Main.*;
import static javafx.scene.paint.Color.BLUE;

public class Boom extends Cella{
    @Override
    public void scopri() {
        super.scopri();
        ((Rectangle)(this.getChildren().get(0))).setFill(BLUE);
        this.getChildren().add(new Text("BOOM!"));

        int n = celle.indexOf(this);
        for (int i = 0; i < N; i++){
            if (celle.get(n / N * N + i).coperto){
                celle.get(n / N * N + i).scopri();
            }
            if (celle.get(n % N + i * N).coperto){
                celle.get(n % N + i * N).scopri();
            }
        }
    }
    @Override
    public String toString() {
        return "BOOM";
    }

}
