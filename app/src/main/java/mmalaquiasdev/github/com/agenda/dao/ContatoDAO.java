package mmalaquiasdev.github.com.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mmalaquiasdev.github.com.agenda.model.Contato;

public class ContatoDAO extends SQLiteOpenHelper {

    public ContatoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS contatos (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, site TEXT, telefone TEXT,nota REAL);";
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
        db.insert("contatos", null, converter(contato));
    }

    public List<Contato> buscarTodosComNome() {
        String sql = "SELECT id, nome FROM contatos;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        return converterComNome(cursor);
    }

    public Contato buscarPorId(Long id) {
        String sql = "SELECT id, nome, endereco, site, telefone, nota FROM contatos WHERE id = ?;";
        String [] params = { id.toString() };
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, params);

        return converter(cursor).get(0);
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


    private List<Contato> converter(Cursor cursor) {
        List<Contato> contatos = new ArrayList<>();
        while (cursor.moveToNext()) {
            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            String endereco = cursor.getString(cursor.getColumnIndex("endereco"));
            String site = cursor.getString(cursor.getColumnIndex("site"));
            String telefone = cursor.getString(cursor.getColumnIndex("telefone"));
            Double nota = cursor.getDouble(cursor.getColumnIndex("nota"));
            contatos.add(new Contato(id, nome, endereco, site, telefone, nota));
        }
        cursor.close();

        return contatos;
    }


    private List<Contato> converterComNome(Cursor cursor) {
        List<Contato> contatos = new ArrayList<>();
        while (cursor.moveToNext()) {
            Long id = cursor.getLong(cursor.getColumnIndex("id"));
            String nome = cursor.getString(cursor.getColumnIndex("nome"));
            contatos.add(new Contato(id, nome, null, null, null, null));
        }
        cursor.close();

        return contatos;
    }

    public void delete(Contato contato) {
        SQLiteDatabase db = getWritableDatabase();
        String [] params = { contato.getId().toString() };
        db.delete("contatos", "id = ?", params);
    }
}
