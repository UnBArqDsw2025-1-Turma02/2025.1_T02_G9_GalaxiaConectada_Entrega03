##






### Adaptação da Classe Abstrata `Conteudo.java` para o Padrão Composite

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


#### Adaptação da Classe Concreta `Artigo.java` como Folha (Leaf)

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


###### Classe Concreta `Jogo.java` como Folha (Leaf)

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

##### Classe Concreta `Quiz.java` como Folha (Leaf)

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

###### Classe Concreta `Video.java` como Folha (Leaf)

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
