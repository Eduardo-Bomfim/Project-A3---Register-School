package org.example.entidades.coordenador;

import org.example.disciplina.Disciplina;
import org.example.entidades.usuario.Usuario;
import org.example.grupo.Grupo;
import org.example.sala.Sala;
import org.example.unidade.Unidade;

import java.util.ArrayList;

public class Coordenador extends Usuario {

    private Area areaAtuacao; // Área de atuação do coordenador

    public Coordenador(long id, long registroAcademico, String nome, String email, String senha, Area areaAtuacao) {
        super(id, registroAcademico, nome, email, senha); // Chama o construtor da classe pai (Usuario)
        this.areaAtuacao = areaAtuacao; // Define a área de atuação
    }

    public Area getAreaCoordenacao() {
        return areaAtuacao; // Retorna a área de atuação
    }

    public void setAreaCoordenacao(Area area) {
        this.areaAtuacao = area; // Define a área de atuação
    }

    // Métodos específicos da classe Coordenador
    public ArrayList<Disciplina> exibirDisciplinas(Unidade unidade){
        return unidade.getDisciplinas(); // Exibe as disciplinas da unidade
    }

    public ArrayList<Sala> exibirSalas(Unidade unidade){
        return unidade.getSalas(); // Exibe as salas da unidade
    }

    public ArrayList exibirGrupos(Unidade unidade){
        return unidade.getGrupos(); // Exibe os grupos da unidade
    }

    public void gerarRelatório(Unidade unidade){
        // Gera um relatório com informações da unidade
        System.out.println(exibirGrupos(unidade));
        System.out.println(exibirSalas(unidade));
        System.out.println(exibirDisciplinas(unidade));
    }

    public void criarSala(Unidade unidade, long id, short numero, short capacidade, short andar, String tipoSala){
        unidade.adicionarSala(id, numero, capacidade, andar, tipoSala); // Cria uma sala na unidade
    }

    public void criarGrupo(Unidade unidade, long id, String nome, String turno, String horarioAula){
        unidade.criarGrupos(id, nome, turno, horarioAula); // Cria um grupo na unidade
    }

    public void criarDisciplinas(Unidade unidade, long id, String nome, String codigo, String cargaHoraria,
                                 String turno, String assuntos, Area areaDisciplina){
        if (this.areaAtuacao == areaDisciplina){
            unidade.criarDisciplina(id, nome, codigo, cargaHoraria, turno, assuntos, areaDisciplina); // Cria uma disciplina na unidade
        }
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "areaCoordenacao='" + areaAtuacao + '\'' +
                "} " + super.toString();
    }
}
