package br.edu.catolica_to.my_pizza;

import android.content.DialogInterface;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.EditText;

/**
 * Created by ivanh on 28/09/2018.
 */

public class Status extends Fragment implements DialogInterface.OnClickListener {

    public Chronometer ch;
    EditText edtstatus = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments


        View view = inflater.inflate(R.layout.fragment_status_pedido, container, false);
        ch = (Chronometer) view.findViewById(R.id.frc);
        edtstatus= (EditText) view.findViewById(R.id.editStatus);


        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Acompanhe seu Pedido");
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {

    }



}
