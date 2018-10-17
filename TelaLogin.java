package br.edu.catolica_to.my_pizza;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class TelaLogin extends AppCompatActivity {

    EditText login = null;
    EditText password = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        login = (EditText)findViewById(R.id.editLogin);
        password = (EditText)findViewById(R.id.editPassword);


    }

    public void trataLogin(View botao)
    {
        // serve para abrir alguma intençao tipo um link de um site
        Intent intencao = new Intent(this, TelaPrincipal.class);
        //acessar a bliblioteca
        Bundle dicionario = new Bundle();
        dicionario.putString("chaveLogin", login.getText().toString());
        intencao.putExtras(dicionario);

        if( login.getText().toString().equals("ivan")  && password.getText().toString().equals("1234")){
            //GerenciadorPersistencia.save(this,login.getText().toString());
            Toast.makeText(this, "Login_realizado ",Toast.LENGTH_SHORT).show();
            startActivity(intencao);

        }
        else{

            Toast.makeText(this, "Login_invalido",Toast.LENGTH_SHORT).show();
            login.setText("");
            password.setText("");
        }
    }

    public void onStop()
    {
        //metodo chamdao quando a app sofre inturrupção externa
        super.onStop();
        Log.i("Info","App interrompida");
    }

    public void onStart()
    {
        //metodo chamado quando app vlta de um interrupçao
        super.onStart();
        Log.i("Info", "App em execução");

    }

    public void onDestroy()
    {
        super.onDestroy();
        Log.i("Info","App destruido");
    }


}
