package org.example.entidades.aluno;

import org.example.disciplina.Disciplina;
import org.example.entidades.usuario.Usuario;
import org.example.grupo.Grupo;
import org.example.unidade.Unidade;

import java.util.ArrayList;

public class Aluno extends Usuario {

    // Variável para armazenar disciplinas matriculadas
    private ArrayList<Disciplina> disciplinasMatriculadas;

    public Aluno(long id, long registroAcademico, String nome, String email, String senha) {
        super(id, registroAcademico, nome, email, senha); // Chama o construtor da classe pai (Usuario)
        disciplinasMatriculadas = new ArrayList<>(); // Inicializa a lista de disciplinas matriculadas
    }

    public ArrayList<Disciplina> consultarDisciplinas(Unidade unidade){
        return unidade.getDisciplinas(); // Consulta as disciplinas na unidade
    }

    public void realizarMatriculaDisciplina(Disciplina disciplina){
        disciplinasMatriculadas.add(disciplina); // Adiciona uma disciplina à lista de disciplinas matriculadas
    }

    public void cancelarMatriculaDisciplina(Disciplina disciplina){
        disciplinasMatriculadas.remove(disciplina); // Remove uma disciplina da lista de disciplinas matriculadas
    }

    public ArrayList<Grupo> consultarGrupos(Unidade unidade) {
        return unidade.getGrupos(); // Consulta os grupos na unidade
    }

    public ArrayList<Disciplina> consultarDisciplinasMatriculadas() {
        return disciplinasMatriculadas; // Retorna a lista de disciplinas matriculadas
    }

    public void realizarInscricaoGrupo(Grupo grupo, Aluno aluno){
        grupo.adicionarAluno(aluno); // Adiciona o aluno em um grupo
    }

    public void cancelarInscricaoGrupo(Grupo grupo, Aluno aluno){
        grupo.removerAluno(aluno); //Remove o aluno de um grupo
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "disciplinasMatriculadas=" + disciplinasMatriculadas +
                "} " + super.toString();
    }
}
