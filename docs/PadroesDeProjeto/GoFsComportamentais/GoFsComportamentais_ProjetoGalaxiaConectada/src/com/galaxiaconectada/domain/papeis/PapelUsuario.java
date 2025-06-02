package com.galaxiaconectada.domain.papeis;

  public interface PapelUsuario {
      String getTipoPapel(); // Retorna uma string como "Aluno", "Instrutor"
      void exibirDetalhesDoPapel(); // Mostra informações específicas do papel
      
  }