package entidades.general;

import entidades.Excecoes.ForaDoIntervaloExcecao;
import entidades.Excecoes.NaoEInteiroExcecao;

public class InterfaceDoUsuario {
    private int opcao;

    public InterfaceDoUsuario() {
        int opcao = 0;
        boolean semErro = false;
        imprimirMenu();
        do {
            System.out.println("Digite a opção desejada: ");
            try {
                Escaner escaner = new Escaner();
                opcao = escaner.lerInteiro();
                if (opcao <= 0 || opcao >= 18)
                    throw new ForaDoIntervaloExcecao("A opção inserida não é válida, insira uma opção entre 0 e 18.");
                semErro = true;
            } catch (NaoEInteiroExcecao | ForaDoIntervaloExcecao e) {
                System.out.println(e.getMessage());
            }
        } while (!semErro); 
        this.opcao = opcao;
    }

    public int getOpcao() {
        return opcao;
    }

    public void imprimirMenu() {
        System.out.println("0.- Sair");
        System.out.println("------------ESTADO------------");
        System.out.println("1.- Imprimir estado dos clientes");
        System.out.println("2.- Imprimir estado da bolsa");
        System.out.println("-------------BANCO------------");
        System.out.println("3.- Adicionar Cliente");
        System.out.println("4.- Remover Cliente");
        System.out.println("5.- Realizar cópia de segurança");
        System.out.println("6.- Restaurar cópia de segurança");
        System.out.println("7.- Melhorar cliente para premium");
        System.out.println("8.- Solicitar recomendação de investimento");
        System.out.println("-------------BOLSA------------");
        System.out.println("9.- Adicionar Empresa à Bolsa");
        System.out.println("10.- Remover Empresa da Bolsa");
        System.out.println("11.- Atualização de valores");
        System.out.println("12.- Realizar cópia de segurança");
        System.out.println("13.- Restaurar cópia de segurança");
        System.out.println("-----------OPERACIONES----------");
        System.out.println("14.- Solicitar compra de ações");
        System.out.println("15.- Solicitar venda de ações");
        System.out.println("16.- Solicitar atualização de valores");
        System.out.println("-------------BROKER------------");
        System.out.println("17.- Imprimir operações pendentes");
        System.out.println("18.- Executar operações pendentes");
    }
}
