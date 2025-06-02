package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Administrador;
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class FabricaDeAdministrador extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeAdministrador] Criando papel de Administrador...");

        @SuppressWarnings("unchecked")
        List<String> permissoesGlobais = (List<String>) detalhesEspecificos.getOrDefault("permissoesGlobais", new ArrayList<String>());

        int nivelAcesso = 1; // Nível padrão
         if (detalhesEspecificos.get("nivelAcesso") instanceof Number) {
             nivelAcesso = ((Number) detalhesEspecificos.get("nivelAcesso")).intValue();
         } else {
             System.out.println("[FabricaDeAdministrador] 'nivelAcesso' não fornecido ou tipo inválido, usando padrão: 1");
         }

        return new Administrador(permissoesGlobais, nivelAcesso);
    }
}
