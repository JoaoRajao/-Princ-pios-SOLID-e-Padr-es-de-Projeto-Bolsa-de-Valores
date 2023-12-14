package entidades.Excecoes;

public class SaldoInsuficienteExcecao extends Exception {
    public SaldoInsuficienteExcecao() {
        super("O cliente não possui saldo suficiente");
    }
}
