package leonardo_matheus.e_commerce.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class CRUD_Pessoas {
    private SQLiteDatabase db;
    private DATABASE DATABASE;
    private Cursor cursor;

    public CRUD_Pessoas(Context context) {
        DATABASE = new DATABASE(context);
    }

    public String inserirDados(String nome, String senha, String cpf, String datanascimento) {
        db = DATABASE.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATABASE.COLUNA_NOME, nome);
        valores.put(DATABASE.COLUNA_SENHA, senha);
        valores.put(DATABASE.COLUNA_CPF, cpf);
        valores.put(DATABASE.COLUNA_DATANASCIMENTO, datanascimento);

        long resultado = db.insert(DATABASE.TABELA_PESSOAS, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao cadastrar!";
        else
            return "Registro cadastrado com sucesso!";
    }

    public String alterarDados(int id, String nome, String senha, String cpf, String datanascimento) {
        db = DATABASE.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATABASE.COLUNA_NOME, nome);
        valores.put(DATABASE.COLUNA_SENHA, senha);
        valores.put(DATABASE.COLUNA_CPF, cpf);
        valores.put(DATABASE.COLUNA_DATANASCIMENTO, datanascimento);
        String where = DATABASE.COLUNA_ID + "=" + id;

        long resultado = db.update(DATABASE.TABELA_PESSOAS, valores, where, null);
        db.close();

        if (resultado == -1)
            return "Erro ao atualizar registro!";
        else
            return "Registro atualizado com sucesso!";
    }

    public String excluirDados(int id) {
        db = DATABASE.getWritableDatabase();
        String where = DATABASE.COLUNA_ID + "=" + id;
        long resultado = db.delete(DATABASE.TABELA_PESSOAS, where, null);
        db.close();

        if (resultado == -1)
            return "Erro ao excluir registro!";
        else
            return "Registro excluido com sucesso!";
    }

    public Cursor consultarDados() {
        String[] campos = {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME, DATABASE.COLUNA_SENHA, DATABASE.COLUNA_CPF, DATABASE.COLUNA_DATANASCIMENTO};
        db = DATABASE.getReadableDatabase();
        cursor = db.query(DATABASE.TABELA_PESSOAS, campos, null, null, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }

    public Cursor carregarDados(int id) {
        String[] campos = {DATABASE.COLUNA_ID, DATABASE.COLUNA_SENHA, DATABASE.COLUNA_NOME, DATABASE.COLUNA_CPF, DATABASE.COLUNA_DATANASCIMENTO};
        String where = DATABASE.COLUNA_ID + "=" + id;
        db = DATABASE.getReadableDatabase();
        cursor = db.query(DATABASE.TABELA_PESSOAS, campos, where, null, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }
}
