package com.galaxiaconectada.core;

public class Video extends Conteudo {
    private String urlVideo;
    private int duracaoSegundos;
    private String transcricao; 

    // Construtor do Video 
    public Video(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String urlVideo, int duracaoSegundos, String transcricao) {
        super(id, titulo, descricao, visibilidade);
        this.urlVideo = urlVideo;
        this.duracaoSegundos = duracaoSegundos;
        this.transcricao = transcricao;
    }

    @Override
    public void exibir() {
        System.out.println("<<< EXIBINDO VÍDEO >>>");
        System.out.println("Título: " + getTitulo());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Visibilidade: " + getVisibilidade().getDescricao());
        System.out.println("URL: " + this.urlVideo);
        System.out.println("Duração: " + this.duracaoSegundos + " segundos");
        if (this.transcricao != null && !this.transcricao.isEmpty()) { 
            System.out.println("Transcrição disponível.");
        } else {
            System.out.println("Transcrição não disponível.");
        }
        play();
    }

    public void play() {
        System.out.println("Vídeo '" + getTitulo() + "' está tocando... ▶️");
    }

    public void pause() {
        System.out.println("Vídeo '" + getTitulo() + "' pausado. ⏸️");
    }

    public String getUrlVideo() {
        return urlVideo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getTranscricao() { 
        return transcricao;
    }
}