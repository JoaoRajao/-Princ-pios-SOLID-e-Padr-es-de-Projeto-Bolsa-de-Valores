package entidades.Excecoes;

public class NaoEhUmaCadeiaSemNumeros extends Exception {
    public NaoEhUmaCadeiaSemNumeros() {
        super("A cadeia não pode conter números");
    }
}
