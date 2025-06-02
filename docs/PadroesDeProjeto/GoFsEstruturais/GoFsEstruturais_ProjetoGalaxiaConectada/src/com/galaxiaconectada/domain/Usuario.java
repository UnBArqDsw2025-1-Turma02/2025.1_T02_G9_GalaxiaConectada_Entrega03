package com.galaxiaconectada.domain;

import com.galaxiaconectada.domain.papeis.PapelUsuario;
import java.time.LocalDateTime; // Para o método editarPerfil
import java.util.Map;


public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senhaHash;
    private LocalDateTime dataCadastro;
    private PapelUsuario papelPrincipal; // NOVO: Atributo para guardar o papel do usuário

    // Construtor
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senhaHash = gerarHashDaSenha(senha);
        this.dataCadastro = LocalDateTime.now();
        this.papelPrincipal = null; // Inicialmente sem papel específico
    }

    public boolean login(String emailFornecido, String senhaFornecida) {
        System.out.println("Usuário " + this.nome + " tentando login.");
        if (this.email.equals(emailFornecido) && verificarSenha(senhaFornecida, this.senhaHash)) {
            System.out.println("Login bem-sucedido para " + this.nome);
            return true;
        }
        System.out.println("Falha no login para " + emailFornecido);
        return false;
    }

    public void logout() {
        System.out.println("Usuário " + this.nome + " fez logout.");
    }

    public void editarPerfil(Map<String, Object> dados) {
        System.out.println("Perfil do usuário " + this.nome + " sendo editado.");
        if (dados.containsKey("nome")) {
            this.setNome((String) dados.get("nome"));
        }
        if (dados.containsKey("email")) {
            this.setEmail((String) dados.get("email"));
        }
        System.out.println("Perfil atualizado: Nome=" + this.nome + ", Email=" + this.email);
    }

    /*
    // MÉTODOS TEMPORARIAMENTE COMENTADOS ATÉ CRIARMOS AS CLASSES DEPENDENTES
    public MensagemPrivada enviarMensagemPrivada(Usuario destinatario, String texto) {
        System.out.println(this.nome + " enviando mensagem para " + destinatario.getNome() + ": " + texto);
        // return new MensagemPrivada(this, destinatario, texto); 
        return null;
    }

    public Topico criarTopicoForum(Subforum subforum, String titulo, String postInicial) {
        System.out.println(this.nome + " criando tópico '" + titulo + "' no subforum " + subforum.getNome());
        // return new Topico(this, subforum, titulo, postInicial); 
        return null;
    }

    public Postagem postarEmTopico(Topico topico, String texto) {
        System.out.println(this.nome + " postando no tópico '" + topico.getTitulo() + "': " + texto);
        // return new Postagem(this, topico, texto); 
        return null;
    }

    public Comentario comentar(Comentavel item, String texto) {
        System.out.println(this.nome + " comentando em item: " + texto);
        // return new Comentario(this, item, texto); 
        return null;
    }
    */

    private String gerarHashDaSenha(String senha) {
        return "hashed_" + senha;
    }

    private boolean verificarSenha(String senhaFornecida, String senhaHashArmazenada) {
        return senhaHashArmazenada.equals("hashed_" + senhaFornecida);
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getSenhaHash() { return senhaHash; }
    public LocalDateTime getDataCadastro() { return dataCadastro; }

    // NOVO: Métodos para papel
    public PapelUsuario getPapelPrincipal() {
        return papelPrincipal;
    }

    public void setPapelPrincipal(PapelUsuario papelPrincipal) {
        this.papelPrincipal = papelPrincipal;
        if (papelPrincipal != null) {
            System.out.println("[INFO] Usuário " + this.nome + " agora tem o papel de: " + papelPrincipal.getTipoPapel());
        } else {
            System.out.println("[INFO] Papel do usuário " + this.nome + " foi removido.");
        }
    }

    public void exibirInformacoesCompletas() {
        System.out.println("--- Informações do Usuário ---");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Email: " + email);
        System.out.println("Data de Cadastro: " + dataCadastro);
        if (papelPrincipal != null) {
            System.out.println("Papel Principal: " + papelPrincipal.getTipoPapel());
            papelPrincipal.exibirDetalhesDoPapel(); // Método que vamos adicionar na interface PapelUsuario
        } else {
            System.out.println("Papel Principal: Não definido");
        }
        System.out.println("-----------------------------");
    }
}