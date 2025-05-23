# Padrão Criacional Factory Method 

## Sumário

* [1. Objetivo](#1-objetivo)
* [2. Metodologia: O Padrão Factory Method](#2-metodologia-o-padrao-factory-method)
* [3. Desenvolvimento e Implementação](#3-desenvolvimento-e-implementacao)
    * [3.1. Preparação do Ambiente](#31-preparacao-do-ambiente)
    * [3.2. Criação das Classes de Produto (Hierarquia de Conteúdo)](#32-criacao-das-classes-de-produto-hierarquia-de-conteudo)
        * [3.2.1. Classe Abstrata `Conteudo.java`](#321-classe-abstrata-conteudojd)
        * [3.2.2. Classe Concreta `Artigo.java`](#322-classe-concreta-artigojd)
        * [3.2.3. Classe Concreta `Video.java`](#323-classe-concreta-videojd)
        * [3.2.4. Classe Concreta `Quiz.java`](#324-classe-concreta-quizjd)
        * [3.2.5. Classe Concreta `Jogo.java`](#325-classe-concreta-jogojd)
        * [3.2.6. Classe Auxiliar `Usuario.java`](#326-classe-auxiliar-usuariojd)
    * [3.3. Criação das Classes de Fábrica](#33-criacao-das-classes-de-fabrica)
        * [3.3.1. Fábrica Abstrata `FabricaDeConteudo.java`](#331-fabrica-abstrata-fabricadeconteudojd)
        * [3.3.2. Fábrica Concreta `FabricaDeArtigo.java`](#332-fabrica-concreta-fabricadeartigojd)
        * [3.3.3. Fábrica Concreta `FabricaDeVideo.java`](#333-fabrica-concreta-fabricadevideojd)
        * [3.3.4. Fábrica Concreta `FabricaDeQuiz.java`](#334-fabrica-concreta-fabricadequizjd)
        * [3.3.5. Fábrica Concreta `FabricaDeJogo.java`](#335-fabrica-concreta-fabricadejogojd)
    * [3.4. Classe de Teste `AplicacaoGalaxia.java` (Main)](#34-classe-de-teste-aplicacaogalaxiad-main)
* [4. Conclusão](#4-conclusao)
* [5. Referências](#5-referencias)


## 1. Objetivo {#1-objetivo}

O presente documento tem como principal objetivo detalhar o processo de design e implementação do padrão de projeto criacional **Factory Method** no contexto da plataforma "Galáxia Conectada". Especificamente, este trabalho foca na aplicação do padrão para gerenciar a criação de diversos tipos de objetos de `Conteudo` (como Artigos, Vídeos, Quizzes e Jogos), ao buscar promover uma arquitetura de software mais flexível, extensível e de fácil manutenção para esta funcionalidade central do sistema.


## 2. Metodologia: O Padrão Factory Method {#2-metodologia-o-padrao-factory-method}

O **Factory Method** é um padrão de projeto criacional que propõe uma solução para o problema de criação de objetos sem que a classe cliente precise especificar a classe concreta do objeto a ser criado. Com isso, ele define uma interface (ou classe abstrata) com um método para criar um objeto – o "método fábrica" – mas permite que as subclasses alterem o tipo de objeto que será efetivamente criado. Isso promove o baixo acoplamento, pois o cliente interage com a interface da fábrica e do produto, desconhecendo as implementações concretas.

No sistema "Galáxia Conectada", identificou-se a necessidade de criar diferentes tipos de `Conteudo` educacional. Assim, a aplicação do Factory Method permite que a lógica de instanciação de cada tipo específico de `Conteudo` (`Artigo`, `Video`, `Quiz`, `Jogo`) seja encapsulada em suas respectivas fábricas concretas, enquanto o sistema cliente interage apenas com uma fábrica abstrata de conteúdo.

**Principais Componentes do Padrão Aplicado:**

* **Product (Produto):** A interface ou classe abstrata `Conteudo`, que define o tipo de objeto que o método fábrica criará.
* **ConcreteProduct (Produto Concreto):** As classes `Artigo`, `Video`, `Quiz` e `Jogo`, que implementam/estendem `Conteudo`.
* **Creator (Criador):** A classe abstrata `FabricaDeConteudo`, que declara o método fábrica abstrato `criarConteudo()`.
* **ConcreteCreator (Criador Concreto):** As classes `FabricaDeArtigo`, `FabricaDeVideo`, `FabricaDeQuiz` e `FabricaDeJogo`, que sobrescrevem o método fábrica para retornar uma instância de um Produto Concreto específico.

A concepção das classes de produto e suas inter-relações foi guiada pelo Diagrama de Classes previamente elaborado para o projeto:
* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).


## 3. Desenvolvimento e Implementação {#3-desenvolvimento-e-implementacao}

A seguir, detalha-se a configuração do ambiente de desenvolvimento e a implementação em Java das classes que compõem a solução com o padrão Factory Method.

### 3.1. Preparação do Ambiente {#31-preparacao-do-ambiente}

O desenvolvimento foi realizado utilizando o **Visual Studio Code (VSCode)** como IDE principal. O ambiente Java foi configurado com o **OpenJDK JDK**. Para facilitar o desenvolvimento Java no VSCode, foi utilizado o pacote de extensões **"Extension Pack for Java"** da Microsoft, que provê funcionalidades como autocompletar, depuração e gerenciamento de projetos Java. A estrutura de pastas do projeto foi organizada seguindo as convenções de pacotes Java, com o código fonte principal localizado na pasta `src`.

### 3.2. Criação das Classes de Produto (Hierarquia de Conteúdo) {#32-criacao-das-classes-de-produto-hierarquia-de-conteudo}

A base para a aplicação do Factory Method é a existência de uma hierarquia de "produtos". No projeto "Galáxia Conectada", estes produtos são os diferentes tipos de conteúdo educacional que a plataforma oferecerá.

#### 3.2.1. Classe Abstrata `Conteudo.java` {#321-classe-abstrata-conteudojd}

**Descrição:**
A classe `Conteudo` serve como a superclasse abstrata para todos os tipos de materiais de estudo. Ela define atributos comuns como `id`, `titulo`, `descricao`, `dataPublicacao` e `visibilidade`, além de um método abstrato `exibir()` que será implementado de forma específica por cada subclasse para determinar como o conteúdo é apresentado.

Abaixo o código para `Conteudo.java`:
```java

```

## Histórico de versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 22/05/2025 |
| 1.1 | Adição do COnteudo.java | Larissa Stéfane | 22/05/2025 |
