package com.galaxiaconectada.observer;

//Interface Subject (Sujeito Observável): define os métodos para que os Observadores possam se registrar e cancelar o registro.

public interface SujeitoTrilhaObservavel {
    void adicionarObservador(ObservadorTrilha observador);

    void removerObservador(ObservadorTrilha observador);

    void notificarObservadoresDaPublicacao();
}