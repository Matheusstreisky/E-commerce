package leonardo_matheus.e_commerce;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import leonardo_matheus.e_commerce.Database.CRUD_Pessoas;
import leonardo_matheus.e_commerce.Database.DATABASE;
import leonardo_matheus.e_commerce.Database.Pessoas;

public class CadastroPessoas extends AppCompatActivity {

    private Pessoas pessoas;
    private int codigo;
    private EditText nome, senha,rpt_senha, cpf, datanasc;
    private CRUD_Pessoas crud;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_pessoas);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_produto);
        setSupportActionBar(myToolbar);

        nome = (EditText) findViewById(R.id.editNome);
        senha = (EditText) findViewById(R.id.editSenha);
        rpt_senha = (EditText) findViewById(R.id.editRepSenha);
        cpf = (EditText) findViewById(R.id.editCPF);
        datanasc = (EditText) findViewById(R.id.editNascimento);

        crud = new CRUD_Pessoas(getBaseContext());
        if(this.getIntent().hasExtra("codigo")) {
            codigo = Integer.parseInt(this.getIntent().getStringExtra("codigo"));
            cursor = crud.carregarDados(codigo);

            nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            senha.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_SENHA)));
            cpf.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_CPF)));
            datanasc.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_DATANASCIMENTO)));
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
                if(!nome.getText().toString().isEmpty() && !senha.getText().toString().isEmpty() && !rpt_senha.getText().toString().isEmpty()
                        && !cpf.getText().toString().isEmpty() && !datanasc.getText().toString().isEmpty()) {
                    if(senha.getText().toString().equals(rpt_senha.getText().toString())) {
                        String resultado;

                        if (!this.getIntent().hasExtra("codigo"))
                            resultado = crud.inserirDados(nome.getText().toString(), senha.getText().toString(),
                                    cpf.getText().toString(), datanasc.getText().toString());
                        else
                            resultado = crud.alterarDados(codigo, nome.getText().toString(), senha.getText().toString(),
                                    cpf.getText().toString(), datanasc.getText().toString());

                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Senhas não conferem!", Toast.LENGTH_SHORT).show();
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
