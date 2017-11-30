package leonardo_matheus.e_commerce;

import android.database.Cursor;
import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.util.Date;

import leonardo_matheus.e_commerce.Database.CRUD_Pessoas;
import leonardo_matheus.e_commerce.Database.DATABASE;
import leonardo_matheus.e_commerce.Database.Pessoas;
import leonardo_matheus.e_commerce.Validation.Mask;
import leonardo_matheus.e_commerce.Validation.ValidaCPF;

public class CadastroPessoas extends AppCompatActivity {

    private Pessoas pessoas;
    private int codigo;
    private EditText nome, senha, rpt_senha, cpf, datanasc, email;
    private CRUD_Pessoas crud;
    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_pessoas);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_pessoa);
        setSupportActionBar(myToolbar);

        nome = (EditText) findViewById(R.id.editNome);
        senha = (EditText) findViewById(R.id.editSenha);
        rpt_senha = (EditText) findViewById(R.id.editRepSenha);
        cpf = (EditText) findViewById(R.id.editCPF);
        datanasc = (EditText) findViewById(R.id.editNascimento);
        email = (EditText) findViewById(R.id.editEmail);

        cpf.addTextChangedListener(Mask.insert("###.###.###-##", cpf));
        datanasc.addTextChangedListener(Mask.insert("##/##/####", datanasc));

        crud = new CRUD_Pessoas(getBaseContext());
        if (this.getIntent().hasExtra("codigo")) {
            codigo = Integer.parseInt(this.getIntent().getStringExtra("codigo"));
            cursor = crud.carregarDados(codigo);

            nome.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)));
            senha.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_SENHA)));
            cpf.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_CPF)));
            datanasc.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_DATANASCIMENTO)));
            email.setText(cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_EMAIL)));
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
        switch (item.getItemId()) {
            case R.id.button_search:
                break;
            case R.id.button_save:
                if (!nome.getText().toString().isEmpty() && !senha.getText().toString().isEmpty() && !rpt_senha.getText().toString().isEmpty()
                        && !cpf.getText().toString().isEmpty() && !datanasc.getText().toString().isEmpty() && !email.getText().toString().isEmpty()) {

                    String c = cpf.getText().toString().replace(".", "");
                    c = c.replaceAll("-", "");
                    if(!ValidaCPF.isCPF(c)) {
                        Toast.makeText(getApplicationContext(), "CPF inválido!!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if(!validarData(datanasc.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Data incorreta!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if(!validarEmail(email.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Email inválido!!", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    if (senha.getText().toString().equals(rpt_senha.getText().toString())) {
                        String resultado;

                        if (!this.getIntent().hasExtra("codigo"))
                            resultado = crud.inserirDados(nome.getText().toString(), senha.getText().toString(),
                                    cpf.getText().toString(), datanasc.getText().toString(), email.getText().toString());
                        else
                            resultado = crud.alterarDados(codigo, nome.getText().toString(), senha.getText().toString(),
                                    cpf.getText().toString(), datanasc.getText().toString(), email.getText().toString());

                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                        finish();
                    } else
                        Toast.makeText(getApplicationContext(), "Campos de senhas não estão iguais!", Toast.LENGTH_SHORT).show();

                } else
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

    private boolean validarData(String data) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        String d = datanasc.getText().toString();
        try {
            sdf.setLenient(false);
            Date date = sdf.parse(d);
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean validarEmail(String email) {
        if(email == null)
            return false;
        else
            return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
