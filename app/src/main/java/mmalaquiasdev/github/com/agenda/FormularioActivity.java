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
        setContentView(R.layout.activity_formulario);
        acaoBotaoSalvar();
    }

    private void acaoBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.formulario_bt_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeText(FormularioActivity.this, "Cliquei no botão", LENGTH_SHORT)
                .show();
            }
        });
    }
}
