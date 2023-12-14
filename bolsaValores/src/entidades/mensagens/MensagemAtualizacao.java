package entidades.mensagens;
import java.util.StringJoiner;

public class MensagemAtualizacao extends Mensagem{

    public MensagemAtualizacao(int identificador) {
        super(identificador);
    }
    public String toString(){
        StringJoiner sj = new StringJoiner("|");
        sj.add(Integer.toString(this.identificador));
        return sj.toString();
    }

    public final String getTipo() {
        return "actualizacion";
    }
}