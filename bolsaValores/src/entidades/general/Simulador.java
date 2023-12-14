package entidades.general;

import entidades.banco.Banco;
import entidades.banco.Cliente;
import entidades.bolsa.BolsaDeValores;
import entidades.bolsa.Empresa;

public class Simulador {
    public Simulador() {
        InterfaceDoUsuario interfaceDoUsuario = new InterfaceDoUsuario();
        Cliente primeiroCliente = new Cliente("Davi", "53956431H", 3000);
        Empresa primeiraEmpresa = new Empresa("Bolsa1");
        Banco banco = new Banco("Meu banco", primeiroCliente);
        BolsaDeValores bolsa = new BolsaDeValores("Minha bolsa", primeiraEmpresa);
        switch (interfaceDoUsuario.getOpcao()) {
            case 1:
                banco.imprimirClientes();
                break;
            case 2:
                bolsa.imprimirEmpresas();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                break;
            case 17:
                break;
            case 18:
                break;
            case 0:
                break;
        }
    }
}
