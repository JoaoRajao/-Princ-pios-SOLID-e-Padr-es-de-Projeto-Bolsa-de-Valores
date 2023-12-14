package entidades.Excecoes;

public class ClienteJaEPremiumExcecao extends Exception {
    public ClienteJaEPremiumExcecao() {
        super("O cliente já é premium");
    }
}
