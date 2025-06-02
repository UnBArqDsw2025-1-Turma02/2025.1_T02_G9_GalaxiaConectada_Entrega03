package com.galaxiaconectada.domain.forum;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger; // Para gerar IDs de subforum simples

// Representa o Fórum Principal da plataforma.

public class Forum {

    private static Forum instancia;  // Atributo estático privado para guardar a ÚNICA instância da classe
    private final int id; 
    private String nome;
    private String descricao;
    private List<Subforum> subforums;
    private AtomicInteger proximoSubforumId = new AtomicInteger(1); // Para gerar IDs simples para subforums

    // Construtor PRIVADO: impede a criação de instâncias com 'new Forum()' de fora da classe.
    private Forum(int id, String nomePadrao, String descricaoPadrao) {
        this.id = id;
        this.nome = nomePadrao;
        this.descricao = descricaoPadrao;
        this.subforums = new ArrayList<>();
        System.out.println("🌟 Instância ÚNICA do Fórum Principal '" + nome + "' criada! (ID: " + id + ") 🌟");
    }

    public static synchronized Forum getInstance() {
        if (instancia == null) {
            instancia = new Forum(1, "Fórum Central da Galáxia Conectada", "O ponto de encontro para todas as discussões intergalácticas!");
        }
        return instancia;
    }

    public List<Subforum> listarSubforums() {
        System.out.println("[Classe do Forum] Listando " + subforums.size() + " subfórum(ns)...");
        return new ArrayList<>(subforums); // Retorna uma cópia para proteger a lista interna
    }

    public Subforum criarSubforum(String nome, String descricao) {
        // Gera um ID simples para o novo subfórum
        int novoId = proximoSubforumId.getAndIncrement();
        Subforum novoSubforum = new Subforum(novoId, nome, descricao);
        this.subforums.add(novoSubforum);
        System.out.println("[Forum] Subfórum '" + nome + "' (ID: " + novoId + ") criado e adicionado ao fórum.");
        return novoSubforum;
    }

    // Getters para os atributos do Fórum
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

    public void exibirDetalhes() {
        System.out.println("\n--- Detalhes do Fórum (Singleton) ---");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
        if (subforums.isEmpty()) {
            System.out.println("Subfóruns: Nenhum subfórum criado ainda.");
        } else {
            System.out.println("Subfóruns (" + subforums.size() + "):");
            for (Subforum sf : subforums) {
                System.out.println("  - " + sf.getNome() + " (ID: " + sf.getId() + ")");
            }
        }
        System.out.println("------------------------------------");
    }
}