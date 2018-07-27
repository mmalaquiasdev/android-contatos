package mmalaquiasdev.github.com.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.logging.Logger;

import mmalaquiasdev.github.com.agenda.dao.ContatoDAO;
import mmalaquiasdev.github.com.agenda.helper.FormularioHelper;
import mmalaquiasdev.github.com.agenda.model.Contato;

import static android.widget.Toast.*;

public class FormularioActivity extends AppCompatActivity {

    FormularioHelper helper;
    ContatoDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_formulario);
        this.helper = new FormularioHelper(this);
        dao = new ContatoDAO(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarFormularioParaEdicao();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                acaoBotaoSalvar(helper.createContato());
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void acaoBotaoSalvar(Contato contato) {
        salvarNovoContato(contato);
        makeText(FormularioActivity.this, "Contato salvo com sucesso" + " " + contato.getNome(), LENGTH_SHORT).show();
        finish();
    }

    private void salvarNovoContato(Contato contato) {
        dao.inserir(contato);
        dao.close();
    }

    private void carregarFormularioParaEdicao() {
        long contatoId = getIntent().getLongExtra("contatoId", 0L);
        if(contatoId != 0L) {
            Contato contato = dao.buscarPorId(contatoId);
            helper.carregarDadosParaEdicao(contato);
        }
    }
}
