package com.galaxiaconectada.trilhas.componentes;

/**
 * Interface Componente para o padrão Composite.
 * Define as operações comuns para elementos simples (folhas, como Conteudo)
 * e para elementos compostos (como Modulo e TrilhaEducacional).
 */
public interface ComponenteTrilha {

    /**
     * Retorna o título do componente.
     * @return O título.
     */
    String getTitulo();

    /**
     * Exibe a estrutura ou detalhes deste componente, usando uma indentação
     * para indicar o nível na hierarquia.
     * @param indentacao A string de indentação a ser usada (ex: "  ", "    ").
     */
    void exibirInformacoes(String indentacao);

    // Métodos para gerenciamento de filhos (abordagem transparente).
    // As classes Leaf (como Conteudo) geralmente lançam UnsupportedOperationException
    // ou fornecem implementações vazias para estes.
    // As classes Composite (Modulo, TrilhaEducacional) os implementarão.

    /**
     * Adiciona um componente filho. Não suportado por Leafs.
     * @param componente O ComponenteTrilha a ser adicionado.
     */
    default void adicionar(ComponenteTrilha componente) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }

    /**
     * Remove um componente filho. Não suportado por Leafs.
     * @param componente O ComponenteTrilha a ser removido.
     */
    default void remover(ComponenteTrilha componente) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }

    /**
     * Obtém um componente filho pelo índice. Não suportado por Leafs.
     * @param index O índice do filho.
     * @return O ComponenteTrilha filho.
     */
    default ComponenteTrilha getFilho(int index) {
        throw new UnsupportedOperationException("Esta operação não é suportada por esta classe.");
    }
}