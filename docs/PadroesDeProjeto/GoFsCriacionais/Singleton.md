# Padrão Criacional Singleton

## Sumário

- [Introdução](#Introducao)
- [Objetivo](#Objetivo)
- [Metodologia](#Metodologia)
- [Desenvolvimento e Implementação](#Desenvolvimento-e-Implementação)
- [Modelagem do SIngleton para o Fórum](#Modelagem-do-Singleton-para-o-Fórum)
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


## Desenvolvimento e Implementação


## Modelagem do SIngleton para o Fórum


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
