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

### Implementação a Classe Forum


### Classe Auxiliar Subforum


## Classe de Teste AplicacaoGalaxia


## Discussão Vantagens e Desvantagens do Singleton


## Conclusão


## Referências

[1] ELEMAR JR. Padrão de design Singleton: Implementação e Exemplos de Uso. Clube de Estudos, [s.d.]. Disponível em: https://elemarjr.com/clube-de-estudos/artigos/padrao-de-design-singleton-implementacao-e-exemplos-de-uso/. Acesso em: 26 maio 2025.

[2] DEVMEDIA. Padrão de Projeto Singleton em Java. DevMedia, [s.d.]. Disponível em: https://www.devmedia.com.br/padrao-de-projeto-singleton-em-java/26392. Acesso em: 27 maio 2025.

[3] REFACTORING GURU. Singleton. Refactoring.Guru, [s.d.]. Disponível em: https://refactoring.guru/pt-br/design-patterns/singleton. Acesso em: 26 maio 2025.

[4] THIENGO, Vinícius. Padrão de Projeto: Singleton. Thiengo, [s.d.]. Disponível em: https://www.thiengo.com.br/padrao-de-projeto-singleton. Acesso em: 27 maio 2025.


## Histórico de Versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 26/05/2025 |
