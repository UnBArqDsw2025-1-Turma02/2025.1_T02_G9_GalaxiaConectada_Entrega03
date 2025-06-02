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


## Introdução

O padrão de projeto Composite, como é explicado em [Composite](https://refactoring.guru/pt-br/design-patterns/composite), é uma solução estrutural que permite compor objetos em estruturas de árvore ao tratar objetos individuais e composições de forma uniforme. Com isso, o seu propósito é permitir que clientes manipulem objetos complexos e simples através de uma interface comum, o que promove flexibilidade e simplicidade no código. Ainda de acordo com [Composite](https://refactoring.guru/pt-br/design-patterns/composite), esse padrão é ideal para representar hierarquias do tipo "parte-todo", como ocorre em sistemas que lidam com elementos agrupáveis e recursivos, como menus, pastas ou estruturas de aprendizado.

Com base nisso, no projeto **Galáxia Conectada**, a aplicação do padrão Composite busca atender a necessidade de organizar elementos educacionais em uma hierarquia lógica e reutilizável. Assim, as **Trilhas Educacionais** representam conjuntos maiores, compostos por Módulos temáticos, os quais agrupam diferentes Conteúdos como artigos, vídeos ou jogos. Ao utilizar uma interface comum (ComponenteTrilha), tanto Conteúdos individuais quanto conjuntos complexos (como Módulos ou Trilhas completas) podem ser tratados uniformemente.

## Objetivo

A aplicação do padrão de projeto estrutural **Composite** na plataforma "Galáxia Conectada" visa estabelecer uma maneira uniforme e flexível de tratar tanto objetos individuais de aprendizado (`Conteudo`) quanto agrupamentos hierárquicos desses objetos (`Modulo`, `TrilhaEducacional`). Com isso, o propósito é construir estruturas em árvore que representem as hierarquias "parte-todo" inerentes aos percursos educacionais, onde uma trilha é composta por módulos, e um módulo é composto por diversos conteúdos.

Os principais objetivos ao utilizar o padrão Composite no contexto das Trilhas Educacionais, Módulos e Conteúdos, inspirados em referências como [Composite Pattern (Refactoring Guru)](https://refactoring.guru/design-patterns/composite) e [Design Pattern: Composite](https://climaco.medium.com/design-pattern-composite-7fcc39c08ff2), são:

* **Tratamento Uniforme:** Permitir que o código trate objetos individuais (folhas, como um `Artigo` ou `Video`) e composições de objetos (compostos, como um `Modulo` ou `TrilhaEducacional`) da mesma maneira através de uma interface comum (`ComponenteTrilha`).
* **Simplificação do Código:** Reduzir a complexidade no código que manipula essas estruturas, pois ele não precisa distinguir explicitamente entre um elemento simples e um grupo de elementos ao realizar operações comuns.
* **Representação de Hierarquias:** Modelar de forma natural e intuitiva as estruturas hierárquicas parte-todo, como uma `TrilhaEducacional` que contém `Modulo`s, os quais por sua vez contêm `Conteudo`s.
* **Facilidade de Adição de Novos Componentes:** Simplificar a adição de novos tipos de `Conteudo` (folhas) ou mesmo novos tipos de agrupadores (compostos) à hierarquia sem impactar significativamente o código.
* **Recursividade em Operações:** Facilitar a aplicação de operações que devem ser propagadas recursivamente por toda a estrutura da árvore.

## Metodologia

Como já foi discutido, o padrão **Composite** é um padrão de projeto estrutural que permite compor objetos em estruturas de árvore para representar hierarquias parte-todo. Fundamentalmente, o Composite permite que sejam tratados os objetos individuais (folhas) e composições de objetos (compostos) de maneira uniforme. 

**Principais Componentes do Padrão Aplicado (com base em [Design Patterns — Parte 10 — Composite](https://medium.com/@jonesroberto/desing-patterns-parte-10-composite-f7600cb3aad7) e na estrutura clássica GoF):**

* **Component (Componente):**
    * **Definição:** Declara a interface para os objetos na composição, tanto para os elementos folha quanto para os compostos. Implementa o comportamento padrão comum a todas as classes, conforme apropriado. 
    * **No Projeto:** A interface `ComponenteTrilha.java` foi criada para este papel, definindo operações como `getTitulo()` e `exibirInformacoes(String indentacao)`, e métodos padrão para gerenciamento de filhos (`adicionar`, `remover`, `getFilho`) que lançam `UnsupportedOperationException` por padrão.

* **Leaf (Folha):**
    * **Definição:** Representa os objetos folha na composição, ou seja, aqueles que não possuem filhos. Define o comportamento para os objetos primitivos na composição.
    * **No Projeto:** A classe abstrata `Conteudo.java` e suas subclasses concretas (`Artigo.java`, `Video.java`, `Quiz.java`, `Jogo.java`) atuam como Leafs. Elas implementam `ComponenteTrilha` e fornecem a lógica para `exibirInformacoes()` através do método `exibirDetalhesEspecificos()`. Para as operações de gerenciamento de filhos, elas utilizam a implementação padrão da interface `ComponenteTrilha` (que lança exceção).

* **Composite (Composto):**
    * **Definição:** Define o comportamento para componentes que têm filhos. Armazena componentes filhos e implementa as operações relacionadas a filhos definidas na interface Component. Suas operações de Componente geralmente delegam para seus filhos.
    * **No Projeto:** As classes `Modulo.java` e `TrilhaEducacional.java` atuam como Composites. Elas implementam `ComponenteTrilha` e mantêm uma lista de `ComponenteTrilha` filhos. Seus métodos `exibirInformacoes()` iteram sobre os filhos, chamando o mesmo método recursivamente. Elas também implementam os métodos `adicionar()`, `remover()` e `getFilho()`.

* **Client (Cliente):**
    * **Definição:** Manipula os objetos na composição através da interface Component.
    * **No Projeto:** A classe `AplicacaoGalaxia.java` atua como Cliente ao construir e interagir com a estrutura hierárquica das trilhas, por exemplo, ao chamar `trilha.exibirInformacoes("")`. As classes Builder (`ModuloBuilder` e `TrilhaEducacionalBuilder`) também atuam como clientes ao montar os objetos Compostos.

A concepção da hierarquia de `TrilhaEducacional`, `Modulo` e `Conteudo`, e a decisão de aplicar o padrão Composite para gerenciá-la, foram informadas pela análise dos seguintes artefatos de modelagem do projeto:

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses) - Indicou a relação de composição natural entre Trilhas, Módulos e Conteúdos.
* **Diagrama de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes) - Ajudou a visualizar como o subsistema de conteúdo interativo (que inclui trilhas) se encaixa na arquitetura geral.
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes) - Orientou a criação do pacote `com.galaxiaconectada.trilhas` e do subpacote `componentes` para as classes do padrão Composite.
* **(Observação: Você listou "Diagrama de Pacotes" duas vezes no seu exemplo de sumário, talvez um deles fosse outro diagrama ou um erro de digitação. Mantive apenas um por enquanto, mas você pode ajustar se necessário.)**
* **Diagrama de Casos de Uso:** [Diagrama de Casos de Uso - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaCasosUso) - A análise de casos de uso como "Consultar Trilha Educacional" ou "Navegar por Módulos" reforçou a necessidade de uma estrutura hierárquica que pudesse ser percorrida e exibida de forma coesa.

**Passo a passo de desenvolvimento da implementação do Composite:**

1.  Identificação da Hierarquia Parte-Todo
2.  Definição da Interface Componente Comum:
3.  Adaptação das Classes "Folha" (Leaf)
4.  Implementação das Classes "Compostas" (Composite)
5.  Atualização das Classes Builder
6.  Demonstração e Teste na classe `AplicacaoGalaxia.java`

## Motivação para o Padrão Composite

A estrutura de aprendizado da "Galáxia Conectada", com Trilhas Educacionais contendo Módulos que, por sua vez, agrupam diversos Conteúdos (Artigos, Vídeos, etc.), forma uma hierarquia natural de "parte-todo". Para manipular esses elementos de forma consistente – seja um Conteúdo individual, um Módulo completo ou uma Trilha inteira – e evitar lógicas condicionais complexas no código, o padrão Composite foi adotado. Como já foi explicado e também é evidenciado em [Padrão Composite](https://diogomoreira.gitbook.io/padroes-de-projeto/padrao-composite), ele permite tratar tanto os objetos simples ("folhas") quanto os agrupamentos ("compostos") através de uma interface comum (ComponenteTrilha), o que simplifica operações como a exibição da estrutura hierárquica e facilita a extensibilidade do sistema educacional da plataforma.

## Desenvolvimento e Implementação

Para o desenvolvimento do padrão Composite no projeto "Galáxia Conectada", foi necessário realizar uma série de etapas de implementação e adaptação das classes existentes. Com isso, este processo envolveu primeiramente a definição da interface `ComponenteTrilha`, que estabelece o contrato comum para todos os objetos na composição. Em seguida, procedeu-se com a refatoração da classe abstrata Conteudo e suas especializações (Artigo, Video, Quiz, Jogo) para que atuassem como os elementos "folha" (Leaf) desta hierarquia. Subsequentemente, as classes Modulo e TrilhaEducacional foram implementadas como elementos "compostos" (Composite), o que as tornou capazes de agregar outros componentes (ComponenteTrilha). 

Foram também cruciais as atualizações nas classes `ModuloBuilder` e `TrilhaEducacionalBuilder`, ao assegurar que a construção desses objetos estivesse alinhada com a nova estrutura Composite. Todo este desenvolvimento foi conduzido em Java, utilizando o Visual Studio Code (VSCode) como ambiente de desenvolvimento principal.

## Modelagem UML do Padrão Composite

A figura 1 abaixo mostra a modelagem do Padrão Composite

<div align="center">
    Figura 1: modelagem do Padrão Composite
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

## Definição da Interface Componente ComponenteTrilha

No cerne do padrão Composite está a definição de uma interface ou classe abstrata comum para todos os objetos da hierarquia, como é explicado em [Criando Objetos Compostos com o Padrão Composite](https://engsoftmoderna.info/artigos/composite.html), sejam eles elementos simples (folhas) ou agrupamentos (compostos). Para o sistema de trilhas educacionais da "Galáxia Conectada", esta responsabilidade é da interface `ComponenteTrilha`.

### Descrição e Objetivos da Interface

A interface `ComponenteTrilha` é o elemento central Component do padrão Composite no sistema de trilhas educacionais. Com isso, seu objetivo primordial é estabelecer um contrato unificado para todos os elementos da hierarquia – sejam eles Conteudos individuais (folhas) ou agrupamentos como Modulo e TrilhaEducacional (compostos). 

Ao definir operações comuns como getTitulo() e exibirInformacoes(String indentacao), e métodos padrão para gerenciamento de filhos (ex: adicionar(), remover()), `ComponenteTrilha` permite que o código trate qualquer objeto da estrutura de forma uniforme, ao simplificar a manipulação de hierarquias complexas e facilitar operações recursivas, sem a necessidade de diferenciar explicitamente entre objetos simples e compostos.

### Código da Interface ComponenteTrilha

Abaixo o código para `ComponenteTrilha` 

<details>
  <summary><strong>Código para `ComponenteTrilha` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 2 abaixo ilustra a estrutura da classe `ComponenteTrilha` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 2: Classe Produto Modulo.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Adaptação das Classes Folha Leaf

Os elementos "Folha" (Leaf) são os componentes mais básicos na hierarquia do padrão Composite, pois representam os objetos individuais que não possuem filhos. No contexto do projeto "Galáxia Conectada", as diversas formas de `Conteudo` educacional (Artigos, Vídeos, Quizzes, Jogos) atuam como essas folhas. Para integrá-los à estrutura Composite, a classe abstrata `Conteudo` e suas subclasses concretas foram devidamente adaptadas.

### Adaptação da Classe Abstrata Conteudo

A classe `Conteudo.java` serve como a superclasse para todos os tipos de materiais de estudo e, portanto, foi o ponto central para integrar os elementos folha ao padrão Composite.

#### Descrição das Mudanças

Para que `Conteudo` e suas especializações pudessem ser tratados uniformemente dentro da hierarquia da `TrilhaEducacional` através da interface `ComponenteTrilha`, as seguintes modificações foram implementadas na classe abstrata `Conteudo.java`:

1.  **Implementação da Interface `ComponenteTrilha`:** A mudança mais significativa foi declarar que `Conteudo` implementa `ComponenteTrilha`. Isso assegura que todo objeto `Conteudo` possa ser tratado **polimorficamente** como um `ComponenteTrilha`.

2.  **Método `getTitulo()`:** A classe `Conteudo` já possuía este método, que agora satisfaz um dos requisitos da interface `ComponenteTrilha`. 

3.  **Novo Método de Exibição Hierárquica - `exibirInformacoes(String indentacao)`:** Este método, exigido pela interface `ComponenteTrilha`, foi implementado para se tornar o principal responsável pela exibição das informações do `Conteudo` de forma hierárquica. Ele utiliza o parâmetro `indentacao` para formatar a saída no console.

4.  **Criação do Método Abstrato `exibirDetalhesEspecificos(String indentacao)`:** Para permitir que cada subclasse de `Conteudo` (como `Artigo`, `Video`, etc.) apresente suas informações particulares.

5.  **Tratamento das Operações de Gerenciamento de Filhos:** Como os objetos `Conteudo` são elementos "folha" e, por definição, não possuem filhos na estrutura Composite, os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) herdados da interface `ComponenteTrilha` não foram sobrescritos.

#### Código Atualizado da Classe Conteudo

Abaixo o código atualizado para `Conteudo.java`:

<details>
  <summary><strong>Código para `Conteudo.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 3 abaixo ilustra a estrutura da classe `Conteudo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: Classe Abstrata Conteudo.java 
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

### Adaptação da Classe Concreta Artigo

A classe `Artigo.java`, que representa um conteúdo textual na plataforma "Galáxia Conectada", é uma das especializações de `Conteudo` e, portanto, atua como um elemento "Folha" (Leaf) na estrutura Composite. Sua adaptação buscou garantir a correta integração e o comportamento uniforme dentro da hierarquia de componentes educacionais.

#### Descrição das Mudanças

As principais adaptações realizadas na classe `Artigo.java` para alinhá-la ao padrão Composite, seguindo as modificações da superclasse `Conteudo`, foram:

1.  **Herança de `Conteudo` Mantida:** `Artigo` continua estendendo `Conteudo`. Como `Conteudo` agora implementa `ComponenteTrilha`, a classe `Artigo` herda essa característica, tornando-se um `ComponenteTrilha` e sendo obrigada a respeitar o contrato definido.

2.  **Implementação de `exibirDetalhesEspecificos(String indentacao)`:** A mudança mais significativa foi a substituição do método `exibir()` original pela implementação do método abstrato `exibirDetalhesEspecificos(String indentacao)`, herdado de `Conteudo`.

3.  **Operações de Gerenciamento de Filhos:** Sendo um elemento "folha", um `Artigo` não possui componentes filhos. Portanto, para os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) da interface `ComponenteTrilha`, a classe `Artigo` depende da implementação padrão fornecida pela superclasse `Conteudo`.

#### Código Atualizado da Classe Artigo

Abaixo o código atualizado para `Artigo.java`:

<details>
  <summary><strong>Código para `Artigo.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 4 abaixo ilustra a estrutura da classe `Artigo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 4: Classe Abstrata Artigo.java 
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

### Adaptação da Classe Concreta Video

A classe `Video.java`, representando conteúdo audiovisual na plataforma "Galáxia Conectada", também foi ajustada para se comportar como um elemento "Folha" (Leaf) dentro da estrutura Composite. Ela estende `Conteudo` e, consequentemente, implementa a interface `ComponenteTrilha`.

#### Descrição das Mudanças

As adaptações realizadas em `Video.java` para sua integração ao padrão Composite foram as seguintes:

1.  **Herança de `Conteudo`:**
    A classe `Video` mantém sua relação de herança com a classe `Conteudo`. Dessa forma, ela herda a implementação da interface `ComponenteTrilha`, o que a qualifica para participar da estrutura hierárquica de componentes educacionais.

2.  **Implementação de `exibirDetalhesEspecificos(String indentacao)`:**
    Seguindo a refatoração da superclasse `Conteudo`, o método `public void exibir()` que existia anteriormente em `Video.java` foi substituído pela implementação do método abstrato `public void exibirDetalhesEspecificos(String indentacao)`.
    * **Foco nos Detalhes do Vídeo:** Este novo método é responsável por exibir unicamente as informações que são específicas de um objeto `Video`, como a `urlVideo`, a `duracaoSegundos` e a disponibilidade da `transcricao`.
    * **Uso da Indentação:** O parâmetro `indentacao` é utilizado para que a saída dessas informações seja corretamente alinhada.
    * **Informações Comuns:** A exibição dos dados genéricos de `Conteudo` (como ID, título principal, descrição geral, visibilidade e data de publicação) é tratada pelo método `exibirInformacoes(String indentacao)` da superclasse `Conteudo`, o qual, por sua vez, chama `exibirDetalhesEspecificos()`.

3.  **Operações de Gerenciamento de Filhos:**
    Como um `Video` é um elemento "folha" e não pode conter outros `ComponenteTrilha`s, os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) da interface `ComponenteTrilha` são tratados pela implementação padrão herdada de `Conteudo` (que utiliza os métodos `default` da interface, lançando `UnsupportedOperationException`). 


#### Código Atualizado da Classe Video

Abaixo o código atualizado para `Video.java`:

<details>
  <summary><strong>Código para `Video.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 5 abaixo ilustra a estrutura da classe `Video.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 5: Classe Abstrata Video.java 
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

### Adaptação da Classe Concreta Quiz

#### Descrição das Mudanças

#### Código Atualizado da Classe Quiz

#### Imagem do Código no VSCode

### Adaptação da Classe Concreta Jogo

#### Descrição das Mudanças

#### Código Atualizado da Classe Jogo

#### Imagem do Código no VSCode

## Implementação dos Elementos Compostos Composite

### Adaptação da Classe Modulo

#### Descrição das Mudanças

#### Código Atualizado da Classe Modulo

#### Imagem do Código no VSCode

### Adaptação da Classe TrilhaEducacional

#### Descrição das Mudanças

#### Código Atualizado da Classe TrilhaEducacional

#### Imagem do Código no VSCode

## Atualização das Classes Builder

### Adaptação da Classe ModuloBuilder

#### Descrição das Mudanças

#### Código Atualizado da Classe ModuloBuilder

#### Imagem do Código no VSCode

### Adaptação da Classe TrilhaEducacionalBuilder

#### Descrição das Mudanças

#### Código Atualizado da Classe TrilhaEducacionalBuilder

#### Imagem do Código no VSCode

## Demonstração de Uso na AplicacaoGalaxia

### Descrição da Interação e Testes

### Código Relevante da Classe AplicacaoGalaxia

### Imagem do Código no VSCode

### Vídeo da Execução

## Conclusão

## Bibliografia

<a name="ref1"></a>
[1] CLIMACO. Design Pattern: Composite. Medium, 2021. Disponível em: https://climaco.medium.com/design-pattern-composite-7fcc39c08ff2. Acesso em: 30 maio–1 jun. 2025.

[2] ENGSOFT MODERNA. Criando objetos compostos com o padrão Composite. Disponível em: https://engsoftmoderna.info/artigos/composite.html. Acesso em: 30 maio–1 jun. 2025.

[3] GURU, Refactoring. Composite – Também conhecido como: Árvore de objetos, Object tree. Disponível em: https://refactoring.guru/pt-br/design-patterns/composite. Acesso em: 30 maio–1 jun. 2025.

[4] JONES, Roberto. Design Patterns — Parte 10 — Composite. Medium, 2019. Disponível em: https://medium.com/@jonesroberto/desing-patterns-parte-10-composite-f7600cb3aad7. Acesso em: 30 maio–1 jun. 2025.

[5] MOREIRA, Diogo. Padrão Composite. In: GitBook. Disponível em: https://diogomoreira.gitbook.io/padroes-de-projeto/padrao-composite. Acesso em: 30 maio–1 jun. 2025.

[6] SOFTPLAN. Composite Design Pattern: What is it, pros and cons and how to implement it?. Disponível em: https://www.softplan.com.br/en/tech-writers/tech-writers-composite. Acesso em: 30 maio–1 jun. 2025.

[7] STACK OVERFLOW. Como funciona na teoria o padrão de projeto Composite?. 2018. Disponível em: https://pt.stackoverflow.com/questions/377303/como-funciona-na-teoria-o-padr%c3%a3o-de-projeto-composite. Acesso em: 30 maio–1 jun. 2025.

## Histórico de Versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 30/05/2025 |
| 1.1 | Adição das mudanças do código | Larissa Stéfane | 30/05/2025 |




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
