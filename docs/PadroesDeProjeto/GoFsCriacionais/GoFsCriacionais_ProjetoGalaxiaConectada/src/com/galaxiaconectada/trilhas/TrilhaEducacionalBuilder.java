 package com.galaxiaconectada.trilhas;

  import java.util.ArrayList;
  import java.util.List;

  public class TrilhaEducacionalBuilder {
      // Atributos da TrilhaEducacional que estamos construindo
      private int id;
      private String titulo;
      private String descricao = ""; // Valor padrão
      private String nivel = "Indefinido"; // Valor padrão
      private String categoria = "Geral"; // Valor padrão
      private boolean publicada = false; // Valor padrão
      private String imagemUrl = ""; // Valor padrão
      private List<Modulo> modulos; // Lista para guardar os módulos da trilha

      //Construtor do TrilhaEducacionalBuilder.
      public TrilhaEducacionalBuilder(int id, String titulo) {
          this.id = id;
          this.titulo = titulo;
          this.modulos = new ArrayList<>(); // Inicializa a lista de módulos
      }

      public TrilhaEducacionalBuilder comDescricao(String descricao) {
          this.descricao = descricao;
          return this;
      }

      
      public TrilhaEducacionalBuilder comNivel(String nivel) {
          this.nivel = nivel;
          return this;
      }

      public TrilhaEducacionalBuilder comCategoria(String categoria) {
          this.categoria = categoria;
          return this;
      }

      public TrilhaEducacionalBuilder definirComoPublicada(boolean publicada) {
          this.publicada = publicada;
          return this;
      }

      public TrilhaEducacionalBuilder comImagemUrl(String imagemUrl) {
          this.imagemUrl = imagemUrl;
          return this;
      }

      public TrilhaEducacionalBuilder adicionarModulo(Modulo modulo) {
          if (modulo != null) {
              this.modulos.add(modulo);
          }
          return this;
      }

      public TrilhaEducacionalBuilder comListaDeModulos(List<Modulo> listaModulos) {
          if (listaModulos != null) {
              this.modulos = new ArrayList<>(listaModulos); // Cria uma cópia da lista
          } else {
              this.modulos = new ArrayList<>();
          }
          return this;
      }

      public TrilhaEducacional build() {
          // Validação simples: garante que o título foi fornecido
          if (this.titulo == null || this.titulo.trim().isEmpty()) {
              throw new IllegalStateException("O título da trilha é obrigatório e não pode ser vazio.");
          }
          // Chama o construtor de TrilhaEducacional que preparamos
          return new TrilhaEducacional(this.id, this.titulo, this.descricao, this.nivel,
                                       this.categoria, this.publicada, this.imagemUrl, this.modulos);
      }
  }