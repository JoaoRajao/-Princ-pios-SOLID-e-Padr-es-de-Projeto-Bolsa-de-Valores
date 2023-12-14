package entidades.banco;

import entidades.Excecoes.PacoteNaoEncontradoExcecao;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente extends Pessoa {
    private double saldo;
    private ArrayList<PacoteDeAcoes> carteiraDeAcoes;

    public Cliente(String nome, String id, double saldo) {
        super(nome, id);
        this.saldo = saldo;
        this.carteiraDeAcoes = new ArrayList<>();
    }

    public void adicionarPacoteDeAcoes(PacoteDeAcoes pacoteDeAcoes) {
        carteiraDeAcoes.add(pacoteDeAcoes);
    }

    public void atualizarSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Nome: " + this.nome +
                "\nID: " + this.id +
                "\nSaldo: " + this.saldo +
                "\nCarteira de ações: \n" + this.carteiraDeAcoes;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setCarteiraDeAcoes(ArrayList<PacoteDeAcoes> carteiraDeAcoes) {
        this.carteiraDeAcoes = carteiraDeAcoes;
    }

    public ArrayList<PacoteDeAcoes> getCarteiraDeAcoes() {
        return carteiraDeAcoes;
    }

    public PacoteDeAcoes getPacote(String nomeEmpresa) throws PacoteNaoEncontradoExcecao {
        Iterator<PacoteDeAcoes> itr = carteiraDeAcoes.iterator();
        boolean encontrado = false;
        PacoteDeAcoes pacote = null;
        while (itr.hasNext() && !encontrado) {
            pacote = itr.next();
            encontrado = pacote.getNomeEmpresa().equals(nomeEmpresa);
        }
        if (!encontrado) throw new PacoteNaoEncontradoExcecao();
        return pacote;
    }
}
