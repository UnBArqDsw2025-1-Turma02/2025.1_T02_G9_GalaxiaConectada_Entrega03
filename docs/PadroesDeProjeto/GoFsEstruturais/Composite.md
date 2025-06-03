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
- [Vídeo Explicação e Execução do Composite para Trilha Módulo e Conteúdo](#Vídeo-Explicação-e-Execução-do-Composite-para-Trilha-Módulo-e-Conteúdo)
- [Demonstração de Uso na AplicacaoGalaxia](#Demonstração-de-Uso-na-AplicacaoGalaxia)
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
2.  Definição da Interface Componente Comum
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
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/6d69b48f4a257dafae3dc150213c50b6bdc64949/docs/PadroesDeProjeto/Imagens/ModelagemComposite.drawio.png" width="1000">
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
package com.galaxiaconectada.trilhas.componentes;

// Interface Componente para o padrão Composite - Define as operações comuns para elementos simples (folhas, como Conteudo)
 
public interface ComponenteTrilha {

    String getTitulo();

    void exibirInformacoes(String indentacao);

    // Métodos para gerenciamento de filhos (abordagem transparente).
    default void adicionar(ComponenteTrilha componente) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }

    default void remover(ComponenteTrilha componente) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }

    default ComponenteTrilha getFilho(int index) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 2 abaixo ilustra a estrutura da classe `ComponenteTrilha` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 2: Classe ComponenteTrilha
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_componenteTrilha.png" width="1000">
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
package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha; // IMPORTANTE: Importar a interface ComponenteTrilha
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Para formatar a data 


public abstract class Conteudo implements ComponenteTrilha { // IMPLEMENTA ComponenteTrilha
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPublicacao;
    private TipoVisibilidade visibilidade;

    
    public Conteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = LocalDateTime.now();
        this.visibilidade = visibilidade;
    }

    
    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Conteúdo (ID: " + id + "): " + titulo + " [Tipo Específico: " + this.getClass().getSimpleName() + "]");
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(indentacao + "  Publicado em: " + (dataPublicacao != null ? dataPublicacao.format(formatador) : "N/A"));
        System.out.println(indentacao + "  Visibilidade: " + (visibilidade != null ? visibilidade.getDescricao() : "N/A"));
        
        // Chama o método que as subclasses implementarão para seus detalhes
        exibirDetalhesEspecificos(indentacao + "  ");
    }

    
    public abstract void exibirDetalhesEspecificos(String indentacao);

    public void adicionarComentario(Usuario usuario, String texto) {
        // Chamado como parte da exibição da estrutura
        System.out.println("    └─ Comentário de " + (usuario != null ? usuario.getNome() : "Anônimo") + ": " + texto);
    }

    // Getters existentes
    public int getId() {
        return id;
    }

    public String getDescricao() { 
        return descricao;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public TipoVisibilidade getVisibilidade() {
        return visibilidade;
    }

    @Override
    public String toString() {
        // O toString pode ser útil para logs ou debug, mas exibirInformacoes é para a estrutura Composite.
        return this.getClass().getSimpleName() + " [id=" + id + ", titulo=" + titulo + "]";
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 3 abaixo ilustra a estrutura da classe `Conteudo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: Classe Abstrata Conteudo.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_conteudo.png" width="1000">
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
package com.galaxiaconectada.core; // Mesmo pacote da classe Conteudo

// Artigo é um tipo de Conteudo e implementa ComponenteTrilha através de Conteudo.
public class Artigo extends Conteudo {
    private String textoHtml; 
    private String fonte;     

    // Construtor do Artigo
    public Artigo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String textoHtml, String fonte) {
        // Chama o construtor da superclasse (Conteudo)
        super(id, titulo, descricao, visibilidade);
        this.textoHtml = textoHtml;
        this.fonte = fonte;
    }

    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID
        System.out.println(indentacao + "Fonte: " + (this.fonte != null && !this.fonte.isEmpty() ? this.fonte : "Não especificada"));
        System.out.println(indentacao + "Conteúdo HTML (prévia):");
        if (this.textoHtml != null && !this.textoHtml.isEmpty()) {
            // Mostra uma prévia do HTML
            String previaHtml = this.textoHtml.replaceAll("<[^>]*>", ""); 
            System.out.println(indentacao + "  " + previaHtml.substring(0, Math.min(previaHtml.length(), 100)) + (previaHtml.length() > 100 ? "..." : ""));
        } else {
            System.out.println(indentacao + "  [Conteúdo HTML não disponível]");
        }
        
    }

    // Getters para os atributos específicos do Artigo
    public String getTextoHtml() {
        return textoHtml;
    }

    public String getFonte() {
        return fonte;
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 4 abaixo ilustra a estrutura da classe `Artigo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 4: Classe Abstrata Artigo.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_artigo.png" width="1000">
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
package com.galaxiaconectada.core;


public class Video extends Conteudo {
    private String urlVideo;     
    private int duracaoSegundos; 
    private String transcricao;   // Atributo para a transcrição do vídeo

    // Construtor do Video
    public Video(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String urlVideo, int duracaoSegundos, String transcricao) {
        super(id, titulo, descricao, visibilidade); // Chama o construtor da classe mãe (Conteudo)
        this.urlVideo = urlVideo;
        this.duracaoSegundos = duracaoSegundos;
        this.transcricao = transcricao;
    }

    // Implementa o método abstrato de Conteudo para exibir os detalhes

    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID, etc.
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

    // Métodos específicos da classe Video
    public void play() { 
        System.out.println("Vídeo '" + getTitulo() + "' está tocando... ▶️");
    }
    
    public void play(String indentacao) {
        System.out.println(indentacao + "Ação: Vídeo '" + getTitulo() + "' está tocando... ▶️");
    }


    public void pause() {
        System.out.println("Vídeo '" + getTitulo() + "' pausado. ⏸️");
    }

    // Getters para os atributos específicos do Video
    public String getUrlVideo() {
        return urlVideo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getTranscricao() {
        return transcricao;
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 5 abaixo ilustra a estrutura da classe `Video.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 5: Classe Abstrata Video.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_video.png" width="1000">
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

package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; 

// Quiz também é um tipo de Conteudo e implementa ComponenteTrilha através de Conteudo.
public class Quiz extends Conteudo {
    private int tempoLimiteMin;       
    private int tentativasPermitidas;

    // Construtor do Quiz
    public Quiz(int id, String titulo, String descricao, TipoVisibilidade visibilidade, int tempoLimiteMin, int tentativasPermitidas) {
        super(id, titulo, descricao, visibilidade); // Chama o construtor de Conteudo
        this.tempoLimiteMin = tempoLimiteMin;
        this.tentativasPermitidas = tentativasPermitidas;
    }

    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID.
        // Imprimimos apenas o que é específico do Quiz.
        System.out.println(indentacao + "Tipo de Interação: Quiz Avaliativo");
        System.out.println(indentacao + "Tempo Limite: " + this.tempoLimiteMin + " minutos");
        System.out.println(indentacao + "Tentativas Permitidas: " + this.tentativasPermitidas);
        System.out.println(indentacao + "Perguntas (simulação):");
        // Lógica placeholder para simular a exibição de perguntas
        if (getTitulo().toLowerCase().contains("planetas")) {
            System.out.println(indentacao + "  1. Qual o maior planeta do Sistema Solar?");
            System.out.println(indentacao + "     a) Terra");
            System.out.println(indentacao + "     b) Júpiter");
            System.out.println(indentacao + "     c) Marte");
        } else {
            System.out.println(indentacao + "  1. Pergunta Genérica A sobre " + getTitulo() + "?");
            System.out.println(indentacao + "     ( ) Opção 1");
        }
    }

    public Object iniciar(Usuario usuario) { 
        System.out.println("  " + (usuario != null ? usuario.getNome() : "Usuário") + " iniciando o quiz: " + getTitulo());
        return null;
    }

    public Object submeter(Object tentativaQuiz) { 
        System.out.println("  Quiz " + getTitulo() + " submetido.");
        return null;
    }

    // Getters para os atributos específicos do Quiz
    public int getTempoLimiteMin() {
        return tempoLimiteMin;
    }

    public int getTentativasPermitidas() {
        return tentativasPermitidas;
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 6 abaixo ilustra a estrutura da classe `Quiz.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe Abstrata Quiz.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_quiz.png" width="1000">
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
package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; // Precisa da classe Usuario para os métodos


public class Jogo extends Conteudo {
    private String tipoJogo;            // Atributos específicos do Jogo
    private int nivelDificuldade;
    private String urlJogo;

    // Construtor do Jogo
    public Jogo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String tipoJogo, int nivelDificuldade, String urlJogo) {
        super(id, titulo, descricao, visibilidade); // Chama o construtor de Conteudo
        this.tipoJogo = tipoJogo;
        this.nivelDificuldade = nivelDificuldade;
        this.urlJogo = urlJogo;
    }

    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID
        // Imprimi apenas o que é específico do Jogo.
        System.out.println(indentacao + "Tipo de Jogo: " + (this.tipoJogo != null ? this.tipoJogo : "Não especificado"));
        System.out.println(indentacao + "Nível de Dificuldade: " + this.nivelDificuldade);
        System.out.println(indentacao + "URL para Jogar: " + (this.urlJogo != null ? this.urlJogo : "Não disponível"));
    }

    public Object iniciar(Usuario usuario) { // Deve retornar SessaoJogo
        System.out.println("  " + (usuario != null ? usuario.getNome() : "Usuário") + " iniciando o jogo: " + getTitulo());
        return null;
    }

    public Object registrarPontuacao(Object sessaoJogo) { // Deveria receber SessaoJogo e retornar PontuacaoJogo
        System.out.println("  Pontuação registrada para o jogo: " + getTitulo());
        return null;
    }

    // Getters para os atributos específicos do Jogo
    public String getTipoJogo() {
        return tipoJogo;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public String getUrlJogo() {
        return urlJogo;
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 6 abaixo ilustra a estrutura da classe `Jogo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe Abstrata Jogo.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_jogo.png" width="1000">
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

package com.galaxiaconectada.trilhas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.util.ArrayList;
import java.util.List;

//Representa um Módulo educacional dentro de uma Trilha.
//Atua como um "Composite" no padrão Composite, pois pode conter outros ComponenteTrilha (especificamente, instâncias de Conteudo).
public class Modulo implements ComponenteTrilha { // IMPLEMENTA ComponenteTrilha
    private int id;
    private String titulo;
    private int ordem;
    private String descricaoBreve;
    // A lista agora armazena ComponenteTrilha, que serão os Conteudos
    private List<ComponenteTrilha> componentesFilhos;


    Modulo(int id, String titulo, int ordem, String descricaoBreve, List<ComponenteTrilha> componentesFilhos) {
        this.id = id;
        this.titulo = titulo;
        this.ordem = ordem;
        this.descricaoBreve = descricaoBreve;
        // Garante que a lista seja inicializada e faz uma cópia da lista passada
        this.componentesFilhos = componentesFilhos != null ? new ArrayList<>(componentesFilhos) : new ArrayList<>();
    }

    // Implementação de getTitulo() da interface ComponenteTrilha
    @Override
    public String getTitulo() {
        return this.titulo;
    }


    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Modulo (ID: " + id + "): " + titulo + " [Ordem: " + ordem + "]");
        System.out.println(indentacao + "  Descrição Breve: " + descricaoBreve);

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Este módulo ainda não possui conteúdos.");
        } else {
            System.out.println(indentacao + "  Conteúdos do Módulo:");
            for (ComponenteTrilha componente : componentesFilhos) {
                // Chama o exibirInformacoes de cada filho (que será um Conteudo)
                componente.exibirInformacoes(indentacao + "    ");
            }
        }
    }

    // Implementação dos métodos de gerenciamento de filhos da interface ComponenteTrilha

    @Override
    public void adicionar(ComponenteTrilha componente) {
        // Um Módulo só pode conter Conteudos como filhos diretos
        if (componente instanceof Conteudo) {
            this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO no Módulo '" + titulo + "'] Tentativa de adicionar um tipo de componente inválido. Apenas Conteúdos são permitidos.");
            
        }
    }


    @Override
    public void remover(ComponenteTrilha componente) {
        this.componentesFilhos.remove(componente);
    }


    @Override
    public ComponenteTrilha getFilho(int index) {
        if (index >= 0 && index < componentesFilhos.size()) {
            return componentesFilhos.get(index);
        }
        return null;
    }


    public int getId() { return id; }
    public int getOrdem() { return ordem; }
    public String getDescricaoBreve() { return descricaoBreve; }


    public List<ComponenteTrilha> getComponentesFilhos() {
        return new ArrayList<>(componentesFilhos);
    }

    @Override
    public String toString() {
        return "Modulo [id=" + id + ", titulo=" + titulo + ", numeroDeConteudos=" + componentesFilhos.size() + "]";
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 7 abaixo ilustra a estrutura da classe `Modulo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 7: Classe Abstrata Modulo.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_Modulo.png" width="1000">
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
package com.galaxiaconectada.trilhas;

import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.util.ArrayList;
import java.util.List;

public class TrilhaEducacional implements ComponenteTrilha { // IMPLEMENTA ComponenteTrilha
    private int id;
    private String titulo;
    private String descricao;
    private String nivel;
    private String categoria;
    private boolean publicada;
    private String imagemUrl;
    //A lista agora armazena ComponenteTrilha, que serão os Modulos
    private List<ComponenteTrilha> componentesFilhos;

   
    TrilhaEducacional(int id, String titulo, String descricao, String nivel,
                          String categoria, boolean publicada, String imagemUrl, List<ComponenteTrilha> componentesFilhos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.categoria = categoria;
        this.publicada = publicada;
        this.imagemUrl = imagemUrl;
        this.componentesFilhos = componentesFilhos != null ? new ArrayList<>(componentesFilhos) : new ArrayList<>();
    }

    // Implementação de getTitulo() da interface ComponenteTrilha
    @Override
    public String getTitulo() {
        return this.titulo;
    }

    //Exibe as informações desta Trilha Educacional e, recursivamente, de todos os seus componentes filhos (Módulos)

    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Trilha Educacional (ID: " + id + "): " + titulo);
        System.out.println(indentacao + "  Nível: " + nivel + ", Categoria: " + categoria);
        System.out.println(indentacao + "  Descrição: " + descricao);
        System.out.println(indentacao + "  Publicada: " + (publicada ? "Sim" : "Não"));
        System.out.println(indentacao + "  Imagem: " + (imagemUrl != null && !imagemUrl.isEmpty() ? imagemUrl : "N/A"));

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Esta trilha ainda não possui módulos.");
        } else {
            System.out.println(indentacao + "  Módulos da Trilha (" + componentesFilhos.size() + "):");
            for (ComponenteTrilha componente : componentesFilhos) {
                // Chama o exibirInformacoes de cada filho (que será um Modulo) com uma indentação adicional.
                componente.exibirInformacoes(indentacao + "    ");
            }
        }
    }

    // Implementação dos métodos de gerenciamento de filhos da interface ComponenteTrilha
    @Override
    public void adicionar(ComponenteTrilha componente) {
        // Uma Trilha Educacional só pode conter Módulos como filhos diretos.
        if (componente instanceof Modulo) {
            this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO na Trilha '" + titulo + "'] Tentativa de adicionar um tipo de componente inválido. Apenas Módulos são permitidos.");
            
        }
    }

    @Override
    public void remover(ComponenteTrilha componente) {
        this.componentesFilhos.remove(componente);
    }

    @Override
    public ComponenteTrilha getFilho(int index) {
        if (index >= 0 && index < componentesFilhos.size()) {
            return componentesFilhos.get(index);
        }
        return null;
    }

    // Getters existentes
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getNivel() { return nivel; }
    public String getCategoria() { return categoria; }
    public boolean isPublicada() { return publicada; }
    public String getImagemUrl() { return imagemUrl; }
    
    public List<ComponenteTrilha> getComponentesFilhos() { 
        return new ArrayList<>(componentesFilhos);
    }


    public float calcularProgressoMedio() {
        System.out.println("[TrilhaEducacional] Calculando progresso médio para: " + titulo);
        return 50.0f; 
    }

    public boolean publicarTrilha() {
        this.publicada = true;
        System.out.println("[TrilhaEducacional] Trilha '" + titulo + "' publicada com sucesso!");
        return true;
    }

    @Override
    public String toString() {
        return "TrilhaEducacional [id=" + id + ", titulo=" + titulo + ", numeroDeModulos=" + componentesFilhos.size() + "]";
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 7 abaixo ilustra a estrutura da classe `TrilhaEducacional.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 7: Classe Abstrata Modulo.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_trilhaEducacional.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Atualização das Classes Builder

Com as classes `Conteudo`, `Modulo` e `TrilhaEducacional` adaptadas para implementar a interface `ComponenteTrilha` e funcionar dentro da estrutura Composite, foi necessário também ajustar suas respectivas classes Builder (`ModuloBuilder` e `TrilhaEducacionalBuilder`). Essas atualizações garantem que os builders construam objetos compatíveis com a nova hierarquia e que possam gerenciar seus filhos como `ComponenteTrilha`.

### Adaptação da Classe ModuloBuilder

A classe `ModuloBuilder` é responsável pela construção passo a passo de objetos `Modulo`. Para que ela pudesse criar `Modulo`s que agora atuam como "Composites" (contendo `Conteudo`s, que são `ComponenteTrilha`s).

#### Descrição das Mudanças

1.  **Tipo da Coleção Interna de Filhos:** O `ModuloBuilder` armazena internamente os componentes que farão parte do `Modulo` sendo construído. Anteriormente, esta era uma `List<Conteudo>`. Para se alinhar com o padrão Composite, onde `Modulo` agora gerencia uma `List<ComponenteTrilha>`,
  
2.  **Atualização dos Métodos de Adição de Filhos:** O método `adicionarConteudo(Conteudo c)` foi modificado para `adicionarComponente(ComponenteTrilha componente)`. Uma verificação interna (`instanceof Conteudo`) foi mantida para assegurar que, no contexto de um `Modulo`, apenas objetos que são efetivamente `Conteudo`s sejam adicionados.

3.  **Atualização do Método `build()`:**
    O método `build()`, que finaliza a construção e retorna a instância de `Modulo`, foi ajustado para chamar o construtor da classe `Modulo` que agora espera uma `List<ComponenteTrilha>` como parâmetro para seus componentes filhos.


#### Código Atualizado da Classe ModuloBuilder

Abaixo o código atualizado para `ModuloBuilder.java`:

<details>
  <summary><strong>Código para `ModuloBuilder.java` </strong></summary>


```java

package com.galaxiaconectada.trilhas;

import com.galaxiaconectada.core.Conteudo; 
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha; // Importar a interface ComponenteTrilha
import java.util.ArrayList;
import java.util.List;

//Builder para a classe Modulo adaptado para trabalhar com a interface ComponenteTrilha para seus filhos.

public class ModuloBuilder {
    private int id;
    private String titulo;
    private int ordem = 0;
    private String descricaoBreve = "";
    private List<ComponenteTrilha> componentesFilhos;

    public ModuloBuilder(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.componentesFilhos = new ArrayList<>(); // Inicializa a lista
    }

    public ModuloBuilder comOrdem(int ordem) {
        this.ordem = ordem;
        return this;
    }


    public ModuloBuilder comDescricaoBreve(String descricao) {
        this.descricaoBreve = descricao;
        return this;
    }

    public ModuloBuilder adicionarComponente(ComponenteTrilha componente) {
        if (componente instanceof Conteudo) {
            this.componentesFilhos.add(componente);
        } else if (componente != null) {
            System.out.println("[AVISO ModuloBuilder] Tentativa de adicionar um tipo de componente não-Conteudo (" + componente.getClass().getSimpleName() + ") a um Módulo. Ignorado.");
        }
        return this;
    }

    
    public ModuloBuilder comListaDeComponentes(List<ComponenteTrilha> listaComponentes) {
        this.componentesFilhos = new ArrayList<>(); // Limpa a lista atual
        if (listaComponentes != null) {
            for (ComponenteTrilha comp : listaComponentes) {
                if (comp instanceof Conteudo) { // Garante que só Conteúdos sejam adicionados
                    this.componentesFilhos.add(comp);
                } else if (comp != null) {
                    System.out.println("[AVISO ModuloBuilder] Componente da lista ignorado (não é Conteudo): " + comp.getClass().getSimpleName());
                }
            }
        }
        return this;
    }


    public Modulo build() {
        if (this.titulo == null || this.titulo.trim().isEmpty()) {
            throw new IllegalStateException("O título do módulo é obrigatório e não pode ser vazio.");
        }
        // Chama o construtor de Modulo, que espera List<ComponenteTrilha>
        return new Modulo(this.id, this.titulo, this.ordem, this.descricaoBreve, this.componentesFilhos);
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 8 abaixo ilustra a estrutura da classe `ModuloBuilder.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 8: Classe Abstrata ModuloBuilder.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_ModuloBuilder.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>


### Adaptação da Classe TrilhaEducacionalBuilder

A classe `TrilhaEducacionalBuilder` é responsável por orquestrar a construção de objetos `TrilhaEducacional`, que são os elementos de mais alto nível na hierarquia de aprendizado da plataforma "Galáxia Conectada". Com a adaptação da `TrilhaEducacional` para atuar como um "Composite" (capaz de conter `Modulo`s, que são também `ComponenteTrilha`s), o `TrilhaEducacionalBuilder` necessitou de ajustes correspondentes para garantir a correta montagem dessa estrutura.

#### Descrição das Mudanças

As modificações implementadas na classe `TrilhaEducacionalBuilder` para alinhá-la com o padrão Composite foram:

1.  **Tipo da Coleção Interna de Filhos (Módulos):** O atributo interno do builder, que armazena os módulos da trilha durante o processo de construção, foi alterado de `private List<Modulo> modulos;` para `private List<ComponenteTrilha> componentesFilhos;`.
  
2.  **Atualização dos Métodos de Adição de Componentes (Módulos):** O método `adicionarModulo(Modulo m)` foi renomeado e adaptado para `adicionarComponente(ComponenteTrilha componente)`. Embora o método aceite agora um `ComponenteTrilha` de forma mais genérica, uma verificação interna com `instanceof Modulo` foi mantida. Isso assegura que, de acordo com as regras de negócio da plataforma, apenas instâncias de `Modulo` sejam adicionadas como filhos diretos de uma `TrilhaEducacional`.

3.  **Atualização do Método `build()`:** O método `build()`, que é responsável por finalizar o processo de construção e retornar a instância de `TrilhaEducacional`, foi ajustado. Agora, ele invoca o construtor da classe `TrilhaEducacional` que espera uma `List<ComponenteTrilha>` como parâmetro para sua coleção de módulos.


#### Código Atualizado da Classe TrilhaEducacionalBuilder

Abaixo o código atualizado para `TrilhaEducacionalBuilder.java`:

<details>
  <summary><strong>Código para `TrilhaEducacionalBuilder.java` </strong></summary>


```java
package com.galaxiaconectada.trilhas;

// Importa a interface ComponenteTrilha e a classe Modulo
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.util.ArrayList;
import java.util.List;

//Adaptado para trabalhar com ComponenteTrilha para seus filhos (Módulos).

public class TrilhaEducacionalBuilder {
    private int id;
    private String titulo;
    private String descricao = "";
    private String nivel = "Indefinido";
    private String categoria = "Geral";
    private boolean publicada = false;
    private String imagemUrl = "";
    //A lista interna é de ComponenteTrilha (que serão os Modulos)
    private List<ComponenteTrilha> componentesFilhos;

    public TrilhaEducacionalBuilder(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.componentesFilhos = new ArrayList<>(); // Inicializa a lista
    }

    public TrilhaEducacionalBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public TrilhaEducacionalBuilder comNivel(String nivel) {
        this.nivel = nivel;
        return this;
    }

    public TrilhaEducacionalBuilder comCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public TrilhaEducacionalBuilder definirComoPublicada(boolean publicada) {
        this.publicada = publicada;
        return this;
    }

    public TrilhaEducacionalBuilder comImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
        return this;
    }

    //Adiciona um ComponenteTrilha (que deve ser um Modulo) à lista de filhos desta trilha.

    public TrilhaEducacionalBuilder adicionarComponente(ComponenteTrilha componente) {
        if (componente instanceof Modulo) {
            this.componentesFilhos.add(componente);
        } else if (componente != null) {
            System.out.println("[AVISO TrilhaBuilder] Tentativa de adicionar um tipo de componente não-Modulo (" + componente.getClass().getSimpleName() + ") a uma Trilha. Ignorado.");
        }
        return this;
    }

    //Define uma lista inteira de ComponenteTrilha (Módulos) para a trilha,
    
    public TrilhaEducacionalBuilder comListaDeComponentes(List<ComponenteTrilha> listaComponentes) {
        this.componentesFilhos = new ArrayList<>(); // Limpa a lista atual
        if (listaComponentes != null) {
            for (ComponenteTrilha comp : listaComponentes) {
                if (comp instanceof Modulo) { // Garante que só Módulos sejam adicionados
                    this.componentesFilhos.add(comp);
                } else if (comp != null) {
                    System.out.println("[AVISO TrilhaBuilder] Componente da lista ignorado (não é Modulo): " + comp.getClass().getSimpleName());
                }
            }
        }
        return this;
    }


    public TrilhaEducacional build() {
        if (this.titulo == null || this.titulo.trim().isEmpty()) {
            throw new IllegalStateException("O título da trilha é obrigatório e não pode ser vazio.");
        }
        // Chama o construtor de TrilhaEducacional
        return new TrilhaEducacional(this.id, this.titulo, this.descricao, this.nivel,
                                   this.categoria, this.publicada, this.imagemUrl, this.componentesFilhos);
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Imagens do Código no VSCode

A figura 9 abaixo ilustra a estrutura da classe `TrilhaEducacionalBuilder.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 9: Classe Abstrata TrilhaEducacionalBuilder.java 
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/2e4d5981c91f003db2b2a015caea3d8798dd4436/docs/PadroesDeProjeto/Imagens/composite_TrilhaEducacionalBuilder.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Vídeo Explicação e Execução do Composite para Trilha Módulo e Conteúdo

O vídeo 1 abaixo mostra explicação e a execução do Composite para Trilha Módulo e Conteúdo


<div align="center">
    Vídeo 1: Singleton para Fórum
    <br>
    <iframe width="1321" height="743" src="https://www.youtube.com/embed/ipsBeEBnjfU" title="Galáxia Conectada: Explicação e Execução do Composite" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
   <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


## Demonstração de Uso na AplicacaoGalaxia

Abaixo está o código da aplicação:

<details>
  <summary><strong>Código para `TAplicacaoGalaxia.java` </strong></summary>


```java

package com.galaxiaconectada.main;

// Imports das fábricas de Conteúdo
import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.comunicacao.Notificacao;
import com.galaxiaconectada.domain.forum.Forum;
import com.galaxiaconectada.domain.forum.Subforum;
import com.galaxiaconectada.fabricas.FabricaDeAdministrador;
import com.galaxiaconectada.fabricas.FabricaDeAluno;
import com.galaxiaconectada.fabricas.FabricaDeArtigo;
import com.galaxiaconectada.fabricas.FabricaDeConteudo;
import com.galaxiaconectada.fabricas.FabricaDeInstrutor;
import com.galaxiaconectada.fabricas.FabricaDeJogo;
import com.galaxiaconectada.fabricas.FabricaDeModerador;
import com.galaxiaconectada.fabricas.FabricaDePapelUsuario;
import com.galaxiaconectada.fabricas.FabricaDeProfessorVoluntario;
import com.galaxiaconectada.fabricas.FabricaDeQuiz;
import com.galaxiaconectada.fabricas.FabricaDeVideo;
import com.galaxiaconectada.prototipos.Conquista;
import com.galaxiaconectada.prototipos.PrototipoClonavel;
import com.galaxiaconectada.prototipos.RegistroDePrototipos; // Importante para o Composite
import com.galaxiaconectada.trilhas.ModuloBuilder;
import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.trilhas.TrilhaEducacionalBuilder;
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// import java.time.format.DateTimeFormatter; // Usado internamente nas classes de exibição

public class AplicacaoGalaxia {

    private static FabricaDeConteudo fabricaDeConteudoAtual;
    private static FabricaDePapelUsuario fabricaDePapelAtual;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();
    private static List<TrilhaEducacional> trilhasCriadas = new ArrayList<>();
    private static RegistroDePrototipos registroDePrototipos = new RegistroDePrototipos();

    public static void main(String[] args) {
        System.out.println("### Bem-vindo(a) à Plataforma Interativa Galáxia Conectada ###");
        carregarPrototiposIniciais();
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            exibirMenuPrincipalGeral();
            int escolha = lerOpcaoDoUsuarioNumerica();

            switch (escolha) {
                case 1: gerenciarPublicacaoDeConteudo(); break;
                case 2: gerenciarUsuariosEPapeis(); break;
                case 3: gerenciarCriacaoDeTrilha(); break; // Testa o Builder e o Composite
                case 4: gerenciarClonagemDePrototipos(); break;
                case 5: gerenciarForumSingleton(); break;
                case 0:
                    continuarExecutando = false;
                    System.out.println("\n[SISTEMA] Desligando a plataforma. Até a próxima exploração estelar!");
                    break;
                default:
                    System.out.println("\n[ERRO] Opção inválida! Por favor, escolha um número do menu.");
            }
        }
        scanner.close();
        System.out.println("### Plataforma Galáxia Conectada Finalizada ###");
    }

    public static void carregarPrototiposIniciais() {
        System.out.println("\n[SISTEMA] Carregando protótipos iniciais no registro...");
        Conquista cProto1 = new Conquista(1000, "Pioneiro Intergaláctico", "Primeiro login na plataforma.", "icone_pioneiro.png", 50);
        registroDePrototipos.adicionarPrototipo("CONQUISTA_PIONEIRO", cProto1);
        Conquista cProto2 = new Conquista(1001, "Mestre das Trilhas Nv.1", "Completou sua primeira trilha educacional.", "icone_trilha_nv1.png", 150);
        registroDePrototipos.adicionarPrototipo("CONQUISTA_TRILHA_NV1", cProto2);
        Notificacao nProto1 = new Notificacao(0, "BEM_VINDO_PLATAFORMA", "Olá, [NomeUsuario]! Seja muito bem-vindo(a) à Galáxia Conectada!", "/painel");
        registroDePrototipos.adicionarPrototipo("NOTIFICACAO_BEM_VINDO", nProto1);
        Notificacao nProto2 = new Notificacao(0, "NOVA_CONQUISTA_GERAL", "Parabéns, [NomeUsuario]! Você desbloqueou: [NomeConquista]!", "/perfil/conquistas");
        registroDePrototipos.adicionarPrototipo("NOTIFICACAO_CONQUISTA", nProto2);
        System.out.println("[SISTEMA] Protótipos carregados com sucesso!");
    }

    public static void exibirMenuPrincipalGeral() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Gerenciar Publicação de Conteúdo (Factory Method)");
        System.out.println("2. Gerenciar Usuários e Papéis (Factory Method)");
        System.out.println("3. Criar Nova Trilha Educacional (Builder + Composite)");
        System.out.println("4. Testar Padrão Prototype (Clonagem)");
        System.out.println("5. Acessar Fórum Principal (Singleton)");
        System.out.println("0. Sair da Plataforma");
        System.out.print("Digite o número da sua opção: ");
    }

    public static int lerOpcaoDoUsuarioNumerica() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine();
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("[ERRO] Entrada inválida. Por favor, digite um número.");
            scanner.nextLine();
            return -1;
        }
    }

    // ---- SEÇÃO DE GERENCIAMENTO DE CONTEÚDO ----
    public static void gerenciarPublicacaoDeConteudo() {
        boolean continuarNoMenuConteudo = true;
        while (continuarNoMenuConteudo) {
            exibirMenuPublicacaoConteudo();
            int escolha = lerOpcaoDoUsuarioNumerica();
            switch (escolha) {
                case 1: processarPublicacaoDeTipoEspecifico("ARTIGO"); break;
                case 2: processarPublicacaoDeTipoEspecifico("VIDEO"); break;
                case 3: processarPublicacaoDeTipoEspecifico("QUIZ"); break;
                case 4: processarPublicacaoDeTipoEspecifico("JOGO"); break;
                case 0: continuarNoMenuConteudo = false; System.out.println("\n[SISTEMA] Voltando ao Menu Principal..."); break;
                default: System.out.println("\n[ERRO] Opção inválida!");
            }
        }
    }

    public static void exibirMenuPublicacaoConteudo() {
        System.out.println("\n--- MENU DE PUBLICAÇÃO DE CONTEÚDO ---");
        System.out.println("1. Publicar um Artigo");
        System.out.println("2. Publicar um Vídeo");
        System.out.println("3. Publicar um Quiz");
        System.out.println("4. Publicar um Jogo");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Digite o número da sua opção: ");
    }

    public static void processarPublicacaoDeTipoEspecifico(String tipoConteudo) {
        System.out.println("\n=== Iniciando Publicação de um Novo " + tipoConteudo.toUpperCase() + " ===");
        configurarFabricaDeConteudo(tipoConteudo);
        System.out.println("[FÁBRICA SELECIONADA]: " + fabricaDeConteudoAtual.getClass().getSimpleName());
        System.out.println("   ↳ Explicação: Esta fábrica é uma especialista! Sabe como construir '" + tipoConteudo + "'.");
        System.out.println("\n--- Coletando Dados Comuns do Conteúdo ---");
        System.out.print("ID do conteúdo (número): "); int id = lerOpcaoDoUsuarioNumerica();
        System.out.print("Título: "); String titulo = scanner.nextLine();
        System.out.print("Descrição: "); String descricao = scanner.nextLine();
        TipoVisibilidade.mostrarOpcoes();
        System.out.print("Escolha o número da Visibilidade: "); int escVis = lerOpcaoDoUsuarioNumerica();
        TipoVisibilidade visibilidadeSel = TipoVisibilidade.fromOpcao(escVis);
        if (visibilidadeSel == null) { visibilidadeSel = TipoVisibilidade.PUBLICO; System.out.println("[INFO] Visibilidade inválida, usando PUBLICO."); }
        System.out.println("[INFO] Visibilidade definida como: " + visibilidadeSel.getDescricao());
        Map<String, Object> detalhes = new HashMap<>();
        System.out.println("\n--- Coletando Dados Específicos para " + tipoConteudo.toUpperCase() + " ---");
        if (tipoConteudo.equalsIgnoreCase("ARTIGO")) {
            System.out.print("Texto HTML: "); detalhes.put("textoHtml", scanner.nextLine());
            System.out.print("Fonte: "); detalhes.put("fonte", scanner.nextLine());
        } else if (tipoConteudo.equalsIgnoreCase("VIDEO")) {
            System.out.print("URL: "); detalhes.put("urlVideo", scanner.nextLine());
            System.out.print("Duração (s): "); detalhes.put("duracaoSegundos", scanner.nextInt()); scanner.nextLine();
            System.out.print("Transcrição: "); detalhes.put("transcricao", scanner.nextLine());
        } else if (tipoConteudo.equalsIgnoreCase("QUIZ")) {
            System.out.print("Tempo Limite (min): "); detalhes.put("tempoLimiteMin", scanner.nextInt()); scanner.nextLine();
            System.out.print("Tentativas: "); detalhes.put("tentativasPermitidas", scanner.nextInt()); scanner.nextLine();
        } else if (tipoConteudo.equalsIgnoreCase("JOGO")) {
            System.out.print("Tipo Jogo: "); detalhes.put("tipoJogo", scanner.nextLine());
            System.out.print("Dificuldade (1-5): "); detalhes.put("nivelDificuldade", scanner.nextInt()); scanner.nextLine();
            System.out.print("URL Jogo: "); detalhes.put("urlJogo", scanner.nextLine());
        }
        System.out.println("\n[FÁBRICA CONTEÚDO AÇÃO] " + fabricaDeConteudoAtual.getClass().getSimpleName() + " criando '" + titulo + "'...");
        fabricaDeConteudoAtual.iniciarPublicacaoDeConteudo(id, titulo, descricao, visibilidadeSel, detalhes); // Este método chama exibirInformacoes internamente
        System.out.println("O " + tipoConteudo.toUpperCase() + " '" + titulo + "' foi processado pela fábrica!");
        System.out.println("==============================================");
    }

    public static void configurarFabricaDeConteudo(String tipoConteudo) {
        if (tipoConteudo.equalsIgnoreCase("ARTIGO")) fabricaDeConteudoAtual = new FabricaDeArtigo();
        else if (tipoConteudo.equalsIgnoreCase("VIDEO")) fabricaDeConteudoAtual = new FabricaDeVideo();
        else if (tipoConteudo.equalsIgnoreCase("QUIZ")) fabricaDeConteudoAtual = new FabricaDeQuiz();
        else if (tipoConteudo.equalsIgnoreCase("JOGO")) fabricaDeConteudoAtual = new FabricaDeJogo();
        else throw new IllegalArgumentException("Tipo de conteúdo desconhecido: " + tipoConteudo);
    }


    public static void gerenciarUsuariosEPapeis() {
        boolean continuarNoMenuUsuario = true;
        while (continuarNoMenuUsuario) {
            exibirMenuUsuariosEPapeis();
            int escolha = lerOpcaoDoUsuarioNumerica();
            switch (escolha) {
                case 1: criarNovoUsuarioBaseInterativo(); break;
                case 2: atribuirPapelInterativo(); break;
                case 3: exibirInformacoesDeUsuarioInterativo(); break;
                case 0: continuarNoMenuUsuario = false; System.out.println("\n[SISTEMA] Voltando ao Menu Principal..."); break;
                default: System.out.println("\n[ERRO] Opção inválida!");
            }
        }
    }

    public static void exibirMenuUsuariosEPapeis() {
        System.out.println("\n--- MENU DE GERENCIAMENTO DE USUÁRIOS E PAPÉIS ---");
        System.out.println("1. Criar Novo Usuário Base");
        System.out.println("2. Atribuir Papel a um Usuário Existente");
        System.out.println("3. Exibir Informações de um Usuário");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Digite o número da sua opção: ");
    }

    public static void criarNovoUsuarioBaseInterativo() {
        System.out.println("\n--- Criando Novo Usuário Base ---");
        System.out.print("ID (número): "); int id = lerOpcaoDoUsuarioNumerica();
        System.out.print("Nome: "); String nome = scanner.nextLine();
        System.out.print("Email: "); String email = scanner.nextLine();
        System.out.print("Senha: "); String senha = scanner.nextLine();
        Usuario novoUsuario = new Usuario(id, nome, email, senha);
        usuariosCadastrados.add(novoUsuario);
        System.out.println("[USUÁRIO CRIADO] '" + nome + "' (ID: " + id + ") criado.");
        novoUsuario.exibirInformacoesCompletas();
    }

    public static void exibirInformacoesDeUsuarioInterativo() {
        System.out.println("\n--- Exibir Informações de Usuário ---");
        if (usuariosCadastrados.isEmpty()) { System.out.println("[INFO] Nenhum usuário cadastrado."); return; }
        System.out.println("Usuários (escolha pelo número):");
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            Usuario u = usuariosCadastrados.get(i);
            String papelInfo = (u.getPapelPrincipal() != null) ? " (" + u.getPapelPrincipal().getTipoPapel() + ")" : " (Sem papel)";
            System.out.println((i + 1) + ". " + u.getNome() + " (ID: " + u.getId() + ")" + papelInfo);
        }
        System.out.print("Número do usuário (ou 0 para cancelar): "); int escolha = lerOpcaoDoUsuarioNumerica();
        if (escolha > 0 && escolha <= usuariosCadastrados.size()) {
            usuariosCadastrados.get(escolha - 1).exibirInformacoesCompletas();
        } else if (escolha != 0) { System.out.println("[ERRO] Escolha inválida."); }
    }

    public static void atribuirPapelInterativo() {
        System.out.println("\n--- Atribuir Papel a Usuário ---");
        if (usuariosCadastrados.isEmpty()) { System.out.println("[INFO] Crie um usuário primeiro."); return; }
        System.out.println("Usuários (escolha pelo número):");
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            Usuario u = usuariosCadastrados.get(i);
            String papelInfo = (u.getPapelPrincipal() != null) ? " (" + u.getPapelPrincipal().getTipoPapel() + ")" : " (Sem papel)";
            System.out.println((i + 1) + ". " + u.getNome() + " (ID: " + u.getId() + ")" + papelInfo);
        }
        System.out.print("Número do usuário (ou 0 para cancelar): "); int escolhaUsuarioNum = lerOpcaoDoUsuarioNumerica();
        if (escolhaUsuarioNum == 0) { System.out.println("[INFO] Atribuição cancelada."); return; }
        if (escolhaUsuarioNum < 1 || escolhaUsuarioNum > usuariosCadastrados.size()) { System.out.println("[ERRO] Escolha inválida."); return; }
        Usuario usuarioEscolhido = usuariosCadastrados.get(escolhaUsuarioNum - 1);

        System.out.println("\n--- Escolha o Papel para " + usuarioEscolhido.getNome() + " ---");
        System.out.println("1. Aluno"); System.out.println("2. Instrutor"); System.out.println("3. Professor Voluntário");
        System.out.println("4. Administrador"); System.out.println("5. Moderador"); System.out.println("0. Cancelar");
        System.out.print("Número do papel: "); int escolhaPapelNum = lerOpcaoDoUsuarioNumerica();
        String tipoPapelStr = null;
        switch (escolhaPapelNum) {
            case 1: tipoPapelStr = "ALUNO"; break; case 2: tipoPapelStr = "INSTRUTOR"; break;
            case 3: tipoPapelStr = "PROFESSOR_VOLUNTARIO"; break; case 4: tipoPapelStr = "ADMINISTRADOR"; break;
            case 5: tipoPapelStr = "MODERADOR"; break; case 0: System.out.println("[INFO] Cancelado."); return;
            default: System.out.println("[ERRO] Papel inválido."); return;
        }

        configurarFabricaDePapel(tipoPapelStr);
        System.out.println("[FÁBRICA DE PAPEL SELECIONADA]: " + fabricaDePapelAtual.getClass().getSimpleName());
        System.out.println("   ↳ Especialista em criar papéis de '" + tipoPapelStr + "'.");
        Map<String, Object> detalhesPapel = new HashMap<>();
        System.out.println("\n--- Dados Específicos para Papel de " + tipoPapelStr.toUpperCase() + " ---");
        if (tipoPapelStr.equalsIgnoreCase("ALUNO")) {
            System.out.print("Progresso Geral (%): "); detalhesPapel.put("progressoGeral", scanner.nextFloat()); scanner.nextLine();
            detalhesPapel.put("ultimoAcessoTrilha", LocalDateTime.now());
        } else if (tipoPapelStr.equalsIgnoreCase("INSTRUTOR")) {
            System.out.print("Biografia Curta: "); detalhesPapel.put("biografiaCurta", scanner.nextLine());
            System.out.print("Avaliação Média: "); detalhesPapel.put("avaliacaoMedia", scanner.nextFloat()); scanner.nextLine();
            System.out.print("Especialidades (separadas por vírgula): ");
            detalhesPapel.put("especialidades", List.of(scanner.nextLine().split(",")));
        } else if (tipoPapelStr.equalsIgnoreCase("PROFESSOR_VOLUNTARIO")) {
            System.out.print("Área de Especialidade: "); detalhesPapel.put("areaEspecialidade", scanner.nextLine());
            System.out.print("Número de Artigos Revisados: "); detalhesPapel.put("artigosRevisados", scanner.nextInt()); scanner.nextLine();
        } else if (tipoPapelStr.equalsIgnoreCase("ADMINISTRADOR")) {
            System.out.print("Permissões Globais (separadas por vírgula): ");
            detalhesPapel.put("permissoesGlobais", List.of(scanner.nextLine().split(",")));
            System.out.print("Nível de Acesso: "); detalhesPapel.put("nivelAcesso", scanner.nextInt()); scanner.nextLine();
        } else if (tipoPapelStr.equalsIgnoreCase("MODERADOR")) {
            System.out.print("Nível de Moderação: "); detalhesPapel.put("nivelModeracao", scanner.nextLine());
            detalhesPapel.put("dataInicioModeracao", LocalDateTime.now());
        }

        System.out.println("\n[FÁBRICA PAPEL AÇÃO] " + fabricaDePapelAtual.getClass().getSimpleName() + " criando e atribuindo papel...");
        fabricaDePapelAtual.atribuirPapelParaUsuario(usuarioEscolhido, detalhesPapel);
        System.out.println("\n--- Informações Atualizadas do Usuário ---");
        usuarioEscolhido.exibirInformacoesCompletas();
        System.out.println("==============================================");
    }

    public static void configurarFabricaDePapel(String tipoPapel) {
        if (tipoPapel.equalsIgnoreCase("ALUNO")) fabricaDePapelAtual = new FabricaDeAluno();
        else if (tipoPapel.equalsIgnoreCase("INSTRUTOR")) fabricaDePapelAtual = new FabricaDeInstrutor();
        else if (tipoPapel.equalsIgnoreCase("PROFESSOR_VOLUNTARIO")) fabricaDePapelAtual = new FabricaDeProfessorVoluntario();
        else if (tipoPapel.equalsIgnoreCase("ADMINISTRADOR")) fabricaDePapelAtual = new FabricaDeAdministrador();
        else if (tipoPapel.equalsIgnoreCase("MODERADOR")) fabricaDePapelAtual = new FabricaDeModerador();
        else throw new IllegalArgumentException("Tipo de papel desconhecido: " + tipoPapel);
    }

    // ---- SEÇÃO PARA CRIAR TRILHAS EDUCACIONAIS (Builder + Composite) ----
    public static void gerenciarCriacaoDeTrilha() {
        System.out.println("\n========= CRIAR NOVA TRILHA EDUCACIONAL =========");
        System.out.print("ID da Trilha (número): "); int idTrilha = lerOpcaoDoUsuarioNumerica();
        System.out.print("Título da Trilha: "); String tituloTrilha = scanner.nextLine();
        TrilhaEducacionalBuilder trilhaBuilder = new TrilhaEducacionalBuilder(idTrilha, tituloTrilha);
        System.out.println("\n[BUILDER TRILHA] Iniciado para: '" + tituloTrilha + "'. Vamos configurar os detalhes.");
        System.out.print("Descrição da Trilha: "); trilhaBuilder.comDescricao(scanner.nextLine());
        System.out.print("Nível da Trilha (ex: Iniciante): "); trilhaBuilder.comNivel(scanner.nextLine());
        System.out.print("Categoria da Trilha (ex: Astronomia): "); trilhaBuilder.comCategoria(scanner.nextLine());
        System.out.print("URL da Imagem da Trilha (opcional): "); trilhaBuilder.comImagemUrl(scanner.nextLine());
        System.out.print("Publicar imediatamente? (s/n): "); trilhaBuilder.definirComoPublicada(scanner.nextLine().trim().equalsIgnoreCase("s"));
        System.out.print("\nQuantos módulos para esta trilha? "); int numModulos = lerOpcaoDoUsuarioNumerica();

        for (int i = 0; i < numModulos; i++) {
            System.out.println("\n--- Configurando Módulo " + (i + 1) + " ---");
            System.out.print("ID do Módulo: "); int idModulo = lerOpcaoDoUsuarioNumerica();
            System.out.print("Título do Módulo: "); String tituloModulo = scanner.nextLine();
            ModuloBuilder moduloBuilder = new ModuloBuilder(idModulo, tituloModulo);
            System.out.println("[BUILDER MÓDULO] Iniciado para: '" + tituloModulo + "'.");
            System.out.print("Ordem do Módulo: "); moduloBuilder.comOrdem(lerOpcaoDoUsuarioNumerica());
            System.out.print("Descrição breve do Módulo: "); moduloBuilder.comDescricaoBreve(scanner.nextLine());
            System.out.print("\nQuantos conteúdos para este módulo '" + tituloModulo + "'? "); int numConteudos = lerOpcaoDoUsuarioNumerica();
            for (int j = 0; j < numConteudos; j++) {
                System.out.println("\n  --- Adicionando Conteúdo " + (j + 1) + " ao Módulo ---");
                ComponenteTrilha novoConteudoComoComponente = criarConteudoInterativoParaModulo(); // Retorna Conteudo (que é ComponenteTrilha)
                if (novoConteudoComoComponente != null) {
                    // ModuloBuilder.adicionarComponente espera ComponenteTrilha
                    moduloBuilder.adicionarComponente(novoConteudoComoComponente);
                    System.out.println("  [BUILDER MÓDULO] Conteúdo '" + novoConteudoComoComponente.getTitulo() + "' (Tipo: " + novoConteudoComoComponente.getClass().getSimpleName() + ") adicionado.");
                }
            }
            // ModuloBuilder.build() retorna Modulo, que é um ComponenteTrilha
            ComponenteTrilha moduloConstruido = moduloBuilder.build();
            trilhaBuilder.adicionarComponente(moduloConstruido); 
            System.out.println("[BUILDER TRILHA] Módulo '" + moduloConstruido.getTitulo() + "' adicionado à trilha.");
        }
        System.out.println("\n[BUILDER TRILHA] Construindo Trilha Educacional...");
        TrilhaEducacional trilhaFinal = trilhaBuilder.build();
        trilhasCriadas.add(trilhaFinal);
        System.out.println("\n🎉 Trilha Educacional '" + trilhaFinal.getTitulo() + "' criada com sucesso! 🎉");
        System.out.println("\n--- Exibindo Estrutura da Trilha (Padrão Composite) ---");
        trilhaFinal.exibirInformacoes(""); // Chama o método do Composite para exibir a estrutura
        System.out.println("===================================================");
    }

    public static Conteudo criarConteudoInterativoParaModulo() { // Retorna Conteudo (que é um ComponenteTrilha)
        exibirMenuTiposDeConteudoParaModulo();
        int escolhaTipoConteudo = lerOpcaoDoUsuarioNumerica();
        String tipoConteudoString = null;
        switch (escolhaTipoConteudo) {
            case 1: tipoConteudoString = "ARTIGO"; break; case 2: tipoConteudoString = "VIDEO"; break;
            case 3: tipoConteudoString = "QUIZ"; break; case 4: tipoConteudoString = "JOGO"; break;
            case 0: System.out.println("[INFO] Criação de conteúdo cancelada."); return null;
            default: System.out.println("[ERRO] Tipo inválido."); return null;
        }
        System.out.println("\n  --- Coletando Dados para " + tipoConteudoString + " (para módulo) ---");
        configurarFabricaDeConteudo(tipoConteudoString);
        System.out.println("  [FÁBRICA CONTEÚDO SELECIONADA]: " + fabricaDeConteudoAtual.getClass().getSimpleName());
        System.out.print("  ID: "); int id = lerOpcaoDoUsuarioNumerica();
        System.out.print("  Título: "); String titulo = scanner.nextLine();
        System.out.print("  Descrição: "); String descricao = scanner.nextLine();
        TipoVisibilidade.mostrarOpcoes();
        System.out.print("  Visibilidade: "); int escolhaVis = lerOpcaoDoUsuarioNumerica();
        TipoVisibilidade visibilidadeSel = TipoVisibilidade.fromOpcao(escolhaVis);
        if (visibilidadeSel == null) { visibilidadeSel = TipoVisibilidade.PUBLICO; System.out.println("  [INFO] Visibilidade inválida, usando PUBLICO.");}
        System.out.println("  [INFO] Visibilidade: " + visibilidadeSel.getDescricao());
        Map<String, Object> detalhes = new HashMap<>();
        if (tipoConteudoString.equalsIgnoreCase("ARTIGO")) {
            System.out.print("  Texto HTML: "); detalhes.put("textoHtml", scanner.nextLine());
            System.out.print("  Fonte: "); detalhes.put("fonte", scanner.nextLine());
        } else if (tipoConteudoString.equalsIgnoreCase("VIDEO")) {
            System.out.print("  URL: "); detalhes.put("urlVideo", scanner.nextLine());
            System.out.print("  Duração (s): "); detalhes.put("duracaoSegundos", scanner.nextInt()); scanner.nextLine();
            System.out.print("  Transcrição: "); detalhes.put("transcricao", scanner.nextLine());
        } else if (tipoConteudoString.equalsIgnoreCase("QUIZ")) {
            System.out.print("  Tempo Limite (min): "); detalhes.put("tempoLimiteMin", scanner.nextInt()); scanner.nextLine();
            System.out.print("  Tentativas: "); detalhes.put("tentativasPermitidas", scanner.nextInt()); scanner.nextLine();
        } else if (tipoConteudoString.equalsIgnoreCase("JOGO")) {
            System.out.print("  Tipo Jogo: "); detalhes.put("tipoJogo", scanner.nextLine());
            System.out.print("  Dificuldade (1-5): "); detalhes.put("nivelDificuldade", scanner.nextInt()); scanner.nextLine();
            System.out.print("  URL Jogo: "); detalhes.put("urlJogo", scanner.nextLine());
        }
        // A fábrica de conteúdo retorna um Conteudo (que é um ComponenteTrilha)
        return fabricaDeConteudoAtual.criarConteudo(id, titulo, descricao, visibilidadeSel, detalhes);
    }

    public static void exibirMenuTiposDeConteudoParaModulo() {
        System.out.println("\n  Qual tipo de conteúdo deseja adicionar a este módulo?");
        System.out.println("  1. Artigo"); System.out.println("  2. Vídeo");
        System.out.println("  3. Quiz"); System.out.println("  4. Jogo");
        System.out.println("  0. Concluir adição de conteúdos a este módulo");
        System.out.print("  Digite sua opção: ");
    }

    // ---- SEÇÃO PARA TESTAR PROTOTYPE ----
    public static void gerenciarClonagemDePrototipos() {
        System.out.println("\n========= TESTAR PADRÃO PROTOTYPE (CLONAGEM) =========");
        if (registroDePrototipos == null) {
            System.out.println("[ERRO] Registro de Protótipos não inicializado!");
            return;
        }
        boolean continuarNesteMenu = true;
        while (continuarNesteMenu) {
            registroDePrototipos.listarPrototiposDisponiveis();
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Digite a CHAVE do protótipo que deseja clonar (ex: CONQUISTA_PIONEIRO) ou 0 para voltar: ");
            String chaveEscolhida = scanner.nextLine().trim().toUpperCase();

            if (chaveEscolhida.equals("0")) {
                continuarNesteMenu = false;
                System.out.println("\n[SISTEMA] Voltando ao Menu Principal...");
                break;
            }
            if (chaveEscolhida.isEmpty()) {
                System.out.println("[ERRO] Nenhuma chave fornecida. Tente novamente.");
                continue;
            }
            PrototipoClonavel objetoClonado = registroDePrototipos.getPrototipoClonado(chaveEscolhida);
            if (objetoClonado != null) {
                System.out.println("\n[SUCESSO] Protótipo '" + chaveEscolhida + "' clonado!");
                System.out.println("--> O objeto original no registro NÃO FOI ALTERADO.");
                System.out.println("--> O objeto a seguir é uma CÓPIA INDEPENDENTE que podemos modificar.");
                System.out.println("\n--- Detalhes do Objeto CLONADO (antes de modificações): ---");
                if (objetoClonado instanceof Conquista) { ((Conquista) objetoClonado).exibirDetalhes(); }
                else if (objetoClonado instanceof Notificacao) { ((Notificacao) objetoClonado).exibir(); }
                else { System.out.println("Tipo de protótipo clonado não tem método de exibição específico aqui."); }

                System.out.print("\nDeseja modificar este clone? (s/n): ");
                if (scanner.nextLine().trim().equalsIgnoreCase("s")) {
                    if (objetoClonado instanceof Conquista) {
                        Conquista c = (Conquista) objetoClonado;
                        System.out.print("  Novo título (atual: '" + c.getTitulo() + "'): "); c.setTitulo(scanner.nextLine());
                        System.out.print("  Novos XP (atual: " + c.getPontosXPConcedidos() + "): "); c.setPontosXPConcedidos(lerOpcaoDoUsuarioNumerica());
                        System.out.println("  [MODIFICADO] Conquista clonada atualizada.");
                    } else if (objetoClonado instanceof Notificacao) {
                        Notificacao n = (Notificacao) objetoClonado;
                        System.out.print("  Nova mensagem (atual: '" + n.getMensagem() + "'): "); n.setMensagem(scanner.nextLine());
                        System.out.print("  Marcar como lida? (s/n - atual: " + (n.isLida() ? "Sim" : "Não") + "): ");
                        if (scanner.nextLine().trim().equalsIgnoreCase("s")) n.marcarComoLida();
                        n.setDataEnvio(LocalDateTime.now());
                        System.out.println("  [MODIFICADO] Notificação clonada atualizada.");
                    }
                }
                System.out.println("\n--- Detalhes FINAIS do Objeto CLONADO (APÓS possíveis modificações): ---");
                if (objetoClonado instanceof Conquista) { ((Conquista) objetoClonado).exibirDetalhes(); }
                else if (objetoClonado instanceof Notificacao) { ((Notificacao) objetoClonado).exibir(); }
            } else {
                System.out.println("[FALHA] Não foi possível encontrar ou clonar o protótipo com a chave: " + chaveEscolhida);
            }
            System.out.println("----------------------------------------------------");
            System.out.print("Pressione Enter para clonar outro protótipo ou digite 0 para voltar...");
            if (scanner.nextLine().trim().equals("0")) {
                continuarNesteMenu = false;
                System.out.println("\n[SISTEMA] Voltando ao Menu Principal...");
            }
        }
    }

    // ---- SEÇÃO PARA GERENCIAR O FÓRUM (Singleton) ----
    public static void gerenciarForumSingleton() {
        System.out.println("\n========= ACESSANDO O FÓRUM PRINCIPAL (Singleton) =========");
        Forum forumPrincipal = Forum.getInstance();
        System.out.println("[INFO] Instância do Fórum obtida. HashCode da instância: " + forumPrincipal.hashCode());
        System.out.println("   ↳ Explicação: Não importa quantas vezes chamarmos Forum.getInstance(), sempre receberemos o MESMO objeto Forum.");

        Forum outraReferenciaForum = Forum.getInstance();
        System.out.println("[INFO] Segunda referência ao Fórum obtida. HashCode: " + outraReferenciaForum.hashCode());
        if (forumPrincipal == outraReferenciaForum) {
            System.out.println("   ↳ Confirmado: As duas referências apontam para o MESMO objeto na memória!");
        }

        boolean continuarNoMenuForum = true;
        while (continuarNoMenuForum) {
            System.out.println("\n--- Menu do Fórum: " + forumPrincipal.getNome() + " ---");
            forumPrincipal.exibirDetalhes(); // Mostra detalhes do fórum e lista de subforums existentes

            System.out.println("\nOpções do Fórum:");
            System.out.println("1. Criar Novo Subfórum");
            System.out.println("2. Listar Subfóruns (detalhado)");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Digite sua opção: ");
            int escolha = lerOpcaoDoUsuarioNumerica();

            switch (escolha) {
                case 1:
                    System.out.println("\n--- Criando Novo Subfórum ---");
                    System.out.print("Nome do novo Subfórum: ");
                    String nomeSub = scanner.nextLine();
                    System.out.print("Descrição do Subfórum: ");
                    String descSub = scanner.nextLine();
                    Subforum novoSub = forumPrincipal.criarSubforum(nomeSub, descSub);
                    System.out.println("Subfórum '" + (novoSub != null ? novoSub.getNome() : "N/A") + "' criado com sucesso!");
                    break;
                case 2:
                    List<Subforum> subforums = forumPrincipal.listarSubforums();
                    if (subforums.isEmpty()) {
                        System.out.println("Nenhum subfórum para listar.");
                    } else {
                        System.out.println("\n--- Subfóruns Existentes ---");
                        for (Subforum sf : subforums) {
                            sf.exibirDetalhes();
                        }
                    }
                    break;
                case 0:
                    continuarNoMenuForum = false;
                    System.out.println("\n[SISTEMA] Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("[ERRO] Opção inválida no menu do fórum.");
            }
        }
        System.out.println("==========================================================");
    }

} 

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

</details>

### Vídeo da Execução

## Conclusão

A implementação do padrão de projeto estrutural Composite para a organização hierárquica das Trilhas Educacionais, Módulos e Conteúdos na plataforma "Galáxia Conectada" demonstrou ser uma solução arquitetural de grande valia, uma vez que endereça de forma eficaz a necessidade de tratar tanto componentes individuais quanto agrupamentos complexos de forma uniforme. Através da introdução da interface ComponenteTrilha e da adaptação das classes Conteudo (e suas especializações como Artigo, Video, Quiz, Jogo) para atuarem como elementos "folha" (Leaf), e das classes Modulo e TrilhaEducacional para funcionarem como elementos "compostos" (Composite), o sistema ganhou flexibilidade.

## Bibliografia


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
| 1.2 | Organização e adição das mudanças | Larissa Stéfane | 01/05/2025 |
| 1.3 | Reestruturação | Larissa Stéfane | 01/05/2025 |
| 1.4 | Adição dos códigos | Larissa Stéfane | 01/05/2025 |
| 1.5 | Adição das imagens | Larissa Stéfane | 01/05/2025 |

