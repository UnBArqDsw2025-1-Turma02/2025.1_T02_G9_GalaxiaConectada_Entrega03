# Padrão Criacional Builder


## Sumário

- [Introdução](#introdução)
- [Objetivo](#objetivo)
- [Metodologia](#metodologia)
- [Desenvolvimento e Implementação](#desenvolvimento-e-implementação)
- [Modelagem do Builder Para Módulo](#Modelagem-do-Builder-Para-Módulo)
  - [Classe Produto Modulo](#Classe-Produto-Modulo)
  - [Classe Builder ModuloBuilder](#Classe-Builder-ModuloBuilder)
- [Modelagem do Builder Para Trilhas de Aprendizado](#Modelagem-do-Builder-Para-Trilhas-de-Aprendizado)
  -  [Classe Produto TrilhaEducacional](#Classe-Produto-TrilhaEducacional)
  -  [Classe Builder TrilhaEducacionalBuilder](#Classe-Builder-TrilhaEducacionalBuilder)
- [Classe de Teste AplicacaoGalaxia](#Classe-de-Teste-AplicacaoGalaxia)
- [Conclusão](#conclusão)
- [Bibliografia](#bibliografia)
- [Histórico de Versão](#histórico-de-versão)



## Introdução

O padrão de projeto Builder (ou Construtor), como é explicado em [Builder](https://refactoring.guru/pt-br/design-patterns/builder), é uma solução criacional voltada à construção de objetos complexos de forma controlada e passo a passo. Com isso, é útil quando a criação de um objeto envolve múltiplas etapas, configurações variáveis ou combinações de atributos que, se implementadas diretamente em um único construtor, levariam a códigos longos, difíceis de manter e pouco legíveis. Portanto, como também é explicado em [Design Patterns — Parte 6 — Builder](https://medium.com/@jonesroberto/desing-patterns-parte-6-builder-f20752fb0c35), com o Builder, o processo de construção é desacoplado da representação final do objeto e permite criar variações com o mesmo fluxo de construção.

No contexto deste projeto, foi escolhido por aplicar o padrão Builder tanto na criação de **Módulos (agrupamentos de conteúdos elaborados por professores voluntários ou instrutores)** quanto na construção das **Trilhas de Aprendizado (conjuntos de módulos organizados com base em um tema ou objetivo educacional)**. A escolha se deu devido à natureza progressiva e configurável dessas estruturas, que podem conter diferentes quantidades de conteúdo, descrições, critérios de acesso e integrações com outras áreas da plataforma. 

## Objetivo

Ao compreender a função do Builder, ao utilizá-lo para implementar os **conteúdos e as trilhas de aprendizado**, busca-se estruturar a criação desses elementos de forma modular, o que permite combinar diferentes tipos de conteúdos, atividades e níveis de dificuldade conforme as necessidades de cada usuário ou percurso educacional. 

**Principais objetivos do uso do padrão Builder nesse contexto, com base em [Builder](https://refactoring.guru/pt-br/design-patterns/builder) e em [O que é o padrão Builder? Java/Spring Boot](https://www.dio.me/articles/o-que-e-o-padrao-builder-javaspring-boot):**

- Montar trilhas de aprendizado com diferentes combinações de conteúdo.

- Separar a lógica de construção da lógica de representação.

- Facilitar a adição, modificação ou remoção de etapas das trilhas, sem impactar outras partes do sistema.

- Evitar o uso de grandes construtores ou métodos complexos.
  
- Melhorar a manutenção e escalabilidade da plataforma, com foco em flexibilidade e reutilização de componentes.

- Tornar os testes mais simples, ao possibilitar a criação de trilhas com apenas os elementos necessários para cada cenário.

## Metodologia

O padrão **Builder**, como já foi explicado, é um padrão de projeto criacional que separa o processo de construção de um objeto complexo de sua representação final. Isso permite que o mesmo processo de construção possa criar diferentes representações do objeto. Com isso, a metodologia para o seu desenvolvimento se baseou em:

**Principais Componentes do Padrão Builder Aplicado, com base em [Design Patterns — Parte 6 — Builder](https://medium.com/@jonesroberto/desing-patterns-parte-6-builder-f20752fb0c35):**

* **Product (Produto):** O objeto complexo que está sendo construído. No caso, são as classes `Modulo` e `TrilhaEducacional`.
* **ConcreteBuilder (Construtor Concreto):** Implementa a interface do Builder (ou é a classe Builder em si) e mantém o controle da representação do produto que está sendo construído. Ele fornece métodos para construir as partes do produto e um método para retornar o produto finalizado. Exemplos: `ModuloBuilder` e `TrilhaEducacionalBuilder`.
* **Director (Diretor):** Uma classe que controla o algoritmo de construção ao usar a interface do Builder. 


**A concepção das classes de produto (`Modulo`, `TrilhaEducacional`) e suas inter-relações serão guiadas por diagrama previamente elaborados para o projeto:**

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).
* **Diagrama de Classes de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes).
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes).

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).
  
* **Diagrama de Casos de Uso:** [Diagrama de Casos de Uso - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaCasosUso).

* **Diagrama de Atividades:** [Diagrama de Atividades - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemDinamica/DiagramaAtividades).


**Passo a passo de desenvolvimento para o padrão Builder no projeto "Galáxia Conectada":**

1. Identificação e Definição das Classes "Produto";
2. Criação das Classes "Construtoras Concretas" (Builders);
3. Implementação de Métodos de Configuração Fluentes;
4. Desenvolvimento do Método de Construção Final (build());
5. Integração dos Builders na classe AplicacaoGalaxia.java 


## Desenvolvimento e Implementação

A seguir, são apresentadas as classes envolvidas na implementação do padrão Builder para `Modulo` e `TrilhaEducacional`, os quais foram desenvolvidos ao utilizar o o [**Visual Studio Code (VSCode)**](https://code.visualstudio.com/) como IDE principal.


## Modelagem do Builder Para Módulo

A figura 1 abaixo mostra a modelagem do campo Módulo

<div align="center">
    Figura 1: modelagem do campo Módulo
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

## Classe Produto Modulo

A classe `Modulo` é um componente que funciona como um contêiner temático que agrupa e organiza diversos objetos `Conteudo` (como artigos, vídeos, quizzes e jogos) sobre um tema dentro do escopo maior de uma `TrilhaEducacional`. Isso porque, ao segmentar o aprendizado em módulos, facilita-se a progressão do usuário e a organização do material didático.

 Cada `Modulo` é caracterizado por um identificador único (`id`), um `titulo` descritivo, uma `ordem` de apresentação dentro da trilha, uma `descricaoBreve` e, crucialmente, a coleção de `Conteudo`s que o compõem. 

Abaixo o código para `Modulo.java` 

<details>
  <summary><strong>Código para `Modulo.java`</strong></summary>


```java
package com.galaxiaconectada.trilhas;

  import com.galaxiaconectada.core.Conteudo; // Usa a classe Conteudo
  import java.util.List;
  import java.util.ArrayList;

  /**
   * Representa um Módulo educacional dentro de uma Trilha.
   * Um módulo agrupa diversos Conteúdos.
   */
  public class Modulo {
      private int id;
      private String titulo;
      private int ordem; // Ordem de exibição do módulo na trilha
      private String descricaoBreve;
      private List<Conteudo> conteudos; // Lista de conteúdos pertencentes a este módulo

      // Construtor será usado pelo ModuloBuilder
      Modulo(int id, String titulo, int ordem, String descricaoBreve, List<Conteudo> conteudos) {
          this.id = id;
          this.titulo = titulo;
          this.ordem = ordem;
          this.descricaoBreve = descricaoBreve;
          this.conteudos = conteudos != null ? new ArrayList<>(conteudos) : new ArrayList<>();
      }

      // Getters
      public int getId() { return id; }
      public String getTitulo() { return titulo; }
      public int getOrdem() { return ordem; }
      public String getDescricaoBreve() { return descricaoBreve; }
      public List<Conteudo> getConteudos() { return new ArrayList<>(conteudos); } // Retorna cópia

      /**
       * Adiciona um conteúdo a este módulo.
       */
      public void adicionarConteudoInterno(Conteudo conteudo) {
          if (this.conteudos == null) {
              this.conteudos = new ArrayList<>();
          }
          this.conteudos.add(conteudo);
      }


      public void exibirDetalhes() {
          System.out.println("  --- Módulo: " + titulo + " (ID: " + id + ", Ordem: " + ordem + ") ---");
          System.out.println("  Descrição Breve: " + descricaoBreve);
          if (conteudos.isEmpty()) {
              System.out.println("    Este módulo ainda não possui conteúdos.");
          } else {
              System.out.println("    Conteúdos do Módulo:");
              for (Conteudo c : conteudos) {
                  System.out.println("      - " + c.getTitulo() + " (Tipo: " + c.getClass().getSimpleName() + ")");
                  // Poderia chamar c.exibir() se quisesse todos os detalhes aqui
              }
          }
          System.out.println("  ----------------------------------");
      }

      // toString para facilitar a visualização (opcional)
      @Override
      public String toString() {
          return "Modulo [id=" + id + ", titulo=" + titulo + ", ordem=" + ordem + ", conteudos=" + conteudos.size() + "]";
      }
  }

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 2 abaixo ilustra a estrutura da classe `Modulo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 2: Classe Produto Modulo.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c4ce743072a50e4b00f32fe3e68be7ae87c7fe93/docs/PadroesDeProjeto/Imagens/BuilderModulo.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Builder ModuloBuilder

O ModuloBuilder tem como objetivo principal simplificar e tornar mais robusto e legível o processo de criação de instâncias da classe Modulo. 
- Dado que um módulo é definido por vários atributos (ID, título, ordem, descrição) e pode conter uma lista variável de Conteudos, o ModuloBuilder oferece uma interface fluente.

Abaixo o código para `ModuloBuilder.java` 

<details>
  <summary><strong>Código para `ModuloBuilder.java`</strong></summary>


```java
package com.galaxiaconectada.trilhas;

   import com.galaxiaconectada.core.Conteudo; // Para a lista de conteúdos
   import java.util.List;
   import java.util.ArrayList;

   // Builder para a classe Modulo.

   public class ModuloBuilder {
       // Atributos que o Modulo final terá, guardados temporariamente aqui
       private int id;
       private String titulo;
       private int ordem = 0; 
       private String descricaoBreve = ""; // Valor padrão
       private List<Conteudo> conteudos;

       /**
        * Construtor do ModuloBuilder.
        * @param id O ID do módulo.
        * @param titulo O título do módulo.
        */
       public ModuloBuilder(int id, String titulo) {
           this.id = id;
           this.titulo = titulo;
           this.conteudos = new ArrayList<>(); // Inicializa a lista de conteúdos
       }

       //Define a ordem de exibição do módulo.
       
       public ModuloBuilder comOrdem(int ordem) {
           this.ordem = ordem;
           return this; // Retorna a própria instância para chamadas fluentes
       }

       public ModuloBuilder comDescricaoBreve(String descricao) {
           this.descricaoBreve = descricao;
           return this;
       }

       public ModuloBuilder adicionarConteudo(Conteudo conteudo) {
           if (conteudo != null) {
               this.conteudos.add(conteudo);
           }
           return this;
       }

       //Define uma lista inteira de Conteudos para o módulo,
       
       public ModuloBuilder comListaDeConteudos(List<Conteudo> listaConteudos) {
           if (listaConteudos != null) {
               this.conteudos = new ArrayList<>(listaConteudos); // Cria uma nova lista baseada na fornecida
           } else {
               this.conteudos = new ArrayList<>();
           }
           return this;
       }

       public Modulo build() {
           // Validação simples: garante que o título foi fornecido
           if (this.titulo == null || this.titulo.trim().isEmpty()) {
               throw new IllegalStateException("O título do módulo é obrigatório e não pode ser vazio.");
           }
           // Chama o construtor de Modulo
           return new Modulo(this.id, this.titulo, this.ordem, this.descricaoBreve, this.conteudos);
       }
   }

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 3 abaixo ilustra a estrutura da classe `ModuloBuilder.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: Classe ModuloBuilder.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c4ce743072a50e4b00f32fe3e68be7ae87c7fe93/docs/PadroesDeProjeto/Imagens/builderModuloBuilder.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Modelagem do Builder Para Trilhas de Aprendizado

A figura 4 abaixo mostra a modelagem do campo Trilhas de Aprendizado



## Classe Produto TrilhaEducacional

A TrilhaEducacional é a entidade central que organiza e define um percurso de aprendizado completo e estruturado dentro da plataforma "Galáxia Conectada". Dessa maneira, o objetivo principal é guiar o usuário através de uma sequência lógica e progressiva de Modulos, cada um focado em subtemas ou habilidades específicas. 
- Além de agregar a coleção ordenada de Modulos, a TrilhaEducacional armazena metadados cruciais como seu id único, titulo principal, descricao detalhada, nivel de dificuldade (ex: Iniciante, Avançado), categoria temática, status de publicada e uma imagemUrl representativa. 

Abaixo o código para `TrilhaEducacional.java` 

<details>
  <summary><strong>Código para `TrilhaEducacional.java`</strong></summary>

```java
package com.galaxiaconectada.trilhas;

  import java.util.ArrayList;
  import java.util.List;
  // Se precisar, importe Usuario aqui se métodos como inscreverUsuario forem implementados agora
  // import com.galaxiaconectada.domain.Usuario;
  // import com.galaxiaconectada.domain.ProgressoUsuarioTrilha; // Placeholder

  /**
   * Representa uma Trilha Educacional na plataforma.
   * Uma trilha é um conjunto ordenado de Módulos sobre um tema específico.
   */
  public class TrilhaEducacional {
      private int id;
      private String titulo;
      private String descricao;
      private String nivel; // Ex: "Iniciante", "Intermediário", "Avançado"
      private String categoria; // Ex: "Astronomia Básica", "Cosmologia", "Astrofísica"
      private boolean publicada;
      private String imagemUrl;
      private List<Modulo> modulos; // Lista de módulos que compõem a trilha

      // Construtor será usado pelo TrilhaEducacionalBuilder
      TrilhaEducacional(int id, String titulo, String descricao, String nivel,
                          String categoria, boolean publicada, String imagemUrl, List<Modulo> modulos) {
          this.id = id;
          this.titulo = titulo;
          this.descricao = descricao;
          this.nivel = nivel;
          this.categoria = categoria;
          this.publicada = publicada;
          this.imagemUrl = imagemUrl;
          this.modulos = modulos != null ? new ArrayList<>(modulos) : new ArrayList<>();
      }

      // Getters
      public int getId() { return id; }
      public String getTitulo() { return titulo; }
      public String getDescricao() { return descricao; }
      public String getNivel() { return nivel; }
      public String getCategoria() { return categoria; }
      public boolean isPublicada() { return publicada; }
      public String getImagemUrl() { return imagemUrl; }
      public List<Modulo> getModulos() { return new ArrayList<>(modulos); } // Retorna cópia

      // Métodos da sua tabela (implementações placeholder ou básicas)
      public float calcularProgressoMedio() {
          // Lógica placeholder
          System.out.println("[TrilhaEducacional] Calculando progresso médio para: " + titulo);
          return 50.0f; // Exemplo
      }

      public boolean publicarTrilha() {
          this.publicada = true;
          System.out.println("[TrilhaEducacional] Trilha '" + titulo + "' publicada com sucesso!");
          return true;
      }

      // public ProgressoUsuarioTrilha inscreverUsuario(Usuario u) {
      //     System.out.println("[TrilhaEducacional] Usuário " + u.getNome() + " inscrito na trilha: " + titulo);
      //     return null;
      // }

      public void exibirDetalhesCompletos() {
          System.out.println("==============================================");
          System.out.println("DETALHES DA TRILHA EDUCACIONAL");
          System.out.println("==============================================");
          System.out.println("ID: " + id);
          System.out.println("Título: " + titulo);
          System.out.println("Descrição: " + descricao);
          System.out.println("Nível: " + nivel);
          System.out.println("Categoria: " + categoria);
          System.out.println("Publicada: " + (publicada ? "Sim" : "Não"));
          System.out.println("URL da Imagem: " + imagemUrl);
          System.out.println("----------------------------------------------");
          if (modulos.isEmpty()) {
              System.out.println("Esta trilha ainda não possui módulos.");
          } else {
              System.out.println("Módulos da Trilha (" + modulos.size() + "):");
              for (Modulo m : modulos) {
                  m.exibirDetalhes(); // Chama o exibirDetalhes de cada módulo
              }
          }
          System.out.println("==============================================");
      }


      @Override
      public String toString() {
          return "TrilhaEducacional [id=" + id + ", titulo=" + titulo + ", modulos=" + modulos.size() + "]";
      }
  }


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 5 abaixo ilustra a estrutura da classe `TrilhaEducacional.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 5:  Classe Produto TrilhaEducacional.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c4ce743072a50e4b00f32fe3e68be7ae87c7fe93/docs/PadroesDeProjeto/Imagens/BuilderTrilhaEducacional.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe Builder TrilhaEducacionalBuilder

A TrilhaEducacionalBuilder é a classe designada para orquestrar e simplificar a construção de objetos TrilhaEducacional, por isso, o seu principal objetivo é fornecer uma API clara, intuitiva e fluente para montar uma trilha passo a passo ao configurar seus diversos atributos (como título, descrição, nível, categoria) e agregar os Modulos que a compõem (os quais podem ser, por sua vez, construídos usando o ModuloBuilder). 

Abaixo o código para `TrilhaEducacionalBuilder.java` 

<details>
  <summary><strong>Código para `TrilhaEducacionalBuilder.java`</strong></summary>


```java
 package com.galaxiaconectada.trilhas;

  import java.util.ArrayList;
  import java.util.List;

  public class TrilhaEducacionalBuilder {
      // Atributos da TrilhaEducacional que estamos construindo
      private int id;
      private String titulo;
      private String descricao = ""; // Valor padrão
      private String nivel = "Indefinido"; // Valor padrão
      private String categoria = "Geral"; // Valor padrão
      private boolean publicada = false; // Valor padrão
      private String imagemUrl = ""; // Valor padrão
      private List<Modulo> modulos; // Lista para guardar os módulos da trilha

      //Construtor do TrilhaEducacionalBuilder.
      public TrilhaEducacionalBuilder(int id, String titulo) {
          this.id = id;
          this.titulo = titulo;
          this.modulos = new ArrayList<>(); // Inicializa a lista de módulos
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

      public TrilhaEducacionalBuilder adicionarModulo(Modulo modulo) {
          if (modulo != null) {
              this.modulos.add(modulo);
          }
          return this;
      }

      public TrilhaEducacionalBuilder comListaDeModulos(List<Modulo> listaModulos) {
          if (listaModulos != null) {
              this.modulos = new ArrayList<>(listaModulos); // Cria uma cópia da lista
          } else {
              this.modulos = new ArrayList<>();
          }
          return this;
      }

      public TrilhaEducacional build() {
          // Validação simples: garante que o título foi fornecido
          if (this.titulo == null || this.titulo.trim().isEmpty()) {
              throw new IllegalStateException("O título da trilha é obrigatório e não pode ser vazio.");
          }
          // Chama o construtor de TrilhaEducacional que preparamos
          return new TrilhaEducacional(this.id, this.titulo, this.descricao, this.nivel,
                                       this.categoria, this.publicada, this.imagemUrl, this.modulos);
      }
  }

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 6 abaixo ilustra a estrutura da classe `TrilhaEducacionalBuilder.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe TrilhaEducacionalBuilder.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/c4ce743072a50e4b00f32fe3e68be7ae87c7fe93/docs/PadroesDeProjeto/Imagens/BuilderTRilhaEducacionalBuilder.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

## Classe de Teste AplicacaoGalaxia

Para testar as classes e os códigos, foi criada uma main chamada AplicacaoGalaxia. O código dela se encontra abaixo:

<details>
  <summary><strong>Código da  AplicacaoGalaxia</strong></summary>

```java

package com.galaxiaconectada.main;

// Imports das fábricas de Conteúdo
import com.galaxiaconectada.core.Conteudo;
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
import com.galaxiaconectada.fabricas.FabricaDeVideo; // Para usar como tipo de retorno e na lista de módulos
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

public class AplicacaoGalaxia {

    // Fábrica para Conteúdo
    private static FabricaDeConteudo fabricaDeConteudoAtual;
    // Fábrica para PapelUsuario
    private static FabricaDePapelUsuario fabricaDePapelAtual;

    private static Scanner scanner = new Scanner(System.in);
    // Lista para guardar usuários criados na sessão
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();
    // NOVA LISTA para guardar trilhas criadas na sessão
    private static List<TrilhaEducacional> trilhasCriadas = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("### Bem-vindo(a) à Plataforma Interativa Galáxia Conectada ###");
        boolean continuarExecutando = true;

        while (continuarExecutando) {
            exibirMenuPrincipalGeral(); // MENU PRINCIPAL ATUALIZADO
            int escolha = lerOpcaoDoUsuarioNumerica();

            switch (escolha) {
                case 1:
                    gerenciarPublicacaoDeConteudo();
                    break;
                case 2:
                    gerenciarUsuariosEPapeis();
                    break;
                case 3: // NOVA OPÇÃO
                    gerenciarCriacaoDeTrilha();
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
        System.out.println("3. Criar Nova Trilha Educacional"); // NOVA OPÇÃO ADICIONADA
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
            return -1;
        }
    }

    // ---- SEÇÃO DE GERENCIAMENTO DE CONTEÚDO (código que você já tinha) ----
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
        System.out.println("   ↳ Explicação: Esta fábrica é uma especialista! Ela sabe exatamente como construir um objeto do tipo '" + tipoConteudo + "'.");

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
            System.out.print("Texto HTML do Artigo: "); detalhes.put("textoHtml", scanner.nextLine());
            System.out.print("Fonte do Artigo: "); detalhes.put("fonte", scanner.nextLine());
        } else if (tipoConteudo.equalsIgnoreCase("VIDEO")) {
            System.out.print("URL do Vídeo: "); detalhes.put("urlVideo", scanner.nextLine());
            System.out.print("Duração em segundos (número): "); detalhes.put("duracaoSegundos", scanner.nextInt()); scanner.nextLine();
            System.out.print("Transcrição do Vídeo: "); detalhes.put("transcricao", scanner.nextLine());
        } else if (tipoConteudo.equalsIgnoreCase("QUIZ")) {
            System.out.print("Tempo Limite em minutos (número): "); detalhes.put("tempoLimiteMin", scanner.nextInt()); scanner.nextLine();
            System.out.print("Número de Tentativas Permitidas (número): "); detalhes.put("tentativasPermitidas", scanner.nextInt()); scanner.nextLine();
        } else if (tipoConteudo.equalsIgnoreCase("JOGO")) {
            System.out.print("Tipo do Jogo (ex: Puzzle, Estratégia): "); detalhes.put("tipoJogo", scanner.nextLine());
            System.out.print("Nível de Dificuldade (número): "); detalhes.put("nivelDificuldade", scanner.nextInt()); scanner.nextLine();
            System.out.print("URL do Jogo: "); detalhes.put("urlJogo", scanner.nextLine());
        }

        System.out.println("\n[INTERAÇÃO COM A FÁBRICA] " + fabricaDeConteudoAtual.getClass().getSimpleName() + " vai agora criar o objeto '" + tipoConteudo + "'.");
        System.out.println("   ↳ A fábrica usa o 'Factory Method' (criarConteudo) para instanciar o tipo correto de Conteudo.");
        fabricaDeConteudoAtual.iniciarPublicacaoDeConteudo(id, titulo, descricao, visibilidadeSel, detalhes);

        System.out.println("O " + tipoConteudo.toUpperCase() + " '" + titulo + "' foi processado pela fábrica!");
        System.out.println("==============================================");
    }

    public static void configurarFabricaDeConteudo(String tipoConteudo) {
        if (tipoConteudo.equalsIgnoreCase("ARTIGO")) fabricaDeConteudoAtual = new FabricaDeArtigo();
        else if (tipoConteudo.equalsIgnoreCase("VIDEO")) fabricaDeConteudoAtual = new FabricaDeVideo();
        else if (tipoConteudo.equalsIgnoreCase("QUIZ")) fabricaDeConteudoAtual = new FabricaDeQuiz();
        else if (tipoConteudo.equalsIgnoreCase("JOGO")) fabricaDeConteudoAtual = new FabricaDeJogo();
        else throw new IllegalArgumentException("Tipo de conteúdo desconhecido para a fábrica: " + tipoConteudo);
    }

    // ---- SEÇÃO DE GERENCIAMENTO DE USUÁRIOS E PAPÉIS (código que você já tinha) ----
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
        System.out.print("ID do usuário (número): "); int id = lerOpcaoDoUsuarioNumerica();
        System.out.print("Nome do usuário: "); String nome = scanner.nextLine();
        System.out.print("Email do usuário: "); String email = scanner.nextLine();
        System.out.print("Senha do usuário: "); String senha = scanner.nextLine();
        Usuario novoUsuario = new Usuario(id, nome, email, senha);
        usuariosCadastrados.add(novoUsuario);
        System.out.println("[USUÁRIO CRIADO] Usuário '" + nome + "' (ID: " + id + ") criado com sucesso sem papel específico.");
        novoUsuario.exibirInformacoesCompletas();
    }

    public static void exibirInformacoesDeUsuarioInterativo() {
        System.out.println("\n--- Exibir Informações de Usuário ---");
        if (usuariosCadastrados.isEmpty()) { System.out.println("[INFO] Nenhum usuário cadastrado nesta sessão ainda."); return; }
        System.out.println("Usuários cadastrados nesta sessão (escolha pelo número):");
        for (int i = 0; i < usuariosCadastrados.size(); i++) {
            Usuario u = usuariosCadastrados.get(i);
            String papelInfo = (u.getPapelPrincipal() != null) ? " (" + u.getPapelPrincipal().getTipoPapel() + ")" : " (Sem papel)";
            System.out.println((i + 1) + ". " + u.getNome() + " (ID: " + u.getId() + ")" + papelInfo);
        }
        System.out.print("Digite o número do usuário para ver detalhes (ou 0 para cancelar): "); int escolha = lerOpcaoDoUsuarioNumerica();
        if (escolha > 0 && escolha <= usuariosCadastrados.size()) {
            usuariosCadastrados.get(escolha - 1).exibirInformacoesCompletas();
        } else if (escolha != 0) { System.out.println("[ERRO] Escolha de usuário inválida."); }
    }

    public static void atribuirPapelInterativo() {
        System.out.println("\n--- Atribuir Papel a Usuário ---");
        if (usuariosCadastrados.isEmpty()) { System.out.println("[INFO] Nenhum usuário cadastrado. Crie um usuário primeiro."); return; }
        System.out.println("Usuários cadastrados (escolha pelo número):");
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
        System.out.println("   ↳ Explicação: Esta fábrica é especialista em criar o papel de '" + tipoPapelStr + "'.");
        Map<String, Object> detalhesPapel = new HashMap<>();
        System.out.println("\n--- Coletando Dados Específicos para o Papel de " + tipoPapelStr.toUpperCase() + " ---");
        if (tipoPapelStr.equalsIgnoreCase("ALUNO")) {
            System.out.print("Progresso Geral do Aluno (ex: 75.5): "); detalhesPapel.put("progressoGeral", scanner.nextFloat()); scanner.nextLine();
            detalhesPapel.put("ultimoAcessoTrilha", LocalDateTime.now());
        } else if (tipoPapelStr.equalsIgnoreCase("INSTRUTOR")) {
            System.out.print("Biografia Curta: "); detalhesPapel.put("biografiaCurta", scanner.nextLine());
            System.out.print("Avaliação Média (ex: 4.5): "); detalhesPapel.put("avaliacaoMedia", scanner.nextFloat()); scanner.nextLine();
            System.out.print("Especialidades (separadas por vírgula): ");
            detalhesPapel.put("especialidades", List.of(scanner.nextLine().split(",")));
        } else if (tipoPapelStr.equalsIgnoreCase("PROFESSOR_VOLUNTARIO")) {
            System.out.print("Área de Especialidade: "); detalhesPapel.put("areaEspecialidade", scanner.nextLine());
            System.out.print("Número de Artigos Revisados: "); detalhesPapel.put("artigosRevisados", scanner.nextInt()); scanner.nextLine();
        } else if (tipoPapelStr.equalsIgnoreCase("ADMINISTRADOR")) {
            System.out.print("Permissões Globais (separadas por vírgula): ");
            detalhesPapel.put("permissoesGlobais", List.of(scanner.nextLine().split(",")));
            System.out.print("Nível de Acesso (número): "); detalhesPapel.put("nivelAcesso", scanner.nextInt()); scanner.nextLine();
        } else if (tipoPapelStr.equalsIgnoreCase("MODERADOR")) {
            System.out.print("Nível de Moderação: "); detalhesPapel.put("nivelModeracao", scanner.nextLine());
            detalhesPapel.put("dataInicioModeracao", LocalDateTime.now());
        }

        System.out.println("\n[INTERAÇÃO COM A FÁBRICA DE PAPEL] " + fabricaDePapelAtual.getClass().getSimpleName() + " vai agora criar e atribuir o papel.");
        System.out.println("   ↳ A fábrica usa o 'Factory Method' (criarPapel) para instanciar o tipo correto de PapelUsuario.");
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

    // ---- NOVA SEÇÃO PARA CRIAR TRILHAS EDUCACIONAIS ----
    public static void gerenciarCriacaoDeTrilha() {
        System.out.println("\n========= CRIAR NOVA TRILHA EDUCACIONAL =========");

        System.out.print("ID da Trilha (número): ");
        int idTrilha = lerOpcaoDoUsuarioNumerica();
        System.out.print("Título da Trilha: ");
        String tituloTrilha = scanner.nextLine();

        TrilhaEducacionalBuilder trilhaBuilder = new TrilhaEducacionalBuilder(idTrilha, tituloTrilha);
        System.out.println("\n[BUILDER TRILHA] Iniciado para: '" + tituloTrilha + "'. Vamos configurar os detalhes.");

        System.out.print("Descrição da Trilha: ");
        trilhaBuilder.comDescricao(scanner.nextLine());
        System.out.print("Nível da Trilha (ex: Iniciante, Intermediário, Avançado): ");
        trilhaBuilder.comNivel(scanner.nextLine());
        System.out.print("Categoria da Trilha (ex: Astronomia, Robótica): ");
        trilhaBuilder.comCategoria(scanner.nextLine());
        System.out.print("URL da Imagem da Trilha (opcional, deixe em branco se não houver): ");
        trilhaBuilder.comImagemUrl(scanner.nextLine());
        System.out.print("Deseja publicar a trilha imediatamente? (s/n): ");
        boolean publicada = scanner.nextLine().trim().equalsIgnoreCase("s");
        trilhaBuilder.definirComoPublicada(publicada);

        System.out.print("\nQuantos módulos você deseja adicionar a esta trilha? ");
        int numModulos = lerOpcaoDoUsuarioNumerica();

        for (int i = 0; i < numModulos; i++) {
            System.out.println("\n--- Configurando Módulo " + (i + 1) + " de " + numModulos + " ---");
            System.out.print("ID do Módulo (número): ");
            int idModulo = lerOpcaoDoUsuarioNumerica();
            System.out.print("Título do Módulo: ");
            String tituloModulo = scanner.nextLine();

            ModuloBuilder moduloBuilder = new ModuloBuilder(idModulo, tituloModulo);
            System.out.println("[BUILDER MÓDULO] Iniciado para: '" + tituloModulo + "'.");

            System.out.print("Ordem do Módulo na trilha (número, ex: 1, 2...): ");
            moduloBuilder.comOrdem(lerOpcaoDoUsuarioNumerica());
            System.out.print("Descrição breve do Módulo: ");
            moduloBuilder.comDescricaoBreve(scanner.nextLine());

            System.out.print("\nQuantos conteúdos você quer adicionar a este módulo '" + tituloModulo + "'? ");
            int numConteudos = lerOpcaoDoUsuarioNumerica();
            for (int j = 0; j < numConteudos; j++) {
                System.out.println("\n  --- Adicionando Conteúdo " + (j + 1) + " ao Módulo '" + tituloModulo + "' ---");
                Conteudo novoConteudo = criarConteudoInterativoParaModulo(); // Usando o método auxiliar
                if (novoConteudo != null) {
                    moduloBuilder.adicionarConteudo(novoConteudo);
                    System.out.println("  [BUILDER MÓDULO] Conteúdo '" + novoConteudo.getTitulo() + "' (Tipo: " + novoConteudo.getClass().getSimpleName() + ") adicionado ao módulo.");
                }
            }
            Modulo moduloConstruido = moduloBuilder.build();
            trilhaBuilder.adicionarModulo(moduloConstruido);
            System.out.println("[BUILDER TRILHA] Módulo '" + moduloConstruido.getTitulo() + "' construído e adicionado à trilha '" + tituloTrilha + "'.");
        }

        System.out.println("\n[BUILDER TRILHA] Finalizando a construção da Trilha Educacional completa...");
        TrilhaEducacional trilhaFinal = trilhaBuilder.build();
        trilhasCriadas.add(trilhaFinal); 

        System.out.println("\n🎉 Trilha Educacional '" + trilhaFinal.getTitulo() + "' criada com sucesso! 🎉");
        trilhaFinal.exibirDetalhesCompletos();
        System.out.println("===================================================");
    }

    // Método auxiliar para criar um Conteúdo interativamente (para ser adicionado a um Módulo)
    public static Conteudo criarConteudoInterativoParaModulo() {
        exibirMenuTiposDeConteudoParaModulo();
        int escolhaTipoConteudo = lerOpcaoDoUsuarioNumerica();
        String tipoConteudoString = null;

        switch (escolhaTipoConteudo) {
            case 1: tipoConteudoString = "ARTIGO"; break;
            case 2: tipoConteudoString = "VIDEO"; break;
            case 3: tipoConteudoString = "QUIZ"; break;
            case 4: tipoConteudoString = "JOGO"; break;
            case 0: System.out.println("[INFO] Criação de conteúdo para módulo cancelada."); return null;
            default: System.out.println("[ERRO] Tipo de conteúdo inválido."); return null;
        }

        System.out.println("\n  --- Coletando Dados para o Novo " + tipoConteudoString.toUpperCase() + " (para o módulo) ---");
        configurarFabricaDeConteudo(tipoConteudoString); // Configura a fábrica de CONTEÚDO
        System.out.println("  [FÁBRICA CONTEÚDO SELECIONADA]: " + fabricaDeConteudoAtual.getClass().getSimpleName());

        System.out.print("  ID do conteúdo (número): ");
        int id = lerOpcaoDoUsuarioNumerica();
        System.out.print("  Título do conteúdo: ");
        String titulo = scanner.nextLine();
        System.out.print("  Descrição do conteúdo: ");
        String descricao = scanner.nextLine();

        TipoVisibilidade.mostrarOpcoes();
        System.out.print("  Escolha o número da Visibilidade para este conteúdo: ");
        int escolhaVis = lerOpcaoDoUsuarioNumerica();
        TipoVisibilidade visibilidadeSel = TipoVisibilidade.fromOpcao(escolhaVis);
        if (visibilidadeSel == null) {
            visibilidadeSel = TipoVisibilidade.PUBLICO; 
            System.out.println("  [INFO] Visibilidade inválida para conteúdo, usando PUBLICO.");
        }
        System.out.println("  [INFO] Visibilidade do conteúdo definida como: " + visibilidadeSel.getDescricao());

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

    // Menu específico para quando estamos adicionando conteúdo a um módulo
    public static void exibirMenuTiposDeConteudoParaModulo() {
        System.out.println("\n  Qual tipo de conteúdo deseja adicionar a este módulo?");
        System.out.println("  1. Artigo");
        System.out.println("  2. Vídeo");
        System.out.println("  3. Quiz");
        System.out.println("  4. Jogo");
        System.out.println("  0. Concluir adição de conteúdos a este módulo");
        System.out.print("  Digite sua opção: ");
    }

} // Fim da classe AplicacaoGalaxia3

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

</details>

## Conclusão

A aplicação do padrão Builder para a construção dos objetos Modulo e TrilhaEducacional no projeto "Galáxia Conectada" demonstrou ser uma estratégia eficaz para lidar com a complexidade inerente à criação desses objetos compostos. Com isso, o uso de uma interface fluente nos Builders (ModuloBuilder e TrilhaEducacionalBuilder) tornou o processo de instanciação mais legível, passo a passo e menos propenso a erros, especialmente quando comparado a construtores com um grande número de parâmetros.

## Bibliografia 

<a name="ref1"></a>
[1] DEV.MEDIA. Design Patterns: aplicando os padrões Builder, Singleton e Prototype. Disponível em: https://www.devmedia.com.br/design-patterns-aplicando-os-padroes-builder-singleton-e-prototype/31023. Acesso em: 23 maio 2025.

<a name="ref2"></a>
[2] DIO.ME. O que é o padrão Builder? Java/Spring Boot. Disponível em: https://www.dio.me/articles/o-que-e-o-padrao-builder-javaspring-boot. Acesso em: 23 maio 2025.

<a name="ref3"></a>
[3] Nuzzi, J. R. Design Patterns — Parte 6 — Builder. Medium, 30 out. 2019. Disponível em: https://medium.com/@jonesroberto/desing-patterns-parte-6-builder-f20752fb0c35. Acesso em: 23 maio 2025.

<a name="ref4"></a>
[4] REFACTORING.GURU. Builder – Também conhecido como: Construtor. Disponível em: https://refactoring.guru/pt-br/design-patterns/builder. Acesso em: 23 maio 2025.

<a name="ref5"></a>
[5] SUPERVIZ. Design Pattern #7 - Builder Pattern. Dev.to. Disponível em: https://dev.to/superviz/design-pattern-7-builder-pattern-10j4. Acesso em: 23 maio 2025.


## Histórico de versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 23/05/2025 |
| 1.1 | Elaboração do da estrutura dos códigos | Larissa Stéfane | 23/05/2025 |
| 1.2 | Adição dos códigos | Larissa Stéfane | 24/05/2025 |
| 1.3 | Adição das imagens | Larissa Stéfane | 24/05/2025 |
