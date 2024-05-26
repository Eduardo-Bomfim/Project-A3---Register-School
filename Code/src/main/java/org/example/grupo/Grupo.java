package org.example.grupo;

import org.example.entidades.aluno.Aluno;
import org.example.exception.unchecked.EIdNaoEncontradoException;
import org.example.exception.unchecked.ELimiteExcedidoException;
import org.example.sala.Sala;

import java.util.ArrayList;

public class Grupo {

    private long id;
    private String nome;
    private String turno;
    private String horarioAula;
    private int limiteAlunos;
    private ArrayList<Aluno> alunos;

    //Construtor
    public Grupo(long id, String nome, String turno, String horarioAula) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
        this.horarioAula = horarioAula;
        limiteAlunos = 5;
        alunos = new ArrayList<>();
    }

    //Getters e Setters

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(String horarioAula) {
        this.horarioAula = horarioAula;
    }

    public int getLimiteAlunos() {
        return limiteAlunos;
    }

    //Métodos

    public ArrayList<Aluno> consultarAlunosInscritos(){
        if(!alunos.isEmpty()){
            for(Aluno aluno : alunos){
                return alunos;
            }
        }else {
            throw new ArrayIndexOutOfBoundsException("Nenhum aluno encontrado.");
        }
        return null;
    }

    public void adicionarAluno(Aluno aluno){
        if (limiteAlunos < alunos.size()){
            alunos.add(aluno);
        }else {
            throw new ELimiteExcedidoException("O grupo já atingiu o limite máximo de integrantes!");
        }
    }

    public void removerAluno(int id){
        for(Aluno aluno: alunos){
            if (aluno.getId() == id){
                alunos.remove(aluno);
            }else {
                throw new EIdNaoEncontradoException("ID " + id + " não encontrado na lista.");
            }
        }
    }

}
