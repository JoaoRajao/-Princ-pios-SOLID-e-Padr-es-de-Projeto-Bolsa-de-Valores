package entidades.mensagens;

abstract public class Mensagem {
    protected int identificador;

    public Mensagem(int identificador) {
        this.identificador = identificador;
    }
    abstract public String toString();
    abstract public String getTipo();

    public int getIdentificador() {
        return identificador;
    }
}