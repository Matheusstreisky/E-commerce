package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import leonardo_matheus.e_commerce.Database.CRUD_Pessoas;
import leonardo_matheus.e_commerce.Database.DATABASE;

import static com.facebook.login.LoginManager.*;

public class TelaLogin extends AppCompatActivity implements View.OnClickListener {
    private EditText usuario, senha;
    private Button login, cadastrar;
    private CRUD_Pessoas crud;
    EditText email;
    EditText password;
    String sMail, sPassword;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);
        callbackManager = CallbackManager.Factory.create();
        getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });


        // Seta toolbar como actionBar na tela
        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_login);
        setSupportActionBar(myToolbar);

        usuario = (EditText) findViewById(R.id.ET_Login);
        senha = (EditText) findViewById(R.id.ET_Senha);
        login = (Button) findViewById(R.id.BT_Login);
        cadastrar = (Button) findViewById(R.id.BT_Cadastrar);

        crud = new CRUD_Pessoas(getBaseContext());
        login.setOnClickListener(this);
        cadastrar.setOnClickListener(this);
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

    @Override
    public void onClick(View id) {
        Intent intent;

        switch (id.getId()) {
            case R.id.BT_Login:
                if(!usuario.getText().toString().isEmpty() && !senha.getText().toString().isEmpty()) {
                    Cursor cursor = crud.validarUsuarioSenha(usuario.getText().toString(), senha.getText().toString());

                    if(cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Bem vindo " + cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_NOME)) + "!", Toast.LENGTH_SHORT).show();

                        if(usuario.getText().toString().substring(0, 5).equals("admin")) {
                            intent = new Intent(this, TelaAdm.class);
                            startActivity(intent);
                        }
                        else {
                            intent = new Intent(this, TelaPrincipal.class);
                            startActivity(intent);
                        }
                    }
                    else
                        Toast.makeText(getApplicationContext(), "Usuário ou Senha INCORRETOS!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.BT_Cadastrar:
                intent = new Intent(this, CadastroPessoas.class);
                startActivity(intent);
                break;
        }
    }
}
