# Padrão Estrutural Facade

## Sumário

- [Introdução](#Introdução)
- [Objetivo](#Objetivo)
- [Metodologia](#Metodologia)
- [Desenvolvimento e Implementação](#Desenvolvimento-e-Implementação)
  - [Modelagem UML do Padrão Facade](#Modelagem-UML-do-Padrão-Facade)
  - [A Classe Facade PlataformaGalaxiaFacade](#A-Classe-Facade-PlataformaGalaxiaFacade)
    - [Descrição Objetivos e Responsabilidades](#Descrição-Objetivos-e-Responsabilidades)
    - [Atributos e Construtor (Gerenciamento de Dependências dos Subsistemas)](#Atributos-e-Construtor-Gerenciamento-de-Dependências-dos-Subsistemas)
    - [Método de Fachada Principal instrutorCriaPublicaTrilhaSimples()](#Método-de-Fachada-Principal-instrutorCriaPublicaTrilhaSimples)
    - [Código da Classe PlataformaGalaxiaFacade](#Código-da-Classe-PlataformaGalaxiaFacade)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Interação da Facade com os Subsistemas](#Interação-da-Facade-com-os-Subsistemas)
    - [Coordenação da Criação de Trilhas (uso de Builders e Fábricas de Conteúdo)](#Coordenação-da-Criação-de-Trilhas-uso-de-Builders-e-Fábricas-de-Conteúdo)
    - [Geração de Notificações (uso de Prototypes e Registro)](#Geração-de-Notificações-uso-de-Prototypes-e-Registro)
    - [Interação com o Fórum (uso do Singleton)](#Interação-com-o-Fórum-uso-do-Singleton)
  - [Utilização da Facade na AplicacaoGalaxia](#Utilização-da-Facade-na-AplicacaoGalaxia)
    - [Vídeo da Execução Demonstrando a Facade](#Vídeo-da-Execução-Demonstrando-a-Facade)
- [Conclusão](#Conclusão)
- [Referências](#Referências)
- [Histórico de Versão](#Histórico-de-Versão)


## Introdução

O padrão de projeto estrutural **Facade** (Fachada) oferece uma solução elegante para simplificar a interação com sistemas ou subsistemas complexos. Conforme descrito em "[Facade](https://refactoring.guru/pt-br/design-patterns/facade), o objetivo principal do Facade é prover uma interface unificada e de mais alto nível para um conjunto de interfaces dentro de um subsistema. Ao fazer isso, o Facade desacopla os clientes da complexidade interna do subsistema, tornando-o mais fácil de usar, entender e manter, sem no entanto restringir o acesso direto aos componentes do subsistema caso funcionalidades sejam necessárias.

No contexto da plataforma "Galáxia Conectada", à medida que diversas funcionalidades foram implementadas – como a criação de conteúdos educacionais, o gerenciamento de usuários e seus papéis, a construção de trilhas de aprendizado, o sistema de notificações e o fórum principal – percebeu-se que certas operações de alto nível exigiriam a coordenação de múltiplos desses subsistemas. Para evitar que o código main (como a classe `AplicacaoGalaxia` ou futuros controladores de interface) tivesse que lidar diretamente com essa orquestração complexa, optou-se pela implementação do padrão Facade. Sendo assim, a classe `PlataformaGalaxiaFacade` foi introduzida para simplificar a execução de tarefas comuns e multifacetadas, como a publicação completa de uma nova trilha por um instrutor, que envolve desde a criação da estrutura da trilha e seus conteúdos até a geração de anúncios e notificações.

## Objetivo

A aplicação do padrão de projeto estrutural **Facade** na plataforma "Galáxia Conectada" visa simplificar a interação com um conjunto de subsistemas complexos e interconectados, como o de criação de conteúdo, gerenciamento de usuários e papéis, construção de trilhas educacionais, notificações e o fórum. 

Os principais objetivos ao utilizar o padrão Facade no projeto, inspirados em referências como [Design Pattern: Facade](https://climaco.medium.com/design-pattern-facade-6b0b2220a604) e [Design Patterns — Parte 12 — Facade](https://medium.com/@jonesroberto/desing-patterns-parte-12-facade-ff66c68f5784), são:

- **Simplificação da Interface:** Reduzir a complexidade ao interagir com funcionalidades que envolvem múltiplos componentes ou subsistemas e oferecer um ponto de entrada único e métodos mais simples.
- **Desacoplamento:** Diminuir o acoplamento entre o código main e as classes internas dos subsistemas. Com isso, o cliente interage apenas com a Facade, e as mudanças internas nos subsistemas têm menor probabilidade de afetá-lo.
- **Melhoria da Legibilidade e Manutenibilidade:** Tornar o código mais limpo e fácil de entender, pois a lógica de orquestração complexa é delegada para a Facade.
- **Organização em Camadas:** Ajudar a estruturar o sistema em camadas, onde a Facade serve como um ponto de entrada para uma camada de serviços ou funcionalidades de mais alto nível.
- **Facilidade de Uso:** Tornar operações comuns que envolvem múltiplos passos ou a coordenação de diferentes partes do sistema mais fáceis de serem invocadas e utilizadas.

## Metodologia

Como já foi discutido, o padrão **Facade** é um padrão de projeto estrutural que fornece uma interface simplificada para um corpo de código maior e mais complexo, como um conjunto de classes ou um subsistema. De acordo com [Facade](https://refactoring.guru/pt-br/design-patterns/facade), o Facade não encapsula o subsistema em si, mas oferece um "rosto" ou "fachada" mais amigável ao rotear as chamadas do cliente para os objetos apropriados dentro do subsistema e gerenciar suas interações.

**Principais Componentes do Padrão Aplicado (com base na estrutura clássica GoF e exemplos como [Design Patterns — Parte 12 — Facade](https://medium.com/@jonesroberto/desing-patterns-parte-12-facade-ff66c68f5784):**

* **Facade (Fachada):** Uma classe que conhece quais classes do subsistema são responsáveis por atender a uma solicitação. Delega as solicitações do cliente aos objetos apropriados do subsistema.
    * **No Projeto:** A classe `PlataformaGalaxiaFacade.java` atua como a Facade. Ela oferece métodos simplificados (ex: `instrutorCriaPublicaTrilhaSimples()`) que internamente coordenam ações com diversos outros componentes e subsistemas.

* **Subsystem classes (Classes do Subsistema):** Implementam a funcionalidade do subsistema. Elas realizam o trabalho real solicitado pela Facade. As classes do subsistema não têm conhecimento da Facade; ou seja, não há referências delas para a Facade.
    * **No Projeto:** Várias classes e padrões que já implementamos atuam como componentes de subsistemas que a `PlataformaGalaxiaFacade` utiliza. 

* **Client (Cliente):** Definição:** Utiliza a classe Facade para interagir com o subsistema, em vez de interagir diretamente com as múltiplas classes do subsistema.
    * **No Projeto:** A classe `AplicacaoGalaxia.java` atua como Cliente ao invocar os métodos da `PlataformaGalaxiaFacade` para realizar operações complexas de forma simplificada.

A decisão de introduzir uma Facade e o design de seus métodos foram informados pela análise dos seguintes artefatos de modelagem já desenvolvidos:

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses) - Ajudou a identificar os diferentes "domínios" (Conteúdo, Usuários, Trilhas, Fórum, Notificações) que precisariam ser coordenados.
* **Diagrama de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes) - Mostrou como diferentes partes do sistema (`Backend Services`, `Subsistema Conteudo Interativo`, etc.) poderiam se beneficiar de uma interface de entrada simplificada.
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes) - Orientou a criação de um novo pacote `com.galaxiaconectada.fachadas` para a classe Facade.
* **Diagrama de Casos de Uso:** [Diagrama de Casos de Uso - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaCasosUso) - Casos de uso como "Publicar Trilha Educacional" (que envolvem múltiplos passos e subsistemas) são candidatos ideais para serem simplificados por um método da Facade.

**Passo a passo de desenvolvimento da implementação do Facade:**

1.  **Identificação da Operação Complexa**
2.  **Definição da Interface da Facade** 
3.  **Implementação da Lógica de Coordenação na Facade**
4.  **Teste da Funcionalidade** Execução da `AplicacaoGalaxia.java` para verificar se a operação através da Facade produz o resultado esperado.

## Desenvolvimento e Implementação

Para concretizar a simplificação da interface com os diversos subsistemas da "Galáxia Conectada", foi desenvolvida e implementada a classe `PlataformaGalaxiaFacade`. Esta seção detalha a sua modelagem UML, a estrutura da classe Facade em si, como ela interage com os componentes dos subsistemas subjacentes, e a forma como o cliente (`AplicacaoGalaxia.java`) a utiliza para executar operações complexas de maneira simplificada. Todo o desenvolvimento foi conduzido em Java, utilizando o Visual Studio Code (VSCode).

### Modelagem UML do Padrão Facade

A figura 1 abaixo mostra a modelagem do Padrão Facade

<div align="center">
    Figura 1: modelagem do Padrão Facade
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

### A Classe Facade PlataformaGalaxiaFacade

A classe `PlataformaGalaxiaFacade.java` é a concretização do padrão Facade no projeto "Galáxia Conectada". Com isso, ela serve como um ponto de entrada simplificado para funcionalidades que, de outra forma, exigiriam que o código main (ou cliente) interagisse diretamente com múltiplos componentes e subsistemas.

#### Descrição Objetivos e Responsabilidades

A `PlataformaGalaxiaFacade` é uma classe que oferece uma interface de alto nível para um conjunto de operações complexas dentro da plataforma.

**Importante**: Ela não adiciona novas funcionalidades por si só, mas simplifica o acesso às funcionalidades existentes ao orquestrar as interações entre diferentes partes do sistema.

**Objetivos Principais:**
- **Simplificar o Uso de Funcionalidades Compostas:** O objetivo primário é fornecer métodos que representem casos de uso comuns ou operações de alto nível que envolvem múltiplos passos ou a coordenação de diferentes subsistemas (como criação de conteúdo, gerenciamento de trilhas, notificações e interações com o fórum).
- **Reduzir Acoplamento:** Desacoplar o código cliente (ex: `AplicacaoGalaxia.java` ou futuras camadas de interface de usuário/API) da complexidade interna dos subsistemas. O cliente precisa conhecer apenas a interface da Facade, não os detalhes de cada componente que ela utiliza.
  
**Responsabilidades:**
- Conhecer e interagir com os componentes dos subsistemas que ela coordena (ex: Builders para Trilhas e Módulos, Fábricas para Conteúdo e Papéis, o Registro de Protótipos para Notificações, o Singleton do Fórum).
- Orquestrar a sequência correta de chamadas a esses componentes para executar a tarefa solicitada pelo cliente.

#### Atributos e Construtor (Gerenciamento de Dependências dos Subsistemas)

**Descrição:** Para cumprir suas responsabilidades de coordenação, a `PlataformaGalaxiaFacade` precisa acessar os pontos de entrada ou as instâncias principais dos subsistemas com os quais interage. Isso é gerenciado através de seus atributos e inicializado em seu construtor.

**Atributos:** A classe `PlataformaGalaxiaFacade` mantém referências a componentes chave, como:
* `private RegistroDePrototipos registroPrototipos;`: Para acessar e clonar protótipos de `Notificacao` e `Conquista`.
* `private Forum forumPrincipal;`: Para interagir com a instância única do fórum principal do sistema.

**Construtor:** O construtor da `PlataformaGalaxiaFacade` é responsável por obter ou inicializar suas dependências. Por exemplo, ele recebe a instância global do `RegistroDePrototipos` (criada na `AplicacaoGalaxia`) e obtém a instância única do `Forum` através de `Forum.getInstance()`. Isso garante que a Facade esteja pronta para operar assim que for criada. 

#### Método de Fachada Principal instrutorCriaPublicaTrilhaSimples()

**Descrição:** O método public TrilhaEducacional instrutorCriaPublicaTrilhaSimples(...) é um exemplo chave de como a PlataformaGalaxiaFacade simplifica uma operação complexa.

**Objetivo do Método:** Permitir que, com uma única chamada de método, um Instrutor possa realizar todo o processo de:

1. Criar uma nova TrilhaEducacional básica.
2. Marcar essa trilha como publicada.
3. Gerar uma Notificacao para anunciar a nova trilha.
4. Criar um "anúncio" (simulado como uma interação com o Subforum) no Forum sobre a nova trilha.

#### Código da Classe PlataformaGalaxiaFacade

Abaixo o código para `PlataformaGalaxiaFacade.java` 

<details>
  <summary><strong>Código para `PlataformaGalaxiaFacade.java` </strong></summary>


```java

package com.galaxiaconectada.fachadas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.comunicacao.Notificacao;
import com.galaxiaconectada.domain.forum.Forum;
import com.galaxiaconectada.domain.forum.Subforum;
import com.galaxiaconectada.fabricas.FabricaDeArtigo;
import com.galaxiaconectada.fabricas.FabricaDeConteudo;
import com.galaxiaconectada.prototipos.PrototipoClonavel;
import com.galaxiaconectada.prototipos.RegistroDePrototipos;
import com.galaxiaconectada.trilhas.Modulo;
import com.galaxiaconectada.trilhas.ModuloBuilder;
import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.trilhas.TrilhaEducacionalBuilder;
import java.time.LocalDateTime; // Necessário para ModuloBuilder e TrilhaEducacionalBuilder
import java.util.HashMap;
import java.util.Map;

//Facade coordenando múltiplos subsistemas.

public class PlataformaGalaxiaFacade {

    private RegistroDePrototipos registroPrototipos;
    private Forum forumPrincipal;

    public PlataformaGalaxiaFacade(RegistroDePrototipos registroPrototiposGlobal) {
        this.registroPrototipos = registroPrototiposGlobal;
        this.forumPrincipal = Forum.getInstance(); // Pega a instância única do Fórum
        System.out.println("[FACADE INICIADA] Pronta para simplificar operações na Galáxia Conectada!");
    }

    // Método de fachada que simplifica a criação e publicação de uma trilha básica

    public TrilhaEducacional instrutorPublicaNovaTrilhaSimples(
            Usuario instrutor,
            int idTrilha, String tituloTrilha, String descTrilha, String categoriaTrilha, String nivelTrilha,
            int idModulo, String tituloModulo, String descModulo,
            int idArtigo, String tituloArtigo, String descArtigo, String textoArtigo, String fonteArtigo) {

        System.out.println("\n[FACADE OPERAÇÃO] " + (instrutor != null ? instrutor.getNome() : "Sistema") + " está criando e publicando uma trilha simples: '" + tituloTrilha + "'...");

        // --- ETAPA 1: Criar o Conteúdo (Artigo) ---
        System.out.println("  [FACADE - ETAPA 1] Preparando conteúdo (artigo) para o módulo...");
        FabricaDeConteudo fabricaArtigo = new FabricaDeArtigo();
        Map<String, Object> detalhesArtigo = new HashMap<>();
        detalhesArtigo.put("textoHtml", textoArtigo);
        detalhesArtigo.put("fonte", fonteArtigo != null ? fonteArtigo : "Instrutor " + (instrutor != null ? instrutor.getNome() : ""));

        Conteudo artigo = (Conteudo) fabricaArtigo.criarConteudo(idArtigo, tituloArtigo, descArtigo, TipoVisibilidade.PUBLICO, detalhesArtigo);
        if (artigo == null) {
            System.out.println("  [ERRO FACADE] Falha ao criar o artigo para a trilha.");
            return null;
        }
        System.out.println("  Conteúdo (Artigo) '" + artigo.getTitulo() + "' criado.");

        // --- ETAPA 2: Criar o Módulo e adicionar o Conteúdo ---
        System.out.println("\n  [FACADE - ETAPA 2] Montando o módulo com o artigo...");
        ModuloBuilder moduloBuilder = new ModuloBuilder(idModulo, tituloModulo)
                .comDescricaoBreve(descModulo)
                .comOrdem(1)
                .adicionarComponente(artigo); // Adiciona o Conteudo (que é ComponenteTrilha)
        Modulo modulo = moduloBuilder.build();
        System.out.println("  Módulo '" + modulo.getTitulo() + "' montado.");

        // --- ETAPA 3: Criar a Trilha Educacional e adicionar o Módulo ---
        System.out.println("\n  [FACADE - ETAPA 3] Montando a trilha educacional...");
        TrilhaEducacionalBuilder trilhaBuilder = new TrilhaEducacionalBuilder(idTrilha, tituloTrilha)
                .comDescricao(descTrilha)
                .comCategoria(categoriaTrilha)
                .comNivel(nivelTrilha)
                .adicionarComponente(modulo); // Adiciona o Modulo (que é ComponenteTrilha)

        TrilhaEducacional novaTrilha = trilhaBuilder.build();
        novaTrilha.publicarTrilha(); // Publica a trilha (isso também notificará observadores da trilha)

        System.out.println("  Trilha Educacional '" + novaTrilha.getTitulo() + "' montada e publicada.");
        // novaTrilha.exibirInformacoes("    "); // Opcional: exibir estrutura aqui para debug da facade

        // --- ETAPA 4: Preparar e "enviar" Notificação sobre a nova trilha ---
        System.out.println("\n  [FACADE - ETAPA 4] Preparando notificação sobre a nova trilha...");
        PrototipoClonavel prototipoNotif = registroPrototipos.getPrototipoClonado("NOTIFICACAO_NOVA_TRILHA");
        if (prototipoNotif instanceof Notificacao) {
            Notificacao notificacaoNovaTrilha = (Notificacao) prototipoNotif;
            String nomeInstrutor = (instrutor != null ? instrutor.getNome() : "a plataforma");
            notificacaoNovaTrilha.setMensagem("Atenção exploradores! A nova trilha '" + novaTrilha.getTitulo() + "' foi lançada por " + nomeInstrutor + "! Confira já!");
            notificacaoNovaTrilha.setLink("/trilhas/" + novaTrilha.getId());
            notificacaoNovaTrilha.setDataEnvio(LocalDateTime.now()); // Data do envio real
            System.out.println("  Notificação (simulada) para ser enviada:");
            notificacaoNovaTrilha.exibir();
        } else {
            System.out.println("  [AVISO FACADE] Protótipo 'NOTIFICACAO_NOVA_TRILHA' não encontrado ou tipo incorreto. Notificação não gerada.");
        }

        // --- ETAPA 5: Criar um anúncio no Fórum ---
        System.out.println("\n  [FACADE - ETAPA 5] Anunciando nova trilha no fórum...");
        Subforum subforumAnuncios = this.forumPrincipal.criarSubforum(
            "Anúncios de Novas Trilhas", 
            "Fique por dentro das últimas trilhas educacionais lançadas!"
        ); 

        System.out.println("  Anúncio (simulado) no subfórum '" + subforumAnuncios.getNome() + "': Trilha '" + novaTrilha.getTitulo() + "' já está disponível!");

        System.out.println("\n[FACADE OPERAÇÃO CONCLUÍDA] Trilha '" + novaTrilha.getTitulo() + "' foi completamente processada pela Facade!");
        return novaTrilha;
    }

}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 2 abaixo ilustra a estrutura da classe `PlataformaGalaxiaFacade.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 2: Classe PlataformaGalaxiaFacade.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>


### Interação da Facade com os Subsistemas

A eficácia da `PlataformaGalaxiaFacade` reside em sua capacidade de orquestrar e simplificar o acesso a funcionalidades complexas, o que é alcançado através da sua interação com diversos subsistemas e componentes da plataforma. Para isso, o método `instrutorCriaPublicaTrilhaSimples()`, por exemplo, demonstra claramente essa coordenação ao utilizar diferentes padrões de projeto e classes para realizar uma operação de alto nível. A seguir, detalhamos como a Facade interage com os principais subsistemas envolvidos nesta operação.

#### Coordenação da Criação de Trilhas (uso de Builders e Fábricas de Conteúdo)

Para a criação da estrutura da trilha educacional, o método `instrutorCriaPublicaTrilhaSimples()` na `PlataformaGalaxiaFacade` delega a complexidade da montagem aos padrões Builder e Factory Method previamente implementados. Primeiramente, para o conteúdo que comporá o módulo inicial da trilha (um artigo), a Facade utiliza uma fábrica de conteúdo específica (como `FabricaDeArtigo`) para instanciar o objeto `Conteudo`. Em seguida, um `ModuloBuilder` é empregado para construir o objeto `Modulo`, ao configurar os seus atributos e ao adicionar o conteúdo recém-criado a ele. Finalmente, um `TrilhaEducacionalBuilder` é utilizado para montar o objeto `TrilhaEducacional` principal, recebendo os dados da trilha e o módulo construído. Ao final desse processo, a Facade invoca o método `build()` de cada builder para obter as instâncias finais e também pode chamar métodos como `publicarTrilha()` no objeto `TrilhaEducacional` resultante. 

#### Geração de Notificações (uso de Prototypes e Registro)

Após a criação e publicação da nova trilha educacional, a `PlataformaGalaxiaFacade`, através do método `instrutorCriaPublicaTrilhaSimples()`, interage com o subsistema de notificações utilizando o padrão Prototype. A Facade acessa o `RegistroDePrototipos` (que lhe foi fornecido ou que ela gerencia) para obter um clone de um objeto `Notificacao` pré-configurado, adequado para anunciar novas trilhas (ex: um protótipo com a chave "NOTIFICACAO_NOVA_TRILHA"). Uma vez que o clone é obtido através do método `clonar()`, a Facade o personaliza com os detalhes específicos da trilha recém-criada, como seu título, o nome do instrutor e um link direto para a trilha. Este objeto `Notificacao` clonado e customizado está então pronto para ser processado pelo sistema de envio de notificações (cuja lógica de envio em si pode ser parte de outro serviço não detalhado pela Facade, mas a *criação* da notificação é facilitada pelo Prototype). 


#### Interação com o Fórum (uso do Singleton)

Para anunciar a nova trilha à comunidade, o método `instrutorCriaPublicaTrilhaSimples()` da `PlataformaGalaxiaFacade` interage com o Fórum principal do sistema. Ele obtém a instância única do `Forum` através do método estático `Forum.getInstance()`, característico do padrão Singleton. Com a referência ao `Forum` em mãos, a Facade pode então realizar operações como buscar ou criar um `Subforum` específico para anúncios (ex: "Anúncios de Novas Trilhas"). Em seguida, ela simula a criação de uma nova postagem ou tópico informativo nesse subfórum, comunicando o lançamento da nova trilha educacional.


### Utilização da Facade na AplicacaoGalaxia

Abaixo está o código da aplicação:

<details>
  <summary><strong>Código para `AplicacaoGalaxia.java` </strong></summary>


```java

package com.galaxiaconectada.main;

// Imports das fábricas de Conteúdo
import com.galaxiaconectada.fabricas.FabricaDeConteudo;
import com.galaxiaconectada.fabricas.FabricaDeArtigo;
import com.galaxiaconectada.fabricas.FabricaDeVideo;
import com.galaxiaconectada.fabricas.FabricaDeQuiz;
import com.galaxiaconectada.fabricas.FabricaDeJogo;

// Imports das fábricas de Papel de Usuário
import com.galaxiaconectada.fabricas.FabricaDePapelUsuario;
import com.galaxiaconectada.fabricas.FabricaDeAluno;
import com.galaxiaconectada.fabricas.FabricaDeInstrutor;
import com.galaxiaconectada.fabricas.FabricaDeProfessorVoluntario;
import com.galaxiaconectada.fabricas.FabricaDeAdministrador;
import com.galaxiaconectada.fabricas.FabricaDeModerador;

// Imports das classes de Domínio, Core, Trilhas e Protótipos
import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import com.galaxiaconectada.trilhas.Modulo;
import com.galaxiaconectada.trilhas.ModuloBuilder;
import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.trilhas.TrilhaEducacionalBuilder;
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha; // Para Composite

import com.galaxiaconectada.prototipos.PrototipoClonavel;
import com.galaxiaconectada.prototipos.RegistroDePrototipos;
import com.galaxiaconectada.prototipos.Conquista;   
import com.galaxiaconectada.domain.comunicacao.Notificacao; 

// Imports para o Fórum (Singleton)
import com.galaxiaconectada.domain.forum.Forum;
import com.galaxiaconectada.domain.forum.Subforum;

// Imports para a Facade
import com.galaxiaconectada.fachadas.PlataformaGalaxiaFacade;

// Imports do Java Util
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AplicacaoGalaxia {

    // Fábricas atuais
    private static FabricaDeConteudo fabricaDeConteudoAtual;
    private static FabricaDePapelUsuario fabricaDePapelAtual;

    private static Scanner scanner = new Scanner(System.in);
    // Listas para guardar objetos criados na sessão
    private static List<Usuario> usuariosCadastrados = new ArrayList<>();
    private static List<TrilhaEducacional> trilhasCriadas = new ArrayList<>();

    // Registro de Protótipos
    private static RegistroDePrototipos registroDePrototipos = new RegistroDePrototipos();

    // Facade
    private static PlataformaGalaxiaFacade plataformaFacade;

    public static void main(String[] args) {
        System.out.println("### Bem-vindo(a) à Plataforma Interativa Galáxia Conectada ###");
        carregarPrototiposIniciais();
        // Instancia a Facade, passando o registro de protótipos que ela pode precisar
        plataformaFacade = new PlataformaGalaxiaFacade(registroDePrototipos);
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
                case 5:
                    gerenciarForumSingleton();
                    break;
                case 6: // OPÇÃO PARA FACADE
                    testarPublicacaoTrilhaViaFacade();
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

        Notificacao nProto1 = new Notificacao(0, "BEM_VINDO_PLATAFORMA", "Olá, [NomeUsuario]! Seja muito bem-vindo(a) à Galáxia Conectada!", "/painel");
        registroDePrototipos.adicionarPrototipo("NOTIFICACAO_BEM_VINDO", nProto1);
        Notificacao nProto2 = new Notificacao(0, "NOVA_CONQUISTA_GERAL", "Parabéns, [NomeUsuario]! Você desbloqueou: [NomeConquista]!", "/perfil/conquistas");
        registroDePrototipos.adicionarPrototipo("NOTIFICACAO_CONQUISTA", nProto2);
        // Protótipo para notificação de nova trilha (usado pela Facade)
        Notificacao nProtoTrilha = new Notificacao(0, "NOVA_TRILHA_LANCADA", "A trilha '[NOME_TRILHA]' foi lançada por [NOME_INSTRUTOR]! Confira!", "/trilhas/[ID_TRILHA]");
        registroDePrototipos.adicionarPrototipo("NOTIFICACAO_NOVA_TRILHA", nProtoTrilha);

        System.out.println("[SISTEMA] Protótipos carregados com sucesso!");
    }


    public static void exibirMenuPrincipalGeral() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("O que você gostaria de fazer?");
        System.out.println("1. Gerenciar Publicação de Conteúdo (Factory Method)");
        System.out.println("2. Gerenciar Usuários e Papéis (Factory Method)");
        System.out.println("3. Criar Nova Trilha Educacional (Builder + Composite)");
        System.out.println("4. Testar Padrão Prototype (Clonagem)");
        System.out.println("5. Acessar Fórum Principal (Singleton)");
        System.out.println("6. Publicar Trilha Completa (via Facade)");
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
                // Usando ComponenteTrilha pois criarConteudoInterativoParaModulo retorna Conteudo (que é ComponenteTrilha)
                ComponenteTrilha novoConteudoComoComponente = criarConteudoInterativoParaModulo();
                if (novoConteudoComoComponente != null) {
                    moduloBuilder.adicionarComponente(novoConteudoComoComponente); // ModuloBuilder espera ComponenteTrilha
                    System.out.println("  [BUILDER MÓDULO] Conteúdo '" + novoConteudoComoComponente.getTitulo() + "' (Tipo: " + novoConteudoComoComponente.getClass().getSimpleName() + ") adicionado.");
                }
            }
            ComponenteTrilha moduloConstruido = moduloBuilder.build(); // ModuloBuilder.build() retorna Modulo (que é ComponenteTrilha)
            trilhaBuilder.adicionarComponente(moduloConstruido); // TrilhaEducacionalBuilder espera ComponenteTrilha
            System.out.println("[BUILDER TRILHA] Módulo '" + moduloConstruido.getTitulo() + "' adicionado à trilha.");
        }
        System.out.println("\n[BUILDER TRILHA] Construindo Trilha Educacional...");
        TrilhaEducacional trilhaFinal = trilhaBuilder.build();
        trilhasCriadas.add(trilhaFinal);
        System.out.println("\n🎉 Trilha Educacional '" + trilhaFinal.getTitulo() + "' criada com sucesso! 🎉");
        System.out.println("\n--- Exibindo Estrutura da Trilha (Padrão Composite) ---");
        trilhaFinal.exibirInformacoes(""); // Chama o método do Composite
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

    // ---- SEÇÃO PARA TESTAR FACADE ----
    public static void testarPublicacaoTrilhaViaFacade() {
        System.out.println("\n========= PUBLICAR TRILHA COMPLETA (via FACADE) =========");

        Usuario instrutor = null;
        if (!usuariosCadastrados.isEmpty()) {
            for (Usuario u : usuariosCadastrados) {
                if (u.getPapelPrincipal() != null && "Instrutor".equalsIgnoreCase(u.getPapelPrincipal().getTipoPapel())) {
                    instrutor = u;
                    break;
                }
            }
            if (instrutor == null) instrutor = usuariosCadastrados.get(0); 
        } else {
            System.out.println("[INFO] Nenhum usuário cadastrado. Crie um usuário e atribua o papel de Instrutor para um teste completo.");
            instrutor = new Usuario(999, "Instrutor Facade Padrão", "instrutor.facade@galaxia.com", "senha123");
            System.out.println("Usando instrutor padrão para o teste da Facade: " + instrutor.getNome());
        }
        System.out.println("Publicando trilha como Instrutor: " + instrutor.getNome());

        System.out.println("\n--- Dados para a Nova Trilha (via Facade) ---");
        System.out.print("ID da Trilha: "); int idTrilha = lerOpcaoDoUsuarioNumerica();
        System.out.print("Título da Trilha: "); String tituloTrilha = scanner.nextLine();
        System.out.print("Descrição da Trilha: "); String descTrilha = scanner.nextLine();
        System.out.print("Categoria da Trilha (ex: Planetas): "); String catTrilha = scanner.nextLine();
        System.out.print("Nível da Trilha (ex: Iniciante): "); String nivTrilha = scanner.nextLine();

        System.out.println("\n--- Dados para o Módulo da Trilha ---");
        System.out.print("ID do Módulo: "); int idModulo = lerOpcaoDoUsuarioNumerica();
        System.out.print("Título do Módulo: "); String tituloModulo = scanner.nextLine();
        System.out.print("Descrição do Módulo: "); String descModulo = scanner.nextLine();
        
        System.out.println("\n--- Dados para o Artigo do Módulo ---");
        System.out.print("ID do Artigo: "); int idArtigo = lerOpcaoDoUsuarioNumerica();
        System.out.print("Título do Artigo: "); String tituloArtigo = scanner.nextLine();
        System.out.print("Descrição do Artigo: "); String descArtigo = scanner.nextLine();
        System.out.print("Texto HTML do Artigo: "); String textoArtigo = scanner.nextLine();
        System.out.print("Fonte do Artigo: "); String fonteArtigo = scanner.nextLine();

        System.out.println("\n[APLICAÇÃO] Solicitando à Facade para criar, publicar, notificar e anunciar a trilha...");
        TrilhaEducacional trilhaPublicada = plataformaFacade.instrutorPublicaNovaTrilhaSimples(
                instrutor, idTrilha, tituloTrilha, descTrilha, catTrilha, nivTrilha,
                idModulo, tituloModulo, descModulo,
                idArtigo, tituloArtigo, descArtigo, textoArtigo, fonteArtigo
        );

        if (trilhaPublicada != null) {
            System.out.println("\n[APLICAÇÃO INFO] Trilha '" + trilhaPublicada.getTitulo() + "' processada pela Facade com sucesso.");
            trilhasCriadas.add(trilhaPublicada);
        } else {
            System.out.println("\n[APLICAÇÃO ERRO] Falha no processo da Facade para publicar a trilha.");
        }
        System.out.println("================================================================");
    }

} 

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

</details>

#### Vídeo da Execução Demonstrando a Facade

## Conclusão

A implementação do padrão de projeto Facade, através da classe `PlataformaGalaxiaFacade`, demonstrou ser uma adição estratégica e benéfica à arquitetura do sistema "Galáxia Conectada". Com isso, ao fornecer uma interface simplificada para operações complexas que orquestram múltiplos subsistemas – como a criação e publicação de trilhas educacionais com suas respectivas notificações e anúncios no fórum – o padrão cumpriu seu objetivo de reduzir a complexidade percebida pelo cliente e de promover um menor acoplamento entre as diferentes camadas e componentes da aplicação.

Observou-se também que a utilização da Facade tornou o código cliente mais enxuto, legível e focado nas intenções de negócio, delegando a complexidade da coordenação para a classe Facade. 


## Referências

[1] LOPES, Davi. Design Pattern Facade: definição e exemplo de implementação. Community Revelo, 2022. Disponível em: https://community.revelo.com.br/design-pattern-facade-definicao-e-exemplo-de-implementacao/. Acesso em: 1 jun. 2025.

[2] REFACTORING.GURU. Facade. Disponível em: https://refactoring.guru/pt-br/design-patterns/facade. Acesso em: 1 jun. 2025.

[3] CLIMACO, Clímaco. Design Pattern: Facade. Medium, 2020. Disponível em: https://climaco.medium.com/design-pattern-facade-6b0b2220a604. Acesso em: 1 jun. 2025.

[4] ROBERTO, Jones. Design Patterns — Parte 12 — Facade. Medium, 2019. Disponível em: https://medium.com/@jonesroberto/desing-patterns-parte-12-facade-ff66c68f5784. Acesso em: 1 jun. 2025.


## Histórico de Versão


| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 01/06/2025 |
| 1.1 | Adição das mudanças do código | Larissa Stéfane | 01/06/2025 |
| 1.2 | Organização e adição das mudanças | Larissa Stéfane | 01/06/2025 |
| 1.3 | Reestruturação | Larissa Stéfane | 01/06/2025 |
| 1.4 | Adição dos códigos | Larissa Stéfane | 01/06/2025 |
| 1.5 | Adição de Interação da Facade com os Subsistemas | Larissa Stéfane | 01/06/2025 |
