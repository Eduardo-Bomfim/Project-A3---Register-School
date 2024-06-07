package org.example.entidades.professor;

import org.example.disciplina.Disciplina;
import org.example.entidades.coordenador.Area;
import org.example.entidades.usuario.Usuario;
import org.example.grupo.Grupo;
import org.example.unidade.Unidade;
import org.example.utilitarios.Valores;

import java.util.ArrayList;

public class Professor extends Usuario {

    // Atributos específicos da classe Professor
    private Area area; // Área de atuação do professor
    private Valores valores; // Valores relacionados às aulas do professor

    // Construtor da classe Professor
    public Professor(long id, long registroAcademico, String nome, String email, String senha, Area area) {
        super(id, registroAcademico, nome, email, senha); // Chama o construtor da classe pai (Usuario)
        this.area = area; // Define a área de atuação
        valores = new Valores(0, 0); // Inicializa o objeto Valores
    }

    // Getters e Setters para os atributos
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    // Métodos específicos da classe Professor
    public ArrayList<Disciplina> consultarDisciplinasMinistradas(Unidade unidade) {
        // Método para consultar disciplinas ministradas (ainda não implementado)
        return null;
    }

    public void definirValoresAulas(int horas, double valor) {
        valores.valorPorAula(horas, valor); // Define os valores das aulas
    }

    public Valores getValorAula() {
        return valores; // Retorna os valores das aulas
    }

    public ArrayList<Grupo> consultarGrupos(Unidade unidade) {
        return unidade.getGrupos(); // Consulta os grupos na unidade
    }

    public ArrayList consultarAlunosInscritos(Grupo grupo) {
        return grupo.consultarAlunosInscritos(); // Consulta os alunos inscritos no grupo
    }

    @Override
    public String toString() {
        return "Professor{" +
                "titulacao='" + area + '\'' +
                "} " + super.toString();
    }
}
