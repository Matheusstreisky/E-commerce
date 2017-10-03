package leonardo_matheus.e_commerce;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TelaConsulta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_consulta);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.ToolbarMenu);
        //myToolbar.setTitle(R.string.title_fornecedor);
        setSupportActionBar(myToolbar);

        List<String> listaStrings = new ArrayList<>();
        listaStrings.add(new String("AAA"));
        listaStrings.add(new String("AAA"));
        listaStrings.add(new String("AAA"));

        ListView lista = (ListView) findViewById(R.id.LV_Consulta);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.activity_tela_consulta, listaStrings);
        lista.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.button_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }


}
