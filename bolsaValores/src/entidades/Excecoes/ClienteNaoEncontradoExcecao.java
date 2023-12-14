package entidades.Excecoes;

public class ClienteNaoEncontradoExcecao extends Exception {
    public ClienteNaoEncontradoExcecao() {
        super("Cliente não encontrado neste banco");
    }
}
