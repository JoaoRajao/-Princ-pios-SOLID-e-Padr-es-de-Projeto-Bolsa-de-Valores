package entidades.banco;

import entidades.Excecoes.EmpresaNaoEncontradaExcecao;
import entidades.Excecoes.FormatoNaoValidoExcecao;
import entidades.Excecoes.NaoPodeComprarAcoesExcecao;
import entidades.bolsa.BolsaDeValores;
import entidades.mensagens.*;

import java.util.ArrayList;

public class AgenteDeInvestimentos {
    private ArrayList<Mensagem> listaDePedidos;

    public AgenteDeInvestimentos(ArrayList<Mensagem> listaDePedidos) {
        this.listaDePedidos = listaDePedidos;
    }

    public void armazenarMensagem(Mensagem mensagem) {
        this.listaDePedidos.add(mensagem);
    }

    public void comecarATrabalhar(BolsaDeValores bolsaValores) throws FormatoNaoValidoExcecao, EmpresaNaoEncontradaExcecao, NaoPodeComprarAcoesExcecao {
        ArrayList<Mensagem> pedidos = this.listaDePedidos;

        for (Mensagem pedido : pedidos) {
            System.out.println(elaborarMensagemResposta(executarPedido(pedido, bolsaValores)));
        }
    }

    public String executarPedido(Mensagem pedido, BolsaDeValores bolsaValores) throws FormatoNaoValidoExcecao, EmpresaNaoEncontradaExcecao, NaoPodeComprarAcoesExcecao {
        if (pedido instanceof MensagemCompra) {
            MensagemCompra mensagem = (MensagemCompra) pedido;
            return bolsaValores.realizarOperacaoCompra(mensagem.toString());
        } else if (pedido instanceof MensagemVenda) {
            MensagemVenda mensagem = (MensagemVenda) pedido;
            return bolsaValores.realizarOperacaoVenda(mensagem.toString());
        } else {
            MensagemAtualizacao mensagem = (MensagemAtualizacao) pedido;
            return bolsaValores.realizarOperacaoAtualizacao(mensagem.toString());
        }
    }

    public MensagemRespostaCompra elaborarMensagemResposta(String mensagem) {
        String[] campos = mensagem.split("\\|");
        int identificador = Integer.parseInt(campos[0]);
        String nomeCliente = campos[1];
        boolean operacaoRealizada = Boolean.parseBoolean(campos[2]);
        int numTitulosComprados = Integer.parseInt(campos[3]);
        double precoAcao = Double.parseDouble(campos[4]);
        double dinheiroSobrante = Double.parseDouble(campos[5]);
        MensagemRespostaCompra mensagemResposta = new MensagemRespostaCompra();
        mensagemResposta.elaborarMensagemRespostaCompra(identificador, nomeCliente, operacaoRealizada, numTitulosComprados, precoAcao, dinheiroSobrante);
        return mensagemResposta;
    }
}
