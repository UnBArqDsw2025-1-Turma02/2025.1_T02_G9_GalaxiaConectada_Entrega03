package com.galaxiaconectada.core;

import com.galaxiaconectada.domain.Usuario;
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha; // IMPORTANTE: Importar a interface ComponenteTrilha
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Para formatar a data 


public abstract class Conteudo implements ComponenteTrilha { // IMPLEMENTA ComponenteTrilha
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataPublicacao;
    private TipoVisibilidade visibilidade;

    
    public Conteudo(int id, String titulo, String descricao, TipoVisibilidade visibilidade) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataPublicacao = LocalDateTime.now();
        this.visibilidade = visibilidade;
    }

    
    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Conteúdo (ID: " + id + "): " + titulo + " [Tipo Específico: " + this.getClass().getSimpleName() + "]");
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(indentacao + "  Publicado em: " + (dataPublicacao != null ? dataPublicacao.format(formatador) : "N/A"));
        System.out.println(indentacao + "  Visibilidade: " + (visibilidade != null ? visibilidade.getDescricao() : "N/A"));
        
        // Chama o método que as subclasses implementarão para seus detalhes
        exibirDetalhesEspecificos(indentacao + "  ");
    }

    
    public abstract void exibirDetalhesEspecificos(String indentacao);

    public void adicionarComentario(Usuario usuario, String texto) {
        // Chamado como parte da exibição da estrutura
        System.out.println("    └─ Comentário de " + (usuario != null ? usuario.getNome() : "Anônimo") + ": " + texto);
    }

    // Getters existentes
    public int getId() {
        return id;
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

    @Override
    public String toString() {
        // O toString pode ser útil para logs ou debug, mas exibirInformacoes é para a estrutura Composite.
        return this.getClass().getSimpleName() + " [id=" + id + ", titulo=" + titulo + "]";
    }
}