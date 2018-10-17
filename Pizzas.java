package br.edu.catolica_to.my_pizza;

import android.graphics.Bitmap;
import android.widget.Button;

/**
 * Created by ivanh on 28/09/2018.
 */

public class Pizzas {
    private int numStars;
    private String name;
    private Bitmap image;


    public Pizzas(int numStars, String name, Bitmap image) {

        this.numStars = numStars;
        this.name = name;
        this.image = image;

    }

    public int getNumStars() {
        return numStars;
    }

    public void setNumStars(int numStars) {
        this.numStars = numStars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }


}

