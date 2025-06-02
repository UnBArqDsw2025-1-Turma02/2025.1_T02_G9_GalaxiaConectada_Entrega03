package com.galaxiaconectada.domain.papeis;

import java.time.LocalDateTime;
// Curso e TrilhaEducacional serão classes que serão definidas depois
// import com.galaxiaconectada.core.Curso;
// import com.galaxiaconectada.core.TrilhaEducacional;
// import java.util.List;
// import java.util.ArrayList;

public class Aluno implements PapelUsuario {
    private float progressoGeral;
    private LocalDateTime ultimoAcessoTrilha;


    public Aluno(float progressoGeral, LocalDateTime ultimoAcessoTrilha) {
        this.progressoGeral = progressoGeral;
        this.ultimoAcessoTrilha = ultimoAcessoTrilha;
    }

    @Override
    public String getTipoPapel() {
        return "Aluno";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Aluno:");
        System.out.println("  Progresso Geral: " + progressoGeral + "%");
        System.out.println("  Último Acesso à Trilha: " + ultimoAcessoTrilha);
    }

    // Métodos específicos do Aluno
    public void listarCursosConcluidos() { // Deveria retornar List<Curso>
        System.out.println("  [Aluno] Listando cursos concluídos...");
       
    }

    public void listarTrilhasEmAndamento() { // Deveria retornar List<TrilhaEducacional>
        System.out.println("  [Aluno] Listando trilhas em andamento...");
        
    }

    // Getters e Setters para os atributos
    public float getProgressoGeral() { return progressoGeral; }
    public void setProgressoGeral(float progressoGeral) { this.progressoGeral = progressoGeral; }
    public LocalDateTime getUltimoAcessoTrilha() { return ultimoAcessoTrilha; }
    public void setUltimoAcessoTrilha(LocalDateTime ultimoAcessoTrilha) { this.ultimoAcessoTrilha = ultimoAcessoTrilha; }
}