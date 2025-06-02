package com.galaxiaconectada.trilhas;

import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.util.ArrayList;
import java.util.List;

public class TrilhaEducacional implements ComponenteTrilha { // IMPLEMENTA ComponenteTrilha
    private int id;
    private String titulo;
    private String descricao;
    private String nivel;
    private String categoria;
    private boolean publicada;
    private String imagemUrl;
    //A lista agora armazena ComponenteTrilha, que serão os Modulos
    private List<ComponenteTrilha> componentesFilhos;

   
    TrilhaEducacional(int id, String titulo, String descricao, String nivel,
                          String categoria, boolean publicada, String imagemUrl, List<ComponenteTrilha> componentesFilhos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.categoria = categoria;
        this.publicada = publicada;
        this.imagemUrl = imagemUrl;
        this.componentesFilhos = componentesFilhos != null ? new ArrayList<>(componentesFilhos) : new ArrayList<>();
    }

    // Implementação de getTitulo() da interface ComponenteTrilha
    @Override
    public String getTitulo() {
        return this.titulo;
    }

    //Exibe as informações desta Trilha Educacional e, recursivamente, de todos os seus componentes filhos (Módulos)

    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Trilha Educacional (ID: " + id + "): " + titulo);
        System.out.println(indentacao + "  Nível: " + nivel + ", Categoria: " + categoria);
        System.out.println(indentacao + "  Descrição: " + descricao);
        System.out.println(indentacao + "  Publicada: " + (publicada ? "Sim" : "Não"));
        System.out.println(indentacao + "  Imagem: " + (imagemUrl != null && !imagemUrl.isEmpty() ? imagemUrl : "N/A"));

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Esta trilha ainda não possui módulos.");
        } else {
            System.out.println(indentacao + "  Módulos da Trilha (" + componentesFilhos.size() + "):");
            for (ComponenteTrilha componente : componentesFilhos) {
                // Chama o exibirInformacoes de cada filho (que será um Modulo) com uma indentação adicional.
                componente.exibirInformacoes(indentacao + "    ");
            }
        }
    }

    // Implementação dos métodos de gerenciamento de filhos da interface ComponenteTrilha
    @Override
    public void adicionar(ComponenteTrilha componente) {
        // Uma Trilha Educacional só pode conter Módulos como filhos diretos.
        if (componente instanceof Modulo) {
            this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO na Trilha '" + titulo + "'] Tentativa de adicionar um tipo de componente inválido. Apenas Módulos são permitidos.");
            
        }
    }

    @Override
    public void remover(ComponenteTrilha componente) {
        this.componentesFilhos.remove(componente);
    }

    @Override
    public ComponenteTrilha getFilho(int index) {
        if (index >= 0 && index < componentesFilhos.size()) {
            return componentesFilhos.get(index);
        }
        return null;
    }

    // Getters existentes
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getNivel() { return nivel; }
    public String getCategoria() { return categoria; }
    public boolean isPublicada() { return publicada; }
    public String getImagemUrl() { return imagemUrl; }
    
    public List<ComponenteTrilha> getComponentesFilhos() { 
        return new ArrayList<>(componentesFilhos);
    }


    public float calcularProgressoMedio() {
        System.out.println("[TrilhaEducacional] Calculando progresso médio para: " + titulo);
        return 50.0f; 
    }

    public boolean publicarTrilha() {
        this.publicada = true;
        System.out.println("[TrilhaEducacional] Trilha '" + titulo + "' publicada com sucesso!");
        return true;
    }

    @Override
    public String toString() {
        return "TrilhaEducacional [id=" + id + ", titulo=" + titulo + ", numeroDeModulos=" + componentesFilhos.size() + "]";
    }
}