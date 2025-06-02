package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade; // Importa a classe Video
import com.galaxiaconectada.core.Video; 
import java.util.Map;

public class FabricaDeVideo extends FabricaDeConteudo {

    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        String urlVideo = (String) detalhes.getOrDefault("urlVideo", "http://example.com/default.mp4");
        int duracaoSegundos = (int) detalhes.getOrDefault("duracaoSegundos", 0);
        String transcricao = (String) detalhes.getOrDefault("transcricao", ""); 

        return new Video(id, titulo, descricao, visibilidade, urlVideo, duracaoSegundos, transcricao);
    }
}