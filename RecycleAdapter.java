package br.edu.catolica_to.my_pizza;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ivanh on 08/09/2018.
 */

public class RecycleAdapter extends RecyclerView.Adapter<PizzaHolder> {

    private Context context;
    private ArrayList<Pizzas> pizzasList;

    public RecycleAdapter(Context context, ArrayList<Pizzas> pizzaList){

        this.context = context;
        this.pizzasList = pizzaList;

    }

    @Override
    public PizzaHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View cell = LayoutInflater.from(context).inflate(R.layout.activity_cedula, parent, false);
        PizzaHolder holter = new PizzaHolder(cell);

        return holter;
    }

    @Override
    public void onBindViewHolder(PizzaHolder holder, int position) {
        Pizzas pizzas = pizzasList.get(position);
        holder.getName().setText(pizzas.getName());
        holder.getStars().setRating(pizzas.getNumStars());
        holder.getItemImage().setImageBitmap(pizzas.getImage());
    }

    @Override
    public int getItemCount() {
        return pizzasList.size();
    }
}