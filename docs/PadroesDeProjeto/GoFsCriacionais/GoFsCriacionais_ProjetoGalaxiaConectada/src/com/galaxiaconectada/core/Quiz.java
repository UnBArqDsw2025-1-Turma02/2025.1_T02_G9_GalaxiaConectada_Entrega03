package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; // É preciso da classe Usuario para os métodos iniciar e submeter

public class Quiz extends Conteudo {
    private int tempoLimiteMin;
    private int tentativasPermitidas;

     // Construtor do Quiz
    public Quiz(int id, String titulo, String descricao, TipoVisibilidade visibilidade, int tempoLimiteMin, int tentativasPermitidas) {
        super(id, titulo, descricao, visibilidade);
        this.tempoLimiteMin = tempoLimiteMin; // Atributos específicos do Quiz
        this.tentativasPermitidas = tentativasPermitidas;
    }

    // MÉTODO EXIBIR:
    @Override
    public void exibir() {
        System.out.println("<<< EXIBINDO QUIZ >>>");
        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Tempo Limite: " + this.tempoLimiteMin + " minutos");
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao());
        System.out.println("Tentativas Permitidas: " + this.tentativasPermitidas);
        System.out.println("------------------------------------");
        System.out.println("PERGUNTAS DO QUIZ:");

    }

    // Métodos específicos do Quiz
    public Object iniciar(Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " iniciando o quiz: " + getTitulo());
        return null;
    }

    public Object submeter(Object tentativaQuiz) { // Deve receber TentativaQuiz e retornar ResultadoQuiz
        System.out.println("Quiz " + getTitulo() + " submetido.");
        return null;
    }

    public int getTempoLimiteMin() {
        return tempoLimiteMin;
    }

    public int getTentativasPermitidas() {
        return tentativasPermitidas;
    }
}