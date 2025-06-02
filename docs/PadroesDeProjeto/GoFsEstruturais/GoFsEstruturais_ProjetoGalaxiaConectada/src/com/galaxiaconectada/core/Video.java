package com.galaxiaconectada.core;


public class Video extends Conteudo {
    private String urlVideo;     
    private int duracaoSegundos; 
    private String transcricao;   // Atributo para a transcrição do vídeo

    // Construtor do Video
    public Video(int id, String titulo, String descricao, TipoVisibilidade visibilidade, String urlVideo, int duracaoSegundos, String transcricao) {
        super(id, titulo, descricao, visibilidade); // Chama o construtor da classe mãe (Conteudo)
        this.urlVideo = urlVideo;
        this.duracaoSegundos = duracaoSegundos;
        this.transcricao = transcricao;
    }

    // Implementa o método abstrato de Conteudo para exibir os detalhes

    @Override
    public void exibirDetalhesEspecificos(String indentacao) {
        // A classe Conteudo.exibirInformacoes() já imprimiu os dados comuns como título, ID, etc.
        // Aqui, imprimimos apenas o que é específico do Vídeo.
        System.out.println(indentacao + "Tipo de Mídia: Vídeo");
        System.out.println(indentacao + "URL: " + (this.urlVideo != null ? this.urlVideo : "Não disponível"));
        System.out.println(indentacao + "Duração: " + this.duracaoSegundos + " segundos");
        if (this.transcricao != null && !this.transcricao.isEmpty()) {
            System.out.println(indentacao + "Transcrição: Disponível (prévia: " + this.transcricao.substring(0, Math.min(this.transcricao.length(), 30)) + "...)");
        } else {
            System.out.println(indentacao + "Transcrição: Não disponível.");
        }
        
    }

    // Métodos específicos da classe Video
    public void play() { 
        System.out.println("Vídeo '" + getTitulo() + "' está tocando... ▶️");
    }
    
    public void play(String indentacao) {
        System.out.println(indentacao + "Ação: Vídeo '" + getTitulo() + "' está tocando... ▶️");
    }


    public void pause() {
        System.out.println("Vídeo '" + getTitulo() + "' pausado. ⏸️");
    }

    // Getters para os atributos específicos do Video
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