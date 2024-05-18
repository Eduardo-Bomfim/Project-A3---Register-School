package org.example.entidades.professor;

import org.example.entidades.Usuario;

import java.util.List;

public class Professor extends Usuario {

    private String titulacao;

    public Professor(int id, int registroAcademico, String nome, String email, String senha, String titulacao) {
        super(id, registroAcademico, nome, email, senha);
        this.titulacao = titulacao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public List consultarDisciplinasMinistradas(){
        return null;
    }

    public void definirValoresAulas(){

    }

    public List consultarGruposDisponiveis(){
        return null;
    }

    public List consultarAlunosInscritos(){
        return null;
    }

    @Override
    public String toString() {
    	return "Id: " + getId() + "\nCódigo: " + getRegistroAcademico() + "\nNome: " + getNome() + "\nEmail: " + getEmail() + "\nSenha: " + getSenha() + "\nTitulação: " + getTitulacao();
    }
}
