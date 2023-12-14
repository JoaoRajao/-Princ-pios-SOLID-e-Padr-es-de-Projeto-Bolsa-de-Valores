# Bolsa de Valores

Este projeto implementa um simulador de bolsa de valores que segue os princípios SOLID e utiliza alguns padrões de projeto para estruturar o código de maneira mais modular e expansível.

## Estrutura do Projeto

O projeto está organizado em pacotes que representam diferentes entidades e funcionalidades relacionadas à bolsa de valores. Aqui está uma visão geral da estrutura:

- **entidades.general:** Contém classes de utilidades gerais, como geração de números aleatórios e métodos para manipulação de strings.

- **entidades.Excecoes:** Agrupa exceções personalizadas que podem ser lançadas em diferentes partes do código.

- **entidades.mensagens:** Classes relacionadas a mensagens que podem ser trocadas no sistema, como mensagens de compra, venda e atualização.

- **entidades.banco:** Classes que representam entidades bancárias, como Cliente e Banco.

- **entidades.bolsa:** Classes relacionadas à bolsa de valores, como BolsaDeValores e Empresa.

- **entidades.general:** Classes que compõem a lógica central do simulador, como o Simulador em si e a InterfazDeUsuario, que cuida da interação com o usuário.

## Princípios SOLID

Este projeto adere aos princípios SOLID, que são diretrizes de design de código que visam criar sistemas mais compreensíveis, flexíveis e sustentáveis. A seguir, estão os princípios SOLID considerados neste projeto:

1. **SRP (Princípio da Responsabilidade Única):** Cada classe tem uma única responsabilidade e motivo para mudar.

2. **OCP (Princípio Aberto/Fechado):** As classes são abertas para extensão, mas fechadas para modificação.

3. **LSP (Princípio da Substituição de Liskov):** Objetos de uma classe base podem ser substituídos por objetos de suas classes derivadas sem afetar o comportamento do programa.

4. **ISP (Princípio da Segregação de Interfaces):** Nenhuma classe deve ser forçada a implementar métodos que ela não utiliza.

5. **DIP (Princípio da Inversão de Dependência):** Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações. Além disso, abstrações não devem depender de detalhes; detalhes devem depender de abstrações.

## Padrões de Projeto

Alguns padrões de projeto foram aplicados para estruturar o código de maneira mais eficiente:

1. **Iterator Pattern:** Utilizado no método `buscarCliente` da classe `Banco` para iterar sobre a lista de clientes.

2. **Strategy Pattern:** Potencialmente utilizado em algumas interações com clientes no método `atualizarCliente` da classe `Banco`.

3. **Singleton Pattern:** Não aplicado explicitamente no código, mas pode ser considerado para garantir que determinadas classes tenham uma única instância.

## Instruções para Compilação e Execução

Para compilar o projeto, certifique-se de ter o Java instalado e siga as instruções a seguir:

1. **Compilação:**
   ```bash
   javac entidades/general/*.java entidades/banco/*.java entidades/bolsa/*.java entidades/mensagens/*.java
