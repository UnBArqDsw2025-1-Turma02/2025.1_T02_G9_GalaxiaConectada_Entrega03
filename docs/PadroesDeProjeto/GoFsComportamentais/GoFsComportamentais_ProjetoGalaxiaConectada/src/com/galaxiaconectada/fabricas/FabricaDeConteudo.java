package com.galaxiaconectada.fabricas; // Pertence ao pacote 'fabricas'


import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import java.util.Map;


public abstract class FabricaDeConteudo {

    public abstract Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes);


    public void iniciarPublicacaoDeConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {

        Conteudo conteudo = criarConteudo(id, titulo, descricao, visibilidade, detalhes);

        System.out.println("\n--- Nova Publicação Iniciada pela Fábrica ---");
        System.out.println("Fábrica: " + this.getClass().getSimpleName() + " está trabalhando...");
        System.out.println("Conteúdo criado: " + conteudo.getTitulo() + " (ID: " + conteudo.getId() + ")");
        

        conteudo.exibirInformacoes(""); 
        
        System.out.println("--- Publicação Concluída ---");
    }
}