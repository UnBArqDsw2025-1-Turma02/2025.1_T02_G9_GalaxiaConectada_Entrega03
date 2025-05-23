# Padrão Criacional Factory Method 

## Sumário

- [Introdução](#Introdução)
- [Objetivo](#Objetivo)
- [Metodologia](#Metodologia)
- [Desenvolvimento e Implementação](#Desenvolvimento-e-Implementação)
    - [Preparação do Ambiente](#Preparação-do-Ambiente)
    - [Criação das Classes de Produto da Hierarquia de Conteúdo](Criação-das-Classes-de-Produto-da-Hierarquia-de-Conteúdo)
        - [Classe Abstrata Conteudo.java](#Classe-Abstrata-Conteudo.java)
        - [Classe Concreta Artigo.java](#Classe-Concreta-Artigo.java)
        - [Classe Concreta Video.java](#Classe-Concreta-Video.java)
        - [Classe Concreta Quiz.java](#Classe-Concreta-Quiz.java)
        - [Classe Concreta Jogo.java](#Classe-Concreta-Jogo.java)
        - [Classe Auxiliar Usuario.java](#Classe-Auxiliar-Usuario.java)
    - [Criação das Classes de Fábrica](#Criação-das-Classes-de-Fábrica)
        - [Fábrica Abstrata FabricaDeConteudo.java](#Fábrica-Abstrata-FabricaDeConteudo.java)
        - [Fábrica Concreta FabricaDeArtigo.java](#Fábrica-Concreta-FabricaDeArtigo.java)
        - [Fábrica Concreta FabricaDeVideo.java](#Fábrica-Concreta-FabricaDeVideo.java)
        - [Fábrica Concreta FabricaDeQuiz.java](#Fábrica-Concreta-FabricaDeQuiz.java)
        - [Fábrica Concreta FabricaDeJogo.java](#Fábrica-Concreta-FabricaDeJogo.java)
    - [Classe de Teste AplicacaoGalaxia.java a Main](#Classe-de-Teste-AplicacaoGalaxia.java-a-Main)
- [Conclusão](#Conclusão)
- [Bibliografia](#Bibliografia)
- [Histórico de versão](#Histórico-de-versão)

## Introdução



## Objetivo



## Metodologia

O **Factory Method** é um padrão de projeto criacional que propõe uma solução para o problema de criação de objetos sem que a classe cliente precise especificar a classe concreta do objeto a ser criado. Com isso, ele define uma interface (ou classe abstrata) com um método para criar um objeto – o "método fábrica" – mas permite que as subclasses alterem o tipo de objeto que será efetivamente criado. Isso promove o baixo acoplamento, pois o cliente interage com a interface da fábrica e do produto, desconhecendo as implementações concretas.

No sistema "Galáxia Conectada", identificou-se a necessidade de criar diferentes tipos de `Conteudo` educacional. Assim, a aplicação do Factory Method permite que a lógica de instanciação de cada tipo específico de `Conteudo` (`Artigo`, `Video`, `Quiz`, `Jogo`) seja encapsulada em suas respectivas fábricas concretas, enquanto o sistema cliente interage apenas com uma fábrica abstrata de conteúdo.

**Principais Componentes do Padrão Aplicado:**

* **Product (Produto):** A interface ou classe abstrata `Conteudo`, que define o tipo de objeto que o método fábrica criará.
* **ConcreteProduct (Produto Concreto):** As classes `Artigo`, `Video`, `Quiz` e `Jogo`, que implementam/estendem `Conteudo`.
* **Creator (Criador):** A classe abstrata `FabricaDeConteudo`, que declara o método fábrica abstrato `criarConteudo()`.
* **ConcreteCreator (Criador Concreto):** As classes `FabricaDeArtigo`, `FabricaDeVideo`, `FabricaDeQuiz` e `FabricaDeJogo`, que sobrescrevem o método fábrica para retornar uma instância de um Produto Concreto específico.

A concepção das classes de produto e suas inter-relações foi guiada pelo Diagrama de Classes previamente elaborado para o projeto:
* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).


## Desenvolvimento e Implementação

A seguir, detalha-se a configuração do ambiente de desenvolvimento e a implementação em Java das classes que compõem a solução com o padrão Factory Method.

### Preparação do Ambiente
O desenvolvimento foi realizado utilizando o **Visual Studio Code (VSCode)** como IDE principal. O ambiente Java foi configurado com o **OpenJDK JDK**. Para facilitar o desenvolvimento Java no VSCode, foi utilizado o pacote de extensões **"Extension Pack for Java"** da Microsoft, que provê funcionalidades como autocompletar, depuração e gerenciamento de projetos Java. A estrutura de pastas do projeto foi organizada seguindo as convenções de pacotes Java, com o código fonte principal localizado na pasta `src`.

### Criação das Classes de Produto da Hierarquia de Conteúdo

A base para a aplicação do Factory Method é a existência de uma hierarquia de "produtos". No projeto "Galáxia Conectada", estes produtos são os diferentes tipos de conteúdo educacional que a plataforma oferecerá.

#### Classe Abstrata Conteudo.java

**Descrição:**
A classe `Conteudo` serve como a superclasse abstrata para todos os tipos de materiais de estudo. Ela define atributos comuns como `id`, `titulo`, `descricao`, `dataPublicacao` e `visibilidade`, além de um método abstrato `exibir()` que será implementado de forma específica por cada subclasse para determinar como o conteúdo é apresentado.

Abaixo o código para `Conteudo.java`:
```package com.galaxiaconectada.core; 

import java.time.LocalDateTime;
import com.galaxiaconectada.domain.Usuario; // Importa a classe Usuario

// Não se pode criar um "Conteudo" genérico diretamente.
public abstract class Conteudo {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPublicacao;
    private String visibilidade; // Ex: "PUBLICO", "PRIVADO"

    // Chamado quando criado um objeto Conteudo (ou suas subclasses).
    public Conteudo(int id, String titulo, String descricao, String visibilidade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = LocalDateTime.now(); // Define a data de publicação para agora
        this.visibilidade = visibilidade;
    }

    // Este método é 'abstract'. Isso força cada subclasse de Conteudo
    // (como Artigo, Video) a ter sua própria maneira de "se exibir".
    public abstract void exibir();

    public void adicionarComentario(Usuario usuario, String texto) {

        System.out.println("Comentário de " + usuario.getNome() + " adicionado ao conteúdo '" + this.titulo + "': " + texto);
    }

    // métodos para obter os valores dos atributos privados.
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public String getVisibilidade() {
        return visibilidade;
    }

    // Define como o objeto Conteudo será representado como texto
    @Override
    public String toString() {
        return "Conteudo [id=" + id + ", titulo=" + titulo + ", dataPublicacao=" + dataPublicacao + "]";
    }
}

```

#### Classe Concreta Artigo.java

#### Classe Concreta Video.java

#### Classe Concreta Quiz.java

#### Classe Concreta Jogo.java

#### Classe Auxiliar Usuario.java


### Criação das Classes de Fábrica

#### Fábrica Abstrata FabricaDeConteudo.java

#### Fábrica Concreta FabricaDeArtigo.java

#### Fábrica Concreta FabricaDeVideo.java

#### Fábrica Concreta FabricaDeQuiz.java

#### Fábrica Concreta FabricaDeJogo.java

### Classe de Teste AplicacaoGalaxia.java a Main

## Conclusão

## Bibliografia 


## Histórico de versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 22/05/2025 |
| 1.1 | Adição do COnteudo.java | Larissa Stéfane | 22/05/2025 |
| 1.1 | Adição das outras classes de poduto da hierarquia| Larissa Stéfane | 23/05/2025 |
