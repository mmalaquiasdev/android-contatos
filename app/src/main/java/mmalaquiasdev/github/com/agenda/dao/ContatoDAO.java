package mmalaquiasdev.github.com.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import mmalaquiasdev.github.com.agenda.model.Contato;

public class ContatoDAO extends SQLiteOpenHelper {

    public ContatoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contatos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, site TEXT, telefone TEXT,nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS contatos";
        db.execSQL(sql);
        onCreate(db);
    }

    public void inserir(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert("Agenda", null, converter(contato));
    }

    private ContentValues converter(Contato contato) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", contato.getNome());
        contentValues.put("endereco", contato.getEndereco());
        contentValues.put("site", contato.getSite());
        contentValues.put("telefone", contato.getTelefone());
        contentValues.put("nota", contato.getNota());

        return contentValues;
    }
}
