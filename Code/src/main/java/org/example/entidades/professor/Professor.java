package org.example.entidades.professor;

import org.example.entidades.usuario.Usuario;

import java.util.List;

public class Professor extends Usuario {

    private String titulacao;

    public Professor(long id, long registroAcademico, String nome, String email, String senha, String titulacao) {
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


}
