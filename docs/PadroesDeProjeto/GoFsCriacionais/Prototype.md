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



## Objetivo


O principal objetivo da aplicação do padrão Prototype no projeto "Galáxia Conectada" é fornecer um mecanismo eficiente e flexível para a criação de novas instâncias de objetos `Conquista` e `Notificacao`. Busca-se com isso:
* Reduzir o acoplamento, permitindo que o sistema crie novos objetos sem conhecer suas classes concretas em tempo de compilação (apenas o protótipo).
* Melhorar a performance em cenários onde a instanciação direta é custosa, aproveitando a clonagem de objetos pré-configurados.
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


## Desenvolvimento e Implementação


## Modelagem do Prototype Para Notificações


## Modelagem do Prototype Para Conquistas


## Definição da Interface de Clonagem


### Interface PrototipoClonavel


## Implementação dos Protótipos Concretos


### Classe Conquista como Protótipo


### Classe Notificacao como Protótipo


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
