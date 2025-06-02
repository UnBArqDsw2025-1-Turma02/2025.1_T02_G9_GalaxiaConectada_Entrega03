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
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/d2cebb15c1f84195134f1f4ec29bf753f1ac2e01/docs/PadroesDeProjeto/Imagens/ModelagemComportamentalObserver.drawio.png" width="1000">
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
package com.galaxiaconectada.observer;

import com.galaxiaconectada.trilhas.TrilhaEducacional; // Importa a classe do objeto que será observado

// Define o método de atualização que será chamado quando o Sujeito (TrilhaEducacional) notificar
public interface ObservadorTrilha {
    void notificarTrilhaPublicada(TrilhaEducacional trilhaPublicada);
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 2 abaixo ilustra a estrutura da classe `ObservadorTrilha.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 2: Classe ObservadorTrilha.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/f26dc103e37355c4a69b3203bf7ecf4ade5c0870/docs/PadroesDeProjeto/Imagens/Observer_ObservadorTrilha.png" width="1000">
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
package com.galaxiaconectada.observer;

//Interface Subject (Sujeito Observável): define os métodos para que os Observadores possam se registrar e cancelar o registro.

public interface SujeitoTrilhaObservavel {
    void adicionarObservador(ObservadorTrilha observador);

    void removerObservador(ObservadorTrilha observador);

    void notificarObservadoresDaPublicacao();
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 3 abaixo ilustra a estrutura da classe `SujeitoTrilhaObservavel.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: SujeitoTrilhaObservavel.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/f26dc103e37355c4a69b3203bf7ecf4ade5c0870/docs/PadroesDeProjeto/Imagens/Observer_SujeitoTrilhaObservavel.png" width="1000">
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
package com.galaxiaconectada.trilhas;

// Imports para o padrão Composite
import com.galaxiaconectada.observer.ObservadorTrilha;
import com.galaxiaconectada.observer.SujeitoTrilhaObservavel; // Usado no construtor de Conteudo, que Modulo usa
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class TrilhaEducacional implements ComponenteTrilha, SujeitoTrilhaObservavel {
    private int id;
    private String titulo;
    private String descricao;
    private String nivel; // Ex: "Iniciante", "Intermediário", "Avançado"
    private String categoria; // Ex: "Astronomia Básica", "Cosmologia", "Astrofísica"
    private boolean publicada;
    private String imagemUrl;
    private LocalDateTime dataPublicacao; 
    //A lista agora armazena ComponenteTrilha, que serão os Modulos
    private List<ComponenteTrilha> componentesFilhos;

    // Para o Padrão Observer: lista de Observadores interessados nesta trilha
    private List<ObservadorTrilha> observadores;

    TrilhaEducacional(int id, String titulo, String descricao, String nivel,
                          String categoria, boolean publicadaInicial, String imagemUrl, List<ComponenteTrilha> componentesIniciais) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.categoria = categoria;
        this.publicada = publicadaInicial;
        this.imagemUrl = imagemUrl;
        this.componentesFilhos = componentesIniciais != null ? new ArrayList<>(componentesIniciais) : new ArrayList<>();
        this.observadores = new ArrayList<>(); // Inicializa a lista de observadores
        if (this.publicada) {
            this.dataPublicacao = LocalDateTime.now(); 
        }
    }

    // Implementação de getTitulo() da interface ComponenteTrilha
    @Override
    public String getTitulo() {
        return this.titulo;
    }


    //Exibe as informações desta Trilha Educacional e, recursivamente, de todos os seus componentes filhos (Módulos)

    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Trilha Educacional (ID: " + id + "): " + titulo);
        System.out.println(indentacao + "  Nível: " + nivel + ", Categoria: " + categoria);
        System.out.println(indentacao + "  Descrição: " + descricao);
        System.out.println(indentacao + "  Publicada: " + (publicada ? "Sim" : "Não"));
        if (publicada && dataPublicacao != null) {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss");
            System.out.println(indentacao + "  Data de Publicação: " + dataPublicacao.format(formatador));
        }
        System.out.println(indentacao + "  Imagem: " + (imagemUrl != null && !imagemUrl.isEmpty() ? imagemUrl : "N/A"));

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Esta trilha ainda não possui módulos.");
        } else {
            System.out.println(indentacao + "  Módulos da Trilha (" + componentesFilhos.size() + "):");
            for (ComponenteTrilha componente : componentesFilhos) {
                // Chama o exibirInformacoes de cada filho (que será um Modulo) com uma indentação adicional.
                componente.exibirInformacoes(indentacao + "    ");
            }
        }
    }

     // Implementação dos métodos de gerenciamento de filhos da interface ComponenteTrilha
    @Override
    public void adicionar(ComponenteTrilha componente) {
        // Uma Trilha Educacional, no nosso design, só contém Módulos como filhos diretos.
        if (componente instanceof Modulo) {
            this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO na Trilha '" + titulo + "'] Tentativa de adicionar um tipo de componente inválido. Apenas Módulos são permitidos.");
        }
    }

    @Override
    public void remover(ComponenteTrilha componente) {
        this.componentesFilhos.remove(componente);
    }

    @Override
    public ComponenteTrilha getFilho(int index) {
        if (index >= 0 && index < componentesFilhos.size()) {
            return componentesFilhos.get(index);
        }
        return null;
    }

   
    public boolean publicarTrilha() {
        if (!this.publicada) {
            this.publicada = true;
            this.dataPublicacao = LocalDateTime.now(); // Registra o momento exato da publicação
            System.out.println("\n[TrilhaEducacional] Trilha '" + titulo + "' (ID: " + id + ") foi PUBLICADA AGORA!");
            notificarObservadoresDaPublicacao(); // Dispara a notificação para os observadores
            return true;
        } else {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println("[TrilhaEducacional] Trilha '" + titulo + "' já está publicada desde " +
                               (dataPublicacao != null ? dataPublicacao.format(formatador) : "data desconhecida") + ".");
            return false;
        }
    }

    public float calcularProgressoMedio() {
        System.out.println("[TrilhaEducacional] Calculando progresso médio para: " + titulo);
        return 50.0f; // Exemplo
    }

    @Override
    public synchronized void adicionarObservador(ObservadorTrilha observador) {
        if (observador != null && !observadores.contains(observador)) {
            this.observadores.add(observador);
            System.out.println("[OBSERVER EM '" + titulo + "'] Observador '" + observador.getClass().getSimpleName() + "' foi ADICIONADO.");
        }
    }

    @Override
    public synchronized void removerObservador(ObservadorTrilha observador) {
        if (observador != null) {
            boolean removido = this.observadores.remove(observador);
            if (removido) {
                 System.out.println("[OBSERVER EM '" + titulo + "'] Observador '" + observador.getClass().getSimpleName() + "' foi REMOVIDO.");
            }
        }
    }

    @Override
    public void notificarObservadoresDaPublicacao() {
        // se um observador tentar se remover durante a notificação.
        List<ObservadorTrilha> observadoresParaNotificar = new ArrayList<>(this.observadores);

        if (observadoresParaNotificar.isEmpty()){
            System.out.println("[OBSERVER EM '" + titulo + "'] Nenhum observador registrado para notificar sobre a publicação.");
            return;
        }
        System.out.println("[OBSERVER EM '" + titulo + "'] Notificando " + observadoresParaNotificar.size() + " observador(es) sobre a publicação...");
        for (ObservadorTrilha observador : observadoresParaNotificar) {
            observador.notificarTrilhaPublicada(this); // Passa a própria trilha (this) como contexto
        }
    }

    // Getters existentes
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getNivel() { return nivel; }
    public String getCategoria() { return categoria; }
    public boolean isPublicada() { return publicada; }
    public String getImagemUrl() { return imagemUrl; }
    public LocalDateTime getDataPublicacao() { return dataPublicacao; } 


    public List<ComponenteTrilha> getComponentesFilhos() {
        return new ArrayList<>(componentesFilhos);
    }

    @Override
    public String toString() {
        return "TrilhaEducacional [id=" + id + ", titulo=" + titulo + ", publicada=" + publicada + ", módulos=" + componentesFilhos.size() + "]";
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

As figuras 4,5 e 6  abaixo ilustra a estrutura da classe `TrilhaEducacional.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 4: TrilhaEducacional.java - Parte 1
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/f26dc103e37355c4a69b3203bf7ecf4ade5c0870/docs/PadroesDeProjeto/Imagens/Observer_TrilhaEducacional1.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

<div align="center">
    Figura 5: TrilhaEducacional.java Parte 2
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/f26dc103e37355c4a69b3203bf7ecf4ade5c0870/docs/PadroesDeProjeto/Imagens/Observer_TrilhaEducacional2.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

<div align="center">
    Figura 6: TrilhaEducacional.java Parte 3
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/f26dc103e37355c4a69b3203bf7ecf4ade5c0870/docs/PadroesDeProjeto/Imagens/Observer_TrilhaEducacional3.png" width="1000">
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
package com.galaxiaconectada.observer;

import com.galaxiaconectada.trilhas.TrilhaEducacional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NotificadorPlataforma implements ObservadorTrilha {
    private String nomeDoNotificador;

    public NotificadorPlataforma(String nomeDoNotificador) {
        this.nomeDoNotificador = nomeDoNotificador;
    }

    @Override
    public void notificarTrilhaPublicada(TrilhaEducacional trilhaPublicada) {
        System.out.println("\n--- [OBSERVADOR: " + nomeDoNotificador + "] ---");
        System.out.println("📢 ALERTA GERAL! Nova Trilha Educacional disponível na plataforma!");
        System.out.println("  Título da Trilha: '" + trilhaPublicada.getTitulo() + "' (ID: " + trilhaPublicada.getId() + ")");
        System.out.println("  Categoria: " + trilhaPublicada.getCategoria() + " | Nível: " + trilhaPublicada.getNivel());
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        System.out.println("  Trilha publicada em: " + (trilhaPublicada.getDataPublicacao() != null ? trilhaPublicada.getDataPublicacao().format(formatador) : "Data não informada pela trilha"));
        System.out.println("  Acesse e comece a aprender agora mesmo!");
        System.out.println("--- Fim da Notificação da Plataforma ---");
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 7 abaixo ilustra a estrutura da classe `NotificadorPlataforma.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 7: NotificadorPlataforma.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/f26dc103e37355c4a69b3203bf7ecf4ade5c0870/docs/PadroesDeProjeto/Imagens/Observer_NotificadorPlataforma.png" width="1000">
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
package com.galaxiaconectada.observer;

import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.domain.forum.Forum;
import com.galaxiaconectada.domain.forum.Subforum; 

public class AnunciadorForum implements ObservadorTrilha {
    private Forum forumPrincipal;

    public AnunciadorForum() {
        this.forumPrincipal = Forum.getInstance();
    }

    @Override
    public void notificarTrilhaPublicada(TrilhaEducacional trilhaPublicada) {
        System.out.println("\n--- [OBSERVADOR: AnunciadorForum] ---");
        System.out.println("📰 Nova Trilha para anunciar no Fórum: '" + trilhaPublicada.getTitulo() + "'!");
        System.out.println("  Acessando o Fórum Principal (Instância Singleton: " + forumPrincipal.hashCode() + ")...");

        // Tentativa de criar/usar um subfórum de anúncios
        Subforum subforumDeAnuncios = forumPrincipal.criarSubforum(
                "Anúncios de Novas Trilhas",
                "Fique por dentro das últimas trilhas educacionais lançadas!"
        );

        System.out.println("  Subfórum para anúncio: '" + subforumDeAnuncios.getNome() + "' (ID: " + subforumDeAnuncios.getId() + ")");

        String tituloTopicoAnuncio = "🎉 Nova Trilha Lançada: " + trilhaPublicada.getTitulo();
        String corpoPostAnuncio = "Olá, exploradores da Galáxia Conectada!\n\n" +
                                  "Temos o prazer de anunciar o lançamento da nova trilha educacional: **" + trilhaPublicada.getTitulo() + "**!\n" +
                                  "Descrição: " + trilhaPublicada.getDescricao() + "\n" +
                                  "Nível: " + trilhaPublicada.getNivel() + " | Categoria: " + trilhaPublicada.getCategoria() + "\n\n" +
                                  "Não percam! Acessem e comecem a aprender agora mesmo.\n" +
                                  "Link da Trilha (simulado): /trilhas/" + trilhaPublicada.getId() + "\n\n" +
                                  "Equipe Galáxia Conectada.";

        System.out.println("  Simulando criação de tópico de anúncio no subfórum '" + subforumDeAnuncios.getNome() + "':");
        System.out.println("    Título do Tópico: " + tituloTopicoAnuncio);
        System.out.println("    Corpo da Postagem: \n\"" + corpoPostAnuncio.replaceAll("\n", "\n      ") + "\"");
        System.out.println("--- Fim do Anúncio no Fórum ---");
    }
}

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

### Imagem do Código no VSCode

A figura 8 abaixo ilustra a estrutura da classe `AnunciadorForum.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 8: AnunciadorForum.java
    <br>
    <img src="https://raw.githubusercontent.com/UnBArqDsw2025-1-Turma02/2025.1_T02_G9_GalaxiaConectada_Entrega03/f26dc103e37355c4a69b3203bf7ecf4ade5c0870/docs/PadroesDeProjeto/Imagens/Observer_AnunciadorForum.png" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

</details>


### Demonstração de Uso na AplicacaoGalaxia

Abaixo está o código da aplicação:

<details>
  <summary><strong>Código para `AplicacaoGalaxia.java` </strong></summary>


```java
package com.galaxiaconectada.main;

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
import com.galaxiaconectada.fachadas.PlataformaGalaxiaFacade;
import com.galaxiaconectada.observer.AnunciadorForum;
import com.galaxiaconectada.observer.NotificadorPlataforma;
import com.galaxiaconectada.observer.ObservadorTrilha;
import com.galaxiaconectada.prototipos.Conquista;
import com.galaxiaconectada.prototipos.PrototipoClonavel;
import com.galaxiaconectada.prototipos.RegistroDePrototipos;
import com.galaxiaconectada.trilhas.ModuloBuilder;
import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.trilhas.TrilhaEducacionalBuilder; 
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
                case 6:
                    testarPublicacaoTrilhaViaFacade();
                    break;
                case 7: 
                    testarObserverPublicacaoTrilha();
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
        try {
            Conquista cProto1 = new Conquista(1000, "Pioneiro Intergaláctico", "Primeiro login na plataforma.", "icone_pioneiro.png", 50);
            registroDePrototipos.adicionarPrototipo("CONQUISTA_PIONEIRO", cProto1);
            Conquista cProto2 = new Conquista(1001, "Mestre das Trilhas Nv.1", "Completou sua primeira trilha educacional.", "icone_trilha_nv1.png", 150);
            registroDePrototipos.adicionarPrototipo("CONQUISTA_TRILHA_NV1", cProto2);

            Notificacao nProto1 = new Notificacao(0, "BEM_VINDO_PLATAFORMA", "Olá, [NomeUsuario]! Seja muito bem-vindo(a) à Galáxia Conectada!", "/painel");
            registroDePrototipos.adicionarPrototipo("NOTIFICACAO_BEM_VINDO", nProto1);
            Notificacao nProto2 = new Notificacao(0, "NOVA_CONQUISTA_GERAL", "Parabéns, [NomeUsuario]! Você desbloqueou: [NomeConquista]!", "/perfil/conquistas");
            registroDePrototipos.adicionarPrototipo("NOTIFICACAO_CONQUISTA", nProto2);
            Notificacao nProtoTrilha = new Notificacao(0, "NOVA_TRILHA_LANCADA", "A trilha '[NOME_TRILHA]' foi lançada por [NOME_INSTRUTOR]! Confira!", "/trilhas/[ID_TRILHA]");
            registroDePrototipos.adicionarPrototipo("NOTIFICACAO_NOVA_TRILHA", nProtoTrilha);

            System.out.println("[SISTEMA] Protótipos carregados com sucesso!");
        } catch (Exception e) {
            System.err.println("[ERRO NO CARREGAMENTO DE PROTÓTIPOS] Verifique se as classes Conquista e Notificacao estão nos pacotes corretos (com.galaxiaconectada.prototipos) e compilando.");
            // e.printStackTrace(); 
        }
    }

    public static void exibirMenuPrincipalGeral() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Gerenciar Publicação de Conteúdo (Factory Method)");
        System.out.println("2. Gerenciar Usuários e Papéis (Factory Method)");
        System.out.println("3. Criar Nova Trilha Educacional (Builder + Composite)");
        System.out.println("4. Testar Padrão Prototype (Clonagem)");
        System.out.println("5. Acessar Fórum Principal (Singleton)");
        System.out.println("6. Publicar Trilha Completa (via Facade)");
        System.out.println("7. Publicar Trilha e Notificar (Observer)"); 
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
                ComponenteTrilha novoConteudoComoComponente = criarConteudoInterativoParaModulo();
                if (novoConteudoComoComponente != null) {
                    moduloBuilder.adicionarComponente(novoConteudoComoComponente);
                    System.out.println("  [BUILDER MÓDULO] Conteúdo '" + novoConteudoComoComponente.getTitulo() + "' (Tipo: " + novoConteudoComoComponente.getClass().getSimpleName() + ") adicionado.");
                }
            }
            ComponenteTrilha moduloConstruido = moduloBuilder.build();
            trilhaBuilder.adicionarComponente(moduloConstruido);
            System.out.println("[BUILDER TRILHA] Módulo '" + moduloConstruido.getTitulo() + "' adicionado à trilha.");
        }
        System.out.println("\n[BUILDER TRILHA] Construindo Trilha Educacional...");
        TrilhaEducacional trilhaFinal = trilhaBuilder.build();
        trilhasCriadas.add(trilhaFinal);
        System.out.println("\n🎉 Trilha Educacional '" + trilhaFinal.getTitulo() + "' criada com sucesso! 🎉");
        System.out.println("\n--- Exibindo Estrutura da Trilha (Padrão Composite) ---");
        trilhaFinal.exibirInformacoes("");
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
                    System.out.print("Nome do novo Subfórum: "); String nomeSub = scanner.nextLine();
                    System.out.print("Descrição do Subfórum: "); String descSub = scanner.nextLine();
                    Subforum novoSub = forumPrincipal.criarSubforum(nomeSub, descSub);
                    System.out.println("Subfórum '" + (novoSub != null ? novoSub.getNome() : "N/A") + "' criado com sucesso!");
                    break;
                case 2:
                    List<Subforum> subforums = forumPrincipal.listarSubforums();
                    if (subforums.isEmpty()) { System.out.println("Nenhum subfórum para listar."); }
                    else { System.out.println("\n--- Subfóruns Existentes ---"); for (Subforum sf : subforums) { sf.exibirDetalhes(); } }
                    break;
                case 0: continuarNoMenuForum = false; System.out.println("\n[SISTEMA] Voltando ao Menu Principal..."); break;
                default: System.out.println("[ERRO] Opção inválida no menu do fórum.");
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
                    instrutor = u; break;
                }
            }
            if (instrutor == null && !usuariosCadastrados.isEmpty()) instrutor = usuariosCadastrados.get(0);
        }
        if (instrutor == null) {
            System.out.println("[INFO] Crie um usuário e atribua o papel de Instrutor para um teste completo, ou um usuário padrão será usado.");
            instrutor = new Usuario(999, "Instrutor Facade Padrão", "instrutor.facade@galaxia.com", "senha123");
        }
        System.out.println("Publicando trilha como Instrutor: " + instrutor.getNome());

        System.out.println("\n--- Dados para a Nova Trilha (via Facade) ---");
        System.out.print("ID da Trilha: "); int idTrilha = lerOpcaoDoUsuarioNumerica();
        System.out.print("Título da Trilha: "); String tituloTrilha = scanner.nextLine();
        System.out.print("Descrição da Trilha: "); String descTrilha = scanner.nextLine();
        System.out.print("Categoria da Trilha: "); String catTrilha = scanner.nextLine();
        System.out.print("Nível da Trilha: "); String nivTrilha = scanner.nextLine();
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
    
    // ---- NOVA SEÇÃO PARA TESTAR OBSERVER ----
    public static void testarObserverPublicacaoTrilha() {
        System.out.println("\n========= TESTANDO PADRÃO OBSERVER (Publicação de Trilha) =========");

        System.out.println("\n[TESTE OBSERVER] Criando uma Trilha Educacional de exemplo...");
        TrilhaEducacionalBuilder builderTrilhaObservavel = new TrilhaEducacionalBuilder(801, "Dominando o Padrão Observer");
        builderTrilhaObservavel.comDescricao("Aprenda como o padrão Observer funciona na prática.")
                               .comCategoria("Padrões de Projeto")
                               .comNivel("Avançado")
                               .definirComoPublicada(false); // Começa como não publicada

        ModuloBuilder moduloObsBuilder = new ModuloBuilder(80101, "Conceitos Chave do Observer");
        // Configura uma fábrica de conteúdo
        if (fabricaDeConteudoAtual == null) { 
            configurarFabricaDeConteudo("ARTIGO");
        }
        Map<String, Object> detalhesArtigoObs = new HashMap<>();
        detalhesArtigoObs.put("textoHtml", "<p>O padrão Observer é crucial para sistemas reativos...</p>");
        detalhesArtigoObs.put("fonte", "Livro Clássico de Padrões");
        Conteudo artigoObs = fabricaDeConteudoAtual.criarConteudo(8010101, "Introdução ao Observer", "O que é e por que usar.", TipoVisibilidade.PUBLICO, detalhesArtigoObs);
        
        if(artigoObs instanceof ComponenteTrilha) {
            moduloObsBuilder.adicionarComponente((ComponenteTrilha) artigoObs);
        }
        
        builderTrilhaObservavel.adicionarComponente(moduloObsBuilder.build());
        
        TrilhaEducacional trilhaObservavel = builderTrilhaObservavel.build();
        System.out.println("Trilha '" + trilhaObservavel.getTitulo() + "' criada. Status Publicada: " + trilhaObservavel.isPublicada());
        System.out.println("Estrutura inicial da trilha:");
        trilhaObservavel.exibirInformacoes("  ");

        System.out.println("\n[TESTE OBSERVER] Criando e registrando observadores...");
        ObservadorTrilha notificadorDaPlataforma = new NotificadorPlataforma("CentralDeAlertasGalacticos");
        ObservadorTrilha anuncianteDoForum = new AnunciadorForum();

        trilhaObservavel.adicionarObservador(notificadorDaPlataforma);
        trilhaObservavel.adicionarObservador(anuncianteDoForum);

        System.out.println("\n[TESTE OBSERVER] Solicitando a publicação da trilha '" + trilhaObservavel.getTitulo() + "'...");
        System.out.println("   ↳ Observadores devem ser notificados AGORA!");
        trilhaObservavel.publicarTrilha(); 

        System.out.println("\n[TESTE OBSERVER] Status final da Trilha: Publicada = " + trilhaObservavel.isPublicada());

        System.out.println("\n[TESTE OBSERVER] Removendo 'NotificadorPlataforma' da lista de observadores...");
        trilhaObservavel.removerObservador(notificadorDaPlataforma);

        System.out.println("[TESTE OBSERVER] Tentando publicar a trilha novamente (já está publicada, não deve notificar)...");
        trilhaObservavel.publicarTrilha(); 
        
        System.out.println("\n==================================================================");
    }

} 

```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

</details>

## Conclusão

A implementação do padrão de projeto comportamental **Observer** para o gerenciamento de notificações após a publicação de uma `TrilhaEducacional` na plataforma "Galáxia Conectada" demonstrou ser uma solução arquitetural eficaz e elegante. Ao estabelecer uma clara separação entre o objeto que origina o evento (o "Sujeito", representado pela `TrilhaEducacional`) e os objetos que precisam reagir a esse evento (os "Observadores", como `NotificadorPlataforma` e `AnunciadorForum`), o padrão promoveu um design significativamente mais desacoplado e flexível.

O principal benefício observado foi a capacidade de adicionar ou modificar comportamentos de reação à publicação de trilhas sem a necessidade de alterar a classe `TrilhaEducacional`. 


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
