package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

import leonardo_matheus.e_commerce.Database.CRUD_Fornecedores;
import leonardo_matheus.e_commerce.Database.CRUD_Produtos;
import leonardo_matheus.e_commerce.Database.DATABASE;

public class Consulta extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);

        // Seta toolbar como actionBar na tela
        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_consulta);
        setSupportActionBar(myToolbar);

        // Seta o spinner com os determinados valores
        Spinner selecionado = (Spinner) findViewById(R.id.SP_Selecione);
        ArrayList<String> itens = new ArrayList<>(Arrays.asList(DATABASE.TABELA_FORNECEDORES.toString(),
                DATABASE.TABELA_PRODUTOS.toString(), DATABASE.TABELA_PESSOAS.toString()));
        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itens);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selecionado.setAdapter(array);

        selecionado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }
            }
        });


        CRUD_Fornecedores crud = new CRUD_Fornecedores(getBaseContext());
        final Cursor cursor = crud.consultarDados();

        String[] campos = new String[] {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.consulta_itens, cursor, campos, idViews, 0);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                String codigo = cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_ID));
                Intent intent = new Intent(Consulta.this, Visualizar.class);
                intent.putExtra("codigo", codigo);
                intent.putExtra("tela", "fornecedor");
                startActivity(intent);
                finish();
            }
        });

        /*
        CRUD_Produtos crud = new CRUD_Produtos(getBaseContext());
        final Cursor cursor = crud.consultarDados();

        String[] campos = new String[] {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.consulta_itens, cursor, campos, idViews, 0);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                String codigo = cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_ID));
                Intent intent = new Intent(Consulta.this, Visualizar.class);
                intent.putExtra("codigo", codigo);
                intent.putExtra("tela", "produto");
                startActivity(intent);
                finish();
            }
        });
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_buttons, menu);

        // Determina quais menus serão visiveis nesta tela
        menu.findItem(R.id.button_search).setVisible(false);
        menu.findItem(R.id.button_save).setVisible(false);
        menu.findItem(R.id.button_edit).setVisible(false);
        menu.findItem(R.id.button_delete).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }
}
