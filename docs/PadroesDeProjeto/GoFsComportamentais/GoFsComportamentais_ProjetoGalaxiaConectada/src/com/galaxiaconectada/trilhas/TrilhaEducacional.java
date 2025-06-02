package com.galaxiaconectada.trilhas;

// Imports para o padrão Composite
import com.galaxiaconectada.observer.ObservadorTrilha;
import com.galaxiaconectada.observer.SujeitoTrilhaObservavel; // Usado no construtor de Conteudo, que Modulo usa
import com.galaxiaconectada.trilhas.componentes.ComponenteTrilha;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;



public class TrilhaEducacional implements ComponenteTrilha, SujeitoTrilhaObservavel {
    private int id;
    private String titulo;
    private String descricao;
    private String nivel; // Ex: "Iniciante", "Intermediário", "Avançado"
    private String categoria; // Ex: "Astronomia Básica", "Cosmologia", "Astrofísica"
    private boolean publicada;
    private String imagemUrl;
    private LocalDateTime dataPublicacao; 
    //A lista agora armazena ComponenteTrilha, que serão os Modulos
    private List<ComponenteTrilha> componentesFilhos;

    // Para o Padrão Observer: lista de Observadores interessados nesta trilha
    private List<ObservadorTrilha> observadores;

    TrilhaEducacional(int id, String titulo, String descricao, String nivel,
                          String categoria, boolean publicadaInicial, String imagemUrl, List<ComponenteTrilha> componentesIniciais) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.nivel = nivel;
        this.categoria = categoria;
        this.publicada = publicadaInicial;
        this.imagemUrl = imagemUrl;
        this.componentesFilhos = componentesIniciais != null ? new ArrayList<>(componentesIniciais) : new ArrayList<>();
        this.observadores = new ArrayList<>(); // Inicializa a lista de observadores
        if (this.publicada) {
            this.dataPublicacao = LocalDateTime.now(); 
        }
    }

    // Implementação de getTitulo() da interface ComponenteTrilha
    @Override
    public String getTitulo() {
        return this.titulo;
    }


    //Exibe as informações desta Trilha Educacional e, recursivamente, de todos os seus componentes filhos (Módulos)

    @Override
    public void exibirInformacoes(String indentacao) {
        System.out.println(indentacao + "Trilha Educacional (ID: " + id + "): " + titulo);
        System.out.println(indentacao + "  Nível: " + nivel + ", Categoria: " + categoria);
        System.out.println(indentacao + "  Descrição: " + descricao);
        System.out.println(indentacao + "  Publicada: " + (publicada ? "Sim" : "Não"));
        if (publicada && dataPublicacao != null) {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm:ss");
            System.out.println(indentacao + "  Data de Publicação: " + dataPublicacao.format(formatador));
        }
        System.out.println(indentacao + "  Imagem: " + (imagemUrl != null && !imagemUrl.isEmpty() ? imagemUrl : "N/A"));

        if (componentesFilhos.isEmpty()) {
            System.out.println(indentacao + "  -> Esta trilha ainda não possui módulos.");
        } else {
            System.out.println(indentacao + "  Módulos da Trilha (" + componentesFilhos.size() + "):");
            for (ComponenteTrilha componente : componentesFilhos) {
                // Chama o exibirInformacoes de cada filho (que será um Modulo) com uma indentação adicional.
                componente.exibirInformacoes(indentacao + "    ");
            }
        }
    }

     // Implementação dos métodos de gerenciamento de filhos da interface ComponenteTrilha
    @Override
    public void adicionar(ComponenteTrilha componente) {
        // Uma Trilha Educacional, no nosso design, só contém Módulos como filhos diretos.
        if (componente instanceof Modulo) {
            this.componentesFilhos.add(componente);
        } else {
            System.out.println("[ERRO na Trilha '" + titulo + "'] Tentativa de adicionar um tipo de componente inválido. Apenas Módulos são permitidos.");
        }
    }

    @Override
    public void remover(ComponenteTrilha componente) {
        this.componentesFilhos.remove(componente);
    }

    @Override
    public ComponenteTrilha getFilho(int index) {
        if (index >= 0 && index < componentesFilhos.size()) {
            return componentesFilhos.get(index);
        }
        return null;
    }

   
    public boolean publicarTrilha() {
        if (!this.publicada) {
            this.publicada = true;
            this.dataPublicacao = LocalDateTime.now(); // Registra o momento exato da publicação
            System.out.println("\n[TrilhaEducacional] Trilha '" + titulo + "' (ID: " + id + ") foi PUBLICADA AGORA!");
            notificarObservadoresDaPublicacao(); // Dispara a notificação para os observadores
            return true;
        } else {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            System.out.println("[TrilhaEducacional] Trilha '" + titulo + "' já está publicada desde " +
                               (dataPublicacao != null ? dataPublicacao.format(formatador) : "data desconhecida") + ".");
            return false;
        }
    }

    public float calcularProgressoMedio() {
        System.out.println("[TrilhaEducacional] Calculando progresso médio para: " + titulo);
        return 50.0f; // Exemplo
    }

    @Override
    public synchronized void adicionarObservador(ObservadorTrilha observador) {
        if (observador != null && !observadores.contains(observador)) {
            this.observadores.add(observador);
            System.out.println("[OBSERVER EM '" + titulo + "'] Observador '" + observador.getClass().getSimpleName() + "' foi ADICIONADO.");
        }
    }

    @Override
    public synchronized void removerObservador(ObservadorTrilha observador) {
        if (observador != null) {
            boolean removido = this.observadores.remove(observador);
            if (removido) {
                 System.out.println("[OBSERVER EM '" + titulo + "'] Observador '" + observador.getClass().getSimpleName() + "' foi REMOVIDO.");
            }
        }
    }

    @Override
    public void notificarObservadoresDaPublicacao() {
        // se um observador tentar se remover durante a notificação.
        List<ObservadorTrilha> observadoresParaNotificar = new ArrayList<>(this.observadores);

        if (observadoresParaNotificar.isEmpty()){
            System.out.println("[OBSERVER EM '" + titulo + "'] Nenhum observador registrado para notificar sobre a publicação.");
            return;
        }
        System.out.println("[OBSERVER EM '" + titulo + "'] Notificando " + observadoresParaNotificar.size() + " observador(es) sobre a publicação...");
        for (ObservadorTrilha observador : observadoresParaNotificar) {
            observador.notificarTrilhaPublicada(this); // Passa a própria trilha (this) como contexto
        }
    }

    // Getters existentes
    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getNivel() { return nivel; }
    public String getCategoria() { return categoria; }
    public boolean isPublicada() { return publicada; }
    public String getImagemUrl() { return imagemUrl; }
    public LocalDateTime getDataPublicacao() { return dataPublicacao; } 


    public List<ComponenteTrilha> getComponentesFilhos() {
        return new ArrayList<>(componentesFilhos);
    }

    @Override
    public String toString() {
        return "TrilhaEducacional [id=" + id + ", titulo=" + titulo + ", publicada=" + publicada + ", módulos=" + componentesFilhos.size() + "]";
    }
}