package entidades.Excecoes;

public class NaoPodeComprarAcoesExcecao extends Exception {
    public NaoPodeComprarAcoesExcecao() {
        super("Não é possível comprar ações dessa empresa com o dinheiro fornecido");
    }
}
