package com.galaxiaconectada.domain.papeis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
// Placeholders para classes que serão definidas no pacote domain.forum
// import com.galaxiaconectada.domain.forum.Subforum;
// import com.galaxiaconectada.domain.forum.Postagem;
// import com.galaxiaconectada.domain.forum.Topico;

/**
 * Representa o papel de um Moderador na plataforma,
 * responsável por manter a ordem nos fóruns.
 */
public class Moderador implements PapelUsuario {

    private String nivelModeracao; // Ex: "JUNIOR", "SENIOR", "GLOBAL"
    private LocalDateTime dataInicioModeracao;

    /**
     * Construtor para o papel de Moderador.
     * @param nivelModeracao O nível de moderação.
     * @param dataInicioModeracao A data em que o usuário começou a moderar.
     */
    public Moderador(String nivelModeracao, LocalDateTime dataInicioModeracao) {
        this.nivelModeracao = nivelModeracao;
        this.dataInicioModeracao = dataInicioModeracao;
    }

    @Override
    public String getTipoPapel() {
        return "Moderador";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Moderador:");
        System.out.println("  Nível de Moderação: " + nivelModeracao);
        System.out.println("  Data Início Moderação: " + dataInicioModeracao);
    }

    /**
     * Lista os subfóruns que este moderador está designado a moderar.
     * (Placeholder: Retorna uma lista vazia de Object por enquanto)
     * @return Uma lista de Object (deverá ser List<Subforum> quando a classe Subforum for definida).
     */
    // MÉTODO CORRIGIDO ABAIXO:
    public List<Object> listarSubforumsModerados() { // Alterado para List<Object> temporariamente
        System.out.println("  [Moderador] Listando subfóruns moderados...");
        return new ArrayList<>(); // Retorna uma lista vazia
    }

    /**
     * Realiza uma ação de moderação em uma postagem.
     * (Placeholder: Parâmetro Postagem comentado até a classe ser criada)
     * @param acao A ação a ser realizada (ex: "APROVAR", "EDITAR", "REMOVER").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean moderarPostagem(/* Postagem p, */ String acao) {
        System.out.println("  [Moderador] Moderando postagem com ação: " + acao);
        return true;
    }

    /**
     * Realiza uma ação de moderação em um tópico.
     * (Placeholder: Parâmetro Topico comentado até a classe ser criada)
     * @param acao A ação a ser realizada (ex: "FIXAR", "FECHAR", "MOVER").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean moderarTopico(/* Topico t, */ String acao) {
        System.out.println("  [Moderador] Moderando tópico com ação: " + acao);
        return true;
    }

    // Getters e Setters
    public String getNivelModeracao() {
        return nivelModeracao;
    }

    public void setNivelModeracao(String nivelModeracao) {
        this.nivelModeracao = nivelModeracao;
    }

    public LocalDateTime getDataInicioModeracao() {
        return dataInicioModeracao;
    }

    public void setDataInicioModeracao(LocalDateTime dataInicioModeracao) {
        this.dataInicioModeracao = dataInicioModeracao;
    }
}