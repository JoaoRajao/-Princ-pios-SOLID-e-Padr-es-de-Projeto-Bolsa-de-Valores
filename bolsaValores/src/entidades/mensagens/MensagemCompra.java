package entidades.mensagens;

import java.util.StringJoiner;

public class MensagemCompra extends Mensagem {
    protected String nomeCliente;
    protected double dinheiro;
    protected String nomeEmpresa;

    public MensagemCompra(int identificador, String nomeCliente, String nomeEmpresa, double dinheiro) {
        super(identificador);
        this.nomeEmpresa = nomeEmpresa;
        this.dinheiro = dinheiro;
    }

    public String toString(){
        StringJoiner sj = new StringJoiner("|");
        sj.add(Integer.toString(this.identificador));
        sj.add(this.nomeCliente);
        sj.add(this.nomeEmpresa);
        sj.add(Double.toString(this.dinheiro));
        return sj.toString();
    }

    public final String getTipo() {
        return "compra";
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }
}
