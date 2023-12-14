package entidades.Excecoes;

public class NaoEInteiroExcecao extends Exception {
    public NaoEInteiroExcecao() {
        super("Não é um inteiro");
    }
}
