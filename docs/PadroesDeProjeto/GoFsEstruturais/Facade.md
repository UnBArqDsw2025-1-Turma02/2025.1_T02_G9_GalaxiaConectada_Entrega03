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
  - [Utilização da Facade pelo Cliente AplicacaoGalaxia](#Utilização-da-Facade-pelo-Cliente-AplicacaoGalaxia)
    - [Descrição da Interação do Cliente com a Facade](#Descrição-da-Interação-do-Cliente-com-a-Facade)
    - [Código Relevante da Classe AplicacaoGalaxia](#Código-Relevante-da-Classe-AplicacaoGalaxia)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode-1)
    - [Vídeo da Execução Demonstrando a Facade](#Vídeo-da-Execução-Demonstrando-a-Facade)
- [Vantagens da Utilização da Facade no Projeto](#Vantagens-da-Utilização-da-Facade-no-Projeto)
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

#### Descrição Objetivos e Responsabilidades

#### Atributos e Construtor (Gerenciamento de Dependências dos Subsistemas)

#### Método de Fachada Principal instrutorCriaPublicaTrilhaSimples()

#### Código da Classe PlataformaGalaxiaFacade

#### Imagem do Código no VSCode

### Interação da Facade com os Subsistemas

#### Coordenação da Criação de Trilhas (uso de Builders e Fábricas de Conteúdo)

#### Geração de Notificações (uso de Prototypes e Registro)

#### Interação com o Fórum (uso do Singleton)

### Utilização da Facade pelo Cliente AplicacaoGalaxia

#### Descrição da Interação do Cliente com a Facade

#### Código Relevante da Classe AplicacaoGalaxia

#### Imagem do Código no VSCode

#### Vídeo da Execução Demonstrando a Facade

## Vantagens da Utilização da Facade no Projeto

## Conclusão

## Referências

[1] LOPES, Davi. Design Pattern Facade: definição e exemplo de implementação. Community Revelo, 2022. Disponível em: https://community.revelo.com.br/design-pattern-facade-definicao-e-exemplo-de-implementacao/. Acesso em: 1 jun. 2025.

[2] REFACTORING.GURU. Facade. Disponível em: https://refactoring.guru/pt-br/design-patterns/facade. Acesso em: 1 jun. 2025.

[3] CLIMACO, Clímaco. Design Pattern: Facade. Medium, 2020. Disponível em: https://climaco.medium.com/design-pattern-facade-6b0b2220a604. Acesso em: 1 jun. 2025.

[4] ROBERTO, Jones. Design Patterns — Parte 12 — Facade. Medium, 2019. Disponível em: https://medium.com/@jonesroberto/desing-patterns-parte-12-facade-ff66c68f5784. Acesso em: 1 jun. 2025.


## Histórico de Versão
