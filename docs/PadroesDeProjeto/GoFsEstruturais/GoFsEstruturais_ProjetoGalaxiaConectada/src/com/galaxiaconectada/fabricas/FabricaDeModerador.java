package com.galaxiaconectada.fabricas;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.papeis.Moderador;
import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.time.LocalDateTime;
import java.util.Map;

public class FabricaDeModerador extends FabricaDePapelUsuario {

    @Override
    public PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos) {
        System.out.println("[FabricaDeModerador] Criando papel de Moderador...");

        String nivelModeracao = (String) detalhesEspecificos.getOrDefault("nivelModeracao", "JUNIOR");
        LocalDateTime dataInicioModeracao = (LocalDateTime) detalhesEspecificos.getOrDefault("dataInicioModeracao", LocalDateTime.now());

        return new Moderador(nivelModeracao, dataInicioModeracao);
    }
}
