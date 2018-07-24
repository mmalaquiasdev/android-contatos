package mmalaquiasdev.github.com.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import static android.widget.Toast.*;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_formulario);
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
                acaoBotaoSalvar();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void acaoBotaoSalvar() {
        makeText(FormularioActivity.this, "Contato salvo com sucesso", LENGTH_SHORT).show();
        finish();
    }
}
