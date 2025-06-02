package com.galaxiaconectada.domain.papeis;

import com.galaxiaconectada.domain.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa o papel de um Administrador na plataforma,
 * com permissões globais e nível de acesso.
 */
public class Administrador implements PapelUsuario {

    private List<String> permissoesGlobais;
    private int nivelAcesso;

    /**
     * Construtor para o papel de Administrador.
     * @param permissoesGlobais Lista de strings representando as permissões globais.
     * @param nivelAcesso Nível numérico de acesso do administrador.
     */
    public Administrador(List<String> permissoesGlobais, int nivelAcesso) {
        this.permissoesGlobais = permissoesGlobais != null ? new ArrayList<>(permissoesGlobais) : new ArrayList<>();
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String getTipoPapel() {
        return "Administrador";
    }

    @Override
    public void exibirDetalhesDoPapel() {
        System.out.println("  Detalhes do Papel Administrador:");
        System.out.println("  Nível de Acesso: " + nivelAcesso);
        System.out.println("  Permissões Globais: " + String.join(", ", permissoesGlobais));
    }

    /**
     * Gerencia um usuário realizando uma determinada ação.
     * (Placeholder)
     * @param u O Usuário a ser gerenciado.
     * @param acao A ação a ser realizada (ex: "ATIVAR", "SUSPENDER", "DELETAR").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean gerenciarUsuario(Usuario u, String acao) {
        System.out.println("  [Admin] Gerenciando usuário '" + (u != null ? u.getNome() : "N/A") + "' com ação: " + acao);
        return true;
    }

    /**
     * Gerencia uma promoção realizando uma determinada ação.
     * (Placeholder: Parâmetro PromocaoExterna comentado até a classe ser criada)
     * @param acao A ação a ser realizada (ex: "APROVAR", "REJEITAR", "REMOVER").
     * @return true se a ação foi bem-sucedida, false caso contrário.
     */
    public boolean gerenciarPromocao(/* PromocaoExterna p, */ String acao) {
        // System.out.println("  [Admin] Gerenciando promoção '" + (p != null ? p.getNomeProduto() : "N/A") + "' com ação: " + acao);
        System.out.println("  [Admin] Gerenciando promoção com ação: " + acao);
        return true;
    }

    // Getters e Setters
    public List<String> getPermissoesGlobais() {
        return new ArrayList<>(permissoesGlobais); // Retorna uma cópia para proteger a lista interna
    }

    public void setPermissoesGlobais(List<String> permissoesGlobais) {
        this.permissoesGlobais = permissoesGlobais != null ? new ArrayList<>(permissoesGlobais) : new ArrayList<>();
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}