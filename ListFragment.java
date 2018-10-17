package br.edu.catolica_to.my_pizza;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by ivanh on 28/09/2018.
 */

public class ListFragment extends AppCompatActivity {

    ArrayList<Pizzas> pizzasList;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pizza);

        pizzasList = new ArrayList<Pizzas>();
        pizzasList.add(new Pizzas(1, "mutessarela", carregaImagem(R.drawable.mussarela)));
        pizzasList.add(new Pizzas(2, "california", carregaImagem(R.drawable.california)));
        pizzasList.add(new Pizzas(3, "mutessarela", carregaImagem(R.drawable.mussarela)));
        pizzasList.add(new Pizzas(1, "mutessarela", carregaImagem(R.drawable.mussarela)));
        pizzasList.add(new Pizzas(2, "mutessarela", carregaImagem(R.drawable.mussarela)));

        RecycleAdapter adapter = new RecycleAdapter(this, pizzasList);


        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);
    }


    Bitmap carregaImagem(int id)
    {
        return BitmapFactory.decodeResource(getResources(), id);
    }


}