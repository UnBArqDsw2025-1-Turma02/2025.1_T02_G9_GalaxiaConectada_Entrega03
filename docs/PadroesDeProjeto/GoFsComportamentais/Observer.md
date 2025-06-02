# Padrão Comportamental Observer

## Sumário

- [Introdução](#Introdução)  
- [Objetivo](#Objetivo)  
- [Metodologia](#Metodologia---O-Padrão-Observer)  
- [Desenvolvimento e Implementação](#Desenvolvimento-e-Implementação)  
  - [Modelagem UML do Padrão Observer](#Modelagem-UML-do-Padrão-Observer)  
  - [Definição das Interfaces do Padrão](#Definição-das-Interfaces-do-Padrão)  
    - [Interface ObservadorTrilha](#Interface-ObservadorTrilha)  
    - [Interface SujeitoTrilhaObservavel](#Interface-SujeitoTrilhaObservavel)  
  - [Adaptação da Classe TrilhaEducacional como Sujeito Concreto](#Adaptação-da-Classe-TrilhaEducacional-como-Sujeito-Concreto)  
    - [Descrição das Modificações](#Descrição-das-Modificações)  
    - [Código Atualizado da Classe TrilhaEducacional](#Código-Atualizado-da-Classe-TrilhaEducacional)  
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)  
  - [Implementação dos Observadores Concretos](#Implementação-dos-Observadores-Concretos)  
    - [Classe NotificadorPlataforma](#Classe-NotificadorPlataforma)  
    - [Classe AnunciadorForum](#Classe-AnunciadorForum)  
  - [Demonstração de Uso na AplicacaoGalaxia](#Demonstração-de-Uso-na-AplicacaoGalaxia)  
    - [Descrição da Interação e Testes](#Descrição-da-Interação-e-Testes)  
    - [Código Relevante da Classe AplicacaoGalaxia](#Código-Relevante-da-Classe-AplicacaoGalaxia)  
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)  
    - [Vídeo da Execução](#Vídeo-da-Execução)  
- [Vantagens da Utilização do Observer no Projeto](#Vantagens-da-Utilização-do-Observer-no-Projeto)  
- [Conclusão](#Conclusão)  
- [Referências](#Referências)  
- [Histórico de Versão](#Histórico-de-Versão)  



## Introdução

O padrão de projeto comportamental **Observer** (Observador) define uma dependência um-para-muitos entre objetos, de forma que quando um objeto, conhecido como "sujeito" (ou "observável"), muda seu estado, todos os seus dependentes, chamados "observadores", são notificados e atualizados automaticamente. Conforme descrito em [Observer](https://refactoring.guru/pt-br/design-patterns/observer#:~:text=O%20Observer%20%C3%A9%20um%20padr%C3%A3o,objeto%20que%20eles%20est%C3%A3o%20observando.), com isso, este padrão promove um baixo acoplamento entre o sujeito e seus observadores ao permitir que interajam sem conhecer os detalhes concretos uns dos outros. O sujeito apenas mantém uma lista de observadores e notifica-os sobre eventos, enquanto cada observador define como reagirá a essa notificação.

Assim, no contexto da plataforma "Galáxia Conectada", o padrão Observer foi escolhido para gerenciar de forma eficiente e desacoplada as reações a eventos significativos do sistema, como a publicação de uma nova `TrilhaEducacional`. Quando uma trilha é publicada, diversas partes do sistema podem ter interesse nessa informação – por exemplo, um sistema de notificação geral da plataforma ou um mecanismo para anunciar a novidade no fórum. Além disso, a utilização do Observer permite que a `TrilhaEducacional` (o sujeito) simplesmente anuncie sua publicação, e todos os componentes registrados como observadores (como `NotificadorPlataforma` ou `AnunciadorForum`) reajam a esse evento de maneira independente e específica, sem que a trilha precise conhecer os detalhes de cada um desses componentes.

## Objetivo

A aplicação do padrão de projeto Observer na plataforma "Galáxia Conectada", especificamente no cenário de publicação de `TrilhaEducacional`, visa estabelecer um mecanismo de comunicação flexível e desacoplado entre objetos. Portanto, o propósito central é permitir que múltiplos objetos (observadores) sejam notificados e reajam automaticamente a mudanças de estado ou eventos ocorridos em um objeto central (o sujeito).

Os principais objetivos ao utilizar o padrão Observer neste contexto, inspirados em referências como [Padrão Observer](https://diogomoreira.gitbook.io/padroes-de-projeto/padroes-gof-comportamentais/padrao-observer) são:

* **Promover o Baixo Acoplamento:** Desvincular a `TrilhaEducacional` (sujeito) das classes que precisam reagir à sua publicação (observadores como `NotificadorPlataforma`, `AnunciadorForum`), o que permite que ambos variem e evoluam independentemente.
* **Suporte à Extensibilidade:** Facilitar a adição de novos tipos de observadores no futuro sem a necessidade de modificar o código da classe `TrilhaEducacional`.
* **Consistência na Notificação:** Garantir que todos os componentes interessados sejam notificados de forma consistente e automática quando uma trilha educacional for publicada.
* **Manutenibilidade e Organização:** Centralizar a lógica de disparo da notificação no sujeito e encapsular a lógica de reação em cada observador individual.
* **Reutilização dos Observadores:** Permitir que os mesmos observadores possam, potencialmente, se registrar para eventos de diferentes sujeitos.


## Metodologia


## Desenvolvimento e Implementação

### Modelagem UML do Padrão Observer

### Definição das Interfaces do Padrão

#### Interface ObservadorTrilha

#### Interface SujeitoTrilhaObservavel

### Adaptação da Classe TrilhaEducacional como Sujeito Concreto

#### Descrição das Modificações

#### Código Atualizado da Classe TrilhaEducacional

#### Imagem do Código no VSCode

### Implementação dos Observadores Concretos

#### Classe NotificadorPlataforma

#### Classe AnunciadorForum

### Demonstração de Uso na AplicacaoGalaxia

#### Descrição da Interação e Testes

#### Código Relevante da Classe AplicacaoGalaxia

#### Imagem do Código no VSCode

#### Vídeo da Execução

## Vantagens da Utilização do Observer no Projeto

## Conclusão

## Referências

[1] REFACTORING.GURU. Observer. Disponível em: https://refactoring.guru/pt-br/design-patterns/observer. Acesso em: 31 maio 2025.

[2] DIO. [sw design pattern] Observer (Observador). Disponível em: https://www.dio.me/articles/sw-design-pattern-observer-observador. Acesso em: 31 maio 2025.

[3] ELEMÁR, J. R. Padrão de Design Observer: Simplificando a Comunicação entre Objetos. Clube de Estudos. Disponível em: https://elemarjr.com/clube-de-estudos/artigos/padrao-de-design-observer-simplificando-a-comunicacao-entre-objetos/. Acesso em: 1 jun. 2025.

[4] MOREIRA, D. Padrão Observer. In: Padrões de Projeto. GitBook. Disponível em: https://diogomoreira.gitbook.io/padroes-de-projeto/padroes-gof-comportamentais/padrao-observer. Acesso em: 1 jun. 2025.

[5] GEEKSFORGEEKS. Observer Design Pattern. Disponível em: https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/. Acesso em: 1 jun. 2025.

## Histórico de Versão
