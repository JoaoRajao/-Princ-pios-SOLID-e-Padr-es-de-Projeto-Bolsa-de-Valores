package entidades.bolsa;

import entidades.Excecoes.*;

import java.util.ArrayList;
import java.util.StringJoiner;

import static entidades.general.Utilidades.numeroAleatorio;

public class BolsaDeValores {
    public String nomeBolsa;
    public ArrayList<Empresa> listaEmpresas;

    public BolsaDeValores(String nome, Empresa empresa) {
        this.nomeBolsa = nome;
        this.listaEmpresas = new ArrayList<>();
        this.listaEmpresas.add(empresa);
    }

    public void adicionarEmpresa(Empresa empresa) throws EmpresaRepetidaExcecao {
        if (this.listaEmpresas.contains(empresa)) throw new EmpresaRepetidaExcecao();
        this.listaEmpresas.add(empresa);
    }

    public void removerEmpresa(Empresa empresa) throws EmpresaNaoEncontradaExcecao {
        if (!this.listaEmpresas.contains(empresa)) throw new EmpresaNaoEncontradaExcecao();
        this.listaEmpresas.remove(empresa);
    }

    public void imprimirEmpresas() {
        ArrayList<Empresa> empresas = this.listaEmpresas;
        for (Empresa empresa : empresas) {
            System.out.println(empresa.toString());
        }
    }

    public void realizarCopiaSeguranca() {
    }

    public void restaurarCopiaSeguranca() {
    }

    public String realizarOperacaoCompra(String mensagem) throws FormatoNaoValidoExcecao, EmpresaNaoEncontradaExcecao, NaoPodeComprarAcoesExcecao {
        String[] campos = mensagem.split("\\|");

        int identificador = 0;
        String nomeCliente = null;
        String nomeEmpresa = null;
        double dinheiro = 0;

        if (campos.length < 4) throw new FormatoNaoValidoExcecao();

        try {
            identificador = Integer.parseInt(campos[0]);
            nomeCliente = campos[1];
            nomeEmpresa = campos[2];
            dinheiro = (double) Integer.parseInt(campos[3]);
        } catch (NumberFormatException e) {
            throw new FormatoNaoValidoExcecao();
        }

        Empresa empresa = buscarEmpresa(nomeEmpresa);
        Object[] numTitulos = calcularNumTitulo(dinheiro, empresa.getValorAtual());

        int acoesCompradas = (int) numTitulos[0];
        double dinheiroSobrante = (double) numTitulos[1];

        this.listaEmpresas.get(this.listaEmpresas.indexOf(empresa)).valorAtualEmpresa((empresa.getValorAtual() * 0.01) + empresa.getValorAtual());

        StringJoiner sj = new StringJoiner("|");
        sj.add(Integer.toString(identificador));
        sj.add(nomeCliente);
        sj.add(Boolean.toString(acoesCompradas != 0));
        sj.add(Integer.toString(acoesCompradas));
        sj.add(Double.toString(empresa.getValorAtual()));
        sj.add(Double.toString(dinheiroSobrante));
        return sj.toString();
    }

    public String realizarOperacaoVenda(String mensagem) throws FormatoNaoValidoExcecao, EmpresaNaoEncontradaExcecao, NaoPodeComprarAcoesExcecao {
        String[] campos = mensagem.split("\\|");

        int identificador = 0;
        String nomeCliente = null;
        String nomeEmpresa = null;
        int numAcoesVenda = 0;

        if (campos.length < 4) throw new FormatoNaoValidoExcecao();

        try {
            identificador = Integer.parseInt(campos[0]);
            nomeCliente = campos[1];
            nomeEmpresa = campos[2];
            numAcoesVenda = Integer.parseInt(campos[3]);
        } catch (NumberFormatException e) {
            throw new FormatoNaoValidoExcecao();
        }

        Empresa empresa = buscarEmpresa(nomeEmpresa);
        Object[] numTitulos = calcularNumTitulo(numAcoesVenda, empresa.getValorAtual());

        int acoesCompradas = (int) numTitulos[0];
        this.listaEmpresas.get(this.listaEmpresas.indexOf(empresa)).valorAtualEmpresa(empresa.getValorAtual() - (empresa.getValorAtual() * 0.01));

        return new String(identificador + "|" + nomeCliente + "|" + (acoesCompradas != 0) + "|" + numTitulos[0] + "|" + empresa.getValorAtual() + "|" + numTitulos[1]);
    }

    public String realizarOperacaoAtualizacao(String mensagem) {
        return mensagem;
    }

    public Empresa buscarEmpresa(String nomeEmpresa) throws EmpresaNaoEncontradaExcecao {
        boolean encontrada = false;
        int i = 0;
        while (!encontrada && i < this.listaEmpresas.size()) {
            encontrada = this.listaEmpresas.get(i).getNomeEmpresa().equals(nomeEmpresa);
            i++;
        }
        if (!encontrada) throw new EmpresaNaoEncontradaExcecao();
        return this.listaEmpresas.get(i - 1);
    }

    public Object[] calcularNumTitulo(double dinheiro, double valorAtual) throws NaoPodeComprarAcoesExcecao {
        double cociente = (dinheiro / valorAtual);
        int numAcoes = (int) Math.floor(cociente);
        double restoAcoes = cociente - numAcoes;

        if (numAcoes == 0) throw new NaoPodeComprarAcoesExcecao();

        Object[] acoesCompradas = new Object[2];
        acoesCompradas[0] = numAcoes;
        acoesCompradas[1] = restoAcoes * valorAtual;
        return acoesCompradas;
    }

    public void atualizarValoresAcoes() {
        ArrayList<Empresa> empresas = this.listaEmpresas;
        for (Empresa empresa : empresas) {
            empresa.valorAtualEmpresa(numeroAleatorio());
        }
    }

    public String empresaMaiorDiferencaAcoes() {
        ArrayList<Empresa> empresas = this.listaEmpresas;
        double diferenca = 0;
        Empresa empresaMaiorDiferenca = null;
        for (Empresa empresa : empresas) {
            if (diferenca < empresa.diferencaAcoes()) {
                diferenca = empresa.diferencaAcoes();
                empresaMaiorDiferenca = empresa;
            }
        }
        return empresaMaiorDiferenca.getNomeEmpresa();
    }
}
