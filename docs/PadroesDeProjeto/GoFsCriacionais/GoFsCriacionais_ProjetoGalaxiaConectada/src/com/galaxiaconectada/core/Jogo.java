package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; // Precisa da classe Usuario para os métodos

// Jogo também é um tipo de Conteudo
public class Jogo extends Conteudo {
    private String tipoJogo;            // Atributos específicos do Jogo
    private int nivelDificuldade;
    private String urlJogo;

    // Construtor do Jogo
    public Jogo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String tipoJogo, int nivelDificuldade, String urlJogo) {
        super(id, titulo, descricao, visibilidade); // Chama o construtor de Conteudo
        this.tipoJogo = tipoJogo;
        this.nivelDificuldade = nivelDificuldade;
        this.urlJogo = urlJogo;
    }

    @Override
    public void exibir() {
        System.out.println("<<< EXIBINDO JOGO >>>");
        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao());
        System.out.println("Tipo: " + this.tipoJogo);
        System.out.println("Dificuldade: Nível " + this.nivelDificuldade);
        System.out.println("Acessar em: " + this.urlJogo);
    }

    public Object iniciar(Usuario usuario) { // Deveria retornar SessaoJogo
        System.out.println("Usuário " + usuario.getNome() + " iniciando o jogo: " + getTitulo());
        return null;
    }

    public Object registrarPontuacao(Object sessaoJogo) { // Deveria receber SessaoJogo e retornar PontuacaoJogo
        System.out.println("Pontuação registrada para o jogo: " + getTitulo());
        return null;
    }

    // Getters para os atributos específicos do Jogo
    public String getTipoJogo() {
        return tipoJogo;
    }

    public int getNivelDificuldade() {
        return nivelDificuldade;
    }

    public String getUrlJogo() {
        return urlJogo;
    }
}