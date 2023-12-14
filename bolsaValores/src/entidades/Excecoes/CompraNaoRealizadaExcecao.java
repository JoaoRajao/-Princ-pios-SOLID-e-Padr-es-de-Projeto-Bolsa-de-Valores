package entidades.Excecoes;

public class CompraNaoRealizadaExcecao extends Exception {
    public CompraNaoRealizadaExcecao() {
        super("A compra não pôde ser realizada");
    }
}
