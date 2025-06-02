package com.galaxiaconectada.trilhas;

import com.galaxiaconectada.core.Conteudo; 
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha; // Importar a interface ComponenteTrilha
import java.util.ArrayList;
import java.util.List;

//Builder para a classe Modulo adaptado para trabalhar com a interface ComponenteTrilha para seus filhos.

public class ModuloBuilder {
    private int id;
    private String titulo;
    private int ordem = 0;
    private String descricaoBreve = "";
    private List<ComponenteTrilha> componentesFilhos;

    public ModuloBuilder(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.componentesFilhos = new ArrayList<>(); // Inicializa a lista
    }

    public ModuloBuilder comOrdem(int ordem) {
        this.ordem = ordem;
        return this;
    }


    public ModuloBuilder comDescricaoBreve(String descricao) {
        this.descricaoBreve = descricao;
        return this;
    }

    public ModuloBuilder adicionarComponente(ComponenteTrilha componente) {
        if (componente instanceof Conteudo) {
            this.componentesFilhos.add(componente);
        } else if (componente != null) {
            System.out.println("[AVISO ModuloBuilder] Tentativa de adicionar um tipo de componente não-Conteudo (" + componente.getClass().getSimpleName() + ") a um Módulo. Ignorado.");
        }
        return this;
    }

    
    public ModuloBuilder comListaDeComponentes(List<ComponenteTrilha> listaComponentes) {
        this.componentesFilhos = new ArrayList<>(); // Limpa a lista atual
        if (listaComponentes != null) {
            for (ComponenteTrilha comp : listaComponentes) {
                if (comp instanceof Conteudo) { // Garante que só Conteúdos sejam adicionados
                    this.componentesFilhos.add(comp);
                } else if (comp != null) {
                    System.out.println("[AVISO ModuloBuilder] Componente da lista ignorado (não é Conteudo): " + comp.getClass().getSimpleName());
                }
            }
        }
        return this;
    }


    public Modulo build() {
        if (this.titulo == null || this.titulo.trim().isEmpty()) {
            throw new IllegalStateException("O título do módulo é obrigatório e não pode ser vazio.");
        }
        // Chama o construtor de Modulo, que espera List<ComponenteTrilha>
        return new Modulo(this.id, this.titulo, this.ordem, this.descricaoBreve, this.componentesFilhos);
    }
}