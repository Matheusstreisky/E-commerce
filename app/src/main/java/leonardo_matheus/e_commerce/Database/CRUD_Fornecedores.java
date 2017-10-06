package leonardo_matheus.e_commerce.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Streisky on 05/10/2017.
 */

public class CRUD_Fornecedores {
    private SQLiteDatabase db;
    private DATABASE DATABASE;
    private Cursor cursor;

    public CRUD_Fornecedores(Context context) {
        DATABASE = new DATABASE(context);
    }

    public String inserirDados(String nome, String cep, String cidade, String pais, String estado, String telefone, String complemento) {
        db = DATABASE.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATABASE.COLUNA_NOME, nome);
        valores.put(DATABASE.COLUNA_CEP, cep);
        valores.put(DATABASE.COLUNA_CIDADE, cidade);
        valores.put(DATABASE.COLUNA_PAIS, pais);
        valores.put(DATABASE.COLUNA_ESTADO, estado);
        valores.put(DATABASE.COLUNA_TELEFONE, telefone);
        valores.put(DATABASE.COLUNA_COMPLEMENTO, complemento);
        long resultado = db.insert(DATABASE.TABELA_FORNECEDORES, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro!";
        else
            return "Registro inserido com sucesso!";
    }

    public String alterarDados(int id, String nome, String cep, String cidade, String pais, String estado, String telefone, String complemento) {
        db = DATABASE.getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(DATABASE.COLUNA_NOME, nome);
        valores.put(DATABASE.COLUNA_CEP, cep);
        valores.put(DATABASE.COLUNA_CIDADE, cidade);
        valores.put(DATABASE.COLUNA_PAIS, pais);
        valores.put(DATABASE.COLUNA_ESTADO, estado);
        valores.put(DATABASE.COLUNA_TELEFONE, telefone);
        valores.put(DATABASE.COLUNA_COMPLEMENTO, complemento);
        String where = DATABASE.COLUNA_ID + "=" + id;
        long resultado = db.update(DATABASE.TABELA_FORNECEDORES, valores, where, null);
        db.close();

        if (resultado == -1)
            return "Erro ao atualizar registro!";
        else
            return "Registro atualizado com sucesso!";
    }

    public String excluirDados(int id) {
        db = DATABASE.getWritableDatabase();
        String where = DATABASE.COLUNA_ID + "=" + id;
        long resultado = db.delete(DATABASE.TABELA_FORNECEDORES, where, null);
        db.close();

        if (resultado == -1)
            return "Erro ao deletar registro!";
        else
            return "Registro deletado com sucesso!";
    }

    public Cursor consultarDados() {
        String[] campos = {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME, DATABASE.COLUNA_CEP, DATABASE.COLUNA_CIDADE, DATABASE.COLUNA_PAIS,
                DATABASE.COLUNA_ESTADO, DATABASE.COLUNA_TELEFONE, DATABASE.COLUNA_COMPLEMENTO};
        db = DATABASE.getReadableDatabase();
        cursor = db.query(DATABASE.TABELA_FORNECEDORES, campos, null, null, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }

    public Cursor carregarDados(int id) {
        String[] campos = {DATABASE.COLUNA_ID, DATABASE.COLUNA_NOME, DATABASE.COLUNA_CEP, DATABASE.COLUNA_CIDADE, DATABASE.COLUNA_PAIS,
                DATABASE.COLUNA_ESTADO, DATABASE.COLUNA_TELEFONE, DATABASE.COLUNA_COMPLEMENTO};
        String where = DATABASE.COLUNA_ID + "=" + id;
        db = DATABASE.getReadableDatabase();
        cursor = db.query(DATABASE.TABELA_FORNECEDORES, campos, where, null, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }
}
