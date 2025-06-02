package com.galaxiaconectada.observer;

import com.galaxiaconectada.trilhas.TrilhaEducacional;
import com.galaxiaconectada.domain.forum.Forum;
import com.galaxiaconectada.domain.forum.Subforum; 

public class AnunciadorForum implements ObservadorTrilha {
    private Forum forumPrincipal;

    public AnunciadorForum() {
        this.forumPrincipal = Forum.getInstance();
    }

    @Override
    public void notificarTrilhaPublicada(TrilhaEducacional trilhaPublicada) {
        System.out.println("\n--- [OBSERVADOR: AnunciadorForum] ---");
        System.out.println("📰 Nova Trilha para anunciar no Fórum: '" + trilhaPublicada.getTitulo() + "'!");
        System.out.println("  Acessando o Fórum Principal (Instância Singleton: " + forumPrincipal.hashCode() + ")...");

        // Tentativa de criar/usar um subfórum de anúncios
        Subforum subforumDeAnuncios = forumPrincipal.criarSubforum(
                "Anúncios de Novas Trilhas",
                "Fique por dentro das últimas trilhas educacionais lançadas!"
        );

        System.out.println("  Subfórum para anúncio: '" + subforumDeAnuncios.getNome() + "' (ID: " + subforumDeAnuncios.getId() + ")");

        String tituloTopicoAnuncio = "🎉 Nova Trilha Lançada: " + trilhaPublicada.getTitulo();
        String corpoPostAnuncio = "Olá, exploradores da Galáxia Conectada!\n\n" +
                                  "Temos o prazer de anunciar o lançamento da nova trilha educacional: **" + trilhaPublicada.getTitulo() + "**!\n" +
                                  "Descrição: " + trilhaPublicada.getDescricao() + "\n" +
                                  "Nível: " + trilhaPublicada.getNivel() + " | Categoria: " + trilhaPublicada.getCategoria() + "\n\n" +
                                  "Não percam! Acessem e comecem a aprender agora mesmo.\n" +
                                  "Link da Trilha (simulado): /trilhas/" + trilhaPublicada.getId() + "\n\n" +
                                  "Equipe Galáxia Conectada.";

        System.out.println("  Simulando criação de tópico de anúncio no subfórum '" + subforumDeAnuncios.getNome() + "':");
        System.out.println("    Título do Tópico: " + tituloTopicoAnuncio);
        System.out.println("    Corpo da Postagem: \n\"" + corpoPostAnuncio.replaceAll("\n", "\n      ") + "\"");
        System.out.println("--- Fim do Anúncio no Fórum ---");
    }
}