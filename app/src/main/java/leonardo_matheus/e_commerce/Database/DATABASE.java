package leonardo_matheus.e_commerce.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DATABASE extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "e_commerce";
    private static final int VERSAO_BANCO = 2;

    // Tableas
    public static final String TABELA_FORNECEDORES = "fornecedores";
    public static final String TABELA_PRODUTOS = "produtos";
    public static final String TABELA_PESSOAS = "pessoas";

    // Campos de atritubo
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
    public static final String COLUNA_CPF = "cpf";
    public static final String COLUNA_DATANASCIMENTO = "datanascimento";
    public static final String COLUNA_SENHA = "senha";

    // Comandos SQL
    private static final String TABLE_FORNECEDORES =
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
    private static final String TABLE_PRODUTOS =
            "CREATE TABLE " + TABELA_PRODUTOS + " ("
                    + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUNA_NOME + " TEXT NOT NULL,"
                    + COLUNA_VALOR + " DOUBLE NOT NULL,"
                    + COLUNA_QUANTIDADE + " INTEGER NOT NULL,"
                    + COLUNA_DESCRICAO + " TEXT"
                    + ");";
    private static final String TABLE_PESSOAS =
            "CREATE TABLE " + TABELA_PESSOAS + " ("
                    + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUNA_NOME + " TEXT NOT NULL,"
                    + COLUNA_SENHA + " TEXT NOT NULL,"
                    + COLUNA_CPF + " TEXT NOT NULL,"
                    + COLUNA_DATANASCIMENTO + " TEXT NOT NULL"
                    + ");";
    private static final String INSERT_ADM = "INSERT INTO "
            + TABELA_PESSOAS + " ("+COLUNA_NOME+", "+COLUNA_SENHA+", "+COLUNA_CPF+", "+COLUNA_DATANASCIMENTO+")" +
            " VALUES('admin', 'admin', '000.000.000-00', '00-00-00');";



    public DATABASE(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_FORNECEDORES);
        db.execSQL(TABLE_PRODUTOS);
        db.execSQL(TABLE_PESSOAS);
        db.execSQL(INSERT_ADM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_FORNECEDORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PRODUTOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PESSOAS);
        onCreate(db);
    }
}
