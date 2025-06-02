package com.galaxiaconectada.core; // Mesmo pacote da classe Conteudo

// Artigo é um tipo de Conteudo e implementa ComponenteTrilha através de Conteudo.
public class Artigo extends Conteudo {
    private String textoHtml; 
    private String fonte;     

    // Construtor do Artigo
    public Artigo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String textoHtml, String fonte) {
        // Chama o construtor da superclasse (Conteudo)
        super(id, titulo, descricao, visibilidade);
        this.textoHtml = textoHtml;
        this.fonte = fonte;
    }

    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID
        System.out.println(indentacao + "Fonte: " + (this.fonte != null && !this.fonte.isEmpty() ? this.fonte : "Não especificada"));
        System.out.println(indentacao + "Conteúdo HTML (prévia):");
        if (this.textoHtml != null && !this.textoHtml.isEmpty()) {
            // Mostra uma prévia do HTML
            String previaHtml = this.textoHtml.replaceAll("<[^>]*>", ""); 
            System.out.println(indentacao + "  " + previaHtml.substring(0, Math.min(previaHtml.length(), 100)) + (previaHtml.length() > 100 ? "..." : ""));
        } else {
            System.out.println(indentacao + "  [Conteúdo HTML não disponível]");
        }
        
    }

    // Getters para os atributos específicos do Artigo
    public String getTextoHtml() {
        return textoHtml;
    }

    public String getFonte() {
        return fonte;
    }
}