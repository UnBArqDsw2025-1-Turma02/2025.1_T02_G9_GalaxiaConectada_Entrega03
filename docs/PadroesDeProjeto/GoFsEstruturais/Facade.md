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
  <summary><strong>Código para `TAplicacaoGalaxia.java` </strong></summary>


```java


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
