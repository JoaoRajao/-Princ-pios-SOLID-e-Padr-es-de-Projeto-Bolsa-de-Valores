package entidades.Excecoes;

public class ClienteNaoPremiumExcecao extends Exception {
    public ClienteNaoPremiumExcecao() {
        super("O cliente não é premium");
    }
}
