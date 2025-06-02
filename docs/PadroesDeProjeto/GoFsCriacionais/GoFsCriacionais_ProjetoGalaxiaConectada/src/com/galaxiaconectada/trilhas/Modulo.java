package com.galaxiaconectada.trilhas;

  import com.galaxiaconectada.core.Conteudo; // Usa a classe Conteudo
  import java.util.List;
  import java.util.ArrayList;

  /**
   * Representa um Módulo educacional dentro de uma Trilha.
   * Um módulo agrupa diversos Conteúdos.
   */
  public class Modulo {
      private int id;
      private String titulo;
      private int ordem; // Ordem de exibição do módulo na trilha
      private String descricaoBreve;
      private List<Conteudo> conteudos; // Lista de conteúdos pertencentes a este módulo

      // Construtor será usado pelo ModuloBuilder
      Modulo(int id, String titulo, int ordem, String descricaoBreve, List<Conteudo> conteudos) {
          this.id = id;
          this.titulo = titulo;
          this.ordem = ordem;
          this.descricaoBreve = descricaoBreve;
          this.conteudos = conteudos != null ? new ArrayList<>(conteudos) : new ArrayList<>();
      }

      // Getters
      public int getId() { return id; }
      public String getTitulo() { return titulo; }
      public int getOrdem() { return ordem; }
      public String getDescricaoBreve() { return descricaoBreve; }
      public List<Conteudo> getConteudos() { return new ArrayList<>(conteudos); } // Retorna cópia

      /**
       * Adiciona um conteúdo a este módulo.
       */
      public void adicionarConteudoInterno(Conteudo conteudo) {
          if (this.conteudos == null) {
              this.conteudos = new ArrayList<>();
          }
          this.conteudos.add(conteudo);
      }


      public void exibirDetalhes() {
          System.out.println("  --- Módulo: " + titulo + " (ID: " + id + ", Ordem: " + ordem + ") ---");
          System.out.println("  Descrição Breve: " + descricaoBreve);
          if (conteudos.isEmpty()) {
              System.out.println("    Este módulo ainda não possui conteúdos.");
          } else {
              System.out.println("    Conteúdos do Módulo:");
              for (Conteudo c : conteudos) {
                  System.out.println("      - " + c.getTitulo() + " (Tipo: " + c.getClass().getSimpleName() + ")");
                  // Poderia chamar c.exibir() se quisesse todos os detalhes aqui
              }
          }
          System.out.println("  ----------------------------------");
      }

      // toString para facilitar a visualização (opcional)
      @Override
      public String toString() {
          return "Modulo [id=" + id + ", titulo=" + titulo + ", ordem=" + ordem + ", conteudos=" + conteudos.size() + "]";
      }
  }