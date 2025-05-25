# Padrão Criacional Prototype


## Sumário

- [Introdução](#introdução)
- [Objetivo](#objetivo)
- [Metodologia](#metodologia)
- [Desenvolvimento e Implementação](#desenvolvimento-e-implementação)
- [Modelagem do Prototype Para Notificações](#Modelagem-do-Prototype-Para-Notificações)
- [Modelagem do Prototype Para Conquistas](#Modelagem-do-Prototype-Para-Conquistas)
- [Definição da Interface de Clonagem](#Definição-da-Interface-de-Clonagem)
  - [Interface PrototipoClonavel](#Interface-PrototipoClonavel)
- [Implementação dos Protótipos Concretos](#Implementação-dos-Protótipos-Concretos)
  - [Classe Conquista como Protótipo](#Classe-Conquista-como-Protótipo)
  - [Classe Notificacao como Protótipo](#Classe-Notificacao-como-Protótipo)
- [Gerenciamento de Protótipos com RegistroDePrototipos](#Gerenciamento-de-Protótipos-com-RegistroDePrototipos)
- [Classe RegistroDePrototipos](#Classe-RegistroDePrototipos)
- [Classe de Teste AplicacaoGalaxia](#Classe-de-Teste-AplicacaoGalaxia)
- [Conclusão](#conclusão)
- [Bibliografia](#bibliografia)
- [Histórico de Versão](#histórico-de-versão)



## Introdução

O padrão de projeto **Prototype** (ou Protótipo) é um padrão criacional que, conforme elucidado por fontes como [Prototype](https://refactoring.guru/pt-br/design-patterns/prototype), permite a criação de novos objetos através da cópia de instâncias existentes, denominadas protótipos. Com isso, em vez de construir um objeto do zero, o que pode ser custoso ou complexo, o padrão Prototype delega o processo de instanciação ao próprio objeto protótipo. Isso é vantajoso quando o sistema precisa de múltiplas variações de objetos que compartilham uma estrutura e estado base, ou quando as classes a serem instanciadas são definidas em tempo de execução.

No contexto do projeto "Galáxia Conectada", o padrão Prototype foi aplicado estrategicamente na criação de objetos das classes **`Conquista`** e **`Notificacao`**. A escolha se justifica pela necessidade de ter um conjunto de conquistas e modelos de notificação padrão que podem ser rapidamente duplicados e personalizados para usuários ou situações específicas. Por exemplo, uma conquista padrão como "Primeira Trilha Concluída" pode ser clonada e associada a um usuário, ou um modelo de notificação de "Boas-Vindas" pode ser clonado e ter seu texto particularizado. Esta abordagem visa otimizar a criação desses objetos, garantir consistência e reduzir a complexidade de configuração repetitiva.

## Objetivo


O principal objetivo da aplicação do padrão Prototype no projeto "Galáxia Conectada" é fornecer um mecanismo eficiente e flexível para a criação de novas instâncias de objetos `Conquista` e `Notificacao`. Busca-se com isso:
* Reduzir o acoplamento ao permitir que o sistema crie novos objetos sem conhecer suas classes concretas em tempo de compilação (apenas o protótipo).
* Melhorar a performance em cenários onde a instanciação direta é custosa.
* Facilitar a gestão de "modelos" ou "templates" de conquistas e notificações que podem ser rapidamente duplicados e adaptados.
* Manter a consistência na criação de objetos que compartilham uma base comum de atributos.


## Metodologia

O padrão **Prototype** especifica os tipos de objetos a criar usando uma instância prototípica e cria novos objetos copiando (clonando) este protótipo. Com isso, a ideia central é ter um objeto "molde" e, em vez de instanciar um novo objeto com `new` e configurar todos os seus atributos, solicita-se ao molde que ele crie uma cópia de si mesmo.

**Componentes do Padrão Aplicado:**

* **Prototype (Protótipo Abstrato/Interface):** Define a interface para clonagem.
* **ConcretePrototype (Protótipo Concreto):** Implementa a operação de clonagem. Assim, as classes `Conquista` e `Notificacao` atuam como Protótipos Concretos ao implementar o método `clonar()`.
* **Client (Cliente):** Cria um novo objeto ao pedir a um protótipo para se clonar.
* **Registry (Registro de Protótipos - Opcional, mas usado):** A classe `RegistroDePrototipos` gerencia um conjunto de protótipos pré-configurados, o que facilita o acesso e a clonagem por meio de uma chave identificadora.

**Observação:** A clonagem em Java é tipicamente realizada ao sobreescrever o método `clone()` da classe `Object` e implementando a interface `Cloneable`.

**A concepção das classes de produto (`Conquista`, `Notificacao`) e suas inter-relações foi guiada pelos seguintes artefatos do projeto:**

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).
* **Diagrama de Classes de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes).
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes).

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).
  
* **Diagrama de Casos de Uso:** [Diagrama de Casos de Uso - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaCasosUso).

**Passo a passo de desenvolvimento para o padrão Prototype no projeto "Galáxia Conectada":**

1.  Definição da Interface de Clonagem que é a criação da interface `PrototipoClonavel`.
2.  Implementação das Classes "Protótipo Concreto.
3.  Criação de um Gerenciador de Protótipos: Desenvolvimento da classe `RegistroDePrototipos` para armazenar, gerenciar e fornecer acesso facilitado aos objetos protótipo através de chaves textuais.
4.  Carregamento de Instâncias Protótipo na classe `AplicacaoGalaxia`.


## Desenvolvimento e Implementação

A seguir, serão detalhadas as modelagens e as implementações das classes envolvidas na aplicação do padrão Prototype.


## Modelagem do Prototype Para Notificações

Abaixo está o diagrama UML para o Prototype de Notificações:

<div align="center">
    Figura 1: Modelagem UML do Padrão Prototype para Notificações
    <br>
    <img src="" width="900">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

## Modelagem do Prototype Para Conquistas

Similarmente à seção anterior, esta parte deve apresentar um diagrama UML focado na aplicação do padrão Prototype à classe `Conquista`.

Abaixo o espaço para o seu diagrama UML para o Prototype de Conquistas:
<div align="center">
    Figura 2: Modelagem UML do Padrão Prototype para Conquistas
    <br>
    <img src="" width="900">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


## Definição da Interface de Clonagem

Para padronizar a operação de clonagem dos protótipos foi definida uma interface simples, apresentada como `PrototipoClonavel`

### Interface PrototipoClonavel

A interface `PrototipoClonavel` estabelece o contrato que todas as classes protótipo devem seguir ao definir um método `clonar()`. Além disso, embora o Java forneça a interface marcadora `Cloneable` e o método `Object.clone()`, esta interface visa tornar o contrato de clonagem mais claro com a função. 

**Observação Importante:** As classes que implementam `PrototipoClonavel` também devem implementar `java.lang.Cloneable` para utilizar `super.clone()` de forma eficaz.

Abaixo o código para `PrototipoClonavel.java`

```java
package com.galaxiaconectada.prototipos;

  // Define uma interface para objetos que podem ser clonados.
  public interface PrototipoClonavel {
      
      Object clonar(); 
  }

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 3 abaixo ilustra a estrutura da classe `PrototipoClonavel.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: Interface PrototipoClonavel.java
    <br>
    <img src="" width="900">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


## Implementação dos Protótipos Concretos

As classes Conquista e Notificacao foram adaptadas para atuar como protótipos concretos.

### Classe Conquista como Protótipo

A classe Conquista representa um prêmio ou reconhecimento dentro da plataforma. Ao implementar PrototipoClonavel e Cloneable, ela pode servir como um molde para criar novas instâncias de conquistas. Isso é particularmente útil para definir um conjunto padrão de conquistas no sistema que podem ser clonadas quando um usuário as alcança. 

**Observação:** O método clonar() utiliza super.clone() para realizar uma cópia superficial, que é suficiente para seus atributos.

Abaixo o código para `Conquista.java`


```Java
package com.galaxiaconectada.prototipos;

  import com.galaxiaconectada.prototipos.PrototipoClonavel;
  import com.galaxiaconectada.domain.Usuario; 

  // Representa uma conquista (prêmio, medalha, badge) que um usuário pode ganhar.
  public class Conquista implements PrototipoClonavel, Cloneable { // Implementa as duas

      private int id;
      private String titulo;
      private String descricao;
      private String iconeUrl;
      private int pontosXPConcedidos;

      public Conquista(int id, String titulo, String descricao, String iconeUrl, int pontosXPConcedidos) {
          this.id = id;
          this.titulo = titulo;
          this.descricao = descricao;
          this.iconeUrl = iconeUrl;
          this.pontosXPConcedidos = pontosXPConcedidos;
      }

      // Getters
      public int getId() { return id; }
      public String getTitulo() { return titulo; }
      public String getDescricao() { return descricao; }
      public String getIconeUrl() { return iconeUrl; }
      public int getPontosXPConcedidos() { return pontosXPConcedidos; }

      public void setId(int id) { this.id = id; } 
      public void setTitulo(String titulo) { this.titulo = titulo; }
      public void setDescricao(String descricao) { this.descricao = descricao; }
      public void setIconeUrl(String iconeUrl) { this.iconeUrl = iconeUrl; }
      public void setPontosXPConcedidos(int pontosXPConcedidos) { this.pontosXPConcedidos = pontosXPConcedidos; }


      public boolean desbloquearPara(/*Usuario u*/) { 
          System.out.println("Conquista '" + titulo + "' desbloqueada para o usuário!");
          // Lógica para criar uma UsuarioConquista.
          return true;
      }

      @Override
      public Conquista clonar() { // Retorna o tipo específico Conquista
          System.out.println("Clonando Conquista: " + this.titulo);
          try {
              // Chama o clone() da classe Object, que faz a cópia superficial
              return (Conquista) super.clone();
          } catch (CloneNotSupportedException e) {
              System.err.println("A clonagem da Conquista falhou: " + e.getMessage());
              return null; 
          }
      }

      public void exibirDetalhes() {
          System.out.println("--- Detalhes da Conquista (ID: " + id + ") ---");
          System.out.println("Título: " + titulo);
          System.out.println("Descrição: " + descricao);
          System.out.println("Ícone: " + iconeUrl);
          System.out.println("XP Concedido: " + pontosXPConcedidos);
          System.out.println("------------------------------------");
      }
  }

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 4 abaixo ilustra a estrutura da classe `Conquista.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 4:  Classe Conquista.java como Protótipo
    <br>
    <img src="" width="900">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


### Classe Notificacao como Protótipo

A classe Notificacao é responsável por representar mensagens do sistema para os usuários. Assim, ao aplicar o padrão Prototype, instâncias de Notificacao podem ser clonadas para criar novas notificações baseadas em modelos pré-definidos (ex: notificação de boas-vindas, notificação de nova mensagem). O método clonar() também utiliza super.clone(). 

Abaixo o código para `Notificacao.java` 

```Java
package com.galaxiaconectada.domain.comunicacao;

  import com.galaxiaconectada.prototipos.PrototipoClonavel;
  import java.time.LocalDateTime;
  import java.time.format.DateTimeFormatter;

  // Representa uma notificação do sistema para o usuário.
  
  public class Notificacao implements PrototipoClonavel, Cloneable {
      private int id; // Gerado ou definido após clonagem para uma nova notificação
      private String mensagem;
      private String tipo; // Ex: "NOVA_MENSAGEM", "CONQUISTA", "AVISO"
      private LocalDateTime dataEnvio;
      private boolean lida;
      private String link; // Link para onde a notificação direciona

      public Notificacao(int id, String tipo, String mensagemBase, String linkBase) {
          this.id = id;
          this.tipo = tipo;
          this.mensagem = mensagemBase;
          this.link = linkBase;
          this.dataEnvio = LocalDateTime.now();
          this.lida = false;
      }

      // Getters
      public int getId() { return id; }
      public String getMensagem() { return mensagem; }
      public String getTipo() { return tipo; }
      public LocalDateTime getDataEnvio() { return dataEnvio; }
      public boolean isLida() { return lida; }
      public String getLink() { return link; }

      // Setters para personalizar o clone
      public void setId(int id) { this.id = id; }
      public void setMensagem(String mensagem) { this.mensagem = mensagem; }
      public void setTipo(String tipo) { this.tipo = tipo; }
      public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
      public void setLink(String link) { this.link = link; }

      public void marcarComoLida() {
          this.lida = true;
          System.out.println("Notificação (ID: " + id + ") marcada como lida.");
      }

      @Override
      public Notificacao clonar() { // Retorna o tipo específico Notificacao
          System.out.println("Clonando Notificação tipo: " + this.tipo);
          try {
              Notificacao clone = (Notificacao) super.clone();
              return clone;
          } catch (CloneNotSupportedException e) {
              System.err.println("A clonagem da Notificação falhou: " + e.getMessage());
              return null;
          }
      }

      public void exibir() {
          DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
          System.out.println("--- Notificação (ID: " + id + ") ---");
          System.out.println("Tipo: " + tipo);
          System.out.println("Mensagem: " + mensagem);
          System.out.println("Link: " + link);
          System.out.println("Data Envio: " + (dataEnvio != null ? dataEnvio.format(formatador) : "N/A"));
          System.out.println("Lida: " + (lida ? "Sim" : "Não"));
          System.out.println("-----------------------------");
      }
  }

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 5 abaixo ilustra a estrutura da classe `Notificacao.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 5: Classe Notificacao.java como Protótipo
    <br>
    <img src="" width="900">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


## Gerenciamento de Protótipos com RegistroDePrototipos

Para facilitar o acesso e a clonagem dos objetos protótipo, foi implementada uma classe de registro.

## Classe RegistroDePrototipos

A classe RegistroDePrototipos atua como um gerenciador centralizado para os objetos protótipo (Conquista, Notificacao). Seu objetivo é armazenar instâncias pré-configuradas desses protótipos, associadas a uma chave textual única.

**Funcionamento:**  O cliente pode então solicitar um clone de um protótipo específico fornecendo sua chave, sem precisar conhecer a classe concreta do protótipo ou como ele é clonado internamente. 

Abaixo o código para `RegistroDePrototipos.java` 

```Java

package com.galaxiaconectada.prototipos;

  import java.util.HashMap;
  import java.util.Map;

  /**
   * Gerencia um conjunto de instâncias de protótipos que podem ser clonados.
   * Funciona como um registro central para acessar e clonar objetos modelo.
   */
  public class RegistroDePrototipos {

      // Um Map para armazenar os protótipos. A chave é uma String (um nome para o protótipo)
      private Map<String, PrototipoClonavel> prototiposRegistrados = new HashMap<>();

      public void adicionarPrototipo(String chave, PrototipoClonavel prototipo) {
          if (chave != null && !chave.isEmpty() && prototipo != null) {
              prototiposRegistrados.put(chave.toUpperCase(), prototipo); // Guarda a chave em maiúsculas por padrão
              System.out.println("[REGISTRO] Prototipo adicionado com a chave: " + chave.toUpperCase());
          } else {
              System.out.println("[REGISTRO ERRO] Chave ou protótipo inválido para adicionar.");
          }
      }

      public PrototipoClonavel getPrototipoClonado(String chave) {
          if (chave == null || chave.isEmpty()) {
              System.out.println("[REGISTRO ERRO] Chave inválida para buscar protótipo.");
              return null;
          }

          PrototipoClonavel prototipoOriginal = prototiposRegistrados.get(chave.toUpperCase());

          if (prototipoOriginal != null) {
              System.out.println("[REGISTRO] Clonando protótipo para a chave: " + chave.toUpperCase());
              // Chama o método clonar() do protótipo específico
              return (PrototipoClonavel) prototipoOriginal.clonar();
          } else {
              System.out.println("[REGISTRO ERRO] Nenhum protótipo encontrado para a chave: " + chave.toUpperCase());
              return null;
          }
      }

      /**
       * Mostra as chaves de todos os protótipos registrados.
       * Útil para o usuário saber quais protótipos estão disponíveis.
       */
      public void listarPrototiposDisponiveis() {
          if (prototiposRegistrados.isEmpty()) {
              System.out.println("[REGISTRO] Nenhum protótipo registrado no momento.");
              return;
          }
          System.out.println("\n--- Protótipos Disponíveis para Clonagem ---");
          for (String chave : prototiposRegistrados.keySet()) {
              PrototipoClonavel p = prototiposRegistrados.get(chave);
              System.out.println("- Chave: \"" + chave + "\" (Tipo: " + p.getClass().getSimpleName() + ")");
          }
          System.out.println("--------------------------------------------");
      }
  }


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 6 abaixo ilustra a estrutura da classe `Notificacao.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe RegistroDePrototipos.java
    <br>
    <img src="" width="900">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


## Classe de Teste AplicacaoGalaxia

A classe AplicacaoGalaxia.java foi atualizada para incluir uma seção de teste dedicada ao padrão Prototype. No início da aplicação, o método carregarPrototiposIniciais() popula o RegistroDePrototipos com instâncias modelo de Conquista e Notificacao. Em seguida, um novo menu interativo permite ao usuário listar os protótipos disponíveis, escolher um pela sua chave, solicitar um clone e, opcionalmente, modificar atributos do objeto clonado. A exibição dos detalhes do clone antes e depois das modificações demonstra que o objeto clonado é uma instância independente do protótipo original, validando a correta aplicação do padrão.

```Java

package com.galaxiaconectada.main;

// Imports das fábricas de Conteúdo
import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.comunicacao.Notificacao;
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
import com.galaxiaconectada.trilhas.TrilhaEducacionalBuilder;   // Assumindo que Conquista está em prototipos
import java.time.LocalDateTime; // Assumindo que Notificacao está em prototipos
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AplicacaoGalaxia {

    private static FabricaDeConteudo fabricaDeConteudoAtual;
    private static FabricaDePapelUsuario fabricaDePapelAtual;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();
    private static List<TrilhaEducacional> trilhasCriadas = new ArrayList<>();
    private static RegistroDePrototipos registroDePrototipos = new RegistroDePrototipos();

    public static void main(String[] args) {
        System.out.println("### Bem-vindo(a) à Plataforma Interativa Galáxia Conectada ###");
        carregarPrototiposIniciais(); // Carrega os modelos para clonagem
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

        Notificacao nProto1 = new Notificacao(0, "BEM_VINDO", "Bem-vindo(a) à Galáxia Conectada, [NOME_USUARIO]! Sua jornada começa agora.", "/painel");
        registroDePrototipos.adicionarPrototipo("NOTIFICACAO_BEM_VINDO", nProto1);
        Notificacao nProto2 = new Notificacao(0, "NOVA_CONQUISTA_GERAL", "Parabéns, [NOME_USUARIO]! Você desbloqueou: [NOME_CONQUISTA]!", "/perfil/conquistas");
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
            System.out.print("Artigos Revisados: "); detalhesPapel.put("artigosRevisados", scanner.nextInt()); scanner.nextLine();
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

    // ---- NOVA SEÇÃO PARA CRIAR TRILHAS EDUCACIONAIS (Builder) ----
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

    // ---- NOVA SEÇÃO PARA TESTAR PROTOTYPE ----
    public static void gerenciarClonagemDePrototipos() {
        System.out.println("\n========= TESTAR PADRÃO PROTOTYPE (CLONAGEM) =========");
        if (registroDePrototipos == null) { // Embora inicializado estaticamente, boa prática verificar
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
                System.out.println("--> O objeto a seguir é uma CÓPIA INDEPENDENTE que pode ser modificada.");
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
                        n.setDataEnvio(LocalDateTime.now()); // Atualiza data para o momento da modificação/envio
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
} 



```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


## Conclusão

A implementação do padrão Prototype para as classes Conquista e Notificacao no projeto "Galáxia Conectada" ofereceu uma maneira eficiente de criar novas instâncias desses objetos a partir de modelos pré-definidos.

## Bibliografia 

[1] CLIMACO, Tácio. Design Pattern: Prototype. Medium, [s.d.]. Disponível em: https://climaco.medium.com/design-pattern-prototype-8930c565d995. Acesso em: 24 maio 2025.

[2] CODE WITH TECH. Prototype Design Pattern: A Real-World Example. Medium, [s.d.]. Disponível em: https://medium.com/@CodeWithTech/efficient-object-creation-using-the-prototype-pattern-with-real-world-examples-ba87082befba. Acesso em: 24 maio 2025.

[3] DIAS, Diogo Moreira. Padrão Prototype. GitBook, [s.d.]. Disponível em: https://diogomoreira.gitbook.io/padroes-de-projeto/padroes-gof-criacionais/padrao-prototype. Acesso em: 24 maio 2025.

[4] ELEMAR JR. Utilizando o Padrão Prototype para Criação Eficiente de Objetos Complexos. Clube de Estudos, [s.d.]. Disponível em: https://elemarjr.com/clube-de-estudos/artigos/utilizando-o-padrao-prototype-para-criacao-eficiente-de-objetos-complexos/. Acesso em: 24 maio 2025.

[5] PYTHON ACADEMY. Padrões de Projeto em Python (Design Patterns): Prototype. Python Academy, [s.d.]. Disponível em: https://pythonacademy.com.br/blog/padroes-de-projeto-em-python-prototype. Acesso em: 24 maio 2025.

[6] REFACTORING GURU. Prototype: Também conhecido como: Protótipo, Clone. Refactoring.Guru, [s.d.]. Disponível em: https://refactoring.guru/pt-br/design-patterns/prototype. Acesso em: 24 maio 2025.



## Histórico de versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 24/05/2025 |
| 1.1 | Adição da Metodologia | Larissa Stéfane | 24/05/2025 |
| 1.2 | Elaboração dos códigos | Larissa Stéfane | 24/05/2025 |
| 1.3 | Reestruturação dos códigos | Larissa Stéfane | 24/05/2025 |
| 1.4 | Adição das imagens | Larissa Stéfane | 24/05/2025 |
| 1.5 | Reorganização | Larissa Stéfane | 24/05/2025 |
| 1.6 | Adição da conclusão | Larissa Stéfane | 24/05/2025 |
