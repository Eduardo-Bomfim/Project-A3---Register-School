package org.example.entidades.usuario;

import org.example.exception.unchecked.EAutenticacaoInvalidaException;
import org.example.exception.unchecked.EValorInvalidoException;

// Classe abstrata Usuario
public abstract class Usuario {

    // Variáveis
    private long registroAcademico, id;
    private String nome, email, senha;

    // Construtor
    public Usuario(long id, long registroAcademico, String nome, String email, String senha) {
        if (id < 0) {
            throw new EValorInvalidoException("O valor do id não pode ser menor que 0."); // Verifica se o id é válido
        }
        if (registroAcademico < 0) {
            throw new EValorInvalidoException("O valor do registro acadêmico não pode ser menor que 0."); // Verifica se o registro acadêmico é válido
        }
        this.id = id;
        this.registroAcademico = registroAcademico;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Métodos Gets e Setters
    public long getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(long registroAcademico) {
        this.registroAcademico = registroAcademico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Métodos da classe
    public void editarDados(String email, String senha) {
        this.email = email;
        this.senha = senha; // Edita os dados do usuário
    }

    public boolean autenticar(String email, String senha) {
        if (!this.email.equalsIgnoreCase(email)) {
            throw new EAutenticacaoInvalidaException("Email incorreto."); // Verifica se o email está correto
        }
        if (!this.senha.equals(senha)) {
            throw new EAutenticacaoInvalidaException("Senha incorreta."); // Verifica se a senha está correta
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "registroAcademico=" + registroAcademico +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
