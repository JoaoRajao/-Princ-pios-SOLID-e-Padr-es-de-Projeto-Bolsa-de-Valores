package entidades.Excecoes;

public class SemEmpresaExcecao extends Exception {
    public SemEmpresaExcecao() {
        super("O cliente não possui ações desta empresa");
    }
}
