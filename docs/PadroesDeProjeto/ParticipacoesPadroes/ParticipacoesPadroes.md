# Participações - Padrões de Projeto

## Introdução

Este documento detalha as contribuições realizadas para a implementação e documentação dos Padrões de Projeto GoF (Criacionais, Estruturais e Comportamentais) no âmbito do projeto "Galáxia Conectada". Sendo este um projeto desenvolvido individualmente por Larissa Stéfane, todas as atividades de estudo, análise, design, implementação, teste e documentação dos padrões foram conduzidas pela mesma.


## Padrão GoF Criacional

A tabela a seguir resume as contribuições referentes aos Padrões de Projeto Criacionais aplicados ao sistema "Galáxia Conectada".

| Nome do Membro  | Contribuição (Padrões Criacionais)                                                                                                                                                                                                                                                           | Significância da Contribuição para o Projeto | Comprobatórios Claros (com link)                                                                                                                                                                       |
| :-------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Larissa Stéfane | 1. **Factory Method:** Estudo, modelagem UML, implementação em Java para a criação flexível de diferentes tipos de `Conteudo` (Artigo, Vídeo, Quiz, Jogo) e de `PapelUsuario` (Aluno, Instrutor, etc.), e documentação detalhada do processo. <br> 2. **Builder:** Análise, modelagem UML, implementação em Java para a construção passo a passo de objetos complexos como `Modulo` e `TrilhaEducacional`, e respectiva documentação. <br> 3. **Prototype:** Pesquisa, modelagem UML, implementação em Java para a clonagem de objetos `Conquista` e `Notificacao` (utilizando um `RegistroDePrototipos`), e documentação completa. <br> 4. **Singleton:** Estudo, modelagem UML, implementação em Java para garantir uma instância única da classe `Forum`, e documentação do padrão e sua aplicação. | Excelente                                    | 1. Documento do Factory Method: [3.1.1 Factory Method](/PadroesDeProjeto/GoFsCriacionais/FactoryMethod.md) <br> 2. Documento do Builder: [3.1.2 Builder](/PadroesDeProjeto/GoFsCriacionais/Builder.md) <br> 3. Documento do Prototype: [3.1.3 Prototype](/PadroesDeProjeto/GoFsCriacionais/Prototype.md) <br> 4. Documento do Singleton: [3.1.4 Singleton](/PadroesDeProjeto/GoFsCriacionais/Singleton.md) <br> Código Fonte: [3.1.5 Código Fonte Criacional](/PadroesDeProjeto/GoFsCriacionais/CriacionalCodigoHospedado.md) |

<b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

## Padrão GoF Estrutural

A tabela a seguir resume as contribuições referentes aos Padrões de Projeto Estruturais aplicados ao sistema "Galáxia Conectada".

| Nome do Membro  | Contribuição (Padrões Estruturais)                                                                                                                                                                                                                                                        | Significância da Contribuição para o Projeto | Comprobatórios Claros (com link)                                                                                                                                                                      |
| :-------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Larissa Stéfane | 1. **Composite:** Estudo aprofundado, modelagem UML, implementação em Java para tratar uniformemente a hierarquia `TrilhaEducacional` -> `Modulo` -> `Conteudo` através da interface `ComponenteTrilha`, e documentação detalhada. <br> 2. **Facade:** Análise da complexidade de interação entre subsistemas, modelagem UML, implementação da `PlataformaGalaxiaFacade` para simplificar operações como a publicação completa de trilhas (envolvendo builders, factories, prototypes e singletons), e respectiva documentação. | Excelente                                    | 1. Documento do Composite: [3.2.1 Composite](/PadroesDeProjeto/GoFsEstruturais/Composite.md) <br> 2. Documento do Facade: [3.2.2 Facade](/PadroesDeProjeto/GoFsEstruturais/Facade.md) <br> Código Fonte: [3.2.3 Código Fonte Estrutural](/PadroesDeProjeto/GoFsEstruturais/EstruturaCodigoFonte.md) |

<b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

## Padrão GoF Comportamental

A tabela a seguir resume as contribuições referentes aos Padrões de Projeto Comportamentais aplicados ao sistema "Galáxia Conectada".

| Nome do Membro  | Contribuição (Padrões Comportamentais)                                                                                                                                                                                                                | Significância da Contribuição para o Projeto | Comprobatórios Claros (com link)                                                                                                                                                                                 |
| :-------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Larissa Stéfane | 1. **Observer:** Estudo, modelagem UML, implementação em Java para notificar componentes interessados (ex: `NotificadorPlataforma`, `AnunciadorForum`) sobre a publicação de uma `TrilhaEducacional`, e documentação completa do processo e aplicação. | Excelente                                    | 1. Documento do Observer: [3.3.1 Observer](/PadroesDeProjeto/GoFsComportamentais/Observer.md) <br> Código Fonte: [3.3.2 Código Fonte Comportamental](/PadroesDeProjeto/GoFsComportamentais/ComportamentalCodigoFonte.md) |

<b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

