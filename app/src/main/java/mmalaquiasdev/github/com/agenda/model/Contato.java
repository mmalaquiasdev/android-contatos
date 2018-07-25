package mmalaquiasdev.github.com.agenda.model;

public class Contato {

    private final Long id;
    private final String nome;
    private final String endereco;
    private final String site;
    private final String telefone;
    private final Double nota;

    public Contato(Long id, String nome, String endereco, String site, String telefone, Double nota) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.site = site;
        this.telefone = telefone;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getSite() {
        return site;
    }

    public String getTelefone() {
        return telefone;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", site='" + site + '\'' +
                ", telefone='" + telefone + '\'' +
                ", nota=" + nota +
                '}';
    }
}
