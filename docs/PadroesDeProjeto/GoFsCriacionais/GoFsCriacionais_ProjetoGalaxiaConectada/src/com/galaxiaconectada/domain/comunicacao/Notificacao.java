package com.galaxiaconectada.domain.comunicacao;

  import com.galaxiaconectada.prototipos.PrototipoClonavel;
  import java.time.LocalDateTime;
  import java.time.format.DateTimeFormatter;

  // Representa uma notificação do sistema para o usuário.
  
  public class Notificacao implements PrototipoClonavel, Cloneable {
      private int id; // Gerado ou definido após clonagem para uma nova notificação
      private String mensagem;
      private String tipo; // Ex: "NOVA_MENSAGEM", "CONQUISTA", "AVISO"
      private LocalDateTime dataEnvio;
      private boolean lida;
      private String link; // Link para onde a notificação direciona

      public Notificacao(int id, String tipo, String mensagemBase, String linkBase) {
          this.id = id;
          this.tipo = tipo;
          this.mensagem = mensagemBase;
          this.link = linkBase;
          this.dataEnvio = LocalDateTime.now();
          this.lida = false;
      }

      // Getters
      public int getId() { return id; }
      public String getMensagem() { return mensagem; }
      public String getTipo() { return tipo; }
      public LocalDateTime getDataEnvio() { return dataEnvio; }
      public boolean isLida() { return lida; }
      public String getLink() { return link; }

      // Setters para personalizar o clone
      public void setId(int id) { this.id = id; }
      public void setMensagem(String mensagem) { this.mensagem = mensagem; }
      public void setTipo(String tipo) { this.tipo = tipo; }
      public void setDataEnvio(LocalDateTime dataEnvio) { this.dataEnvio = dataEnvio; }
      public void setLink(String link) { this.link = link; }

      public void marcarComoLida() {
          this.lida = true;
          System.out.println("Notificação (ID: " + id + ") marcada como lida.");
      }

      @Override
      public Notificacao clonar() { // Retorna o tipo específico Notificacao
          System.out.println("Clonando Notificação tipo: " + this.tipo);
          try {
              Notificacao clone = (Notificacao) super.clone();
              return clone;
          } catch (CloneNotSupportedException e) {
              System.err.println("A clonagem da Notificação falhou: " + e.getMessage());
              return null;
          }
      }

      public void exibir() {
          DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
          System.out.println("--- Notificação (ID: " + id + ") ---");
          System.out.println("Tipo: " + tipo);
          System.out.println("Mensagem: " + mensagem);
          System.out.println("Link: " + link);
          System.out.println("Data Envio: " + (dataEnvio != null ? dataEnvio.format(formatador) : "N/A"));
          System.out.println("Lida: " + (lida ? "Sim" : "Não"));
          System.out.println("-----------------------------");
      }
  }