package leonardo_matheus.e_commerce.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



public class CRUD_Produtos {
    private SQLiteDatabase db;
    private DATABASE DATABASE;
    private Cursor cursor;

    public CRUD_Produtos(Context context) {
        DATABASE = new DATABASE(context);
    }

    public String inserirDados(String nome, double valor, int quantidade, String descricao) {
        db = DATABASE.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATABASE.COLUNA_NOME, nome);
        valores.put(DATABASE.COLUNA_VALOR, valor);
        valores.put(DATABASE.COLUNA_QUANTIDADE, quantidade);
        valores.put(DATABASE.COLUNA_DESCRICAO, descricao);

        long resultado = db.insert(DATABASE.TABELA_PRODUTOS, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }

    public String alterarDados(int id, String nome, double valor, int quantidade, String descricao) {
        db = DATABASE.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATABASE.COLUNA_NOME, nome);
        valores.put(DATABASE.COLUNA_VALOR, valor);
        valores.put(DATABASE.COLUNA_QUANTIDADE, quantidade);
        valores.put(DATABASE.COLUNA_DESCRICAO, descricao);
        String where = DATABASE.COLUNA_ID + "=" + id;

        long resultado = db.update(DATABASE.TABELA_PRODUTOS, valores, where, null);
        db.close();

        if (resultado == -1)
            return "Erro ao atualizar registro!";
        else
            return "Registro atualizado com sucesso!";
    }

    public String excluirDados(int id) {
        db = DATABASE.getWritableDatabase();
        String where = DATABASE.COLUNA_ID + "=" + id;
        long resultado = db.delete(DATABASE.TABELA_PRODUTOS, where, null);
        db.close();

        if (resultado == -1)
            return "Erro ao deletar registro!";
        else
            return "Registro deletado com sucesso!";
    }

    public Cursor consultarDados() {
        String[] campos = {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME, DATABASE.COLUNA_VALOR, DATABASE.COLUNA_QUANTIDADE, DATABASE.COLUNA_DESCRICAO};
        db = DATABASE.getReadableDatabase();
        cursor = db.query(DATABASE.TABELA_PRODUTOS, campos, null, null, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }

    public Cursor carregarDados(int id) {
        String[] campos = {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME, DATABASE.COLUNA_VALOR, DATABASE.COLUNA_QUANTIDADE, DATABASE.COLUNA_DESCRICAO};
        String where = DATABASE.COLUNA_ID + "=" + id;
        db = DATABASE.getReadableDatabase();
        cursor = db.query(DATABASE.TABELA_PRODUTOS, campos, where, null, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }
}
