package com.galaxiaconectada.fabricas;

    import com.galaxiaconectada.domain.Usuario;
    import com.galaxiaconectada.domain.papeis.PapelUsuario; // A interface que os produtos implementam
    import java.util.Map;

    //Fábrica Abstrata (Creator) para criar diferentes tipos de PapelUsuario.
     
    public abstract class FabricaDePapelUsuario {

        public abstract PapelUsuario criarPapel(Usuario usuarioReferencia, Map<String, Object> detalhesEspecificos);

        /**
         * Um método de conveniência que usa o factory method para criar um papel, em seguida, o atribui ao usuário fornecido.
         *
         * @param usuario O Usuário que receberá o novo papel.
         * @param detalhesPapel Os detalhes para a criação do papel.
         * @return O objeto Usuario atualizado com o novo papel, ou o próprio usuário se o papel não puder ser criado.
         */
        public Usuario atribuirPapelParaUsuario(Usuario usuario, Map<String, Object> detalhesPapel) {
            PapelUsuario novoPapel = criarPapel(usuario, detalhesPapel);

            if (novoPapel != null && usuario != null) {
               
                usuario.setPapelPrincipal(novoPapel);
                System.out.println("[FÁBRICA DE PAPEL] Papel '" + novoPapel.getTipoPapel() + "' atribuído com sucesso ao usuário: " + usuario.getNome());
            } else if (usuario == null) {
                System.out.println("[FÁBRICA DE PAPEL ERRO] Usuário de referência não pode ser nulo para atribuir papel.");
            } else {
                System.out.println("[FÁBRICA DE PAPEL ERRO] Não foi possível criar o papel para o usuário: " + usuario.getNome());
            }
            return usuario;
        }
    }