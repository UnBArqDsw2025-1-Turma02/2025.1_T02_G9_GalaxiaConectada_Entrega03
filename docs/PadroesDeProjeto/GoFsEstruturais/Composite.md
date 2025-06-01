# Padrão Estrutural Composite

## Sumário

- [Introdução](#Introdução)
- [Objetivo](#Objetivo)
- [Metodologia](#Metodologia)
- [Motivação para o Padrão Composite](#Motivação-para-o-Padrão-Composite)
- [Desenvolvimento e Implementação](#Desenvolvimento-e-Implementação)
- [Modelagem UML do Padrão Composite](#Modelagem-UML-do-Padrão-Composite)
- [Definição da Interface Componente ComponenteTrilha](#Definição-da-Interface-Componente-ComponenteTrilha)
  - [Descrição e Objetivos da Interface](#Descrição-e-Objetivos-da-Interface)
  - [Código da Interface ComponenteTrilha](#Código-da-Interface-ComponenteTrilha)
  - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
- [Adaptação das Classes Folha Leaf](#Adaptação-das-Classes-Folha-Leaf)
  - [Adaptação da Classe Abstrata Conteudo](#Adaptação-da-Classe-Abstrata-Conteudo)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe Conteudo](#Código-Atualizado-da-Classe-Conteudo)
    - [Imagens do Código no VSCode](#Imagens-do-Código-no-VSCode)
  - [Adaptação da Classe Concreta Artigo](#Adaptação-da-Classe-Concreta-Artigo)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe Artigo](#Código-Atualizado-da-Classe-Artigo)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Adaptação da Classe Concreta Video](#Adaptação-da-Classe-Concreta-Video)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe Video](#Código-Atualizado-da-Classe-Video)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Adaptação da Classe Concreta Quiz](#Adaptação-da-Classe-Concreta-Quiz)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe Quiz](#Código-Atualizado-da-Classe-Quiz)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Adaptação da Classe Concreta Jogo](#Adaptação-da-Classe-Concreta-Jogo)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe Jogo](#Código-Atualizado-da-Classe-Jogo)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
- [Implementação dos Elementos Compostos Composite](#Implementação-dos-Elementos-Compostos-Composite)
  - [Adaptação da Classe Modulo](#Adaptação-da-Classe-Modulo)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe Modulo](#Código-Atualizado-da-Classe-Modulo)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Adaptação da Classe TrilhaEducacional](#Adaptação-da-Classe-TrilhaEducacional)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe TrilhaEducacional](#Código-Atualizado-da-Classe-TrilhaEducacional)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
- [Atualização das Classes Builder](#Atualização-das-Classes-Builder)
  - [Adaptação da Classe ModuloBuilder](#Adaptação-da-Classe-ModuloBuilder)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe ModuloBuilder](#Código-Atualizado-da-Classe-ModuloBuilder)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Adaptação da Classe TrilhaEducacionalBuilder](#Adaptação-da-Classe-TrilhaEducacionalBuilder)
    - [Descrição das Mudanças](#Descrição-das-Mudanças)
    - [Código Atualizado da Classe TrilhaEducacionalBuilder](#Código-Atualizado-da-Classe-TrilhaEducacionalBuilder)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
- [Demonstração de Uso na AplicacaoGalaxia](#Demonstração-de-Uso-na-AplicacaoGalaxia)
  - [Descrição da Interação e Testes](#Descrição-da-Interação-e-Testes)
  - [Código Relevante da Classe AplicacaoGalaxia](#Código-Relevante-da-Classe-AplicacaoGalaxia)
  - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Vídeo da Execução](#Vídeo-da-Execução)
- [Conclusão](#Conclusão)
- [Bibliografia](#Bibliografia)
- [Histórico de Versão](#Histórico-de-Versão)








# Adaptação da Classe Abstrata `Conteudo.java` para o Padrão Composite

Para integrar a hierarquia de `Conteudo` ao padrão Composite, permitindo que tanto conteúdos individuais quanto agrupamentos (como `Modulo` e `TrilhaEducacional`) fossem tratados de forma uniforme, a classe abstrata `Conteudo.java` passou por adaptações significativas. Ela agora serve como a classe base para os elementos "Folha" (Leaf) dentro da estrutura Composite da trilha de aprendizado.

As principais modificações realizadas foram:

1.  **Implementação da Interface `ComponenteTrilha`:**
    A alteração mais fundamental foi fazer com que `Conteudo` implementasse a interface `ComponenteTrilha`. Isso estabelece que todo `Conteudo` (e, por herança, todas as suas subclasses como `Artigo`, `Video`, `Quiz`, `Jogo`) é um tipo de `ComponenteTrilha` e, portanto, deve fornecer as operações definidas por esta interface.
    ```java
    // No arquivo Conteudo.java
    import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;

    public abstract class Conteudo implements ComponenteTrilha {
        // ...
    }
    ```

2.  **Satisfação do Contrato `getTitulo()`:**
    A classe `Conteudo` já possuía um método `public String getTitulo()`. Com a implementação da interface, este método passou a satisfazer um dos requisitos do contrato de `ComponenteTrilha`, necessitando apenas da anotação `@Override` por boa prática.

3.  **Novo Método de Exibição Hierárquica: `exibirInformacoes(String indentacao)`:**
    Este método, exigido pela interface `ComponenteTrilha`, tornou-se o principal responsável pela exibição do estado do `Conteudo` dentro de uma estrutura em árvore. Ele foi implementado para:
    * Receber uma `String indentacao`, permitindo que a saída no console reflita o nível do componente na hierarquia.
    * Exibir os atributos comuns a todo `Conteudo` (como ID, título, data de publicação formatada e visibilidade).
    * Chamar um novo método abstrato, `exibirDetalhesEspecificos(String indentacao)`, para delegar às subclasses a responsabilidade de exibir seus dados particulares.
    A introdução deste método substituiu a necessidade do antigo método abstrato `exibir()`.

    ```java
    // Dentro da classe Conteudo.java
    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Conteúdo (ID: " + id + "): " + titulo + " [Tipo Específico: " + this.getClass().getSimpleName() + "]");
        // ... (impressão de outros dados comuns com indentação) ...
        exibirDetalhesEspecificos(indentacao + "  "); // Chamada para o método abstrato
    }
    ```

4.  **Criação do Método Abstrato `exibirDetalhesEspecificos(String indentacao)`:**
    Para que cada subclasse de `Conteudo` (`Artigo`, `Video`, etc.) pudesse apresentar suas informações únicas de forma formatada dentro da estrutura hierárquica, foi introduzido o método:
    ```java
    public abstract void exibirDetalhesEspecificos(String indentacao);
    ```
    As classes `Artigo`, `Video`, `Quiz` e `Jogo` foram então modificadas para implementar este método, movendo para ele a lógica de exibição que antes residia em seus respectivos métodos `exibir()`.

5.  **Gerenciamento de Filhos (Operações de Composite):**
    Como a classe `Conteudo` e suas subclasses atuam como elementos "Folha" no padrão Composite (ou seja, não possuem outros `ComponenteTrilha` como filhos), elas não precisam de uma implementação própria para os métodos de gerenciamento de filhos (`adicionar(ComponenteTrilha c)`, `remover(ComponenteTrilha c)`, `getFilho(int index)`). Elas utilizam as implementações `default` fornecidas pela interface `ComponenteTrilha`, que corretamente lançam uma `UnsupportedOperationException` se esses métodos forem chamados em um objeto `Conteudo`. Isso está alinhado com o comportamento esperado para um nó folha em uma estrutura Composite transparente.

Essas adaptações permitiram que os objetos `Conteudo` fossem integrados de maneira coesa à estrutura Composite, sendo tratados uniformemente como `ComponenteTrilha` pelas classes compostas (`Modulo` e `TrilhaEducacional`), ao mesmo tempo em que mantêm a capacidade de exibir seus detalhes específicos de forma hierárquica.

# Adaptação da Classe Concreta `Artigo.java` como Folha (Leaf)

A classe `Artigo.java`, sendo uma especialização de `Conteudo`, representa um dos elementos finais (ou "folhas") na hierarquia da estrutura Composite de uma `TrilhaEducacional`. Para se alinhar com o padrão e com as modificações na superclasse `Conteudo`, as seguintes adaptações foram realizadas:

1.  **Herança de `Conteudo` (e indiretamente `ComponenteTrilha`):**
    A classe `Artigo` continua a estender `Conteudo`. Como `Conteudo` agora implementa a interface `ComponenteTrilha`, a classe `Artigo` automaticamente também se torna um `ComponenteTrilha`, herdando a obrigação de participar da estrutura Composite.

2.  **Substituição do Método `exibir()` por `exibirDetalhesEspecificos(String indentacao)`:**
    Seguindo a refatoração da superclasse `Conteudo`, o método `public void exibir()` original da classe `Artigo` foi substituído pela implementação do novo método abstrato `public void exibirDetalhesEspecificos(String indentacao)`.
    * **Responsabilidade:** Este novo método é agora responsável por exibir apenas as informações que são *exclusivas* de um `Artigo`, como seu `textoHtml` (ou uma prévia dele) e a `fonte`.
    * **Uso da Indentação:** O parâmetro `indentacao` é utilizado para formatar a saída no console, garantindo que os detalhes do artigo apareçam corretamente alinhados dentro da estrutura hierárquica quando exibidos como parte de um `Modulo` ou `TrilhaEducacional`.
    * **Dados Comuns:** A exibição dos dados comuns a todos os `Conteudo`s (como ID, título principal, descrição geral, visibilidade e data de publicação) é gerenciada pelo método `exibirInformacoes(String indentacao)` da superclasse `Conteudo`, que por sua vez chama `exibirDetalhesEspecificos()`.

    Exemplo da implementação em `Artigo.java`:
    ```java
    // Dentro da classe Artigo.java
    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns.
        // Aqui, imprimimos apenas o que é específico do Artigo.
        System.out.println(indentacao + "Fonte: " + (this.fonte != null && !this.fonte.isEmpty() ? this.fonte : "Não especificada"));
        System.out.println(indentacao + "Conteúdo HTML (prévia):");
        if (this.textoHtml != null && !this.textoHtml.isEmpty()) {
            String previaHtml = this.textoHtml.replaceAll("<[^>]*>", ""); 
            System.out.println(indentacao + "  " + previaHtml.substring(0, Math.min(previaHtml.length(), 100)) + (previaHtml.length() > 100 ? "..." : ""));
        } else {
            System.out.println(indentacao + "  [Conteúdo HTML não disponível]");
        }
    }
    ```

3.  **Operações de Gerenciamento de Filhos:**
    Como um `Artigo` é um elemento "folha" na estrutura Composite, ele não possui filhos. Portanto, para os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) definidos na interface `ComponenteTrilha`, a classe `Artigo` (através da herança de `Conteudo`) utiliza as implementações padrão da interface, que lançam uma `UnsupportedOperationException`. Este comportamento é o esperado e correto para elementos folha.

Com essas modificações, a classe `Artigo` se integra perfeitamente à estrutura Composite, permitindo que seja tratada de forma uniforme com outros `ComponenteTrilha` (sejam eles outras folhas ou elementos compostos como `Modulo`), ao mesmo tempo em que exibe suas informações características de maneira hierarquicamente organizada. Adaptações similares foram realizadas nas classes `Video.java`, `Quiz.java` e `Jogo.java`.


# Classe Concreta `Jogo.java` como Folha (Leaf)

A classe `Jogo.java`, representando um conteúdo educacional interativo e lúdico, também foi adaptada para funcionar como um elemento "Folha" dentro da estrutura do padrão Composite. Sendo uma subclasse de `Conteudo`, ela herda a implementação da interface `ComponenteTrilha`.

As principais modificações em `Jogo.java` para essa integração foram:

1.  **Herança de `Conteudo`:**
    A classe `Jogo` continua estendendo `Conteudo`. Com `Conteudo` agora implementando `ComponenteTrilha`, a classe `Jogo` também se torna um `ComponenteTrilha`, conformando-se ao contrato necessário para participar da composição hierárquica.

2.  **Substituição do Método `exibir()` por `exibirDetalhesEspecificos(String indentacao)`:**
    Assim como nas outras subclasses de `Conteudo`, o método `public void exibir()` original foi substituído pela implementação do novo método abstrato `public void exibirDetalhesEspecificos(String indentacao)`, herdado de `Conteudo`.
    * **Responsabilidade do Novo Método:** Este método é agora encarregado de exibir apenas as informações que são particulares a um `Jogo`, como seu `tipoJogo`, `nivelDificuldade` e a `urlJogo`.
    * **Uso da Indentação:** O parâmetro `indentacao` é crucial para formatar a saída no console, garantindo que os detalhes do jogo sejam apresentados de forma alinhada e hierárquica quando o jogo for parte de um `Modulo`.
    * **Dados Comuns:** A exibição de informações gerais (ID, título principal, descrição, visibilidade, data de publicação) é gerenciada pelo método `exibirInformacoes(String indentacao)` da superclasse `Conteudo`, que, por sua vez, invoca `exibirDetalhesEspecificos()`.

    Exemplo da implementação em `Jogo.java`:
    ```java
    // Dentro da classe Jogo.java
    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns.
        // Aqui, imprimimos apenas o que é específico do Jogo.
        System.out.println(indentacao + "Tipo de Jogo: " + (this.tipoJogo != null ? this.tipoJogo : "Não especificado"));
        System.out.println(indentacao + "Nível de Dificuldade: " + this.nivelDificuldade);
        System.out.println(indentacao + "URL para Jogar: " + (this.urlJogo != null ? this.urlJogo : "Não disponível"));
    }
    ```

3.  **Métodos Específicos de Jogo (`iniciar`, `registrarPontuacao`):**
    Os métodos `iniciar(Usuario usuario)` e `registrarPontuacao(Object sessaoJogo)` foram mantidos, pois representam comportamentos específicos da entidade `Jogo`. Suas saídas no console podem, opcionalmente, também utilizar a indentação se forem chamados como parte de uma exibição hierárquica detalhada.

4.  **Operações de Gerenciamento de Filhos:**
    Sendo um elemento "folha", um `Jogo` não contém outros `ComponenteTrilha` filhos. Assim, para os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) definidos na interface `ComponenteTrilha`, a classe `Jogo` (via `Conteudo`) utiliza as implementações padrão da interface, que corretamente lançam uma `UnsupportedOperationException`.

Estas adaptações asseguram que a classe `Jogo` se integre harmoniosamente à estrutura Composite, permitindo que seja tratada de maneira uniforme junto a outros componentes da trilha educacional, ao mesmo tempo em que exibe suas informações características de forma organizada e hierárquica.

# Classe Concreta `Quiz.java` como Folha (Leaf)

A classe `Quiz.java`, que representa um conteúdo interativo de avaliação de conhecimento, foi igualmente adaptada para funcionar como um elemento "Folha" (Leaf) na estrutura do padrão Composite. Sendo uma subclasse de `Conteudo`, ela herda a implementação da interface `ComponenteTrilha`.

As principais modificações em `Quiz.java` para esta integração incluem:

1.  **Herança de `Conteudo`:**
    A classe `Quiz` mantém sua herança da classe `Conteudo`. Com a alteração em `Conteudo` para implementar `ComponenteTrilha`, a classe `Quiz` também se torna, por consequência, um `ComponenteTrilha`, apta a participar da estrutura hierárquica do padrão.

2.  **Substituição do Método `exibir()` por `exibirDetalhesEspecificos(String indentacao)`:**
    Em conformidade com a refatoração da superclasse `Conteudo`, o método original `public void exibir()` da classe `Quiz` foi substituído pela implementação do novo método abstrato `public void exibirDetalhesEspecificos(String indentacao)`.
    * **Responsabilidade do Novo Método:** Este método é agora focado em apresentar apenas as informações que são intrínsecas a um `Quiz`, como o `tempoLimiteMin`, o número de `tentativasPermitidas` e a simulação da exibição das perguntas que compõem o quiz.
    * **Uso da Indentação:** O parâmetro `indentacao` é utilizado para formatar a saída no console, assegurando que os detalhes do quiz sejam exibidos de forma alinhada e clara dentro da estrutura hierárquica, especialmente quando o quiz é um componente de um `Modulo`.
    * **Dados Comuns:** Informações gerais como ID, título principal, descrição, visibilidade e data de publicação são exibidas pelo método `exibirInformacoes(String indentacao)` da superclasse `Conteudo`, que subsequentemente invoca `exibirDetalhesEspecificos()`.

    Exemplo da implementação em `Quiz.java`:
    ```java
    // Dentro da classe Quiz.java
    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns.
        // Aqui, imprimimos apenas o que é específico do Quiz.
        System.out.println(indentacao + "Tipo de Interação: Quiz Avaliativo");
        System.out.println(indentacao + "Tempo Limite: " + this.tempoLimiteMin + " minutos");
        System.out.println(indentacao + "Tentativas Permitidas: " + this.tentativasPermitidas);
        System.out.println(indentacao + "Perguntas (simulação):");
        // Lógica placeholder para simular a exibição de perguntas
        if (getTitulo().toLowerCase().contains("planetas")) {
            System.out.println(indentacao + "  1. Qual o maior planeta do Sistema Solar?");
            System.out.println(indentacao + "     a) Terra");
            // ... mais opções e perguntas ...
        } else {
            System.out.println(indentacao + "  1. Pergunta Genérica A sobre " + getTitulo() + "?");
            // ... mais opções ...
        }
    }
    ```

3.  **Métodos Específicos de Quiz (`iniciar`, `submeter`):**
    Os métodos `iniciar(Usuario usuario)` e `submeter(Object tentativaQuiz)` foram mantidos, pois representam comportamentos específicos da entidade `Quiz`. Suas saídas no console foram ligeiramente ajustadas para incluir indentação, melhorando a visualização quando são chamados no contexto de uma exibição hierárquica.

4.  **Operações de Gerenciamento de Filhos:**
    Como um `Quiz` é um elemento "folha" na estrutura Composite (ele não contém outros `ComponenteTrilha`s), para os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) definidos na interface `ComponenteTrilha`, a classe `Quiz` (através da herança de `Conteudo`) utiliza as implementações padrão da interface. Estas implementações corretamente lançam uma `UnsupportedOperationException`, que é o comportamento esperado para elementos folha que não podem ter filhos.

Com estas adaptações, a classe `Quiz` se integra de forma coesa à estrutura Composite, permitindo que seja tratada uniformemente com outros componentes da trilha de aprendizado, ao mesmo tempo em que mantém a capacidade de exibir suas características únicas de maneira organizada e hierárquica.

# Classe Concreta `Video.java` como Folha (Leaf)

A classe `Video.java`, destinada a representar conteúdo audiovisual dentro da plataforma, também foi refatorada para se integrar à estrutura do padrão Composite, atuando como um elemento "Folha" (Leaf). Como uma subclasse de `Conteudo`, ela herda a conformidade com a interface `ComponenteTrilha`.

As modificações chave em `Video.java` para esta adaptação foram:

1.  **Herança de `Conteudo`:**
    A classe `Video` continua sua herança da classe `Conteudo`. Com `Conteudo` implementando `ComponenteTrilha`, `Video` consequentemente se torna um `ComponenteTrilha`, habilitado a fazer parte da composição hierárquica do sistema de trilhas de aprendizado.

2.  **Substituição do Método `exibir()` por `exibirDetalhesEspecificos(String indentacao)`:**
    De forma análoga às outras subclasses de `Conteudo`, o método `public void exibir()` original da classe `Video` foi substituído pela implementação do novo método abstrato `public void exibirDetalhesEspecificos(String indentacao)`, definido na superclasse `Conteudo`.
    * **Responsabilidade do Novo Método:** Este método foca em apresentar apenas as informações que são particulares a um `Video`. Isso inclui a `urlVideo`, a `duracaoSegundos` e informações sobre a disponibilidade da `transcricao`.
    * **Uso da Indentação:** O parâmetro `indentacao` é empregado para formatar adequadamente a saída no console, garantindo que os detalhes do vídeo sejam exibidos de maneira alinhada e clara dentro da estrutura hierárquica, especialmente quando o vídeo é um componente de um `Modulo`.
    * **Dados Comuns:** A responsabilidade pela exibição de informações gerais partilhadas por todos os `Conteudo`s (como ID, título principal, descrição geral, visibilidade e data de publicação) é do método `exibirInformacoes(String indentacao)` da superclasse `Conteudo`, que internamente invoca `exibirDetalhesEspecificos()`.

    Exemplo da implementação em `Video.java`:
    ```java
    // Dentro da classe Video.java
    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns.
        // Aqui, imprimimos apenas o que é específico do Vídeo.
        System.out.println(indentacao + "Tipo de Mídia: Vídeo");
        System.out.println(indentacao + "URL: " + (this.urlVideo != null ? this.urlVideo : "Não disponível"));
        System.out.println(indentacao + "Duração: " + this.duracaoSegundos + " segundos");
        if (this.transcricao != null && !this.transcricao.isEmpty()) {
            System.out.println(indentacao + "Transcrição: Disponível (prévia: " + this.transcricao.substring(0, Math.min(this.transcricao.length(), 30)) + "...)");
        } else {
            System.out.println(indentacao + "Transcrição: Não disponível.");
        }
    }
    ```

3.  **Métodos Específicos de Vídeo (`play`, `pause`):**
    Os métodos `play()` e `pause()`, que representam comportamentos intrínsecos a um objeto `Video`, foram mantidos. Eles podem ser chamados independentemente ou, opcionalmente, invocados como parte da lógica de `exibirDetalhesEspecificos` se a exibição automática for desejada.

4.  **Operações de Gerenciamento de Filhos:**
    Como um `Video` funciona como um nó "folha" na estrutura Composite (ou seja, não possui outros `ComponenteTrilha`s como filhos), para os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) da interface `ComponenteTrilha`, a classe `Video` (via herança de `Conteudo`) utiliza as implementações padrão da interface. Estas implementações corretamente lançam uma `UnsupportedOperationException`, o que é o comportamento adequado para elementos folha que não podem agregar outros componentes.

Com estas alterações, a classe `Video` se alinha ao padrão Composite, podendo ser tratada de forma uniforme com outros `ComponenteTrilha` e exibindo suas informações de forma hierárquica e organizada quando parte de uma estrutura maior como um `Modulo` ou `TrilhaEducacional`.


# Adaptação da Classe `Modulo.java` como Elemento Composto (Composite)

A classe `Modulo.java`, que representa um agrupamento temático de `Conteudo`s dentro de uma `TrilhaEducacional`, foi fundamentalmente adaptada para atuar como um "Composite" no padrão de projeto de mesmo nome. Esta transformação permite que um `Modulo` seja tratado como um `ComponenteTrilha`, assim como seus conteúdos filhos, mas com a capacidade adicional de agregar e gerenciar esses filhos.

As principais alterações e características da classe `Modulo` como um Composite são:

1.  **Implementação da Interface `ComponenteTrilha`:**
    `Modulo` agora implementa diretamente a interface `ComponenteTrilha`. Isso a integra à hierarquia Composite, permitindo que seja tratada de forma uniforme com outros componentes, sejam eles folhas (`Conteudo`) ou outros compostos (`TrilhaEducacional`).

2.  **Gerenciamento de Componentes Filhos:**
    * A lista interna que antes armazenava `Conteudo` foi modificada para `private List<ComponenteTrilha> componentesFilhos;`. Como a classe `Conteudo` (e suas subclasses) agora também implementa `ComponenteTrilha`, esta lista pode armazenar os diversos tipos de conteúdo que compõem o módulo.
    * Foram implementados os métodos de gerenciamento de filhos definidos na interface `ComponenteTrilha`:
        * `adicionar(ComponenteTrilha componente)`: Adiciona um `ComponenteTrilha` (que neste contexto deve ser uma instância de `Conteudo`) à lista de filhos do módulo. Uma verificação foi incluída para garantir que apenas `Conteudo`s sejam adicionados.
        * `remover(ComponenteTrilha componente)`: Remove um componente filho.
        * `getFilho(int index)`: Retorna um componente filho específico.

    Exemplo do método `adicionar`:
    ```java
    // Dentro da classe Modulo.java
    @Override
    public void adicionar(ComponenteTrilha componente) {
        if (componente instanceof com.galaxiaconectada.core.Conteudo) { // Verifica se é um Conteudo
             this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO Modulo] Só é possível adicionar Conteudos a um Módulo.");
        }
    }
    ```

3.  **Implementação Recursiva de `exibirInformacoes(String indentacao)`:**
    Este é um dos aspectos centrais do padrão Composite. O método `exibirInformacoes` em `Modulo` foi implementado para:
    * Primeiro, exibir os detalhes do próprio módulo (ID, título, ordem, descrição breve) utilizando a `indentacao` fornecida.
    * Em seguida, iterar sobre sua lista de `componentesFilhos`. Para cada filho, o método `exibirInformacoes()` do filho é chamado recursivamente, passando uma string de indentação aumentada (ex: `indentacao + "    "`).
    * Isso resulta em uma exibição hierárquica e indentada de toda a estrutura do módulo e seus conteúdos no console.

    Exemplo da lógica recursiva em `exibirInformacoes`:
    ```java
    // Dentro da classe Modulo.java
    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Modulo (ID: " + id + "): " + titulo + " [Ordem: " + ordem + "]");
        System.out.println(indentacao + "  Descrição Breve: " + descricaoBreve);

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Este módulo ainda não possui conteúdos.");
        } else {
            System.out.println(indentacao + "  Conteúdos do Módulo:");
            for (ComponenteTrilha componente : componentesFilhos) {
                componente.exibirInformacoes(indentacao + "    "); // Chamada recursiva
            }
        }
    }
    ```

4.  **Satisfação do Contrato `getTitulo()`:**
    O método `getTitulo()`, já existente, foi mantido e anotado com `@Override` para cumprir o contrato da interface `ComponenteTrilha`.

Através dessas modificações, a classe `Modulo` não apenas agrupa `Conteudo`s, mas também participa ativamente da estrutura Composite, permitindo que operações sejam aplicadas de forma uniforme em toda a hierarquia da `TrilhaEducacional`. A adaptação do `ModuloBuilder` (discutida em sua respectiva seção) foi necessária para garantir que ele construísse instâncias de `Modulo` compatíveis com esta nova estrutura.



#  Adaptação da Classe `ModuloBuilder.java` para o Padrão Composite

Com a refatoração da classe `Modulo` para atuar como um elemento "Composite" (capaz de conter filhos do tipo `ComponenteTrilha`), a classe `ModuloBuilder.java` também necessitou de atualizações para construir instâncias de `Modulo` compatíveis com esta nova estrutura. O objetivo do `ModuloBuilder` continua sendo fornecer uma interface fluente para a construção passo a passo de objetos `Modulo`, mas agora ele lida com a agregação de `ComponenteTrilha` (que, no contexto de um `Modulo`, serão instâncias de `Conteudo`).

As principais modificações na classe `ModuloBuilder` foram:

1.  **Tipo da Lista de Filhos Interna:**
    * O atributo interno do builder que armazena os componentes filhos do módulo foi alterado de `private List<Conteudo> conteudos;` para `private List<ComponenteTrilha> componentesFilhos;`.
    * Esta mudança reflete que um `Modulo` agora gerencia uma coleção de `ComponenteTrilha`, alinhando o builder com o produto que ele constrói.

2.  **Atualização dos Métodos de Adição de Componentes:**
    * O método `adicionarConteudo(Conteudo c)` foi renomeado para `adicionarComponente(ComponenteTrilha componente)`. Embora um `Modulo` na nossa regra de negócio específica só deva conter `Conteudo`s como filhos diretos, o método agora aceita `ComponenteTrilha` para ser consistente com a lista interna. Uma verificação `instanceof Conteudo` foi adicionada dentro deste método para garantir que apenas instâncias de `Conteudo` (ou suas subclasses) sejam efetivamente adicionadas à lista de filhos do módulo.
    * Similarmente, o método `comListaDeConteudos(List<Conteudo> lc)` foi atualizado para `comListaDeComponentes(List<ComponenteTrilha> listaComponentes)`, também com a verificação de tipo para cada elemento da lista.

    Exemplo da assinatura e lógica do novo método de adição:
    ```java
    // Dentro da classe ModuloBuilder.java
    public ModuloBuilder adicionarComponente(ComponenteTrilha componente) {
        if (componente instanceof com.galaxiaconectada.core.Conteudo) {
            this.componentesFilhos.add(componente);
        } else if (componente != null) {
            System.out.println("[AVISO ModuloBuilder] Tentativa de adicionar tipo de componente não-Conteudo a um Módulo. Ignorado.");
        }
        return this;
    }
    ```

3.  **Atualização do Método `build()`:**
    * O método `build()`, responsável por finalizar a construção e retornar a instância de `Modulo`, foi ajustado para chamar o construtor da classe `Modulo` que agora espera uma `List<ComponenteTrilha>` como parâmetro para seus componentes filhos.

    Exemplo da chamada ao construtor no método `build()`:
    ```java
    // Dentro da classe ModuloBuilder.java
    public Modulo build() {
        if (this.titulo == null || this.titulo.trim().isEmpty()) {
            throw new IllegalStateException("O título do módulo é obrigatório e não pode ser vazio.");
        }
        // Passa a lista de componentesFilhos (List<ComponenteTrilha>) para o construtor de Modulo
        return new Modulo(this.id, this.titulo, this.ordem, this.descricaoBreve, this.componentesFilhos);
    }
    ```

Com estas adaptações, o `ModuloBuilder` continua a oferecer uma forma conveniente e robusta para criar objetos `Modulo`, agora totalmente compatível com o papel do `Modulo` como um elemento "Composite" na estrutura hierárquica do padrão. Ele garante que os `Modulo`s sejam construídos corretamente com seus `Conteudo`s (que são `ComponenteTrilha`s) e possam ser integrados em componentes de nível superior, como a `TrilhaEducacional`.


# Adaptação da Classe `TrilhaEducacional.java` como Elemento Composto de Alto Nível (Composite)

A classe `TrilhaEducacional.java`, que representa o percurso de aprendizado completo na plataforma, foi adaptada para funcionar como o elemento "Composite" de mais alto nível na hierarquia de componentes educacionais. Esta transformação permite que uma `TrilhaEducacional` não apenas agrupe `Modulo`s, mas também seja tratada como um `ComponenteTrilha`, participando de forma uniforme em operações que percorrem a estrutura hierárquica.

As principais modificações e características da classe `TrilhaEducacional` como um Composite são:

1.  **Implementação da Interface `ComponenteTrilha`:**
    A classe `TrilhaEducacional` agora implementa a interface `ComponenteTrilha`. Isso a estabelece formalmente como um nó na estrutura Composite, capaz de ser tratada de forma polimórfica junto com `Modulo`s e `Conteudo`s.

2.  **Gerenciamento de Componentes Filhos (Módulos):**
    * A lista interna que anteriormente armazenava `Modulo` diretamente (`List<Modulo> modulos`) foi alterada para `private List<ComponenteTrilha> componentesFilhos;`. Como a classe `Modulo` também foi adaptada para implementar `ComponenteTrilha`, esta lista pode agora armazenar os `Modulo`s que compõem a trilha.
    * Foram implementados os métodos de gerenciamento de filhos definidos na interface `ComponenteTrilha`:
        * `adicionar(ComponenteTrilha componente)`: Adiciona um `ComponenteTrilha` à lista de filhos da trilha. Neste contexto, uma verificação `instanceof Modulo` foi incluída para garantir que apenas instâncias de `Modulo` sejam adicionadas como filhos diretos de uma `TrilhaEducacional`.
        * `remover(ComponenteTrilha componente)`: Remove um módulo filho.
        * `getFilho(int index)`: Retorna um módulo filho específico.

    Exemplo da lógica no método `adicionar`:
    ```java
    // Dentro da classe TrilhaEducacional.java
    @Override
    public void adicionar(ComponenteTrilha componente) {
        if (componente instanceof Modulo) { // Só permite adicionar Modulos
            this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO na Trilha '" + getTitulo() + "'] Tentativa de adicionar um tipo de componente inválido. Apenas Módulos são permitidos.");
        }
    }
    ```

3.  **Implementação Recursiva de `exibirInformacoes(String indentacao)`:**
    O método `exibirInformacoes` na `TrilhaEducacional` é crucial para demonstrar o padrão Composite em ação. Ele foi implementado para:
    * Primeiro, exibir os detalhes da própria trilha (ID, título, nível, categoria, etc.) utilizando a `indentacao` fornecida.
    * Em seguida, iterar sobre sua lista de `componentesFilhos` (que são os `Modulo`s). Para cada `Modulo` filho, o método `exibirInformacoes()` daquele módulo é chamado recursivamente, passando uma string de indentação aumentada.
    * Essa recursão continua até que os elementos "Folha" (`Conteudo`) sejam alcançados e exibam seus detalhes específicos, resultando na impressão de toda a estrutura hierárquica da trilha.

    Trecho da lógica recursiva em `exibirInformacoes`:
    ```java
    // Dentro da classe TrilhaEducacional.java
    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Trilha Educacional (ID: " + id + "): " + titulo);
        // ... (impressão de outros dados da trilha com indentação) ...

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Esta trilha ainda não possui módulos.");
        } else {
            System.out.println(indentacao + "  Módulos da Trilha (" + componentesFilhos.size() + "):");
            for (ComponenteTrilha componenteModulo : componentesFilhos) {
                // Chama o exibirInformacoes de cada Modulo filho
                componenteModulo.exibirInformacoes(indentacao + "    "); 
            }
        }
    }
    ```

4.  **Satisfação do Contrato `getTitulo()`:**
    O método `getTitulo()`, que já existia, foi mantido e anotado com `@Override` para cumprir o contrato da interface `ComponenteTrilha`.

Com estas modificações, `TrilhaEducacional` se torna um poderoso contêiner Composite, capaz de gerenciar seus `Modulo`s (que são eles mesmos Composites) e de participar em operações que percorrem toda a árvore de componentes de forma uniforme. A adaptação do `TrilhaEducacionalBuilder` (detalhada na próxima seção do seu documento) foi essencial para permitir a construção de instâncias de `TrilhaEducacional` que respeitam esta nova estrutura Composite.


# Adaptação da Classe `TrilhaEducacionalBuilder.java` para o Padrão Composite

Após a refatoração da classe `TrilhaEducacional` para atuar como um nó "Composite" de alto nível (capaz de conter `Modulo`s, que por sua vez são `ComponenteTrilha`s), a classe `TrilhaEducacionalBuilder.java` também foi atualizada. O objetivo dessas modificações foi garantir que o builder construísse instâncias de `TrilhaEducacional` compatíveis com a nova estrutura hierárquica e a interface `ComponenteTrilha`.

As principais alterações na classe `TrilhaEducacionalBuilder` foram:

1.  **Tipo da Lista de Filhos Interna:**
    * O atributo interno do builder, que armazena os módulos da trilha durante a construção, foi modificado de `private List<Modulo> modulos;` para `private List<ComponenteTrilha> componentesFilhos;`.
    * Esta alteração é fundamental, pois a classe `TrilhaEducacional` agora espera uma lista de `ComponenteTrilha` em seu construtor (sabendo que, no contexto de uma trilha, esses componentes serão instâncias de `Modulo`).

2.  **Atualização dos Métodos de Adição de Componentes (Módulos):**
    * O método `adicionarModulo(Modulo m)` foi renomeado e adaptado para `adicionarComponente(ComponenteTrilha componente)`. Embora o método agora aceite um `ComponenteTrilha` de forma genérica, uma verificação interna (`instanceof Modulo`) foi adicionada para assegurar que apenas instâncias de `Modulo` sejam efetivamente adicionadas como filhos diretos de uma `TrilhaEducacional`, conforme a regra de negócio estabelecida.
    * Da mesma forma, o método `comListaDeModulos(List<Modulo> lm)` foi atualizado para `comListaDeComponentes(List<ComponenteTrilha> listaComponentes)`, incorporando a mesma lógica de verificação de tipo para cada elemento da lista.

    Exemplo da assinatura e lógica do novo método de adição no builder:
    ```java
    // Dentro da classe TrilhaEducacionalBuilder.java
    public TrilhaEducacionalBuilder adicionarComponente(ComponenteTrilha componente) {
        // Uma Trilha Educacional, no nosso design, só contém Módulos como filhos diretos.
        if (componente instanceof Modulo) {
            this.componentesFilhos.add(componente);
        } else if (componente != null) {
            System.out.println("[AVISO TrilhaBuilder] Tentativa de adicionar um tipo de componente não-Modulo (" + componente.getClass().getSimpleName() + ") a uma Trilha. Ignorado.");
        }
        return this;
    }
    ```

3.  **Atualização do Método `build()`:**
    * O método `build()`, que finaliza a construção e retorna a instância de `TrilhaEducacional`, foi ajustado para invocar o construtor da classe `TrilhaEducacional` que agora espera uma `List<ComponenteTrilha>` como parâmetro para seus módulos.

    Exemplo da chamada ao construtor no método `build()`:
    ```java
    // Dentro da classe TrilhaEducacionalBuilder.java
    public TrilhaEducacional build() {
        if (this.titulo == null || this.titulo.trim().isEmpty()) {
            throw new IllegalStateException("O título da trilha é obrigatório e não pode ser vazio.");
        }
        // Passa a lista de componentesFilhos (List<ComponenteTrilha>) para o construtor de TrilhaEducacional
        return new TrilhaEducacional(this.id, this.titulo, this.descricao, this.nivel,
                                   this.categoria, this.publicada, this.imagemUrl, this.componentesFilhos);
    }
    ```

Com essas adaptações, o `TrilhaEducacionalBuilder` permanece consistente com o produto `TrilhaEducacional` que ele constrói, assegurando que as trilhas sejam montadas corretamente dentro da estrutura do padrão Composite. Ele continua a oferecer uma interface fluente para a criação passo a passo de trilhas complexas, agora plenamente integrado à hierarquia de `ComponenteTrilha`.
