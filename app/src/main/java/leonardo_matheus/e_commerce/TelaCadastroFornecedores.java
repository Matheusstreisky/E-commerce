package leonardo_matheus.e_commerce;

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

public class TelaCadastroFornecedores extends AppCompatActivity {

    private EditText nome, cep, cidade, pais, telefone, complemento;
    private Spinner estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_fornecedores);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_fornecedor);
        setSupportActionBar(myToolbar);


        nome = (EditText) findViewById(R.id.ET_Nome);
        cep = (EditText) findViewById(R.id.ET_CEP);
        cidade = (EditText) findViewById(R.id.ET_Cidade);
        pais = (EditText) findViewById(R.id.ET_Pais);
        telefone = (EditText) findViewById(R.id.ET_Telefone);
        estado = (Spinner) findViewById(R.id.SP_Estado);
        estado = (Spinner) findViewById(R.id.SP_Estado);
        complemento = (EditText) findViewById(R.id.ET_Complemento);

        ArrayList<String> estados = new ArrayList<>(Arrays.asList("AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO",
                "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"));
        ArrayAdapter<String> array = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, estados);
        array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estado.setAdapter(array);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.button_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.button_search:
                break;
            case R.id.button_save:
                if(!nome.getText().toString().equals("")) {
                    CRUD_Fornecedores crud = new CRUD_Fornecedores(getBaseContext());
                    String resultado = crud.inserirDados(nome.getText().toString(), cep.getText().toString(),
                            cidade.getText().toString(), pais.getText().toString(), estado.getSelectedItem().toString(),
                            telefone.getText().toString(), complemento.getText().toString());

                    Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                    Toast.makeText(getApplicationContext(), "Insira o nome do Fornecedor!", Toast.LENGTH_SHORT).show();



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
