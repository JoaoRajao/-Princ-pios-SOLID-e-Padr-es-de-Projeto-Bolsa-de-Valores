package entidades.Excecoes;

public class NaoPossuiAcoesSuficientesExcecao extends Exception {
    public NaoPossuiAcoesSuficientesExcecao() {
        super("O cliente não possui ações suficientes");
    }
}
