# Padrão Criacional Factory Method 

## Sumário

- [Introdução](#introdução)
- [Objetivo](#objetivo)
- [Metodologia](#metodologia)
- [Desenvolvimento e Implementação](#desenvolvimento-e-implementação)
  - [Preparação do Ambiente](#preparação-do-ambiente)
- [Aplicação do Factory Method para Papéis de Conteúdo](#aplicação-do-factory-method-para-papéis-de-conteúdo)
  - [Criação das Classes de Produto da Hierarquia de Conteúdo](#criação-das-classes-de-produto-da-hierarquia-de-conteúdo)
  - [Modelagem do Factory Method para Conteúdo](#Modelagem-do-Factory-Method-para-Conteúdo)
    - [Classe Abstrata Conteudo](#classe-abstrata-conteudo)
    - [Classe TipoVisibilidade](#classe-tipovisibilidade)
    - [Classe Concreta Artigo](#classe-concreta-artigo)
    - [Classe Concreta Video](#classe-concreta-video)
    - [Classe Concreta Quiz](#classe-concreta-quiz)
    - [Classe Concreta Jogo](#classe-concreta-jogo)
    - [Classe Auxiliar Usuario](#classe-auxiliar-usuario)
  - [Criação das Classes de Fábrica de Conteúdo](#criação-das-classes-de-fábrica-de-conteúdo)
    - [Fábrica Abstrata FabricaDeConteudo](#fábrica-abstrata-fabricadeconteudo)
    - [Fábrica Concreta FabricaDeArtigo](#fábrica-concreta-fabricadeartigo)
    - [Fábrica Concreta FabricaDeVideo](#fábrica-concreta-fabricadevideo)
    - [Fábrica Concreta FabricaDeQuiz](#fábrica-concreta-fabricadequiz)
    - [Fábrica Concreta FabricaDeJogo](#fábrica-concreta-fabricadejogo)
- [Aplicação do Factory Method para Papéis de Usuário](#aplicação-do-factory-method-para-papéis-de-usuário)
  - [Modelagem do Factory Method para Usuário](Modelagem-do-Factory-Method-para-Usuário)
  - [Interface Produto PapelUsuario](#interface-produto-papelusuario)
  - [Classes Concretas de Produto e Papéis](#classes-concretas-de-produto-e-papéis)
    - [Classe Aluno](#classe-aluno)
    - [Classe Instrutor](#classe-instrutor)
    - [Classe ProfessorVoluntario](#classe-professorvoluntario)
    - [Classe Administrador](#classe-administrador)
    - [Classe Moderador](#classe-moderador)
  - [Criação das Classes de Produto da Hierarquia de Usuário](#criação-das-classes-de-produto-da-hierarquia-de-usuário)
    - [Fábrica Abstrata FabricaDePapelUsuario](#fábrica-abstrata-fabricadepapelusuario)
    - [Fábricas Concretas de Papel](#fábricas-concretas-de-papel)
      - [Fábrica FabricaDeAluno](#fábrica-fabricadealuno)
      - [Fábrica FabricaDeInstrutor](#fábrica-fabricadeinstrutor)
      - [Fábrica FabricaDeProfessorVoluntario](#fábrica-fabricadeprofessorvoluntario)
      - [Fábrica FabricaDeAdministrador](#fábrica-fabricadeadministrador)
      - [Fábrica FabricaDeModerador](#fábrica-fabricademoderador)
- [Classe de Teste AplicacaoGalaxia](#Classe-de-Teste-AplicacaoGalaxia)
- [Conclusão](#conclusão)
- [Bibliografia](#bibliografia)
- [Histórico de Versão](#histórico-de-versão)


## Introdução

Com base em [Factory Method](https://refactoring.guru/design-patterns/factory-method), o **Factory Method** é um padrão de projeto criacional que define uma interface para a criação de objetos, a qual permite que as subclasses decidam qual classe instanciar. Dessa maneira, em vez de instanciar objetos diretamente por meio de um operador, esse padrão propõe o uso de um método de fábrica especializado que centraliza e flexibiliza a lógica de criação. Consequentemente, como também é evidenciado em [Design Patterns - Parte 3 – Factory Method](https://medium.com/@jonesroberto/desing-patterns-factory-method-a7496ae071aa), isso traz diversos benefícios, como a redução do acoplamento, a facilidade de manutenção e a possibilidade de extensão futura do sistema sem grandes alterações no código existente. 

No contexto da plataforma educacional **Galáxia Conectada**, que visa oferecer experiências interativas em astronomia, a aplicação desse padrão favorece a organização e escalabilidade do código. Portanto, o padrão Factory Method será utilizado para gerenciar duas categorias centrais do projeto: **Conteúdos e Usuários**. A categoria de usuários abrange diferentes perfis presentes na plataforma, como aluno, instrutor, professor voluntário, administrador e moderador — cada um com responsabilidades e permissões distintas. Já a categoria de conteúdos contempla os principais formatos educacionais oferecidos, como artigos, vídeos, quizzes e jogos. 

**Observação**: A escolha dessas duas categorias se deu pelo fato de elas representarem núcleos de variação frequente dentro do sistema: novos perfis e formatos de conteúdo podem ser adicionados futuramente, e o uso do Factory Method garante que essas adições possam ocorrer sem a necessidade de modificar diretamente a lógica de criação ou o código.


## Objetivo

A aplicação do padrão de projeto Factory Method na plataforma Galáxia Conectada visa promover uma arquitetura de software mais flexível, reutilizável e preparada para evoluções futuras. Sendo assim, ao organizar a criação de objetos relacionados aos usuários e aos conteúdos educacionais por meio de fábricas especializadas, o sistema  deve se tornar de fácil manutenção. 

Os principais objetivos ao utilizar o padrão Factory Method no projeto, com base em [Padrão de Projeto: Factory Method](https://www.thiengo.com.br/padrao-de-projeto-factory-method#title-5) e em [Factory Method](https://refactoring.guru/design-patterns/factory-method) são:

- Reduzir o acoplamento entre as classes que utilizam objetos e as classes concretas que os implementam.

- Facilitar a adição de novos tipos de conteúdo e usuários sem impactar a lógica central do sistema.

- Centralizar a lógica de criação dos objeto e tornar o código mais consistente.

- Promover a reutilização de códig ao permitir que as subclasses reutilizem a estrutura básica das superclasses.

- Aumentar a escalabilidade e manutenção do sistema.


## Metodologia

Como foi citado, o **Factory Method** é um padrão de projeto criacional que propõe uma solução para o problema de criação de objetos sem que a classe cliente precise especificar a classe concreta do objeto a ser criado. Com isso, ele define uma interface (ou classe abstrata) com um método para criar um objeto – o "método fábrica" – mas permite que as subclasses alterem o tipo de objeto que será efetivamente criado.

**Principais Componentes do Padrão Aplicado, com base em [Design Patterns - Parte 3 – Factory Method](https://medium.com/@jonesroberto/desing-patterns-factory-method-a7496ae071aa):**

* **Product (Produto):** Interface ou classe abstrata que define os métodos que todos os tipos de conteúdo ou usuários devem implementar.
* **ConcreteProduct (Produto Concreto):** mplementações concretas da interface Product, como Artigo, Vídeo, Quiz, Aluno, Instrutor, entre outros.
* **Creator (Criador):** Classe base que declara o método de fábrica createProduct(), que deve ser sobrescrito pelas subclasses.
* **ConcreteCreator (Criador Concreto):** Subclasses que implementam o método de fábrica e retornam instâncias específicas dos ConcreteProduct.

A concepção das classes de produto e suas inter-relações serão guiadas por diagrama previamente elaborados para o projeto:

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).
* **Diagrama de Classes de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes).
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes).

**Passo a passo de desenvolvimento:**

1. Definição das interfaces ou classes abstratas para Product, representando tanto os conteúdos educacionais quanto os usuários da plataforma.
2. Criação das classes concretas (ConcreteProduct) como Artigo, Vídeo, Quiz, Jogo, além de Aluno, Instrutor, Administrador, entre outras.
3. Desenvolvimento da classe criadora (Creator) com o método de fábrica abstrato.
4. Implementação das fábricas concretas (ConcreteCreator), cada uma responsável por instanciar um tipo específico de conteúdo ou usuário.
5. Criação de uma classe Main para testes, na qual serão instanciadas as fábricas e verificado o retorno dos objetos criados.


## Desenvolvimento e Implementação

### Preparação do Ambiente

- O desenvolvimento foi realizado ao utilizar o [**Visual Studio Code (VSCode)**](https://code.visualstudio.com/) como IDE principal.
- O ambiente Java foi configurado com o **OpenJDK JDK**.
- Para facilitar o desenvolvimento Java no VSCode, foi utilizado o pacote de extensões **"Extension Pack for Java"** da Microsoft, que provê funcionalidades como autocompletar, depuração e gerenciamento de projetos Java.
- A estrutura de pastas do projeto foi organizada seguindo as convenções de pacotes Java, com o código fonte principal localizado na pasta `src`.

## Criação das Classes de Produto da Hierarquia de Conteúdo

A base para a aplicação do Factory Method é a existência de uma hierarquia de "produtos". No projeto "Galáxia Conectada", estes produtos são os diferentes tipos de conteúdo educacional que a plataforma oferecerá.

### Modelagem do Factory Method para Conteúdo






### Aplicação do Factory Method para Papéis de Conteúdo

## Classe Abstrata Conteudo

A classe `Conteudo` serve como a **superclasse abstrata** para todos os tipos de materiais de estudo. Assim, ela define atributos comuns como `id`, `titulo`, `descricao`, `dataPublicacao` e `visibilidade`, além de um método abstrato `exibir()` que será implementado de forma específica por cada subclasse para determinar como o conteúdo é apresentado.

Abaixo o código para `Conteudo.java`:

<details>
  <summary><strong>Código para `Conteudo.java`</strong></summary>

```java
package com.galaxiaconectada.core; 

import com.galaxiaconectada.domain.Usuario;
import java.time.LocalDateTime; // Importa a classe Usuario

// Não se pode criar um "Conteudo" genérico diretamente.
public abstract class Conteudo {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPublicacao;
    private TipoVisibilidade visibilidade; 

    // Chamado quando criado um objeto Conteudo (ou suas subclasses).
    public Conteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade) { 
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

    public TipoVisibilidade getVisibilidade() { 
        return visibilidade; 
    }

    // Define como o objeto Conteudo será representado como texto
    @Override
    public String toString() {
        return "Conteudo [id=" + id + ", titulo=" + titulo + ", dataPublicacao=" + dataPublicacao + ", visibilidade=" + visibilidade.name() + "]";
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

As figuras 1 e 2 abaixo ilustra a estrutura da classe `Conteudo.java` no ambiente de desenvolvimento VSCode.


<div align="center">
    Figura 1: Classe Abstrata Conteudo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/conteudoJava1.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


<div align="center">
    Figura 2: Classe Abstrata Conteudo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/ConteudoJava2.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


</details>

## Classe TipoVisibilidade

O TipoVisibilidade foi criado para representar de forma segura e clara os diferentes níveis de acesso que um Conteudo pode ter. Assim, ao utilizar essa classe é possível evitar erros de digitação e torna o código mais robusto e legível. 

**Observação:** Cada constante uma descrição para facilitar a interação e compreensão.

Abaixo o código para TipoVisibilidade.java:

<details>
  <summary><strong>Código para TipoVisibilidade.java</strong></summary>

```java
package com.galaxiaconectada.core;

public enum TipoVisibilidade {
    PUBLICO("Público - Acessível a todos"),
    PRIVADO("Privado - Acessível apenas ao criador"), 
    RESTRITO_ALUNOS("Restrito a Alunos - Apenas para usuários com papel de aluno"),
    RESTRITO_INSTRUTORES("Restrito a Instrutores - Apenas para instrutores e admins"),
    RESTRITO_ADMINS("Restrito a Administradores - Apenas para administradores");

    private final String descricao;

    TipoVisibilidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método para exibir as opções
    public static void mostrarOpcoes() {
        System.out.println("Opções de Visibilidade:");
        for (TipoVisibilidade tipo : values()) {
            System.out.println((tipo.ordinal() + 1) + ". " + tipo.getDescricao());
        }
    }

    // Método para obter um TipoVisibilidade a partir da escolha numérica do usuário
    public static TipoVisibilidade fromOpcao(int opcao) {
        if (opcao > 0 && opcao <= values().length) {
            return values()[opcao - 1];
        }
        return null; // Ou lançar uma exceção para opção inválida
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 3 abaixo ilustra a estrutura da classe `TipoVisibilidade.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: TipoVisibilidade.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/TipoVisibilidadeJava.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>


## Classe Concreta Artigo

A classe Artigo é uma especialização de Conteudo, a qual representa conteúdo textual. Além dos atributos herdados, possui textoHtml para o corpo do artigo e fonte para referências. 

- **Observação:** O método exibir() é implementado para formatar e apresentar essas informações de maneira adequada para um artigo.

Abaixo o código para Artigo.java:

<details>
  <summary><strong>Código para Artigo.java</strong></summary>

```java
package com.galaxiaconectada.core; // Mesmo pacote da classe Conteudo

// É um tipo de Conteudo e herda seus atributos e métodos (como getTitulo(), adicionarComentario()
public class Artigo extends Conteudo {
    private String textoHtml; // Atributo específico do Artigo
    private String fonte;     // Outro atributo específico do Artigo

    // Construtor do Artigo
    public Artigo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String textoHtml, String fonte) {
        // A primeira linha DEVE ser a chamada para o construtor da superclasse (Conteudo)
        super(id, titulo, descricao, visibilidade);
        this.textoHtml = textoHtml;
        this.fonte = fonte;
    }

    // Cada tipo de conteúdo terá sua própria forma de se "exibir".
    @Override // sobrescrevendo um método da superclasse
    public void exibir() {
        System.out.println("<<< EXIBINDO ARTIGO >>>");
        System.out.println("Título: " + getTitulo()); // getTitulo() foi herdado de Conteudo
        System.out.println("Descrição: " + getDescricao()); // getDescricao() também foi herdado
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao()); 
        System.out.println("Fonte: " + this.fonte);
        System.out.println("------------------------------------");
        System.out.println(this.textoHtml);
        System.out.println("------------------------------------");
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

##### Imagem do código no VSCODE


A figura 4 abaixo ilustra a estrutura da classe `Artigo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 4: Classe Concreta Artigo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/ArtigoJava.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Concreta Video

A classe **Video** estende **Conteudo** para representar conteúdo audiovisual. Com isso, contém atributos específicos como urlVideo, duracaoSegundos e transcricao. 

Abaixo o código para Video.java:

<details>
  <summary><strong>Código para Video.java</strong></summary>


```java
package com.galaxiaconectada.core;

public class Video extends Conteudo {
    private String urlVideo;
    private int duracaoSegundos;
    private String transcricao; 

    // Construtor do Video 
    public Video(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String urlVideo, int duracaoSegundos, String transcricao) {
        super(id, titulo, descricao, visibilidade);
        this.urlVideo = urlVideo;
        this.duracaoSegundos = duracaoSegundos;
        this.transcricao = transcricao;
    }

    @Override
    public void exibir() {
        System.out.println("<<< EXIBINDO VÍDEO >>>");
        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao());
        System.out.println("URL: " + this.urlVideo);
        System.out.println("Duração: " + this.duracaoSegundos + " segundos");
        if (this.transcricao != null && !this.transcricao.isEmpty()) { 
            System.out.println("Transcrição disponível.");
        } else {
            System.out.println("Transcrição não disponível.");
        }
        play();
    }

    public void play() {
        System.out.println("Vídeo '" + getTitulo() + "' está tocando... ▶️");
    }

    public void pause() {
        System.out.println("Vídeo '" + getTitulo() + "' pausado. ⏸️");
    }

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


##### Imagem do código no VSCODE


A figura 5 abaixo ilustra a estrutura da classe `Video.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 5: Classe Concreta Video.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/VideoJava.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Concreta Quiz

Como um tipo de Conteudo interativo, a classe Quiz é destinada a avaliações ou testes de conhecimento. Dessa maneira, ela herda de Conteudo e adiciona atributos como tempoLimiteMin e tentativasPermitidas.

Abaixo o código para Quiz.java:

<details>
  <summary><strong>Código para Quiz.java</strong></summary>

```java
package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; // É preciso da classe Usuario para os métodos iniciar e submeter

public class Quiz extends Conteudo {
    private int tempoLimiteMin;
    private int tentativasPermitidas;

     // Construtor do Quiz
    public Quiz(int id, String titulo, String descricao, TipoVisibilidade visibilidade, int tempoLimiteMin, int tentativasPermitidas) {
        super(id, titulo, descricao, visibilidade);
        this.tempoLimiteMin = tempoLimiteMin; // Atributos específicos do Quiz
        this.tentativasPermitidas = tentativasPermitidas;
    }

    // MÉTODO EXIBIR:
    @Override
    public void exibir() {
        System.out.println("<<< EXIBINDO QUIZ >>>");
        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Tempo Limite: " + this.tempoLimiteMin + " minutos");
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao());
        System.out.println("Tentativas Permitidas: " + this.tentativasPermitidas);
        System.out.println("------------------------------------");
        System.out.println("PERGUNTAS DO QUIZ:");

    }

    // Métodos específicos do Quiz
    public Object iniciar(Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " iniciando o quiz: " + getTitulo());
        return null;
    }

    public Object submeter(Object tentativaQuiz) { // Deve receber TentativaQuiz e retornar ResultadoQuiz
        System.out.println("Quiz " + getTitulo() + " submetido.");
        return null;
    }

    public int getTempoLimiteMin() {
        return tempoLimiteMin;
    }

    public int getTentativasPermitidas() {
        return tentativasPermitidas;
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE


A figura 6 abaixo ilustra a estrutura da classe `Quiz.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe Concreta Quiz.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/QuizJava.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Concreta Jogo

A classe Jogo representa conteúdo educacional em formato interativo e lúdico. Sendo uma subclasse de Conteudo, ela inclui atributos específicos como tipoJogo, nivelDificuldade e urlJogo. 

Abaixo o código para Jogo.java:

<details>
  <summary><strong>Código para Jogo.java</strong></summary>

```java
package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; // Precisa da classe Usuario para os métodos

// Jogo também é um tipo de Conteudo
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
    public void exibir() {
        System.out.println("<<< EXIBINDO JOGO >>>");
        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao());
        System.out.println("Tipo: " + this.tipoJogo);
        System.out.println("Dificuldade: Nível " + this.nivelDificuldade);
        System.out.println("Acessar em: " + this.urlJogo);
    }

    public Object iniciar(Usuario usuario) { // Deveria retornar SessaoJogo
        System.out.println("Usuário " + usuario.getNome() + " iniciando o jogo: " + getTitulo());
        return null;
    }

    public Object registrarPontuacao(Object sessaoJogo) { // Deveria receber SessaoJogo e retornar PontuacaoJogo
        System.out.println("Pontuação registrada para o jogo: " + getTitulo());
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

##### Imagem do código no VSCODE


A figura 7 abaixo ilustra a estrutura da classe `Jogo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 7:  Classe Concreta Jogo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/JogoJava.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Auxiliar Usuario

A classe Usuario, localizada no pacote com.galaxiaconectada.domain, é fundamental para o sistema, pois representa os participantes da plataforma. Assim, no contexto desta implementação do Factory Method, ela é utilizada por métodos dentro das classes de Conteudo (ex: adicionarComentario) e para simular interações em Quiz e Jogo. 

**Observação:** Foi baseada no diagrama de [classes do projeto.](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses)

Abaixo o código para Usuario.java:

<details>
  <summary><strong>Código para Usuario.java</strong></summary>

```java
package com.galaxiaconectada.domain;

import java.time.LocalDateTime;
import java.util.Map; // Para o método editarPerfil

//Imports para classes outras classes relacionadas
import com.galaxiaconectada.domain.forum.Subforum;
import com.galaxiaconectada.domain.forum.Topico;
import com.galaxiaconectada.domain.forum.Postagem;
import com.galaxiaconectada.domain.forum.Comentario;
import com.galaxiaconectada.domain.forum.Comentavel; // Esta seria uma interface
import com.galaxiaconectada.domain.mensagens.MensagemPrivada;


public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senhaHash; // Armazenar o hash da senha, não a senha em si
    private LocalDateTime dataCadastro;

    // Construtor
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = gerarHashDaSenha(senha); // Método placeholder
        this.dataCadastro = LocalDateTime.now();
    }


    public boolean login(String emailFornecido, String senhaFornecida) {
        // Lógica de login: verificar email e hash da senhaFornecida com senhaHash
        System.out.println("Usuário " + this.nome + " tentando login.");
        if (this.email.equals(emailFornecido) && verificarSenha(senhaFornecida, this.senhaHash)) {
            System.out.println("Login bem-sucedido para " + this.nome);
            return true;
        }
        System.out.println("Falha no login para " + emailFornecido);
        return false;
    }

    public void logout() {
        System.out.println("Usuário " + this.nome + " fez logout.");
        // Invalidar sessão.
    }

    public void editarPerfil(Map<String, Object> dados) {
        System.out.println("Perfil do usuário " + this.nome + " sendo editado.");
        if (dados.containsKey("nome")) {
            this.setNome((String) dados.get("nome"));
        }
        if (dados.containsKey("email")) {
            this.setEmail((String) dados.get("email"));
        }
        // Adicionar lógica para outros campos do perfil
        System.out.println("Perfil atualizado: Nome=" + this.nome + ", Email=" + this.email);
    }

    public MensagemPrivada enviarMensagemPrivada(Usuario destinatario, String texto) {
        System.out.println(this.nome + " enviando mensagem para " + destinatario.getNome() + ": " + texto);
        // Lógica para criar e armazenar a mensagem
        // Retornar uma instância de MensagemPrivada. Por enquanto, null ou um placeholder.
        return new MensagemPrivada(this, destinatario, texto); // Supondo um construtor em MensagemPrivada
    }

    public Topico criarTopicoForum(Subforum subforum, String titulo, String postInicial) {
        System.out.println(this.nome + " criando tópico '" + titulo + "' no subforum " + subforum.getNome());
        // Lógica para criar e armazenar o tópico e a postagem inicial
        return new Topico(this, subforum, titulo, postInicial); // Supondo construtores
    }

    public Postagem postarEmTopico(Topico topico, String texto) {
        System.out.println(this.nome + " postando no tópico '" + topico.getTitulo() + "': " + texto);
        // Lógica para criar e armazenar a postagem
        return new Postagem(this, topico, texto); 
    }

    public Comentario comentar(Comentavel item, String texto) {
        System.out.println(this.nome + " comentando em item: " + texto);
        // Lógica para criar e armazenar o comentário
        return new Comentario(this, item, texto); 
    }

    // Métodos auxiliares placeholders (simulados)
    private String gerarHashDaSenha(String senha) {
        return "hashed_" + senha;
    }

    private boolean verificarSenha(String senhaFornecida, String senhaHashArmazenada) {
        return senhaHashArmazenada.equals("hashed_" + senhaFornecida);
    }


    // Getters e Setters para os atributos
    public int getId() {
        return id;
    }
    // Não costuma ter setId para id, pois é gerado uma vez.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaHash() {
        return senhaHash;
    }


    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }
    // Não costuma ter setDataCadastro.
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE


A figura 8 abaixo ilustra a estrutura da classe `Usuario.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 8: Classe Auxiliar Usuario.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/UsuarioJava1.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


<div align="center">
    Figura 9: Classe Auxiliar Usuario.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/UsuarioJava2.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


<div align="center">
    Figura 10: Classe Auxiliar Usuario.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/ca5a0ec7a0d186a9874f2b158d99b222508d32c4/docs/PadroesDeProjeto/Imagens/UsuarioJava3.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

### Criação das Classes de Fábrica de Conteudo

Com os "produtos" (Conteudo e suas subclasses) definidos, foram implementadas as fábricas responsáveis pela sua criação, seguindo o padrão Factory Method.


## Fábrica Abstrata FabricaDeConteudo

FabricaDeConteudo é a classe "Creator" abstrata. Com isso, ela define o contrato para todas as fábricas de conteúdo ao declarar o método fábrica abstrato criarConteudo(). Este método recebe os parâmetros comuns para a criação de qualquer Conteudo, incluindo o TipoVisibilidade, e um Map para os detalhes específicos de cada subclasse de Conteudo. 

A fábrica abstrata também possui um método concreto, **iniciarPublicacaoDeConteudo**, a qual demonstra como a fábrica pode orquestrar a criação e o uso inicial do produto.

Abaixo o código para FabricaDeConteudo.java:

<details>
  <summary><strong>Código para FabricaDeConteudo.java</strong></summary>

```java
package com.galaxiaconectada.fabricas; // Pertence ao pacote 'fabricas'

// Importa a classe base Conteudo e a interface Map
import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import java.util.Map;

// Ela não pode ser instanciada diretamente.
public abstract class FabricaDeConteudo {

    /**
     * FACTORY METHOD (Método de Fábrica) abstrato.
     * Cada fábrica concreta (FabricaDeArtigo ou FabricaDeVideo) precisará implementar este método para criar seu tipo específico de Conteudo.
     *
     * @param id O ID do conteúdo.
     * @param titulo O título do conteúdo.
     * @param descricao A descrição do conteúdo.
     * @param visibilidade A visibilidade do conteúdo.
     * @param detalhes Um Map contendo atributos específicos para o tipo de conteúdo a ser criado
     * (ex: para Artigo pode ter "textoHtml", "fonte"; para Video "urlVideo", "duracaoSegundos").
     * @return Uma instância de uma subclasse de Conteudo.
     */
    public abstract Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes);


     public void iniciarPublicacaoDeConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        // Chama o factory method para obter o objeto Produto.
        Conteudo conteudo = criarConteudo(id, titulo, descricao, visibilidade, detalhes);

        // Agora usa o produto.
        System.out.println("\n--- Nova Publicação Iniciada pela Fábrica ---");
        System.out.println("Fábrica: " + this.getClass().getSimpleName() + " está trabalhando...");
        System.out.println("Conteúdo criado: " + conteudo.getTitulo() + " (ID: " + conteudo.getId() + ")");
        conteudo.exibir(); // Chama o método exibir() do produto específico
        System.out.println("--- Publicação Concluída ---");
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE


A figura 11 abaixo ilustra a estrutura da classe `FabricaDeConteudo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 11:  Fábrica Abstrata FabricaDeConteudo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c234bca6eb22c8a4caa7ef18d0391df6e6cb8271/docs/PadroesDeProjeto/Imagens/FabricaConteudo.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Fábrica Concreta FabricaDeArtigo

FabricaDeArtigo é uma "ConcreteCreator" que também herda de FabricaDeConteudo. Assim, sua responsabilidade é implementar o método criarConteudo() para instanciar e retornar especificamente objetos Artigo. Ela extrai os dados necessários para um artigo (como textoHtml e fonte) do Map de detalhes fornecido.

Abaixo o código para FabricaDeArtigo.java:

<details>
  <summary><strong>Código para FabricaDeArtigo.java</strong></summary>


```java
package com.galaxiaconectada.fabricas; // Mesmo pacote da FabricaDeConteudo

import com.galaxiaconectada.core.Artigo;
import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade; 
import java.util.Map;


public class FabricaDeArtigo extends FabricaDeConteudo {


    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {

        String textoHtml = (String) detalhes.getOrDefault("textoHtml", "<p>Conteúdo do artigo não fornecido.</p>");
        String fonte = (String) detalhes.getOrDefault("fonte", "Fonte não especificada");

        // Cria e retorna uma nova instância de Artigo
        return new Artigo(id, titulo, descricao, visibilidade, textoHtml, fonte);
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE


A figura 12 abaixo ilustra a estrutura da classe `FabricaDeArtigo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 12: Fábrica Concreta FabricaDeArtigo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c234bca6eb22c8a4caa7ef18d0391df6e6cb8271/docs/PadroesDeProjeto/Imagens/FabricaArtigo.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Fábrica Concreta FabricaDeVideo

Especializada na criação de objetos Video, a FabricaDeVideo implementa o método fábrica criarConteudo() para construir instâncias de Video, utilizando os detalhes apropriados como urlVideo, duracaoSegundos e transcricao.

Abaixo o código para FabricaDeVideo.java

<details>
  <summary><strong>Código para FabricaDeVideo.java</strong></summary>

```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade; // Importa a classe Video
import com.galaxiaconectada.core.Video; 
import java.util.Map;

public class FabricaDeVideo extends FabricaDeConteudo {

    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        String urlVideo = (String) detalhes.getOrDefault("urlVideo", "http://example.com/default.mp4");
        int duracaoSegundos = (int) detalhes.getOrDefault("duracaoSegundos", 0);
        String transcricao = (String) detalhes.getOrDefault("transcricao", ""); 

        return new Video(id, titulo, descricao, visibilidade, urlVideo, duracaoSegundos, transcricao);
    }
}


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE


A figura 13 abaixo ilustra a estrutura da classe `FabricaDeVideo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 13: Fábrica Concreta FabricaDeVideo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c234bca6eb22c8a4caa7ef18d0391df6e6cb8271/docs/PadroesDeProjeto/Imagens/FabricaVideo.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Fábrica Concreta FabricaDeQuiz

FabricaDeQuiz é a fábrica concreta encarregada de instanciar objetos do tipo Quiz. Ela implementa criarConteudo() para configurar e retornar um Quiz com seus atributos específicos, como tempoLimiteMin e tentativasPermitidas.

Abaixo o código para FabricaDeQuiz.java:

<details>
  <summary><strong>Código para FabricaDeQuiz.java</strong></summary>


```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.Quiz; // Importa a classe Quiz
import com.galaxiaconectada.core.TipoVisibilidade;
import java.util.Map;

public class FabricaDeQuiz extends FabricaDeConteudo {

    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        int tempoLimiteMin = (int) detalhes.getOrDefault("tempoLimiteMin", 30);
        int tentativasPermitidas = (int) detalhes.getOrDefault("tentativasPermitidas", 1);

        return new Quiz(id, titulo, descricao, visibilidade, tempoLimiteMin, tentativasPermitidas);
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 14 abaixo ilustra a estrutura da classe `FabricaDeQuiz.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 14: Fábrica Concreta FabricaDeQuiz.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c234bca6eb22c8a4caa7ef18d0391df6e6cb8271/docs/PadroesDeProjeto/Imagens/FabricaQUIZ.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Fábrica Concreta FabricaDeJogo

A FabricaDeJogo é a fábrica concreta especializada na criação de instâncias da classe Jogo. Desse modo, ela implementa o método criarConteudo() para configurar e retornar objetos Jogo com seus detalhes como tipoJogo, nivelDificuldade e urlJogo.

Abaixo o código para FabricaDeJogo.java:

<details>
  <summary><strong>Código para FabricaDeJogo.java</strong></summary>

```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.Jogo; // Importa a classe Jogo
import com.galaxiaconectada.core.TipoVisibilidade;
import java.util.Map;

public class FabricaDeJogo extends FabricaDeConteudo {

    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        String tipoJogo = (String) detalhes.getOrDefault("tipoJogo", "Desconhecido");
        int nivelDificuldade = (int) detalhes.getOrDefault("nivelDificuldade", 1);
        String urlJogo = (String) detalhes.getOrDefault("urlJogo", "http://example.com/defaultgame");

        return new Jogo(id, titulo, descricao, visibilidade, tipoJogo, nivelDificuldade, urlJogo);
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 15 abaixo ilustra a estrutura da classe `FabricaDeJogo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 15: Fábrica Concreta FabricaDeJogo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c234bca6eb22c8a4caa7ef18d0391df6e6cb8271/docs/PadroesDeProjeto/Imagens/FabricaJogo.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Aplicação do Factory Method para Papéis de Usuário

Além da criação de diferentes tipos de `Conteudo`, o padrão Factory Method também foi aplicado para gerenciar a criação e atribuição de diferentes **papéis** aos usuários da plataforma "Galáxia Conectada". Isso permite que um objeto `Usuario` base possa assumir funcionalidades e atributos específicos de `Aluno`, `Instrutor`, `ProfessorVoluntario`, `Administrador` e `Moderador` , de forma flexível e desacoplada.

### Modelagem do Factory Method para Usuário








### Interface Produto PapelUsuario

A interface `PapelUsuario` define o contrato comum para todos os papéis específicos que um usuário pode desempenhar na plataforma. Ela estabelece os métodos essenciais que cada papel deve implementar, como `getTipoPapel()` para identificar o papel e `exibirDetalhesDoPapel()` para apresentar informações específicas daquela função.

Abaixo o código para `PapelUsuario.java`:

<details>
  <summary><strong>Código para `PapelUsuario.java`</strong></summary>
  
```java
package com.galaxiaconectada.domain.papeis;

  public interface PapelUsuario {
      String getTipoPapel(); // Retorna uma string como "Aluno", "Instrutor"
      void exibirDetalhesDoPapel(); // Mostra informações específicas do papel
      
  }

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 16 abaixo ilustra a estrutura da classe `PapelUsuario.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 16: Interface PapelUsuario.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/4a1b879db59aaf07e072541edf89263eaa7bf839/docs/PadroesDeProjeto/Imagens/aaPapelUsuario.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

#### Classes Concretas de Produto e Papéis

As classes concretas a seguir implementam a interface PapelUsuario e representam os diferentes papéis que um usuário pode ter, cada uma com seus atributos e comportamentos específicos, conforme definido na tabela de classes do projeto.

## Classe Aluno

A classe Aluno implementa PapelUsuario e encapsula os dados e funcionalidades específicas de um usuário enquanto estudante na plataforma, como seu progresso geral e o último acesso a trilhas educacionais.

Abaixo o código para `Aluno.java`

<details>
  <summary><strong>Código para `Aluno.java`</strong></summary>

```java
package com.galaxiaconectada.domain.papeis;

import java.time.LocalDateTime;
// Curso e TrilhaEducacional serão classes que serão definidas depois
// import com.galaxiaconectada.core.Curso;
// import com.galaxiaconectada.core.TrilhaEducacional;
// import java.util.List;
// import java.util.ArrayList;

public class Aluno implements PapelUsuario {
    private float progressoGeral;
    private LocalDateTime ultimoAcessoTrilha;


    public Aluno(float progressoGeral, LocalDateTime ultimoAcessoTrilha) {
        this.progressoGeral = progressoGeral;
        this.ultimoAcessoTrilha = ultimoAcessoTrilha;
    }

    @Override
    public String getTipoPapel() {
        return "Aluno";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Aluno:");
        System.out.println("  Progresso Geral: " + progressoGeral + "%");
        System.out.println("  Último Acesso à Trilha: " + ultimoAcessoTrilha);
    }

    // Métodos específicos do Aluno
    public void listarCursosConcluidos() { // Deveria retornar List<Curso>
        System.out.println("  [Aluno] Listando cursos concluídos...");
       
    }

    public void listarTrilhasEmAndamento() { // Deveria retornar List<TrilhaEducacional>
        System.out.println("  [Aluno] Listando trilhas em andamento...");
        
    }

    // Getters e Setters para os atributos
    public float getProgressoGeral() { return progressoGeral; }
    public void setProgressoGeral(float progressoGeral) { this.progressoGeral = progressoGeral; }
    public LocalDateTime getUltimoAcessoTrilha() { return ultimoAcessoTrilha; }
    public void setUltimoAcessoTrilha(LocalDateTime ultimoAcessoTrilha) { this.ultimoAcessoTrilha = ultimoAcessoTrilha; }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 17 abaixo ilustra a estrutura da classe `Aluno.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 17: Classe Aluno.java (Papel)
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/4a1b879db59aaf07e072541edf89263eaa7bf839/docs/PadroesDeProjeto/Imagens/aaaluno.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Instrutor

A classe Instrutor implementa PapelUsuario e representa um usuário com capacidades de criação e gerenciamento de conteúdo educacional, possuindo atributos como biografia, avaliação e especialidades.

Abaixo o código para `Instrutor.java` 

<details>
  <summary><strong>Código para `Instrutor.java`</strong></summary>


```java
package com.galaxiaconectada.domain.papeis;

import java.util.ArrayList;
import java.util.List;

// Curso e TrilhaEducacional serão classes que serão definidas depois
// import com.galaxiaconectada.core.TrilhaEducacional;

public class Instrutor implements PapelUsuario {

    private String biografiaCurta;
    private float avaliacaoMedia;
    private List<String> especialidades;

    public Instrutor(String biografiaCurta, float avaliacaoMedia, List<String> especialidades) {
        this.biografiaCurta = biografiaCurta;
        this.avaliacaoMedia = avaliacaoMedia;
        this.especialidades = especialidades != null ? especialidades : new ArrayList<>();
    }

    @Override
    public String getTipoPapel() {
        return "Instrutor";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Instrutor:");
        System.out.println("  Biografia: " + biografiaCurta);
        System.out.println("  Avaliação Média: " + avaliacaoMedia);
        System.out.println("  Especialidades: " + String.join(", ", especialidades));
    }

    // Métodos específicos do Instrutor (da Tabela 1)
    public void listarTrilhasCriadas() { // Deveria retornar List<TrilhaEducacional>
        System.out.println("  [Instrutor] Listando trilhas criadas...");

    }

    public void listarConteudosCriados() { // Deveria retornar List<Conteudo>
        System.out.println("  [Instrutor] Listando conteúdos criados...");
        
    }

    // Getters e Setters
    public String getBiografiaCurta() { return biografiaCurta; }
    public void setBiografiaCurta(String biografiaCurta) { this.biografiaCurta = biografiaCurta; }
    public float getAvaliacaoMedia() { return avaliacaoMedia; }
    public void setAvaliacaoMedia(float avaliacaoMedia) { this.avaliacaoMedia = avaliacaoMedia; }
    public List<String> getEspecialidades() { return especialidades; }
    public void setEspecialidades(List<String> especialidades) { this.especialidades = especialidades; }
}




```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 18 abaixo ilustra a estrutura da classe `Instrutor.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 18: Classe Instrutor.java (Papel)
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/4a1b879db59aaf07e072541edf89263eaa7bf839/docs/PadroesDeProjeto/Imagens/aaInstrutor.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe ProfessorVoluntario

Esta classe implementa PapelUsuario para usuários que atuam como professores voluntários, com atributos como área de especialidade e contagem de artigos revisados.

Abaixo o código para `ProfessorVoluntario.java`

<details>
  <summary><strong>Código para `ProfessorVoluntario.java`</strong></summary>


```java
package com.galaxiaconectada.domain.papeis;

import com.galaxiaconectada.core.Artigo; // Artigo está em .core
import java.util.ArrayList;
import java.util.List;

/**
 * Representa o papel de um Professor Voluntário na plataforma,
 * com suas especialidades e atividades de revisão.
 */
public class ProfessorVoluntario implements PapelUsuario {

    private String areaEspecialidade;
    private int artigosRevisados;

    /**
     * Construtor para o papel de Professor Voluntário.
     * @param areaEspecialidade A área de conhecimento principal do professor.
     * @param artigosRevisados A quantidade de artigos que este professor já revisou.
     */
    public ProfessorVoluntario(String areaEspecialidade, int artigosRevisados) {
        this.areaEspecialidade = areaEspecialidade;
        this.artigosRevisados = artigosRevisados;
    }

    @Override
    public String getTipoPapel() {
        return "ProfessorVoluntario";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Professor Voluntário:");
        System.out.println("  Área de Especialidade: " + areaEspecialidade);
        System.out.println("  Artigos Revisados: " + artigosRevisados);
    }

    /**
     * Lista os artigos submetidos (ou associados) a este professor voluntário.
     * (Placeholder: Retorna uma lista vazia por enquanto)
     * @return Uma lista de Artigos.
     */
    public List<Artigo> listarArtigosSubmetidos() {
        System.out.println("  [Professor Voluntário] Listando artigos submetidos/associados...");
        // TODO: Implementar a lógica real para buscar e retornar os artigos.
        return new ArrayList<>();
    }

    // Getters e Setters
    public String getAreaEspecialidade() {
        return areaEspecialidade;
    }

    public void setAreaEspecialidade(String areaEspecialidade) {
        this.areaEspecialidade = areaEspecialidade;
    }

    public int getArtigosRevisados() {
        return artigosRevisados;
    }

    public void setArtigosRevisados(int artigosRevisados) {
        this.artigosRevisados = artigosRevisados;
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 19 abaixo ilustra a estrutura da classe `ProfessorVoluntario.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 19: Classe ProfessorVoluntario.java (Papel)
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/4a1b879db59aaf07e072541edf89263eaa7bf839/docs/PadroesDeProjeto/Imagens/aaProfessorVoluntario.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Administrador

A classe Administrador implementa PapelUsuario e define as características e capacidades de um usuário com privilégios administrativos na plataforma, incluindo permissões globais e nível de acesso.

Abaixo o código para `Administrador.java`

<details>
  <summary><strong>Código para `Administrador.java`</strong></summary>

```java
package com.galaxiaconectada.domain.papeis;

import com.galaxiaconectada.domain.Usuario;
// import com.galaxiaconectada.domain.PromocaoExterna; // Classe ainda não criada como placeholder
import java.util.List;
import java.util.ArrayList;

/**
 * Representa o papel de um Administrador na plataforma,
 * com permissões globais e nível de acesso.
 */
public class Administrador implements PapelUsuario {

    private List<String> permissoesGlobais;
    private int nivelAcesso;

    /**
     * Construtor para o papel de Administrador.
     * @param permissoesGlobais Lista de strings representando as permissões globais.
     * @param nivelAcesso Nível numérico de acesso do administrador.
     */
    public Administrador(List<String> permissoesGlobais, int nivelAcesso) {
        this.permissoesGlobais = permissoesGlobais != null ? new ArrayList<>(permissoesGlobais) : new ArrayList<>();
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String getTipoPapel() {
        return "Administrador";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Administrador:");
        System.out.println("  Nível de Acesso: " + nivelAcesso);
        System.out.println("  Permissões Globais: " + String.join(", ", permissoesGlobais));
    }

    /**
     * Gerencia um usuário realizando uma determinada ação.
     * (Placeholder)
     * @param u O Usuário a ser gerenciado.
     * @param acao A ação a ser realizada (ex: "ATIVAR", "SUSPENDER", "DELETAR").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean gerenciarUsuario(Usuario u, String acao) {
        System.out.println("  [Admin] Gerenciando usuário '" + (u != null ? u.getNome() : "N/A") + "' com ação: " + acao);
        // TODO: Implementar a lógica real de gerenciamento de usuário.
        return true;
    }

    /**
     * Gerencia uma promoção realizando uma determinada ação.
     * (Placeholder: Parâmetro PromocaoExterna comentado até a classe ser criada)
     * @param acao A ação a ser realizada (ex: "APROVAR", "REJEITAR", "REMOVER").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean gerenciarPromocao(/* PromocaoExterna p, */ String acao) {
        // System.out.println("  [Admin] Gerenciando promoção '" + (p != null ? p.getNomeProduto() : "N/A") + "' com ação: " + acao);
        System.out.println("  [Admin] Gerenciando promoção com ação: " + acao);
        // TODO: Implementar a lógica real e descomentar o parâmetro PromocaoExterna.
        return true;
    }

    // Getters e Setters
    public List<String> getPermissoesGlobais() {
        return new ArrayList<>(permissoesGlobais); // Retorna uma cópia para proteger a lista interna
    }

    public void setPermissoesGlobais(List<String> permissoesGlobais) {
        this.permissoesGlobais = permissoesGlobais != null ? new ArrayList<>(permissoesGlobais) : new ArrayList<>();
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 20 abaixo ilustra a estrutura da classe `Administrador.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 20: Classe Administrador.java (Papel)
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/4a1b879db59aaf07e072541edf89263eaa7bf839/docs/PadroesDeProjeto/Imagens/aaAdministrador.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Moderador

Implementando PapelUsuario, a classe Moderador representa usuários responsáveis pela moderação de conteúdo em fóruns, possuindo atributos como nível de moderação e data de início da atividade.

Abaixo o código para `Moderador.java`

<details>
  <summary><strong>Código para `Moderador.java`</strong></summary>

```java
package com.galaxiaconectada.domain.papeis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// Placeholders para classes que serão definidas no pacote domain.forum
// import com.galaxiaconectada.domain.forum.Subforum;
// import com.galaxiaconectada.domain.forum.Postagem;
// import com.galaxiaconectada.domain.forum.Topico;

/**
 * Representa o papel de um Moderador na plataforma,
 * responsável por manter a ordem nos fóruns.
 */
public class Moderador implements PapelUsuario {

    private String nivelModeracao; // Ex: "JUNIOR", "SENIOR", "GLOBAL"
    private LocalDateTime dataInicioModeracao;

    /**
     * Construtor para o papel de Moderador.
     * @param nivelModeracao O nível de moderação.
     * @param dataInicioModeracao A data em que o usuário começou a moderar.
     */
    public Moderador(String nivelModeracao, LocalDateTime dataInicioModeracao) {
        this.nivelModeracao = nivelModeracao;
        this.dataInicioModeracao = dataInicioModeracao;
    }

    @Override
    public String getTipoPapel() {
        return "Moderador";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Moderador:");
        System.out.println("  Nível de Moderação: " + nivelModeracao);
        System.out.println("  Data Início Moderação: " + dataInicioModeracao);
    }

    /**
     * Lista os subfóruns que este moderador está designado a moderar.
     * (Placeholder: Retorna uma lista vazia de Object por enquanto)
     * @return Uma lista de Object (deverá ser List<Subforum> quando a classe Subforum for definida).
     */
    // MÉTODO CORRIGIDO ABAIXO:
    public List<Object> listarSubforumsModerados() { // Alterado para List<Object> temporariamente
        System.out.println("  [Moderador] Listando subfóruns moderados...");
        // TODO: Implementar a lógica real e alterar o tipo de retorno para List<Subforum>.
        return new ArrayList<>(); // Retorna uma lista vazia
    }

    /**
     * Realiza uma ação de moderação em uma postagem.
     * (Placeholder: Parâmetro Postagem comentado até a classe ser criada)
     * @param acao A ação a ser realizada (ex: "APROVAR", "EDITAR", "REMOVER").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean moderarPostagem(/* Postagem p, */ String acao) {
        System.out.println("  [Moderador] Moderando postagem com ação: " + acao);
        // TODO: Implementar a lógica real.
        return true;
    }

    /**
     * Realiza uma ação de moderação em um tópico.
     * (Placeholder: Parâmetro Topico comentado até a classe ser criada)
     * @param acao A ação a ser realizada (ex: "FIXAR", "FECHAR", "MOVER").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean moderarTopico(/* Topico t, */ String acao) {
        System.out.println("  [Moderador] Moderando tópico com ação: " + acao);
        // TODO: Implementar a lógica real.
        return true;
    }

    // Getters e Setters
    public String getNivelModeracao() {
        return nivelModeracao;
    }

    public void setNivelModeracao(String nivelModeracao) {
        this.nivelModeracao = nivelModeracao;
    }

    public LocalDateTime getDataInicioModeracao() {
        return dataInicioModeracao;
    }

    public void setDataInicioModeracao(LocalDateTime dataInicioModeracao) {
        this.dataInicioModeracao = dataInicioModeracao;
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 21 abaixo ilustra a estrutura da classe `Moderador.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 21: Classe Moderador.java (Papel)
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/4a1b879db59aaf07e072541edf89263eaa7bf839/docs/PadroesDeProjeto/Imagens/aaModerador.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

### Criação das Classes de Produto da Hierarquia de Usuário

## Fábrica Abstrata FabricaDePapelUsuario

A classe FabricaDePapelUsuario é a "Creator" abstrata para os papéis de usuário. Ela declara o método fábrica abstrato criarPapel(), que será implementado pelas subclasses concretas para instanciar um tipo específico de PapelUsuario. Também inclui um método de conveniência, atribuirPapelParaUsuario(), que utiliza o método fábrica para criar e associar o papel a um objeto Usuario.

Abaixo o código para `FabricaDePapelUsuario.java`

<details>
  <summary><strong>Código para `FabricaDePapelUsuario.java`</strong></summary>

```java
package com.galaxiaconectada.fabricas;

    import com.galaxiaconectada.domain.Usuario;
    import com.galaxiaconectada.domain.papeis.PapelUsuario; // A interface que os produtos implementam
    import java.util.Map;

    //Fábrica Abstrata (Creator) para criar diferentes tipos de PapelUsuario.
     
    public abstract class FabricaDePapelUsuario {

        public abstract PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos);

        /**
         * Um método de conveniência que usa o factory method para criar um papel, em seguida, o atribui ao usuário fornecido.
         *
         * @param usuario O Usuário que receberá o novo papel.
         * @param detalhesPapel Os detalhes para a criação do papel.
         * @return O objeto Usuario atualizado com o novo papel, ou o próprio usuário se o papel não puder ser criado.
         */
        public Usuario atribuirPapelParaUsuario(Usuario usuario, Map<String, Object> detalhesPapel) {
            PapelUsuario novoPapel = criarPapel(usuario, detalhesPapel);

            if (novoPapel != null && usuario != null) {
               
                usuario.setPapelPrincipal(novoPapel);
                System.out.println("[FÁBRICA DE PAPEL] Papel '" + novoPapel.getTipoPapel() + "' atribuído com sucesso ao usuário: " + usuario.getNome());
            } else if (usuario == null) {
                System.out.println("[FÁBRICA DE PAPEL ERRO] Usuário de referência não pode ser nulo para atribuir papel.");
            } else {
                System.out.println("[FÁBRICA DE PAPEL ERRO] Não foi possível criar o papel para o usuário: " + usuario.getNome());
            }
            return usuario;
        }
    }

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 22 abaixo ilustra a estrutura da classe `FabricaDePapelUsuario.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 22: Fábrica Abstrata FabricaDePapelUsuario.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/66c42dd46baccf8d6103799f83a7ad6ea74cd4bd/docs/PadroesDeProjeto/Imagens/FabricaPapelUsuario.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

#### Fábricas Concretas de Papel




## Fábrica FabricaDeAluno

FabricaDeAluno estende FabricaDePapelUsuario e implementa criarPapel() para instanciar e retornar objetos Aluno, utilizando os detalhes fornecidos para configurar o novo papel.

Abaixo o código para `FabricaDeAluno.java`


<details>
  <summary><strong>Código para `FabricaDeAluno.java`</strong></summary>


```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Aluno; // Importa a classe Aluno
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Fábrica Concreta (ConcreteCreator) especializada em criar objetos do tipo Aluno.
 */
public class FabricaDeAluno extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeAluno] Criando papel de Aluno...");

        // Extrai os detalhes específicos para um Aluno do Map.
        float progressoGeral = 0.0f;
        if (detalhesEspecificos.get("progressoGeral") instanceof Number) {
            progressoGeral = ((Number) detalhesEspecificos.get("progressoGeral")).floatValue();
        } else {
            System.out.println("[FabricaDeAluno] 'progressoGeral' não fornecido ou tipo inválido, usando padrão: 0.0f");
        }

        LocalDateTime ultimoAcessoTrilha = (LocalDateTime) detalhesEspecificos.getOrDefault("ultimoAcessoTrilha", LocalDateTime.now());

        // Cria e retorna uma nova instância de Aluno
        return new Aluno(progressoGeral, ultimoAcessoTrilha);
    }
}

``` 
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 23 abaixo ilustra a estrutura da classe `FabricaDeAluno.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 23: Fábrica FabricaDeAluno.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/66c42dd46baccf8d6103799f83a7ad6ea74cd4bd/docs/PadroesDeProjeto/Imagens/FabricaAluno.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Fábrica FabricaDeInstrutor

Esta fábrica é responsável por criar instâncias do papel Instrutor, configurando-o com dados como biografia e especialidades.

Abaixo o código para `FabricaDeInstrutor.java`

<details>
  <summary><strong>Código para `FabricaDeInstrutor.java`</strong></summary>

```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Instrutor; // Importa a classe Instrutor
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

//Fábrica Concreta especializada em criar objetos do tipo Instrutor.
public class FabricaDeInstrutor extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeInstrutor] Criando papel de Instrutor...");

        String biografiaCurta = (String) detalhesEspecificos.getOrDefault("biografiaCurta", "Instrutor(a) da plataforma Galáxia Conectada.");

        float avaliacaoMedia = 0.0f;
        if (detalhesEspecificos.get("avaliacaoMedia") instanceof Number) {
            avaliacaoMedia = ((Number) detalhesEspecificos.get("avaliacaoMedia")).floatValue();
        } else {
             System.out.println("[FabricaDeInstrutor] 'avaliacaoMedia' não fornecida ou tipo inválido, usando padrão: 0.0f");
        }

        @SuppressWarnings("unchecked") // Usado para suprimir aviso de cast não verificado, use com cautela
        List<String> especialidades = (List<String>) detalhesEspecificos.getOrDefault("especialidades", new ArrayList<String>());

        return new Instrutor(biografiaCurta, avaliacaoMedia, especialidades);
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 24 abaixo ilustra a estrutura da classe `FabricaDeInstrutor.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 24: Fábrica FabricaDeInstrutor.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/66c42dd46baccf8d6103799f83a7ad6ea74cd4bd/docs/PadroesDeProjeto/Imagens/FabricaInstrutor.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Fábrica FabricaDeProfessorVoluntario

FabricaDeProfessorVoluntario cria instâncias do papel ProfessorVoluntario, configurando atributos como área de especialidade.

Abaixo o código para `FabricaDeProfessorVoluntario.java`

<details>
  <summary><strong>Código para `FabricaDeProfessorVoluntario.java`</strong></summary>

```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.ProfessorVoluntario;
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.util.Map;

public class FabricaDeProfessorVoluntario extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeProfessorVoluntario] Criando papel de Professor Voluntário...");

        String areaEspecialidade = (String) detalhesEspecificos.getOrDefault("areaEspecialidade", "Não especificada");
        int artigosRevisados = 0;
         if (detalhesEspecificos.get("artigosRevisados") instanceof Number) {
             artigosRevisados = ((Number) detalhesEspecificos.get("artigosRevisados")).intValue();
         } else {
             System.out.println("[FabricaDeProfessorVoluntario] 'artigosRevisados' não fornecido ou tipo inválido, usando padrão: 0");
         }

        return new ProfessorVoluntario(areaEspecialidade, artigosRevisados);
    }
}

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 25 abaixo ilustra a estrutura da classe `FabricaDeProfessorVoluntario.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 25: Fábrica FabricaDeProfessorVoluntario.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/66c42dd46baccf8d6103799f83a7ad6ea74cd4bd/docs/PadroesDeProjeto/Imagens/FabricaInstrutorVoluntario.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Fábrica FabricaDeAdministrador

Esta fábrica é especializada na criação de papéis de Administrador, configurando suas permissões e nível de acesso.

Abaixo o código para `FabricaDeAdministrador.java`

<details>
  <summary><strong>Código para `FabricaDeAdministrador.java`</strong></summary>


```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Administrador;
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class FabricaDeAdministrador extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeAdministrador] Criando papel de Administrador...");

        @SuppressWarnings("unchecked")
        List<String> permissoesGlobais = (List<String>) detalhesEspecificos.getOrDefault("permissoesGlobais", new ArrayList<String>());

        int nivelAcesso = 1; // Nível padrão
         if (detalhesEspecificos.get("nivelAcesso") instanceof Number) {
             nivelAcesso = ((Number) detalhesEspecificos.get("nivelAcesso")).intValue();
         } else {
             System.out.println("[FabricaDeAdministrador] 'nivelAcesso' não fornecido ou tipo inválido, usando padrão: 1");
         }

        return new Administrador(permissoesGlobais, nivelAcesso);
    }
}


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 26 abaixo ilustra a estrutura da classe `FabricaDeAdministrador.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 26: Fábrica FabricaDeAdministrador.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/66c42dd46baccf8d6103799f83a7ad6ea74cd4bd/docs/PadroesDeProjeto/Imagens/FabricaAdministrador.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

#### Fábrica FabricaDeModerador

FabricaDeModerador é responsável por criar papéis de Moderador, definindo atributos como o nível de moderação.


Abaixo o código para `FabricaDeModerador.java `


```java
package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Moderador;
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.time.LocalDateTime;
import java.util.Map;

public class FabricaDeModerador extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeModerador] Criando papel de Moderador...");

        String nivelModeracao = (String) detalhesEspecificos.getOrDefault("nivelModeracao", "JUNIOR");
        LocalDateTime dataInicioModeracao = (LocalDateTime) detalhesEspecificos.getOrDefault("dataInicioModeracao", LocalDateTime.now());

        return new Moderador(nivelModeracao, dataInicioModeracao);
    }
}


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 27 abaixo ilustra a estrutura da classe `FabricaDeModerador.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 27: Fábrica FabricaDeModerador.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/66c42dd46baccf8d6103799f83a7ad6ea74cd4bd/docs/PadroesDeProjeto/Imagens/FabricaModerador.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

## Classe de Teste AplicacaoGalaxia

Para testar as classes e os códigos, foi criada uma main chamada AplicacaoGalaxia. O código dela se encontra abaixo:

```java
package com.galaxiaconectada.main;

// Imports das fábricas de Conteúdo
import com.galaxiaconectada.core.TipoVisibilidade;
import com.galaxiaconectada.domain.Usuario;
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
import com.galaxiaconectada.fabricas.FabricaDeVideo; // A interface de Papel
import java.time.LocalDateTime;   // O Enum de Visibilidade
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AplicacaoGalaxia {

    // Fábrica para Conteúdo
    private static FabricaDeConteudo fabricaDeConteudoAtual;
    // Fábrica para PapelUsuario
    private static FabricaDePapelUsuario fabricaDePapelAtual;

    private static Scanner scanner = new Scanner(System.in);
    // Lista para guardar usuários criados na sessão
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("### Bem-vindo(a) à Plataforma Interativa Galáxia Conectada ###");
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            exibirMenuPrincipalGeral();
            int escolha = lerOpcaoDoUsuarioNumerica();

            switch (escolha) {
                case 1:
                    gerenciarPublicacaoDeConteudo();
                    break;
                case 2:
                    gerenciarUsuariosEPapeis();
                    break;
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

    public static void exibirMenuPrincipalGeral() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("O que você gostaria de fazer?");
        System.out.println("1. Gerenciar Publicação de Conteúdo");
        System.out.println("2. Gerenciar Usuários e Papéis");
        System.out.println("0. Sair da Plataforma");
        System.out.print("Digite o número da sua opção: ");
    }

    public static int lerOpcaoDoUsuarioNumerica() {
        try {
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Importante: consumir o caractere de nova linha
            return opcao;
        } catch (InputMismatchException e) {
            System.out.println("[ERRO] Entrada inválida. Por favor, digite um número.");
            scanner.nextLine(); // Limpar o buffer do scanner em caso de erro
            return -1; // Retorna um valor inválido para repetir o menu ou ser tratado
        }
    }

    // ---- SEÇÃO DE GERENCIAMENTO DE CONTEÚDO ----
    public static void gerenciarPublicacaoDeConteudo() {
        boolean continuarNoMenuConteudo = true;
        while (continuarNoMenuConteudo) {
            exibirMenuPublicacaoConteudo();
            int escolha = lerOpcaoDoUsuarioNumerica();

            switch (escolha) {
                case 1:
                    processarPublicacaoDeTipoEspecifico("ARTIGO");
                    break;
                case 2:
                    processarPublicacaoDeTipoEspecifico("VIDEO");
                    break;
                case 3:
                    processarPublicacaoDeTipoEspecifico("QUIZ");
                    break;
                case 4:
                    processarPublicacaoDeTipoEspecifico("JOGO");
                    break;
                case 0:
                    continuarNoMenuConteudo = false;
                    System.out.println("\n[SISTEMA] Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("\n[ERRO] Opção inválida! Por favor, escolha um número do menu.");
            }
        }
    }

    public static void exibirMenuPublicacaoConteudo() {
        System.out.println("\n--- MENU DE PUBLICAÇÃO DE CONTEÚDO ---");
        System.out.println("Qual tipo de conteúdo você gostaria de publicar hoje?");
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
        System.out.println("   ↳ Explicação: Esta fábrica é uma especialista! Ela sabe exatamente como construir um objeto do tipo '" + tipoConteudo + "'.");

        System.out.println("\n--- Coletando Dados Comuns do Conteúdo ---");
        System.out.print("ID do conteúdo (número): ");
        int id = lerOpcaoDoUsuarioNumerica();

        System.out.print("Título: ");
        String titulo = scanner.nextLine();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        TipoVisibilidade.mostrarOpcoes();
        System.out.print("Escolha o número da Visibilidade: ");
        int escolhaVisibilidade = lerOpcaoDoUsuarioNumerica();
        TipoVisibilidade visibilidadeSelecionada = TipoVisibilidade.fromOpcao(escolhaVisibilidade);

        if (visibilidadeSelecionada == null) {
            System.out.println("[ERRO] Opção de visibilidade inválida. Usando PUBLICO como padrão.");
            visibilidadeSelecionada = TipoVisibilidade.PUBLICO;
        }
        System.out.println("[INFO] Visibilidade definida como: " + visibilidadeSelecionada.getDescricao());

        Map<String, Object> detalhesEspecificos = new HashMap<>();
        System.out.println("\n--- Coletando Dados Específicos para " + tipoConteudo.toUpperCase() + " ---");
        if (tipoConteudo.equalsIgnoreCase("ARTIGO")) {
            System.out.print("Texto HTML do Artigo: ");
            detalhesEspecificos.put("textoHtml", scanner.nextLine());
            System.out.print("Fonte do Artigo: ");
            detalhesEspecificos.put("fonte", scanner.nextLine());
        } else if (tipoConteudo.equalsIgnoreCase("VIDEO")) {
            System.out.print("URL do Vídeo: ");
            detalhesEspecificos.put("urlVideo", scanner.nextLine());
            System.out.print("Duração em segundos (número): ");
            detalhesEspecificos.put("duracaoSegundos", scanner.nextInt());
            scanner.nextLine(); // Consumir nova linha
            System.out.print("Transcrição do Vídeo: ");
            detalhesEspecificos.put("transcricao", scanner.nextLine());
        } else if (tipoConteudo.equalsIgnoreCase("QUIZ")) {
            System.out.print("Tempo Limite em minutos (número): ");
            detalhesEspecificos.put("tempoLimiteMin", scanner.nextInt());
            scanner.nextLine(); // Consumir nova linha
            System.out.print("Número de Tentativas Permitidas (número): ");
            detalhesEspecificos.put("tentativasPermitidas", scanner.nextInt());
            scanner.nextLine(); // Consumir nova linha
        } else if (tipoConteudo.equalsIgnoreCase("JOGO")) {
            System.out.print("Tipo do Jogo (ex: Puzzle, Estratégia): ");
            detalhesEspecificos.put("tipoJogo", scanner.nextLine());
            System.out.print("Nível de Dificuldade (número): ");
            detalhesEspecificos.put("nivelDificuldade", scanner.nextInt());
            scanner.nextLine(); // Consumir nova linha
            System.out.print("URL do Jogo: ");
            detalhesEspecificos.put("urlJogo", scanner.nextLine());
        }

        System.out.println("\n[INTERAÇÃO COM A FÁBRICA] " + fabricaDeConteudoAtual.getClass().getSimpleName() + " vai agora criar o objeto '" + tipoConteudo + "'.");
        System.out.println("   ↳ A fábrica usa o 'Factory Method' (criarConteudo) para instanciar o tipo correto de Conteudo.");
        fabricaDeConteudoAtual.iniciarPublicacaoDeConteudo(id, titulo, descricao, visibilidadeSelecionada, detalhesEspecificos);

        System.out.println("O " + tipoConteudo.toUpperCase() + " '" + titulo + "' foi processado pela fábrica!");
        System.out.println("==============================================");
    }

    public static void configurarFabricaDeConteudo(String tipoConteudo) {
        if (tipoConteudo.equalsIgnoreCase("ARTIGO")) {
            fabricaDeConteudoAtual = new FabricaDeArtigo();
        } else if (tipoConteudo.equalsIgnoreCase("VIDEO")) {
            fabricaDeConteudoAtual = new FabricaDeVideo();
        } else if (tipoConteudo.equalsIgnoreCase("QUIZ")) {
            fabricaDeConteudoAtual = new FabricaDeQuiz();
        } else if (tipoConteudo.equalsIgnoreCase("JOGO")) {
            fabricaDeConteudoAtual = new FabricaDeJogo();
        } else {
            throw new IllegalArgumentException("Tipo de conteúdo desconhecido para a fábrica: " + tipoConteudo);
        }
    }

    // ---- SEÇÃO DE GERENCIAMENTO DE USUÁRIOS E PAPÉIS ----
    public static void gerenciarUsuariosEPapeis() {
        boolean continuarNoMenuUsuario = true;
        while (continuarNoMenuUsuario) {
            exibirMenuUsuariosEPapeis();
            int escolha = lerOpcaoDoUsuarioNumerica();

            switch (escolha) {
                case 1:
                    criarNovoUsuarioBaseInterativo();
                    break;
                case 2:
                    atribuirPapelInterativo();
                    break;
                case 3:
                    exibirInformacoesDeUsuarioInterativo();
                    break;
                case 0:
                    continuarNoMenuUsuario = false;
                    System.out.println("\n[SISTEMA] Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("\n[ERRO] Opção inválida! Por favor, escolha um número do menu.");
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
        System.out.print("ID do usuário (número): ");
        int id = lerOpcaoDoUsuarioNumerica();
        System.out.print("Nome do usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Email do usuário: ");
        String email = scanner.nextLine();
        System.out.print("Senha do usuário: ");
        String senha = scanner.nextLine();

        Usuario novoUsuario = new Usuario(id, nome, email, senha);
        usuariosCadastrados.add(novoUsuario);
        System.out.println("[USUÁRIO CRIADO] Usuário '" + nome + "' (ID: " + id + ") criado com sucesso sem papel específico.");
        novoUsuario.exibirInformacoesCompletas();
    }

    public static void exibirInformacoesDeUsuarioInterativo() {
        System.out.println("\n--- Exibir Informações de Usuário ---");
        if (usuariosCadastrados.isEmpty()) {
            System.out.println("[INFO] Nenhum usuário cadastrado nesta sessão ainda.");
            return;
        }

        System.out.println("Usuários cadastrados nesta sessão (escolha pelo número):");
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            Usuario u = usuariosCadastrados.get(i);
            String papelInfo = (u.getPapelPrincipal() != null) ? " (" + u.getPapelPrincipal().getTipoPapel() + ")" : " (Sem papel)";
            System.out.println((i + 1) + ". " + u.getNome() + " (ID: " + u.getId() + ")" + papelInfo);
        }
        System.out.print("Digite o número do usuário para ver detalhes (ou 0 para cancelar): ");
        int escolhaUsuarioNum = lerOpcaoDoUsuarioNumerica();

        if (escolhaUsuarioNum > 0 && escolhaUsuarioNum <= usuariosCadastrados.size()) {
            Usuario usuarioSelecionado = usuariosCadastrados.get(escolhaUsuarioNum - 1);
            usuarioSelecionado.exibirInformacoesCompletas();
        } else if (escolhaUsuarioNum != 0) {
            System.out.println("[ERRO] Escolha de usuário inválida.");
        }
    }

    public static void atribuirPapelInterativo() {
        System.out.println("\n--- Atribuir Papel a Usuário ---");
        if (usuariosCadastrados.isEmpty()) {
            System.out.println("[INFO] Nenhum usuário cadastrado. Crie um usuário primeiro (Opção 1 do Menu de Usuários).");
            return;
        }

        System.out.println("Usuários cadastrados (escolha pelo número):");
         for (int i = 0; i < usuariosCadastrados.size(); i++) {
            Usuario u = usuariosCadastrados.get(i);
            String papelInfo = (u.getPapelPrincipal() != null) ? " (" + u.getPapelPrincipal().getTipoPapel() + ")" : " (Sem papel)";
            System.out.println((i + 1) + ". " + u.getNome() + " (ID: " + u.getId() + ")" + papelInfo);
        }
        System.out.print("Digite o número do usuário ao qual deseja atribuir um papel (ou 0 para cancelar): ");
        int escolhaUsuarioNum = lerOpcaoDoUsuarioNumerica();

        if (escolhaUsuarioNum == 0) {
            System.out.println("[INFO] Atribuição de papel cancelada.");
            return;
        }
        if (escolhaUsuarioNum < 1 || escolhaUsuarioNum > usuariosCadastrados.size()) {
            System.out.println("[ERRO] Escolha de usuário inválida.");
            return;
        }
        Usuario usuarioEscolhido = usuariosCadastrados.get(escolhaUsuarioNum - 1);

        System.out.println("\n--- Escolha o Papel para " + usuarioEscolhido.getNome() + " ---");
        System.out.println("1. Aluno");
        System.out.println("2. Instrutor");
        System.out.println("3. Professor Voluntário");
        System.out.println("4. Administrador");
        System.out.println("5. Moderador");
        System.out.println("0. Cancelar Atribuição");
        System.out.print("Digite o número do papel: ");
        int escolhaPapelNum = lerOpcaoDoUsuarioNumerica();

        String tipoPapelString = null;
        switch (escolhaPapelNum) {
            case 1: tipoPapelString = "ALUNO"; break;
            case 2: tipoPapelString = "INSTRUTOR"; break;
            case 3: tipoPapelString = "PROFESSOR_VOLUNTARIO"; break;
            case 4: tipoPapelString = "ADMINISTRADOR"; break;
            case 5: tipoPapelString = "MODERADOR"; break;
            case 0: System.out.println("[INFO] Atribuição de papel cancelada."); return;
            default: System.out.println("[ERRO] Tipo de papel inválido."); return;
        }

        configurarFabricaDePapel(tipoPapelString);
        System.out.println("[FÁBRICA DE PAPEL SELECIONADA]: " + fabricaDePapelAtual.getClass().getSimpleName());
        System.out.println("   ↳ Explicação: Esta fábrica é especialista em criar o papel de '" + tipoPapelString + "'.");

        Map<String, Object> detalhesPapel = new HashMap<>();
        System.out.println("\n--- Coletando Dados Específicos para o Papel de " + tipoPapelString.toUpperCase() + " ---");

        if (tipoPapelString.equalsIgnoreCase("ALUNO")) {
            System.out.print("Progresso Geral do Aluno (ex: 75.5): ");
            detalhesPapel.put("progressoGeral", scanner.nextFloat());
            scanner.nextLine(); // Consumir nova linha
            detalhesPapel.put("ultimoAcessoTrilha", LocalDateTime.now()); // Pode ser definido automaticamente
        } else if (tipoPapelString.equalsIgnoreCase("INSTRUTOR")) {
            System.out.print("Biografia Curta do Instrutor: ");
            detalhesPapel.put("biografiaCurta", scanner.nextLine());
            System.out.print("Avaliação Média (ex: 4.5): ");
            detalhesPapel.put("avaliacaoMedia", scanner.nextFloat());
            scanner.nextLine();
            System.out.print("Especialidades (separadas por vírgula, ex: Astrofísica,Cosmologia): ");
            String[] especialidadesArray = scanner.nextLine().split(",");
            detalhesPapel.put("especialidades", List.of(especialidadesArray));
        } else if (tipoPapelString.equalsIgnoreCase("PROFESSOR_VOLUNTARIO")) {
            System.out.print("Área de Especialidade: ");
            detalhesPapel.put("areaEspecialidade", scanner.nextLine());
            System.out.print("Número de Artigos Revisados: ");
            detalhesPapel.put("artigosRevisados", scanner.nextInt());
            scanner.nextLine();
        } else if (tipoPapelString.equalsIgnoreCase("ADMINISTRADOR")) {
            System.out.print("Permissões Globais (separadas por vírgula, ex: GERENCIAR_USUARIOS,MODERAR_TUDO): ");
            String[] permissoesArray = scanner.nextLine().split(",");
            detalhesPapel.put("permissoesGlobais", List.of(permissoesArray));
            System.out.print("Nível de Acesso (número): ");
            detalhesPapel.put("nivelAcesso", scanner.nextInt());
            scanner.nextLine();
        } else if (tipoPapelString.equalsIgnoreCase("MODERADOR")) {
            System.out.print("Nível de Moderação (ex: JUNIOR, SENIOR): ");
            detalhesPapel.put("nivelModeracao", scanner.nextLine());
            detalhesPapel.put("dataInicioModeracao", LocalDateTime.now()); // Pode ser definido automaticamente
        }

        System.out.println("\n[INTERAÇÃO COM A FÁBRICA DE PAPEL] " + fabricaDePapelAtual.getClass().getSimpleName() + " vai agora criar e atribuir o papel.");
        System.out.println("   ↳ A fábrica usa o 'Factory Method' (criarPapel) para instanciar o tipo correto de PapelUsuario.");
        fabricaDePapelAtual.atribuirPapelParaUsuario(usuarioEscolhido, detalhesPapel);
        
        System.out.println("\n--- Informações Atualizadas do Usuário ---");
        usuarioEscolhido.exibirInformacoesCompletas();
        System.out.println("==============================================");
    }

    public static void configurarFabricaDePapel(String tipoPapel) {
        if (tipoPapel.equalsIgnoreCase("ALUNO")) {
            fabricaDePapelAtual = new FabricaDeAluno();
        } else if (tipoPapel.equalsIgnoreCase("INSTRUTOR")) {
            fabricaDePapelAtual = new FabricaDeInstrutor();
        } else if (tipoPapel.equalsIgnoreCase("PROFESSOR_VOLUNTARIO")) {
            fabricaDePapelAtual = new FabricaDeProfessorVoluntario();
        } else if (tipoPapel.equalsIgnoreCase("ADMINISTRADOR")) {
            fabricaDePapelAtual = new FabricaDeAdministrador();
        } else if (tipoPapel.equalsIgnoreCase("MODERADOR")) {
            fabricaDePapelAtual = new FabricaDeModerador();
        } else {
            throw new IllegalArgumentException("Tipo de papel desconhecido para a fábrica: " + tipoPapel);
        }
    }
} 

```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


## Conclusão

A aplicação do padrão de projeto Factory Method no desenvolvimento da plataforma **Galáxia Conectada** demonstrou-se uma solução para promover flexibilidade, escalabilidade e baixo acoplamento na criação de objetos relacionados a conteúdos e usuários. Ao centralizar e especializar a lógica de instanciamento, foi possível garantir que novos tipos de conteúdo ou perfis de usuários possam ser adicionados com facilidade, sem impactar a estrutura já existente do sistema.

## Bibliografia 

<a name="ref1"></a>
[1] IBM. Definindo um factory method. Atualizado pela última vez em 03 fev. 2025. Disponível em: https://www.ibm.com/docs/pt-br/cobol-zos/6.4.0?topic=section-defining-factory-method. Acesso em: 22 maio 2025.

<a name="ref2"></a>
[2] Nuzzi, Jones Roberto. Design Patterns – Parte 3: Factory Method. Medium, 07 out. 2019. Disponível em: https://medium.com/@jonesroberto/desing-patterns-factory-method-a7496ae071aa. Acesso em: 22 maio 2025.

<a name="ref3"></a>
[3] REFACTORING.GURU. Factory Method. Disponível em: https://refactoring.guru/design-patterns/factory-method. Acesso em: 22 maio 2025.

<a name="ref4"></a>
[4] Thiengo. Padrão de Projeto: Factory Method. Disponível em: https://www.thiengo.com.br/padrao-de-projeto-factory-method#title-5. Acesso em: 23 maio 2025.

## Histórico de versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 22/05/2025 |
| 1.1 | Adição do Conteudo.java | Larissa Stéfane | 22/05/2025 |
| 1.2 | Adição das outras classes de poduto da hierarquia| Larissa Stéfane | 23/05/2025 |
| 1.3 | Adição das fábricas de contudo | Larissa Stéfane | 23/05/2025 |
| 1.4 | Adição das outras classes dos usuários| Larissa Stéfane | 23/05/2025 |
| 1.5 | Adição das fábricas de Usuários | Larissa Stéfane | 23/05/2025 |
| 1.6 | Reorganização dos códigos | Larissa Stéfane | 24/05/2025 |

