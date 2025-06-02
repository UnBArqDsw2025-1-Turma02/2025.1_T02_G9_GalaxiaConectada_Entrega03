package com.galaxiaconectada.observer;

import com.galaxiaconectada.trilhas.TrilhaEducacional; // Importa a classe do objeto que será observado

// Define o método de atualização que será chamado quando o Sujeito (TrilhaEducacional) notificar
public interface ObservadorTrilha {
    void notificarTrilhaPublicada(TrilhaEducacional trilhaPublicada);
}

