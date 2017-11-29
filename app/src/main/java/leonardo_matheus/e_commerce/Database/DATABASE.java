package leonardo_matheus.e_commerce.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DATABASE extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "e_commerce";
    private static final int VERSAO_BANCO = 2;

    /* Tabelas -------------------------------------------------------------------------------------
    --------------------------------------------------------------------------------------------- */
    public static final String TABELA_FORNECEDORES = "fornecedores";
    public static final String TABELA_PRODUTOS = "produtos";
    public static final String TABELA_PESSOAS = "pessoas";
    public static final String TABELA_CARRINHO = "carrinho";

    /* Campos de atritubo --------------------------------------------------------------------------
    --------------------------------------------------------------------------------------------- */
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_ID_FORNECEDOR = "id_fornecedor";
    public static final String COLUNA_ID_PRODUTO = "id_produto";
    public static final String COLUNA_ID_PESSOA = "id_pessoa";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_CEP = "cep";
    public static final String COLUNA_CIDADE = "cidade";
    public static final String COLUNA_PAIS = "pais";
    public static final String COLUNA_ESTADO = "estado";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_COMPLEMENTO = "complemento";
    public static final String COLUNA_VALOR = "valor";
    public static final String COLUNA_QUANTIDADE = "quantidade";
    public static final String COLUNA_TIPO = "tipo";
    public static final String COLUNA_DESCRICAO = "descricao";
    public static final String COLUNA_IMAGEM = "imagem";
    public static final String COLUNA_CPF = "cpf";
    public static final String COLUNA_DATANASCIMENTO = "datanascimento";
    public static final String COLUNA_DATACOMPRA = "datacompra";
    public static final String COLUNA_SENHA = "senha";
    public static final String COLUNA_EMAIL = "email";

    /* Comandos SQL --------------------------------------------------------------------------------
    --------------------------------------------------------------------------------------------- */
    private static final String TABLE_FORNECEDORES =
            "CREATE TABLE " + TABELA_FORNECEDORES + " ("
                    + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUNA_NOME + " TEXT NOT NULL,"
                    + COLUNA_CEP + " TEXT,"
                    + COLUNA_CIDADE + " TEXT,"
                    + COLUNA_PAIS + " TEXT,"
                    + COLUNA_ESTADO + " TEXT,"
                    + COLUNA_TELEFONE + " TEXT NOT NULL,"
                    + COLUNA_COMPLEMENTO + " TEXT"
                    + ")";
    private static final String TABLE_PRODUTOS =
            "CREATE TABLE " + TABELA_PRODUTOS + " ("
                    + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUNA_NOME + " TEXT NOT NULL,"
                    + COLUNA_VALOR + " DOUBLE NOT NULL,"
                    + COLUNA_QUANTIDADE + " INTEGER NOT NULL,"
                    + COLUNA_TIPO + " TEXT NOT NULL,"
                    + COLUNA_DESCRICAO + " TEXT,"
                    + COLUNA_IMAGEM + " BLOB, "
                    + COLUNA_ID_FORNECEDOR + " INTEGER,"
                    + "FOREIGN KEY(" + COLUNA_ID_FORNECEDOR + ") REFERENCES " + TABELA_FORNECEDORES + " (" + COLUNA_ID + ")"
                    + ");";
    private static final String TABLE_PESSOAS =
            "CREATE TABLE " + TABELA_PESSOAS + " ("
                    + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUNA_NOME + " TEXT NOT NULL,"
                    + COLUNA_SENHA + " TEXT NOT NULL,"
                    + COLUNA_CPF + " TEXT NOT NULL,"
                    + COLUNA_DATANASCIMENTO + " TEXT NOT NULL,"
                    + COLUNA_EMAIL + " TEXT NOT NULL"
                    + ");";
    private static final String TABLE_CARRINHO =
            "CREATE TABLE " + TABELA_CARRINHO + " ("
                    + COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUNA_ID_PESSOA + " INTEGER NOT NULL,"
                    + COLUNA_ID_PRODUTO + " INTEGER NOT NULL,"
                    + COLUNA_QUANTIDADE + " INTEGER NOT NULL,"
                    + COLUNA_DATACOMPRA + " TEXT NOT NULL,"
                    + "FOREIGN KEY(" + COLUNA_ID_PESSOA + ") REFERENCES " + TABELA_PESSOAS + " (" + COLUNA_ID + "),"
                    + "FOREIGN KEY(" + COLUNA_ID_PRODUTO + ") REFERENCES " + TABELA_PRODUTOS + " (" + COLUNA_ID + ")"
                    + ");";
    private static final String INSERT_ADM = "INSERT INTO " + TABELA_PESSOAS
            + " (" + COLUNA_NOME + ", " + COLUNA_SENHA + ", " + COLUNA_CPF + ", " + COLUNA_DATANASCIMENTO + ", " + COLUNA_EMAIL + ")"
            + " VALUES('admin', 'admin', '000.000.000-00', '00-00-00', 'admin@admin.com');";



    public DATABASE(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_FORNECEDORES);
        db.execSQL(TABLE_PRODUTOS);
        db.execSQL(TABLE_PESSOAS);
        db.execSQL(TABLE_CARRINHO);
        db.execSQL(INSERT_ADM);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_FORNECEDORES);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PRODUTOS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PESSOAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CARRINHO);
        onCreate(db);
    }
}
