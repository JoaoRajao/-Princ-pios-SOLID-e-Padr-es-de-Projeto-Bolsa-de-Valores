package entidades.banco;

import entidades.Excecoes.*;
import entidades.bolsa.BolsaDeValores;
import entidades.mensagens.*;

import java.util.*;


public class Banco {
    private String nome;
    private HashSet<Cliente> clientes;

    public Banco(String nome, Cliente cliente) {
        this.nome = nome;
        this.clientes = new HashSet<>();
        this.clientes.add(cliente);
    }

    public void adicionarCliente(Cliente cliente) throws ClienteJaAdicionadoExcecao {
        if (!this.clientes.add(cliente)) throw new ClienteJaAdicionadoExcecao();
    }

    public void removerCliente(Cliente cliente) throws ClienteNaoEncontradoExcecao {
        if (!this.clientes.contains(cliente)) throw new ClienteNaoEncontradoExcecao();
        this.clientes.remove(cliente);
    }

    public void realizarCopiaSeguranca(){/**/}

    public void restaurarCopiaSeguranca(){/**/}

    public void imprimirClientes() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public void tornarClientePremium(Cliente cliente, String nomeGestorInversores, String idGestorInvestimentos)
        throws ClienteNaoEncontradoExcecao, ClienteJaAdicionadoExcecao, ClienteJaEPremiumExcecao {
    if (!this.clientes.contains(cliente)) throw new ClienteNaoEncontradoExcecao();
    if (cliente instanceof ClientePremium) throw new ClienteJaEPremiumExcecao();
    this.clientes.remove(cliente);
    ClientePremium clientePremium = new ClientePremium(cliente.getNome(), cliente.getId(),
    cliente.getSaldo(), new GestorInvestimentos(nomeGestorInversores, idGestorInvestimentos));
    clientePremium.setCarteraDeAcoes(cliente.getCarteraDeAcoes());
    this.adicionarCliente(clientePremium);
}

    public boolean clienteTemSaldoSuficiente(Cliente cliente, double saldo) {
        return cliente.getSaldo() >= saldo;
    }

    public boolean verificarPacote(Cliente cliente, String nomeEmpresa, int numAcoes) {
        try {
            PacoteDeAcoes pacote = cliente.getPacote(nomeEmpresa);
            return pacote.getNumeroDeAcoes() >= numAcoes;
        } catch (PacoteNaoEncontradoExcecao e) {
            return false;
        }
    }

    private Cliente buscarCliente(String nomeCliente) throws ClienteNaoEncontradoExcecao {
        Iterator<Cliente> itr = clientes.iterator();
        boolean encontrado = false;
        Cliente cliente = null;
        while(itr.hasNext() && !encontrado){
            cliente =  itr.next();
            encontrado = cliente.getNome().equals(nomeCliente);
        }
        if (!encontrado) throw new ClienteNaoEncontradoExcecao();
        else return cliente;
    }

    public MensagemCompra realizarCompra(int identificador, String nomeCliente, String nomeEmpresa, double dinheiro)
            throws ClienteNaoEncontradoExcecao, SaldoInsuficienteExcecao {
        Cliente cliente = buscarCliente(nomeCliente);
        if (!clienteTemSaldoSuficiente(cliente, dinheiro)) throw new SaldoInsuficienteExcecao();
        return new MensagemCompra(identificador, nomeCliente, nomeEmpresa, dinheiro);
    }

    public MensagemVenda realizarVenda(int identificador, String nomeCliente, String nomeEmpresa, int numAcoes)
            throws ClienteNaoEncontradoExcecao, AcoesInsuficientesExcecao {
        Cliente cliente = buscarCliente(nomeCliente);
        if(!verificarPacote(cliente, nomeEmpresa, numAcoes)) throw new AcoesInsuficientesExcecao();
        return new MensagemVenda(identificador, nomeCliente, nomeEmpresa, numAcoes);
    }

    public MensagemAtualizacao realizarAtualizacao(int identificador) {
        return new MensagemAtualizacao(identificador);
    }

    public void atualizarCliente(Mensagem mensagem) throws ClienteNaoEncontradoExcecao, CompraNaoRealizadaExcecao,
            VendaNaoRealizadaExcecao {
        switch (mensagem.getTipo()){
            case "compra": {
                if(!(((MensagemRespostaCompra)mensagem).isOperacao())) throw new CompraNaoRealizadaExcecao();
                Cliente cliente = this.buscarCliente(((MensagemRespostaCompra)mensagem).getNomeCliente());
                try {
                    PacoteDeAcoes pacote = cliente.getPacote(((MensagemRespostaCompra)mensagem).getNomeEmpresa());
                    pacote.atualizarPacoteCompra(
                            ((MensagemRespostaCompra)mensagem).getAcoesCompradas(), ((MensagemRespostaCompra)mensagem).getPrecoAcao());
                } catch (PacoteNaoEncontradoExcecao e) {
                    PacoteDeAcoes pacote = new PacoteDeAcoes(((MensagemRespostaCompra)mensagem).getNomeEmpresa(),
                            ((MensagemRespostaCompra)mensagem).getAcoesCompradas(), ((MensagemRespostaCompra)mensagem).getPrecoAcao());
                    cliente.adicionarPacoteDeAcoes(pacote);
                } finally {
                    cliente.setSaldo(cliente.getSaldo() - ((MensagemRespostaCompra)mensagem).getDinheiro() +
                            ((MensagemRespostaCompra)mensagem).getDinheiroSobrante());
                    System.out.println("Operação nº: " + mensagem.getIdentificador());
                    System.out.println("Nome do cliente: " + ((MensagemRespostaCompra)mensagem).getNomeCliente());
                    System.out.println("Comprou " + ((MensagemRespostaCompra)mensagem).getAcoesCompradas() + " ações de "+
                            ((MensagemRespostaCompra)mensagem).getNomeEmpresa()  +" a um preço de " +
                            ((MensagemRespostaCompra)mensagem).getPrecoAcao());
                    System.out.println("O novo saldo do cliente é: " + cliente.getSaldo());
                    System.out.println("Compra realizada com sucesso");
                }
                break;
            }
            case "venda": {
                if(!(((MensagemRespostaVenda)mensagem).isOperacao())) throw new VendaNaoRealizadaExcecao();
                Cliente cliente = this.buscarCliente(((MensagemRespostaVenda)mensagem).getNomeCliente());
                PacoteDeAcoes pacote = null;
                try {
                    pacote = cliente.getPacote(((MensagemRespostaVenda) mensagem).getNomeEmpresa());
                } catch (PacoteNaoEncontradoExcecao excecao) {
                   
                }
             
                    pacote.atualizarPacoteVenda(((MensagemRespostaVenda)mensagem).getAcoesVenda(),
                            ((MensagemRespostaVenda)mensagem).getPrecoAcao());
               
                cliente.setSaldo(cliente.getSaldo() + ((MensagemRespostaVenda)mensagem).getDinheiroDevolvido());
                System.out.println("Operação nº: " + mensagem.getIdentificador());
                System.out.println("Nome do cliente: " + ((MensagemRespostaVenda)mensagem).getNomeCliente());
                System.out.println("Vendeu " + ((MensagemRespostaVenda)mensagem).getAcoesVenda() + " ações de "+
                        ((MensagemRespostaVenda)mensagem).getNomeEmpresa() +" a um" +
                        " preço de " + ((MensagemRespostaVenda)mensagem).getPrecoAcao());
                System.out.println("O novo saldo do cliente é: " + cliente.getSaldo());
                System.out.println("Venda realizada com sucesso");
                break;
            }
            case "atualizacao" :
                System.out.println("Operação nº: " + mensagem.getIdentificador());
                ArrayList<String> nomesEmpresas = ((MensagemRespostaAtualizacao)mensagem).getNomesEmpresas();
                ArrayList<Double> valoresEmpresas = ((MensagemRespostaAtualizacao)mensagem).getValoresEmpresas();
                int numPacotesAtualizados = 0;
                int numPacotesNaoAtualizados = 0;
                int numClientes = 0;
                for (Cliente cliente : clientes) {
                    System.out.println("Nome do cliente: " + cliente.getNome());
                    if (cliente.getCarteraDeAcoes().size() == 0){
                        System.out.println("O cliente não possui ações de nenhuma empresa");
                    }else {
                        for (String nomeEmpresa : nomesEmpresas) {
                            try {
                                PacoteDeAcoes pacote = cliente.getPacote(nomeEmpresa);
                                pacote.atualizarPacoteValor(valoresEmpresas.get(nomesEmpresas.indexOf(nomeEmpresa)));
                                if (pacote.getValorPacote() != pacote.getNumeroDeAcoes() *
                                        valoresEmpresas.get(nomesEmpresas.indexOf(nomeEmpresa))) {
                                    System.out.println("Atualizado o valor das ações de " + nomeEmpresa +
                                            ", o novo valor do pacote é " + pacote.getValorPacote());
                                    numPacotesAtualizados++;
                                } else {
                                    numPacotesNaoAtualizados++;
                                }
                            } catch (PacoteNaoEncontradoExcecao e) {
                                numPacotesNaoAtualizados++;
                            }
                        }
                        if (numPacotesAtualizados == 0) {
                            System.out.println("Nenhum pacote deste cliente foi atualizado");
                        } else if (numPacotesNaoAtualizados == 0) {
                            System.out.println("Todos os pacotes deste cliente foram atualizados");
                            numClientes++;
                        } else {
                            System.out.println("Foram atualizados " + numPacotesAtualizados + " pacotes de ações");
                            System.out.println("Não foram atualizados " + numPacotesNaoAtualizados + " pacotes de ações");
                            numClientes++;
                        }
                    }
                }
                System.out.println("Atualização de pacotes de " + numClientes + " clientes");
                System.out.println("Atualização de pacotes realizada com sucesso");
                break;
        }
    }
}
