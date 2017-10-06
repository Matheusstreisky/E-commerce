package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TelaAdm extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_adm);

        // Seta toolbar como actionBar na tela
        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_administrador);
        setSupportActionBar(myToolbar);

        Button botao1 = (Button) findViewById(R.id.button);
        botao1.setOnClickListener(this);
        Button botao2 = (Button) findViewById(R.id.button2);
        botao2.setOnClickListener(this);
        Button botao3 = (Button) findViewById(R.id.Consulta);
        botao3.setOnClickListener(this);
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
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, CadastroFornecedores.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, CadastroProdutos.class);
                startActivity(intent);
                break;
            case R.id.Consulta:
                intent = new Intent(this, Consulta.class);
                startActivity(intent);
            default:
                break;
        }
    }
}
