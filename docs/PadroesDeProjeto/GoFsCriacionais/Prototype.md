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

```


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


```


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

```


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

## Classe RegistroDePrototipos

## Classe de Teste AplicacaoGalaxia

## Conclusão

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
