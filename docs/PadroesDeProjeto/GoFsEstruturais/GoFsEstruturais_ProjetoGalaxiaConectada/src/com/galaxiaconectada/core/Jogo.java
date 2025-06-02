package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario; // Precisa da classe Usuario para os métodos


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
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID
        // Imprimi apenas o que é específico do Jogo.
        System.out.println(indentacao + "Tipo de Jogo: " + (this.tipoJogo != null ? this.tipoJogo : "Não especificado"));
        System.out.println(indentacao + "Nível de Dificuldade: " + this.nivelDificuldade);
        System.out.println(indentacao + "URL para Jogar: " + (this.urlJogo != null ? this.urlJogo : "Não disponível"));
    }

    public Object iniciar(Usuario usuario) { // Deve retornar SessaoJogo
        System.out.println("  " + (usuario != null ? usuario.getNome() : "Usuário") + " iniciando o jogo: " + getTitulo());
        return null;
    }

    public Object registrarPontuacao(Object sessaoJogo) { // Deveria receber SessaoJogo e retornar PontuacaoJogo
        System.out.println("  Pontuação registrada para o jogo: " + getTitulo());
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