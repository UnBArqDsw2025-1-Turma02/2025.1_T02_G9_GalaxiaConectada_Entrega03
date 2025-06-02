package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.Jogo; // Importa a classe Jogo
import com.galaxiaconectada.core.TipoVisibilidade;
import java.util.Map;

public class FabricaDeJogo extends FabricaDeConteudo {

    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        String tipoJogo = (String) detalhes.getOrDefault("tipoJogo", "Desconhecido");
        int nivelDificuldade = (int) detalhes.getOrDefault("nivelDificuldade", 1);
        String urlJogo = (String) detalhes.getOrDefault("urlJogo", "http://example.com/defaultgame");

        return new Jogo(id, titulo, descricao, visibilidade, tipoJogo, nivelDificuldade, urlJogo);
    }
}