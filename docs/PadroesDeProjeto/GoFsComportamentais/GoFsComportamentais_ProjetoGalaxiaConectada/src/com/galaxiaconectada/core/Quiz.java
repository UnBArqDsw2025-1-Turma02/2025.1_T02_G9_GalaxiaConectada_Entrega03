package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; 

// Quiz também é um tipo de Conteudo e implementa ComponenteTrilha através de Conteudo.
public class Quiz extends Conteudo {
    private int tempoLimiteMin;       
    private int tentativasPermitidas;

    // Construtor do Quiz
    public Quiz(int id, String titulo, String descricao, TipoVisibilidade visibilidade, int tempoLimiteMin, int tentativasPermitidas) {
        super(id, titulo, descricao, visibilidade); // Chama o construtor de Conteudo
        this.tempoLimiteMin = tempoLimiteMin;
        this.tentativasPermitidas = tentativasPermitidas;
    }

    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID.
        // Imprimimos apenas o que é específico do Quiz.
        System.out.println(indentacao + "Tipo de Interação: Quiz Avaliativo");
        System.out.println(indentacao + "Tempo Limite: " + this.tempoLimiteMin + " minutos");
        System.out.println(indentacao + "Tentativas Permitidas: " + this.tentativasPermitidas);
        System.out.println(indentacao + "Perguntas (simulação):");
        // Lógica placeholder para simular a exibição de perguntas
        if (getTitulo().toLowerCase().contains("planetas")) {
            System.out.println(indentacao + "  1. Qual o maior planeta do Sistema Solar?");
            System.out.println(indentacao + "     a) Terra");
            System.out.println(indentacao + "     b) Júpiter");
            System.out.println(indentacao + "     c) Marte");
        } else {
            System.out.println(indentacao + "  1. Pergunta Genérica A sobre " + getTitulo() + "?");
            System.out.println(indentacao + "     ( ) Opção 1");
        }
    }

    public Object iniciar(Usuario usuario) { 
        System.out.println("  " + (usuario != null ? usuario.getNome() : "Usuário") + " iniciando o quiz: " + getTitulo());
        return null;
    }

    public Object submeter(Object tentativaQuiz) { 
        System.out.println("  Quiz " + getTitulo() + " submetido.");
        return null;
    }

    // Getters para os atributos específicos do Quiz
    public int getTempoLimiteMin() {
        return tempoLimiteMin;
    }

    public int getTentativasPermitidas() {
        return tentativasPermitidas;
    }
}