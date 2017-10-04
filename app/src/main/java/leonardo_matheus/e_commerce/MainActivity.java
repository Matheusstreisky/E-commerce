package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao1 = (Button) findViewById(R.id.button);
        botao1.setOnClickListener(this);
        Button botao2 = (Button) findViewById(R.id.button2);
        botao2.setOnClickListener(this);
        Button botao3 = (Button) findViewById(R.id.Consulta);
        botao3.setOnClickListener(this);
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
