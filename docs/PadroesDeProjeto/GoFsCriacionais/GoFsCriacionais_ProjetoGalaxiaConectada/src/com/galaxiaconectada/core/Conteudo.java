package com.galaxiaconectada.core; 

import com.galaxiaconectada.domain.Usuario;
import java.time.LocalDateTime; // Importa a classe Usuario

// Não se pode criar um "Conteudo" genérico diretamente.
public abstract class Conteudo {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPublicacao;
    private TipoVisibilidade visibilidade; 

    // Chamado quando criado um objeto Conteudo (ou suas subclasses).
    public Conteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade) { 
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = LocalDateTime.now(); // Define a data de publicação para agora
        this.visibilidade = visibilidade;
    }

    // Este método é 'abstract'. Isso força cada subclasse de Conteudo
    // (como Artigo, Video) a ter sua própria maneira de "se exibir".
    public abstract void exibir();

    public void adicionarComentario(Usuario usuario, String texto) {

        System.out.println("Comentário de " + usuario.getNome() + " adicionado ao conteúdo '" + this.titulo + "': " + texto);
    }

    // métodos para obter os valores dos atributos privados.
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public TipoVisibilidade getVisibilidade() { 
        return visibilidade; 
    }

    // Define como o objeto Conteudo será representado como texto
    @Override
    public String toString() {
        return "Conteudo [id=" + id + ", titulo=" + titulo + ", dataPublicacao=" + dataPublicacao + ", visibilidade=" + visibilidade.name() + "]";
    }
}