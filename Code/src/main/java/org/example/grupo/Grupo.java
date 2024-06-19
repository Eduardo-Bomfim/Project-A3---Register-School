package org.example.grupo;

import org.example.entidades.aluno.Aluno;
import org.example.exception.unchecked.EIdNaoEncontradoException;
import org.example.exception.unchecked.ELimiteExcedidoException;
import org.example.sala.Sala;

import java.util.ArrayList;

public class Grupo {

    // Atributos da classe Grupo
    private long id;
    private String nome;
    private String turno;
    private String horarioAula;
    private int limiteAlunos;
    private ArrayList<Aluno> alunos;

    // Construtor da classe Grupo
    public Grupo(long id, String nome, String turno, String horarioAula) {
        this.id = id;
        this.nome = nome;
        this.turno = turno;
        this.horarioAula = horarioAula;
        limiteAlunos = 5;
        alunos = new ArrayList<>();
    }

    // Métodos getters e setters
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

    // Método para consultar a lista de alunos inscritos
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

    // Método para adicionar um aluno ao grupo
    public void adicionarAluno(Aluno aluno){
        if (limiteAlunos < alunos.size()){
            alunos.add(aluno);
        }else {
            throw new ELimiteExcedidoException("O grupo já atingiu o limite máximo de integrantes!");
        }
    }

    // Método para remover um aluno do grupo
    public void removerAluno(Aluno aluno){
        alunos.remove(aluno);
    }

    // Método para reservar uma sala
    public void reservaSala(Sala sala){
        sala.reservar();
    }

    // Método para cancelar a reserva de uma sala
    public void cancelarReservaSala(Sala sala){
        sala.cancelarReserva();
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", turno='" + turno + '\'' +
                ", horarioAula='" + horarioAula + '\'' +
                ", limiteAlunos=" + limiteAlunos +
                ", alunos=" + alunos +
                '}';
    }
}