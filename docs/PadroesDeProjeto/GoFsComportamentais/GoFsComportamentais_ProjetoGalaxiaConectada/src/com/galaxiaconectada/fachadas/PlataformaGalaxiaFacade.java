package com.galaxiaconectada.fachadas;

import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.domain.comunicacao.Notificacao;
import com.galaxiaconectada.domain.forum.Forum;
import com.galaxiaconectada.domain.forum.Subforum;
import com.galaxiaconectada.fabricas.FabricaDeArtigo;
import com.galaxiaconectada.fabricas.FabricaDeConteudo;
import com.galaxiaconectada.prototipos.PrototipoClonavel;
import com.galaxiaconectada.prototipos.RegistroDePrototipos;
import com.galaxiaconectada.trilhas.Modulo;
import com.galaxiaconectada.trilhas.ModuloBuilder;
import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.trilhas.TrilhaEducacionalBuilder;
import java.time.LocalDateTime; // Necessário para ModuloBuilder e TrilhaEducacionalBuilder
import java.util.HashMap;
import java.util.Map;

//Facade coordenando múltiplos subsistemas.

public class PlataformaGalaxiaFacade {

    private RegistroDePrototipos registroPrototipos;
    private Forum forumPrincipal;

    public PlataformaGalaxiaFacade(RegistroDePrototipos registroPrototiposGlobal) {
        this.registroPrototipos = registroPrototiposGlobal;
        this.forumPrincipal = Forum.getInstance(); // Pega a instância única do Fórum
        System.out.println("[FACADE INICIADA] Pronta para simplificar operações na Galáxia Conectada!");
    }

    // Método de fachada que simplifica a criação e publicação de uma trilha básica

    public TrilhaEducacional instrutorPublicaNovaTrilhaSimples(
            Usuario instrutor,
            int idTrilha, String tituloTrilha, String descTrilha, String categoriaTrilha, String nivelTrilha,
            int idModulo, String tituloModulo, String descModulo,
            int idArtigo, String tituloArtigo, String descArtigo, String textoArtigo, String fonteArtigo) {

        System.out.println("\n[FACADE OPERAÇÃO] " + (instrutor != null ? instrutor.getNome() : "Sistema") + " está criando e publicando uma trilha simples: '" + tituloTrilha + "'...");

        // --- ETAPA 1: Criar o Conteúdo (Artigo) ---
        System.out.println("  [FACADE - ETAPA 1] Preparando conteúdo (artigo) para o módulo...");
        FabricaDeConteudo fabricaArtigo = new FabricaDeArtigo();
        Map<String, Object> detalhesArtigo = new HashMap<>();
        detalhesArtigo.put("textoHtml", textoArtigo);
        detalhesArtigo.put("fonte", fonteArtigo != null ? fonteArtigo : "Instrutor " + (instrutor != null ? instrutor.getNome() : ""));

        Conteudo artigo = (Conteudo) fabricaArtigo.criarConteudo(idArtigo, tituloArtigo, descArtigo, TipoVisibilidade.PUBLICO, detalhesArtigo);
        if (artigo == null) {
            System.out.println("  [ERRO FACADE] Falha ao criar o artigo para a trilha.");
            return null;
        }
        System.out.println("  Conteúdo (Artigo) '" + artigo.getTitulo() + "' criado.");

        // --- ETAPA 2: Criar o Módulo e adicionar o Conteúdo ---
        System.out.println("\n  [FACADE - ETAPA 2] Montando o módulo com o artigo...");
        ModuloBuilder moduloBuilder = new ModuloBuilder(idModulo, tituloModulo)
                .comDescricaoBreve(descModulo)
                .comOrdem(1)
                .adicionarComponente(artigo); // Adiciona o Conteudo (que é ComponenteTrilha)
        Modulo modulo = moduloBuilder.build();
        System.out.println("  Módulo '" + modulo.getTitulo() + "' montado.");

        // --- ETAPA 3: Criar a Trilha Educacional e adicionar o Módulo ---
        System.out.println("\n  [FACADE - ETAPA 3] Montando a trilha educacional...");
        TrilhaEducacionalBuilder trilhaBuilder = new TrilhaEducacionalBuilder(idTrilha, tituloTrilha)
                .comDescricao(descTrilha)
                .comCategoria(categoriaTrilha)
                .comNivel(nivelTrilha)
                .adicionarComponente(modulo); // Adiciona o Modulo (que é ComponenteTrilha)

        TrilhaEducacional novaTrilha = trilhaBuilder.build();
        novaTrilha.publicarTrilha(); // Publica a trilha (isso também notificará observadores da trilha)

        System.out.println("  Trilha Educacional '" + novaTrilha.getTitulo() + "' montada e publicada.");
        // novaTrilha.exibirInformacoes("    "); // Opcional: exibir estrutura aqui para debug da facade

        // --- ETAPA 4: Preparar e "enviar" Notificação sobre a nova trilha ---
        System.out.println("\n  [FACADE - ETAPA 4] Preparando notificação sobre a nova trilha...");
        PrototipoClonavel prototipoNotif = registroPrototipos.getPrototipoClonado("NOTIFICACAO_NOVA_TRILHA");
        if (prototipoNotif instanceof Notificacao) {
            Notificacao notificacaoNovaTrilha = (Notificacao) prototipoNotif;
            String nomeInstrutor = (instrutor != null ? instrutor.getNome() : "a plataforma");
            notificacaoNovaTrilha.setMensagem("Atenção exploradores! A nova trilha '" + novaTrilha.getTitulo() + "' foi lançada por " + nomeInstrutor + "! Confira já!");
            notificacaoNovaTrilha.setLink("/trilhas/" + novaTrilha.getId());
            notificacaoNovaTrilha.setDataEnvio(LocalDateTime.now()); // Data do envio real
            System.out.println("  Notificação (simulada) para ser enviada:");
            notificacaoNovaTrilha.exibir();
        } else {
            System.out.println("  [AVISO FACADE] Protótipo 'NOTIFICACAO_NOVA_TRILHA' não encontrado ou tipo incorreto. Notificação não gerada.");
        }

        // --- ETAPA 5: Criar um anúncio no Fórum ---
        System.out.println("\n  [FACADE - ETAPA 5] Anunciando nova trilha no fórum...");
        Subforum subforumAnuncios = this.forumPrincipal.criarSubforum(
            "Anúncios de Novas Trilhas", 
            "Fique por dentro das últimas trilhas educacionais lançadas!"
        ); 

        System.out.println("  Anúncio (simulado) no subfórum '" + subforumAnuncios.getNome() + "': Trilha '" + novaTrilha.getTitulo() + "' já está disponível!");

        System.out.println("\n[FACADE OPERAÇÃO CONCLUÍDA] Trilha '" + novaTrilha.getTitulo() + "' foi completamente processada pela Facade!");
        return novaTrilha;
    }

}