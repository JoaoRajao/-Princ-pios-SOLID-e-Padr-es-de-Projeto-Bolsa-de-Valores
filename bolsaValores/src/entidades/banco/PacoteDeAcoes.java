package entidades.banco;

public class PacoteDeAcoes {
    private String nomeEmpresa;
    private int numeroDeAcoes;
    private double valorPacote;

    public PacoteDeAcoes(String nomeEmpresa, int numeroDeAcoes, double precoCompra) {
        this.nomeEmpresa = nomeEmpresa;
        this.numeroDeAcoes = numeroDeAcoes;
        this.valorPacote = numeroDeAcoes * precoCompra;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public int getNumeroDeAcoes() {
        return numeroDeAcoes;
    }

    public double getValorPacote() {
        return valorPacote;
    }

    public void atualizarPacoteCompra(int numeroDeAcoes, double precoCompra) {
        this.numeroDeAcoes = this.numeroDeAcoes + numeroDeAcoes;
        this.valorPacote = this.numeroDeAcoes * precoCompra;
    }

    public void atualizarPacoteVenda(int numeroDeAcoes, double precoVenda) {
        this.numeroDeAcoes = this.numeroDeAcoes - numeroDeAcoes;
        this.valorPacote = this.valorPacote - this.numeroDeAcoes * precoVenda;
    }

    public void atualizarPacoteValor(double precoAtualizado) {
        this.valorPacote = this.numeroDeAcoes * precoAtualizado;
    }

    @Override
    public String toString() {
        return "Empresa: " + nomeEmpresa + " Nº de Ações: " + numeroDeAcoes + " Valor do Pacote: " + valorPacote;
    }
}
