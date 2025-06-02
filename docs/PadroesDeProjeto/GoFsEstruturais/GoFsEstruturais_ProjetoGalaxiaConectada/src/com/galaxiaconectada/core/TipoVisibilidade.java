package com.galaxiaconectada.core;

public enum TipoVisibilidade {
    PUBLICO("Público - Acessível a todos"),
    PRIVADO("Privado - Acessível apenas ao criador"), 
    RESTRITO_ALUNOS("Restrito a Alunos - Apenas para usuários com papel de aluno"),
    RESTRITO_INSTRUTORES("Restrito a Instrutores - Apenas para instrutores e admins"),
    RESTRITO_ADMINS("Restrito a Administradores - Apenas para administradores");

    private final String descricao;

    TipoVisibilidade(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    // Método para exibir as opções
    public static void mostrarOpcoes() {
        System.out.println("Opções de Visibilidade:");
        for (TipoVisibilidade tipo : values()) {
            System.out.println((tipo.ordinal() + 1) + ". " + tipo.getDescricao());
        }
    }

    // Método para obter um TipoVisibilidade a partir da escolha numérica do usuário
    public static TipoVisibilidade fromOpcao(int opcao) {
        if (opcao > 0 && opcao <= values().length) {
            return values()[opcao - 1];
        }
        return null; // Ou lançar uma exceção para opção inválida
    }
}