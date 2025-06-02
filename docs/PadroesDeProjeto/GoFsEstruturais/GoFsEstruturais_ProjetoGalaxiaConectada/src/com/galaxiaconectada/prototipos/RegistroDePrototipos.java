package com.galaxiaconectada.prototipos;

  import java.util.HashMap;
  import java.util.Map;

  /**
   * Gerencia um conjunto de instâncias de protótipos que podem ser clonados.
   * Funciona como um registro central para acessar e clonar objetos modelo.
   */
  public class RegistroDePrototipos {

      // Um Map para armazenar os protótipos. A chave é uma String (um nome para o protótipo)
      private Map<String, PrototipoClonavel> prototiposRegistrados = new HashMap<>();

      public void adicionarPrototipo(String chave, PrototipoClonavel prototipo) {
          if (chave != null && !chave.isEmpty() && prototipo != null) {
              prototiposRegistrados.put(chave.toUpperCase(), prototipo); // Guarda a chave em maiúsculas por padrão
              System.out.println("[REGISTRO] Prototipo adicionado com a chave: " + chave.toUpperCase());
          } else {
              System.out.println("[REGISTRO ERRO] Chave ou protótipo inválido para adicionar.");
          }
      }

      public PrototipoClonavel getPrototipoClonado(String chave) {
          if (chave == null || chave.isEmpty()) {
              System.out.println("[REGISTRO ERRO] Chave inválida para buscar protótipo.");
              return null;
          }

          PrototipoClonavel prototipoOriginal = prototiposRegistrados.get(chave.toUpperCase());

          if (prototipoOriginal != null) {
              System.out.println("[REGISTRO] Clonando protótipo para a chave: " + chave.toUpperCase());
              // Chama o método clonar() do protótipo específico
              return (PrototipoClonavel) prototipoOriginal.clonar();
          } else {
              System.out.println("[REGISTRO ERRO] Nenhum protótipo encontrado para a chave: " + chave.toUpperCase());
              return null;
          }
      }

      /**
       * Mostra as chaves de todos os protótipos registrados.
       * Útil para o usuário saber quais protótipos estão disponíveis.
       */
      public void listarPrototiposDisponiveis() {
          if (prototiposRegistrados.isEmpty()) {
              System.out.println("[REGISTRO] Nenhum protótipo registrado no momento.");
              return;
          }
          System.out.println("\n--- Protótipos Disponíveis para Clonagem ---");
          for (String chave : prototiposRegistrados.keySet()) {
              PrototipoClonavel p = prototiposRegistrados.get(chave);
              System.out.println("- Chave: \"" + chave + "\" (Tipo: " + p.getClass().getSimpleName() + ")");
          }
          System.out.println("--------------------------------------------");
      }
  }