package org.example.unidade;

import org.example.disciplina.Disciplina;
import org.example.entidades.coordenador.Area;
import org.example.exception.unchecked.EEstadoIlegalException;
import org.example.grupo.Grupo;
import org.example.sala.Sala;

import java.util.ArrayList;

public class Unidade {

    // Atributos da classe Unidade
    private long id;
    private String nome;
    private String bairro;
    private String telefone;
    private String cnpj;
    private int limiteSala;
    private ArrayList<Sala> salas;
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Grupo> grupos;

    // Construtor da classe Unidade
    public Unidade(long id, String nome, String bairro, String telefone, String cnpj, int limiteSala) {
        this.id = id;
        this.nome = nome;
        this.bairro = bairro;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.limiteSala = limiteSala;
        salas = new ArrayList<>();
        disciplinas = new ArrayList<>();
        grupos = new ArrayList<>();
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getLimiteSala() {
        return limiteSala;
    }

    public ArrayList<Sala> getSalas() {
        return salas;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public ArrayList<Grupo> getGrupos() {
        return grupos;
    }

    // Método para adicionar uma sala
    public void adicionarSala(long id, short numero, short capacidade, short andar, String tipoSala) {
        if (limiteSala > salas.size()) {
            salas.add(new Sala(id, numero, capacidade, andar, tipoSala));
        }else {
            throw new EEstadoIlegalException("A unidade já atingiu o limite máximo de salas.");
        }
    }

    // Método para exibir uma sala específica com base no id
    public Sala exibirSalaEspecifica(long id){
        for (Sala sala : salas){
            if(sala.getId() == id){
                return sala;
            }
        }
        throw new EEstadoIlegalException("Sala não encontrada.");
    }

    // Método para adicionar uma disciplina
    public void criarDisciplina(long id, String nome, String codigo, String cargaHoraria, String turno,
                                String assuntos) {
        disciplinas.add(new Disciplina(id, nome, codigo, cargaHoraria, turno, assuntos));
    }

    // Método para remover uma disciplina com base no id
    public void removerDisciplina(long id){
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getId() == id){
                disciplinas.remove(disciplina);
            }else {
                throw new EEstadoIlegalException("Disciplina não encontrada.");
            }
        }
    }

    // Método para adicionar um grupo
    public void criarGrupos(long id, String nome, String turno, String horarioAula) {
        grupos.add(new Grupo(id, nome, turno, horarioAula));
    }

    // Método para remover um grupo com base no id
    public void removerGrupo(long id){
        for (Grupo grupo : grupos){
            if(grupo.getId() == id){
                grupos.remove(grupo);
            }else {
                throw new EEstadoIlegalException("Grupo não encontrado.");
            }
        }
    }

    // Método para exibir uma disciplina específica com base no id
    public Disciplina exibirDisciplinaEspecifica(long id){
        for (Disciplina disciplina : disciplinas){
            if(disciplina.getId() == id){
                return disciplina;
            }
        }
        throw new EEstadoIlegalException("Disciplina não encontrada.");
    }

    // Método para exibir um grupo específico com base no id
    public Grupo exibirGrupoEspecifico(long id){
        for (Grupo grupo : grupos){
            if(grupo.getId() == id){
                return grupo;
            }
        }
        throw new EEstadoIlegalException("Grupo não encontrado.");
    }

    @Override
    public String toString() {
        return "Unidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", bairro='" + bairro + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", limiteSala=" + limiteSala +
                ", salas=" + salas +
                ", disciplinas=" + disciplinas +
                ", grupos=" + grupos +
                '}';
    }
}