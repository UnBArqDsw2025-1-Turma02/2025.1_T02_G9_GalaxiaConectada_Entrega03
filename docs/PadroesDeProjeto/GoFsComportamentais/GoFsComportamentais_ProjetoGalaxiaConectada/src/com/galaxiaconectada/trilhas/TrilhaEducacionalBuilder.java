package com.galaxiaconectada.trilhas;

// Importa a interface ComponenteTrilha e a classe Modulo
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.util.ArrayList;
import java.util.List;

//Adaptado para trabalhar com ComponenteTrilha para seus filhos (Módulos).

public class TrilhaEducacionalBuilder {
    private int id;
    private String titulo;
    private String descricao = "";
    private String nivel = "Indefinido";
    private String categoria = "Geral";
    private boolean publicada = false;
    private String imagemUrl = "";
    //A lista interna é de ComponenteTrilha (que serão os Modulos)
    private List<ComponenteTrilha> componentesFilhos;

    public TrilhaEducacionalBuilder(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.componentesFilhos = new ArrayList<>(); // Inicializa a lista
    }

    public TrilhaEducacionalBuilder comDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public TrilhaEducacionalBuilder comNivel(String nivel) {
        this.nivel = nivel;
        return this;
    }

    public TrilhaEducacionalBuilder comCategoria(String categoria) {
        this.categoria = categoria;
        return this;
    }

    public TrilhaEducacionalBuilder definirComoPublicada(boolean publicada) {
        this.publicada = publicada;
        return this;
    }

    public TrilhaEducacionalBuilder comImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
        return this;
    }

    //Adiciona um ComponenteTrilha (que deve ser um Modulo) à lista de filhos desta trilha.

    public TrilhaEducacionalBuilder adicionarComponente(ComponenteTrilha componente) {
        if (componente instanceof Modulo) {
            this.componentesFilhos.add(componente);
        } else if (componente != null) {
            System.out.println("[AVISO TrilhaBuilder] Tentativa de adicionar um tipo de componente não-Modulo (" + componente.getClass().getSimpleName() + ") a uma Trilha. Ignorado.");
        }
        return this;
    }

    //Define uma lista inteira de ComponenteTrilha (Módulos) para a trilha,
    
    public TrilhaEducacionalBuilder comListaDeComponentes(List<ComponenteTrilha> listaComponentes) {
        this.componentesFilhos = new ArrayList<>(); // Limpa a lista atual
        if (listaComponentes != null) {
            for (ComponenteTrilha comp : listaComponentes) {
                if (comp instanceof Modulo) { // Garante que só Módulos sejam adicionados
                    this.componentesFilhos.add(comp);
                } else if (comp != null) {
                    System.out.println("[AVISO TrilhaBuilder] Componente da lista ignorado (não é Modulo): " + comp.getClass().getSimpleName());
                }
            }
        }
        return this;
    }


    public TrilhaEducacional build() {
        if (this.titulo == null || this.titulo.trim().isEmpty()) {
            throw new IllegalStateException("O título da trilha é obrigatório e não pode ser vazio.");
        }
        // Chama o construtor de TrilhaEducacional
        return new TrilhaEducacional(this.id, this.titulo, this.descricao, this.nivel,
                                   this.categoria, this.publicada, this.imagemUrl, this.componentesFilhos);
    }
}