package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Instrutor; // Importa a classe Instrutor
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

//Fábrica Concreta especializada em criar objetos do tipo Instrutor.
public class FabricaDeInstrutor extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeInstrutor] Criando papel de Instrutor...");

        String biografiaCurta = (String) detalhesEspecificos.getOrDefault("biografiaCurta", "Instrutor(a) da plataforma Galáxia Conectada.");

        float avaliacaoMedia = 0.0f;
        if (detalhesEspecificos.get("avaliacaoMedia") instanceof Number) {
            avaliacaoMedia = ((Number) detalhesEspecificos.get("avaliacaoMedia")).floatValue();
        } else {
             System.out.println("[FabricaDeInstrutor] 'avaliacaoMedia' não fornecida ou tipo inválido, usando padrão: 0.0f");
        }

        @SuppressWarnings("unchecked") // Usado para suprimir aviso de cast não verificado, use com cautela
        List<String> especialidades = (List<String>) detalhesEspecificos.getOrDefault("especialidades", new ArrayList<String>());

        return new Instrutor(biografiaCurta, avaliacaoMedia, especialidades);
    }
}