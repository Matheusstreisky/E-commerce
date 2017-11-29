package leonardo_matheus.e_commerce;

import android.database.Cursor;
import android.graphics.MaskFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import leonardo_matheus.e_commerce.Database.CRUD_Fornecedores;
import leonardo_matheus.e_commerce.Database.DATABASE;
import leonardo_matheus.e_commerce.Database.Fornecedores;

public class CadastroFornecedores extends AppCompatActivity {
    private Fornecedores fornecedores;
    private int codigo;
    private EditText nome, cep, cidade, pais, telefone, complemento;
    private Spinner estado;
    private CRUD_Fornecedores crud;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_fornecedores);

        // Seta toolbar como actionBar na tela
        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_fornecedor);
        setSupportActionBar(myToolbar);

        // Pega os ids dos campos e seta nas variaveis
        nome = (EditText) findViewById(R.id.ET_Nome);
        cep = (EditText) findViewById(R.id.ET_CEP);
        cidade = (EditText) findViewById(R.id.ET_Cidade);
        pais = (EditText) findViewById(R.id.ET_Pais);
        telefone = (EditText) findViewById(R.id.ET_Telefone);
        estado = (Spinner) findViewById(R.id.SP_Estado);
        complemento = (EditText) findViewById(R.id.ET_Complemento);

        // Seta o spinner com os determinados valores
        ArrayList<String> estados = new ArrayList<>(Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
                "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));
        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estados);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado.setAdapter(array);

        // Seta as mascaras para os campos
        cep.addTextChangedListener(Mask.insert("#####-###", cep));
        telefone.addTextChangedListener(Mask.insert("(##)#####-####", telefone));


        // Se ouver um "codigo" (este codigo indica que foi feito um pedido de alteração do cadastro)
        // seta os valores recuperados do banco nos campos correspondentes
        crud = new CRUD_Fornecedores(getBaseContext());
        if(this.getIntent().hasExtra("codigo")) {
            codigo = Integer.parseInt(this.getIntent().getStringExtra("codigo"));
            cursor = crud.carregarDados(codigo);

            //fornecedores.setid(cursor.getInt(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_ID)));
            nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            cep.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_CEP)));
            cidade.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_CIDADE)));
            pais.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_PAIS)));
            telefone.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_TELEFONE)));
            // Como comparar os dados do spinner
            complemento.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_COMPLEMENTO)));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_buttons, menu);

        // Determina quais menus serão visiveis nesta tela
        menu.findItem(R.id.button_search).setVisible(false);
        menu.findItem(R.id.button_edit).setVisible(false);
        menu.findItem(R.id.button_delete).setVisible(false);
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
                if(!nome.getText().toString().isEmpty() && !cep.getText().toString().isEmpty() && !cidade.getText().toString().isEmpty() &&
                        !pais.getText().toString().isEmpty() && !telefone.getText().toString().isEmpty()) {
                    String resultado;

                    if(!this.getIntent().hasExtra("codigo"))
                        resultado = crud.inserirDados(nome.getText().toString(), cep.getText().toString(),
                                cidade.getText().toString(), pais.getText().toString(), estado.getSelectedItem().toString(),
                                telefone.getText().toString(), complemento.getText().toString());
                    else
                        resultado = crud.alterarDados(codigo, nome.getText().toString(), cep.getText().toString(),
                                cidade.getText().toString(), pais.getText().toString(), estado.getSelectedItem().toString(),
                                telefone.getText().toString(), complemento.getText().toString());

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
