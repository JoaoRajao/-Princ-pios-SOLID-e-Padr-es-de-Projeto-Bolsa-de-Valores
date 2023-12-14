package entidades.banco;

public class ClientePremium extends Cliente {

    private GestorDeInvestimentos gestorDeInvestimentos;

    public ClientePremium(String nome, String id, Double saldo, GestorDeInvestimentos gestorDeInvestimentos) {
        super(nome, id, saldo);
        this.gestorDeInvestimentos = gestorDeInvestimentos;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Nome do Gestor: " + this.gestorDeInvestimentos.getNome();
    }
}
