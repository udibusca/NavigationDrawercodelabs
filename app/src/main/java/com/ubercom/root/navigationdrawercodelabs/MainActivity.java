package com.ubercom.root.navigationdrawercodelabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.ubercom.root.navigationdrawercodelabs.model.Aluno;
import com.ubercom.root.navigationdrawercodelabs.services.InterfaceDeServicos;
import com.ubercom.root.navigationdrawercodelabs.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout) findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl, R.string.abrir, R.string.fechar);

        dl.addDrawerListener(t);
        t.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(this);
    }

    // Responde a eventos do hamburger
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    // Responde a eventos do menu da gaveta de navegação
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.conta:
            Intent intentAlunos = new Intent(this, ActivityListView.class);
            startActivity(intentAlunos);
            case R.id.config:
                Toast.makeText(MainActivity.this, "Configuração", Toast.LENGTH_SHORT).show();
                break;
            case R.id.carrinho:
                Toast.makeText(MainActivity.this, "Meu carrinho de compras", Toast.LENGTH_SHORT).show();
                break;
            default:
                return true;
        }
        return false;
    }
}