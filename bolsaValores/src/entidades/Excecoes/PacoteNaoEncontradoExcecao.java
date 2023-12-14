package entidades.Excecoes;

public class PacoteNaoEncontradoExcecao extends Exception {
    public PacoteNaoEncontradoExcecao() {
        super("Pacote não encontrado");
    }
}
