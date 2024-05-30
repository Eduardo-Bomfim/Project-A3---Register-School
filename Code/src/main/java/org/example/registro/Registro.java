package org.example.registro;

import org.example.entidades.aluno.Aluno;
import org.example.entidades.coordenador.Coordenador;
import org.example.entidades.professor.Professor;
import org.example.entidades.usuario.Usuario;
import org.example.exception.unchecked.EEstadoIlegalException;
import org.example.exception.unchecked.EIdNaoEncontradoException;

import java.util.ArrayList;

public class Registro {

    private long id;
    private ArrayList<Usuario> usuarios;

    //Construtor
    public Registro(long id) {
        this.id = id;
        usuarios = new ArrayList<>();
    }

    //Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Método

    //Esse método vai cadastrar os usuários no sistema
    public void cadastroUsuario(Usuario usuario) {
        if (usuario != null) {
            usuarios.add(usuario);
        }
        throw new NullPointerException("As informações do usuário estão vazias.");
    }

    public void excluirUsuario(long id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                usuarios.remove(usuario);
            }
            throw new EIdNaoEncontradoException("Usuário não encontrado.");
        }
    }

    //Esse método vai retorna os Coordenadores que estão cadastrados no ArrayList<Usuario>
    public ArrayList<Coordenador> consultarCoordenadores() {
        if (!usuarios.isEmpty()) {
            ArrayList<Coordenador> coordenadores = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Coordenador) {
                    coordenadores.add((Coordenador) usuario);
                }
            }
            return coordenadores;
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    //Esse método vai retorna os Professores que estão cadastrados no ArrayList<Usuario>
    public ArrayList<Professor> consultarProfessores() {
        if (!usuarios.isEmpty()) {
            ArrayList<Professor> professores = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Professor) {
                    professores.add((Professor) usuario);
                }
            }
            return professores;
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    //Esse método vai retorna os Alunos que estão cadastrados no ArrayList<Usuario>
    public ArrayList<Aluno> consultarAlunos() {
        if (!usuarios.isEmpty()) {
            ArrayList<Aluno> alunos = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario instanceof Professor) {
                    alunos.add((Aluno) usuario);
                }
            }
            return alunos;
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    //Esse método vai retorna os Usuários que estão cadastrados no ArrayList<Usuario>
    public Usuario consultarRegistroUsuarios() {
        if (!usuarios.isEmpty()) {
            for (Usuario usuario : usuarios) {
                return usuario;
            }
        }
        throw new EEstadoIlegalException("Nenhum usuário cadastrado.");
    }

    @Override
    public String toString() {
        return "Registro{" +
                "id=" + id +
                ", usuarios=" + usuarios +
                '}';
    }
}
