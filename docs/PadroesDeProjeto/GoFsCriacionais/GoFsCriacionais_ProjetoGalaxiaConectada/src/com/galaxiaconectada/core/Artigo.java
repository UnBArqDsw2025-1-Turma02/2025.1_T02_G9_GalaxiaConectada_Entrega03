package com.galaxiaconectada.core; // Mesmo pacote da classe Conteudo

// É um tipo de Conteudo e herda seus atributos e métodos (como getTitulo(), adicionarComentario()
public class Artigo extends Conteudo {
    private String textoHtml; // Atributo específico do Artigo
    private String fonte;     // Outro atributo específico do Artigo

    // Construtor do Artigo
    public Artigo(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String textoHtml, String fonte) {
        // A primeira linha DEVE ser a chamada para o construtor da superclasse (Conteudo)
        super(id, titulo, descricao, visibilidade);
        this.textoHtml = textoHtml;
        this.fonte = fonte;
    }

    // Cada tipo de conteúdo terá sua própria forma de se "exibir".
    @Override // sobrescrevendo um método da superclasse
    public void exibir() {
        System.out.println("<<< EXIBINDO ARTIGO >>>");
        System.out.println("Título: " + getTitulo()); // getTitulo() foi herdado de Conteudo
        System.out.println("Descrição: " + getDescricao()); // getDescricao() também foi herdado
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao()); 
        System.out.println("Fonte: " + this.fonte);
        System.out.println("------------------------------------");
        System.out.println(this.textoHtml);
        System.out.println("------------------------------------");
    }

    // Getters para os atributos específicos do Artigo
    public String getTextoHtml() {
        return textoHtml;
    }

    public String getFonte() {
        return fonte;
    }
}