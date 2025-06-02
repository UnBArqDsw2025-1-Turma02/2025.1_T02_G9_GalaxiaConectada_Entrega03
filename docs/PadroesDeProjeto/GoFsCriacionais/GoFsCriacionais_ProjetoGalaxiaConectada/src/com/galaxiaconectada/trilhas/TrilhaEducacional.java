package com.galaxiaconectada.trilhas;

  import java.util.ArrayList;
  import java.util.List;
  // Se precisar, importe Usuario aqui se métodos como inscreverUsuario forem implementados agora
  // import com.galaxiaconectada.domain.Usuario;
  // import com.galaxiaconectada.domain.ProgressoUsuarioTrilha; // Placeholder

  /**
   * Representa uma Trilha Educacional na plataforma.
   * Uma trilha é um conjunto ordenado de Módulos sobre um tema específico.
   */
  public class TrilhaEducacional {
      private int id;
      private String titulo;
      private String descricao;
      private String nivel; // Ex: "Iniciante", "Intermediário", "Avançado"
      private String categoria; // Ex: "Astronomia Básica", "Cosmologia", "Astrofísica"
      private boolean publicada;
      private String imagemUrl;
      private List<Modulo> modulos; // Lista de módulos que compõem a trilha

      // Construtor será usado pelo TrilhaEducacionalBuilder
      TrilhaEducacional(int id, String titulo, String descricao, String nivel,
                          String categoria, boolean publicada, String imagemUrl, List<Modulo> modulos) {
          this.id = id;
          this.titulo = titulo;
          this.descricao = descricao;
          this.nivel = nivel;
          this.categoria = categoria;
          this.publicada = publicada;
          this.imagemUrl = imagemUrl;
          this.modulos = modulos != null ? new ArrayList<>(modulos) : new ArrayList<>();
      }

      // Getters
      public int getId() { return id; }
      public String getTitulo() { return titulo; }
      public String getDescricao() { return descricao; }
      public String getNivel() { return nivel; }
      public String getCategoria() { return categoria; }
      public boolean isPublicada() { return publicada; }
      public String getImagemUrl() { return imagemUrl; }
      public List<Modulo> getModulos() { return new ArrayList<>(modulos); } // Retorna cópia

      // Métodos da sua tabela (implementações placeholder ou básicas)
      public float calcularProgressoMedio() {
          // Lógica placeholder
          System.out.println("[TrilhaEducacional] Calculando progresso médio para: " + titulo);
          return 50.0f; // Exemplo
      }

      public boolean publicarTrilha() {
          this.publicada = true;
          System.out.println("[TrilhaEducacional] Trilha '" + titulo + "' publicada com sucesso!");
          return true;
      }

      // public ProgressoUsuarioTrilha inscreverUsuario(Usuario u) {
      //     System.out.println("[TrilhaEducacional] Usuário " + u.getNome() + " inscrito na trilha: " + titulo);
      //     return null;
      // }

      public void exibirDetalhesCompletos() {
          System.out.println("==============================================");
          System.out.println("DETALHES DA TRILHA EDUCACIONAL");
          System.out.println("==============================================");
          System.out.println("ID: " + id);
          System.out.println("Título: " + titulo);
          System.out.println("Descrição: " + descricao);
          System.out.println("Nível: " + nivel);
          System.out.println("Categoria: " + categoria);
          System.out.println("Publicada: " + (publicada ? "Sim" : "Não"));
          System.out.println("URL da Imagem: " + imagemUrl);
          System.out.println("----------------------------------------------");
          if (modulos.isEmpty()) {
              System.out.println("Esta trilha ainda não possui módulos.");
          } else {
              System.out.println("Módulos da Trilha (" + modulos.size() + "):");
              for (Modulo m : modulos) {
                  m.exibirDetalhes(); // Chama o exibirDetalhes de cada módulo
              }
          }
          System.out.println("==============================================");
      }


      @Override
      public String toString() {
          return "TrilhaEducacional [id=" + id + ", titulo=" + titulo + ", modulos=" + modulos.size() + "]";
      }
  }
