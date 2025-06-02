package com.galaxiaconectada.domain.papeis;

import com.galaxiaconectada.core.Artigo; // Artigo está em .core
import java.util.ArrayList;
import java.util.List;

/**
 * Representa o papel de um Professor Voluntário na plataforma,
 * com suas especialidades e atividades de revisão.
 */
public class ProfessorVoluntario implements PapelUsuario {

    private String areaEspecialidade;
    private int artigosRevisados;

    /**
     * Construtor para o papel de Professor Voluntário.
     * @param areaEspecialidade A área de conhecimento principal do professor.
     * @param artigosRevisados A quantidade de artigos que este professor já revisou.
     */
    public ProfessorVoluntario(String areaEspecialidade, int artigosRevisados) {
        this.areaEspecialidade = areaEspecialidade;
        this.artigosRevisados = artigosRevisados;
    }

    @Override
    public String getTipoPapel() {
        return "ProfessorVoluntario";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Professor Voluntário:");
        System.out.println("  Área de Especialidade: " + areaEspecialidade);
        System.out.println("  Artigos Revisados: " + artigosRevisados);
    }

    /**
     * Lista os artigos submetidos (ou associados) a este professor voluntário.
     * (Placeholder: Retorna uma lista vazia por enquanto)
     * @return Uma lista de Artigos.
     */
    public List<Artigo> listarArtigosSubmetidos() {
        System.out.println("  [Professor Voluntário] Listando artigos submetidos/associados...");
        return new ArrayList<>();
    }

    // Getters e Setters
    public String getAreaEspecialidade() {
        return areaEspecialidade;
    }

    public void setAreaEspecialidade(String areaEspecialidade) {
        this.areaEspecialidade = areaEspecialidade;
    }

    public int getArtigosRevisados() {
        return artigosRevisados;
    }

    public void setArtigosRevisados(int artigosRevisados) {
        this.artigosRevisados = artigosRevisados;
    }
}