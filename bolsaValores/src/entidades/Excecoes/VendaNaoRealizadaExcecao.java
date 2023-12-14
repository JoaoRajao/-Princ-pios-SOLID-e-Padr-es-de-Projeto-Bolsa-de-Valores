package entidades.Excecoes;

public class VendaNaoRealizadaExcecao extends Exception {
    public VendaNaoRealizadaExcecao() {
        super("A venda não pôde ser realizada");
    }
}
