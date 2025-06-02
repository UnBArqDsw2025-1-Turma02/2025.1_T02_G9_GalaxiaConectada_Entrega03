package com.galaxiaconectada.prototipos;

  import com.galaxiaconectada.prototipos.PrototipoClonavel;
  import com.galaxiaconectada.domain.Usuario; 

  // Representa uma conquista (prêmio, medalha, badge) que um usuário pode ganhar.
  public class Conquista implements PrototipoClonavel, Cloneable { // Implementa as duas

      private int id;
      private String titulo;
      private String descricao;
      private String iconeUrl;
      private int pontosXPConcedidos;

      public Conquista(int id, String titulo, String descricao, String iconeUrl, int pontosXPConcedidos) {
          this.id = id;
          this.titulo = titulo;
          this.descricao = descricao;
          this.iconeUrl = iconeUrl;
          this.pontosXPConcedidos = pontosXPConcedidos;
      }

      // Getters
      public int getId() { return id; }
      public String getTitulo() { return titulo; }
      public String getDescricao() { return descricao; }
      public String getIconeUrl() { return iconeUrl; }
      public int getPontosXPConcedidos() { return pontosXPConcedidos; }

      public void setId(int id) { this.id = id; } 
      public void setTitulo(String titulo) { this.titulo = titulo; }
      public void setDescricao(String descricao) { this.descricao = descricao; }
      public void setIconeUrl(String iconeUrl) { this.iconeUrl = iconeUrl; }
      public void setPontosXPConcedidos(int pontosXPConcedidos) { this.pontosXPConcedidos = pontosXPConcedidos; }


      public boolean desbloquearPara(/*Usuario u*/) { 
          System.out.println("Conquista '" + titulo + "' desbloqueada para o usuário!");
          // Lógica para criar uma UsuarioConquista.
          return true;
      }

      @Override
      public Conquista clonar() { // Retorna o tipo específico Conquista
          System.out.println("Clonando Conquista: " + this.titulo);
          try {
              // Chama o clone() da classe Object, que faz a cópia superficial
              return (Conquista) super.clone();
          } catch (CloneNotSupportedException e) {
              System.err.println("A clonagem da Conquista falhou: " + e.getMessage());
              return null; 
          }
      }

      public void exibirDetalhes() {
          System.out.println("--- Detalhes da Conquista (ID: " + id + ") ---");
          System.out.println("Título: " + titulo);
          System.out.println("Descrição: " + descricao);
          System.out.println("Ícone: " + iconeUrl);
          System.out.println("XP Concedido: " + pontosXPConcedidos);
          System.out.println("------------------------------------");
      }
  }