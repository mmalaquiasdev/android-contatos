package mmalaquiasdev.github.com.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.desenhaLvListaAlunos(this.getContatosMock());
        this.acaoBotaoNovoContato();
    }

    private void desenhaLvListaAlunos(List contatos) {
        ListView lvListaContatos = findViewById(R.id.lv_lista_contatos);
        lvListaContatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos));
    }

    private void acaoBotaoNovoContato() {
        Button novoContato = findViewById(R.id.bt_novo_contato);
        novoContato.setOnClickListener((view) -> startActivity(new Intent(MainActivity.this, FormularioActivity.class)));
    }

    private List getContatosMock() {
        return Arrays.asList("Daniel", "Ronaldo", "Cafu", "Dida", "Romario");
    }

}
