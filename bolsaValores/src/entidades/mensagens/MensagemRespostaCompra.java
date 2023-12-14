package entidades.mensagens;

import entidades.bolsa.Empresa;

import java.util.StringJoiner;

public class MensagemRespostaCompra extends MensagemCompra {
    private boolean operacao;
    private int acoesCompradas;
    private double precoAcao;
    private double dinheiroSobrando;

    public MensagemRespostaCompra(int identificador, String nomeCliente, String nomeEmpresa, double dinheiro, boolean operacao, int numAcoesCompradas, double precoAcao, double dinheiroSobrando) {
        super(identificador, nomeCliente, nomeEmpresa, dinheiro);
        this.operacao = operacao;
        this.acoesCompradas = numAcoesCompradas;
        this.precoAcao = precoAcao;
        this.dinheiroSobrando = dinheiroSobrando;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner("|");
        sj.add(Integer.toString(this.identificador));
        sj.add(this.nomeCliente);
        sj.add(Boolean.toString(this.operacao));
        sj.add(Integer.toString(this.acoesCompradas));
        sj.add(Double.toString(this.precoAcao));
        sj.add(Double.toString(this.dinheiroSobrando));
        return sj.toString();
    }

    public boolean isOperacao() {
        return operacao;
    }

    public int getAcoesCompradas() {
        return acoesCompradas;
    }

    public double getPrecoAcao() {
        return precoAcao;
    }

    public double getDinheiroSobrando() {
        return dinheiroSobrando;
    }
}
