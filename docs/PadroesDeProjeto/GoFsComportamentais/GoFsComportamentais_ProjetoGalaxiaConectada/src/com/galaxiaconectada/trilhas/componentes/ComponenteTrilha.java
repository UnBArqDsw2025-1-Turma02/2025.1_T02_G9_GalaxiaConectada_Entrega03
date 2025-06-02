package com.galaxiaconectada.trilhas.componentes;

// Interface Componente para o padrão Composite - Define as operações comuns para elementos simples (folhas, como Conteudo)
 
public interface ComponenteTrilha {

    String getTitulo();

    void exibirInformacoes(String indentacao);

    // Métodos para gerenciamento de filhos (abordagem transparente).
    default void adicionar(ComponenteTrilha componente) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }

    default void remover(ComponenteTrilha componente) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }

    default ComponenteTrilha getFilho(int index) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }
}