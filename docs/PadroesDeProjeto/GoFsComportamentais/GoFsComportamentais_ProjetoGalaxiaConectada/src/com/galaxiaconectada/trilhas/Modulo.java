package com.galaxiaconectada.trilhas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.util.ArrayList;
import java.util.List;

//Representa um Módulo educacional dentro de uma Trilha.
//Atua como um "Composite" no padrão Composite, pois pode conter outros ComponenteTrilha (especificamente, instâncias de Conteudo).
public class Modulo implements ComponenteTrilha { // IMPLEMENTA ComponenteTrilha
    private int id;
    private String titulo;
    private int ordem;
    private String descricaoBreve;
    // A lista agora armazena ComponenteTrilha, que serão os Conteudos
    private List<ComponenteTrilha> componentesFilhos;


    Modulo(int id, String titulo, int ordem, String descricaoBreve, List<ComponenteTrilha> componentesFilhos) {
        this.id = id;
        this.titulo = titulo;
        this.ordem = ordem;
        this.descricaoBreve = descricaoBreve;
        // Garante que a lista seja inicializada e faz uma cópia da lista passada
        this.componentesFilhos = componentesFilhos != null ? new ArrayList<>(componentesFilhos) : new ArrayList<>();
    }

    // Implementação de getTitulo() da interface ComponenteTrilha
    @Override
    public String getTitulo() {
        return this.titulo;
    }


    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Modulo (ID: " + id + "): " + titulo + " [Ordem: " + ordem + "]");
        System.out.println(indentacao + "  Descrição Breve: " + descricaoBreve);

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Este módulo ainda não possui conteúdos.");
        } else {
            System.out.println(indentacao + "  Conteúdos do Módulo:");
            for (ComponenteTrilha componente : componentesFilhos) {
                // Chama o exibirInformacoes de cada filho (que será um Conteudo)
                componente.exibirInformacoes(indentacao + "    ");
            }
        }
    }

    // Implementação dos métodos de gerenciamento de filhos da interface ComponenteTrilha

    @Override
    public void adicionar(ComponenteTrilha componente) {
        // Um Módulo só pode conter Conteudos como filhos diretos
        if (componente instanceof Conteudo) {
            this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO no Módulo '" + titulo + "'] Tentativa de adicionar um tipo de componente inválido. Apenas Conteúdos são permitidos.");
            
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


    public int getId() { return id; }
    public int getOrdem() { return ordem; }
    public String getDescricaoBreve() { return descricaoBreve; }


    public List<ComponenteTrilha> getComponentesFilhos() {
        return new ArrayList<>(componentesFilhos);
    }

    @Override
    public String toString() {
        return "Modulo [id=" + id + ", titulo=" + titulo + ", numeroDeConteudos=" + componentesFilhos.size() + "]";
    }
}