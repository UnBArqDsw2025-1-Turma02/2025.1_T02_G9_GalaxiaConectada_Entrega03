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

Como já foi discutido, o padrão comportamental **Observer** (Observador) foi empregado no projeto "Galáxia Conectada" para estabelecer um sistema de comunicação eficiente e desacoplado entre objetos. Isso porque este padrão define uma dependência um-para-muitos onde um objeto central, o "sujeito" (ou "observável"), notifica automaticamente múltiplos objetos "observadores" sobre quaisquer mudanças em seu estado ou sobre a ocorrência de eventos específicos. 

**Principais Componentes do Padrão Aplicado (com base na estrutura clássica GoF e referências como [Observer](https://refactoring.guru/pt-br/design-patterns/observer#:~:text=O%20Observer%20%C3%A9%20um%20padr%C3%A3o,objeto%20que%20eles%20est%C3%A3o%20observando.):**

- **Subject (Sujeito Observável / `Observable`):** Interface ou classe abstrata que define os métodos para registrar (`attach`), remover (`detach`) e notificar (`notify`) observadores. Mantém uma lista de seus observadores.
    
- **ConcreteSubject (Sujeito Concreto):** Implementa a interface do Sujeito. Armazena o estado que é de interesse dos observadores e envia uma notificação para eles quando este estado muda.
   
- **Observer (Observador):** Interface ou classe abstrata que define o método de atualização (ex: `update()`) que será chamado quando o sujeito notificar uma mudança.

- **ConcreteObserver (Observador Concreto):** Implementa a interface do Observador. Cada observador concreto registra-se com um sujeito concreto para receber atualizações e define a ação a ser tomada quando notificado.
    
A decisão de implementar o padrão Observer para o evento de publicação de trilhas, bem como o design das interfaces e classes envolvidas, foi informada pela análise dos seguintes artefatos de modelagem do projeto "Galáxia Conectada":

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses) - Ajudou a identificar a `TrilhaEducacional` como uma entidade central e a antever a necessidade de outras classes ou sistemas (como `Notificacao` ou o `Forum`) reagirem a mudanças em seu estado.
* **Diagrama de Casos de Uso:** [Diagrama de Casos de Uso - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaCasosUso) - Cenários como "Instrutor Publicar Trilha" implicam que, após a publicação, outros atores ou partes do sistema (como alunos ou a comunidade do fórum) precisariam ser informados, justificando um mecanismo de notificação de eventos.
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes) - Orientou a criação de um novo pacote dedicado, `com.galaxiaconectada.observer`, para abrigar as interfaces e classes específicas da implementação do padrão Observer, promovendo uma melhor organização do código.

**Passo a passo de desenvolvimento da implementação do Observer:**

1.  **Identificação do Evento Chave e dos Potenciais Interessados** 
2.  **Definição da Interface `ObservadorTrilha`** 
3.  **Definição da Interface `SujeitoTrilhaObservavel`** 
4.  **Adaptação da Classe `TrilhaEducacional` como Sujeito Concreto** 
5.  **Implementação dos Observadores Concretos** 

## Desenvolvimento e Implementação

Com o intuito de concretizar a aplicação do padrão **Observer** no projeto "Galáxia Conectada", especificamente para estabelecer um mecanismo desacoplado e eficiente de notificação quando uma `TrilhaEducacional` é publicada, esta seção detalha as etapas de sua modelagem e implementação. Com isso, serão apresentadas a estrutura UML do padrão conforme aplicado, a definição das interfaces fundamentais `ObservadorTrilha` (Observer) e `SujeitoTrilhaObservavel` (Subject), a adaptação da classe `TrilhaEducacional` para atuar como o sujeito concreto (ConcreteSubject) capaz de notificar seus dependentes.

## Modelagem UML do Padrão Observer

A figura 1 abaixo mostra a modelagem do Padrão Observer

<div align="center">
    Figura 1: modelagem do Padrão Observer
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

### Definição das Interfaces do Padrão

A implementação do padrão Observer no projeto "Galáxia Conectada" inicia-se com a definição de duas interfaces cruciais: uma para os Observadores (`ObservadorTrilha`) e outra para o Sujeito observável (`SujeitoTrilhaObservavel`). Essas interfaces estabelecem o contrato de comunicação e garantem o desacoplamento entre os componentes.

#### Interface ObservadorTrilha

A interface `ObservadorTrilha` representa o papel do **Observer** no padrão. Seu principal objetivo é definir um método de atualização comum (`notificarTrilhaPublicada`) que todas as classes concretas interessadas em serem notificadas sobre a publicação de uma `TrilhaEducacional` devem implementar. 

Quando uma trilha é publicada, o sujeito (a `TrilhaEducacional`) invocará este método em cada um dos seus observadores registrados, passando a instância da trilha publicada como parâmetro. Isso permite que cada observador reaja ao evento de forma específica e apropriada ao seu contexto.

Abaixo o código para `ObservadorTrilha.java` 

<details>
  <summary><strong>Código para `ObservadorTrilha.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 2 abaixo ilustra a estrutura da classe `ObservadorTrilha.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 2: Classe ObservadorTrilha.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

#### Interface SujeitoTrilhaObservavel





### Adaptação da Classe TrilhaEducacional como Sujeito Concreto

#### Descrição das Modificações

#### Código Atualizado da Classe TrilhaEducacional

#### Imagem do Código no VSCode

### Implementação dos Observadores Concretos

#### Classe NotificadorPlataforma

#### Classe AnunciadorForum

### Demonstração de Uso na AplicacaoGalaxia

## Conclusão

## Referências

[1] REFACTORING.GURU. Observer. Disponível em: https://refactoring.guru/pt-br/design-patterns/observer. Acesso em: 31 maio 2025.

[2] DIO. [sw design pattern] Observer (Observador). Disponível em: https://www.dio.me/articles/sw-design-pattern-observer-observador. Acesso em: 31 maio 2025.

[3] ELEMÁR, J. R. Padrão de Design Observer: Simplificando a Comunicação entre Objetos. Clube de Estudos. Disponível em: https://elemarjr.com/clube-de-estudos/artigos/padrao-de-design-observer-simplificando-a-comunicacao-entre-objetos/. Acesso em: 1 jun. 2025.

[4] MOREIRA, D. Padrão Observer. In: Padrões de Projeto. GitBook. Disponível em: https://diogomoreira.gitbook.io/padroes-de-projeto/padroes-gof-comportamentais/padrao-observer. Acesso em: 1 jun. 2025.

[5] GEEKSFORGEEKS. Observer Design Pattern. Disponível em: https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/. Acesso em: 1 jun. 2025.

## Histórico de Versão
