package org.example.entidades.professor;

import org.example.entidades.usuario.Usuario;
import org.example.utilitarios.Valores;

import java.util.ArrayList;

public class Professor extends Usuario {

    private String titulacao;
    private Valores valores;

    public Professor(long id, long registroAcademico, String nome, String email, String senha, String titulacao) {
        super(id, registroAcademico, nome, email, senha);
        this.titulacao = titulacao;
        valores = new Valores(0, 0);
    }

    //Getters e Setters
    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    //Métodos

    public ArrayList consultarDisciplinasMinistradas() {
        return null;
    }

    public void definirValoresAulas(int horas, double valor) {
        valores.valorPorAula(horas, valor);
    }

    public Valores getValorAula() {
        return valores;
    }

    public ArrayList consultarGruposDisponiveis() {
        return null;
    }

    public ArrayList consultarAlunosInscritos() {
        return null;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "titulacao='" + titulacao + '\'' +
                "} " + super.toString();
    }
}
