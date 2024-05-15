package org.example.disciplina;

import org.example.entidades.professor.Professor;

import java.util.ArrayList;

class Disciplina {

    private long id;
    private String nome, codigo, cargaHoraria, turno, assuntos;
    private ArrayList <Professor> professores;

    public Disciplina(long id, String nome, String codigo, String cargaHoraria, String turno, String assuntos) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
        this.turno = turno;
        this.assuntos = assuntos;
        professores = new ArrayList<>();
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(String assuntos) {
        this.assuntos = assuntos;
    }

    public void adicionarProfessor(Professor professor) {
        professores.add(professor);
    }

    public void removerProfessor(long registroAcademico){
        for(Professor professor : professores){
           if (professor.getRegistroAcademico() == registroAcademico){
               professores.remove(professor);
           }else{
               throw new RuntimeException("Não existe professor com esse registro academico!");
           }
        }
    }

    public ArrayList consultarProfessoresDisponiveis(){
       if(professores.isEmpty()){
           throw new RuntimeException("Não tem professores disponíveis!");
       }
        for(Professor professor : professores){
            return professores;
        }
        return null;
    }
}
