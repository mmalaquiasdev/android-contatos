package mmalaquiasdev.github.com.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        this.desenhaLvListaAlunos(this.getAlunos());
    }

    private void desenhaLvListaAlunos(List listaAlunos){
        ListView lvListaAlunos = findViewById(R.id.lv_lista_alunos);
        lvListaAlunos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaAlunos));
    }

    private List getAlunos(){
        return Arrays.asList("Daniel", "Ronaldo", "Cafu", "Dida", "Romario");
    }

}
