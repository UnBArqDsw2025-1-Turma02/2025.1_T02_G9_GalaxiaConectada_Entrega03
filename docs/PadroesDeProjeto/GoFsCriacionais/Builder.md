# Padrão Criacional Builder


## Sumário

- [Introdução](#introdução)
- [Objetivo](#objetivo)
- [Metodologia](#metodologia)
- [Desenvolvimento e Implementação](#desenvolvimento-e-implementação)
- [Modelagem do Builder Para Módulo](#Modelagem-do-Builder-Para-Módulo)
- [Builder para a Classe Modulo](#Builder-para-a-Classe-Modulo)
  - [Classe Produto Modulo](#Classe-Produto-Modulo)
  - [Classe Builder ModuloBuilder](#Classe-Builder-ModuloBuilder)
- [Modelagem do Builder Para Trilhas de Aprendizado](#Modelagem-do-Builder-Para-Trilhas-de-Aprendizado)
- [Builder para a Classe TrilhaEducacional](#Builder-para-a-Classe-TrilhaEducacional)
  -  [Classe Produto TrilhaEducacional](#Classe-Produto-TrilhaEducacional)
  -  [Classe Builder TrilhaEducacionalBuilder](#Classe-Builder-TrilhaEducacionalBuilder)
- [Classe de Teste AplicacaoGalaxia](#Classe-de-Teste-AplicacaoGalaxia)
- [Conclusão](#conclusão)
- [Bibliografia](#bibliografia)
- [Histórico de Versão](#histórico-de-versão)



## Introdução

O padrão de projeto Builder (ou Construtor), como é explicado em [Builder](https://refactoring.guru/pt-br/design-patterns/builder), é uma solução criacional voltada à construção de objetos complexos de forma controlada e passo a passo. Com isso, é útil quando a criação de um objeto envolve múltiplas etapas, configurações variáveis ou combinações de atributos que, se implementadas diretamente em um único construtor, levariam a códigos longos, difíceis de manter e pouco legíveis. Portanto, como também é explicado em [Design Patterns — Parte 6 — Builder](https://medium.com/@jonesroberto/desing-patterns-parte-6-builder-f20752fb0c35), com o Builder, o processo de construção é desacoplado da representação final do objeto e permite criar variações com o mesmo fluxo de construção.

No contexto deste projeto, foi escolhido por aplicar o padrão Builder tanto na criação de **Módulos (agrupamentos de conteúdos elaborados por professores voluntários ou instrutores)** quanto na construção das **Trilhas de Aprendizado (conjuntos de módulos organizados com base em um tema ou objetivo educacional)**. A escolha se deu devido à natureza progressiva e configurável dessas estruturas, que podem conter diferentes quantidades de conteúdo, descrições, critérios de acesso e integrações com outras áreas da plataforma. 

## Objetivo

Ao compreender a função do Builder, ao utilizá-lo para implementar os **conteúdos e as trilhas de aprendizado**, busca-se estruturar a criação desses elementos de forma modular, o que permite combinar diferentes tipos de conteúdos, atividades e níveis de dificuldade conforme as necessidades de cada usuário ou percurso educacional. 

**Principais objetivos do uso do padrão Builder nesse contexto, com base em [Builder](https://refactoring.guru/pt-br/design-patterns/builder) e em [O que é o padrão Builder? Java/Spring Boot](https://www.dio.me/articles/o-que-e-o-padrao-builder-javaspring-boot):**

- Montar trilhas de aprendizado com diferentes combinações de conteúdo.

- Separar a lógica de construção da lógica de representação.

- Facilitar a adição, modificação ou remoção de etapas das trilhas, sem impactar outras partes do sistema.

- Evitar o uso de grandes construtores ou métodos complexos.
  
- Melhorar a manutenção e escalabilidade da plataforma, com foco em flexibilidade e reutilização de componentes.

- Tornar os testes mais simples, ao possibilitar a criação de trilhas com apenas os elementos necessários para cada cenário.

## Metodologia

O padrão **Builder**, como já foi explicado, é um padrão de projeto criacional que separa o processo de construção de um objeto complexo de sua representação final. Isso permite que o mesmo processo de construção possa criar diferentes representações do objeto. Com isso, a metodologia para o seu desenvolvimento se baseou em:

**Principais Componentes do Padrão Builder Aplicado, com base em [Design Patterns — Parte 6 — Builder](https://medium.com/@jonesroberto/desing-patterns-parte-6-builder-f20752fb0c35):**

* **Product (Produto):** O objeto complexo que está sendo construído. No caso, são as classes `Modulo` e `TrilhaEducacional`.
* **ConcreteBuilder (Construtor Concreto):** Implementa a interface do Builder (ou é a classe Builder em si) e mantém o controle da representação do produto que está sendo construído. Ele fornece métodos para construir as partes do produto e um método para retornar o produto finalizado. Exemplos: `ModuloBuilder` e `TrilhaEducacionalBuilder`.
* **Director (Diretor):** Uma classe que controla o algoritmo de construção ao usar a interface do Builder. 


**A concepção das classes de produto (`Modulo`, `TrilhaEducacional`) e suas inter-relações serão guiadas por diagrama previamente elaborados para o projeto:**

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).
* **Diagrama de Classes de Componentes:** [Diagrama de Componentes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaComponentes).
* **Diagrama de Pacotes:** [Diagrama de Pacotes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaPacotes).

* **Diagrama de Classes de Referência:** [Diagrama de Classes - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemEstatica/DiagramaClasses).
  
* **Diagrama de Casos de Uso:** [Diagrama de Casos de Uso - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemOrganizacional/DiagramaCasosUso).

* **Diagrama de Atividades:** [Diagrama de Atividades - Galáxia Conectada](https://unbarqdsw2025-1-turma02.github.io/2025.1_T02_G9_GalaxiaConectada_Entrega02/#/Modelagem/ModelagemDinamica/DiagramaAtividades).


**Passo a passo de desenvolvimento para o padrão Builder no projeto "Galáxia Conectada":**

1. Identificação e Definição das Classes "Produto";
2. Criação das Classes "Construtoras Concretas" (Builders);
3. Implementação de Métodos de Configuração Fluentes;
4. Desenvolvimento do Método de Construção Final (build());
5. Integração dos Builders na classe AplicacaoGalaxia.java 


## Desenvolvimento e Implementação

A seguir, são apresentadas as classes envolvidas na implementação do padrão Builder para `Modulo` e `TrilhaEducacional`, os quais foram desenvolvidos ao utilizar o o [**Visual Studio Code (VSCode)**](https://code.visualstudio.com/) como IDE principal.


## Modelagem do Builder Para Módulo

A figura 1 abaixo mostra a modelagem do campo Módulo


### Classe Produto Modulo

A classe `Modulo` é um componente que funciona como um contêiner temático que agrupa e organiza diversos objetos `Conteudo` (como artigos, vídeos, quizzes e jogos) sobre um tema dentro do escopo maior de uma `TrilhaEducacional`. Isso porque, ao segmentar o aprendizado em módulos, facilita-se a progressão do usuário e a organização do material didático.

 Cada `Modulo` é caracterizado por um identificador único (`id`), um `titulo` descritivo, uma `ordem` de apresentação dentro da trilha, uma `descricaoBreve` e, crucialmente, a coleção de `Conteudo`s que o compõem. 

Abaixo o código para `Modulo.java` 

```


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.


##### Imagem do código no VSCODE

A figura 2 abaixo ilustra a estrutura da classe `Modulo.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 2: Classe Produto Modulo.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


### Classe Builder ModuloBuilder

O ModuloBuilder tem como objetivo principal simplificar e tornar mais robusto e legível o processo de criação de instâncias da classe Modulo. 
- Dado que um módulo é definido por vários atributos (ID, título, ordem, descrição) e pode conter uma lista variável de Conteudos, o ModuloBuilder oferece uma interface fluente.

Abaixo o código para `ModuloBuilder.java` 

```


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 3 abaixo ilustra a estrutura da classe `ModuloBuilder.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 3: Classe ModuloBuilder.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>


## Modelagem do Builder Para Trilhas de Aprendizado

A figura 4 abaixo mostra a modelagem do campo Trilhas de Aprendizado



### Classe Produto TrilhaEducacional

A TrilhaEducacional é a entidade central que organiza e define um percurso de aprendizado completo e estruturado dentro da plataforma "Galáxia Conectada". Dessa maneira, o objetivo principal é guiar o usuário através de uma sequência lógica e progressiva de Modulos, cada um focado em subtemas ou habilidades específicas. 
- Além de agregar a coleção ordenada de Modulos, a TrilhaEducacional armazena metadados cruciais como seu id único, titulo principal, descricao detalhada, nivel de dificuldade (ex: Iniciante, Avançado), categoria temática, status de publicada e uma imagemUrl representativa. 

Abaixo o código para `TrilhaEducacional.java` 

```


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 5 abaixo ilustra a estrutura da classe `TrilhaEducacional.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 5:  Classe Produto TrilhaEducacional.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

### Builder para a Classe TrilhaEducacional

A TrilhaEducacionalBuilder é a classe designada para orquestrar e simplificar a construção de objetos TrilhaEducacional, por isso, o seu principal objetivo é fornecer uma API clara, intuitiva e fluente para montar uma trilha passo a passo ao configurar seus diversos atributos (como título, descrição, nível, categoria) e agregar os Modulos que a compõem (os quais podem ser, por sua vez, construídos usando o ModuloBuilder). 

Abaixo o código para `TrilhaEducacionalBuilder.java` 

```


```

<b> Autora: </b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

##### Imagem do código no VSCODE

A figura 6 abaixo ilustra a estrutura da classe `TrilhaEducacionalBuilder.java` no ambiente de desenvolvimento VSCode.

<div align="center">
    Figura 6: Classe TrilhaEducacionalBuilder.java
    <br>
    <img src="" width="1000">
    <br>
    <b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.
    <br>
</div>

## Classe de Teste AplicacaoGalaxia

Para testar as classes e os códigos, foi criada uma main chamada AplicacaoGalaxia. O código dela se encontra abaixo:


## Conclusão

A aplicação do padrão Builder para a construção dos objetos Modulo e TrilhaEducacional no projeto "Galáxia Conectada" demonstrou ser uma estratégia eficaz para lidar com a complexidade inerente à criação desses objetos compostos. Com isso, o uso de uma interface fluente nos Builders (ModuloBuilder e TrilhaEducacionalBuilder) tornou o processo de instanciação mais legível, passo a passo e menos propenso a erros, especialmente quando comparado a construtores com um grande número de parâmetros.

## Bibliografia 

<a name="ref1"></a>
[1] DEV.MEDIA. Design Patterns: aplicando os padrões Builder, Singleton e Prototype. Disponível em: https://www.devmedia.com.br/design-patterns-aplicando-os-padroes-builder-singleton-e-prototype/31023. Acesso em: 23 maio 2025.

<a name="ref2"></a>
[2] DIO.ME. O que é o padrão Builder? Java/Spring Boot. Disponível em: https://www.dio.me/articles/o-que-e-o-padrao-builder-javaspring-boot. Acesso em: 23 maio 2025.

<a name="ref3"></a>
[3] Nuzzi, J. R. Design Patterns — Parte 6 — Builder. Medium, 30 out. 2019. Disponível em: https://medium.com/@jonesroberto/desing-patterns-parte-6-builder-f20752fb0c35. Acesso em: 23 maio 2025.

<a name="ref4"></a>
[4] REFACTORING.GURU. Builder – Também conhecido como: Construtor. Disponível em: https://refactoring.guru/pt-br/design-patterns/builder. Acesso em: 23 maio 2025.

<a name="ref5"></a>
[5] SUPERVIZ. Design Pattern #7 - Builder Pattern. Dev.to. Disponível em: https://dev.to/superviz/design-pattern-7-builder-pattern-10j4. Acesso em: 23 maio 2025.


## Histórico de versão

| Versão | Alteração | Responsável | Data |
| - | - | - | - |
| 1.0 | Elaboração do documento| Larissa Stéfane | 23/05/2025 |
| 1.1 | Elaboração do da estrutura dos códigos | Larissa Stéfane | 23/05/2025 |
