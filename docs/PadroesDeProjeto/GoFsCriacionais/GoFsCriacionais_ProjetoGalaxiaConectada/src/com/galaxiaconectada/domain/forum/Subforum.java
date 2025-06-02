package com.galaxiaconectada.domain.forum;

// import java.util.List; // Para futuros tópicos
// import java.util.ArrayList; // Para futuros tópicos

// Representa um Subforum dentro do Forum principal.
public class Subforum {
    private int id;
    private String nome;
    private String descricao;
    private int ordemExibicao; 
    
    // Construtor
    public Subforum(int id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ordemExibicao = 0; // Valor padrão
        System.out.println("[Subforum Criado] ID: " + id + ", Nome: " + nome); 
    }

    // Construtor
    public Subforum(int id, String nome, String descricao, int ordemExibicao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ordemExibicao = ordemExibicao;
    }

    // Getters e Setters 
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdemExibicao() {
        return ordemExibicao;
    }

    public void setOrdemExibicao(int ordemExibicao) {
        this.ordemExibicao = ordemExibicao;
    }

    public void exibirDetalhes() {
        System.out.println("  Subforum ID: " + id + " | Nome: " + nome + " | Ordem: " + ordemExibicao);
        System.out.println("    Descrição: " + descricao);
    }
}