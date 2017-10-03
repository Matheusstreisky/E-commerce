package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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


    }

    @Override
    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.button:
                intent = new Intent(this, TelaCadastroFornecedores.class);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this, TelaCadastroProdutos.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }
}
