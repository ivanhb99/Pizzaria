package br.edu.catolica_to.my_pizza;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DialogInterface.OnClickListener {

    TextView userName = null;
    TextView userStatus = null;
    private long pauseOffset;
    private boolean running;
    Status status;

    private void displaySelectedScreen(int itemId) {

        //creating fragment object
     Fragment fragment = null;



        //initializing the fragment object which is selected
        switch (itemId) {
            case R.id.nav_montagem:
                fragment = new Montagem();
                break;
            case R.id.nav_pedidos:
                fragment = new Pedidos();
//                Intent intencao = new Intent(this, ListFragment.class);
//                startActivity(intencao);
                break;
            case R.id.nav_status:
                status = new Status();
                fragment = status;
                break;
            case R.id.nav_sobre:
                fragment = new Sobre();
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame,fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        /*Bundle dicionario = getIntent().getExtras();
        String nomeUsuario = dicionario.getString("chaveLogin");
        userName = (TextView)  navigationView.findViewById(R.id.txtView);
       userName.setText(nomeUsuario);*/

        //add this line to display menu1 when the activity is loaded
        displaySelectedScreen(R.id.nav_montagem);
    }

    public void tratarVoltar(View button){

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("aviso");
        alert.setIcon(R.mipmap.ic_launcher_round);
        alert.setMessage("tem certeza que deseja sair mestre?");
        alert.setPositiveButton("Sim", this );
        alert.setNegativeButton("Nao", this);
        alert.show();
        //Uri uri = Uri.parse("http://google.com.br");
        //Intent intent = new Intent(Intent.ACTION_VIEW);
    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela_principal, menu);
        userName  = (TextView) findViewById(R.id.txtView);
        userName.setText((String)GerenciadorPersistencia.getValue(this,GerenciadorPersistencia.TYPE_STRING));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        //make this method blank
        displaySelectedScreen(item.getItemId());

        return true;
    }

    @Override
    public void onClick(DialogInterface dialog, int codBotao) {
        if(codBotao == DialogInterface.BUTTON_POSITIVE)
        {
            onBackPressed();
            this.finish();
        }
    }

    public void abreLink(View button) {
        // serve para abrir alguma intençao tipo um link de um site
        Uri uri = Uri.parse("http://google.com.br");
        Intent intencao = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intencao);
    }


    public void pauseChronometer(View v) {
        if (running) {
            status.ch.stop();
            pauseOffset = SystemClock.elapsedRealtime() - status.ch.getBase();
            running = false;
        }
    }

    public void resetChronometer(View v) {
        status.ch.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }

    public void startChronometer(View v) {
        if (!running) {
            status.ch.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            status.ch.start();
            running = true;
        }
    }

    public void mudarStatus(View v){
        Intent intencao = new Intent(this, Status.class);
        Bundle dicionario = new Bundle();
        dicionario.putString("notificação", status.edtstatus.getText().toString());
        intencao.putExtras(dicionario);
        userStatus = (TextView) findViewById(R.id.textStatus);
        userStatus.setText((String)GerenciadorPersistencia.getValue(this,GerenciadorPersistencia.TYPE_STRING));

    }
}
