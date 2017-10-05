package leonardo_matheus.e_commerce.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Streisky on 18/09/2017.
 */

public class DATABASE extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "e_commerce";
    private static final int VERSAO_BANCO = 1;

    public static final String TABELA_FORNECEDORES = "fornecedores";
    public static final String TABELA_PRODUTOS = "produtos";

    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_CEP = "cep";
    public static final String COLUNA_CIDADE = "cidade";
    public static final String COLUNA_PAIS = "pais";
    public static final String COLUNA_ESTADO = "estado";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_COMPLEMENTO = "complemento";

    public static final String COLUNA_VALOR = "valor";
    public static final String COLUNA_QUANTIDADE = "quantidade";
    public static final String COLUNA_DESCRICAO = "descricao";


    public DATABASE(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_FORNECEDORES);

        String TABLE_FORNECEDORES =
                "CREATE TABLE " + TABELA_FORNECEDORES + " ("
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_NOME+ " TEXT NOT NULL,"
                + COLUNA_CEP+ " TEXT,"
                + COLUNA_CIDADE+ " TEXT,"
                + COLUNA_PAIS+ " TEXT,"
                + COLUNA_ESTADO+ " TEXT,"
                + COLUNA_TELEFONE+ " TEXT NOT NULL,"
                + COLUNA_COMPLEMENTO+ " TEXT"
                + ")";
        String TABLE_PRODUTOS =
                "CREATE TABLE" + TABELA_PRODUTOS + " ("
                + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUNA_NOME + " TEXT NOT NULL,"
                + COLUNA_VALOR + " DECIMAL(10,2) NOT NULL,"
                + COLUNA_QUANTIDADE + " INTEGER NOT NULL,"
                + COLUNA_DESCRICAO + " TEXT"
                + ");";
        String TABLE_CLIENTE = "";

        db.execSQL(TABLE_FORNECEDORES);
        db.execSQL(TABLE_PRODUTOS);
        db.execSQL(TABLE_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_FORNECEDORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PRODUTOS);
        onCreate(db);
    }
}
