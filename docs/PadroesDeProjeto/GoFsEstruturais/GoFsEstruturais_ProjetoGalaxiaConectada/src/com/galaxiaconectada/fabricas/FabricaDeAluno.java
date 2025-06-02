package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Aluno; // Importa a classe Aluno
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * Fábrica Concreta (ConcreteCreator) especializada em criar objetos do tipo Aluno.
 */
public class FabricaDeAluno extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeAluno] Criando papel de Aluno...");

        // Extrai os detalhes específicos para um Aluno do Map.
        float progressoGeral = 0.0f;
        if (detalhesEspecificos.get("progressoGeral") instanceof Number) {
            progressoGeral = ((Number) detalhesEspecificos.get("progressoGeral")).floatValue();
        } else {
            System.out.println("[FabricaDeAluno] 'progressoGeral' não fornecido ou tipo inválido, usando padrão: 0.0f");
        }

        LocalDateTime ultimoAcessoTrilha = (LocalDateTime) detalhesEspecificos.getOrDefault("ultimoAcessoTrilha", LocalDateTime.now());

        // Cria e retorna uma nova instância de Aluno
        return new Aluno(progressoGeral, ultimoAcessoTrilha);
    }
}