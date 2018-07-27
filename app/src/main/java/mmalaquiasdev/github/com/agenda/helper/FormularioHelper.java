package mmalaquiasdev.github.com.agenda.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import mmalaquiasdev.github.com.agenda.FormularioActivity;
import mmalaquiasdev.github.com.agenda.R;
import mmalaquiasdev.github.com.agenda.dao.ContatoDAO;
import mmalaquiasdev.github.com.agenda.model.Contato;

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoSite;
    private final EditText campoTelefone;
    private final RatingBar campoNota;

    public FormularioHelper(FormularioActivity activity) {
        campoNome = activity.findViewById(R.id.formulario_nome);
        campoEndereco = activity.findViewById(R.id.formulario_endereco);
        campoNota = activity.findViewById(R.id.formulario_nota);
        campoSite = activity.findViewById(R.id.formulario_site);
        campoTelefone = activity.findViewById(R.id.formulario_telefone);
    }

    public Contato createContato() {
        return new Contato(
                null,
                campoNome.getText().toString(),
                campoEndereco.getText().toString(),
                campoSite.getText().toString(),
                campoTelefone.getText().toString(),
                Double.valueOf(campoNota.getRating())
        );
    }

    public void carregarDadosParaEdicao(Contato contato) {
        campoNome.setText(contato.getNome());
        campoEndereco.setText(contato.getEndereco());
        campoNota.setProgress(contato.getNota().intValue());
        campoSite.setText(contato.getSite());
        campoTelefone.setText(contato.getTelefone());
    }
}
