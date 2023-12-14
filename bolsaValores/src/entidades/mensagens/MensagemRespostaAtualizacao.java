package entidades.mensagens;

import java.util.ArrayList;
import java.util.StringJoiner;

public class MensagemRespostaAtualizacao extends MensagemAtualizacao {
    private ArrayList<String> nomesEmpresas;
    private ArrayList<Double> valoresEmpresas;

    public MensagemRespostaAtualizacao(int identificador, ArrayList<String> nomesEmpresas, ArrayList<Double> valoresEmpresas){
        super(identificador);
        this.nomesEmpresas = nomesEmpresas;
        this.valoresEmpresas = valoresEmpresas;
    }

    public String toString(){

        StringBuilder sbNomesEmpresas = new StringBuilder("");
        for(String s : nomesEmpresas){
            sbNomesEmpresas.append(s);
            sbNomesEmpresas.append(",");
        }
        sbNomesEmpresas.deleteCharAt(sbNomesEmpresas.lastIndexOf(","));
        StringBuilder sbValoresEmpresas = new StringBuilder("");
        for(Double d : valoresEmpresas){
            sbValoresEmpresas.append(d);
            sbValoresEmpresas.append(",");
        }
        sbValoresEmpresas.deleteCharAt(sbValoresEmpresas.lastIndexOf(","));
        StringJoiner sj = new StringJoiner("|");
        sj.add(Integer.toString(this.identificador));
        sj.add(sbNomesEmpresas.toString());
        sj.add(sbValoresEmpresas.toString());
        return sj.toString();
    }


    public ArrayList<String> getNomesEmpresas() {
        return nomesEmpresas;
    }

    public ArrayList<Double> getValoresEmpresas() {
        return valoresEmpresas;
    }
}
