package mmalaquiasdev.github.com.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.widget.Toast.*;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_formulario);
        this.acaoBotaoSalvar();
    }

    private void acaoBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.formulario_bt_salvar);
        botaoSalvar.setOnClickListener((view) -> {
            makeText(FormularioActivity.this, "Contato salvo com sucesso", LENGTH_SHORT).show();
            finish();
        });
    }
}
