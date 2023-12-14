package entidades.mensagens;

import java.util.StringJoiner;

public class MensagemVenda extends Mensagem {
    protected String nomeCliente;
    protected int acoesVenda;
    protected String nomeEmpresa;

    public MensagemVenda(int identificador, String nomeCliente, String nomeEmpresa, int numAcoes) {
        super(identificador);
        this.acoesVenda = numAcoes;
        this.nomeEmpresa = nomeEmpresa;
    }

    public String toString(){
        StringJoiner sj = new StringJoiner("|");
        sj.add(Integer.toString(this.identificador));
        sj.add(this.nomeCliente);
        sj.add(this.nomeEmpresa);
        sj.add(Integer.toString(this.acoesVenda));
        return sj.toString();
    }

    public final String getTipo() {
        return "venda";
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getAcoesVenda() {
        return acoesVenda;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
}
