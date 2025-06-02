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

A interface `SujeitoTrilhaObservavel` desempenha o papel do Subject (ou Observable) no padrão Observer, especificamente para o contexto de eventos relacionados a TrilhaEducacional. Seu objetivo é definir o contrato para qualquer classe que possa ser "observada" por instâncias de ObservadorTrilha. Este contrato inclui métodos para que os observadores possam se registrar (adicionarObservador) e cancelar seu registro (removerObservador), bem como um método (notificarObservadoresDaPublicacao) que o sujeito utilizará para informar a todos os seus observadores registrados sobre a ocorrência do evento de publicação. 

Abaixo o código para `SujeitoTrilhaObservavel.java`


<details>
  <summary><strong>Código para `SujeitoTrilhaObservavel.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 3 abaixo ilustra a estrutura da classe `SujeitoTrilhaObservavel.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: SujeitoTrilhaObservavel.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>


### Adaptação da Classe TrilhaEducacional como Sujeito Concreto

A classe `TrilhaEducacional.java`, que representa um percurso de aprendizado completo na plataforma, é a entidade cujo evento de "publicação" vai ser observado. Para que ela pudesse notificar outros objetos sobre essa mudança de estado, ela foi adaptada para atuar como um Sujeito Concreto no padrão Observer.

#### Descrição das Modificações

As seguintes modificações foram realizadas na classe `TrilhaEducacional.java` para implementar as responsabilidades de um Sujeito Concreto:

1.  **Implementação da Interface `SujeitoTrilhaObservavel`:** A classe `TrilhaEducacional` passou a implementar a interface `SujeitoTrilhaObservavel`. 

2.  **Armazenamento de Observadores:** Foi adicionado um atributo privado para manter uma lista dos observadores registrados interessados nos eventos desta trilha

3.  **Implementação dos Métodos de Gerenciamento de Observadores:**
    * **`adicionarObservador(ObservadorTrilha observador)`:** Este método permite que um novo observador se registre para receber notificações da trilha. Ele adiciona o observador à lista interna.
    * **`removerObservador(ObservadorTrilha observador)`:** Este método permite que um observador cancele seu registro, sendo removido da lista de notificações.
    Ambos os métodos foram implementados com a palavra-chave `synchronized` para garantir a segurança em caso de acesso concorrente à lista de observadores.

4.  **Implementação do Método de Notificação:** Este método é o responsável por percorrer a lista de observadores registrados e invocar o método `notificarTrilhaPublicada(this)` em cada um deles. 

#### Código Atualizado da Classe TrilhaEducacional

Abaixo o código para `TrilhaEducacional.java`


<details>
  <summary><strong>Código para `TrilhaEducacional.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 4 abaixo ilustra a estrutura da classe `TrilhaEducacional.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 4: TrilhaEducacional.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>


### Implementação dos Observadores Concretos

Os Observadores Concretos são as classes que implementam a interface `ObservadorTrilha` e definem a ação específica a ser tomada quando são notificadas pelo sujeito (`TrilhaEducacional`) sobre a publicação de uma nova trilha. Para o projeto "Galáxia Conectada", foram implementados dois exemplos de observadores concretos.

#### Classe NotificadorPlataforma

A classe `NotificadorPlataforma` atua como um Observador Concreto cuja responsabilidade é simular um sistema de notificação geral da plataforma "Galáxia Conectada". Ao ser informado sobre a publicação de uma nova `TrilhaEducacional` (através da implementação do método `notificarTrilhaPublicada` da interface `ObservadorTrilha`), este componente exibe no console uma mensagem de alerta geral, detalhando a trilha recém-disponibilizada. Dessa maneira, esta classe poderia ser responsável por interagir com mecanismos reais de envio de notificações, como e-mails para usuários interessados, alertas push em aplicativos móveis, ou a criação de um item na seção de "Novidades" da plataforma. 

Abaixo o código para `NotificadorPlataforma.java`

<details>
  <summary><strong>Código para `NotificadorPlataforma.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 5 abaixo ilustra a estrutura da classe `NotificadorPlataforma.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 5: NotificadorPlataforma.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>

#### Classe AnunciadorForum

A classe AnunciadorForum é outro Observador Concreto, projetado para reagir à publicação de uma TrilhaEducacional através da criação de um anúncio no fórum principal da plataforma. Ao implementar o método notificarTrilhaPublicada da interface ObservadorTrilha, esta classe obtém a instância Singleton do Forum e simula a criação de um subfórum de anúncios (ou a utilização de um existente) e, em seguida, a postagem de um novo tópico informando a comunidade sobre a nova trilha. Em um sistema completo, esta classe utilizaria um TopicoBuilder para a criação formal do tópico e da postagem inicial. 

Abaixo o código para `AnunciadorForum.java`

<details>
  <summary><strong>Código para `AnunciadorForum.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 6 abaixo ilustra a estrutura da classe `AnunciadorForum.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: AnunciadorForum.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>


### Demonstração de Uso na AplicacaoGalaxia

Abaixo está o código da aplicação:

<details>
  <summary><strong>Código para `TAplicacaoGalaxia.java` </strong></summary>


```java


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

</details>

## Conclusão

## Referências

[1] REFACTORING.GURU. Observer. Disponível em: https://refactoring.guru/pt-br/design-patterns/observer. Acesso em: 31 maio 2025.

[2] DIO. [sw design pattern] Observer (Observador). Disponível em: https://www.dio.me/articles/sw-design-pattern-observer-observador. Acesso em: 31 maio 2025.

[3] ELEMÁR, J. R. Padrão de Design Observer: Simplificando a Comunicação entre Objetos. Clube de Estudos. Disponível em: https://elemarjr.com/clube-de-estudos/artigos/padrao-de-design-observer-simplificando-a-comunicacao-entre-objetos/. Acesso em: 1 jun. 2025.

[4] MOREIRA, D. Padrão Observer. In: Padrões de Projeto. GitBook. Disponível em: https://diogomoreira.gitbook.io/padroes-de-projeto/padroes-gof-comportamentais/padrao-observer. Acesso em: 1 jun. 2025.

[5] GEEKSFORGEEKS. Observer Design Pattern. Disponível em: https://www.geeksforgeeks.org/observer-pattern-set-1-introduction/. Acesso em: 1 jun. 2025.

## Histórico de Versão


| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 31/06/2025 |
| 1.1 | Adição do código | Larissa Stéfane | 31/06/2025 |
| 1.2 | Organização e adição das mudanças | Larissa Stéfane | 01/06/2025 |
