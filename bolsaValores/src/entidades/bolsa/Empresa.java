package entidades.bolsa;

import java.io.*;

public class Empresa implements Serializable {
    private String nomeEmpresa;
    private double valorAtual;
    private double valorAnterior;

    public Empresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public Empresa(String nomeEmpresa, double valorAtual, double valorAnterior) {
        this(nomeEmpresa);
        this.valorAnterior = valorAnterior;
        this.valorAtual = valorAtual;
    }

    public Empresa(String nomeEmpresa, double valor) {
        this(nomeEmpresa);
        this.valorAnterior = valor;
        this.valorAtual = valor;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public double getValorAnterior() {
        return valorAnterior;
    }

    public void setValorAnterior(double valorAnterior) {
        this.valorAnterior = valorAnterior;
    }

    private void calcularValorAnterior(double valor) {
        this.valorAnterior = valor;
    }

    public void valorAtualEmpresa(double valor) {
        calcularValorAnterior(this.valorAtual);
        this.valorAtual = valor;
    }

    public double diferencaAcoes() {
        return Math.abs(this.valorAtual - this.valorAnterior);
    }

    public String toString() {
        return new StringBuilder("Nome: " + this.nomeEmpresa + ", Valor Atual " + this.valorAtual + ", Valor Anterior " + this.valorAnterior).toString();
    }
}
