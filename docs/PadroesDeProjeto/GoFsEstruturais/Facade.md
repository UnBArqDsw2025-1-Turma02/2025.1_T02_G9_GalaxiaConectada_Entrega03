# Padrão Estrutural Facade

## Sumário

- [Introdução](#Introdução)
- [Objetivo](#Objetivo)
- [Metodologia: O Padrão Facade](#Metodologia-O-Padrão-Facade)
  - [Definição e Participantes do Padrão Facade](#Definição-e-Participantes-do-Padrão-Facade)
  - [Aplicação no Contexto do Projeto](#Aplicação-no-Contexto-do-Projeto)
- [Desenvolvimento e Implementação da `PlataformaGalaxiaFacade`](#Desenvolvimento-e-Implementação-da-PlataformaGalaxiaFacade)
  - [Modelagem UML do Padrão Facade](#Modelagem-UML-do-Padrão-Facade)
  - [A Classe Facade: `PlataformaGalaxiaFacade.java`](#A-Classe-Facade-PlataformaGalaxiaFacadejava)
    - [Descrição, Objetivos e Responsabilidades](#Descrição-Objetivos-e-Responsabilidades)
    - [Atributos e Construtor (Gerenciamento de Dependências dos Subsistemas)](#Atributos-e-Construtor-Gerenciamento-de-Dependências-dos-Subsistemas)
    - [Método de Fachada Principal: `instrutorCriaPublicaTrilhaSimples()`](#Método-de-Fachada-Principal-instrutorCriaPublicaTrilhaSimples)
    - [Código da Classe `PlataformaGalaxiaFacade.java`](#Código-da-Classe-PlataformaGalaxiaFacadejava)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode)
  - [Interação da Facade com os Subsistemas](#Interação-da-Facade-com-os-Subsistemas)
    - [Coordenação da Criação de Trilhas (uso de Builders e Fábricas de Conteúdo)](#Coordenação-da-Criação-de-Trilhas-uso-de-Builders-e-Fábricas-de-Conteúdo)
    - [Geração de Notificações (uso de Prototypes e Registro)](#Geração-de-Notificações-uso-de-Prototypes-e-Registro)
    - [Interação com o Fórum (uso do Singleton)](#Interação-com-o-Fórum-uso-do-Singleton)
  - [Utilização da Facade pelo Cliente: `AplicacaoGalaxia.java`](#Utilização-da-Facade-pelo-Cliente-AplicacaoGalaxiajava)
    - [Descrição da Interação do Cliente com a Facade](#Descrição-da-Interação-do-Cliente-com-a-Facade)
    - [Código Relevante da Classe `AplicacaoGalaxia.java`](#Código-Relevante-da-Classe-AplicacaoGalaxiajava)
    - [Imagem do Código no VSCode](#Imagem-do-Código-no-VSCode-1)
    - [Vídeo da Execução Demonstrando a Facade](#Vídeo-da-Execução-Demonstrando-a-Facade)
- [Vantagens da Utilização da Facade no Projeto](#Vantagens-da-Utilização-da-Facade-no-Projeto)
- [Conclusão](#Conclusão)
- [Referências](#Referências)
- [Histórico de Versão](#Histórico-de-Versão)


## Introdução



## Objetivo

## Metodologia: O Padrão Facade

### Definição e Participantes do Padrão Facade

### Aplicação no Contexto do Projeto

## Desenvolvimento e Implementação da `PlataformaGalaxiaFacade`

### Modelagem UML do Padrão Facade

### A Classe Facade: `PlataformaGalaxiaFacade.java`

#### Descrição, Objetivos e Responsabilidades

#### Atributos e Construtor (Gerenciamento de Dependências dos Subsistemas)

#### Método de Fachada Principal: `instrutorCriaPublicaTrilhaSimples()`

#### Código da Classe `PlataformaGalaxiaFacade.java`

#### Imagem do Código no VSCode

### Interação da Facade com os Subsistemas

#### Coordenação da Criação de Trilhas (uso de Builders e Fábricas de Conteúdo)

#### Geração de Notificações (uso de Prototypes e Registro)

#### Interação com o Fórum (uso do Singleton)

### Utilização da Facade pelo Cliente: `AplicacaoGalaxia.java`

#### Descrição da Interação do Cliente com a Facade

#### Código Relevante da Classe `AplicacaoGalaxia.java`

#### Imagem do Código no VSCode

#### Vídeo da Execução Demonstrando a Facade

## Vantagens da Utilização da Facade no Projeto

## Conclusão

## Referências

## Histórico de Versão

