package leonardo_matheus.e_commerce;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;

import java.io.File;

public class PDF extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
    }

    public void onClick(View id) {

        Intent it;
        switch (id.getId()) {
            case R.id.frag_bt_Download:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://drive.google.com/drive/folders/0B2j8Tcz4GW5-UHp6RWxDcU5pYlU?usp=sharing"));
                startActivity(browserIntent);
                break;

            case R.id.frag_bt_Abrir_PDF:
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "aps.pdf");
                Uri path = Uri.fromFile(file);
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setDataAndType(path, "application/pdf");
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;

        }


    }
}
