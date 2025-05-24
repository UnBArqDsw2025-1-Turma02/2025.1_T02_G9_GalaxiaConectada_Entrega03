# Padrão Criacional Factory Method 

## Sumário

- [Introdução](#introdução)
- [Objetivo](#objetivo)
- [Metodologia](#metodologia)
- [Desenvolvimento e Implementação](#desenvolvimento-e-implementação)
  - [Preparação do Ambiente](#preparação-do-ambiente)
- [Aplicação do Factory Method para Papéis de Conteúdo](#aplicação-do-factory-method-para-papéis-de-conteúdo)
  - [Criação das Classes de Produto da Hierarquia de Conteúdo](#criação-das-classes-de-produto-da-hierarquia-de-conteúdo)
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
- [Classe de Teste AplicacaoGalaxia (Main)](#classe-de-teste-aplicacaogalaxia-main)
- [Conclusão](#conclusão)
- [Bibliografia](#bibliografia)
- [Histórico de Versão](#histórico-de-versão)


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
* * **Diagrama de Classes de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes).


## Desenvolvimento e Implementação

A seguir, detalha-se a configuração do ambiente de desenvolvimento e a implementação em Java das classes que compõem a solução com o padrão Factory Method.

### Preparação do Ambiente

- O desenvolvimento foi realizado ao utilizar o [**Visual Studio Code (VSCode)**](https://code.visualstudio.com/) como IDE principal.
- O ambiente Java foi configurado com o **OpenJDK JDK**.
- Para facilitar o desenvolvimento Java no VSCode, foi utilizado o pacote de extensões **"Extension Pack for Java"** da Microsoft, que provê funcionalidades como autocompletar, depuração e gerenciamento de projetos Java.
- A estrutura de pastas do projeto foi organizada seguindo as convenções de pacotes Java, com o código fonte principal localizado na pasta `src`.

### Criação das Classes de Produto da Hierarquia de Conteúdo

A base para a aplicação do Factory Method é a existência de uma hierarquia de "produtos". No projeto "Galáxia Conectada", estes produtos são os diferentes tipos de conteúdo educacional que a plataforma oferecerá.

### Aplicação do Factory Method para Papéis de Conteúdo

#### Classe Abstrata Conteudo

A classe `Conteudo` serve como a **superclasse abstrata** para todos os tipos de materiais de estudo. Assim, ela define atributos comuns como `id`, `titulo`, `descricao`, `dataPublicacao` e `visibilidade`, além de um método abstrato `exibir()` que será implementado de forma específica por cada subclasse para determinar como o conteúdo é apresentado.

Abaixo o código para `Conteudo.java`:
```
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


#### Classe TipoVisibilidade

O TipoVisibilidade foi criado para representar de forma segura e clara os diferentes níveis de acesso que um Conteudo pode ter. Assim, ao utilizar essa classe é possível evitar erros de digitação e torna o código mais robusto e legível. 

**Observação:** Cada constante uma descrição para facilitar a interação e compreensão.

Abaixo o código para TipoVisibilidade.java:

```
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




#### Classe Concreta Artigo

A classe Artigo é uma especialização de Conteudo, a qual representa conteúdo textual. Além dos atributos herdados, possui textoHtml para o corpo do artigo e fonte para referências. 

- **Observação:** O método exibir() é implementado para formatar e apresentar essas informações de maneira adequada para um artigo.

Abaixo o código para Artigo.java:

```
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


#### Classe Concreta Video

A classe **Video** estende **Conteudo** para representar conteúdo audiovisual. Com isso, contém atributos específicos como urlVideo, duracaoSegundos e transcricao. 

Abaixo o código para Video.java:

```
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

#### Classe Concreta Quiz

Como um tipo de Conteudo interativo, a classe Quiz é destinada a avaliações ou testes de conhecimento. Dessa maneira, ela herda de Conteudo e adiciona atributos como tempoLimiteMin e tentativasPermitidas.

Abaixo o código para Quiz.java:

```
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

#### Classe Concreta Jogo

A classe Jogo representa conteúdo educacional em formato interativo e lúdico. Sendo uma subclasse de Conteudo, ela inclui atributos específicos como tipoJogo, nivelDificuldade e urlJogo. 

Abaixo o código para Jogo.java:

```
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


#### Classe Auxiliar Usuario

A classe Usuario, localizada no pacote com.galaxiaconectada.domain, é fundamental para o sistema, pois representa os participantes da plataforma. Assim, no contexto desta implementação do Factory Method, ela é utilizada por métodos dentro das classes de Conteudo (ex: adicionarComentario) e para simular interações em Quiz e Jogo. 

**Observação:** Foi baseada no diagrama de [classes do projeto.](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses)

Abaixo o código para Usuario.java:

```
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

### Criação das Classes de Fábrica de Conteudo

Com os "produtos" (Conteudo e suas subclasses) definidos, foram implementadas as fábricas responsáveis pela sua criação, seguindo o padrão Factory Method.


#### Fábrica Abstrata FabricaDeConteudo

FabricaDeConteudo é a classe "Creator" abstrata. Com isso, ela define o contrato para todas as fábricas de conteúdo ao declarar o método fábrica abstrato criarConteudo(). Este método recebe os parâmetros comuns para a criação de qualquer Conteudo, incluindo o TipoVisibilidade, e um Map para os detalhes específicos de cada subclasse de Conteudo. 

A fábrica abstrata também possui um método concreto, **iniciarPublicacaoDeConteudo**, a qual demonstra como a fábrica pode orquestrar a criação e o uso inicial do produto.

Abaixo o código para FabricaDeConteudo.java:

```
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
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


#### Fábrica Concreta FabricaDeArtigo

FabricaDeArtigo é uma "ConcreteCreator" que também herda de FabricaDeConteudo. Assim, sua responsabilidade é implementar o método criarConteudo() para instanciar e retornar especificamente objetos Artigo. Ela extrai os dados necessários para um artigo (como textoHtml e fonte) do Map de detalhes fornecido.

Abaixo o código para FabricaDeArtigo.java:

```
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


A figura 12 abaixo ilustra a estrutura da classe `FabricaDeArtigo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 12: Fábrica Concreta FabricaDeArtigo.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


#### Fábrica Concreta FabricaDeVideo

Especializada na criação de objetos Video, a FabricaDeVideo implementa o método fábrica criarConteudo() para construir instâncias de Video, utilizando os detalhes apropriados como urlVideo, duracaoSegundos e transcricao.

Abaixo o código para FabricaDeVideo.java


```
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
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

#### Fábrica Concreta FabricaDeQuiz

FabricaDeQuiz é a fábrica concreta encarregada de instanciar objetos do tipo Quiz. Ela implementa criarConteudo() para configurar e retornar um Quiz com seus atributos específicos, como tempoLimiteMin e tentativasPermitidas.

Abaixo o código para FabricaDeQuiz.java:

```
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
    Figura 14: Fábrica Concreta FabricaDeVideo.java
    <br>
    <img src="Fábrica Concreta FabricaDeQuiz.java" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


#### Fábrica Concreta FabricaDeJogo

A FabricaDeJogo é a fábrica concreta especializada na criação de instâncias da classe Jogo. Desse modo, ela implementa o método criarConteudo() para configurar e retornar objetos Jogo com seus detalhes como tipoJogo, nivelDificuldade e urlJogo.

Abaixo o código para FabricaDeJogo.java:

```
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
    <img src="Fábrica Concreta FabricaDeQuiz.java" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

### Aplicação do Factory Method para Papéis de Usuário

Além da criação de diferentes tipos de `Conteudo`, o padrão Factory Method também foi aplicado para gerenciar a criação e atribuição de diferentes **papéis** aos usuários da plataforma "Galáxia Conectada". Isso permite que um objeto `Usuario` base possa assumir funcionalidades e atributos específicos de `Aluno`, `Instrutor`, `ProfessorVoluntario`, `Administrador` e `Moderador` , de forma flexível e desacoplada.

### Interface Produto PapelUsuario

A interface `PapelUsuario` define o contrato comum para todos os papéis específicos que um usuário pode desempenhar na plataforma. Ela estabelece os métodos essenciais que cada papel deve implementar, como `getTipoPapel()` para identificar o papel e `exibirDetalhesDoPapel()` para apresentar informações específicas daquela função.

Abaixo o código para `PapelUsuario.java`:

```
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
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


#### Classes Concretas de Produto e Papéis

As classes concretas a seguir implementam a interface PapelUsuario e representam os diferentes papéis que um usuário pode ter, cada uma com seus atributos e comportamentos específicos, conforme definido na tabela de classes do projeto.

#### Classe Aluno

A classe Aluno implementa PapelUsuario e encapsula os dados e funcionalidades específicas de um usuário enquanto estudante na plataforma, como seu progresso geral e o último acesso a trilhas educacionais.

Abaixo o código para `Aluno.java`

```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 17 abaixo ilustra a estrutura da classe `Aluno.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 17: Classe Aluno.java (Papel)
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


#### Classe Instrutor


```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 18 abaixo ilustra a estrutura da classe `Instrutor.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 18: Classe Instrutor.java (Papel)
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


#### Classe ProfessorVoluntario


```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 19 abaixo ilustra a estrutura da classe `ProfessorVoluntario.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 19: Classe ProfessorVoluntario.java (Papel)
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>



#### Classe Administrador


```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 20 abaixo ilustra a estrutura da classe `Administrador.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 20: Classe Administrador.java (Papel)
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

#### Classe Moderador

```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 21 abaixo ilustra a estrutura da classe `Moderador.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 21: Classe Moderador.java (Papel)
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

### Criação das Classes de Produto da Hierarquia de Usuário

#### Fábrica Abstrata FabricaDePapelUsuario


```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

#### Fábricas Concretas de Papel

```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Fábrica FabricaDeAluno

```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Fábrica FabricaDeInstrutor

```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Fábrica FabricaDeProfessorVoluntario


```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


#### Fábrica FabricaDeAdministrador


```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.



#### Fábrica FabricaDeModerador

```


```
<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


### Classe de Teste AplicacaoGalaxia a Main

## Conclusão

## Bibliografia 


## Histórico de versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 22/05/2025 |
| 1.1 | Adição do Conteudo.java | Larissa Stéfane | 22/05/2025 |
| 1.2 | Adição das outras classes de poduto da hierarquia| Larissa Stéfane | 23/05/2025 |
| 1.3 | Adição das fábricas de contudo | Larissa Stéfane | 23/05/2025 |
| 1.4 | Adição das outras classes dos usuários| Larissa Stéfane | 23/05/2025 |
| 1.5 | Adição das fábricas de Usuários | Larissa Stéfane | 23/05/2025 |

