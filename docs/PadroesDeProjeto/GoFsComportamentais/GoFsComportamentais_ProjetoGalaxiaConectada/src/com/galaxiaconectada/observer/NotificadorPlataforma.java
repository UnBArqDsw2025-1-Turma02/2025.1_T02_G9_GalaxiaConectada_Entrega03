package com.galaxiaconectada.observer;

import com.galaxiaconectada.trilhas.TrilhaEducacional;
import java.time.format.DateTimeFormatter;

public class NotificadorPlataforma implements ObservadorTrilha {
    private String nomeDoNotificador;

    public NotificadorPlataforma(String nomeDoNotificador) {
        this.nomeDoNotificador = nomeDoNotificador;
    }

    @Override
    public void notificarTrilhaPublicada(TrilhaEducacional trilhaPublicada) {
        System.out.println("\n--- [OBSERVADOR: " + nomeDoNotificador + "] ---");
        System.out.println("📢 ALERTA GERAL! Nova Trilha Educacional disponível na plataforma!");
        System.out.println("  Título da Trilha: '" + trilhaPublicada.getTitulo() + "' (ID: " + trilhaPublicada.getId() + ")");
        System.out.println("  Categoria: " + trilhaPublicada.getCategoria() + " | Nível: " + trilhaPublicada.getNivel());
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
        System.out.println("  Trilha publicada em: " + (trilhaPublicada.getDataPublicacao() != null ? trilhaPublicada.getDataPublicacao().format(formatador) : "Data não informada pela trilha"));
        System.out.println("  Acesse e comece a aprender agora mesmo!");
        System.out.println("--- Fim da Notificação da Plataforma ---");
    }
}

