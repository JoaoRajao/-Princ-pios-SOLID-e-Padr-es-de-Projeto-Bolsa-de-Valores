package entidades.Excecoes;

public class EmpresaNaoEncontradaExcecao extends Exception {
    public EmpresaNaoEncontradaExcecao() {
        super("A empresa não está atualmente na bolsa");
    }
}
