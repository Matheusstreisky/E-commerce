package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botao = (Button) findViewById(R.id.button);
        botao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Intent intent = new Intent(this, TelaCadastroProdutos.class);
        //startActivity(intent);

        Intent intent = new Intent(this, TelaCadastroFornecedores.class);
        startActivity(intent);
    }
}
