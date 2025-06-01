# Padrão Criacional Singleton

## Sumário

- [Introdução](#Introducao)
- [Objetivo](#Objetivo)
- [Metodologia](#Metodologia)
- [Desenvolvimento e Implementação](#Desenvolvimento-e-Implementação)
- [Modelagem do Singleton para o Fórum](#Modelagem-do-Singleton-para-o-Fórum)
    - [Implementação a Classe Forum](#Implementação-a-Classe-Forum.java)
    - [Classe Auxiliar Subforum](#Classe-Auxiliar-Subforum)
- [Classe de Teste AplicacaoGalaxia](#Classe-de-Teste-AplicacaoGalaxia)
- [Discussão Vantagens e Desvantagens do Singleton](#Discussão-Vantagens-e-Desvantagens-do-Singleton)
- [Conclusão](#Conclusão)
- [Referências](#Referências)
- [Histórico de Versão](#Histórico-de-Versão)

## Introdução

Como explicado em [Singleton](https://refactoring.guru/pt-br/design-patterns/singleton), o padrão de projeto Singleton é uma solução criacional utilizada para garantir que uma determinada classe possua apenas uma instância ao longo da execução de um programa. Com isso, ele oferece um ponto de acesso global e controlado a essa instância, o que o torna especialmente útil para gerenciar recursos compartilhados, como conexões com banco de dados, arquivos ou componentes centrais do sistema. 

No contexto do projeto Galáxia Conectada, o padrão Singleton foi aplicado à classe Forum, responsável por centralizar as interações entre os usuários. Assim, essa decisão arquitetural foi tomada para assegurar que haja apenas um fórum global no sistema e evitar a criação acidental de múltiplos fóruns e facilitar o gerenciamento das discussões. 

## Objetivo

Os principais objetivos ao aplicar o padrão Singleton à classe `Forum` são:
* **Garantir Instância Única:** Assegurar que apenas um objeto `Forum` seja criado e utilizado em todo o ciclo de vida da aplicação.
* **Ponto de Acesso Global:** Fornecer um método bem definido e acessível globalmente (`getInstance()`) para que outras partes do sistema possam obter a referência à instância única do `Forum` sem a necessidade de passá-la como parâmetro por múltiplas camadas.
* **Controle sobre a Instanciação:** Centralizar o controle da criação da instância do `Forum` dentro da própria classe e evitar instanciações acidentais ou múltiplas.


## Metodologia

O padrão de projeto criacional **Singleton** foi selecionado para a classe `Forum` devido à necessidade de que exista apenas uma única instância do fórum principal. Assim, como foi descrito em [Padrão de design Singleton: Implementação e Exemplos de Uso](https://elemarjr.com/clube-de-estudos/artigos/padrao-de-design-singleton-implementacao-e-exemplos-de-uso/), esta abordagem garante um ponto de acesso global e controlado. 

A implementação do padrão Singleton para a classe `Forum` será realizada em Java, utilizando o Visual Studio Code (VSCode) como ambiente de desenvolvimento integrado, com o apoio das suas ferramentas e extensões para desenvolvimento Java. O processo de desenvolvimento seguirá as práticas padrão de codificação e organização em pacotes, conforme detalhado nas seções subsequentes.

**A concepção da classe `Forum` será guiada pela análise dos seguintes artefatos de modelagem previamente desenvolvidos:**

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses) - Este diagrama estabeleceu a classe `Forum` como uma entidade central e definiu seus atributos e métodos iniciais, além de seus relacionamentos com outras classes como `Subforum` e `Usuario`.
* **Diagrama de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes) - A análise deste diagrama ajudou a situar o `Forum` dentro de um componente de serviço de backend apropriado (ex: "Subsistema Comunidade"), reforçando a ideia de um serviço centralizado.
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes) - Orientou a decisão de localizar a classe `Forum` e suas classes relacionadas (como `Subforum`) dentro de um pacote específico e coeso (ex: `com.galaxiaconectada.domain.forum`).
* **Diagrama de Casos de Uso:** [Diagrama de Casos de Uso - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaCasosUso) - A análise dos casos de uso que envolvem interação com o fórum (ex: "Criar Tópico", "Visualizar Subfóruns") evidenciou que os usuários sempre interagem com "o" fórum da plataforma, e não com múltiplas instâncias de fóruns diferentes, justificando a abordagem de instância única.

**O desenvolvimento e implementação da classe `Forum` como um Singleton seguiram os seguintes passos:**

1.  **Identificação da Necessidade de Unicidade:** Foi constatado, a partir da análise dos requisitos funcionais e do Diagrama de Casos de Uso, que a plataforma "Galáxia Conectada" deveria possuir um único Fórum Principal. Este fórum centraliza todas as discussões e subfóruns, e a existência de múltiplas instâncias seria conceitualmente incorreta e logisticamente problemática.
2.  **Escolha do Padrão Singleton:** Diante da exigência de uma única instância globalmente acessível, o padrão de projeto criacional Singleton foi escolhido como a solução de design mais direta e apropriada.
3.  **Definição da Estrutura da Classe `Forum`:**  Criação do arquivo `Forum.java`.
4.  **Implementação dos Elementos Característicos do Singleto**
5.  **Definição dos Métodos de Negócio do Fórum**
6.  **Integração e Teste na Aplicação Cliente (`AplicacaoGalaxia.java`):**


**Principais Componentes e Características da Implementação do Singleton:**

* **Construtor Privado:** Impede que a classe seja instanciada diretamente de fora dela mesma com o operador `new`.
* **Instância Estática Privada:** A classe mantém uma referência estática à sua própria instância única. Como a que se encontra abaixo:


    ```java
    private static Forum instancia;
    ```
* **Método Estático Público `getInstance()`:** Este método é o único ponto de acesso para obter a instância da classe. Ele verifica se a instância já foi criada; se não, ele a cria e a armazena na variável estática. Se já existe, ele simplesmente a retorna. Para garantir segurança em ambientes com múltiplas threads (concorrência), este método pode ser sincronizado.
    ```java
    public static synchronized Forum getInstance() {
        if (instancia == null) {
            instancia = new Forum(...); // Criação na primeira chamada
        }
        return instancia;
    }
    ```

No contexto do "Galáxia Conectada", a classe `Forum` deve encapsular seus dados (como nome, descrição e a lista de `Subforum`s) e a lógica para gerenciá-los, enquanto o padrão Singleton controla sua criação e acesso.


## Desenvolvimento e Implementação

A seguir, são detalhadas a modelagem e a implementação da classe `Forum` como um Singleton e sua interação com outras partes do sistema.


## Modelagem do Singleton para o Fórum

Abaixo o espaço para o seu diagrama UML para o Singleton do `Forum`:
<div align="center">
    Figura 1 (Singleton): Modelagem UML do Padrão Singleton para a Classe Forum
    <br>
    <img src="" alt="Modelagem UML do Singleton para Forum" width="700">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

## Implementação a Classe Forum

A classe `Forum` foi implementada no pacote `com.galaxiaconectada.domain.forum` para representar o fórum principal da plataforma. Ela contém um construtor privado para impedir a instanciação externa, um atributo estático privado para armazenar sua única instância, e um método estático público `getInstance()` que controla o acesso a essa instância, criando-a apenas na primeira chamada. A classe também gerencia uma lista de `Subforum`s e fornece métodos para interagir com eles.

Abaixo o código para `Forum.java`:

<details>
  <summary><strong>Código para `Forum.java`:</strong></summary>

```java
package com.galaxiaconectada.domain.forum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger; // Para gerar IDs de subforum simples

// Representa o Fórum Principal da plataforma.

public class Forum {

    private static Forum instancia;  // Atributo estático privado para guardar a ÚNICA instância da classe
    private final int id; 
    private String nome;
    private String descricao;
    private List<Subforum> subforums;
    private AtomicInteger proximoSubforumId = new AtomicInteger(1); // Para gerar IDs simples para subforums

    // Construtor PRIVADO: impede a criação de instâncias com 'new Forum()' de fora da classe.
    private Forum(int id, String nomePadrao, String descricaoPadrao) {
        this.id = id;
        this.nome = nomePadrao;
        this.descricao = descricaoPadrao;
        this.subforums = new ArrayList<>();
        System.out.println("🌟 Instância ÚNICA do Fórum Principal '" + nome + "' criada! (ID: " + id + ") 🌟");
    }

    public static synchronized Forum getInstance() {
        if (instancia == null) {
            instancia = new Forum(1, "Fórum Central da Galáxia Conectada", "O ponto de encontro para todas as discussões intergalácticas!");
        }
        return instancia;
    }

    public List<Subforum> listarSubforums() {
        System.out.println("[Classe do Forum] Listando " + subforums.size() + " subfórum(ns)...");
        return new ArrayList<>(subforums); // Retorna uma cópia para proteger a lista interna
    }

    public Subforum criarSubforum(String nome, String descricao) {
        // Gera um ID simples para o novo subfórum
        int novoId = proximoSubforumId.getAndIncrement();
        Subforum novoSubforum = new Subforum(novoId, nome, descricao);
        this.subforums.add(novoSubforum);
        System.out.println("[Forum] Subfórum '" + nome + "' (ID: " + novoId + ") criado e adicionado ao fórum.");
        return novoSubforum;
    }

    // Getters para os atributos do Fórum
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void exibirDetalhes() {
        System.out.println("\n--- Detalhes do Fórum (Singleton) ---");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        if (subforums.isEmpty()) {
            System.out.println("Subfóruns: Nenhum subfórum criado ainda.");
        } else {
            System.out.println("Subfóruns (" + subforums.size() + "):");
            for (Subforum sf : subforums) {
                System.out.println("  - " + sf.getNome() + " (ID: " + sf.getId() + ")");
            }
        }
        System.out.println("------------------------------------");
    }
}
```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

As figuras 2 e 3 abaixo ilustra a estrutura da classe `Forum.java` no ambiente de desenvolvimento VSCode.


<div align="center">
    Figura 2: Classe Forum.java implementando Singleton
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


<div align="center">
    Figura 3: Classe Forum.java implementando Singleton
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Auxiliar Subforum

Para que a classe Forum pudesse gerenciar seus subfóruns, uma classe Subforum foi definida. Esta classe representa uma seção temática dentro do fórum principal e possui atributos como ID, nome e descrição. A instância de Forum mantém uma lista desses objetos e pode criar novos Subforums. 

**Observação:** Embora a implementação completa de Subforum e suas interações não sejam o foco deste documento sobre Singleton, sua existência é necessária para a funcionalidade da classe Forum.

Abaixo o código para Subforum.java:

<details>
  <summary><strong>Código para Subforum.java</strong></summary>

```java

package com.galaxiaconectada.domain.forum;

// import java.util.List; // Para futuros tópicos
// import java.util.ArrayList; // Para futuros tópicos

// Representa um Subforum dentro do Forum principal.
public class Subforum {
    private int id;
    private String nome;
    private String descricao;
    private int ordemExibicao; 
    
    // Construtor
    public Subforum(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ordemExibicao = 0; // Valor padrão
        System.out.println("[Subforum Criado] ID: " + id + ", Nome: " + nome); // Opcional
    }

    // Construtor
    public Subforum(int id, String nome, String descricao, int ordemExibicao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ordemExibicao = ordemExibicao;
    }

    // Getters e Setters 
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdemExibicao() {
        return ordemExibicao;
    }

    public void setOrdemExibicao(int ordemExibicao) {
        this.ordemExibicao = ordemExibicao;
    }

    public void exibirDetalhes() {
        System.out.println("  Subforum ID: " + id + " | Nome: " + nome + " | Ordem: " + ordemExibicao);
        System.out.println("    Descrição: " + descricao);
    }
}
```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 4 abaixo ilustra a estrutura da classe `Subforum.java` no ambiente de desenvolvimento VSCode.


<div align="center">
    Figura 4: Classe Auxiliar Subforum.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe de Teste AplicacaoGalaxia

A classe AplicacaoGalaxia.java foi atualizada para incluir uma opção de menu que permite interagir com o Forum. Ao selecionar esta opção, a aplicação obtém a instância do Forum através do método estático Forum.getInstance(). Para demonstrar a unicidade da instância, o método é chamado múltiplas vezes, e o código hash do objeto retornado é comparado, confirmando que se trata sempre do mesmo objeto. 

Após a criação do fórum, o usuário pode então interagir com o fórum, como listar e criar novos Subforums, todas as operações sendo realizadas na única instância do Forum.

Abaixo o código relevante da classe AplicacaoGalaxia.java que demonstra o uso do Singleton Forum:

<details>
  <summary><strong>Código da AplicacaoGalaxia.java</strong></summary>

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
import com.galaxiaconectada.prototipos.RegistroDePrototipos;
import com.galaxiaconectada.trilhas.Modulo;
import com.galaxiaconectada.trilhas.ModuloBuilder;
import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.trilhas.TrilhaEducacionalBuilder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// import java.time.format.DateTimeFormatter; // Não usado diretamente aqui, mas nas classes de exibição

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
                case 1:
                    gerenciarPublicacaoDeConteudo();
                    break;
                case 2:
                    gerenciarUsuariosEPapeis();
                    break;
                case 3:
                    gerenciarCriacaoDeTrilha();
                    break;
                case 4:
                    gerenciarClonagemDePrototipos();
                    break;
                case 5: // OPÇÃO PARA O FÓRUM
                    gerenciarForumSingleton();
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

    public static void carregarPrototiposIniciais() {
        System.out.println("\n[SISTEMA] Carregando protótipos iniciais no registro...");
        // Assumindo que Conquista e Notificacao estão no pacote com.galaxiaconectada.prototipos
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
        System.out.println("O que você gostaria de fazer?");
        System.out.println("1. Gerenciar Publicação de Conteúdo");
        System.out.println("2. Gerenciar Usuários e Papéis");
        System.out.println("3. Criar Nova Trilha Educacional");
        System.out.println("4. Testar Padrão Prototype (Clonagem)");
        System.out.println("5. Acessar Fórum Principal (Singleton)"); // OPÇÃO DO FÓRUM
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
        fabricaDeConteudoAtual.iniciarPublicacaoDeConteudo(id, titulo, descricao, visibilidadeSel, detalhes);
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

    // ---- SEÇÃO DE GERENCIAMENTO DE USUÁRIOS E PAPÉIS ----
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

    // ---- SEÇÃO PARA CRIAR TRILHAS EDUCACIONAIS (Builder) ----
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
                Conteudo novoConteudo = criarConteudoInterativoParaModulo();
                if (novoConteudo != null) {
                    moduloBuilder.adicionarConteudo(novoConteudo);
                    System.out.println("  [BUILDER MÓDULO] Conteúdo '" + novoConteudo.getTitulo() + "' (Tipo: " + novoConteudo.getClass().getSimpleName() + ") adicionado.");
                }
            }
            Modulo moduloConstruido = moduloBuilder.build();
            trilhaBuilder.adicionarModulo(moduloConstruido);
            System.out.println("[BUILDER TRILHA] Módulo '" + moduloConstruido.getTitulo() + "' adicionado à trilha.");
        }
        System.out.println("\n[BUILDER TRILHA] Construindo Trilha Educacional...");
        TrilhaEducacional trilhaFinal = trilhaBuilder.build();
        trilhasCriadas.add(trilhaFinal);
        System.out.println("\n🎉 Trilha Educacional '" + trilhaFinal.getTitulo() + "' criada com sucesso! 🎉");
        trilhaFinal.exibirDetalhesCompletos();
        System.out.println("===================================================");
    }

    public static Conteudo criarConteudoInterativoParaModulo() {
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

    // ---- NOVA SEÇÃO PARA GERENCIAR O FÓRUM (Singleton) ----
    public static void gerenciarForumSingleton() {
        System.out.println("\n========= ACESSANDO O FÓRUM PRINCIPAL (Singleton) =========");
        Forum forumPrincipal = Forum.getInstance();
        System.out.println("[INFO] Instância do Fórum obtida. HashCode da instância: " + forumPrincipal.hashCode());
        System.out.println("   ↳ Explicação: Não importa quantas vezes chamarmos Forum.getInstance(), sempre recebe o MESMO objeto Forum.");

        Forum outraReferenciaForum = Forum.getInstance();
        System.out.println("[INFO] Segunda referência ao Fórum obtida. HashCode: " + outraReferenciaForum.hashCode());
        if (forumPrincipal == outraReferenciaForum) {
            System.out.println("   ↳ Confirmado: As duas referências apontam para o MESMO objeto na memória!");
        }

        boolean continuarNoMenuForum = true;
        while (continuarNoMenuForum) {
            System.out.println("\n--- Menu do Fórum: " + forumPrincipal.getNome() + " ---");
            forumPrincipal.exibirDetalhes();

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

} // Fim da classe AplicacaoGalaxia

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

</details>

## Discussão Vantagens e Desvantagens do Singleton


A escolha de utilizar o padrão Singleton para a classe Forum foi ponderada, considerando seus benefícios e também as críticas frequentemente associadas a este padrão.

**Vantagens Observadas:**

- **Instância Única Garantida:** O padrão assegura de forma robusta que apenas uma instância do Forum principal exista, o que está alinhado com o requisito do sistema de ter um único fórum central.
- **Ponto de Acesso Global Controlado:** O método Forum.getInstance() oferece um meio padronizado e global para acessar o fórum, sem a necessidade de passar a referência do objeto Forum por múltiplas camadas da aplicação.
**Inicialização Sob Demanda:** A instância do Forum só é criada na primeira vez que getInstance() é chamado.

**Desvantagens e Considerações (Críticas ao Singleton):**

É importante reconhecer as críticas comuns ao padrão Singleton, que foram consideradas:

- **Estado Global:** O Singleton pode introduzir um estado global, o que pode dificultar o rastreamento de dependências e o raciocínio sobre o comportamento do sistema.
- **Acoplamento:** Classes que utilizam o Singleton diretamente através de Forum.getInstance() podem se tornar fortemente acopladas à classe Forum o que dificulta a substituição ou a modificação do Singleton sem impactá-los.
- **Testabilidade:** Testar unitariamente classes que dependem de um Singleton global pode ser mais desafiador.


**Observação:** No contexto deste projeto acadêmico e para a entidade Forum que é conceitualmente única, os benefícios de garantir a unicidade e ter um ponto de acesso claro foram considerados preponderantes. 

## Conclusão

A implementação da classe Forum utilizando o padrão Singleton atendeu ao requisito de garantir uma única instância para o fórum principal da plataforma e fornecer um ponto de acesso global e controlado a ele. 

## Referências

[1] ELEMAR JR. Padrão de design Singleton: Implementação e Exemplos de Uso. Clube de Estudos, [s.d.]. Disponível em: https://elemarjr.com/clube-de-estudos/artigos/padrao-de-design-singleton-implementacao-e-exemplos-de-uso/. Acesso em: 26 maio 2025.

[2] DEVMEDIA. Padrão de Projeto Singleton em Java. DevMedia, [s.d.]. Disponível em: https://www.devmedia.com.br/padrao-de-projeto-singleton-em-java/26392. Acesso em: 27 maio 2025.

[3] REFACTORING GURU. Singleton. Refactoring.Guru, [s.d.]. Disponível em: https://refactoring.guru/pt-br/design-patterns/singleton. Acesso em: 26 maio 2025.

[4] THIENGO, Vinícius. Padrão de Projeto: Singleton. Thiengo, [s.d.]. Disponível em: https://www.thiengo.com.br/padrao-de-projeto-singleton. Acesso em: 27 maio 2025.


## Histórico de Versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 26/05/2025 |
| 1.1 | Complementação da Metodologia | Larissa Stéfane | 26/05/2025 |
| 1.2 | Elaboração e adição dos códigos | Larissa Stéfane | 27/05/2025 |
| 1.3 | Adição dos subfórum | Larissa Stéfane | 27/05/2025 |
| 1.4 | Adição das imagens | Larissa Stéfane | 28/05/2025 |
| 1.5 | Reorganização | Larissa Stéfane | 28/05/2025 |
| 1.6 | Adição da conclusão | Larissa Stéfane | 28/05/2025 |
