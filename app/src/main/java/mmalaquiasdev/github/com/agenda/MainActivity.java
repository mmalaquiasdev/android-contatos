package mmalaquiasdev.github.com.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import mmalaquiasdev.github.com.agenda.dao.ContatoDAO;
import mmalaquiasdev.github.com.agenda.model.Contato;

public class MainActivity extends AppCompatActivity {

    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        dao = new ContatoDAO(this);
        this.acaoBotaoNovoContato();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregarListaContatos(this.getContatos());
    }

    private void carregarListaContatos(List<Contato> contatos) {
        ListView lvListaContatos = findViewById(R.id.lv_lista_contatos);

        lvListaContatos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contatos));
    }

    private void acaoBotaoNovoContato() {
        Button novoContato = findViewById(R.id.bt_novo_contato);
        novoContato.setOnClickListener((view) -> startActivity(new Intent(MainActivity.this, FormularioActivity.class)));
    }

    private List<Contato> getContatos() {
         List<Contato> contatos = dao.buscarTodosComNome();
         dao.close();

         return contatos;
    }

}
