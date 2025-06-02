package com.galaxiaconectada.fabricas; // Pertence ao pacote 'fabricas'

// Importa a classe base Conteudo e a interface Map
import com.galaxiaconectada.core.Conteudo;
import com.galaxiaconectada.core.TipoVisibilidade;
import java.util.Map;

// Ela não pode ser instanciada diretamente.
public abstract class FabricaDeConteudo {

    /**
     * FACTORY METHOD (Método de Fábrica) abstrato.
     * Cada fábrica concreta (FabricaDeArtigo ou FabricaDeVideo) precisará implementar este método para criar seu tipo específico de Conteudo.
     *
     * @param id O ID do conteúdo.
     * @param titulo O título do conteúdo.
     * @param descricao A descrição do conteúdo.
     * @param visibilidade A visibilidade do conteúdo.
     * @param detalhes Um Map contendo atributos específicos para o tipo de conteúdo a ser criado
     * (ex: para Artigo pode ter "textoHtml", "fonte"; para Video "urlVideo", "duracaoSegundos").
     * @return Uma instância de uma subclasse de Conteudo.
     */
    public abstract Conteudo criarConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes);


     public void iniciarPublicacaoDeConteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, Map<String, Object> detalhes) {
        // Chama o factory method para obter o objeto Produto.
        Conteudo conteudo = criarConteudo(id, titulo, descricao, visibilidade, detalhes);

        // Agora usa o produto.
        System.out.println("\n--- Nova Publicação Iniciada pela Fábrica ---");
        System.out.println("Fábrica: " + this.getClass().getSimpleName() + " está trabalhando...");
        System.out.println("Conteúdo criado: " + conteudo.getTitulo() + " (ID: " + conteudo.getId() + ")");
        conteudo.exibir(); // Chama o método exibir() do produto específico
        System.out.println("--- Publicação Concluída ---");
    }
}