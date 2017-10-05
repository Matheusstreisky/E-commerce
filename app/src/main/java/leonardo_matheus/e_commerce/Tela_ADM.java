package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela_ADM extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__adm);


    }

    public void onClick(View v) {

        Intent intent;
        switch (v.getId()) {
            case R.id.btn_Produtos:
                intent = new Intent(this, TelaCadastroProdutos.class);
                startActivity(intent);
                break;
            case R.id.btn_Fornecedores:
                intent = new Intent(this, TelaCadastroFornecedores.class);
                startActivity(intent);
                break;
            default:
                break;
        }


    }
}
