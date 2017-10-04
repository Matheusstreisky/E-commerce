package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import leonardo_matheus.e_commerce.Database.CRUD_Fornecedores;
import leonardo_matheus.e_commerce.Database.DATABASE;

public class Consulta extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);

        CRUD_Fornecedores crud = new CRUD_Fornecedores(getBaseContext());
        final Cursor cursor = crud.consultarDados();

        String[] campos = new String[] {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME};
        int[] idViews = new int[] {R.id.idLivro, R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(), R.layout.consulta_itens, cursor, campos, idViews, 0);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                cursor.moveToPosition(i);
                String codigo = cursor.getString(cursor.getColumnIndexOrThrow(DATABASE.COLUNA_ID));
                Intent intent = new Intent(Consulta.this, CadastroFornecedores.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
                finish();
            }
        });
    }
}
