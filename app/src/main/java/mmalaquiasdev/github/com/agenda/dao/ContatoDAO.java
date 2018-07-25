package mmalaquiasdev.github.com.agenda.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContatoDAO extends SQLiteOpenHelper {

    public ContatoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE contatos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, site TEXT, nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS contatos";
        db.execSQL(sql);
        onCreate(db);
    }
}
