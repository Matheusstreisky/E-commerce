package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import leonardo_matheus.e_commerce.Database.CRUD_Fornecedores;
import leonardo_matheus.e_commerce.Database.CRUD_Pessoas;
import leonardo_matheus.e_commerce.Database.CRUD_Produtos;
import leonardo_matheus.e_commerce.Database.DATABASE;

public class Visualizar extends AppCompatActivity {
    private CRUD_Fornecedores crud_fornecedores;
    private CRUD_Produtos crud_produtos;
    private CRUD_Pessoas crud_pessoas;
    private int codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar);

        // Seta toolbar como actionBar na tela
        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_detalhes);
        setSupportActionBar(myToolbar);

        Cursor cursor;
        TextView rotulos;
        if(this.getIntent().getStringExtra("tela").equals("fornecedor")) {
            crud_fornecedores = new CRUD_Fornecedores(getBaseContext());
            codigo = Integer.parseInt(this.getIntent().getStringExtra("codigo"));
            cursor = crud_fornecedores.carregarDados(codigo);

            rotulos = (TextView) findViewById(R.id.TV_Campo1);
            rotulos.setText(R.string.string_nome);
            rotulos = (TextView) findViewById(R.id.TV_Campo2);
            rotulos.setText(R.string.string_cep);
            rotulos = (TextView) findViewById(R.id.TV_Campo3);
            rotulos.setText(R.string.string_cidade);
            rotulos = (TextView) findViewById(R.id.TV_Campo4);
            rotulos.setText(R.string.string_pais);
            rotulos = (TextView) findViewById(R.id.TV_Campo5);
            rotulos.setText(R.string.string_estado);
            rotulos = (TextView) findViewById(R.id.TV_Campo6);
            rotulos.setText(R.string.string_telefone);
            rotulos = (TextView) findViewById(R.id.TV_Campo7);
            rotulos.setText(R.string.string_complemento);

            rotulos = (TextView) findViewById(R.id.ET_Campo1);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            rotulos = (TextView) findViewById(R.id.ET_Campo2);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_CEP)));
            rotulos = (TextView) findViewById(R.id.ET_Campo3);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_CIDADE)));
            rotulos = (TextView) findViewById(R.id.ET_Campo4);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_PAIS)));
            rotulos = (TextView) findViewById(R.id.ET_Campo5);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_ESTADO)));
            rotulos = (TextView) findViewById(R.id.ET_Campo6);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_TELEFONE)));
            rotulos = (TextView) findViewById(R.id.ET_Campo7);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_COMPLEMENTO)));
        }
        else if(this.getIntent().getStringExtra("tela").equals("produto")) {
            crud_produtos = new CRUD_Produtos(getBaseContext());
            codigo = Integer.parseInt(this.getIntent().getStringExtra("codigo"));
            cursor = crud_produtos.carregarDados(codigo);

            rotulos = (TextView) findViewById(R.id.TV_Campo1);
            rotulos.setText(R.string.string_nome);
            rotulos = (TextView) findViewById(R.id.TV_Campo2);
            rotulos.setText(R.string.string_valor);
            rotulos = (TextView) findViewById(R.id.TV_Campo3);
            rotulos.setText(R.string.string_quantidade);
            rotulos = (TextView) findViewById(R.id.TV_Campo4);
            rotulos.setText(R.string.string_tipo);
            rotulos = (TextView) findViewById(R.id.TV_Campo6);
            rotulos.setText(R.string.string_descricao);

            rotulos = (TextView) findViewById(R.id.ET_Campo1);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            rotulos = (TextView) findViewById(R.id.ET_Campo2);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_VALOR)));
            rotulos = (TextView) findViewById(R.id.ET_Campo3);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_QUANTIDADE)));
            rotulos = (TextView) findViewById(R.id.ET_Campo4);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_TIPO)));
            rotulos = (TextView) findViewById(R.id.ET_Campo6);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_DESCRICAO)));

            codigo = cursor.getInt(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_ID_FORNECEDOR));
            if(codigo >= 0) {
                crud_fornecedores = new CRUD_Fornecedores(getBaseContext());
                cursor = crud_fornecedores.carregarDados(codigo);

                rotulos = (TextView) findViewById(R.id.TV_Campo5);
                rotulos.setText(R.string.title_fornecedor);
                rotulos = (TextView) findViewById(R.id.ET_Campo5);
                rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            }
        }
        else if(this.getIntent().getStringExtra("tela").equals("pessoa")) {
            crud_pessoas = new CRUD_Pessoas(getBaseContext());
            codigo = Integer.parseInt(this.getIntent().getStringExtra("codigo"));
            cursor = crud_pessoas.carregarDados(codigo);

            rotulos = (TextView) findViewById(R.id.TV_Campo1);
            rotulos.setText(R.string.string_nome);
            rotulos = (TextView) findViewById(R.id.TV_Campo2);
            rotulos.setText(R.string.string_CPF);
            rotulos = (TextView) findViewById(R.id.TV_Campo3);
            rotulos.setText(R.string.string_datNasc);
            rotulos = (TextView) findViewById(R.id.TV_Campo4);
            rotulos.setText(R.string.string_email);

            rotulos = (TextView) findViewById(R.id.ET_Campo1);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            rotulos = (TextView) findViewById(R.id.ET_Campo2);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_CPF)));
            rotulos = (TextView) findViewById(R.id.ET_Campo3);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_DATANASCIMENTO)));
            rotulos = (TextView) findViewById(R.id.ET_Campo4);
            rotulos.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_EMAIL)));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_buttons, menu);

        // Determina quais menus serão visiveis nesta tela
        menu.findItem(R.id.button_search).setVisible(false);
        menu.findItem(R.id.button_save).setVisible(false);
        menu.findItem(R.id.button_carrinho).setVisible(false);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Executa determinado trecho de codigo para cada item do menu disponivel na tela
        switch (item.getItemId()) {
            case R.id.button_search:
                break;
            case R.id.button_save:
                break;
            case R.id.button_edit:
                Intent intent;
                if(this.getIntent().getStringExtra("tela").equals("fornecedor")) {
                    intent = new Intent(this, CadastroFornecedores.class);
                    intent.putExtra("codigo", Integer.toString(codigo));
                    startActivity(intent);
                }
                else if(this.getIntent().getStringExtra("tela").equals("produto")) {
                    intent = new Intent(this, CadastroProdutos.class);
                    intent.putExtra("codigo", Integer.toString(codigo));
                    startActivity(intent);
                }
                else if(this.getIntent().getStringExtra("tela").equals("pessoa")) {
                    intent = new Intent(this, CadastroPessoas.class);
                    intent.putExtra("codigo", Integer.toString(codigo));
                    startActivity(intent);
                }
                break;
            case R.id.button_delete:
                String resultado = "";

                if(this.getIntent().getStringExtra("tela").equals("fornecedor"))
                    resultado = crud_fornecedores.excluirDados(codigo);
                else if(this.getIntent().getStringExtra("tela").equals("produto"))
                    resultado = crud_produtos.excluirDados(codigo);
                else if(this.getIntent().getStringExtra("tela").equals("pessoa"))
                    resultado = crud_pessoas.excluirDados(codigo);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                finish();
                break;
            default:
                break;
        }
        return true;
    }
}
