# Padrão Criacional Builder


## Sumário

- [Introdução](#introdução)
- [Objetivo](#objetivo)
- [Metodologia](#metodologia)
- [Desenvolvimento e Implementação](#desenvolvimento-e-implementação)

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
