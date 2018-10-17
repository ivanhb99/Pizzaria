package br.edu.catolica_to.my_pizza;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by ivanh on 28/09/2018.
 */

public class PizzaHolder extends RecyclerView.ViewHolder {

    private TextView textName;
    private RatingBar stars;
    private ImageView itemImage;

    public PizzaHolder(View cell){

        super(cell);
        textName = cell.findViewById(R.id.textName);
        stars = cell.findViewById(R.id.stars);
        itemImage = cell.findViewById(R.id.itemImage);
    }

    public TextView getName(){ return textName;}
    public RatingBar getStars(){return stars;}
    public ImageView getItemImage(){return itemImage;}
}

