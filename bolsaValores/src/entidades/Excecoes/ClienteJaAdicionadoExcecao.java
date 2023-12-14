package entidades.Excecoes;

public class ClienteJaAdicionadoExcecao extends Exception {
    public ClienteJaAdicionadoExcecao() {
        super("O cliente já foi adicionado a este banco");
    }
}
