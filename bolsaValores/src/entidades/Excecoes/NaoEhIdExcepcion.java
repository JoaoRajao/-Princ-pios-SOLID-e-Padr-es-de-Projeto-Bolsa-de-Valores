package entidades.Excecoes;

public class NaoEhIdExcepcion extends Exception {
    public NaoEhIdExcepcion(){
        super("ID com formato incorreto");
    }
}
