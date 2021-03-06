package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;

import java.util.ArrayList;

import leonardo_matheus.e_commerce.Database.CRUD_Produtos;
import leonardo_matheus.e_commerce.Database.DATABASE;
import leonardo_matheus.e_commerce.Database.Fornecedores;
import leonardo_matheus.e_commerce.Database.Produtos;
import leonardo_matheus.e_commerce.Fragment.MangaFragment;
import leonardo_matheus.e_commerce.Fragment.NovelFragment;


public class TelaPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView listView;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        //FloatButton
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView = (ListView) findViewById(R.id.listView);
        String[] campos;
        int[] idViews;

        CRUD_Produtos crud_produtos = new CRUD_Produtos(getBaseContext());
        final Cursor cursor = crud_produtos.consultarDados();
        campos = new String[] {DATABASE.COLUNA_NOME, DATABASE.COLUNA_TIPO, DATABASE.COLUNA_VALOR};
        idViews = new int[] {R.id.nomeItens, R.id.tipoItens, R.id.valorItens};

        adapter = new SimpleCursorAdapter(this, R.layout.tela_principal_itens, cursor, campos, idViews, 0);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                String codigo = cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME));
                Intent intent = new Intent(getBaseContext(), Carrinho.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
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
        getMenuInflater().inflate(R.menu.tela_principal_menu, menu);
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

    /**
     * @param item
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        //Nos dois primeiros if's sao responsaveis pela porjecao dos fragments referentes aos produtos
        if (id == R.id.nav_manga) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            MangaFragment mangaFragment = new MangaFragment();
            fragmentTransaction.replace(R.id.frameTeste, mangaFragment);
            fragmentTransaction.commit();


        } else if (id == R.id.nav_novel) {
            android.app.FragmentManager fragmentManager = getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            NovelFragment novelFragment = new NovelFragment();
            fragmentTransaction.replace(R.id.frameTeste, novelFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_pdf) {
            Intent i = new Intent(this, PDF.class);
            startActivity(i);
        } else if (id == R.id.nav_adm) {
            Intent i = new Intent(this, TelaAdm.class);
            startActivity(i);
        } else if (id == R.id.nav_faq) {
            Intent i = new Intent(this, Tela_FAQ.class);
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClick(View id) {

        Intent it;
        switch (id.getId()) {
            case R.id.TV_Login:
                it = new Intent(this, TelaLogin.class);
                startActivity(it);
                break;

        }
    }
}
