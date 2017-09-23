package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Streisky on 18/09/2017.
 */

public class CRUD_Fornecedores {
    private SQLiteDatabase db;
    private DATABASE DATABASE;

    public CRUD_Fornecedores(Context context) {
        DATABASE = new DATABASE(context);
    }

    public String inserirDados(String nome, String CEP, String cidade, String pais, String estado, String telefone, String descricao) {
        db = DATABASE.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATABASE.COLUNA_NOME, nome);
        valores.put(DATABASE.COLUNA_CEP, CEP);
        valores.put(DATABASE.COLUNA_CIDADE, cidade);
        valores.put(DATABASE.COLUNA_PAIS, pais);
        valores.put(DATABASE.COLUNA_ESTADO, estado);
        valores.put(DATABASE.COLUNA_TELEFONE, telefone);
        valores.put(DATABASE.COLUNA_DESCRICAO, descricao);

        long resultado = db.insert(DATABASE.TABELA_FORNECEDORES, null, valores);
        db.close();

        if(resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }
}
