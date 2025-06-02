package com.galaxiaconectada.trilhas;

   import com.galaxiaconectada.core.Conteudo; // Para a lista de conteúdos
   import java.util.List;
   import java.util.ArrayList;

   // Builder para a classe Modulo.

   public class ModuloBuilder {
       // Atributos que o Modulo final terá, guardados temporariamente aqui
       private int id;
       private String titulo;
       private int ordem = 0; 
       private String descricaoBreve = ""; // Valor padrão
       private List<Conteudo> conteudos;

       /**
        * Construtor do ModuloBuilder.
        * @param id O ID do módulo.
        * @param titulo O título do módulo.
        */
       public ModuloBuilder(int id, String titulo) {
           this.id = id;
           this.titulo = titulo;
           this.conteudos = new ArrayList<>(); // Inicializa a lista de conteúdos
       }

       //Define a ordem de exibição do módulo.
       
       public ModuloBuilder comOrdem(int ordem) {
           this.ordem = ordem;
           return this; // Retorna a própria instância para chamadas fluentes
       }

       public ModuloBuilder comDescricaoBreve(String descricao) {
           this.descricaoBreve = descricao;
           return this;
       }

       public ModuloBuilder adicionarConteudo(Conteudo conteudo) {
           if (conteudo != null) {
               this.conteudos.add(conteudo);
           }
           return this;
       }

       //Define uma lista inteira de Conteudos para o módulo,
       
       public ModuloBuilder comListaDeConteudos(List<Conteudo> listaConteudos) {
           if (listaConteudos != null) {
               this.conteudos = new ArrayList<>(listaConteudos); // Cria uma nova lista baseada na fornecida
           } else {
               this.conteudos = new ArrayList<>();
           }
           return this;
       }

       public Modulo build() {
           // Validação simples: garante que o título foi fornecido
           if (this.titulo == null || this.titulo.trim().isEmpty()) {
               throw new IllegalStateException("O título do módulo é obrigatório e não pode ser vazio.");
           }
           // Chama o construtor de Modulo
           return new Modulo(this.id, this.titulo, this.ordem, this.descricaoBreve, this.conteudos);
       }
   }