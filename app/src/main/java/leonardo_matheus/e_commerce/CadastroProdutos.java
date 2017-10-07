package leonardo_matheus.e_commerce;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import leonardo_matheus.e_commerce.Database.CRUD_Produtos;
import leonardo_matheus.e_commerce.Database.DATABASE;
import leonardo_matheus.e_commerce.Database.Produtos;

public class CadastroProdutos extends AppCompatActivity {
    private Produtos produtos;
    private int codigo;
    private EditText nome, valor, quantidade, descricao;
    private CRUD_Produtos crud;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_produtos);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_produto);
        setSupportActionBar(myToolbar);

        nome = (EditText) findViewById(R.id.ET_Nome);
        valor = (EditText) findViewById(R.id.ET_Valor);
        quantidade = (EditText) findViewById(R.id.ET_Quantidade);
        descricao = (EditText) findViewById(R.id.ET_Descricao);

        crud = new CRUD_Produtos(getBaseContext());
        if(this.getIntent().hasExtra("codigo")) {
            codigo = Integer.parseInt(this.getIntent().getStringExtra("codigo"));
            cursor = crud.carregarDados(codigo);

            nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            valor.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_VALOR)));
            quantidade.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_QUANTIDADE)));
            descricao.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_DESCRICAO)));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_buttons, menu);

        // Determina quais menus serão visiveis nesta tela
        menu.findItem(R.id.button_search).setVisible(false);
        menu.findItem(R.id.button_edit).setVisible(false);
        menu.findItem(R.id.button_delete).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.button_search:
                break;
            case R.id.button_save:
                if(!nome.getText().toString().equals("") && !valor.getText().toString().equals("") && !quantidade.getText().toString().equals("")) {
                    String resultado;

                    if(!this.getIntent().hasExtra("codigo"))
                        resultado = crud.inserirDados(nome.getText().toString(), Double.parseDouble(valor.getText().toString()),
                                Integer.parseInt(quantidade.getText().toString()), descricao.getText().toString());
                    else
                        resultado = crud.alterarDados(codigo, nome.getText().toString(), Double.parseDouble(valor.getText().toString()),
                                Integer.parseInt(quantidade.getText().toString()), descricao.getText().toString());

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_edit:
                break;
            case R.id.button_delete:
                break;
            default:
                break;
        }
        return true;
    }
}
