package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.ProfessorVoluntario;
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.util.Map;

public class FabricaDeProfessorVoluntario extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeProfessorVoluntario] Criando papel de Professor Voluntário...");

        String areaEspecialidade = (String) detalhesEspecificos.getOrDefault("areaEspecialidade", "Não especificada");
        int artigosRevisados = 0;
         if (detalhesEspecificos.get("artigosRevisados") instanceof Number) {
             artigosRevisados = ((Number) detalhesEspecificos.get("artigosRevisados")).intValue();
         } else {
             System.out.println("[FabricaDeProfessorVoluntario] 'artigosRevisados' não fornecido ou tipo inválido, usando padrão: 0");
         }

        return new ProfessorVoluntario(areaEspecialidade, artigosRevisados);
    }
}