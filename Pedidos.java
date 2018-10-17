package br.edu.catolica_to.my_pizza;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by ivanh on 28/09/2018.
 */

public class Pedidos extends Fragment {

    ArrayList<Pizzas> pizzasList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        pizzasList = new ArrayList<Pizzas>();
        pizzasList.add(new Pizzas(1, "mutessarela", carregaImagem(R.drawable.mussarela)));
        pizzasList.add(new Pizzas(2, "california", carregaImagem(R.drawable.california)));
        pizzasList.add(new Pizzas(3, "Quatro-Queijo", carregaImagem(R.drawable.quatro_queijos)));
        pizzasList.add(new Pizzas(1, "portuguesa", carregaImagem(R.drawable.portuguesa)));
        pizzasList.add(new Pizzas(2, "chocolate-perfeito", carregaImagem(R.drawable.chocolateperfeito)));

        RecycleAdapter adapter = new RecycleAdapter(getContext(), pizzasList);

        View view = inflater.inflate(R.layout.fragment_pedido_pizza, container, false);

        RecyclerView recycler = view.findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setItemAnimator(new DefaultItemAnimator());
        recycler.setAdapter(adapter);

        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Pedidos de Pizza");
    }

    Bitmap carregaImagem(int id)
    {
        return BitmapFactory.decodeResource(getResources(), id);
    }



}
