package entidades.banco;

public class Pessoa {
    protected String nome;
    protected String id;

    public Pessoa(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;

        Pessoa pessoa = (Pessoa) o;

        return getNome().equals(pessoa.getNome()) && getId().equals(pessoa.getId());
    }

    @Override
    public int hashCode() {
        int result = getNome().hashCode();
        result = 31 * result + getId().hashCode();
        return result;
    }
}
