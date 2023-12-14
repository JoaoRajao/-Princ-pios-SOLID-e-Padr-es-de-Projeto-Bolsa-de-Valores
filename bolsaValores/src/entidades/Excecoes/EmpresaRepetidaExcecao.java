package entidades.Excecoes;

public class EmpresaRepetidaExcecao extends Exception {
    public EmpresaRepetidaExcecao() {
        super("A empresa já está nesta bolsa");
    }
}
