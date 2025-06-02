package com.galaxiaconectada.fabricas; // Mesmo pacote da FabricaDeConteudo

import com.galaxiaconectada.core.Artigo;
import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade; 
import java.util.Map;


public class FabricaDeArtigo extends FabricaDeConteudo {


    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {

        String textoHtml = (String) detalhes.getOrDefault("textoHtml", "<p>Conteúdo do artigo não fornecido.</p>");
        String fonte = (String) detalhes.getOrDefault("fonte", "Fonte não especificada");

        // Cria e retorna uma nova instância de Artigo
        return new Artigo(id, titulo, descricao, visibilidade, textoHtml, fonte);
    }
}
