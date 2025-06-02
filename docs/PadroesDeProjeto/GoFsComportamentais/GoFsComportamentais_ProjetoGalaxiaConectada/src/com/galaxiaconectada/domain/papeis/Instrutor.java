package com.galaxiaconectada.domain.papeis;

import java.util.ArrayList;
import java.util.List;

// Curso e TrilhaEducacional serão classes que serão definidas depois
// import com.galaxiaconectada.core.TrilhaEducacional;

public class Instrutor implements PapelUsuario {

    private String biografiaCurta;
    private float avaliacaoMedia;
    private List<String> especialidades;

    public Instrutor(String biografiaCurta, float avaliacaoMedia, List<String> especialidades) {
        this.biografiaCurta = biografiaCurta;
        this.avaliacaoMedia = avaliacaoMedia;
        this.especialidades = especialidades != null ? especialidades : new ArrayList<>();
    }

    @Override
    public String getTipoPapel() {
        return "Instrutor";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Instrutor:");
        System.out.println("  Biografia: " + biografiaCurta);
        System.out.println("  Avaliação Média: " + avaliacaoMedia);
        System.out.println("  Especialidades: " + String.join(", ", especialidades));
    }

    // Métodos específicos do Instrutor (da Tabela 1)
    public void listarTrilhasCriadas() { // Deveria retornar List<TrilhaEducacional>
        System.out.println("  [Instrutor] Listando trilhas criadas...");

    }

    public void listarConteudosCriados() { // Deveria retornar List<Conteudo>
        System.out.println("  [Instrutor] Listando conteúdos criados...");
        
    }

    // Getters e Setters
    public String getBiografiaCurta() { return biografiaCurta; }
    public void setBiografiaCurta(String biografiaCurta) { this.biografiaCurta = biografiaCurta; }
    public float getAvaliacaoMedia() { return avaliacaoMedia; }
    public void setAvaliacaoMedia(float avaliacaoMedia) { this.avaliacaoMedia = avaliacaoMedia; }
    public List<String> getEspecialidades() { return especialidades; }
    public void setEspecialidades(List<String> especialidades) { this.especialidades = especialidades; }
}


