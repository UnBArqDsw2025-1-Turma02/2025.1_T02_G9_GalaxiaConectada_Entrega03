package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.Quiz; // Importa a classe Quiz
import com.galaxiaconectada.core.TipoVisibilidade;
import java.util.Map;

public class FabricaDeQuiz extends FabricaDeConteudo {

    @Override
    public Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        int tempoLimiteMin = (int) detalhes.getOrDefault("tempoLimiteMin", 30);
        int tentativasPermitidas = (int) detalhes.getOrDefault("tentativasPermitidas", 1);

        return new Quiz(id, titulo, descricao, visibilidade, tempoLimiteMin, tentativasPermitidas);
    }
}