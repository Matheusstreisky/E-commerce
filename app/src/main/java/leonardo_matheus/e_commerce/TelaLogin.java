package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;





public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_login);

        // Seta toolbar como actionBar na tela
        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        myToolbar.setTitle(R.string.title_login);
        setSupportActionBar(myToolbar);
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

    public void onClick(View id) {

        Intent it;
        switch (id.getId()) {
//            case R.id.BT_Login:
//                break;
            case R.id.BT_Cadastrar:
                it = new Intent(this, CadastroPessoas.class);
                startActivity(it);
                break;

        }

    }
}
