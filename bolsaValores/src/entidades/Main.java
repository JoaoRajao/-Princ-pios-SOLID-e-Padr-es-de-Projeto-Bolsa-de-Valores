package entidades;

import entidades.Excecoes.EmpresaNaoEncontradaExcecao;
import entidades.Excecoes.FormatoNaoValidoExcecao;
import entidades.Excecoes.NaoPodeComprarAcoesExcecao;
import entidades.bolsa.BolsaDeValores;
import entidades.bolsa.Empresa;
import entidades.general.InterfaceDoUsuario;
import entidades.general.Utilidades;

public class Principal {

    public static void main(String[] args) throws EmpresaNaoEncontradaExcecao, FormatoNaoValidoExcecao, NaoPodeComprarAcoesExcecao {
        System.out.println(Utilidades.arredondarDecimais(78.123456, 2));
    }

}
