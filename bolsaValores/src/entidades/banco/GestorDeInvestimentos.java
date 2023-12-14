package entidades.banco;

import entidades.mensagens.MensagemAtualizacao;

public class GestorDeInvestimentos extends Pessoa {
    public GestorDeInvestimentos(String nome, String id) {
        super(nome, id);
    }

    public String solicitarRecomendacao() {
        return "";
    }
}
