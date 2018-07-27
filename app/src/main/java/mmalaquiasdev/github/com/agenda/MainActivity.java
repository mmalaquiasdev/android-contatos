package mmalaquiasdev.github.com.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mmalaquiasdev.github.com.agenda.dao.ContatoDAO;
import mmalaquiasdev.github.com.agenda.model.Contato;

public class MainActivity extends AppCompatActivity {

    ContatoDAO dao;
    ListView lvListaContatos;

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
        this.alterarContatos(this.lvListaContatos);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)  {
        MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(item -> {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Contato contato = (Contato) lvListaContatos.getItemAtPosition(info.position);
            dao.delete(contato);
            dao.close();
            Toast.makeText(MainActivity.this, "Deletando o contato " + contato.getNome(), Toast.LENGTH_SHORT).show();
            onResume();
            return false;
        });
    }

    private void carregarListaContatos(List<Contato> contatos) {
        lvListaContatos = findViewById(R.id.lv_lista_contatos);
        lvListaContatos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contatos));
        registerForContextMenu(lvListaContatos);
    }

    private void acaoBotaoNovoContato() {
        Button novoContato = findViewById(R.id.bt_novo_contato);
        novoContato.setOnClickListener((view) -> startActivity(new Intent(MainActivity.this, FormularioActivity.class)));
    }

    private void alterarContatos(ListView lvListaContatos) {
        lvListaContatos.setOnItemClickListener((list, item, position, itemId) -> {
            Contato contato = (Contato) lvListaContatos.getItemAtPosition(position);
            Toast.makeText(MainActivity.this, "Contato " + contato.getNome() + " clicado!", Toast.LENGTH_SHORT).show();
        });
    }

    private List<Contato> getContatos() {
         List<Contato> contatos = dao.buscarTodosComNome();
         dao.close();

         return contatos;
    }

}
