# Participações - Padrões de Projeto

## Introdução

Este documento detalha as contribuições realizadas para a implementação e documentação dos Padrões de Projeto GoF (Criacionais, Estruturais e Comportamentais) no âmbito do projeto "Galáxia Conectada". Sendo este um projeto desenvolvido individualmente por Larissa Stéfane, todas as atividades de estudo, análise, design, implementação, teste e documentação dos padrões foram conduzidas pela mesma.


## Padrão GoF Criacional

A tabela a seguir resume as contribuições referentes aos Padrões de Projeto Criacionais aplicados ao sistema "Galáxia Conectada".


| Nome do Membro  | Contribuição Específica (Padrão Criacional)                                                                                                                                 | Significância da Contribuição para o Projeto | Comprobatórios Claros (com link)                                                                                                   |
| :-------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------- |
| Larissa Stéfane | **Factory Method:** Estudo aprofundado, planejamento da aplicação, modelagem UML, implementação em Java para a criação flexível de objetos `Conteudo` e `PapelUsuario`, e documentação completa do padrão. | Excelente                                    | Documento: [3.1.1 Factory Method](/PadroesDeProjeto/GoFsCriacionais/FactoryMethod.md) <br> Código: [Fonte Criacional](/PadroesDeProjeto/GoFsCriacionais/CriacionalCodigoHospedado.md) |
| Larissa Stéfane | **Builder:** Análise de aplicabilidade, modelagem UML, implementação em Java para a construção passo a passo e configuração de objetos complexos como `Modulo` e `TrilhaEducacional`, e documentação detalhada. | Excelente                                    | Documento: [3.1.2 Builder](/PadroesDeProjeto/GoFsCriacionais/Builder.md) <br> Código: [Fonte Criacional](/PadroesDeProjeto/GoFsCriacionais/CriacionalCodigoHospedado.md)             |
| Larissa Stéfane | **Prototype:** Pesquisa sobre o padrão, modelagem UML, implementação em Java para permitir a clonagem eficiente de objetos `Conquista` e `Notificacao` (incluindo `RegistroDePrototipos`), e documentação do processo. | Excelente                                    | Documento: [3.1.3 Prototype](/PadroesDeProjeto/GoFsCriacionais/Prototype.md) <br> Código: [Fonte Criacional](/PadroesDeProjeto/GoFsCriacionais/CriacionalCodigoHospedado.md)         |
| Larissa Stéfane | **Singleton:** Estudo do padrão e suas implicações, modelagem UML, implementação em Java para garantir uma instância única da classe `Forum`, e documentação da aplicação e suas considerações. | Excelente                                    | Documento: [3.1.4 Singleton](/PadroesDeProjeto/GoFsCriacionais/Singleton.md) <br> Código: [Fonte Criacional](/PadroesDeProjeto/GoFsCriacionais/CriacionalCodigoHospedado.md)         |


<b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

## Padrão GoF Estrutural

A tabela a seguir resume as contribuições referentes aos Padrões de Projeto Estruturais aplicados ao sistema "Galáxia Conectada".

| Nome do Membro  | Contribuição Específica (Padrão Estrutural)                                                                                                                                     | Significância da Contribuição para o Projeto | Comprobatórios Claros (com link)                                                                                                                                                                  |
| :-------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ | :------------------------------------------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| Larissa Stéfane | **Composite:** Estudo aprofundado do padrão, modelagem UML, implementação em Java da interface `ComponenteTrilha` e adaptação das classes `Conteudo`, `Modulo` e `TrilhaEducacional` para tratar objetos individuais e composições de forma uniforme, e documentação detalhada. | Excelente                                    | Documento: [3.2.1 Composite](/PadroesDeProjeto/GoFsEstruturais/Composite.md) <br> Código: [Fonte Estrutural](/PadroesDeProjeto/GoFsEstruturais/EstruturaCodigoFonte.md)                      |
| Larissa Stéfane | **Facade:** Análise da necessidade de simplificação de interações complexas, modelagem UML, implementação da classe `PlataformaGalaxiaFacade` para orquestrar operações envolvendo múltiplos subsistemas (Builders, Factories, Prototypes, Singleton), e documentação da solução. | Excelente                                    | Documento: [3.2.2 Facade](/PadroesDeProjeto/GoFsEstruturais/Facade.md) <br> Código: [Fonte Estrutural](/PadroesDeProjeto/GoFsEstruturais/EstruturaCodigoFonte.md)                          |


<b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

## Padrão GoF Comportamental

A tabela a seguir resume as contribuições referentes aos Padrões de Projeto Comportamentais aplicados ao sistema "Galáxia Conectada".

| Nome do Membro  | Contribuição Específica (Padrão Comportamental)                                                                                                                               | Significância da Contribuição para o Projeto | Comprobatórios Claros (com link)                                                                                                                                                                                   |
| :-------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | :------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Larissa Stéfane | **Observer:** Estudo do padrão, modelagem UML, implementação em Java das interfaces `ObservadorTrilha` e `SujeitoTrilhaObservavel`, adaptação da `TrilhaEducacional` como sujeito e criação de observadores (`NotificadorPlataforma`, `AnunciadorForum`) para notificação de eventos, e documentação completa. | Excelente                                    | Documento: [3.3.1 Observer](/PadroesDeProjeto/GoFsComportamentais/Observer.md) <br> Código: [Fonte Comportamental](/PadroesDeProjeto/GoFsComportamentais/ComportamentalCodigoFonte.md) |


<b>Autora:</b> <a href="https://github.com/SkywalkerSupreme">Larissa Stéfane</a>.

