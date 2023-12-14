package entidades.mensagens;

import java.util.StringJoiner;

public class MensagemRespostaVenda extends MensagemVenda {
    private boolean operacao;
    private double precoAcao;
    private double dinheiroDevolvido;

    public MensagemRespostaVenda(int identificador, String nomeCliente, String nomeEmpresa, int numAcoes, boolean operacao, double dinheiroDevolvido, double precoAcao) {
        super(identificador, nomeCliente, nomeEmpresa, numAcoes);
        this.operacao = operacao;
        this.dinheiroDevolvido = dinheiroDevolvido;
        this.precoAcao = precoAcao;
    }

    public String toString() {
        StringJoiner sj = new StringJoiner("|");
        sj.add(Integer.toString(this.identificador));
        sj.add(this.nomeCliente);
        sj.add(Boolean.toString(this.operacao));
        sj.add(Double.toString(this.dinheiroDevolvido));
        sj.add(Double.toString(this.precoAcao));
        return sj.toString();
    }

    public boolean isOperacao() {
        return operacao;
    }

    public double getPrecoAcao() {
        return precoAcao;
    }

    public double getDinheiroDevolvido() {
        return dinheiroDevolvido;
    }
}
