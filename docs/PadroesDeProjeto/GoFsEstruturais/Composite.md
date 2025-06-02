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

1.  **Herança de `Conteudo`:** A classe `Video` mantém sua relação de herança com a classe `Conteudo`. Dessa forma, ela herda a implementação da interface `ComponenteTrilha`, o que a qualifica para participar da estrutura hierárquica de componentes educacionais.

2.  **Implementação de `exibirDetalhesEspecificos(String indentacao)`:** Seguindo a refatoração da superclasse `Conteudo`, o método `public void exibir()` que existia anteriormente em `Video.java` foi substituído pela implementação do método abstrato `public void exibirDetalhesEspecificos(String indentacao)`.
    * **Foco nos Detalhes do Vídeo:** Este novo método é responsável por exibir unicamente as informações que são específicas de um objeto `Video`, como a `urlVideo`, a `duracaoSegundos` e a disponibilidade da `transcricao`.
    * **Uso da Indentação:** O parâmetro `indentacao` é utilizado para que a saída dessas informações seja corretamente alinhada.
    * **Informações Comuns:** A exibição dos dados genéricos de `Conteudo` (como ID, título principal, descrição geral, visibilidade e data de publicação) é tratada pelo método `exibirInformacoes(String indentacao)` da superclasse `Conteudo`, o qual, por sua vez, chama `exibirDetalhesEspecificos()`.

3.  **Operações de Gerenciamento de Filhos:** Como um `Video` é um elemento "folha" e não pode conter outros `ComponenteTrilha`s, os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) da interface `ComponenteTrilha` são tratados pela implementação padrão herdada de `Conteudo` (que utiliza os métodos `default` da interface, lançando `UnsupportedOperationException`). 


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

A classe `Quiz.java`, que representa um conteúdo interativo destinado à avaliação de conhecimento na plataforma "Galáxia Conectada", foi ajustada para se comportar como um elemento "Folha" (Leaf) na estrutura do padrão Composite.

#### Descrição das Mudanças

As modificações aplicadas à classe `Quiz.java` para sua integração ao padrão Composite foram as seguintes:

1.  **Herança da Classe `Conteudo`:** `Quiz` mantém sua herança da classe `Conteudo`. Com a adaptação de `Conteudo` para implementar `ComponenteTrilha`, a classe `Quiz` também se qualifica como um `ComponenteTrilha`, o que permite sua participação uniforme na hierarquia de componentes educacionais.

2.  **Implementação do Método `exibirDetalhesEspecificos(String indentacao)`:** Seguindo o padrão estabelecido na superclasse `Conteudo`, o método `exibir()` que existia anteriormente em `Quiz.java` foi substituído pela implementação do novo método abstrato `public void exibirDetalhesEspecificos(String indentacao)`.

3.  **Operações de Gerenciamento de Filhos:** Sendo um elemento "folha", um `Quiz` não possui componentes filhos dentro da estrutura Composite. Assim, para os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) definidos na interface `ComponenteTrilha`, a classe `Quiz` utiliza as implementações padrão herdadas de `Conteudo` (que por sua vez vêm da interface `ComponenteTrilha`).

#### Código Atualizado da Classe Quiz

Abaixo o código atualizado para `Quiz.java`:

<details>
  <summary><strong>Código para `Quiz.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 6 abaixo ilustra a estrutura da classe `Quiz.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe Abstrata Quiz.java 
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

### Adaptação da Classe Concreta Jogo

A classe `Jogo.java`, que representa conteúdo educacional em formato de jogo interativo na plataforma "Galáxia Conectada", também foi devidamente ajustada para operar como um elemento "Folha" (Leaf) dentro da arquitetura do padrão Composite. Como uma subclasse de `Conteudo`, ela herda a implementação da interface `ComponenteTrilha`, o que permite a sua integração uniforme na hierarquia de componentes educacionais.

#### Descrição das Mudanças

As principais modificações efetuadas na classe `Jogo.java` para seu alinhamento com o padrão Composite incluem:

1.  **Herança da Classe `Conteudo`:** `Jogo` prossegue estendendo a classe `Conteudo`. Através desta herança, e com a adaptação de `Conteudo` para implementar `ComponenteTrilha`, a classe `Jogo` também se torna um `ComponenteTrilha`, habilitada a participar da estrutura hierárquica do padrão.

2.  **Implementação do Método `exibirDetalhesEspecificos(String indentacao)`:** Conforme o padrão estabelecido na superclasse `Conteudo` e nas demais classes de conteúdo concreto, o método `exibir()` preexistente em `Jogo.java` foi substituído pela implementação do novo método abstrato `public void exibirDetalhesEspecificos(String indentacao)`.

3.  **Operações de Gerenciamento de Filhos:** Por ser um elemento "folha", um `Jogo` não possui componentes filhos na estrutura Composite. Desta forma, para os métodos de gerenciamento de filhos (`adicionar()`, `remover()`, `getFilho()`) especificados na interface `ComponenteTrilha`, a classe `Jogo` (por meio da herança de `Conteudo`).

#### Código Atualizado da Classe Jogo

Abaixo o código atualizado para `Jogo.java`:

<details>
  <summary><strong>Código para `Jogo.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 6 abaixo ilustra a estrutura da classe `Jogo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe Abstrata Jogo.java 
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Implementação dos Elementos Compostos Composite

Após a adaptação dos elementos "Folha" (as classes de `Conteudo`), o próximo passo na implementação do padrão Composite foi refatorar as classes que atuam como agrupadoras ou contêineres: `Modulo` e `TrilhaEducacional`. Estas classes se tornam os "Composites", capazes de conter tanto folhas quanto outros composites, e de operar sobre eles de forma uniforme.

### Adaptação da Classe Modulo

A classe `Modulo.java` é um dos principais elementos compostos na hierarquia educacional da "Galáxia Conectada", pois serve para agrupar diversos `Conteudo`s relacionados a um subtema específico dentro de uma `TrilhaEducacional`.

#### Descrição das Mudanças

Para que a classe `Modulo` pudesse atuar efetivamente como um "Composite" e participar da estrutura hierárquica definida pela interface `ComponenteTrilha`, as seguintes alterações foram implementadas:

1.  **Implementação da Interface `ComponenteTrilha`:** A classe `Modulo` passou a implementar diretamente a interface `ComponenteTrilha`. Esta é a mudança fundamental que a insere no padrão Composite, permitindo que seja tratada da mesma forma que os `Conteudo`s (folhas) e a `TrilhaEducacional` (outro composite) por um código cliente.

2.  **Armazenamento de Componentes Filhos:** A lista interna que anteriormente era específica para `List<Conteudo>` foi generalizada para `private List<ComponenteTrilha> componentesFilhos;`. Como a classe `Conteudo` (e, por conseguinte, suas subclasses `Artigo`, `Video`) agora implementa `ComponenteTrilha`, esta lista é capaz de armazenar os diversos tipos de conteúdo que um módulo pode englobar.

3.  **Implementação Recursiva de `exibirInformacoes(String indentacao)`:** Este método é central para o comportamento do Composite. Em `Modulo.java`, ele foi implementado para:
    * Exibir as informações do próprio módulo (ID, título, ordem, descrição breve), utilizando a `indentacao` para refletir sua posição na hierarquia.
    * Iterar sobre sua coleção de `componentesFilhos` (os `Conteudo`s).
    * Para cada `ComponenteTrilha` filho, invocar recursivamente o método `componente.exibirInformacoes()` com um nível de indentação adicional.
  
4.  **Implementação dos Métodos de Gerenciamento de Filhos:** Os métodos `adicionar(ComponenteTrilha componente)`, `remover(ComponenteTrilha componente)` e `getFilho(int index)`, definidos na interface `ComponenteTrilha`, foram sobrescritos e implementados para manipular a lista `componentesFilhos`. No método `adicionar`, foi incluída uma verificação para assegurar que apenas instâncias de `Conteudo` sejam adicionadas como filhos diretos de um `Modulo`, conforme a regra de negócio do sistema.


#### Código Atualizado da Classe Modulo

Abaixo o código atualizado para `Modulo.java`:

<details>
  <summary><strong>Código para `Modulo.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 7 abaixo ilustra a estrutura da classe `Modulo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 7: Classe Abstrata Modulo.java 
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

### Adaptação da Classe TrilhaEducacional

A classe `TrilhaEducacional.java` representa o nível mais alto na organização do conteúdo de aprendizado, uma vez que funciona como um contêiner principal que agrupa diversos `Modulo`s. Para se integrar ao padrão Composite, ela foi adaptada para atuar como um elemento "Composite" de alto nível.

#### Descrição das Mudanças

As modificações implementadas na classe `TrilhaEducacional.java` para alinhá-la ao padrão Composite e permitir que ela gerencie seus `Modulo`s (que também são `ComponenteTrilha`s) de forma uniforme foram as seguintes:

1.  **Implementação da Interface `ComponenteTrilha`:** A `TrilhaEducacional` agora implementa a interface `ComponenteTrilha`. 

2.  **Armazenamento de Componentes Filhos (Módulos):** A lista interna, que antes era especificamente `List<Modulo>`, foi generalizada para `private List<ComponenteTrilha> componentesFilhos;`.

3.  **Implementação do Método `getTitulo()`:** O método `getTitulo()`, que já existia para retornar o título da trilha, foi mantido e anotado com `@Override` para cumprir o contrato estabelecido pela interface `ComponenteTrilha`.


#### Código Atualizado da Classe TrilhaEducacional

Abaixo o código atualizado para `TrilhaEducacional.java`:

<details>
  <summary><strong>Código para `TrilhaEducacional.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 7 abaixo ilustra a estrutura da classe `TrilhaEducacional.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 7: Classe Abstrata Modulo.java 
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

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


