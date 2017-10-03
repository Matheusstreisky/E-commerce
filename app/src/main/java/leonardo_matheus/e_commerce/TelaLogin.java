package leonardo_matheus.e_commerce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TelaLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }

    public void onClick(View id) {

        Intent it;
        switch (id.getId()) {
            case R.id.BT_Login:
                it = new Intent(this, MainActivity.class);
                startActivity(it);
                break;
            case R.id.BT_Cadastrar:
                it = new Intent(this, TelaCadastro.class);
                startActivity(it);
                break;

        }

    }
}
